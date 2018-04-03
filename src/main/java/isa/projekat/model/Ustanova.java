package isa.projekat.model;

import javax.persistence.*;
import java.util.ArrayList;

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
    @OneToMany
    @JoinColumn(name = "delo_id")
    private ArrayList<Delo> repertoar;
	@OneToMany
	@JoinColumn(name = "sala_id")
    private ArrayList<Sala> sale;
	//TODO opet enum
    public enum VrstaUstanove {POZORISTE, BIOSKOP}
    @Column
    private VrstaUstanove vrstaUstanove;
    
    @OneToOne
    @JoinColumn(name = "korisnik_id")
    private Korisnik admin;
    
    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }
    
    //TODO seteri i geteri
	//TODO U logautu videti korisnika ulogovanog, sta mu se resetuje
}
