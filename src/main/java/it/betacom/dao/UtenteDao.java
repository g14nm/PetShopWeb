package it.betacom.dao;

import it.betacom.model.Utente;

import java.util.List;

public interface UtenteDao {

    public Utente findByUsernameOrEmail(String username_email);

    public Utente findLastUserWithUsernameLike(String username);

    public List<Utente> findAll();

    public void save(Utente utente);

}
