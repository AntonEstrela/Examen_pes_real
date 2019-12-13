package models;

import play.db.jpa.Model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Comentari extends Model {
    private String text;
    private int any;

    @ManyToOne
    Alumne alumne = new Alumne();


    public Comentari(){
        text = null;
        any = 0;
    }

    public Comentari(String text, int any){
        this.text = text;
        this.any = any;
    }

    public void setAny(int any) {
        this.any = any;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setAlumne(Alumne alumne) {
        this.alumne = alumne;
    }

    public int getAny() {
        return any;
    }

    public String getText() {
        return text;
    }

    public Alumne getAlumne() {
        return alumne;
    }
}
