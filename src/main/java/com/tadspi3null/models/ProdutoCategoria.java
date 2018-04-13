/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tadspi3null.models;

import java.util.ArrayList;

/**
 *
 * @author Danilo
 */
public class ProdutoCategoria {
    
    private Produto produto;
    private ArrayList<Categoria> listaCategoria;

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public ArrayList<Categoria> getListaCategoria() {
        return listaCategoria;
    }

    public void setListaCategoria(ArrayList<Categoria> listaCategoria) {
        this.listaCategoria = listaCategoria;
    }
}
