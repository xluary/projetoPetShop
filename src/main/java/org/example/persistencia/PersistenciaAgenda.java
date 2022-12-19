package org.example.persistencia;

import org.example.entidade.Agendamento;
import org.example.entidade.Cliente;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
        if(tempAgenda.isEmpty()){
            System.out.println("Não há horários agendados o dia " + data.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        } else {
            for(Agendamento compromisso : tempAgenda){
                System.out.printf("Cliente: %s \t Pet: %s \t Horário: %s  \t Procedimento: %s \n" ,compromisso.getCliente().getNome(), compromisso.getPet().getNome(), compromisso.getHorario().getLabel(),compromisso.getProcedimento().getTipo());
            }
        }

    }
    public static List<Agendamento> buscarContasAbertas() {
        List<Agendamento> tempAgenda = new ArrayList<>();
        int i=0;
        if (Objects.isNull(agenda)) {
            throw new RuntimeException("Não achamos contas deste cliente");
        }
        for (Agendamento tempagenda : agenda) {
            if (!tempagenda.getContaFechada()) {
                tempAgenda.add(tempagenda);
            }
        }
        return tempAgenda;
    }
    public static void imprimirAgendamentoCliente(Cliente cliente){
        List<Agendamento> tempAgenda = buscarContasAbertas();
        BigDecimal ContaTotal = BigDecimal.valueOf(0);

        if(tempAgenda.isEmpty()){
            System.out.println("Não há agendamentos");
        } else {
            for(Agendamento conta : tempAgenda){
                System.out.printf("Cliente: %s \t Pet: %s \t Horário: %s  \t Procedimento: %s \n Valor: R$ %s\n" ,conta.getCliente().getNome(), conta.getPet().getNome(), conta.getHorario().getLabel(),conta.getProcedimento().getTipo(), conta.getProcedimento().getValor());
                ContaTotal=ContaTotal.add(conta.getProcedimento().getValor());
            }
        }
        System.out.printf("Valor total: %s\n", ContaTotal);

    }

    public static List<Agendamento> horariosDia(LocalDate data){
        return agenda.stream().filter(agenda -> agenda.getData().equals(data)).collect(Collectors.toList());
    }

    public static List<Agendamento> AgendamentosClientes(Cliente cliente){

        return agenda.stream().filter(agenda -> agenda.getContaFechada()).collect(Collectors.toList());
    }

}
