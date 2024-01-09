package it.betacom.dao.impl;

import it.betacom.EntityManagerFactoryHandler;
import it.betacom.dao.ClienteDao;
import it.betacom.model.Animale;
import it.betacom.model.Cliente;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

public class ClienteDaoImpl implements ClienteDao {

    @Override
    public List<Cliente> findAll() {
        EntityManager em = EntityManagerFactoryHandler.getEntityManagerFactory().createEntityManager();

        List<Cliente> clienti = em.createQuery("SELECT c FROM Cliente c", Cliente.class).getResultList();

        em.close();
        return clienti;
    }

    @Override
    public List<Animale> getAnimaliById(Long id) {
        EntityManager em = EntityManagerFactoryHandler.getEntityManagerFactory().createEntityManager();

        Cliente cliente = em.find(Cliente.class, id);
        List<Animale> animali = new ArrayList<>(cliente.getAnimali());

        em.close();
        return animali;
    }

}
