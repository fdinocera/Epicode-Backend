package Esercizio2;

import java.util.*;

public class Interi {

    public static void main(String[] args) {

        //funzione 1
        List<Integer> l1 = getListaOrdinata(10);
        System.out.println("Stampa lista ordinata numeri random");
        System.out.println(l1);

        //funzione2
        List<Integer> l2 = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            int random = new Random().nextInt(101);
            l2.add(random);
        }
        System.out.println(getListaOrdineInverso(l2));

        //funzione3
        stampaPariDispari(l2, true);

    }

    public static List<Integer> getListaOrdinata(int n) {

        List<Integer> lista = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int random = new Random().nextInt(101);
            lista.add(random);
        }

        System.out.println("Stampa lista non ordinata numeri random");
        System.out.println(lista);

        Collections.sort(lista);
        return lista;
    }

    public static List<Integer> getListaOrdineInverso(List<Integer> lista) {
        List<Integer> l1 = new ArrayList<>();
        l1 = lista;

        System.out.println(lista);

        for (int i = lista.size() - 1; i >= 0; i--) {
            l1.add(lista.get(i));
        }
        return l1;
    }

    public static void stampaPariDispari(List<Integer> lista, boolean pari) {

        if (pari) {
            for (int i = 0; i < lista.size(); i += 2) {
                System.out.print(lista.get(i) + " ");
            }
        } else {
            for (int i = 1; i < lista.size(); i += 2) {
                System.out.print(lista.get(i) + " ");
            }
        }
    }
}

