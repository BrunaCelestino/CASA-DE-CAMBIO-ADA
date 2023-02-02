package com.ada.cotacao;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class CotacaoEconomiaApiDTO {
    private String code;
    private String codein;
    private String name;
    private Double high;
    private Double low;
    private Double varBid;
    private Double pctChange;
    private Double bid;
    private Double ask;
    private String timestamp;
    private String create_date;

    public CotacaoEconomiaApiDTO() {
    }

    public CotacaoEconomiaApiDTO(String code, String codein, String name, Double high, Double low, Double varBid, Double pctChange, Double bid, Double ask, String timestamp, String create_date) {
        this.code = code;
        this.codein = codein;
        this.name = name;
        this.high = high;
        this.low = low;
        this.varBid = varBid;
        this.pctChange = pctChange;
        this.bid = bid;
        this.ask = ask;
        this.timestamp = timestamp;
        this.create_date = create_date;
    }

    public static CotacaoEconomiaApiDTO of(CotacaoEconomiaApi cotacao) {
        CotacaoEconomiaApiDTO dto = new CotacaoEconomiaApiDTO(
                cotacao.getCode(),
                cotacao.getCodein(),
                cotacao.getName(),
                cotacao.getHigh(),
                cotacao.getLow(),
                cotacao.getVarBid(),
                cotacao.getPctChange(),
                cotacao.getBid(),
                cotacao.getAsk(),
                cotacao.getTimestamp(),
                cotacao.getCreate_date());
        return dto;
    }

    public CotacaoEconomiaApi toEntity() {
        CotacaoEconomiaApi entity = new CotacaoEconomiaApi();
        entity.setCode(code);
        entity.setCodein(codein);
        entity.setName(name);
        entity.setHigh(high);
        entity.setLow(low);
        entity.setVarBid(varBid);
        entity.setPctChange(pctChange);
        entity.setBid(bid);
        entity.setAsk(ask);
        entity.setTimestamp(timestamp);
        entity.setCreate_date(create_date);

        return entity;
    }
}
