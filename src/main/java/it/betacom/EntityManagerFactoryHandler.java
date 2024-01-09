package it.betacom;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Classe per caricare la persistence unit e l'EntityManagerFactory durante il deploy dell'applicazione
 */

@WebListener
public class EntityManagerFactoryHandler implements ServletContextListener {

    private static EntityManagerFactory emFactory;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        emFactory = Persistence.createEntityManagerFactory("petshopweb");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        if (emFactory != null && emFactory.isOpen())
            emFactory.close();
    }

    public static EntityManagerFactory getEntityManagerFactory() {
        return emFactory;
    }

}
