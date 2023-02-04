package com.ada.cotacao;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@RestController
@RequestMapping("/cotacao")
public class CotacaoInternaController {

    private final CotacaoInternaService cotacaoInternaService;

    public CotacaoInternaController(CotacaoInternaService cotacaoInternaService) {
        this.cotacaoInternaService = cotacaoInternaService;
    }

    @GetMapping("/{moeda}")
    public ResponseEntity<CotacaoInterna> obterCotacao(@PathVariable String moeda) {
        if (!(moeda.equals("USD") || moeda.equals("EUR"))) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Moeda informada não é válida!");
        }

    Optional<CotacaoInterna> cotacao = cotacaoInternaService.obterCotacao(moeda);
        cotacao.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cotação não encontrada!"));
        CotacaoInterna response = cotacao.get();


        return ResponseEntity.ok(response);
    }
}