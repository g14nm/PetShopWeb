package it.betacom.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Utente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String nome;
    
    @Column(nullable = false)
    private String cognome;
    
    @Column(nullable = false, unique = true)
    private String username;
    
    @Column(nullable = false, unique = true)
    private String email;
    
    @Column(nullable = false)
    private LocalDate dataDiNascita;
    
    @Column(nullable = false)
    private String cellulare;
    
    @Column(nullable = false)
    private String password;
    
    @Column(nullable = false, columnDefinition = "char(1) default 'g'")
    private char ruolo = 'g';
    
    @Column(nullable = false, columnDefinition = "char(1) default 'a'")
    private char stato = 'a';
    
    @Column(nullable = false, columnDefinition = "int default 3")
    private int loginRimanenti = 3;

    public Utente() {}

    public Utente(String nome, String cognome, String email, String cellulare, String password) {
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.cellulare = cellulare;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDataDiNascita() {
        return dataDiNascita;
    }

    public void setDataDiNascita(LocalDate dataDiNascita) {
        this.dataDiNascita = dataDiNascita;
    }

    public String getCellulare() {
        return cellulare;
    }

    public void setCellulare(String cellulare) {
        this.cellulare = cellulare;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public char getRuolo() {
        return ruolo;
    }

    public void setRuolo(char ruolo) {
        this.ruolo = ruolo;
    }

    public char getStato() {
        return stato;
    }

    public void setStato(char stato) {
        this.stato = stato;
    }

    public int getLoginRimanenti() {
        return loginRimanenti;
    }

    public void setLoginRimanenti(int loginRimanenti) {
        this.loginRimanenti = loginRimanenti;
    }

}
