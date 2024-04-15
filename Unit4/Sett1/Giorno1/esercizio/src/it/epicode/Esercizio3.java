package it.epicode;

import java.util.Scanner;

public class Esercizio3 {

    public static void main(String[] args) {

        //scanner
        Scanner scanner = new Scanner(System.in);

        //calcola perimetro
        System.out.println(" *** Calcolo perimetro rettangolo ***");
        System.out.println("Inserisci lato1: ");
        Float l1 = scanner.nextFloat();
        System.out.println("Inserisci lato2: ");
        Float l2 = scanner.nextFloat();
        System.out.println("Perimetro rettangolo: " + perimetroRettangolo(l1, l2));

        //pari dispari
        System.out.println(" *** Calcolo pari dispari ***");
        System.out.println("Inserisci un numero intero: ");
        int n = scanner.nextInt();
        System.out.println(pariDispari(n));

        //area triangolo formula Erone
        System.out.println(" *** Calcolo area triangolo formula Erone ***");
        System.out.println("Inserisci lato1: ");
        double a = scanner.nextDouble();
        System.out.println("Inserisci lato2: ");
        double b = scanner.nextDouble();
        System.out.println("Inserisci lato3: ");
        double c = scanner.nextDouble();
        System.out.println("Area triangolo: " + areaTriangolo(a, b, c));
    }

    public static float perimetroRettangolo(float lato1, float lato2){
        return lato1 * 2 + lato2 * 2;
    }

    public static int pariDispari(int n){
        return n % 2;
    }

    public static double areaTriangolo(double l1, double l2, double l3){
        Double p = (l1 + l2 + l3) / 2;
        double area = Math.sqrt(p * (p - l1) * (p - l2) * (p - l3));
        return area;

    }
}
