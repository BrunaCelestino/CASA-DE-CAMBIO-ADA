package com.ada.compra;

import com.ada.cadastro.ClienteDTO;
import org.aspectj.weaver.ast.Instanceof;
import org.springframework.remoting.RemoteAccessException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Optional;

public class CadastroApiClient {

    private ClienteDTO clienteDTO;
    private String URI = "http://localhost:8081/cadastro/{cpf}";
    private WebClient client = WebClient.create();





}
