package org.example.entidade;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Agendamento {
    private Cliente cliente;
    private Pets pet;
    private LocalDate data;
    private Horarios horario;
    private Procedimentos procedimento;

    public Agendamento(Cliente cliente, LocalDate data, Horarios horario, Pets pet, Procedimentos procedimento) {
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

    public Procedimentos getProcedimento() {
        return procedimento;
    }
}
