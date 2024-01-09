package it.betacom.controller;

import it.betacom.dao.impl.AnimaleDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/eliminaAnimale")
public class EliminazioneAnimaleController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getSession().getAttribute("ruolo").equals("m")) {
            new AnimaleDaoImpl().deleteByMatricola(Long.parseLong(req.getParameter("matricola")));
            resp.sendRedirect(req.getContextPath() + "/animali");
        } else
            resp.sendError(403);
    }

}
