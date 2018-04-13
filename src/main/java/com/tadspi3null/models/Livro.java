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
public class Livro extends Produto{
    
    private String idioma;
    private String autor;
    private String editora;
    private String edicao;
    private String numeroPaginas;
    private String isbn;

    public Livro(String idioma, String autor, String editora, String edicao, String numeroPaginas, String isbn) {
        this.idioma = idioma;
        this.autor = autor;
        this.editora = editora;
        this.edicao = edicao;
        this.numeroPaginas = numeroPaginas;
        this.isbn = isbn;
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
