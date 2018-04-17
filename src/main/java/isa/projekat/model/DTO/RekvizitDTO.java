package isa.projekat.model.DTO;

import isa.projekat.model.Korisnik;

import javax.sql.rowset.serial.SerialBlob;
import java.util.Date;

public class RekvizitDTO {
    private Long id;
    private Korisnik korisnik;
    private String naziv;
    private String opis;
    private Date aktivanDo;
    private SerialBlob slika;
    private boolean oficijalni;
    private boolean odobren;

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

    public boolean isOdobren() {
        return odobren;
    }

    public void setOdobren(boolean odobren) {
        this.odobren = odobren;
    }
}
