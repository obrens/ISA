package isa.projekat.model;


import java.util.ArrayList;

public class Ustanova {
    private String naziv;
    private String adresa;
    private String opis;
    private ArrayList<Delo> repertoar;
    private ArrayList<Sala> sale;

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }
}
