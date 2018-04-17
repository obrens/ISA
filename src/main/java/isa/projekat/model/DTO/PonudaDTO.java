package isa.projekat.model.DTO;

import isa.projekat.model.Korisnik;
import isa.projekat.model.Rekvizit;

public class PonudaDTO {

    private long id;
    private Rekvizit oglas;
    private Korisnik ponudjac;
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
