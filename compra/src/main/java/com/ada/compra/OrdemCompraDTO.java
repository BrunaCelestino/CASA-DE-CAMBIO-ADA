package com.ada.compra;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
@Data
public class OrdemCompraDTO {

    private Long idCompra;
    private Long idCliente;
    private String cpfCliente;
    private LocalDate dataSolicitacao;
    private TipoMoeda tipoMoedaEstrangeira;
    private Double valorMoedaEstrangeira;
    private Double valorCotação;
    private Double valorTotalOperação;
    private String numeroAgenciaDeRetirada;

    public static OrdemCompraDTO of(OrdemCompra ordemCompra) {
        OrdemCompraDTO dto = new OrdemCompraDTO();
        dto.setIdCompra(ordemCompra.getIdCompra());
        dto.setIdCliente(ordemCompra.getIdCliente());
        dto.setCpfCliente(ordemCompra.getCpfCliente());
        dto.setDataSolicitacao(ordemCompra.getDataSolicitacao());
        dto.setTipoMoedaEstrangeira(ordemCompra.getTipoMoedaEstrangeira());
        dto.setValorCotação(ordemCompra.getValorCotação());
        dto.setValorTotalOperação(ordemCompra.getValorTotalOperação());
        dto.setNumeroAgenciaDeRetirada(ordemCompra.getNumeroAgenciaDeRetirada());
    }

    public OrdemCompraDTO toEntity (){
        OrdemCompra entity = new OrdemCompra();
        entity.setIdCompra(idCompra);
        entity.getIdCliente(idCliente);
        entity.getCpfCliente(cpfCliente);
        entity.setDataSolicitacao(dataSolicitacao);
        entity.setTipoMoedaEstrangeira(tipoMoedaEstrangeira);
        entity.setValorCotação(valorCotação);
        entity.setValorTotalOperação(valorTotalOperação);
        entity.setNumeroAgenciaDeRetirada(numeroAgenciaDeRetirada);
        return entity;
    }

}


