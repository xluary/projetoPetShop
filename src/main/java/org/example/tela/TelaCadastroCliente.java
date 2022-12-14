package org.example.tela;

import org.example.persistencia.PersistenciaCliente;
import org.example.entidade.Cliente;

import java.util.Scanner;

public class TelaCadastroCliente {
    public static Cliente cadastrarNovoCliente(Scanner scanner){
        System.out.println("Informe o nome do Cliente:");
        final String nome = scanner.next();
        System.out.println("Informe o CPF: (somente numeros)");
        final long cpf = scanner.nextLong();
        System.out.println("Informe o contato: (ddd)99999-9999");
        final String contato = scanner.next();
        Cliente cliente = new Cliente(nome, cpf, contato);
        PersistenciaCliente bancoCliente = PersistenciaCliente.getInstance();
        bancoCliente.addCliente(cliente);
        System.out.println("Cliente cadastrado.");
        return cliente;
    }


}
