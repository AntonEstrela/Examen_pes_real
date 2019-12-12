package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

import models.*;

public class Application extends Controller {

    public static void index() {
        render();
    }
    public static void AfegirVisitant(String n, int e){
        Visitant v = Visitant.find("byNom", n).first();
        if(v == null){
            v = new Visitant(n, e);
            v.save();
            renderText("OK");
        }
        else{
            renderText("FAIL");
        }
    }
    public static void AfegirAtraccio(String n, int em){
        Atraccio a = Atraccio.find("byNom", n).first();
        if(a == null){
            a = new Atraccio(n, em);
            a.save();
            renderText("OK");
        }
        else{
            renderText("FAIL");
        }
    }
    public static void PujarAtraccio(String nVisitant, String nAtraccio){
        Atraccio a = Atraccio.find("byNom", nAtraccio).first();
        Visitant v = Visitant.find("byNom", nVisitant).first();
        if(a != null){
            if(v != null){
                if(v.getEdat() >= a.getEdatMinima()){
                    a.getVisitants().add(v);
                    a.save();
                    renderText("OK");
                }
                else{
                    renderText("FAIL: you have to wait " + (a.getEdatMinima() - v.getEdat()) + " years");
                }
            }
            else{
                renderText("FAIL: " + nVisitant + " not found");
            }
        }
        else{
            renderText("FAIL: " + nAtraccio + " not found");
        }
    }
    public static void LlistaNomAtraccionsPerMenorsdeXAnys(int nAnys){
        //List<Producte> lp = Producte.find("byPreuGreaterThanEquals", preuMinim).fetch();
        List<Atraccio> a = Atraccio.find("byEdatMinimaLessThanEquals", nAnys).fetch();
        if(a != null){
            String buffer= "";
            for(Atraccio atraccio : a){
                buffer += ", ";
                buffer += atraccio.getNom();
            }
            renderText("Per a menors de " + nAnys + " anys: " + buffer);
        }
        else{
            renderText("404 not found");
        }
    }


}