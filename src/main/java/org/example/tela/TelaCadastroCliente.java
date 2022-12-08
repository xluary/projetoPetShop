package org.example.tela;

import org.example.entidade.Cliente;

import java.util.Scanner;

public class TelaCadastroCliente {
    public static Cliente cadastrarNovoCliente(Scanner scanner){
        System.out.println("Informe o nome do Cliente:");
        final String nome = scanner.next();
        System.out.println("Informe o CPF:");
        final int cpf = scanner.nextInt();
        System.out.println("Informe o contato: (ddd)99999-9999");
        final String contato = scanner.next();

        Cliente cliente = new Cliente(nome, cpf, contato);
        int i=0;
        return cliente;
    }
}
