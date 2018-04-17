package isa.projekat.repository;

import isa.projekat.model.Korisnik;
import isa.projekat.model.Prijateljstvo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PrijateljstvoRepository extends JpaRepository<Prijateljstvo, Long> {
	List<Prijateljstvo> findByZahtevni(Korisnik zahtevni);
	
	List<Prijateljstvo> findByPrihvatni(Korisnik prihvatni);
}
