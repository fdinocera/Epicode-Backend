package bean;

import lombok.Data;

import java.util.List;

@Data
public class MenuApp {

    private List<Pizza> pizze;
    private List<Drink> drinks;
    private List<Topping> toppings;

    public void stampaMenu(){
        System.out.println("Menu");
        System.out.println("Pizze");
        pizze.forEach(pizza -> System.out.println(pizza.getNome() + "    Kcal     " + pizza.getCalorie() + "    Prezzo    " + pizza.getPrice() ));
        System.out.println();

        System.out.println("Drink");
        drinks.forEach(drink -> System.out.println(drink.getNome() + "    Kcal    " + drink.getCalorie() + "    Prezzo    " + drink.getPrice() ));
        System.out.println();

        System.out.println("Toppings");
        toppings.forEach(topping -> System.out.println(topping.getNome() + "    Kcal    " + topping.getCalorie() + "    Prezzo    " + topping.getPrice() ));
        System.out.println();

    }
}
