package isa.projekat;

import isa.projekat.controller.UstanovaController;
import isa.projekat.service.UstanovaService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class UstanovaControllerTest {
	@Mock
	private UstanovaService ustanovaService;
	
	@InjectMocks
	private UstanovaController ustanovaController;
	
	@Before
	public void setUp() throws Exception {
		
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void test() {
		
		//assertion here
	}
}
