package it.betacom.controller;

import it.betacom.dao.impl.ClienteDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/clienti")
public class ClientiController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getSession().getAttribute("ruolo") != null) {
            req.setAttribute("clienti", new ClienteDaoImpl().findAll());
            getServletContext().getRequestDispatcher("/clienti.jsp").forward(req, resp);
        } else
            resp.sendError(403);
    }

}
