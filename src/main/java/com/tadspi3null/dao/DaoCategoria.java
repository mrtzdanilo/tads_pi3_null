/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tadspi3null.dao;

import com.tadspi3null.connect.ConnectionUtils;
import com.tadspi3null.models.Categoria;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Danilo
 */
public class DaoCategoria {
    
    public static void inserirCategoria(Categoria categoria) throws SQLException{
        
        String query = "INSERT INTO categoria (nome, descricao) VALUES (?,?)";
        
        long id_categoria = 0;
        
        try (Connection conn = ConnectionUtils.getConnection();
                PreparedStatement stmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
        
            stmt.setString(0, categoria.getNome());
            stmt.setString(1, categoria.getDescricao());
            
            stmt.executeUpdate();
            
            ResultSet generatedKeys = stmt.getGeneratedKeys();
                if (generatedKeys.next()) {
                    id_categoria = (generatedKeys.getInt(1));
                }
        }
        categoria.setId(id_categoria);
        
        
        //return categoria;
    }
    
    public static void atualizarCategoria(Categoria categoria) throws SQLException{
        
        String query = " UPDATE categoria SET (nome=?, descricao=?) WHERE (id=?)";
        
        try (Connection conn = ConnectionUtils.getConnection();
                PreparedStatement stmt = conn.prepareStatement(query)) {
            
            stmt.setString(0, categoria.getNome());
            stmt.setString(1, categoria.getDescricao());
            stmt.setLong(2, categoria.getId());
            
            stmt.executeUpdate();
        }
    }
    
    
    public static Categoria obterCategoria(Long id) throws SQLException{
        Categoria categoria = new Categoria();
        
        String query = "SELECT * FROM categoria WHERE (id = ?)";
        
        try (Connection conn = ConnectionUtils.getConnection();
                PreparedStatement stmt = conn.prepareStatement(query)) {
            
            stmt.setLong(0, id);
            
            try (ResultSet resultados = stmt.executeQuery()) {
                
                while(resultados.next()){
                    categoria.setId(resultados.getLong("id"));
                    categoria.setNome(resultados.getString("nome"));
                    categoria.setDescricao(resultados.getString("descricao"));
                }
            }
        }
        return categoria;
    }
    
    public static Categoria obterCategoria(String nome) throws SQLException{
        Categoria categoria = new Categoria();
        
        String query = "SELECT * FROM categoria WHERE UPPER (nome) = (?)";
        
        try (Connection conn = ConnectionUtils.getConnection();
                PreparedStatement stmt = conn.prepareStatement(query)) {
            
            stmt.setString(0, nome);
            
            try (ResultSet resultados = stmt.executeQuery()) {
                
                while(resultados.next()){
                    categoria.setId(resultados.getLong("id"));
                    categoria.setNome(resultados.getString("nome"));
                    categoria.setDescricao(resultados.getString("descricao"));
                }
            }
        }
        return categoria;
    }
    
}
