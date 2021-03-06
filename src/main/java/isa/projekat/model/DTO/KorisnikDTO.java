package isa.projekat.model.DTO;

import isa.projekat.model.TipKorisnika;

import java.util.Set;

public class KorisnikDTO {
	private Long id;
	private String imejl;
	private String lozinka;
	private String ime;
	private String prezime;
	private String grad;
	private Integer brojTelefona;
	private Set<TipKorisnika> uloge;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setBrojTelefona(Integer brojTelefona) {
		this.brojTelefona = brojTelefona;
	}

	public String getImejl() {
		return imejl;
	}
	
	public void setImejl(String imejl) {
		this.imejl = imejl;
	}
	
	public String getLozinka() {
		return lozinka;
	}
	
	public void setLozinka(String lozinka) {
		this.lozinka = lozinka;
	}
	
	public String getIme() {
		return ime;
	}
	
	public void setIme(String ime) {
		this.ime = ime;
	}
	
	public String getPrezime() {
		return prezime;
	}
	
	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}
	
	public String getGrad() {
		return grad;
	}
	
	public void setGrad(String grad) {
		this.grad = grad;
	}
	
	public int getBrojTelefona() {
		return brojTelefona;
	}
	
	public void setBrojTelefona(int brojTelefona) {
		this.brojTelefona = brojTelefona;
	}

	public Set<TipKorisnika> getUloge() {
		return uloge;
	}

	public void setUloge(Set<TipKorisnika> uloge) {
		this.uloge = uloge;
	}
}
