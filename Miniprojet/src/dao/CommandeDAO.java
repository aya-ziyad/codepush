/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

/**
 *
 * @author DELL
 */
import entity.DB;
import javax.swing.JOptionPane;
import java.sql.*;

public class CommandeDAO{
    public Connection con;

    // Constructeur pour initialiser la connexion à la base de données
    public CommandeDAO() {
        this.con = DB.getConnection();
    }

    // Méthode pour créer une commande et ses lignes associées
    public void createCommande(String dateCommande, String nomCommande, String materielId, int quantite) {
        try {
            // 1. Insertion de la commande dans la table 'commande'
            String sqlCommande = "INSERT INTO commande (datecommande, nomcommande) VALUES (?, ?)";
            try (PreparedStatement pstCommande = con.prepareStatement(sqlCommande, Statement.RETURN_GENERATED_KEYS)) {
                pstCommande.setString(1, dateCommande);
                pstCommande.setString(2, nomCommande);
                pstCommande.executeUpdate();

                // 2. Récupération de l'ID de la commande générée
                ResultSet rs = pstCommande.getGeneratedKeys();
                if (rs.next()) {
                    String idCommande = rs.getString(1); // ID de la commande

                    // 3. Création de la ligne de commande pour lier la commande et le matériel
                    createLigneCommande(idCommande, materielId, quantite);

                    // Message de confirmation
                    JOptionPane.showMessageDialog(null, "Commande ajoutée avec succès!");
                }
            }
        } catch (SQLException ex) {
            // En cas d'erreur, afficher un message d'erreur
            JOptionPane.showMessageDialog(null, "Erreur lors de la création de la commande: " + ex.getMessage());
        }
    }

    // Méthode pour ajouter une ligne de commande dans la table 'lignecommande'
    private void createLigneCommande(String idCommande, String materielId, int quantite) {
        try {
            String sqlLigneCommande = "INSERT INTO lignecommande (idcommande, idmateriel, quantite) VALUES (?, ?, ?)";
            try (PreparedStatement pstLigneCommande = con.prepareStatement(sqlLigneCommande)) {
                pstLigneCommande.setString(1, idCommande);
                pstLigneCommande.setString(2, materielId);
                pstLigneCommande.setInt(3, quantite);
                pstLigneCommande.executeUpdate();
            }
        } catch (SQLException ex) {
            // En cas d'erreur, afficher un message d'erreur
            JOptionPane.showMessageDialog(null, "Erreur lors de la création de la ligne de commande: " + ex.getMessage());
        }
    }
}
