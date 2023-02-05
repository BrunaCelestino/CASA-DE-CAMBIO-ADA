package com.ada.compra;

import org.springframework.http.HttpStatus;
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
        OrdemCompra compra = ordemCompraService.obterCotacao(ordemCompra);
        return new ResponseEntity<>(compra, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<OrdemCompra> encontrarPorId(@PathVariable Long id) {
       OrdemCompra compra = ordemCompraService.findById(id);
       if(compra == null) {
           ResponseEntity.notFound();
       }
        return ResponseEntity.ok(compra);
    }

}
