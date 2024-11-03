package br.edu.infnet.erik.model.domain;

import jakarta.persistence.Table;
import jakarta.persistence.Entity;

import java.math.BigDecimal;

@Entity
@Table(name = "TAcao")
public class Acao extends Titulo {
    private BigDecimal baseCusto;

    public BigDecimal getBaseCusto() {
        return baseCusto;
    }

    public void setBaseCusto(BigDecimal baseCusto) {
        this.baseCusto = baseCusto;
    }
}
