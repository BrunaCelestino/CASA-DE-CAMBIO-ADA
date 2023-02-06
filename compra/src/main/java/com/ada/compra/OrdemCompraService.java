package com.ada.compra;
import com.ada.exceptions.CadastroInvalidoException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Optional;


@RequiredArgsConstructor
@Service
public class OrdemCompraService {


    private final CrudRepository<OrdemCompra, Long> repository;

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

        CadastroApiClient cadastroApiClient = new CadastroApiClient();
        String clearCpf = entity.getCpfCliente().replaceAll("[\\.-]", "");
        entity.setCpfCliente(clearCpf);
        CadastroDTO cadastro = cadastroApiClient.getCadastro((entity.getCpfCliente()));
        try {
            if (Objects.isNull(cadastro)) {
                throw new CadastroInvalidoException("Cadastro não localizado");
            }
            entity = obterCotacao(entity);
            entity.setIdCliente(cadastro.getId());


        } catch (RestClientException e) {
            throw new CadastroInvalidoException("Api de Cadastro não disponível");
        }
        return repository.save(entity);
    }


}



