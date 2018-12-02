package com.sw.bdd;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class Dark {
    private Connection connexion;
    
    public List<Anakin> recupererVadors() {
        List<Anakin> Vador = new ArrayList<Anakin>();
        Statement statement = null;
        ResultSet resultat = null;

        loadDatabase();
        
        try {
            statement = connexion.createStatement();

            // Exécution de la requête
            resultat = statement.executeQuery("SELECT name, surname FROM jedi_masters;");

            // Récupération des données
            while (resultat.next()) {
                String name = resultat.getString("name");
                String surname = resultat.getString("surname");
                
                Anakin force = new Anakin();
                force.setName(name);
                force.setSurname(surname);
                
                Vador.add(force);
            }
        } catch (SQLException e) {
        } finally {
            // Fermeture de la connexion
            try {
                if (resultat != null)
                    resultat.close();
                if (statement != null)
                    statement.close();
                if (connexion != null)
                    connexion.close();
            } catch (SQLException ignore) {
            }
        }
        
        return Vador;
    }
    
    private void loadDatabase() {
        // Chargement du driver
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
        }

        try {
            connexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/starwars","Utilisateur","mdp");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    } 
}
