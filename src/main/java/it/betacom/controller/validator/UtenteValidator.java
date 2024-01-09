package it.betacom.controller.validator;

import it.betacom.dao.UtenteDao;
import it.betacom.dao.impl.UtenteDaoImpl;
import it.betacom.model.Utente;

import java.util.HashMap;
import java.util.Map;

public class UtenteValidator {

    private final UtenteDao utenteDao;
    private final Map<String, String> messaggiErrore;

    public UtenteValidator() {
        utenteDao = new UtenteDaoImpl();
        messaggiErrore = new HashMap<>();
    }

    public boolean validate(Utente utente) {
        if (utenteDao.findByUsernameOrEmail(utente.getEmail()) != null) {
            messaggiErrore.put("email", "email già esistente");
            return false;
        }
        return true;
    }

    public Map<String, String> getMessaggiErrore() {
        return this.messaggiErrore;
    }

}
