package org.example.entidade;

import java.math.BigDecimal;

public abstract class Procedimentos {
    BigDecimal valor;
    String tipo;

    public Procedimentos() {
        this.valor = valor;
        this.tipo = tipo;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public String getTipo() {
        return tipo;
    }

}
