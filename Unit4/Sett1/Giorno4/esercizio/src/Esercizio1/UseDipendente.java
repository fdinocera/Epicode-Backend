package Esercizio1;

public class UseDipendente {

    public static void main(String[] args) {

//        Dipendente d1 = new Dipendente("1a2b", 1847.44, Dipendente.Dipartimento.VENDITE);
//        Dipendente d2 = new Dipendente("2a2b", 1947.44, Dipendente.Dipartimento.VENDITE);
//        Dipendente d3 = new Dipendente("3a2b", 1955.44, Dipendente.Dipartimento.VENDITE);


//        d1.setDipartimento(Dipendente.Dipartimento.AMMINISTRAZIONE);

        Dipendente[] dipendenti = new Dipendente[3];

//        dipendenti[0] = d1;
//        dipendenti[1] = d2;
//        dipendenti[2] = d3;

        for (int i = 0; i < dipendenti.length; i++) {
            System.out.println(dipendenti[i].getMatricola());
        }
    }
}
