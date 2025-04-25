import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ServeurBanque {
    public static void main(String[] args) {
        try {
            CompteImpl compte = new CompteImpl();
            Registry registry = LocateRegistry.getRegistry();
            registry.rebind("CompteBancaire", compte);
            System.out.println("Serveur en attente...");
        } catch (Exception e) {
            System.out.println("Erreur serveur : " + e.getMessage());
            e.printStackTrace();
        }
    }
}
