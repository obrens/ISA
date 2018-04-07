package isa.projekat.model;

import javax.persistence.*;
import javax.sql.rowset.serial.SerialBlob;
import java.util.Date;


@Entity
public class Rekvizit {
    @Id
    @Column (name="rekvizit_id")
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn
    private Korisnik korisnik;

    @Column
    private String naziv;
    @Column
    private String opis;
    @Column
    private Date aktivanDo;
    @Column
    private SerialBlob slika;
    @Column
    private boolean oficijalni;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Korisnik getKorisnik() {
        return korisnik;
    }

    public void setKorisnik(Korisnik korisnik) {
        this.korisnik = korisnik;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public Date getAktivanDo() {
        return aktivanDo;
    }

    public void setAktivanDo(Date aktivanDo) {
        this.aktivanDo = aktivanDo;
    }

    public SerialBlob getSlika() {
        return slika;
    }

    public void setSlika(SerialBlob slika) {
        this.slika = slika;
    }

    public boolean isOficijalni() {
        return oficijalni;
    }

    public void setOficijalni(boolean oficijalni) {
        this.oficijalni = oficijalni;
    }
}
