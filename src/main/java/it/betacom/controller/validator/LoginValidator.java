package it.betacom.controller.validator;

import it.betacom.dao.UtenteDao;
import it.betacom.dao.impl.UtenteDaoImpl;
import it.betacom.model.Utente;

import java.util.HashMap;
import java.util.Map;

public class LoginValidator {

	private final UtenteDao utenteDao;
	private final Map<String, String> messaggiErrore, attributiUtente;

	public LoginValidator() {
		this.utenteDao = new UtenteDaoImpl();
		this.messaggiErrore = new HashMap<String, String>();
		this.attributiUtente = new HashMap<String, String>();
	}

	public boolean validate(String username_email, String password) {
		//cerca nel db un utente con username/email inserito 
		Utente utente = utenteDao.findByUsernameOrEmail(username_email);
		//se l'utente esiste
		if (utente != null) {
			if (utente.getStato() == 'a') {
				//se l'utente e abilitato e la password è corretta aggiunge dei valori associati all'utente alla mappa attributiUtente
				if (utente.getPassword().equals(password)) {
					attributiUtente.put("username", utente.getUsername());
					attributiUtente.put("nome", utente.getNome());
					attributiUtente.put("cognome", utente.getCognome());
					attributiUtente.put("ruolo", String.valueOf(utente.getRuolo()));
					return true;
				}
				//altrimenti esegue un controllo sui tentativi di login rimanenti
				else controllaLoginRimanenti(utente, utenteDao); 
			}
			//se l'utente è disabilitato
			else messaggiErrore.put("username_email", "utente disabilitato");
		}
		//se l'utente con username/email inserito non esiste
		else messaggiErrore.put("username_email", "username/email errato");
		return false;
	}

	private void controllaLoginRimanenti(Utente utente, UtenteDao utenteDao) {
		if (utente.getLoginRimanenti() == 1) {
			utente.setLoginRimanenti(0);
			utente.setStato('d');
			utenteDao.save(utente);
			messaggiErrore.put("username_email", "utente disabilitato");
		} else {
			utente.setLoginRimanenti(utente.getLoginRimanenti() - 1);
			utenteDao.save(utente);
			messaggiErrore.put("password", "password errata");
		}
	}

	public Map<String, String> getMessaggiErrore() {
		return this.messaggiErrore;
	}

	public Map<String, String> getAttributiUtente() {
		return this.attributiUtente;
	}

}
