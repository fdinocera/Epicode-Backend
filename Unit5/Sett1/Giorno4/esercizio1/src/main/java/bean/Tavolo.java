package bean;

import enums.Stato;
import lombok.Data;

@Data
public class Tavolo {
    private int numero;
    private int maxCoperti;
    private Stato stato;
    private double coperto;

}
