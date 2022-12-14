package org.example.tela;

import org.example.entidade.Cliente;
import org.example.entidade.Pets;
import org.example.persistencia.PersistenciaCliente;
import org.example.persistencia.PersistenciaPet;

import java.util.Optional;
import java.util.Scanner;

public class TelaRecuperarPet {
    public static Pets recuperarPet(Scanner scanner, Cliente cliente) {
        PersistenciaPet bancoPet= PersistenciaPet.getInstance();

        return bancoPet.escolherPet(scanner.next(), cliente).orElseThrow(() -> new RuntimeException("Pet não encontrado."));

    }
}
