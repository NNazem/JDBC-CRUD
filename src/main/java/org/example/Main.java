package org.example;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        try{
            Connection connection = DatabaseConnection.getInstance();
            System.out.println("Connesione stabilita con successo");

            Giocatore giocatore = new Giocatore("NZMNVD0ADA", 23, "Navid", "Nazem", 3333333);
            giocatore.insertGiocatore(connection);
            giocatore.updateGiocatore(connection, "Nome", "Andrea");
            //giocatore.deleteGiocatore(connection);

            Squadra squadra = new Squadra("Milano", "Inter", "Meazza");
            squadra.insertSquadra(connection);
            squadra.updateSquadra(connection, "Nome", "Milan");
            //squadra.deleteSquadra(connection);

            Membro membro = new Membro(squadra, giocatore, new java.sql.Date(1L), new java.sql.Date(10000000000000L));
            membro.insertMembro(connection);
            //membro.deleteGiocatore(connection);
            //giocatore.deleteGiocatore(connection);
            //squadra.deleteSquadra(connection);

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}