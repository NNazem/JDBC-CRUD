package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class Giocatore {

    private String codiceFiscale;
    private int età;
    private String nome;
    private String cognome;
    private int numeroTelefono;

    public Giocatore(String codiceFiscale, int età, String nome, String cognome, int numeroTelefono) {
        this.codiceFiscale = codiceFiscale;
        this.età = età;
        this.nome = nome;
        this.cognome = cognome;
        this.numeroTelefono = numeroTelefono;
    }

    public String getCodiceFiscale() {
        return codiceFiscale;
    }

    public void insertGiocatore(Connection connection){
        try {
            String insert = "INSERT INTO giocatori_table (codicefiscale, età, nome, cognome, telefono) VALUES (?,?,?,?,?)";

            PreparedStatement preparedStatement = connection.prepareStatement(insert);
            preparedStatement.setString(1, codiceFiscale);
            preparedStatement.setInt(2, età);
            preparedStatement.setString(3, nome);
            preparedStatement.setString(4, cognome);
            preparedStatement.setInt(5, numeroTelefono);
            preparedStatement.executeUpdate();
            System.out.println("Insert effettuata");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void updateGiocatore(Connection connection, String campo, String valore){
        try{
            String update = "UPDATE giocatori_table SET " + campo + " = ? WHERE codiceFiscale = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(update);
            preparedStatement.setString(1, valore);
            preparedStatement.setString(2, codiceFiscale);
            System.out.println(update);
            preparedStatement.executeUpdate();
            System.out.println("Update effettuato");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void deleteGiocatore(Connection connection){
        try{
            String delete = "DELETE FROM giocatori_table WHERE codicefiscale = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(delete);
            preparedStatement.setString(1, codiceFiscale);
            preparedStatement.executeUpdate();
            System.out.println("Delete effettuata");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
