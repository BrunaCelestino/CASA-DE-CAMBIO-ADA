package com.ada.compra;

public class OrdemCompra {

//    Após efetuar o cadastro, o cliente pode registrar a ordem de compra, que consiste em informar seu cpf,
//    o tipo de moeda (USD ou EUR),
//    o valor em moeda estrangeira e o número da agência (4 dígitos) que ocorrerá a retirada.
}

//Ao final de uma requisição bem sucedida, deverá ser retornado um request body similiar ao abaixo:
//
//        Response 201
//
//        {
//        "id_compra": 1,
//        "id_cliente": 1,
//        "cpf_cliente": "43488428095",
//        "dataSolicitacao": "2021-08-27T16:11:23.866",
//        "tipo_moeda": "EUR",
//        "valor_moeda_estrangeira": 100.0,
//        "valor_cotacao": 6.5857,
//        "valor_total_operacao": 658.57,
//        "numero_agencia_retirada": "7057"
//        }