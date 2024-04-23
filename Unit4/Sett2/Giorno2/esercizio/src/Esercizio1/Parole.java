package Esercizio1;

import java.util.*;

public class Parole {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<String> paroleDistinte = new HashSet<>();

        System.out.println("Inserisci un numero");
        int nParole = scanner.nextInt();
        scanner.nextLine();

        //parole duplicate
        List<String> paroleDuplicate = new ArrayList<>();


        for (int i = 0; i < nParole; i++) {
            System.out.println("Inserisci una parola");
            String parola = scanner.nextLine();

            if (!paroleDistinte.add(parola)) {
                paroleDuplicate.add(parola);
            }
        }

        //stampa parole duplicate
        System.out.println("Elenco parole duplicate: " + paroleDuplicate);

        //stampa numero parole distinte
        System.out.println("Numero parole distinte: " + paroleDistinte.size());

        //stampa parole distinte
        System.out.println("Elenco parole distinte: " + paroleDistinte);
    }
}
