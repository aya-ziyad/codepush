package entity;
public class Materiel {
   
    private String id,nom, marque;
         private Float prix;

    public Materiel(String id,String nom,String marque,Float prix) {
        this.nom = nom;
        this.marque = marque;
       this.id=id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getId() {
        return id;
    }

    public void setIp(Float prix) {
        this.prix = prix;
    }

    public Float getPrix() {
        return prix;
    }

    
    public String getNom() {
        return nom;
    }

    public String getMarque() {
        return marque;
    }

  
}