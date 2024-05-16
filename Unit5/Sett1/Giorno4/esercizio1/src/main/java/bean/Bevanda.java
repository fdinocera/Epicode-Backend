package bean;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
public class Bevanda extends VoceDiMenu{
    private int ml;
    private String nome;
    private int gradoAlcohol;
}
