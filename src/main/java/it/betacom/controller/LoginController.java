package it.betacom.controller;

import it.betacom.controller.validator.LoginValidator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

@WebServlet("/login")
public class LoginController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LoginValidator loginValidator = new LoginValidator();

        if (loginValidator.validate(req.getParameter("username_email").trim(), req.getParameter("password"))) {
            HttpSession session = req.getSession();
            Map<String, String> attributiUtente = loginValidator.getAttributiUtente();
            session.setAttribute("username", attributiUtente.get("username"));
            session.setAttribute("nome", attributiUtente.get("nome"));
            session.setAttribute("cognome", attributiUtente.get("cognome"));
            session.setAttribute("ruolo", attributiUtente.get("ruolo"));
            resp.sendRedirect("utenti");
        } else {
            req.setAttribute("messaggiErrore", loginValidator.getMessaggiErrore());
            getServletContext().getRequestDispatcher("/login.jsp").forward(req, resp);
        }
    }

}
