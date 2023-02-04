package com.ada.cadastro;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cadastro")
public class ClienteController {
    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @PostMapping
    public Cliente salvar(@RequestBody Cliente cliente) {
       return clienteService.salvar(cliente);
    }

    @GetMapping("/{cpf}")
    public Cliente buscarPorCpf(@PathVariable String cpf){
        return clienteService.buscaPorCpf(cpf);
    }

}
