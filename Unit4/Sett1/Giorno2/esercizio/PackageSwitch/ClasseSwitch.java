package PackageSwitch;

import javax.script.ScriptEngine;
import java.util.Scanner;

public class ClasseSwitch {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("inseri" +
                "sci numero intero");
        int numero = scanner.nextInt();
        switch (numero){
            case 0:
                System.out.println("zero");
                break;
            case 1:
                System.out.println("uno");
                break;
            case 2:
                System.out.println("due");
                break;
            case 3:
                System.out.println("tre");
                break;
            default:
                System.out.println("numero errato");
        }
    }
}
