package org.example.tela;

import org.example.entidade.Cliente;
import org.example.persistencia.PersistenciaAgenda;

import java.util.Scanner;

public class TelaContaCliente implements Tela{
    public void executar(Scanner scanner) throws Exception {
        Cliente cliente = TelaRecuperarCliente.recuperarCliente(scanner);
        PersistenciaAgenda.imprimirAgendamentoCliente(scanner, cliente);
    }

}
