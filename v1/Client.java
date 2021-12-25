package v1;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry();
            // trouve le service de résolution de nom de RMI qui se trouve sur hostName
            Compte compte = (Compte) registry.lookup("Bob");
            // demande un mandataire vers le compte de Bob
            System.out.println("Bob possède " + compte.solde() + " euros");
            // utilise le compte
        } catch (Exception e) {
            System.out.println("v1.Client exception: " + e.toString());
        }
    }
}