package com.ada.compra;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;


@Entity
@Data
public class OrdemCompra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCompra;
    private Long idCliente;
    private String cpfCliente;
    private LocalDate dataSolicitacao;
    private TipoMoeda tipoMoedaEstrangeira;
    private Double valorMoedaEstrangeira;
    private Double valorCotação;
    private Double valorTotalOperação;
    private String numeroAgenciaDeRetirada;

}