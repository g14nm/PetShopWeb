package it.betacom.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.betacom.dao.impl.ClienteDaoImpl;

@WebServlet("/animaliCliente")
public class AnimaliClienteController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getSession().getAttribute("ruolo") != null) {
            req.setAttribute("animali", new ClienteDaoImpl().getAnimaliById(Long.parseLong(req.getParameter("id"))));
            getServletContext().getRequestDispatcher("/animaliCliente.jsp").forward(req, resp);
        } else
            resp.sendError(403);
    }
}
