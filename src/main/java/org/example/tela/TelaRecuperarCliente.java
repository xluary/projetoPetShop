package org.example.tela;

import org.example.persistencia.PersistenciaCliente;
import org.example.entidade.Cliente;

import java.util.Scanner;

public class TelaRecuperarCliente {
    public static Cliente recuperarCliente(Scanner scanner) {
        System.out.println("Informe o nome do cliente: ");
        PersistenciaCliente bancoCliente = PersistenciaCliente.getInstance();

        return bancoCliente.buscarPorNome(scanner.next()).orElseThrow(() -> new RuntimeException("Cliente não encontrado."));
    }
}
