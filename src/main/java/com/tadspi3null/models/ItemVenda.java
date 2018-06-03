/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tadspi3null.models;

/**
 *
 * @author Danilo
 */
public class ItemVenda {
    
    private Long id;
    private Integer quantidade;
    private Double valorUnitario;
    private LivroFilial livroFilial;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(Double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public LivroFilial getLivroFilial() {
        return livroFilial;
    }

    public void setLivroFilial(LivroFilial livroFilial) {
        this.livroFilial = livroFilial;
    }   
}
