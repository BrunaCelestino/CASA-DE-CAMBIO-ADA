package com.ada.compra;

import lombok.Data;

import java.time.LocalDate;

@Data
public class CadastroDTO {

    private Long id;
    private String nome;
    private String cpf;
    private LocalDate dataNascimento;
    private String estadoCivil;
    private String sexo;

    public CadastroDTO() {
    }

    public CadastroDTO(Long id, String nome, String cpf, LocalDate dataNascimento, String estadoCivil, String sexo) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.estadoCivil = estadoCivil;
        this.sexo = sexo;
    }
}
