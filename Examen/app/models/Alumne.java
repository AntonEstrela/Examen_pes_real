package models;

import play.db.jpa.Model;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Alumne extends Model {
    private String nom;
    private int edat;

    @OneToMany(mappedBy="alumne")
    List<Comentari> comentaris = new ArrayList<Comentari>();

    public Alumne(){
        nom = null;
        edat = 0;
    }
    public Alumne(String nom, int edat){
        this.nom = nom;
        this.edat = edat;
    }

    public void setEdat(int edat) {
        this.edat = edat;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getEdat() {
        return edat;
    }

    public String getNom() {
        return nom;
    }

    public List<Comentari> getComentaris() {
        return comentaris;
    }
}
