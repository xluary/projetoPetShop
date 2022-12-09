package org.example;


import org.example.entidade.Cliente;
import org.example.entidade.Pets;
import org.example.tela.TelaCadastroCliente;
import org.example.tela.TelaCadastroPets;

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
            Cliente cliente = null;
            Pets pet = null;
            switch (opcao){
                case 0:
                    System.out.println("Sistema encerrado!");
                    break;
                case 1:
                    //TODO criar o cliente, e armazenar no bancoCliente
                    cliente = TelaCadastroCliente.cadastrarNovoCliente(scanner);
                    //TODO cadastra pets do cliente (usar um do while para permitir cadastrar vários pets?)
                    break;
                case 2:
                    cliente = TelaCadastroCliente.recuperarCliente(scanner);
                    boolean proximo;
                    do {
                        pet = TelaCadastroPets.cadastrarPet(scanner);
                        System.out.println("Deseja cadastrar outro Pet? (S) Sim; (N) Não");
                        proximo = scanner.next().equalsIgnoreCase("s");
                    } while (proximo);

                    break;
                    // TODO atualizar cadastro de cliente (mudar dados cadastrais como contato, ou adicionar novos pets)

                    // (remover pet) :( ?

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
