package org.example.tela;

import org.example.entidade.Cliente;

import java.util.Scanner;

public class TelaContaCliente implements Tela{
    public void executar(Scanner scanner) throws Exception {
        System.out.println("Digite o nome do Cliente:");
        Cliente cliente = TelaRecuperarCliente.recuperarCliente(scanner);
    }

}
