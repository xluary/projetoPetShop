package org.example.persistencia;

import org.example.entidade.Cliente;
import org.example.entidade.Pets;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Optional;

public class PersistenciaCliente {
    private ArrayList<Cliente> clientes;

    private static PersistenciaCliente instance;

    public static PersistenciaCliente getInstance(){
        if(Objects.isNull(instance)){
            instance = new PersistenciaCliente();
        }
        return instance;
    }
    private PersistenciaCliente(){
        clientes = new ArrayList<>();
    }
    public Optional<Cliente> buscarPorNome(String nome) {
        if(Objects.isNull(clientes)){
            throw new RuntimeException("Não achamos esse cliente na nossa lista");
        }
        for (Cliente cliente : clientes) {
            if(cliente.getNome().equalsIgnoreCase(nome)){
                return Optional.of(cliente);
            }
        }
        return Optional.empty();

    }
    public  void addCliente(Cliente cliente){
        if(Objects.isNull(clientes)){
            clientes = new ArrayList<>();
        }
        clientes.add(cliente);
    }
    public Optional<Pets> escolherPet(String nomePet, Cliente cliente){
        if(Objects.isNull(cliente.getPets())){
            throw new RuntimeException("Não achamos esse Pet na nossa lista");
        }
        for (int i=0; i<cliente.getPets().size(); i++ ) {
            if(cliente.getPets().get(i).getNome().equalsIgnoreCase(nomePet)){
                return Optional.of(cliente.getPets().get(i));
            }
        }
        return Optional.empty();
    }
}
