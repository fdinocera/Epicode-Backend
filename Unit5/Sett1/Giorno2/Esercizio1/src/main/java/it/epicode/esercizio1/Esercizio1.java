package it.epicode.esercizio1;

import Enums.StatoOrdine;
import appConfig.AppConfig;
import bean.MenuApp;
import bean.Ordine;
import bean.Tavolo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.time.LocalDateTime;

@SpringBootApplication
public class Esercizio1 {
    public static void main(String[] args) {
        SpringApplication.run(Esercizio1.class, args);
    }
}
