package org.example.entidade;

import java.math.BigDecimal;

public class ProcedimentoTosa extends Procedimento {
    public ProcedimentoTosa() {

        this.valor = BigDecimal.valueOf(20);
        this.tipo = TipoProcedimento.TOSA.getLabel();
    }
}
