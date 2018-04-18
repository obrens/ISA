package isa.projekat.model.DTO;

import isa.projekat.model.Korisnik;

public class UstanovaDTO {
	private Long id;
	private String naziv;
	private String opis;
	private String adresa;
	private float ocena;
	private boolean vrstaUstanove;
	private Korisnik admin;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getNaziv() { return naziv; }
	
	public void setNaziv(String naziv) { this.naziv = naziv; }
	
	public String getOpis() { return opis; }
	
	public void setOpis(String opis) { this.opis = opis; }
	
	public String getAdresa() { return adresa; }
	
	public void setAdresa(String adresa) { this.adresa = adresa; }
	
	public float getOcena() { return ocena; }
	
	public void setOcena(float ocena) { this.ocena = ocena; }

	public boolean isVrstaUstanove() {
		return vrstaUstanove;
	}

	public void setVrstaUstanove(boolean vrstaUstanove) {
		this.vrstaUstanove = vrstaUstanove;
	}

	public Korisnik getAdmin() {
		return admin;
	}

	public void setAdmin(Korisnik admin) {
		this.admin = admin;
	}
}
