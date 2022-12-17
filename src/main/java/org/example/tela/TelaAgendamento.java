package org.example.tela;

import org.example.entidade.*;
import org.example.fabrica.FabricaProcedimento;
import org.example.persistencia.PersistenciaAgenda;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class TelaAgendamento implements Tela{

    public void executar(Scanner scanner) {

        Cliente cliente = TelaRecuperarCliente.recuperarCliente(scanner);
        Pets pet = TelaRecuperarPet.recuperarPet(scanner, cliente);
        PersistenciaAgenda agenda = PersistenciaAgenda.getInstance();

        System.out.println("Informe o procedimento a ser realizado: ");
        for (TipoProcedimento procedimento : TipoProcedimento.values()) {
            System.out.printf("Opção (%d) - %s \n", procedimento.getOpcao(), procedimento.getLabel());
        }
        Procedimento procedimento = FabricaProcedimento.getInstance(TipoProcedimento.fromOpcao(scanner.nextInt()));

        System.out.println("Informe a data desejada (dd/mm/aaaa): ");
        LocalDate dataAgendamento = LocalDate.parse(scanner.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        List<Horarios> horariosAgendadosDia = PersistenciaAgenda.horariosDia(dataAgendamento).stream().map(Agendamento::getHorario).collect(Collectors.toList());
        System.out.println("Informe o horario desejado: ");


        int valida = 0;
        do {
            for (Horarios horarios : Horarios.values()) {
                if (horariosAgendadosDia.contains(horarios)) {
                    System.out.printf("Opção (%d) - Horário indisponível \n", horarios.getOpcao());
                } else {
                    System.out.printf("Opção (%d) - %s \n", horarios.getOpcao(), horarios.getLabel());
                }
            }

            if(horariosAgendadosDia.size() == Horarios.quantidadeHorarios){
                System.out.printf("\nTodos os horários para o dia %s estão preenchidos, selecione outra data (dd/mm/aaaa): ", dataAgendamento.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
                dataAgendamento = LocalDate.parse(scanner.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                horariosAgendadosDia = PersistenciaAgenda.horariosDia(dataAgendamento).stream().map(Agendamento::getHorario).collect(Collectors.toList());
            } else {

                Horarios opcao = Horarios.fromOpcao(scanner.nextInt());

                if (horariosAgendadosDia.contains(opcao)) {
                    System.out.println("Horário indisponível, por favor selecione outro horário");
                } else {
                    Agendamento agendamento = new Agendamento(cliente, dataAgendamento, opcao, pet, procedimento);
                    agenda.addHorario(agendamento);
                    System.out.println("Agendamento realizado!");
                    valida = 1;
                }
            }
        } while (valida == 0);
    }

}
