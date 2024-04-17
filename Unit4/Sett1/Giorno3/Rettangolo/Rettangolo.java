package Rettangolo;

public class Rettangolo {
    double larghezza;
    double altezza;

    Rettangolo(double larghezza, double altezza) {
        this.larghezza = larghezza;
        this.altezza = altezza;
    }

    public double calcolaArea() {
        return this.larghezza * this.altezza;
    }

    public double calcolaPerimetro() {
        return this.larghezza * 2 + this.altezza * 2;
    }
}
