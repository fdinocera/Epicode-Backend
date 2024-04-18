package Rettangolo;

public class UsaRettangolo {

    public static void main(String[] args) {

        Rettangolo r1 = new Rettangolo(3, 2);
        Rettangolo r2 = new Rettangolo(6, 4);

        stampaRettangolo(r1);
        System.out.println();
        stampaDueRettangoli(r1, r2);
    }

    public static void stampaRettangolo(Rettangolo r) {

        System.out.println("Area rettangolo " + r.calcolaArea());
        System.out.println("Perimetro rettangolo " + r.calcolaPerimetro());
    }

    public static void stampaDueRettangoli(Rettangolo r1, Rettangolo r2) {
        stampaRettangolo(r1);
        stampaRettangolo(r2);

        System.out.println("L'area dei due rettangoli è " + (r1.calcolaArea() + r2.calcolaArea()));
        System.out.println("Il perimetro dei due rettangoli è " + (r1.calcolaPerimetro() + r2.calcolaPerimetro()));
    }
}