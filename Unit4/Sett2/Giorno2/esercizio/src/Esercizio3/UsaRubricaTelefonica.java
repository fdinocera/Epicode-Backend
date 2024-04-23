package Esercizio3;

import java.util.HashMap;

public class UsaRubricaTelefonica {

    public static void main(String[] args) {

        RubricaTelefonica rubrica = new RubricaTelefonica();

        rubrica.inserisci("Aldo Bianchi", "0818798789");
        rubrica.inserisci("Mario Rossi", "08187978449");
        rubrica.inserisci("Maria Verdi", "79879784049");

        rubrica.stampaRubrica();

        System.out.println(rubrica.cercaPerNome("Maria Verdi"));

        System.out.println(rubrica.cercaPerTelefono("08187978449"));

        rubrica.rimuoviContatto("Maria Verdi");

        rubrica.stampaRubrica();
    }
}