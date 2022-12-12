package org.example.entidade;

public enum Horarios {
    // de 8 as 12 de 13 as 18
    OITO(1, "08:00 - 09:00"),
    NOVE(2, "09:00 - 10:00"),
    DEZ(3, "10:00 - 11:00"),
    ONZE(4, "11:00 - 12:00"),
    UMA(5, "13:00 - 14:00"),
    DUAS(6, "14:00 - 15:00"),
    TRES (7, "15:00 - 16:00"),
    QUATRO(8, "16:00 - 17:00"),
    CINCO(9, "17:00 - 18:00");

    private int opcao;

    private String label;
    public static final int quantidadeHorarios = Horarios.values().length;

    private Horarios(int opcao, String label){
        this.opcao = opcao;
        this.label = label;
    }

    public static Horarios fromOpcao(int opcao) {
        for(Horarios horarios: Horarios.values()){
            if(horarios.getOpcao() == opcao){
                return horarios;
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
