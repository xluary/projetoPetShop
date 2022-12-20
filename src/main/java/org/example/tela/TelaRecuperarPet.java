package org.example.tela;

import org.example.entidade.Cliente;
import org.example.entidade.Pets;
import org.example.entidade.TratamentoErros;
import org.example.persistencia.PersistenciaCliente;

import java.util.Scanner;

public class TelaRecuperarPet {
    public static Pets recuperarPet(Scanner scanner, Cliente cliente) {
        PersistenciaCliente bancoPet= PersistenciaCliente.getInstance();
        String nome = scanner.nextLine();
        if(TratamentoErros.Caracter(nome)){
            throw new RuntimeException("Entrada inválida");
        }
        return bancoPet.escolherPet(nome, cliente).orElseThrow(() -> new RuntimeException("Pet não encontrado."));
    }
}
