package isa.projekat.service;

import isa.projekat.model.DTO.RekvizitDTO;
import isa.projekat.model.Rekvizit;
import isa.projekat.repository.RekvizitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RekvizitService {
    @Autowired
    RekvizitRepository rekvizitRepository;

    public RekvizitDTO rekvizitZaSlanje(Rekvizit rekvizit){
        RekvizitDTO rekvizitDTO=new RekvizitDTO();
        rekvizitDTO.setId(rekvizit.getId());
        rekvizitDTO.setNaziv(rekvizit.getNaziv());
        rekvizitDTO.setOpis(rekvizit.getOpis());
        rekvizitDTO.setAktivanDo(rekvizit.getAktivanDo());
        rekvizitDTO.setKorisnik(rekvizit.getKorisnik());
        return rekvizitDTO;
    }
}
