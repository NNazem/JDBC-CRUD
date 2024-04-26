package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class DV01 {

    public static void main(String[] args) {
        try{

            Connection connection = DatabaseConnection.getInstance();
            String sql = "INSERT INTO DV01_JDBC (SUBSTR, PILLAR, DV01PAR) VALUES (?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            String filePath = "C:\\Users\\Nazem\\IdeaProjects\\JDBC-CRUD\\src\\main\\java\\org\\example\\DV01_PAR_CURVE.csv";

            BufferedReader lineReader = new BufferedReader(new FileReader(filePath));

            String lineText = null;

            lineReader.readLine();

            Date inizio = new Date();

            while ((lineText = lineReader.readLine()) != null) {

                String[] parts = lineText.split(";");

                String substr = parts[0];
                String pillar = parts[1];
                Double dv01Par = Double.valueOf(parts[2]);

                statement.setString(1, substr);
                statement.setString(2, pillar);
                statement.setDouble(3, dv01Par);


                statement.executeUpdate();

            }

            Date fine = new Date();

            long secondsPassed = TimeUnit.MILLISECONDS.toSeconds(fine.getTime() - inizio.getTime());

            System.out.printf("Inserimento completato in: %d secondi", secondsPassed);



        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
