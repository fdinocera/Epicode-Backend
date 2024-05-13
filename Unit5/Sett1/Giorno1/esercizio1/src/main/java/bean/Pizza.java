package bean;

import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@ToString(callSuper = true)
public class Pizza extends VoceMenu{
    private List<Topping> toppings;
}
