package Rettangolo;

public class Rettangolo {
    double larghezza;
    double altezza;

    public Rettangolo(double larghezza, double altezza) {
        this.larghezza = larghezza;
        this.altezza = altezza;
    }

    public double getLarghezza() {
        return larghezza;
    }

    public void setLarghezza(double larghezza) {
        this.larghezza = larghezza;
    }

    public double getAltezza() {
        return altezza;
    }

    public void setAltezza(double altezza) {
        this.altezza = altezza;
    }

    public double calcolaArea() {
        return this.larghezza * this.altezza;
    }

    public double calcolaPerimetro() {
        return this.larghezza * 2 + this.altezza * 2;
    }
}
