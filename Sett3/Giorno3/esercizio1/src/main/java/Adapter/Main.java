package Adapter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.GregorianCalendar;

public class Main {
    public static void main(String[] args) {


        Info persona1 = new Info();
        persona1.setCognome("Rossi");
        persona1.setNome("Mario");
        //persona1.setDataDiNascita(new Date(1980,6,2));
        persona1.setDataDiNascita(new GregorianCalendar(2000,6,2).getTime());

        InfoAdapter infoAdapter = new InfoAdapter(persona1);




        UserData userData= new UserData();
        userData.getData(infoAdapter);

        System.out.println(userData);




    }
}
