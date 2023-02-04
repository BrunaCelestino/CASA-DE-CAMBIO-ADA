package com.ada.compra;
import org.springframework.stereotype.Service;
import java.time.LocalDate;

@Service
public class OrdemCompraService {

    public OrdemCompra obterCotacao(OrdemCompra ordemCompra) {
        CotacaoApiClient cotacaoApiClient = new CotacaoApiClient();

        // Obtendo a Cotação da api de Cotação
        CotacaoDTO cotacao = cotacaoApiClient.getCotacao(ordemCompra.getTipoMoedaEstrangeira().toString());

        // Colocando o valor obtido no atributo
        ordemCompra.setValorCotação(cotacao.getCotacaoAlta());

        // Calculando o valor total da operação
        ordemCompra.setValorTotalOperação(cotacao.getCotacaoAlta() * ordemCompra.getValorMoedaEstrangeira());

        // Colocando a data do dia
        ordemCompra.setDataSolicitacao(LocalDate.now());

        return ordemCompra;
    }

}
