package isa.projekat;

import isa.projekat.model.Korisnik;
import isa.projekat.model.Ustanova;
import isa.projekat.repository.UstanovaRepository;
import isa.projekat.service.UstanovaService;
import isa.projekat.service.UstanovaServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class UstanovaServiceTest {
	@Mock
	private UstanovaRepository ustanovaRepository;
	
	@InjectMocks
	private UstanovaService ustanovaService;
	
	private List<Ustanova> ustanove;
	
	@Before
	public void setUp() throws Exception {
		ustanovaService = new UstanovaServiceImpl();
		MockitoAnnotations.initMocks(this);
		ustanove = new ArrayList<>();
		//region Popunjavanje ustanova
		Ustanova u1 = new Ustanova();
		u1.setId((long) 1);
		u1.setAdresa("3. maja");
		u1.setOpis("Dobra");
		u1.setVrstaUstanove(true);
		u1.setNaziv("Bioskop");
		u1.setAdmin(new Korisnik());
		ustanove.add(u1);
		
		Ustanova u2 = new Ustanova();
		u2.setId((long) 1);
		u2.setAdresa("3. maja");
		u2.setOpis("Dobra");
		u2.setVrstaUstanove(false);
		u2.setNaziv("Pozoriste");
		u2.setAdmin(new Korisnik());
		ustanove.add(u2);
		//endregion
	}
	
	@Test
	public void testVezaSaBazom() {
		when(ustanovaRepository.findAll()).thenReturn(ustanove);
		/*List<Ustanova> ustanovije = new ArrayList<>();
		ustanovije.add(ustanove.get(0));
		ustanovije.add(ustanove.get(0));*/
		assertArrayEquals(ustanove.toArray(), ustanovaService.svi().toArray());
		verify(ustanovaRepository).findAll();
		//verify(ustanovaRepository).findOne((long) 3);
	}
	
	@Test
	public void testBioskopi() {
		when(ustanovaRepository.findAll()).thenReturn(ustanove);
		List<Ustanova> ustanovije = new ArrayList<>();
		ustanovije.add(ustanove.get(0));
		assertArrayEquals(ustanovije.toArray(), ustanovaService.bioskopi().toArray());
		verify(ustanovaRepository).findAll();
	}
	
	@Test
	public void testPozorista() {
		when(ustanovaRepository.findAll()).thenReturn(ustanove);
		List<Ustanova> ustanovije = new ArrayList<>();
		ustanovije.add(ustanove.get(1));
		assertArrayEquals(ustanovije.toArray(), ustanovaService.pozorista().toArray());
		verify(ustanovaRepository).findAll();
	}
	
	/*@Test
	public void testUstanovaZaSlanje(){
		Ustanova ustanova = ustanove.get(0);
		assertEquals(ustanova.getNaziv(), ustanovaService.ustanovaZaSlanje(ustanova).getNaziv());
	}*/
}
