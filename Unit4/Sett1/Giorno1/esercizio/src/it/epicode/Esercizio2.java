package it.epicode;

import java.util.Scanner;

public class Esercizio2 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("inserisci stringa1: ");
        String s1 = scanner.next();

        System.out.println("inserisci stringa2: ");
        String s2 = scanner.next();

        System.out.println("inserisci stringa3: ");
        String s3 = scanner.next();

        System.out.println(s1 + s2 + s3);
        System.out.println(s3 + s2 + s1);
    }
}
