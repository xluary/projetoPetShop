package org.example.entidade;

public class Pets {

    private String nome;
    private String tipo;

    public Pets(String nome, String tipo){
        this.nome = nome;
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }

    public String getTipo() {
        return tipo;
    }
}
