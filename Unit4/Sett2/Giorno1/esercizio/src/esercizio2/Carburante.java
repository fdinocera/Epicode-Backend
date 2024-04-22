package esercizio2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

public class Carburante {

    //TRACE<DEBUG<INFO<WARN<ERROR
    static Logger logger = LoggerFactory.getLogger("logger1");


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Inserisci numero chilometri percorsi");
        int chilometri = scanner.nextInt();

        System.out.println("Inserisci litri carburante consumati");
        int litriCarburante = scanner.nextInt();

        int consumo = 0;

        try {
            consumo = chilometri / litriCarburante;
        } catch (ArithmeticException e) {
            System.out.println("Divisione per 0 non ammessa");
            logger.info("Divisione per 0 non ammessa");
        }

        System.out.println("Km/litro:");
        System.out.println(consumo);
    }
}
