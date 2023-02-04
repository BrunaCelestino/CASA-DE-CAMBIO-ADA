package com.ada.cadastro;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

@Data
@Entity
public class Cliente {

    @Id
    @GeneratedValue
    private Long id;
    private String nome;
    private String cpf;
    private LocalDate dataNascimento;
    private String estadoCivil;
    private String sexo;

}
