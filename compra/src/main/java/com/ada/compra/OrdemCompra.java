package com.ada.compra;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;
@Entity
public class OrdemCompra {

   @ID
   @GenerateValue
   private Long idCompra;

   private Long idCliente;

   private String cpfCliente;

   private Localdate dataSolicitacao;

   private String tipoMoedaEstrangeira;

   private Double valorMoedaEstrangeira;

   private Double valorCotação;

   private Double valorTotalOperação;

   private String numeroAgenciaDeRetirada;


    public Long getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(Long idCompra) {
        this.idCompra = idCompra;
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public String getCpfCliente() {
        return cpfCliente;
    }

    public void setCpfCliente(String cpfCliente) {
        this.cpfCliente = cpfCliente;
    }

    public Localdate getDataSolicitacao() {
        return dataSolicitacao;
    }

    public void setDataSolicitacao(Localdate dataSolicitacao) {
        this.dataSolicitacao = dataSolicitacao;
    }

    public String getTipoMoedaEstrangeira() {
        return tipoMoedaEstrangeira;
    }

    public void setTipoMoedaEstrangeira(String tipoMoedaEstrangeira) {
        this.tipoMoedaEstrangeira = tipoMoedaEstrangeira;
    }

    public Double getValorMoedaEstrangeira() {
        return valorMoedaEstrangeira;
    }

    public void setValorMoedaEstrangeira(Double valorMoedaEstrangeira) {
        this.valorMoedaEstrangeira = valorMoedaEstrangeira;
    }

    public Double getValorCotação() {
        return valorCotação;
    }

    public void setValorCotação(Double valorCotação) {
        this.valorCotação = valorCotação;
    }

    public Double getValorTotalOperação() {
        return valorTotalOperação;
    }

    public void setValorTotalOperação(Double valorTotalOperação) {
        this.valorTotalOperação = valorTotalOperação;
    }

    public String getNumeroAgenciaDeRetirada() {
        return numeroAgenciaDeRetirada;
    }

    public void setNumeroAgenciaDeRetirada(String numeroAgenciaDeRetirada) {
        this.numeroAgenciaDeRetirada = numeroAgenciaDeRetirada;
    }
}
