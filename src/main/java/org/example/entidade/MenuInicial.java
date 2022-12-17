package org.example.entidade;

public enum MenuInicial {

    SAIR(0, "Sair"),
    CADASTRAR_CLIENTE(1, "Cadastrar Cliente"),
    CADASTRAR_PET(2, "Cadastrar Pet"),
    AGENDAR(3, "Agendar Horário"),
    IMPRIMIR_AGENDA(4, "Imprimir Agenda Diária"),
    CONTA(5 ,"Fechar Conta Cliente ");

    private int opcao;

    private String label;

    private MenuInicial(int opcao, String label){
        this.opcao = opcao;
        this.label = label;
    }

    public static MenuInicial fromOpcao(int opcao) {
        for(MenuInicial opcaoSelecionada: MenuInicial.values()){
            if(opcaoSelecionada.getOpcao() == opcao){
                return opcaoSelecionada;
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
