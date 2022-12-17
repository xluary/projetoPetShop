package org.example.fabrica;

import org.example.entidade.MenuInicial;
import org.example.tela.*;

public class TelaFabrica {

    public static Tela getInstance(MenuInicial opcao) {
        switch (opcao) {
            case CADASTRAR_CLIENTE:
                return new TelaCadastroCliente();
            case CADASTRAR_PET:
                return new TelaCadastroPets();
            case AGENDAR:
                return new TelaAgendamento();
            case IMPRIMIR_AGENDA:
                return new TelaObterAgendaDiaria();
            case CONTA:
                return new TelaContaCliente();
            case SAIR:
                return new TelaDespedida();
        }
        System.out.println("Opção inválida");
        return new TelaDespedida();
    }
}
