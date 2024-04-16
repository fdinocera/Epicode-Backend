package PackageWhile;

import java.util.Scanner;

public class ClasseWhile {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("inserisci stringa (:q per terminare)");
        String testo = scanner.nextLine();

        while (!testo.equals(":q")) {
            String txt = "";
            int index = 0;

            while (index < testo.length()) {
                char result = testo.charAt(index);
                txt += String.valueOf(result) + ',';
                index++;
            }
            System.out.println(txt);
            System.out.println("inserisci stringa");
            testo = scanner.nextLine();
        };
    }
}
