package models;

import play.db.jpa.Model;

import javax.persistence.Entity;

@Entity
public class Visitant extends Model {
    private String nom;
    private int edat;


    public Visitant(){
        nom = null;
        edat = 0;
    }

    public Visitant(String nom, int edat){
        this.nom = nom;
        this.edat = edat;
    }

    public String getNom() {
        return nom;
    }

    public int getEdat() {
        return edat;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setEdat(int edat) {
        this.edat = edat;
    }
}
