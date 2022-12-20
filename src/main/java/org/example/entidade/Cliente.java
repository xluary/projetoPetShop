package org.example.entidade;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Optional;
import org.example.entidade.Pets;

public class Cliente {
    private String nome;
    private long cpf;
    private String contato;
    private ArrayList<Pets> pets;

    public Cliente(String nome, long cpf, String contato){
        this.nome=nome;
        this.cpf=cpf;
        this.contato=contato;
        pets = new ArrayList<>();
    }

    // Métodos personalizados
    public void adicionarPet(Pets pet){
        pets.add(pet);
    }

    public void imprimirPets(){
        int quantidadePets = pets.size();
        System.out.printf("O cliente possui %d pet(s) cadastrados: \n", quantidadePets);
        for(int i=0; i<quantidadePets; i++){
            System.out.printf("Nome: %s \t Tipo: %s \n", pets.get(i).getNome(), pets.get(i).getTipo());
        }
        if(quantidadePets<0){
            throw new RuntimeException("o Cliente não possui nenhum Pet Cadastrado");
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

    public ArrayList<Pets> getPets() {
        return pets;
    }

}
