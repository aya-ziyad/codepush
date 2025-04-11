/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author DELL
 */

public class LigneCommande{
    private String idcommande;  // Changer le type de int à String
    private String idmateriel;  // Changer le type de int à String
    private int quantite;

    public LigneCommande(String idcommande, String idmateriel, int quantite) {
        this.idcommande = idcommande;  // Stocker l'id en tant que String
        this.idmateriel = idmateriel;  // Stocker l'id du matériel en tant que String
        this.quantite = quantite;
    }

    public String getIdcommande() {
        return idcommande;  // Retourner l'id de la commande en tant que String
    }

    public String getIdmateriel() {
        return idmateriel;  // Retourner l'id du matériel en tant que String
    }

    public int getQuantite() {
        return quantite;
    }
}
