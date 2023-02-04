package com.ada.compra;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/compra")
public class OrdemCompraController {

    private final OrdemCompraService ordemCompraService;

    public OrdemCompraController(OrdemCompraService ordemCompraService) {
        this.ordemCompraService = ordemCompraService;
    }

    @PostMapping
    public ResponseEntity<OrdemCompra> obterCotacao(@RequestBody OrdemCompra ordemCompra) {
       return ResponseEntity.ok(ordemCompraService.obterCotacao(ordemCompra));
    }

}
