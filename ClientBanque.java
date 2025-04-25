import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class ClientBanque {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            CompteInterface compte = (CompteInterface) registry.lookup("CompteBancaire");

            Scanner scanner = new Scanner(System.in);
            int choix;

            do {
                System.out.println("\n--- Menu ---");
                System.out.println("1. Consulter solde");
                System.out.println("2. Verser montant");
                System.out.println("3. Retirer montant");
                System.out.println("4. Fixer un découvert");
                System.out.println("5. Quitter");
                System.out.print("Votre choix : ");
                choix = scanner.nextInt();

                switch (choix) {
                    case 1:
                        System.out.println("Solde actuel : " + compte.getSolde());
                        break;
                    case 2:
                        System.out.print("Montant à verser : ");
                        float mtv = scanner.nextFloat();
                        compte.verser(mtv);
                        break;
                    case 3:
                        System.out.print("Montant à retirer : ");
                        float mtr = scanner.nextFloat();
                        compte.retirer(mtr);
                        break;
                    case 4:
                        System.out.print("Nouveau découvert autorisé : ");
                        float d = scanner.nextFloat();
                        compte.setDecouvert(d);
                        break;
                }

            } while (choix != 5);

            scanner.close();
        } catch (Exception e) {
            System.out.println("Erreur client : " + e.getMessage());
            e.printStackTrace();
        }
    }
}
