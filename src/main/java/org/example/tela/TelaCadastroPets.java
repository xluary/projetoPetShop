package org.example.tela;

import org.example.entidade.Cliente;
import org.example.entidade.Pets;
import org.example.entidade.TipoPet;

import java.util.Scanner;

public class TelaCadastroPets implements Tela{

    public void executar(Scanner scanner){

        TelaRecuperarCliente.recuperarCliente(scanner);
        boolean proximo;
        do {
            System.out.println("Informe o nome do Pet: ");
            String nome = scanner.next();

            for (TipoPet tipoPet : TipoPet.values()) {
                System.out.printf("Opção (%d) - %s \n", tipoPet.getOpcao(), tipoPet.getLabel());
            }

            Pets pet = new Pets(nome,TipoPet.fromOpcao(scanner.nextInt()).getLabel());
            Cliente.adicionarPet(pet);
            System.out.println("Deseja cadastrar outro Pet? (S) Sim; (N) Não");
            proximo = scanner.next().equalsIgnoreCase("s");
        } while (proximo);
    }
}
