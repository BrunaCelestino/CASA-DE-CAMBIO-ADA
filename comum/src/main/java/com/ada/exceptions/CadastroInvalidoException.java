package com.ada.exceptions;

public class CadastroInvalidoException extends Exception{
    private final String motivo;

    public CadastroInvalidoException(String motivo) {
        super("Cadastro inválido. Motivo: " + motivo);
        this.motivo = motivo;
    }
}
