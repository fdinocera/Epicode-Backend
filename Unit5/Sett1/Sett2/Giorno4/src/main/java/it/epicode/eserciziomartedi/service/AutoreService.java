package it.epicode.eserciziomartedi.service;

import com.cloudinary.Cloudinary;
import it.epicode.eserciziomartedi.DTO.AutoreDto;
import it.epicode.eserciziomartedi.exception.AutoreNonTrovatoException;

import it.epicode.eserciziomartedi.model.Autore;
import it.epicode.eserciziomartedi.repository.AutoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class AutoreService {

    @Autowired
    private AutoreRepository autoreRepository;

    private PostService postService;

    @Autowired
    private Cloudinary cloudinary;

    @Autowired
    private JavaMailSenderImpl javaMailSender;

    public List<Autore> getAllAutori() {
        return autoreRepository.findAll();
    }

    public String creaAutore(AutoreDto autoreDto) {
        Autore autore = new Autore();
        autore.setNome(autoreDto.getNome());
        autore.setCognome(autoreDto.getCognome());
        autore.setEmail(autoreDto.getEmail());
        autore.setDataDiNascita(autoreDto.getDataDiNascita());
        autore.setAvatar("https://ui-avatars.com/api/?name=" + autore.getNome() + "+" + autore.getCognome());

        autoreRepository.save(autore);
        sendMail("fdinocera@libero.it");
        return "Autore creato con successo id=" + autore.getId();
    }

    public Optional<Autore> getAutoreById(int id) {
        return autoreRepository.findById(id);
    }


    public Autore updateAutore(int id, AutoreDto autoreDto) throws AutoreNonTrovatoException {

        Optional<Autore> autoreOpt = getAutoreById(id);

        if (autoreOpt.isPresent()) {
            Autore autore = autoreOpt.get();
            autore.setNome(autoreDto.getNome());
            autore.setCognome(autoreDto.getCognome());
            autore.setDataDiNascita(autoreDto.getDataDiNascita());
            autore.setEmail(autoreDto.getEmail());
            //autore.setAvatar(autoreDto.getAvatar());

            return autoreRepository.save(autore);
        } else {
            throw new AutoreNonTrovatoException("Autore non trovato id=" + id);
        }
    }

    public String deleteAutore(int id) throws AutoreNonTrovatoException {
        Optional<Autore> autoreOpt = getAutoreById(id);
        if (autoreOpt.isPresent()) {
            autoreRepository.delete(autoreOpt.get());
            //autori.remove(autoreOpt.get());
            return "Autore cancellato id=" + id;
        } else {
            throw new AutoreNonTrovatoException("Autore non trovato id=");
        }
    }
    private void sendMail(String email) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email);
        message.setSubject("Registrazione Servizio rest");
        message.setText("Registrazione al servizio rest avvenuta con successo");

        javaMailSender.send(message);
    }

    public String patchFotoAutore(int id, MultipartFile foto) throws IOException {
        Optional<Autore> autoreOptional= getAutoreById(id);

        if (autoreOptional.isPresent()){
            String url = (String) cloudinary.uploader().upload(foto.getBytes(), Collections.emptyMap()).get("url");
            Autore autore = autoreOptional.get();
            autore.setFoto(url);
            autoreRepository.save(autore);
            return "Autore con id=" + id + " aggiornato correttamente con la foto inviata";
        }else{
            throw new AutoreNonTrovatoException("Autore con id=" + id + " non trovato");
        }
    }
}
