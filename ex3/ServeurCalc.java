import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class ServeurCalc extends UnicastRemoteObject implements Calculatrice {

    protected ServeurCalc() throws RemoteException {
        super();
    }

    public double addition(double a, double b) throws RemoteException {
        return a + b;
    }

    public double soustraction(double a, double b) throws RemoteException {
        return a - b;
    }

    public double multiplication(double a, double b) throws RemoteException {
        return a * b;
    }

    public double division(double a, double b) throws RemoteException {
        if (b == 0) throw new ArithmeticException("Division par zéro !");
        return a / b;
    }

    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry(); // Lancer le registre RMI
            ServeurCalc calc = new ServeurCalc();
            registry.rebind("CalculatriceService", calc);
            System.out.println("Serveur de calcul prêt...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
