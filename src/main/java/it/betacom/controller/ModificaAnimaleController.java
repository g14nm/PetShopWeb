package it.betacom.controller;

import it.betacom.dao.AnimaleDao;
import it.betacom.dao.impl.AnimaleDaoImpl;
import it.betacom.model.Animale;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/modificaAnimale")
public class ModificaAnimaleController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getSession().getAttribute("ruolo").equals("m")) {
            req.setAttribute("animale", new AnimaleDaoImpl().findByMatricola(Long.parseLong(req.getParameter("matricola"))));
            getServletContext().getRequestDispatcher("/formModificaAnimale.jsp").forward(req, resp);
        } else
            resp.sendError(403);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getSession().getAttribute("ruolo").equals("m")) {
            AnimaleDao animaleDao = new AnimaleDaoImpl();
            Animale animale = animaleDao.findByMatricola(Long.parseLong(req.getParameter("matricola")));
            try {
                animale.setNomeAnimale(req.getParameter("nome").trim());
                animale.setTipoAnimale(req.getParameter("tipo").trim());
                animale.setPrezzo(Double.parseDouble(req.getParameter("prezzo").replace(',', '.')));
                animaleDao.save(animale);
                resp.sendRedirect(req.getContextPath() + "/animali");
            } catch (NumberFormatException e) {
                req.setAttribute("animale", animale);
                req.setAttribute("erroreConversioneNumero", "inserire una cifra valida!");
                getServletContext().getRequestDispatcher("/formModificaAnimale.jsp").forward(req, resp);
            }
        }
    }

}
