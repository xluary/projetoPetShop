package org.example.persistencia;

import org.example.entidade.Cliente;
import org.example.entidade.Pets;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Optional;

public class PersistenciaPet {
    private ArrayList<Pets> pets;
    private static PersistenciaPet instance;

    public static PersistenciaPet getInstance(){
        if(Objects.isNull(instance)){
            instance = new PersistenciaPet();
        }
        return instance;
    }
    public Optional<Pets> escolherPet(String nomePet, Cliente cliente){
        if(Objects.isNull(cliente.getPets())){
            throw new RuntimeException("Não achamos esse Pet na nossa lista");
        }
        for (int i=0; i<cliente.getPets().size(); i++ ) {
            if(cliente.getPets().get(i).getNome().equals(nomePet)){
                return Optional.of(cliente.getPets().get(i));
            }
            i++;
        }
        return Optional.empty();
    }
}
