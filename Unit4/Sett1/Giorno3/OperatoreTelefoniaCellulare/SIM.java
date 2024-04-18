package OperatoreTelefoniaCellulare;

import java.util.Scanner;

public class SIM {
    private int numeroTelefono;
    private double creditoDisponibile;
    private Chiamata[] ultime5Chiamate;

    public SIM(int numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
    }

    public int getNumeroTelefono() {
        return numeroTelefono;
    }

    public void setNumeroTelefono(int numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
    }

    public double getCreditoDisponibile() {
        return creditoDisponibile;
    }

    public void setCreditoDisponibile(double creditoDisponibile) {
        this.creditoDisponibile = creditoDisponibile;
    }

    public Chiamata[] getUltime5Chiamate() {
        return ultime5Chiamate;
    }

    public void setUltime5Chiamate(Chiamata[] ultime5Chiamate) {
        this.ultime5Chiamate = ultime5Chiamate;
    }

    public void stampaDati() {
        System.out.println("Numero di telefono: " + numeroTelefono);
        System.out.println("Credito disponibile: " + creditoDisponibile);

        for (int i = 0; i < ultime5Chiamate.length; i++) {
            System.out.println("il numero chiamato è " + ultime5Chiamate[i].getNumero() +
                    ", i minuti di conversazione sono " + ultime5Chiamate[i].getMinutiConversazione());
        }
    }
}
