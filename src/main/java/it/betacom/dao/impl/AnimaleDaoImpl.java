package it.betacom.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;

import it.betacom.EntityManagerFactoryHandler;
import it.betacom.dao.AnimaleDao;
import it.betacom.model.Animale;

public class AnimaleDaoImpl implements AnimaleDao {

    @Override
    public Animale findByMatricola(Long matricola) {
        EntityManager em = EntityManagerFactoryHandler.getEntityManagerFactory().createEntityManager();

        Animale animale = em.find(Animale.class, matricola);

        em.close();
        return animale;
    }

    @Override
    public List<Animale> findAll() {
        EntityManager em = EntityManagerFactoryHandler.getEntityManagerFactory().createEntityManager();

        List<Animale> animali = em.createQuery("SELECT a FROM Animale a", Animale.class).getResultList();

        em.close();
        return animali;
    }

    @Override
    public void save(Animale animale) {
        EntityManager em = EntityManagerFactoryHandler.getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();

        if (animale.getMatricola() != null)
            em.merge(animale);
        else
            em.persist(animale);

        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void deleteByMatricola(Long matricola) {
        EntityManager em = EntityManagerFactoryHandler.getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();

        Animale animale = em.find(Animale.class, matricola);
        em.remove(animale);

        em.getTransaction().commit();
        em.close();
    }

}
