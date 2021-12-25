package v2;

import java.rmi.Naming;

public class Client {
    public static void main(String[] args) {
        try {
            Compte compte = (Compte) Naming.lookup("rmi://127.0.0.1/Bob");
            System.out.println(compte.getTitulaire() +" possède "+ compte.solde() +" euros");
            // utilise le compte
        } catch (Exception e) {
            System.out.println("v1.Client exception: " + e.toString());
        }
    }
}