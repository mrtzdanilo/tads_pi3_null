/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tadspi3null.dao;

import com.tadspi3null.connect.ConnectionUtils;
import com.tadspi3null.models.Categoria;
import com.tadspi3null.models.Livro;
import com.tadspi3null.models.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Danilo
 */
public class DaoProduto {
    
    public static void inserirLivro(Produto produto) throws SQLException{
        
        long id_produto = 0;
        
        String query = "INSERT INTO livro (titulo,valor,descricao,idioma,autor,"
                + "edicao,numero_paginas,isbn) VALUES (?,?,?,?,?,?,?,?)";
        
        try (Connection conn = ConnectionUtils.getConnection();
                PreparedStatement stmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            
            if(produto instanceof Livro){
                Livro temp = (Livro) produto;
                
                stmt.setString(1, temp.getTitulo());
                stmt.setDouble(2, temp.getValor());
                stmt.setString(3, temp.getDescricao());
                stmt.setString(4, temp.getIdioma());
                stmt.setString(5, temp.getAutor());
                stmt.setString(6, temp.getEdicao());
                stmt.setString(7, temp.getNumeroPaginas());
                stmt.setString(8, temp.getIsbn());
                
                stmt.executeUpdate();
                
                ResultSet generatedKeys = stmt.getGeneratedKeys();
                if (generatedKeys.next()) {
                    id_produto = (generatedKeys.getInt(1));
                }
                
                produto.setId(id_produto);
            }
        }
        for(Categoria categoria: produto.getCategorias()){
            DaoProdutoCategoria.inserirProdutoCategoria(produto, categoria);
        }
        
    }
    
    public static void atualizarProduto(Produto produto) throws SQLException{
        
        String query = "UPDATE livro SET titulo=?, valor=?, descricao=?,"
                + "idioma=?, autor=?, edicao=?, numero_paginas=?, isbn=? "
                + " WHERE (id=?)";
        
        try (Connection conn = ConnectionUtils.getConnection();
                PreparedStatement stmt = conn.prepareStatement(query)) {
            
            if(produto instanceof Livro){
                Livro temp = (Livro) produto;
                
                stmt.setString(0, temp.getTitulo());
                stmt.setDouble(1, temp.getValor());
                stmt.setString(2, temp.getDescricao());
                stmt.setString(3, temp.getIdioma());
                stmt.setString(4, temp.getAutor());
                stmt.setString(5, temp.getEdicao());
                stmt.setString(6, temp.getNumeroPaginas());
                stmt.setString(7, temp.getIsbn());
                
                stmt.executeUpdate();
            }
        }
        
    }
    
    
    public static Produto excluirProduto(Produto produto) throws SQLException{
        
        String query = "DELETE FROM livro WHERE (id=?) ";
        
        try (Connection conn = ConnectionUtils.getConnection();
                PreparedStatement stmt = conn.prepareStatement(query)) {
        
            stmt.setLong(0, produto.getId());
            
            stmt.executeUpdate();
        }
         return produto;
    }
    
    public static ArrayList<Livro> consultarProduto(String nome) throws SQLException{
        
        ArrayList <Livro> listaLivro = new ArrayList<>();
        
        String query = "SELECT * FROM livro WHERE ((UPPER(produto.nome) LIKE (UPPER ?) ";
        
        try (Connection conn = ConnectionUtils.getConnection();
                PreparedStatement stmt = conn.prepareStatement(query)) {
            
            stmt.setString(0, nome);
            
            try (ResultSet result = stmt.executeQuery()) {
                
                Livro livro = new Livro();
                
                livro.setId(result.getInt("id"));
                livro.setTitulo(result.getString("nome"));
                livro.setAutor(result.getString("autor"));
                livro.setEditora(result.getString("editora"));
                livro.setEdicao(result.getString("edicao"));
                livro.setIdioma(result.getString("idioma"));
                livro.setIsbn(result.getString("isbn"));
                livro.setValor(result.getDouble("valor"));
                livro.setNumeroPaginas(result.getString("numero_paginas"));
                
                listaLivro.add(livro);
            }
        }
        
        for(Livro livro: listaLivro){
            livro.setCategoria(DaoProdutoCategoria.obterCategorias(livro));
        }
        return listaLivro;
    }
    public static ArrayList<Livro> consultarProdutoCategoria(String nome) throws SQLException{
        
        ArrayList <Livro> listaLivro = new ArrayList<>();
        
        String query = "SELECT * FROM livro WHERE UPPER(produto.nome) LIKE (UPPER ?) ";
        
        try (Connection conn = ConnectionUtils.getConnection();
                PreparedStatement stmt = conn.prepareStatement(query)) {
            
            stmt.setString(0, nome);
            
            try (ResultSet result = stmt.executeQuery()) {
                
                Livro livro = new Livro();
                
                livro.setId(result.getInt("id"));
                livro.setTitulo(result.getString("nome"));
                livro.setAutor(result.getString("autor"));
                livro.setEditora(result.getString("editora"));
                livro.setEdicao(result.getString("edicao"));
                livro.setIdioma(result.getString("idioma"));
                livro.setIsbn(result.getString("isbn"));
                livro.setValor(result.getDouble("valor"));
                livro.setNumeroPaginas(result.getString("numero_paginas"));
                
                listaLivro.add(livro);
            }
        }
        
        for(Livro livro: listaLivro){
            livro.setCategoria(DaoProdutoCategoria.obterCategorias(livro));
        }
        return listaLivro;
    }
    
    
    
}
