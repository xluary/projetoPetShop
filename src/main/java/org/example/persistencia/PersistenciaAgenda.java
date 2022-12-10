package org.example.persistencia;

import org.example.entidade.Agendamento;
import org.example.entidade.Cliente;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

public class PersistenciaAgenda {

    private static ArrayList<Agendamento> agenda;
    private static PersistenciaAgenda instanceAgenda;

    public static PersistenciaAgenda getInstance(){
        if(Objects.isNull(instanceAgenda)){
            instanceAgenda = new PersistenciaAgenda();
        }
        return instanceAgenda;
    }

    private PersistenciaAgenda(){
        agenda = new ArrayList<>();
    }

    public void addHorario(Agendamento agendamento){
        if(Objects.isNull(agenda)){
            agenda = new ArrayList<>();
        }
        agenda.add(agendamento);
    }

    public static void imprimirAgendamentoDiario(LocalDate data){
        List<Agendamento> tempAgenda = horariosDia(data);
        for(Agendamento compromisso : tempAgenda){
            System.out.printf("Cliente: %s \t Horário: %s \n",compromisso.getCliente().getNome(), compromisso.getHorario().getLabel());
        }
    }

    public static List<Agendamento> horariosDia(LocalDate data){
        return agenda.stream().filter(agenda -> agenda.getData().equals(data)).collect(Collectors.toList());
    }

}
