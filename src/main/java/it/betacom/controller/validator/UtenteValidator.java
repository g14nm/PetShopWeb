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
    	if(utente.getNome().trim().length() < 2)
    		messaggiErrore.put("nome", "inserire almeno due caratteri!");
    	
    	if(utente.getCognome().trim().length() < 2)
    		messaggiErrore.put("cognome", "inserire almeno due caratteri!");
    	
        if (utenteDao.findByUsernameOrEmail(utente.getEmail()) != null)
            messaggiErrore.put("email", "email già esistente!");
        
        if(utente.getDataDiNascita() == null)
        	messaggiErrore.put("data_di_nascita", "inserire data valida!");
        
        if(utente.getCellulare().contains(" ") || utente.getCellulare().trim().length() != 10)
        	messaggiErrore.put("cellulare", "inserire cellulare valido!");
        
        if(utente.getPassword().contains(" ") || utente.getPassword().trim().length() < 8)
        	messaggiErrore.put("password", "inserire password valida!");
        
        return messaggiErrore.isEmpty();
    }

    public Map<String, String> getMessaggiErrore() {
        return this.messaggiErrore;
    }

}
