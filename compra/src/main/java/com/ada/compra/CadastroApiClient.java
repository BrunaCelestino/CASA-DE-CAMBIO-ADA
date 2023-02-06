package com.ada.compra;

import lombok.RequiredArgsConstructor;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class CadastroApiClient {

    private String URI = "http://localhost:8081/cadastro/";
    private WebClient client = WebClient.create();

    public CadastroDTO getCadastro(String cpf) {
        URI = URI + cpf;
        Mono<CadastroDTO> cadastro =
                client.get().uri(URI).retrieve().bodyToMono(CadastroDTO.class);
        return  cadastro.block();
    }
}
