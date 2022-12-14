package org.example.entidade;

import java.math.BigDecimal;

public abstract class Procedimento {
    BigDecimal valor;
    String tipo;

    public Procedimento() {}

    public String getTipo() {
        return tipo;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }
}
