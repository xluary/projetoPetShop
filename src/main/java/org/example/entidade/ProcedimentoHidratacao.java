package org.example.entidade;

import java.math.BigDecimal;

public class ProcedimentoHidratacao extends Procedimento {

    public ProcedimentoHidratacao() {

        this.valor = BigDecimal.valueOf(80);
        this.tipo = TipoProcedimento.HIDRATACAO.getLabel();
    }
}
