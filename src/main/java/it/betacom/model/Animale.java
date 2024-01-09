package it.betacom.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Animale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long matricola;

    @Column(nullable = false)
    private String nomeAnimale;

    private LocalDate dataAcquisto;

    @Column(nullable = false)
    private double prezzo;

    @Column(nullable = false)
    private String tipoAnimale;

    public Animale() {}

    public Animale(String nomeAnimale, double prezzo, String tipoAnimale) {
        this.nomeAnimale = nomeAnimale;
        this.prezzo = prezzo;
        this.tipoAnimale = tipoAnimale;
    }

    public Long getMatricola() {
        return matricola;
    }

    public void setMatricola(Long matricola) {
        this.matricola = matricola;
    }

    public String getNomeAnimale() {
        return nomeAnimale;
    }

    public void setNomeAnimale(String nomeAnimale) {
        this.nomeAnimale = nomeAnimale;
    }

    public LocalDate getDataAcquisto() {
        return dataAcquisto;
    }

    public void setDataAcquisto(LocalDate dataAcquisto) {
        this.dataAcquisto = dataAcquisto;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }

    public String getTipoAnimale() {
        return tipoAnimale;
    }

    public void setTipoAnimale(String tipoAnimale) {
        this.tipoAnimale = tipoAnimale;
    }

}
