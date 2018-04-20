package isa.projekat.service;

import isa.projekat.model.DTO.TipKorisnikaDTO;
import isa.projekat.model.TipKorisnika;
import isa.projekat.repository.TipKorisnikaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TipKorisnikaService {
    @Autowired
    TipKorisnikaRepository tipKorisnikaRepository;

    public TipKorisnikaDTO tipZaSlanje(TipKorisnika tipKorisnika)
    {
        TipKorisnikaDTO tipKorisnikaDTO=new TipKorisnikaDTO();
        tipKorisnikaDTO.setId(tipKorisnika.getId());
        tipKorisnikaDTO.setNaziv(tipKorisnika.getNaziv());
        return tipKorisnikaDTO;
    }
}
