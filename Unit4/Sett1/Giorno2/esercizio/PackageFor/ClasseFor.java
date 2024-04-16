package PackageFor;

import java.util.Scanner;

public class ClasseFor {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("inserisci numero intero");
        int numero = scanner.nextInt();

        for (int i = numero; i > -1; i--) {
            System.out.println(i);
        }
    }
}
