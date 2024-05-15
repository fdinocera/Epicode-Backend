package bean;

import Enums.StatoOrdine;
import jakarta.annotation.PostConstruct;
import lombok.Data;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Component
public class Ordine {
    private int tavolo;
    private int numero;
    private StatoOrdine statoOrdine;
    private int numeroCoperti;
    private LocalDateTime oraAcquisizione;
    private List<VoceMenu> listaMenu = new ArrayList<>();
    private Double importoTotale;
    private Double costoCoperto;


    public void addVoceMenu(VoceMenu voce) {
        this.listaMenu.add(voce);
    }


    public double importoTotale() {
        return this.listaMenu.stream().mapToDouble(VoceMenu::getPrice).sum() + costoCoperto * numeroCoperti;
    }

    public void stampaOrdine() {
        System.out.println("Ordine n. " + numero);
        System.out.println("Tavolo " + tavolo);
        //System.out.println("Costo coperto " + costoCoperto);
        System.out.println("Stato ordine " + statoOrdine);
        System.out.println("Numero coperti " + numeroCoperti);
        System.out.println("Importo totale " + importoTotale());
        System.out.println("Costo coperto " + costoCoperto);
    }
}
