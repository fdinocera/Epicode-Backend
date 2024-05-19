package it.epicode.progetto;

import it.epicode.progetto.ENUMS.TipoPostazione;
import it.epicode.progetto.entities.Edificio;
import it.epicode.progetto.entities.Postazione;
import it.epicode.progetto.entities.Prenotazione;
import it.epicode.progetto.entities.Utente;
import it.epicode.progetto.repositories.PrenotazioneRepository;
import it.epicode.progetto.repositories.UtenteRepository;
import it.epicode.progetto.service.EdificioService;
import it.epicode.progetto.service.PostazioneService;
import it.epicode.progetto.service.PrenotazioneService;
import it.epicode.progetto.service.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
@PropertySource("application.properties")
public class Runner implements CommandLineRunner {

    @Autowired
    private UtenteService utenteService;

    @Autowired
    private EdificioService edificioService;

    @Autowired
    private PostazioneService postazioneService;

    @Autowired
    private PrenotazioneService prenotazioneService;

    @Override
    public void run(String... args) throws Exception {

        ApplicationContext ctx = new AnnotationConfigApplicationContext(ProgettoApplication.class);

        Utente utente1 = new Utente();
        utente1.setNomeCompleto("Mario Rossi");
        utente1.setEmail("mario@rossi.com");
        utente1.setUsername("mrossi");
        utenteService.creaUtente(utente1);

        Edificio edificio1 = new Edificio();
        edificio1.setIndirizzo("Via Garibaldi, 34");
        edificio1.setCitta("Verona");
        edificio1.setNome("Palazzo Fano");
        edificioService.creaEdificio(edificio1);

        Postazione postazione1 = new Postazione();
        postazione1.setMaxOccupanti(25);
        postazione1.setDescrizione("Sala conferenze");
        postazione1.setEdificio(edificio1);
        postazione1.setTipoPostazione(TipoPostazione.SALA_RIUNIONI);
        postazioneService.creaPostazione(postazione1);

        Prenotazione prenotazione1 = new Prenotazione();
        prenotazione1.setDataPrenotazione(LocalDate.of(2024, 6, 1));
        prenotazione1.setUtente(utente1);
        prenotazione1.setPostazione(postazione1);
        prenotazioneService.creaPrenotazione(prenotazione1);


        Prenotazione prenotazione2 = new Prenotazione();
        prenotazione2.setDataPrenotazione(LocalDate.of(2024, 6, 2));
        prenotazione2.setUtente(utente1);
        prenotazione2.setPostazione(postazione1);
        if (!prenotazioneService.existsPrenotazioneByUtenteIdAndData(1L, LocalDate.of(2024, 6, 2))) {
            prenotazioneService.creaPrenotazione(prenotazione2);
        }

        System.out.println("elenco prenotazioni Mario Rossi 01/06/2024");
        System.out.println(prenotazioneService.findByUtenteAndData(utente1, LocalDate.of(2024, 6, 1)));

        System.out.println("elenco postazioni di tipo SALA_RIUNIONI a Verona ");
        System.out.println(postazioneService.findByTipoPostazioneAndCitta(TipoPostazione.SALA_RIUNIONI, "Verona"));

        System.out.println("Controlla se esiste già prenotazione per utente e data");
        System.out.println(prenotazioneService.existsPrenotazioneByUtenteIdAndData(1L, LocalDate.of(2024, 6, 1)));



    }
}
