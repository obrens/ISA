package isa.projekat.model;

import javax.sql.rowset.serial.SerialBlob;
import java.time.ZonedDateTime;
import java.util.ArrayList;

public class Delo {
    //region Atributi
    private String naziv;
    private ArrayList<String> glumci;
    private String zanr;
    private String reditelj;
    private float trajanje;
    private SerialBlob poster;
    private String opis;
    private ArrayList<Sala> saleProjekcije;
    private ArrayList<ZonedDateTime> vremenaProjekcije;
    private float cena;
    //endregion
}
