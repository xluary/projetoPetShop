package org.example.tela;

import org.example.banco.BancoCliente;
import org.example.entidade.Cliente;

import java.util.Scanner;

public class TelaCadastroCliente {
    public static Cliente cadastrarNovoCliente(Scanner scanner){
        System.out.println("Informe o nome do Cliente:");
        final String nome = scanner.next();
        System.out.println("Informe o CPF: (somente numeros)");
        final int cpf = scanner.nextInt();
        System.out.println("Informe o contato: (ddd)99999-9999");
        final String contato = scanner.next();
        return new Cliente(nome, cpf, contato);
    }

    public static Cliente recuperarCliente(Scanner scanner) {
        System.out.println("Informe o nome do cliente que deseja cadastrar o pet.");
         BancoCliente bancoCliente = BancoCliente.getInstance();

         return bancoCliente.buscarPorNome(scanner.next()).orElseThrow(() -> new RuntimeException("Cliente não encontrado."));
    }
}
