package Rettangolo;

public class UsaRettangolo {


    public static void main(String[] args) {
        stampaRettangolo();
        System.out.println();
        stampaDueRettangoli();

    }

    public static void stampaRettangolo() {
        Rettangolo rect1 = new Rettangolo(3, 2);

        System.out.println("Area rettangolo (3x2) " + rect1.calcolaArea());
        System.out.println("Perimetro rettangolo (3x2) " + rect1.calcolaPerimetro());
    }

    public static void stampaDueRettangoli() {
        Rettangolo rect1 = new Rettangolo(4, 3);

        System.out.println("Area rettangolo (4x3) " + rect1.calcolaArea());
        System.out.println("Perimetro rettangolo (4x3) " + rect1.calcolaPerimetro());

        Rettangolo rect2 = new Rettangolo(6, 5);

        System.out.println("Area rettangolo (6x5) " + rect2.calcolaArea());
        System.out.println("Perimetro rettangolo (6x5) " + rect2.calcolaPerimetro());


        double sommaAree = rect1.calcolaArea() + rect2.calcolaArea();
        System.out.println("Somma aree rettangoli (4x3) (6x5) " + sommaAree);

        double sommaPerimetri = rect1.calcolaPerimetro() + rect2.calcolaPerimetro();
        System.out.println("Somma perimetri rettangoli (4x3) (6x5) " + sommaPerimetri);
    }
}