package br.com.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import br.com.dao.DAO;
import br.com.primeiroprojeto.model.Uf;

@Repository
@Transactional
public class UfDao implements DAO<Uf> {

    @PersistenceContext
    public EntityManager entityManager;

    @Override
    public List<Uf> findAll() {
        return entityManager.createQuery("from Uf").
                getResultList();
    }

    @Override
    public Uf findById(Integer id) {
        Query query = entityManager.createQuery("from Uf where id = pId");
        query.setParameter("pId", id);
        return (Uf) query.getSingleResult();
    }

    @Override
    public List<Uf> findByName(String name) {
        Query query = entityManager.createQuery("from Uf where name like = pName");
        query.setParameter("pName", "%" + name + "%");
        return query.getResultList();
    }

    @Override
    public boolean save(Uf uf) {
        try {
            if (uf.getId() != null) {
                entityManager.merge(uf);
            } else {
                entityManager.persist(uf);
            }
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean delete(Integer id) {
        Uf uf = findById(id);
        entityManager.remove(uf);
        return true;
    }
}
