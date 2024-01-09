package it.betacom.controller;

import it.betacom.dao.impl.AnimaleDaoImpl;
import it.betacom.model.Animale;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/registrazioneAnimale")
public class RegistrazioneAnimaleController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getSession().getAttribute("ruolo").equals("m")) {
            getServletContext().getRequestDispatcher("/formAnimale.jsp").forward(req, resp);
        } else
            resp.sendError(403);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getSession().getAttribute("ruolo").equals("m")) {
            try {
                Animale animale = new Animale(
                        req.getParameter("nome").trim(),
                        Double.parseDouble(req.getParameter("prezzo").replace(',', '.')),
                        req.getParameter("tipo").trim()
                );
                new AnimaleDaoImpl().save(animale);
                resp.sendRedirect(req.getContextPath() + "/animali");
            }
            catch (NumberFormatException e) {
                req.setAttribute("erroreConversioneNumero", "inserire una cifra valida!");
                getServletContext().getRequestDispatcher("/formAnimale.jsp").forward(req, resp);
            }
        }
    }

}
