package it.epicode.esercizio1;

import appConfig.AppConfig;
import bean.Drink;
import bean.MenuApp;
import bean.Pizza;
import bean.VoceMenu;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

@SpringBootApplication
public class Esercizio1Application {

    public static void main(String[] args) {

        SpringApplication.run(Esercizio1Application.class, args);
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);

        MenuApp menu = ctx.getBean(MenuApp.class);

        menu.stampaMenu();




    }
}
