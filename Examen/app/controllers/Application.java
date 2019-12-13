package controllers;

import play.*;
import play.db.jpa.JPA;
import play.mvc.*;

import java.util.*;

import models.*;

import javax.persistence.Query;

public class Application extends Controller {

    public static void index() {
        render();
    }

    public static void AltaAlumne(String nom, int edat){
        Alumne a = Alumne.find("byNom", nom).first();
        if(a == null){
            a = new Alumne(nom, edat);
            a.save();
            renderText("OK");
        }
        else{
            renderText("El nom ja existeix");
        }
    }
    public static void PublicarComentari(String nomAlumne, String text){
        Alumne a = Alumne.find("byNom", nomAlumne).first();
        if (a != null){
            int any = Calendar.getInstance().get(Calendar.YEAR);
            Comentari c = new Comentari(text, any);
            c.setAlumne(a);
            c.save();
            renderText("OK");
        }
        else{
            renderText("T'has de donar d'alta en el sistema abans de publicar");
        }
    }
    public static void MostrarComentaris(int a){
        List<Comentari> comentaris = Comentari.findAll();
        // List<Comentari> comentaris = Comentari.find("byAny", a).fetch(); //no se pq no funcionava

        String tmp = "Comentaris del " + a + ":\n";
        for(Comentari c : comentaris){
            if(c.getAny() == a) {//aquest if tan lleig perque no funcionava la consulta amb el find
                Alumne alumne = c.getAlumne();
                tmp += alumne.getNom() + ": ";
                tmp += c.getText() + ";";
            }
        }
        renderText(tmp);
    }

}