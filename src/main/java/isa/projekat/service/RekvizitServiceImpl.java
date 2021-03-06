package isa.projekat.service;

import isa.projekat.model.DTO.RekvizitDTO;
import isa.projekat.model.Rekvizit;
import isa.projekat.repository.RekvizitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RekvizitServiceImpl implements RekvizitService {
    @Autowired
    RekvizitRepository rekvizitRepository;

    @Override
	public RekvizitDTO rekvizitZaSlanje(Rekvizit rekvizit){
        RekvizitDTO rekvizitDTO=new RekvizitDTO();
        rekvizitDTO.setId(rekvizit.getId());
        rekvizitDTO.setNaziv(rekvizit.getNaziv());
        rekvizitDTO.setOpis(rekvizit.getOpis());
        rekvizitDTO.setAktivanDo(rekvizit.getAktivanDo());
        rekvizitDTO.setKorisnik(rekvizit.getKorisnik());
        return rekvizitDTO;
    }

    @Override
	public Rekvizit rekvizitZaPrimanje(RekvizitDTO rekvizitDTO){
        Rekvizit rekvizit=new Rekvizit();
        rekvizit.setId(rekvizitDTO.getId());
        rekvizit.setNaziv(rekvizitDTO.getNaziv());
        rekvizit.setOpis(rekvizitDTO.getOpis());
        rekvizit.setAktivanDo(rekvizitDTO.getAktivanDo());
        rekvizit.setKorisnik(rekvizitDTO.getKorisnik());
        return rekvizit;
    }

    @Override
	@Transactional
    public void izmeniRekvizit(RekvizitDTO rekvizitDTO){
        Rekvizit rekvizit = rekvizitRepository.findOne(rekvizitDTO.getId());
        rekvizit.setId(rekvizitDTO.getId());
        rekvizit.setKorisnik(rekvizitDTO.getKorisnik());
        rekvizit.setAktivanDo(rekvizitDTO.getAktivanDo());
        rekvizit.setNaziv(rekvizitDTO.getNaziv());
        rekvizit.setOpis(rekvizitDTO.getOpis());
        rekvizit.setOdobren(rekvizitDTO.isOdobren());
        rekvizit.setOficijalni(rekvizitDTO.isOficijalni());
        rekvizit.setSlika(rekvizitDTO.getSlika());
        rekvizit.setPreuzet(rekvizitDTO.isPreuzet());
        rekvizitRepository.save(rekvizit);
    }

    @Override
	public Rekvizit napraviRekvizit(RekvizitDTO rekvizitDTO){
        Rekvizit rekvizit = new Rekvizit();
        rekvizit.setId(rekvizitDTO.getId());
        rekvizit.setKorisnik(rekvizitDTO.getKorisnik());
        rekvizit.setAktivanDo(rekvizitDTO.getAktivanDo());
        rekvizit.setNaziv(rekvizitDTO.getNaziv());
        rekvizit.setOpis(rekvizitDTO.getOpis());
        rekvizit.setOdobren(rekvizitDTO.isOdobren());
        rekvizit.setOficijalni(rekvizitDTO.isOficijalni());
        rekvizit.setSlika(rekvizitDTO.getSlika());
        rekvizit.setPreuzet(rekvizitDTO.isPreuzet());
        rekvizitRepository.save(rekvizit);
        return rekvizit;
    }

    @Override
	public void izbrisiRekvizit(Long id){
        Rekvizit rekvizit = rekvizitRepository.findById(id);
        rekvizit.setKorisnik(null);
        rekvizit=rekvizitRepository.save(rekvizit);
        rekvizitRepository.delete(rekvizit);
    }
}
