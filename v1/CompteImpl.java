package v1;

import java.rmi.RemoteException;

public class CompteImpl implements Compte {
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