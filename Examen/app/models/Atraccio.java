package models;

import play.db.jpa.Model;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Atraccio extends Model {
    private String nom;
    private int edatMinima;


    @ManyToMany//(mappedBy="visitants")
    List<Visitant> visitants = new ArrayList<Visitant>();

    public Atraccio(){
        nom = null;
        edatMinima = 0;
    }

    public Atraccio(String nom, int edatMinima){
        this.nom = nom;
        this.edatMinima = edatMinima;
    }

    public int getEdatMinima() {
        return edatMinima;
    }

    public List<Visitant> getVisitants() {
        return visitants;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setEdatMinima(int edatMinima) {
        this.edatMinima = edatMinima;
    }
}
