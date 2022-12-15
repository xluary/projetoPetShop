package org.example;

import org.example.entidade.Cliente;
import org.example.entidade.Pets;
import org.example.entidade.Procedimentos;
import org.example.persistencia.PersistenciaAgenda;
import org.example.tela.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class App
{
    public static void main( String[] args )
    {
        System.out.println( "Bem vindo ao PetShop Grupo 1!");
        Scanner scanner = new Scanner(System.in);

        Cliente cliente;
        Pets pet;

        int opcao;
        do{
            System.out.println("Digite: \n (1) Cadastrar Cliente \n (2) Cadastrar Pet \n (3) Agendar Horário \n (4) Imprimir Agenda Diária \n (0) Sair");
            opcao= scanner.nextInt();
            switch (opcao){
                case 0:
                    System.out.println("Sistema encerrado!");
                    break;
                case 1:
                    TelaCadastroCliente.cadastrarNovoCliente(scanner);
                    break;
                case 2:
                    cliente = TelaRecuperarCliente.recuperarCliente(scanner);
                    boolean proximo;
                    do {
                        TelaCadastroPets.cadastrarPet(scanner, cliente);
                        System.out.println("Deseja cadastrar outro Pet? (S) Sim; (N) Não");
                        proximo = scanner.next().equalsIgnoreCase("s");
                    } while (proximo);
                    break;
                case 3:
                    cliente = TelaRecuperarCliente.recuperarCliente(scanner);
                    System.out.println("Qual o nome do Pet que você quer atendimento?");
                    cliente.imprimirPets();
                    pet = TelaRecuperarPet.recuperarPet(scanner, cliente);
                    TelaAgendamento.agendarHorario(scanner, cliente, pet);
                    break;
                case 4:
                    System.out.println("Informe a data desejada (dd/mm/aaaa): ");
                    LocalDate data = LocalDate.parse(scanner.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                    PersistenciaAgenda.imprimirAgendamentoDiario(data);
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }while (opcao !=0);
    }
}
