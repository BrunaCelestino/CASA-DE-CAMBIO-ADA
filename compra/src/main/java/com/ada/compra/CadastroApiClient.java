package com.ada.compra;

import org.springframework.web.reactive.function.client.WebClient;

public class CadastroApiClient {

    private String URI = "http://localhost:8081/cadastro/";
    private WebClient client = WebClient.create();
}
