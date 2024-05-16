import bean.Bevanda;
import bean.Ingrediente;
import bean.Pizza;
import bean.VoceDiMenu;
import it.epicode.esercizio1.Esercizio1Application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;
import service.VoceDiMenuService;

@Component
public class Runner implements CommandLineRunner {

    @Autowired
    private VoceDiMenuService voceDiMenuService;

    @Override
    public void run(String... args) throws Exception {

        ApplicationContext ctx = new AnnotationConfigApplicationContext(Esercizio1Application.class);

        Bevanda b1 = ctx.getBean("birra", Bevanda.class);
        voceDiMenuService.salvaVoceDiMenu(b1);

        Bevanda b2 = ctx.getBean("acqua", Bevanda.class);
        voceDiMenuService.salvaVoceDiMenu(b2);

        Bevanda b3 = ctx.getBean("cocaCola", Bevanda.class);
        voceDiMenuService.salvaVoceDiMenu(b3);

        Ingrediente i1 = ctx.getBean("mozzarella", Ingrediente.class);
        voceDiMenuService.salvaVoceDiMenu(i1);

        Ingrediente i2 = ctx.getBean("pomodoro", Ingrediente.class);
        voceDiMenuService.salvaVoceDiMenu(i2);

        Ingrediente i3 = ctx.getBean("salame", Ingrediente.class);
        voceDiMenuService.salvaVoceDiMenu(i3);

        Pizza p1 = ctx.getBean("margherita", Pizza.class);
        voceDiMenuService.salvaVoceDiMenu(p1);

        Pizza p2 = ctx.getBean("diavola", Pizza.class);
        voceDiMenuService.salvaVoceDiMenu(p2);

        System.out.println(voceDiMenuService.getPizzePriceLessThan(6));
        System.out.println(voceDiMenuService.countPizza());
    }
}
