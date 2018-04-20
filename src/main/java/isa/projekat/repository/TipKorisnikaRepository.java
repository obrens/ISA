package isa.projekat.repository;

import isa.projekat.model.Rekvizit;
import isa.projekat.model.TipKorisnika;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TipKorisnikaRepository extends JpaRepository<TipKorisnika,Long> {
    TipKorisnika findById(Long id);
}
