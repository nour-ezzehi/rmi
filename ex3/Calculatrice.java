import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Calculatrice extends Remote {
    public double addition(double a, double b) throws RemoteException;
    public double soustraction(double a, double b) throws RemoteException;
    public double multiplication(double a, double b) throws RemoteException;
    public double division(double a, double b) throws RemoteException;
}
