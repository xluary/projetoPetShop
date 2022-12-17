package org.example.tela;

import org.example.entidade.Cliente;
import org.example.entidade.Pets;

import java.util.Scanner;

public class TelaCadastroPets {

    public static void cadastrarPet(Scanner scanner, Cliente cliente){
        System.out.println("Informe o nome do Pet: ");
        String nome = scanner.next();

        System.out.println("(1) Cachorro; (2) Gato");
        int tipoPet = scanner.nextInt();

        String tipo="";
        if(tipoPet==1){
            tipo = "Cachorro";
        }else if(tipoPet==2){
            tipo = "Gato";
        }

        Pets pet = new Pets(nome,tipo);
        Cliente.adicionarPet(pet);
    }
}
