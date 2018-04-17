package isa.projekat.repository;

import isa.projekat.model.Delo;
import isa.projekat.model.Ponuda;
import isa.projekat.model.Ustanova;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.Id;
import java.util.List;

public interface PonudaRepository extends JpaRepository<Delo,Long> {
    Ponuda findById(Long id);

    List<Delo> findByUstanova(Ustanova ustanova);
}
