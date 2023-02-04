package com.ada.cotacao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@SpringBootApplication
public class CotacaoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CotacaoApplication.class, args);
	}

	@RequestMapping("/v1/cotacao")
	@ResponseBody
	List<CotacaoEconomiaApiDTO> home(){
		CotacaoEconomiaApiClient cotacaoEconomia = new CotacaoEconomiaApiClient();
		return cotacaoEconomia.getCotacaoEconomia("USD");
	}
}
