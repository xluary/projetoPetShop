package org.example.entidade;

public enum TipoPet {


    CACHORRO(1, "Cachorro"),
    GATO(2, "Gato");

    private int opcao;

    private String label;

    TipoPet(int opcao, String label){
        this.opcao = opcao;
        this.label = label;
    }

    public static TipoPet fromOpcao(int opcao) {
        for(TipoPet tipo: TipoPet.values()){
            if(tipo.getOpcao() == opcao){
                return tipo;
            }
        }
        throw new RuntimeException("Opção Inválida!");
    }
    public int getOpcao() {
        return opcao;
    }

    public String getLabel() {
        return label;
    }

}
