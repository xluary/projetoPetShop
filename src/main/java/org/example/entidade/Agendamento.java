package org.example.entidade;

import java.time.LocalDate;

public class Agendamento implements Comparable<Agendamento>{
    private Cliente cliente;
    private Pets pet;
    private LocalDate data;
    private Horarios horario;
    private Procedimento procedimento;


    public Agendamento(Cliente cliente, LocalDate data, Horarios horario, Pets pet, Procedimento procedimento) {
        this.cliente = cliente;
        this.data = data;
        this.horario = horario;
        this.pet = pet;
        this.procedimento = procedimento;
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

    @Override
    public int compareTo(Agendamento outroAgendamento) {
        return this.horario.compareTo(outroAgendamento.getHorario());
    }
}
