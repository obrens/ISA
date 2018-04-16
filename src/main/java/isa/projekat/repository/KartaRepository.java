package isa.projekat.repository;

import isa.projekat.model.Karta;
import isa.projekat.model.Korisnik;
import isa.projekat.model.Projekcija;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface KartaRepository extends JpaRepository<Karta, Long> {
	List<Karta> findByProjekcija(Projekcija projekcija);
	
	List<Karta> findByKorisnik(Korisnik korisnik);
}
