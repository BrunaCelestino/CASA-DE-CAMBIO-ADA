package com.ada.compra;

import org.springframework.web.reactive.function.client.WebClient;

public class CotacaoApiClient {

    private String URI = "http://localhost:8083/v1/cotacao";
    private WebClient client = WebClient.create();
}
