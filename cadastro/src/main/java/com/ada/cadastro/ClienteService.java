package com.ada.cadastro;

import org.springframework.stereotype.Service;

@Service
public class ClienteService {
    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public Cliente salvar(Cliente cliente){
        Cliente clienteEncontrado = buscaPorCpf(cliente.getCpf());
        if (clienteEncontrado == null){
            throw new IllegalArgumentException("CPF já esta cadastrado em outro cliente");
        }
        return clienteRepository.save(cliente);
    }

    public Cliente buscaPorCpf(String cpf){
        return clienteRepository.findByCpf(cpf);
    }


}
