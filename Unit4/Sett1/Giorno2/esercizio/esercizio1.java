import java.util.Scanner;

public class esercizio1 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        //esercizio lunghezza stringa
        System.out.println("Inserisci stringa");
        String s = scanner.nextLine();
        Boolean bPariDispari = stringaPariDispari(s);
        if (bPariDispari) {
            System.out.println("la stringa inserita ha un numero di caratteri pari");
        } else {
            System.out.println("la stringa inserita ha un numero di caratteri dispari");
        }

        //esercizio bisestile
        System.out.println("Inserisci anno");
        int anno = scanner.nextInt();
        Boolean bisestile = annoBisestile(anno);
        if (bisestile) {
            System.out.println("L'anno inserito è bisestile");
        } else {
            System.out.println("L'anno inserito NON è bisestile");
        }
    }

    public static boolean stringaPariDispari(String s) {

        if (s.length() % 2 == 1) {
            //dispari
            return false;
        } else {
            //pari
            return true;
        }
    }

    public static boolean annoBisestile(int anno) {
        //true: anno bisestile
        if (anno % 400 == 0 || (anno % 4 == 0 && anno % 100 != 0)) {
            return true;
        } else {
            return false;
        }
    }
}
