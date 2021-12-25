package v1;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Server {
    public static void main(String args[]) {
        try {
            CompteImpl compteimpl = new CompteImpl("Bob");
            // création de l’objet serveur
            Compte compte = (Compte) UnicastRemoteObject.exportObject(compteimpl);
            // enregistre compte dans RMI : on peut l’appeler à distance
            Registry registry = LocateRegistry.getRegistry();
            // trouve le service de nom de RMI
            registry.bind("Bob", compte);
            // enregistre la référence distante dans le service de résolution
        } catch (Exception e) {
            System.out.println("Server exception: " + e.toString());
        }
    }
}