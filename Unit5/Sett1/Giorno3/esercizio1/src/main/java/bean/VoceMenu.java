package bean;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class VoceMenu {

    @Id
    @GeneratedValue
    int id;

    private String nome;
    private int calorie;
    private Double price;
}
