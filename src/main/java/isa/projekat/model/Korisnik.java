package isa.projekat.model;

import javax.persistence.*;
import java.util.Set;

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
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(joinColumns = @JoinColumn(name = "korisnik_id"),inverseJoinColumns = @JoinColumn(name="tipkorisnika_id"))
    private Set<TipKorisnika> uloge;

    public Korisnik(){

    }

    public Korisnik(Korisnik korisnik) {
        this.imejl = korisnik.imejl;
        this.lozinka = korisnik.lozinka;
        this.ime = korisnik.ime;
        this.brojTelefona = korisnik.brojTelefona;
        this.grad = korisnik.grad;
        this.prezime = korisnik.prezime;
        this.uloge = korisnik.uloge;
        this.id = korisnik.id;
    }

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

    public Set<TipKorisnika> getUloge() {
        return uloge;
    }

    public void setUloge(Set<TipKorisnika> uloge) {
        this.uloge = uloge;
    }
}