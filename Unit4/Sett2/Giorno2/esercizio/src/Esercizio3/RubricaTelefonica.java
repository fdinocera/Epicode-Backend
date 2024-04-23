package Esercizio3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class RubricaTelefonica {
    private HashMap<String, String> rubrica = new HashMap<>();

    public  void inserisci(String nome, String numero){
        rubrica.put(nome, numero);
    }
}
