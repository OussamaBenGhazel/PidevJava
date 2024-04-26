package tn.esprit.pigui.test;

import tn.esprit.pigui.models.Client;
import tn.esprit.pigui.services.ClientService;
import tn.esprit.pigui.utils.MyDatabase;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args){
        ClientService cs = new ClientService();

        try {
        //    cs.ajouter(new Client("oussema",20239980,"manar1","3a41@esprint.tn"));
      //      cs.modifier(new Client(1,9451351,"20239980","manar 2","gre@esprit.tn"));
        //    cs.supprimer(1);
            System.out.println(cs.afficher());
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

}
