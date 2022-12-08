package org.example;


import java.util.Scanner;

public class App
{
    public static void main( String[] args )
    {

        System.out.println( "Bem vindo ao PetShop Grupo 1!");
        Scanner scanner = new Scanner(System.in);
        int opcao;
        do{
            System.out.println("Digite: \n (1) Cadastrar Cliente \n (2) Cadastrar Pet \n (3) Agendar Horário \n (4) Imprimir Agenda Diária \n (0) Sair");
            opcao= scanner.nextInt();
            switch (opcao){
                case 0:
                    System.out.println("Sistema encerrado!");
                    break;
                case 1:
                    //TODO criar o cliente, e armazenar no bancoCliente
                    //TODO cadastra pets do cliente (usar um do while para permitir cadastrar vários pets?)
                    break;
                case 2:
                    // TODO atualizar cadastro de cliente (mudar dados cadastrais como contato, ou adicionar novos pets)
                    // (remover pet) :( ?
                    break;
                case 3:
                    //TODO criar agenda e adicionar item na agenda
                    break;
                case 4:
                    //TODO buscar na agenda os horarios marcados para o dia e imprimir na tela
                default:
                    System.out.println("Opção inválida!");
            }
        }while (opcao !=0);
    }
}
