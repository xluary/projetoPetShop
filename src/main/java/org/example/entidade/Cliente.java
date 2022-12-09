package org.example.entidade;

import java.util.ArrayList;

public class Cliente {
    private String nome;
    private int cpf;
    private String contato;

    private ArrayList<Pets> pets;

    public Cliente(String nome, int cpf, String contato){
        this.nome=nome;
        this.cpf=cpf;
        this.contato=contato;
        pets = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }
}
