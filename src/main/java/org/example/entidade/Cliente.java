package org.example.entidade;

import java.util.ArrayList;

public class Cliente {
    private String nome;
    private int cpf;
    private String contato;

    private static ArrayList<Pets> pets;

    public Cliente(String nome, int cpf, String contato){
        this.nome=nome;
        this.cpf=cpf;
        this.contato=contato;
        pets = new ArrayList<>();
    }

    // Métodos personalizados
    public static void adicionarPet(Pets pet){
        pets.add(pet);
    }

    public void imprimirPets(){
        int quantidadePets = pets.size();
        System.out.printf("O cliente possui %d pet(s) cadastrados: \n", quantidadePets);
        for(int i=0; i<quantidadePets; i++){
            System.out.printf("Nome: %s \t Tipo: %s \n", pets.get(i).getNome(), pets.get(i).getTipo());
        }
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nome='" + nome + '\'' +
                ", cpf=" + cpf +
                ", contato='" + contato + '\'' +
                '}';
    }

    public String getNome() {
        return nome;
    }

}
