package isa.projekat;

import isa.projekat.model.Karta;
import isa.projekat.model.Korisnik;
import isa.projekat.model.Projekcija;
import isa.projekat.repository.KartaRepository;
import isa.projekat.repository.KorisnikRepository;
import isa.projekat.service.KartaServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

public class KartaServiceTest {
	@Mock
	private KartaRepository kartaRepository;
	
	@Mock
	private KorisnikRepository korisnikRepository;
	
	@InjectMocks
	private KartaServiceImpl kartaService;
	
	private List<Karta> karte;
	
	@Before
	public void setUp() throws Exception {
		kartaService = new KartaServiceImpl();
		MockitoAnnotations.initMocks(this);
		karte = new ArrayList<>();
		//region Dodavanje karata
		Karta k1 = new Karta();
		k1.setId((long) 0);
		Projekcija projekcija = new Projekcija();
		projekcija.setDatum(Date.from(Instant.now()));
		k1.setProjekcija(projekcija);
		k1.setOcenaAmbijenta(3);
		k1.setOcenjenaProjekcija(true);
		k1.setOcenjenAmbijent(true);
		k1.setKupac(new Korisnik());
		k1.setRezervisana(true);
		k1.setRed(1);
		k1.setSediste(1);
		karte.add(k1);
		
		Karta k2 = new Karta();
		k2.setId((long) 1);
		k2.setProjekcija(projekcija);
		k2.setOcenaProjekcije(0);
		k2.setOcenaAmbijenta(0);
		k2.setOcenjenaProjekcija(false);
		k2.setOcenjenAmbijent(false);
		k2.setKupac(new Korisnik());
		k2.setRezervisana(false);
		k2.setRed(2);
		k2.setSediste(2);
		karte.add(k2);
		//endregion
		when(korisnikRepository.findOne(any(Long.class))).thenReturn(new Korisnik());
	}
	
	@Test
	public void testRezervisi1() {
		when(kartaRepository.findOne((long) 0)).thenReturn(karte.get(0));
		assertEquals(false, kartaService.rezervisiKartu((long) 0, (long) 0));
	}
	
	@Test
	public void testRezervisi2() {
		when(kartaRepository.findOne((long) 0)).thenReturn(karte.get(1));
		assertEquals(true, kartaService.rezervisiKartu((long) 0, (long) 0));
	}
	
	@Test
	public void rezervacijeKorisnika() {
		when(kartaRepository.findByKupac(any(Korisnik.class))).thenReturn(karte);
		assertArrayEquals(new Karta[0], kartaService.rezervacijeKorisnika((long) 0).toArray());
	}
	
	/*@Test
	public void poseteKorisnika() {
		when(kartaRepository.findByKupac(any(Korisnik.class))).thenReturn(karte);
		assertArrayEquals(new Karta[0], kartaService.poseteKorisnika((long) 0).toArray());
	}*/
}
