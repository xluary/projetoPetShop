package org.example.entidade;

import java.time.LocalDate;

public class Agendamento implements Comparable<Agendamento>{
    private Cliente cliente;
    private Pets pet;
    private LocalDate data;
    private Horarios horario;
    private Procedimento procedimento;

    private boolean statusPagamento;


    public Agendamento(Cliente cliente, LocalDate data, Horarios horario, Pets pet, Procedimento procedimento) {
        this.cliente = cliente;
        this.data = data;
        this.horario = horario;
        this.pet = pet;
        this.procedimento = procedimento;
        this.statusPagamento = false;
    }

    public LocalDate getData() {
        return data;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Horarios getHorario() {
        return horario;
    }

    public Pets getPet() { return pet; }

    public Procedimento getProcedimento() {
        return procedimento;
    }

    public boolean isStatusPagamento() {
        return statusPagamento;
    }

    public void setStatusPagamento(boolean statusPagamento) {
        this.statusPagamento = statusPagamento;
    }

    @Override
    public int compareTo(Agendamento outroAgendamento) {
        return this.horario.compareTo(outroAgendamento.getHorario());
    }

}
