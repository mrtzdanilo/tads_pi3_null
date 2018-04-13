/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tadspi3null.models;


/**
 *
 * @author mverissimo
 */
public class Filial {
    
    private Integer id; 
    
    private Endereco endereco;
    
    private String nomeFantasia;
    private String nome;
    private String cnpj;
    private String inscricaoEstadual;
    
    private String telefone;
    private String fax;
    private String email;

    public Filial(Endereco endereco, String nomeFantasia, String nome, 
                  String cnpj, String inscricaoEstadual, String telefone, String fax, String email) {
        this.endereco = endereco;
        this.nomeFantasia = nomeFantasia;
        this.nome = nome;
        this.cnpj = cnpj;
        this.inscricaoEstadual = inscricaoEstadual;
        this.telefone = telefone;
        this.fax = fax;
        this.email = email;
    }
    
    public Integer getId() {
        return id;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
    
    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCNPJ(String CNPJ) {
        this.cnpj = CNPJ;
    }

    public String getInscricaoEstadual() {
        return inscricaoEstadual;
    }

    public void setInscricaoEstadual(String inscricaoEstadual) {
        this.inscricaoEstadual = inscricaoEstadual;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
    

}
