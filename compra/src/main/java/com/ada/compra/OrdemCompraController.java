package com.ada.compra;

import com.ada.exceptions.CadastroInvalidoException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/compra")
public class OrdemCompraController {

    private final OrdemCompraService ordemCompraService;

    @PostMapping
    public ResponseEntity<OrdemCompra> criarOrdemDeCompra(@RequestBody OrdemCompra ordemCompra) throws CadastroInvalidoException {
        String clearCpf = ordemCompra.getCpfCliente().replaceAll("[\\.-]", "");

        if (clearCpf.isBlank()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Não foi informado um CPF válido");
        }
        OrdemCompra compra = ordemCompraService.salvar(ordemCompra);
        return new ResponseEntity<>(compra, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<OrdemCompraDTO> encontrarPorId(@PathVariable Long id) {
        if (id == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "ID não informado!");
        }
        OrdemCompra entity = ordemCompraService.getById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Não encontramos ordem de compra com ID informado."));
        return ResponseEntity.ok(OrdemCompraDTO.of(entity));
    }




}
