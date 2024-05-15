package appConfig;

import Enums.StatoOrdine;
import Enums.StatoTavolo;
import bean.*;

import org.springframework.aot.generate.ValueCodeGenerationException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

import java.awt.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Configuration
@PropertySource("application.properties")
public class AppConfig {

    @Value("${Esercizio1.costo.coperto}")
    String costoCoperto;

    @Bean("Margherita")
    public Pizza getMargherita() {
        Pizza margherita = new Pizza();
        margherita.setNome("Pizza Margherita (tomato, cheese)");
        margherita.setPrice(4.99);
        margherita.setCalorie(1104);
        margherita.setToppings(List.of(getCheese()));
        return margherita;
    }

    @Bean("Hawaiana")
    public Pizza getHawaiana() {
        Pizza pizza = new Pizza();
        pizza.setNome("Hawaiian Pizza (tomato, cheese, ham, pineapple )");
        pizza.setPrice(6.49);
        pizza.setCalorie(1024);
        pizza.setToppings(List.of(getCheese(), getHam(), getPineapple()));
        return pizza;
    }

    @Bean("Salami")
    public Pizza getPizzaSalami() {
        Pizza salami = new Pizza();
        salami.setNome("Salami Pizza (tomato, cheese, salami)");
        salami.setPrice(6.49);
        salami.setCalorie(1024);
        salami.setToppings(List.of(getCheese(), getSalami()));
        return salami;
    }

    @Bean("Cheese")
    public Topping getCheese() {
        Topping cheese = new Topping();
        cheese.setNome("Cheese");
        cheese.setCalorie(92);
        cheese.setPrice(0.69);
        return cheese;
    }

    @Bean("Ham")
    public Topping getHam() {
        Topping ham = new Topping();
        ham.setNome("Ham");
        ham.setCalorie(35);
        ham.setPrice(0.99);
        return ham;
    }

    @Bean("Pineapple")
    public Topping getPineapple() {
        Topping pineapple = new Topping();
        pineapple.setNome("Pineapple");
        pineapple.setCalorie(24);
        pineapple.setPrice(0.79);
        return pineapple;
    }

    @Bean("Salame")
    public Topping getSalami() {
        Topping salami = new Topping();
        salami.setNome("Salami");
        salami.setCalorie(86);
        salami.setPrice(0.99);
        return salami;
    }

    @Bean("Cipolle")
    public Topping getOnions() {
        Topping onions = new Topping();
        onions.setNome("Onions");
        onions.setCalorie(86);
        onions.setPrice(0.99);
        return onions;
    }

    @Bean("Limonata")
    public Drink getLimonata() {
        Drink limonata = new Drink();
        limonata.setNome("Limonata (0.33l)");
        limonata.setPrice(1.29);
        limonata.setCalorie(128);
        return limonata;
    }

    @Bean("Acqua")
    public Drink getAcqua() {
        Drink acqua = new Drink();
        acqua.setNome("Acqua");
        acqua.setPrice(1.29);
        acqua.setCalorie(0);
        return acqua;
    }

    @Bean("Vino")
    public Drink getVino() {
        Drink vino = new Drink();
        vino.setNome("Vino");
        vino.setPrice(7.49);
        vino.setCalorie(607);
        return vino;
    }

    @Bean
    public MenuApp getMenu(){
        MenuApp menu = new MenuApp();

        ArrayList<Pizza> pizze =new ArrayList<>();
        pizze.add(getMargherita());
        pizze.add(getHawaiana());
        pizze.add(getPizzaSalami());

        ArrayList<Drink> drinks = new ArrayList<>();
        drinks.add(getVino());
        drinks.add(getAcqua());
        drinks.add(getLimonata());

        ArrayList<Topping> toppings= new ArrayList<>();
        toppings.add(getCheese());
        toppings.add((getPineapple()));
        toppings.add((getHam()));
        toppings.add(getOnions());
        toppings.add(getSalami());

        menu.setPizze(pizze);
        menu.setDrinks(drinks);
        menu.setToppings(toppings);

        return menu;
    }

    @Bean("Tavolo1")
    public Tavolo getTavolo1(){
        Tavolo tavolo = new Tavolo();
        tavolo.setStatoTavolo(StatoTavolo.LIBERO);
        tavolo.setNumero(4);
        tavolo.setNumeroCopertiMax(5);
        tavolo.setCostoCoperto(Double.valueOf(costoCoperto));
        return tavolo;
    }
}
