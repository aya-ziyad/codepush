/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Mat;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class MatDAO {
    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */



    Connection con;
private static final String USER = "root";  // Assurez-vous que c'est l'utilisateur correct
private static final String PASSWORD = "";  
private static final String URL = "jdbc:mysql://localhost:3307/onousc?useSSL=false&serverTimezone=UTC";


    public MatDAO()  {
        try {     
              con = DriverManager.getConnection(URL,USER,PASSWORD);
            System.out.println("Database connected successfully.");
        } 
        catch (SQLException e) 
   { System.err.println("Failed to connect  " + e.getMessage()); }     
    }
   public ArrayList<Mat> getAll() {
    ArrayList<Mat> article = new ArrayList<>();  
    if (con == null) {  // Vérifie si la connexion est bien initialisée
        System.err.println("Connection is null. Ensure the database connection is initialized.");
        return article;  // Retourne une liste vide si la connexion échoue
    }

    String query = "SELECT * FROM mat";
    try (Statement st = con.createStatement();
         ResultSet rs = st.executeQuery(query)) {

        // Traiter les résultats
        while (rs.next()) {
            String id = rs.getString("id");  // Utiliser getString pour l'ID
            String ip = rs.getString("ip");
            String marque = rs.getString("marque");
            String nom = rs.getString("nom");
            article.add(new Mat(id, ip, marque, nom));  // Crée un objet Mat et l'ajoute à la liste
        }
    } catch (SQLException e) {
        System.err.println("Error fetching materiels: " + e.getMessage());
    }

    return article;  // Retourne la liste peuplée
}

    

    public static void main(String[] args) {
        MatDAO artDAO = new MatDAO();
        ArrayList<Mat> article= artDAO.getAll();

        // Print the results
        if (article.isEmpty()) {
            System.out.println("No articles found.");
        } else {
            for (Mat art: article) {
                System.out.println(art);
            }
        }
    }
   
    public ArrayList<Mat> recherche(String lib){
        try {
        // Préparer la requête SQL
        PreparedStatement pst = con.prepareStatement("SELECT * FROM mat WHERE ip LIKE ?");     
        // Ajouter le paramètre avec le caractère de remplacement (%)
        pst.setString(1, lib + "%");
        // Exécuter la requête
        ResultSet rs = pst.executeQuery();
          ArrayList Table = new ArrayList();
        // Parcourir les résultats
        while (rs.next()) {
            String id = rs.getString("id");
    String ip = rs.getString("ip");
    String marque = rs.getString("marque");
    String nom = rs.getString("nom");
    Mat d = new Mat(id, ip, marque, nom);
            Table.add(d);
        }
            // Exemple : Afficher les résultats dans la console
          return Table;      
    } catch (SQLException e) {
       return null; }
    }
}
    
    
        
           


            
       
    
    



