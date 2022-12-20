package org.example.persistencia;

import org.example.entidade.Agendamento;
import org.example.entidade.Cliente;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
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
            Collections.sort(tempAgenda);
            for(Agendamento compromisso : tempAgenda){
                System.out.printf("Cliente: %s \t Pet: %s \t Horário: %s  \t Procedimento: %s \n" ,compromisso.getCliente().getNome(), compromisso.getPet().getNome(), compromisso.getHorario().getLabel(),compromisso.getProcedimento().getTipo());
            }
        }

    }

    public static List<Agendamento> horariosDia(LocalDate data){
        List<Agendamento> entrada = agenda.stream().filter(agenda -> agenda.getData().equals(data)).collect(Collectors.toList());
        if(entrada == null){
            throw new RuntimeException("Dia não possui agendamentos");
        }
        return entrada;
    }

    public static void imprimirAgendamentoCliente(Scanner scanner, Cliente cliente){
        List<Agendamento> tempAgenda = contasAbertas(cliente);
        BigDecimal contaTotal = BigDecimal.valueOf(0);
        if(tempAgenda.isEmpty()){
            System.out.println("Não contas em aberto ");
        } else {
            Collections.sort(tempAgenda);
            System.out.printf("Cliente: %s  \n", cliente.getNome());
            for(Agendamento conta : tempAgenda){
                System.out.printf("Pet: %s  \t Procedimento: %s \t Valor: %s \n", conta.getPet().getNome(), conta.getProcedimento().getTipo(), conta.getProcedimento().getValor());
                contaTotal = contaTotal.add(conta.getProcedimento().getValor());
            }
        }
        System.out.printf("Valor total: %s \n", contaTotal);

        if(!contaTotal.equals(0)){
            System.out.println("O cliente realizou o pagamento? (1) sim (2) não");
            if(scanner.nextInt() == 1){
                for(Agendamento conta : tempAgenda){
                    conta.setStatusPagamento(true);
                }
            }
        }
    }

    public static List<Agendamento> contasAbertas(Cliente cliente){
        List<Agendamento> tempAgenda = new ArrayList<>();
        if (Objects.isNull(agenda)) {
            throw new RuntimeException("Nenhum agendamento cadastrado!");
        }
        for (Agendamento tempagenda : agenda) {
            if (!tempagenda.isStatusPagamento() && tempagenda.getCliente().equals(cliente)) {
                tempAgenda.add(tempagenda);
            }
        }
        return tempAgenda;
    }

}
