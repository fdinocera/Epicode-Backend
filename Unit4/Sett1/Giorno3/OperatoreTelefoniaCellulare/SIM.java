package OperatoreTelefoniaCellulare;

import java.util.Scanner;

public class SIM {
    private String numeroTelefono;
    private double creditoDisponibile;
    private String[] ultime5Chiamate = new String[5];

    SIM(String numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
    }

    public void stampaDati() {
        System.out.println("Numero di telefono: " + numeroTelefono);
        System.out.println("Credito disponibile: " + creditoDisponibile);

        for (int i = 0; i < ultime5Chiamate.length; i++) {
            System.out.println("chiamata: " + ultime5Chiamate[i]);
        }
    }
}
