package org.example.tela;

import org.example.entidade.Cliente;
import org.example.entidade.Pets;
import org.example.entidade.TipoPet;
import org.example.entidade.TratamentoErros;

import java.util.Scanner;

public class TelaCadastroPets implements Tela{

    public void executar(Scanner scanner) throws Exception {

        Cliente cliente = TelaRecuperarCliente.recuperarCliente(scanner);
        try{
            boolean proximo;
            do {
                System.out.println("Informe o nome do Pet: ");
                String nome = scanner.next();
                if(TratamentoErros.Caracter(nome)){
                    throw new RuntimeException();
                }
                for (TipoPet tipoPet : TipoPet.values()) {
                    System.out.printf("Opção (%d) - %s \n", tipoPet.getOpcao(), tipoPet.getLabel());
                }
                Pets pet = new Pets(nome,TipoPet.fromOpcao(scanner.nextInt()).getLabel());
                cliente.adicionarPet(pet);
                System.out.println("Deseja cadastrar outro Pet? (S) Sim; (N) Não");
                proximo = scanner.next().equalsIgnoreCase("s");
            } while (proximo);
        }catch (Exception e){
            System.err.println("Entrada Invalida");
            System.exit(0);
        }
    }
}
