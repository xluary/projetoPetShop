package org.example.entidade;

import java.math.BigDecimal;

public class ProcedimentoTosa extends Procedimentos {
    public ProcedimentoTosa() {

        this.valor = BigDecimal.valueOf(20);
        this.tipo = TipoProcedimento.TOSA.getLabel();
    }
}
