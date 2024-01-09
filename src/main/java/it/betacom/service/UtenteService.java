package it.betacom.service;

import it.betacom.dao.UtenteDao;
import it.betacom.dao.impl.UtenteDaoImpl;
import it.betacom.model.Utente;

public class UtenteService {

    private final UtenteDao utenteDao;

    public UtenteService() {
        this.utenteDao = new UtenteDaoImpl();
    }

    public String createUsernameAndSave(Utente utente) {
        String username = "" + utente.getNome().toLowerCase().charAt(0) + utente.getNome().toLowerCase().charAt(1) + utente.getCognome().toLowerCase().charAt(0) + utente.getCognome().toLowerCase().charAt(1) + utente.getDataDiNascita().getYear();
        Utente ultimoUtenteConUsernameSimile = utenteDao.findLastUserWithUsernameLike(username);
        if (ultimoUtenteConUsernameSimile != null) {
            String ultimoUsernameSimile = ultimoUtenteConUsernameSimile.getUsername();
            if (ultimoUsernameSimile.length() == 8)
                username += "_1";
            else {
                int progressivo = Character.getNumericValue(ultimoUsernameSimile.charAt(ultimoUsernameSimile.length() - 1));
                username += ("_" + (progressivo + 1));
            }
        }
        utente.setUsername(username);
        utenteDao.save(utente);
        return username;
    }

    public void changeStateAndSaveByUsername(String username) {
        Utente utente = utenteDao.findByUsernameOrEmail(username);
        if (utente.getStato() == 'a') {
            utente.setStato('d');
            utente.setLoginRimanenti(0);
        } else {
            utente.setStato('a');
            utente.setLoginRimanenti(3);
        }
        utenteDao.save(utente);
    }

    public void changeRoleAndSaveByUsername(String username) {
        Utente utente = utenteDao.findByUsernameOrEmail(username);
        if (utente.getRuolo() == 'g')
            utente.setRuolo('m');
        else
            utente.setRuolo('g');
        utenteDao.save(utente);
    }
    
}
