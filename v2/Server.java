package v2;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Server {
    public static void main(String args[]) {
        try {
            CompteImpl compteimpl = new CompteImpl("Bob");
            // création de l’objet serveur
            Naming.rebind("Bob", compteimpl);
        } catch (Exception e) {
            System.out.println("v1.Server exception: " + e.toString());
        }
    }
}