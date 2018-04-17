package isa.projekat.repository;

import isa.projekat.model.Ponuda;
import isa.projekat.model.Rekvizit;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PonudaRepository extends JpaRepository<Ponuda,Long> {
    Ponuda findById(Long id);

    List<Ponuda> findByOglas(Rekvizit rekvizit);
}
