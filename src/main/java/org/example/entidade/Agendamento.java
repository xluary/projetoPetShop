package org.example.entidade;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Agendamento {
    private Cliente cliente;
    private LocalDate data;
    private Horarios horario;

    public Agendamento(Cliente cliente, LocalDate data, Horarios horario) {
        this.cliente = cliente;
        this.data = data;
        this.horario = horario;
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
}
