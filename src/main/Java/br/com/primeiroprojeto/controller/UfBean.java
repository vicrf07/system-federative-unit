package br.com.primeiroprojeto.controller;

import java.util.List;

import javax.annotation.ManagedBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.dao.impl.UfDao;
import br.com.primeiroprojeto.model.Uf;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;

@Component
@ManagedBean
@ApplicationScoped
public class UfBean {

    @Autowired
    UfDao ufDao;

    private List<Uf> list;

    private Uf uf;

    public Uf getUf() {
        return uf;
    }

    public void setUf(Uf uf) {
        this.uf = uf;
    }

    @PostConstruct
    public void init() {
        if (list == null) {
            list = ufDao.findAll();
        }

    }

    public List<Uf> getList() {
        return list;
    }

    public String novo() {
        this.uf = new Uf();
        return "cadastrarUf";
    }

    public String salvar() {
        if (ufDao.save(this.uf)) {
            list = ufDao.findAll();
        }
        return "uf";
    }

    public String remover(Uf uf) {
        ufDao.delete(uf.getId());
        list = ufDao.findAll();
        return "uf";
    }

    public String editar(Uf uf) {
        this.uf = uf;
        return "cadastrarUf";
    }
}
