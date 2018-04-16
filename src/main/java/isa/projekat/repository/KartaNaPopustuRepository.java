package isa.projekat.repository;

import isa.projekat.model.Karta;
import isa.projekat.model.KartaNaPopustu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KartaNaPopustuRepository extends JpaRepository<KartaNaPopustu, Long> {
	KartaNaPopustu findByKarta(Karta karta);
}
