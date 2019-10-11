package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

import models.*;

public class Application extends Controller {

    public static void index() {
        Canso c = new Canso("qwkdm", 2019, "qenceiuqlnicjnq");
        c.AddCantantNomPais("qjdn", "iqwehbd");
        c.save();

        render();
    }

}