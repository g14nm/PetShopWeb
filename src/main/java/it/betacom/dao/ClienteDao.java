package it.betacom.dao;

import it.betacom.model.Animale;
import it.betacom.model.Cliente;

import java.util.List;

public interface ClienteDao {

    public List<Cliente> findAll();

    public List<Animale> getAnimaliById(Long id);

}
