package it.epicode.esercizio1;

import bean.Drink;
import bean.Ordine;
import bean.Tavolo;
import bean.VoceMenu;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.print.attribute.standard.OrientationRequested;

@SpringBootTest
class Esercizio1ApplicationTests {

    static ApplicationContext ctx;

    @BeforeAll
    public static void accediAlContesto() {
        ctx = new AnnotationConfigApplicationContext(Esercizio1.class);
        System.out.println("Accesso al contesto avvenuto");
    }

    @Test
    void verificaNumeroTavolo() {
//        Tavolo tavolo1 = ctx.getBean(Tavolo.class);
//        Assertions.assertEquals(5, tavolo1.getNumeroCopertiMax());
		Drink vino = ctx.getBean("Vino", Drink.class);
		Assertions.assertNotNull(vino);


    }


    @AfterAll
    public static void chiudiContesto() {
        ctx = null;
        System.out.println("Contesto chiuso");
    }
}
