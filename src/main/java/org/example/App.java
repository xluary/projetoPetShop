package org.example;

import org.example.entidade.*;
import org.example.fabrica.TelaFabrica;
import org.example.tela.*;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class App
{
    public static void main( String[] args ) throws Exception {
        //System.out.println( "Bem vindo ao PetShop Grupo 1!");
        Scanner scanner = new Scanner(entryHelpFile1().toFile());
        //Scanner scanner = new Scanner(System.in);

        int opcao =0;
        do{
            for (MenuInicial opcaoMenu : MenuInicial.values()) {
                System.out.printf("Opção (%d) - %s \n", opcaoMenu.getOpcao(), opcaoMenu.getLabel());
            }
            opcao= scanner.nextInt();
            Tela tela = TelaFabrica.getInstance(MenuInicial.fromOpcao(opcao));
            tela.executar(scanner);
            /*try{

            } catch (RuntimeException e){
                System.err.println("Tente Novamente");
            }*/
        }while (opcao !=0);
    }

    private static Path entryHelpFile() {
        return Paths.get("src", "main", "resources", "Input.entry")
                .toAbsolutePath();
    }
    private static Path entryHelpFile1() {
        return Paths.get("src", "main", "resources", "Input.entry.2")
                .toAbsolutePath();
    }
}
