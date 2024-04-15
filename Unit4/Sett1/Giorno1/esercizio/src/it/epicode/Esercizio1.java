package it.epicode;

public class Esercizio1 {

    public static void main(String[] args) {

        // 1)
        int x = moltiplica(3,2);

        // 2)
        String nuovaStringa = concatena("Epicode", 1);

        // 3)
        String [] alfabeto = {"alfa", "beta", "gamma", "delta", "eta"};
        String [] nuovoArray = inserisciInArray(alfabeto, "omega");
    }

    public static int moltiplica(int a, int b){
        return a*b;
    }

    public static String concatena(String s, int i){
        return s + i;
    }

    public static String[] inserisciInArray(String elems[], String s){
        String [] nuovoArray = {elems[0], elems[1], s, elems[2], elems[3], elems[4]};
        return nuovoArray;
    }
}
