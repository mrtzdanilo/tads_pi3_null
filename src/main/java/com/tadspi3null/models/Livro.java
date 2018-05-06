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
public class Livro{
    
    private Categoria categoria;
    private long id;
    private double valor;
    private String titulo;
    private String descricao;
    private String idioma;
    private String autor;
    private String editora;
    private String edicao;
    private String numeroPaginas;
    private String isbn;

    public Livro(String titulo,String idioma, String autor, String editora, String edicao, 
            String numeroPaginas, String isbn,Double valor, String descricao,
            Categoria categoria) {
        this.valor = valor;
        this.titulo = titulo;
        this.descricao = descricao;
        this.idioma = idioma;
        this.autor = autor;
        this.editora = editora;
        this.edicao = edicao;
        this.numeroPaginas = numeroPaginas;
        this.isbn = isbn;
        this.categoria = categoria;
    }
    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public void setId(long id) {
        this.id = id;
    }
    
    public long getId() {
        return this.id;
    }
    public Categoria getCategoria() {
        return this.categoria;
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
   
    public Livro(){
        
    }

    
    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public String getEdicao() {
        return edicao;
    }

    public void setEdicao(String edicao) {
        this.edicao = edicao;
    }

    public String getNumeroPaginas() {
        return numeroPaginas;
    }

    public void setNumeroPaginas(String numeroPaginas) {
        this.numeroPaginas = numeroPaginas;
    }
}
