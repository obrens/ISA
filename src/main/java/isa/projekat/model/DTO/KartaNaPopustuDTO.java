package isa.projekat.model.DTO;

public class KartaNaPopustuDTO {
	private Long id;
	private KartaDTO karta;
	private ProjekcijaDTO projekcija;
	private float cena;
	private boolean rezervisana;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public KartaDTO getKarta() {
		return karta;
	}
	
	public void setKarta(KartaDTO karta) {
		this.karta = karta;
	}
	
	public ProjekcijaDTO getProjekcija() {
		return projekcija;
	}
	
	public void setProjekcija(ProjekcijaDTO projekcija) {
		this.projekcija = projekcija;
	}
	
	public float getCena() {
		return cena;
	}
	
	public void setCena(float cena) {
		this.cena = cena;
	}
	
	public boolean isRezervisana() {
		return rezervisana;
	}
	
	public void setRezervisana(boolean rezervisana) {
		this.rezervisana = rezervisana;
	}
}
