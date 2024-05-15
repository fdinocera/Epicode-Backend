package it.epicode.esercizio1;

import Enums.StatoOrdine;
import appConfig.AppConfig;
import bean.MenuApp;
import bean.Ordine;
import bean.Tavolo;
import bean.VoceMenu;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
public class MyCommandLinerunners implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {

        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);

        MenuApp menu = ctx.getBean(MenuApp.class);
        menu.stampaMenu();

        Tavolo tavolo = ctx.getBean(Tavolo.class);
        tavolo.stampaTavolo();

        Ordine o1 = new Ordine();
        o1.setNumero(12);
        o1.setTavolo(4);
        o1.setNumeroCoperti(2);
        o1.addVoceMenu(ctx.getBean("Margherita", VoceMenu.class));
        o1.addVoceMenu(ctx.getBean("Hawaiana", VoceMenu.class));
        o1.addVoceMenu(ctx.getBean("Cheese", VoceMenu.class));
        o1.addVoceMenu(ctx.getBean("Vino", VoceMenu.class));
        o1.addVoceMenu(ctx.getBean("Vino", VoceMenu.class));
        o1.addVoceMenu(ctx.getBean("Acqua", VoceMenu.class));
        o1.setCostoCoperto(tavolo.getCostoCoperto());

        o1.setStatoOrdine(StatoOrdine.PRONTO);
        o1.stampaOrdine();
    }
}
