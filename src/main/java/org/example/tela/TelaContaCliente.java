package org.example.tela;

import org.example.entidade.Agendamento;
import org.example.entidade.Cliente;
import org.example.persistencia.PersistenciaAgenda;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class TelaContaCliente implements Tela{
    public void executar(Scanner scanner){
        Cliente cliente = TelaRecuperarCliente.recuperarCliente(scanner);
        PersistenciaAgenda.imprimirAgendamentoCliente(cliente);

    }

}
