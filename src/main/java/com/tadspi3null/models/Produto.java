/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tadspi3null.models;

import java.util.ArrayList;

/**
 *
 * @author mverissimo
 */
public class Produto {
    
    private long id;
    private double valor;
    private String titulo;
    private String descricao;
    private ArrayList<Categoria> categorias = new ArrayList<>();
    
    public Produto(){
        
    }

    public Produto(double valor, String titulo, String descricao) {
        this.valor = valor;
        this.titulo = titulo;
        this.descricao = descricao;
    }
    

    public void addCategoria(Categoria categoria){
        this.categorias.add(categoria);
    }
    
    public void setCategoria(ArrayList<Categoria> listaCategoria){
        this.categorias = listaCategoria;
    }

    public ArrayList<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(ArrayList<Categoria> categorias) {
        this.categorias = categorias;
    }
    
    public void setId(long id){
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
