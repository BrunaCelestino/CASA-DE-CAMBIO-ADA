package com.ada.cadastro;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;


import java.net.URI;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/cadastro")
public class ClienteController {
    private final ClienteService clienteService;

    @PostMapping
    public ResponseEntity<Void> salvar(@RequestBody ClienteDTO cliente) {
        if (cliente == null || cliente.getCpf() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Não foi informado um cadastro válido");
        }
        String clearCpf = cliente.getCpf().replaceAll("[\\.-]", "");

        if (clearCpf.isBlank()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Não foi informado um cadastro com CPF válido");
        }
        if (cliente.getNome() == null || cliente.getNome().isBlank()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Não foi informado um cadastro com Nome válido");
        }

        try {
            clienteService.salvar(cliente.toEntity());
        } catch (IllegalArgumentException e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Já existe um cadastro com o CPF informado");
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Ocorreu um erro desconhecido");
        }
        return ResponseEntity.created(URI.create("/cadastro/" + clearCpf)).build();
    }

    @GetMapping("/{cpf}")
    public ResponseEntity<ClienteDTO> buscarPorCpf(@PathVariable String cpf) {
        if (cpf == null || cpf.isBlank()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Não foi informado um CPF!");
        }
        String clearCpf = cpf.replaceAll("[\\.-]", "");
        Optional<Cliente> encontrado = clienteService.buscaPorCpf(clearCpf);
        if (encontrado.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Não foi localizado um cadastro com o CPF informado");
        }
        Cliente entity = encontrado.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Não foi localizado um cadastro com o CPF informado"));
        return ResponseEntity.ok(ClienteDTO.of(entity));
    }

}
