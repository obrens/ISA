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
    //TODO nesto drugo ide za enumeracije
    public enum Uloga { OBICAN, USTANOVAADMIN, FANZONAADMIN, SISTEMADMIN};
    @Column
    private Uloga uloga;
}