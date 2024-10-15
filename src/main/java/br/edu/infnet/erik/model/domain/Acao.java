package br.edu.infnet.erik.model.domain;

import java.math.BigDecimal;

public class Acao extends Titulo {
    private BigDecimal baseCusto;

    public BigDecimal getBaseCusto() {
        return baseCusto;
    }

    public void setBaseCusto(BigDecimal baseCusto) {
        this.baseCusto = baseCusto;
    }
}
