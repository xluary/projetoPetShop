package org.example.entidade;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Agendamento {
    private Cliente cliente;
    private Pets pet;
    private LocalDate data;
    private Horarios horario;

    public Agendamento(Cliente cliente, LocalDate data, Horarios horario, Pets pet) {
        this.cliente = cliente;
        this.data = data;
        this.horario = horario;
        this.pet=pet;
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
}
