package org.example.tela;

import org.example.entidade.Agendamento;
import org.example.entidade.Cliente;
import org.example.entidade.Horarios;
import org.example.persistencia.PersistenciaAgenda;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class TelaAgendamento {

    public static void agendarHorario (Scanner scanner, Cliente cliente){
        PersistenciaAgenda agenda = PersistenciaAgenda.getInstance();

        System.out.println("Informe a data desejada (dd/mm/aaaa): ");
        LocalDate dataAgendamento= LocalDate.parse(scanner.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        List<Horarios> horariosAgendadosDia = PersistenciaAgenda.horariosDia(dataAgendamento).stream().map(Agendamento::getHorario).collect(Collectors.toList());
        System.out.println("Informe o horario desejado: ");

        for (Horarios horarios : Horarios.values()){
            if(horariosAgendadosDia.contains(horarios)){
                System.out.printf("Opção (%d) - Horário indisponível \n", horarios.getOpcao());
            } else{
                System.out.printf("Opção (%d) - %s \n", horarios.getOpcao(),horarios.getLabel());
            }

        }
        Horarios horarios = Horarios.fromOpcao(scanner.nextInt());

        Agendamento agendamento = new Agendamento(cliente, dataAgendamento, horarios);
        agenda.addHorario(agendamento);
    }
}
