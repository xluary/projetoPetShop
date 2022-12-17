package org.example.entidade;

import java.math.BigDecimal;

public class ProcedimentoBanho extends Procedimentos {

    public ProcedimentoBanho() {
        this.valor = BigDecimal.valueOf(30);
        this.tipo = TipoProcedimento.BANHO.getLabel();
    }
}
