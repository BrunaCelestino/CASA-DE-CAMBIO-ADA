package com.ada.cotacao;

import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.stream.Collectors;

public class CotacaoEconomiaApiClient {

    private String URI = "https://economia.awesomeapi.com.br/";
    private WebClient client = WebClient.create();


    public List<CotacaoEconomiaApiDTO> getCotacaoEconomia(String currency) {
        URI = URI + currency;
        Flux<CotacaoEconomiaApiDTO> cotacaoFlux =
                client.get().uri(URI).retrieve().bodyToFlux(CotacaoEconomiaApiDTO.class);

        return  cotacaoFlux
                .collect(Collectors.toList())
                .share().block();

    }
}
