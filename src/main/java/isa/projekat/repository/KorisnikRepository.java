package isa.projekat.repository;

import isa.projekat.model.Korisnik;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface KorisnikRepository extends JpaRepository<Korisnik, Long> {
    Korisnik findById(Long id);
    Optional<Korisnik> findByImejl(String username);
}
