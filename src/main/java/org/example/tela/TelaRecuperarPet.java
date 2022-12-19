package org.example.tela;

import org.example.entidade.Cliente;
import org.example.entidade.Pets;
import org.example.persistencia.PersistenciaCliente;

import java.util.Scanner;

public class TelaRecuperarPet {
    public static Pets recuperarPet(Scanner scanner, Cliente cliente) {
        System.out.println("Qual pet você quer agendar?");
        PersistenciaCliente bancoPet= PersistenciaCliente.getInstance();
        return bancoPet.escolherPet(scanner.next(), cliente).orElseThrow(() -> new RuntimeException("Pet não encontrado."));

    }
}
