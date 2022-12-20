package org.example.tela;

import org.example.entidade.TratamentoErros;
import org.example.persistencia.PersistenciaCliente;
import org.example.entidade.Cliente;

import java.util.Scanner;

public class TelaRecuperarCliente {
    public static Cliente recuperarCliente(Scanner scanner) throws Exception {

        scanner.nextLine();
        System.out.println("Informe o nome do cliente: ");
        PersistenciaCliente bancoCliente = PersistenciaCliente.getInstance();
        String nome = scanner.nextLine();
        if(!TratamentoErros.Caracter(nome)){
        }else {
            throw new RuntimeException("Entrada Inválida");
        }
        Cliente usario = bancoCliente.buscarPorNome(nome).orElseThrow(() -> new Exception("Cliente não encontrado."));
        return usario;
    }
}
