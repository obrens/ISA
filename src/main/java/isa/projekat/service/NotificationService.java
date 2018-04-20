package isa.projekat.service;

import isa.projekat.model.DTO.KorisnikDTO;
import isa.projekat.model.Korisnik;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {
    private JavaMailSender javaMailSender;


    @Autowired
    public NotificationService(JavaMailSender javaMailSender){
        this.javaMailSender=javaMailSender;
    }

    public void sendNotification(Korisnik user) throws MailException{
        SimpleMailMessage mail=new SimpleMailMessage();
        mail.setTo(user.getImejl());
        mail.setSubject("Dobrodošli");
        mail.setText("Uspešno ste se registrovali");

        javaMailSender.send(mail);
    }

}
