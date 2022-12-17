package org.example.entidade;

public enum TipoProcedimento {

    BANHO(1, "Banho"),
    TOSA(2, "Tosa"),
    HIDRATACAO(3, "Hidratação");

    private int opcao;

    private String label;
    public static final int quantidadeProcedimentos = TipoProcedimento.values().length;

    private TipoProcedimento(int opcao, String label){
        this.opcao = opcao;
        this.label = label;
    }

    public static TipoProcedimento fromOpcao(int opcao) {
        for(TipoProcedimento tipo: TipoProcedimento.values()){
            if(tipo.getOpcao() == opcao){
                return tipo;
            }
        }
        throw new RuntimeException("Opção Inválida!");
    }
    public int getOpcao() {
        return opcao;
    }

    public void setOpcao(int opcao) {
        this.opcao = opcao;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
