package it.betacom.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.betacom.dao.impl.AnimaleDaoImpl;

@WebServlet("/animali")
public class AnimaliController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getSession().getAttribute("ruolo").equals("m")) {
            req.setAttribute("animali", new AnimaleDaoImpl().findAll());
            getServletContext().getRequestDispatcher("/animali.jsp").forward(req, resp);
        } else
            resp.sendError(403);
    }

}
