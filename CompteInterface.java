import java.rmi.Remote;
import java.rmi.RemoteException;

public interface CompteInterface extends Remote {
    float getSolde() throws RemoteException;
    void verser(float mt) throws RemoteException;
    void retirer(float mt) throws RemoteException;
    float getDecouvert() throws RemoteException;
    void setDecouvert(float d) throws RemoteException;
}
