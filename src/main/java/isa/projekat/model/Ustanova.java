package isa.projekat.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Set;

@Entity
public class Ustanova {
	@Id
	@Column(name = "ustanova_id")
	@GeneratedValue
	private Long id;
	
    @Column
    private String naziv;
    @Column
    private String adresa;
    @Column
    private String opis;
<<<<<<< HEAD
    //@OneToMany
    //@JoinColumn(name = "delo_id")
    //private ArrayList<Delo> repertoar;
	//@OneToMany(mappedBy = "ustanova")
    //private ArrayList<Sala> sale;
=======
    @OneToMany
    @JoinColumn(name = "delo_id")
    private Set<Delo> repertoar;
	@OneToMany(mappedBy = "ustanova")
    private Set<Sala> sale;
>>>>>>> 824699de7f3b11c3ad85f97fba9ee88d8fcd7d2d
	
    //public enum VrstaUstanove {POZORISTE, BIOSKOP}
    @Column
    private boolean vrstaUstanove;
    
    @OneToOne
    @JoinColumn(name = "korisnik_id")
    private Korisnik admin;
    
    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }
    
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getAdresa() {
		return adresa;
	}
	
	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}
	
	public String getOpis() {
		return opis;
	}
	
	public void setOpis(String opis) {
		this.opis = opis;
	}
	
<<<<<<< HEAD
	/*public ArrayList<Delo> getRepertoar() {
=======
	public Set<Delo> getRepertoar() {
>>>>>>> 824699de7f3b11c3ad85f97fba9ee88d8fcd7d2d
		return repertoar;
	}
	
	public void setRepertoar(Set<Delo> repertoar) {
		this.repertoar = repertoar;
	}
	
	public Set<Sala> getSale() {
		return sale;
	}
	
	public void setSale(Set<Sala> sale) {
		this.sale = sale;
	}
	*/
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
