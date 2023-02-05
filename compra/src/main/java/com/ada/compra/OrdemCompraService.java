package com.ada.compra;
import org.springframework.stereotype.Service;
import java.time.LocalDate;

@Service
public class OrdemCompraService {

    private final OrdemCompraRepository ordemCompraRepository;

    public OrdemCompraService(OrdemCompraRepository ordemCompraRepository) {
        this.ordemCompraRepository = ordemCompraRepository;
    }
    public OrdemCompra obterCotacao(OrdemCompra ordemCompra) {
        CotacaoApiClient cotacaoApiClient = new CotacaoApiClient();
        CadastroApiClient cliente = new CadastroApiClient();

        // Obtendo a Cotação da api de Cotação
        CotacaoDTO cotacao = cotacaoApiClient.getCotacao(ordemCompra.getTipoMoedaEstrangeira().toString());

        // Obtendo a Cadastro da api de Cadastro
        CadastroDTO cadastro = cliente.getCadastro(ordemCompra.getCpfCliente());

        // Colocando o valor obtido no atributo
        ordemCompra.setValorCotação(cotacao.getCotacaoAlta());

        // Calculando o valor total da operação
        ordemCompra.setValorTotalOperação(cotacao.getCotacaoAlta() * ordemCompra.getValorMoedaEstrangeira());

        // Colocando a data do dia
        ordemCompra.setDataSolicitacao(LocalDate.now());

        // Colocando o id do cliente
        ordemCompra.setIdCliente(cadastro.getId());


        return ordemCompraRepository.save(ordemCompra);
    }

    public OrdemCompra findById(Long id) {

        return ordemCompraRepository.findById(id).orElseThrow(null);
    }


}
