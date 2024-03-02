package org.example;

import Entites.Actualite;
import Services.ActualiteService;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {

        //**Actualite*//
        ActualiteService as = new ActualiteService() ;
        //as.ajouter(new Actualite("aaaaaaaaaaaaaaaaaaaaaa","11/11/1988"));
        //as.modifier(new Actualite("aaaaaaaaaaaaaaaaaaaaaa","11/11/1988"));
        //as.supprimer(new Actualite("aaaaaaaaaaaaaaaaaaaaaa","11/11/1988"));
        //System.out.println(as.afficher());
    }
}