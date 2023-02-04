package com.ada.compra;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CotacaoDTO {

    private String tipoMoeda;
    private String nomeMoeda;
    private Double cotacaoAlta;
    private Double cotacaoBaixa;
    private LocalDateTime dataConsulta;

    public CotacaoDTO() {
    }

    public CotacaoDTO(String tipoMoeda, String nomeMoeda, Double cotacaoAlta, Double cotacaoBaixa, LocalDateTime dataConsulta) {
        this.tipoMoeda = tipoMoeda;
        this.nomeMoeda = nomeMoeda;
        this.cotacaoAlta = cotacaoAlta;
        this.cotacaoBaixa = cotacaoBaixa;
        this.dataConsulta = dataConsulta;
    }
}
