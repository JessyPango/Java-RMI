package v2;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Compte extends Remote {
    public String getTitulaire() throws RemoteException;

    public float solde() throws RemoteException;
}