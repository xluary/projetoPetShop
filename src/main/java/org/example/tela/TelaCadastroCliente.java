package org.example.tela;

import org.example.persistencia.PersistenciaCliente;
import org.example.entidade.Cliente;
import org.example.entidade.TratamentoErros;

import java.util.Scanner;

public class TelaCadastroCliente implements Tela{
    public void executar(Scanner scanner){


        try{
            scanner.nextLine();
            System.out.println("Informe o nome do Cliente:");
            final String nome = scanner.nextLine();
            if (TratamentoErros.Caracter(nome)){
                throw new RuntimeException("Entrada Inválida");
            }
            System.out.println("Informe o CPF: (somente numeros)");
            final long cpf = scanner.nextLong();
            System.out.println("Informe o contato: (ddd)99999-9999");
            final String contato = scanner.next();
            Cliente cliente = new Cliente(nome, cpf, contato);
            PersistenciaCliente bancoCliente = PersistenciaCliente.getInstance();
            bancoCliente.addCliente(cliente);
            System.out.println("Cliente cadastrado!");
        }catch (Exception e){
            System.err.println("Entrada inválida");
            System.exit(0);
        }
    }
}
