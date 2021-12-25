package v2;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class CompteImpl extends UnicastRemoteObject implements Compte {
    private String proprietaire;
    private float solde;

    public CompteImpl(String proprietaire) throws RemoteException {
        this.proprietaire = proprietaire;
        this.solde = 0;
    }

    public String getTitulaire() throws RemoteException {
        return proprietaire;
    }

    public float solde() throws RemoteException {
        return solde;
    }
}