package bean;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@Entity
@ToString(callSuper = true)
public class Pizza extends VoceMenu{
    private List<Topping> toppings;
}
