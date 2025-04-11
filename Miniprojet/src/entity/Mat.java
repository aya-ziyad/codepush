/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.util.logging.Logger;

/**
 *
 * @author DELL
 */
public class Mat {
    private String id, marque,nom,ip;

    public Mat(String id ,String ip, String marque, String nom) {
        this.id = id;
        this.marque = marque;
        this.nom = nom;
        this.ip = ip;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getId() {
        return id;
    }

    public String getMarque() {
        return marque;
    }

    public String getNom() {
        return nom;
    }

    public String getIp() {
        return ip;
    }
    public Object[] toArray(){
       Object t[]= new Object[4];
   t[0]=id;
    t[1]=ip;
     t[2]=nom;
      t[3]=marque;
        return t;     
    }
}
