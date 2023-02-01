package com.ada.cadastro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Collections;

@RestController
@SpringBootApplication
public class CadastroApplication {

	public static void main(String[] args) {
		SpringApplication.run(CadastroApplication.class, args);
	}

	@RequestMapping("/v1/cadastro")
	@ResponseBody
	String home(){
		WebClient clientCompra = WebClient.builder()
				.baseUrl("http://localhost:8082/v1/compra")
				.defaultCookie("cookieKey", "cookieValue")
				.defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
				.defaultUriVariables(Collections.singletonMap("url", "http://localhost:8082/v1/compra"))
				.build();

		Mono<String> bodyCompra = clientCompra.get().retrieve().bodyToMono(String.class);
		String compraMsg = bodyCompra.block();

		WebClient clientCotacao = WebClient.builder()
				.baseUrl("http://localhost:8083/v1/cotacao")
				.defaultCookie("cookieKey", "cookieValue")
				.defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
				.defaultUriVariables(Collections.singletonMap("url", "http://localhost:8083/v1/cotacao"))
				.build();

		Mono<String> bodyCotacao = clientCotacao.get().retrieve().bodyToMono(String.class);
		String cotacaoMsg = bodyCotacao.block();

		return "Olá, sou a API DE CADASTRO e estou consumindo a: "  + compraMsg + " e a: " + cotacaoMsg;
	}
}
