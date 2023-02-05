package com.ada.cadastro;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
@RequiredArgsConstructor
@Service
public class ClienteService {
    private final ClienteRepository clienteRepository;


    public void salvar(Cliente cliente){
        Optional<Cliente> clienteEncontrado = buscaPorCpf(cliente.getCpf());
        if (clienteEncontrado.isPresent()){
            throw new IllegalArgumentException("CPF já esta cadastrado em outro cliente");
        }
        String clearCpf = cliente.getCpf().replaceAll("[\\.-]", "");
        cliente.setCpf(clearCpf);
        clienteRepository.save(cliente);
    }

    public Optional<Cliente> buscaPorCpf(String cpf){
        return clienteRepository.findByCpf(cpf);
    }


}
