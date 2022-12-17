package org.example.fabrica;

import org.example.entidade.*;

public class FabricaProcedimento {

    private FabricaProcedimento(){}
    public static Procedimento getInstance(TipoProcedimento opcao){
        switch (opcao){
            case BANHO:
                return new ProcedimentoBanho();
            case TOSA:
               return new ProcedimentoTosa();
            case HIDRATACAO:
                return new ProcedimentoHidratacao();
        }
        return null;
    }
}
