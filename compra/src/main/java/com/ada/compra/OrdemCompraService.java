package com.ada.compra;
import com.ada.exceptions.CadastroInvalidoException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;

import java.time.LocalDate;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class OrdemCompraService {

    private final CrudRepository<OrdemCompra, Long> repository;
    private final CadastroApiClient cadastroApiClient;


    public Optional<OrdemCompra> getById (Long id){
        return repository.findById(id);
    }
    public OrdemCompra obterCotacao(OrdemCompra ordemCompra) {
        CotacaoApiClient cotacaoApiClient = new CotacaoApiClient();

        CotacaoDTO cotacao = cotacaoApiClient.getCotacao(ordemCompra.getTipoMoedaEstrangeira().toString());
        ordemCompra.setValorCotação(cotacao.getCotacaoAlta());
        ordemCompra.setValorTotalOperação(cotacao.getCotacaoAlta() * ordemCompra.getValorMoedaEstrangeira());
        ordemCompra.setDataSolicitacao(LocalDate.now());

        return ordemCompra;
    }

    public OrdemCompra salvar (OrdemCompra entity) throws CadastroInvalidoException {
        try {
            if (cadastroApiClient. ((entity.getCpfCliente()))) {
                throw new CadastroInvalidoException("Cadastro não localizado");
                }
            }catch (RestClientException e){
                throw new CadastroInvalidoException("Api de Cadastro não disponível");
            }
    }


}
