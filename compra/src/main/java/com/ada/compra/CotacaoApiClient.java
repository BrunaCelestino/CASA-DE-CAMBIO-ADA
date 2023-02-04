package com.ada.compra;

import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

public class CotacaoApiClient {

    private String URI = "http://localhost:8083/cotacao/";
    private WebClient client = WebClient.create();

    public CotacaoDTO getCotacao(String currency) {
        URI = URI + currency;
        Mono<CotacaoDTO>cotacao =
                client.get().uri(URI).retrieve().bodyToMono(CotacaoDTO.class);
        return  cotacao.block();
    }
}
