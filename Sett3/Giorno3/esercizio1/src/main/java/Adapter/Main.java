package Adapter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class Main {
    public static void main(String[] args) {


        Info persona1 = new Info();
        persona1.setCognome("Rossi");
        persona1.setNome("Mario");
        persona1.setDataDiNascita(new Date(1980,6,2));

        InfoAdapter infoAdapter = new InfoAdapter(persona1);




        System.out.println(infoAdapter.getEta());
        System.out.println(infoAdapter.getNomeCompleto());

        System.out.println(infoAdapter.toString());

    }
}
