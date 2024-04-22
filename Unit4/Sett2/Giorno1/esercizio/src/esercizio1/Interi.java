package esercizio1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.DoubleSummaryStatistics;
import java.util.Random;
import java.util.Scanner;

public class Interi {
    Logger logger = LoggerFactory.getLogger("logger1");

    public static void main(String[] args) {
        Random numrtoRandom = new Random();
        int[] interi = new int[5];

        for (int i = 0; i < interi.length; i++) {
            interi[i] = numrtoRandom.nextInt(10) + 1;
            System.out.println(interi[i]);
        }

        Scanner scanner = new Scanner(System.in);
        int posizione;

        while (true) {

            try {
                System.out.println("Inserisci una posizione (da 1 a 5), 0 per finire");
                posizione = scanner.nextInt();
                if (posizione == 0) break;

                System.out.println("Inserisci un numero (da 1 a 10)");
                int numeroUtente = scanner.nextInt();

                interi[posizione - 1] = numeroUtente;

                for (int i = 0; i < interi.length; i++) {
                    System.out.println(interi[i]);
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("La posizione deve essere compresa tra 1 e 5");
            } catch (Exception e) {
                System.out.println("Errore generico");
                scanner.nextLine();
            }
        }
    }
}
