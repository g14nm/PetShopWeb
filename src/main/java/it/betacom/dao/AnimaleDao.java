package it.betacom.dao;

import it.betacom.model.Animale;

import java.util.List;

public interface AnimaleDao {

    public Animale findByMatricola(Long matricola);

    public List<Animale> findAll();

    public void save(Animale animale);

    public void deleteByMatricola(Long matricola);

}
