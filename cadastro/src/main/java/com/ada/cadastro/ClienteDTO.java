package com.ada.cadastro;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ClienteDTO {

    private Long id;
    private String nome;
    private String cpf;
    private LocalDate dataNascimento;
    private String estadoCivil;
    private String sexo;

    public static ClienteDTO of(Cliente cliente) {
        ClienteDTO dto = new ClienteDTO();
        dto.setId(cliente.getId());
        dto.setNome(cliente.getNome());
        dto.setCpf(cliente.getCpf());
        dto.setDataNascimento(cliente.getDataNascimento());
        dto.setSexo(cliente.getSexo());
        dto.setEstadoCivil(cliente.getEstadoCivil());
        return dto;
    }

    public Cliente toEntity() {
        Cliente entity = new Cliente();
        entity.setId(id);
        entity.setNome(nome);
        entity.setCpf(cpf);
        entity.setDataNascimento(dataNascimento);
        entity.setSexo(sexo);
        entity.setEstadoCivil(estadoCivil);
        return entity;
    }
}
