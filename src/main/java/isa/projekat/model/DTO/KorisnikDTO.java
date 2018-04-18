package isa.projekat.model.DTO;

public class KorisnikDTO {
	private String imejl;
	private String lozinka;
	private String ime;
	private String prezime;
	private String grad;
	private Integer brojTelefona;
	
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
}
