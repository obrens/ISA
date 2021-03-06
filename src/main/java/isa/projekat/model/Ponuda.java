package isa.projekat.model;

import javax.persistence.*;

@Entity
public class Ponuda {
    @Id
    @Column (name = "ponuda_id")
    @GeneratedValue
    private long id;

    @ManyToOne
    @JoinColumn
    private Rekvizit oglas;//oficijalni=false;

    @ManyToOne
    @JoinColumn
    private Korisnik ponudjac;

    @Column
    private float cena;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Rekvizit getOglas() {
        return oglas;
    }

    public void setOglas(Rekvizit oglas) {
        this.oglas = oglas;
    }

    public Korisnik getPonudjac() {
        return ponudjac;
    }

    public void setPonudjac(Korisnik ponudjac) {
        this.ponudjac = ponudjac;
    }

    public float getCena() {
        return cena;
    }

    public void setCena(float cena) {
        this.cena = cena;
    }
}
