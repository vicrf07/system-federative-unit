package br.com.managedbean;

import javax.annotation.ManagedBean;

@ManagedBean
public class PrimeiroManagedBean {
    private String nome;
    private String nomeMaiusculo;

    public String getNome() {
        return nome;
    }

    public String getNomeMaiusculo() {
        return nomeMaiusculo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setNomeMaiusculo(String nomeMaiusculo) {
        this.nomeMaiusculo = nomeMaiusculo;
    }

    public String getMessage() {
        return "Esta é uma mensagem que surgiu no controller";
    }

    public void exibirMaiusculo() {
        nomeMaiusculo = nome.toUpperCase();
    }
}
