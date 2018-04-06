package isa.projekat.model;

import javax.persistence.*;

@Entity
public class Korisnik {
    @Id
	@Column(name = "korisnik_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column
    private String imejl;
    @Column
    private String lozinka;
    @Column
    private String ime;
    @Column
    private String prezime;
    @Column
    private String grad;
    @Column
    private int brojTelefona;
    
    //public enum Uloga { OBICAN, USTANOVAADMIN, FANZONAADMIN, SISTEMADMIN};
    @ManyToOne
    private TipKorisnika uloga;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
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
	
	public TipKorisnika getUloga() {
		return uloga;
	}
	
	public void setUloga(TipKorisnika uloga) {
		this.uloga = uloga;
	}
}