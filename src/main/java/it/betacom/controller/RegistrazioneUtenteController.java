package it.betacom.controller;

import it.betacom.controller.validator.UtenteValidator;
import it.betacom.model.Utente;
import it.betacom.service.UtenteService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

@WebServlet("/registrazione")
public class RegistrazioneUtenteController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/formRegistrazione.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UtenteValidator utenteValidator = new UtenteValidator();
        Utente utente = new Utente(
                req.getParameter("nome").trim(),
                req.getParameter("cognome").trim(),
                req.getParameter("email").trim(),
                LocalDate.parse(req.getParameter("data_di_nascita")),
                req.getParameter("cellulare").trim(),
                req.getParameter("password").trim()
        );
        if (utenteValidator.validate(utente)) {
            new UtenteService().createUsernameAndSave(utente);
            resp.sendRedirect("login");
        } else {
            req.setAttribute("messaggiErrore", utenteValidator.getMessaggiErrore());
            getServletContext().getRequestDispatcher("/formRegistrazione.jsp").forward(req, resp);
        }
    }

}
