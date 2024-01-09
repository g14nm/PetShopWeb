package it.betacom.controller;

import it.betacom.service.UtenteService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/cambiastato")
public class CambioStatoController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getSession().getAttribute("ruolo").equals("m")) {
            new UtenteService().changeStateAndSaveByUsername(req.getParameter("username"));
            resp.sendRedirect(req.getContextPath() + "/utenti");
        }
        else
            resp.sendError(403);
    }
}
