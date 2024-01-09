package it.betacom.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.betacom.dao.UtenteDao;
import it.betacom.dao.impl.UtenteDaoImpl;
import it.betacom.model.Utente;

@WebServlet("/utenti")
public class UtenteController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getSession().getAttribute("ruolo") != null) {
            req.setAttribute("utenti", new UtenteDaoImpl().findAll());
            getServletContext().getRequestDispatcher("/utenti.jsp").forward(req, resp);
        } else
            resp.sendError(403);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getSession().getAttribute("ruolo").equals("m")) {
            String email = req.getParameter("email").trim();
            UtenteDao utenteDao = new UtenteDaoImpl();
            Utente utente = utenteDao.findByUsernameOrEmail(req.getParameter("username"));
            if (!email.equals(utente.getEmail()) && (utenteDao.findByUsernameOrEmail(email) != null))
                req.setAttribute("messaggioErroreEmail", "email già esistente");
            else {
                utente.setEmail(email);
                utente.setCellulare(req.getParameter("cellulare").trim());
                utente.setPassword(req.getParameter("password"));
                utenteDao.save(utente);
            }
            resp.sendRedirect(req.getContextPath() + "/animali");
        } else
            resp.sendError(403);
    }

}
