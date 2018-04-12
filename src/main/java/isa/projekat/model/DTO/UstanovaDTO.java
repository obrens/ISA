package isa.projekat.model.DTO;

public class UstanovaDTO {
	private String naziv;
	private String opis;
	private String adresa;
	private float ocena;
	
	public String getNaziv() { return naziv; }
	
	public void setNaziv(String naziv) { this.naziv = naziv; }
	
	public String getOpis() { return opis; }
	
	public void setOpis(String opis) { this.opis = opis; }
	
	public String getAdresa() { return adresa; }
	
	public void setAdresa(String adresa) { this.adresa = adresa; }
	
	public float getOcena() { return ocena; }
	
	public void setOcena(float ocena) { this.ocena = ocena; }
}
