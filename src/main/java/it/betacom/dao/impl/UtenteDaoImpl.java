package it.betacom.dao.impl;

import it.betacom.EntityManagerFactoryHandler;
import it.betacom.dao.UtenteDao;
import it.betacom.model.Utente;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class UtenteDaoImpl implements UtenteDao {

    @Override
    public Utente findByUsernameOrEmail(String username_email) {
        EntityManager em = EntityManagerFactoryHandler.getEntityManagerFactory().createEntityManager();

        TypedQuery<Utente> query = em.createQuery("SELECT u FROM Utente u WHERE u.username = :p OR u.email = :p", Utente.class);
        query.setParameter("p", username_email);
        try {
            return query.getSingleResult();
        } catch (Exception e) {
            return null;
        } finally {
            em.close();
        }
    }

    @Override
    public Utente findLastUserWithUsernameLike(String username) {
        EntityManager em = EntityManagerFactoryHandler.getEntityManagerFactory().createEntityManager();

        TypedQuery<Utente> query = em.createQuery("SELECT u FROM Utente u WHERE u.username LIKE CONCAT(:p, '%') ORDER BY u.id DESC", Utente.class);
        query.setParameter("p", username);
        query.setMaxResults(1);
        try {
            return query.getSingleResult();
        } catch (Exception e) {
            return null;
        } finally {
            em.close();
        }
    }

    @Override
    public List<Utente> findAll() {
        EntityManager em = EntityManagerFactoryHandler.getEntityManagerFactory().createEntityManager();

        List<Utente> utenti = em.createQuery("SELECT u FROM Utente u", Utente.class).getResultList();

        em.close();
        return utenti;
    }

    @Override
    public void save(Utente utente) {
        EntityManager em = EntityManagerFactoryHandler.getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();

        if (utente.getId() != null)
            em.merge(utente);
        else
            em.persist(utente);

        em.getTransaction().commit();
        em.close();
    }

}
