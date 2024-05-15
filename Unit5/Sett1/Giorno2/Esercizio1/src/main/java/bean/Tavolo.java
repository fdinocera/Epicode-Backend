package bean;

import Enums.StatoTavolo;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Data
@Component

public class Tavolo {
    private int numero;
    private int numeroCopertiMax;
    private StatoTavolo statoTavolo;
    private Double costoCoperto;

    public void stampaTavolo() {
        System.out.println("Tavolo n. " + numero);
        System.out.println("Max coperti: " + numeroCopertiMax);

        if (statoTavolo == StatoTavolo.LIBERO) {
            System.out.println("Stato tavolo: libero");
        } else {
            System.out.println("Stato tavolo: occupato");
        }
        System.out.println();
       //System.out.println("costo coperto***:" + costoCoperto);
    }
}
