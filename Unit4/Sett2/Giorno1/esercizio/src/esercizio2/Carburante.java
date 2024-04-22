package esercizio2;

import java.util.Scanner;

public class Carburante {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        System.out.println("Inserisci numero chilometri percorsi");
        int chilometri = scanner.nextInt();

        System.out.println("Inserisci litri carburante consumati");
        int litriCarburante = scanner.nextInt();

        int consumo=0;

        try {
            consumo = chilometri / litriCarburante;
        }catch (ArithmeticException e){
            System.out.println("Divisione per 0 non ammessa");
        }

        System.out.println("Km/litro:");
        System.out.println(consumo);
    }
}
