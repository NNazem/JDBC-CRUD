package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Date;

public class Membro {

    private int id;
    private static int id_counter = 2;
    private Date dataInizio;
    private Date dataFine;
    private int squadra_id;
    private String codiceFiscale;


    public Membro(Squadra squadra, Giocatore giocatore, Date dataInizio, Date dataFine){
        this.squadra_id = squadra.getId();
        this.codiceFiscale = giocatore.getCodiceFiscale();
        this.dataInizio = dataInizio;
        this.dataFine = dataFine;
        this.id = ++id_counter;
    }

    public void insertMembro(Connection connection){
        try {
            String insert = "INSERT INTO membri_table (id, squadra_id, codiceFiscale, dataInizio, dataFine) VALUES (?,?,?,?,?)";

            PreparedStatement preparedStatement = connection.prepareStatement(insert);
            preparedStatement.setInt(1, id);
            preparedStatement.setInt(2, squadra_id);
            preparedStatement.setString(3, codiceFiscale);
            preparedStatement.setDate(4, dataInizio);
            preparedStatement.setDate(5,  dataFine);
            preparedStatement.executeUpdate();
            System.out.println("Insert effettuata");
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    public void deleteGiocatore(Connection connection){
        try{
            String delete = "DELETE FROM membri_table WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(delete);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            System.out.println("Delete effettuata");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
