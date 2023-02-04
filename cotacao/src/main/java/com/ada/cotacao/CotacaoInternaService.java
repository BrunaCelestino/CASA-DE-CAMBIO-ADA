package com.ada.cotacao;

import com.ada.cotacao.CotacaoEconomiaApiClient;
import com.ada.cotacao.CotacaoEconomiaApiDTO;
import com.ada.cotacao.CotacaoInterna;

import org.springframework.stereotype.Service;


import java.util.Optional;

import static com.ada.cotacao.utils.Util.formatDateTime;

@Service
public class CotacaoInternaService {

    public Optional<CotacaoInterna> obterCotacao(String moeda) {
        CotacaoEconomiaApiClient cotacaoEconomia = new CotacaoEconomiaApiClient();
        CotacaoEconomiaApiDTO cotacaoApi = cotacaoEconomia.getCotacaoEconomia(moeda).get(0);

        CotacaoInterna cotacao = new CotacaoInterna(cotacaoApi.getCode(),
                cotacaoApi.getName(),
                cotacaoApi.getHigh(),
                cotacaoApi.getLow(),
                formatDateTime(cotacaoApi.getCreate_date()));

        return Optional.of(cotacao);

    }

}
