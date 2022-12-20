package org.example.tela;

import org.example.persistencia.PersistenciaAgenda;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class TelaObterAgendaDiaria implements Tela{
    public void executar(Scanner scanner){
        PersistenciaAgenda agenda = PersistenciaAgenda.getInstance();
        try{
            System.out.println("Informe a data desejada (dd/mm/aaaa): ");
            LocalDate data = LocalDate.parse(scanner.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            PersistenciaAgenda.imprimirAgendamentoDiario(data);
        }catch (RuntimeException e){
            System.err.println("Data Inválida");
        }
    }
}
