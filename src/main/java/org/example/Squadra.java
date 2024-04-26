package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class Squadra {

    private int id;
    private String città;
    private String nome;
    private String stadio;
    private static int counter_id = 2; //Non funziona per più esecuzioni


    public Squadra(String città, String nome,String stadio){
        this.id = ++counter_id;
        this.città = città;
        this.nome = nome;
        this.stadio = stadio;
    }

    public int getId() {
        return id;
    }

    public void insertSquadra(Connection connection){
        try {
            String insert = "INSERT INTO squadre_table (id, nome, città, stadio) VALUES (?,?,?,?)";

            PreparedStatement preparedStatement = connection.prepareStatement(insert);
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, nome);
            preparedStatement.setString(3, città);
            preparedStatement.setString(4, stadio);
            preparedStatement.executeUpdate();
            System.out.println("Insert effettuata");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void updateSquadra(Connection connection, String campo, String valore){
        try{
            String update = "UPDATE squadre_table SET " + campo + " = ? WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(update);
            preparedStatement.setString(1, valore);
            preparedStatement.setInt(2, id);
            System.out.println(update);
            preparedStatement.executeUpdate();
            System.out.println("Update effettuato");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void deleteSquadra(Connection connection){
        try{
            String delete = "DELETE FROM squadre_table WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(delete);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            System.out.println("Delete effettuata");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
