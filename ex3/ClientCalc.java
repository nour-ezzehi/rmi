import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class ClientCalc {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            Calculatrice calc = (Calculatrice) registry.lookup("CalculatriceService");

            Scanner scanner = new Scanner(System.in);
            int choix;

            do {
                System.out.println("\n--- Menu Calculatrice ---");
                System.out.println("1. Addition");
                System.out.println("2. Soustraction");
                System.out.println("3. Multiplication");
                System.out.println("4. Division");
                System.out.println("5. Quitter");
                System.out.print("Votre choix : ");
                choix = scanner.nextInt();

                if (choix >= 1 && choix <= 4) {
                    System.out.print("Entrez le premier nombre : ");
                    double a = scanner.nextDouble();
                    System.out.print("Entrez le deuxième nombre : ");
                    double b = scanner.nextDouble();

                    switch (choix) {
                        case 1:
                            System.out.println("Résultat : " + calc.addition(a, b));
                            break;
                        case 2:
                            System.out.println("Résultat : " + calc.soustraction(a, b));
                            break;
                        case 3:
                            System.out.println("Résultat : " + calc.multiplication(a, b));
                            break;
                        case 4:
                            try {
                                System.out.println("Résultat : " + calc.division(a, b));
                            } catch (ArithmeticException e) {
                                System.out.println("Erreur : " + e.getMessage());
                            }
                            break;
                    }
                } else if (choix != 5) {
                    System.out.println("Choix invalide !");
                }

            } while (choix != 5);

            scanner.close();
            System.out.println("Fin du programme.");
        } catch (Exception e) {
            System.out.println("Erreur client : " + e.getMessage());
            e.printStackTrace();
        }
    }
}
