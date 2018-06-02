/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tadspi3null.dao;

import com.tadspi3null.connect.ConnectionUtils;
import com.tadspi3null.models.Filial;
import com.tadspi3null.models.Livro;
import com.tadspi3null.models.LivroFilial;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author mverissimo
 */
public class DaoEstoque {
    
    public static void atualizar(LivroFilial livroFilial, int estoque) throws SQLException{
        
        String query = "UPDATE livro_filial SET estoque = ? WHERE livro_filial.id_livro=? AND livro_filial.id_filial=?";
        try (Connection conn = ConnectionUtils.getConnection();
                PreparedStatement stmt = conn.prepareStatement(query)) {
            
            stmt.setLong(1, estoque);
            stmt.setLong(2, livroFilial.getLivro().getId());
            stmt.setLong(3, livroFilial.getFilial().getId());
            
            stmt.executeUpdate();
        }
    }
    
    public static ArrayList<LivroFilial> obterEstoque(long id_livro) throws SQLException{
        
        String query = "SELECT * FROM livro_filial INNER JOIN filial "
                    + " ON livro_filial.id_filial = filial.id"
                    + " AND livro_filial.id_livro = ?"
                    + " AND filial.removido = false";
                
        ArrayList<LivroFilial> listaLivroFilial = new ArrayList<LivroFilial>();
        
        try (Connection conn = ConnectionUtils.getConnection();
                PreparedStatement stmt = conn.prepareStatement(query)) {
                
            stmt.setLong(1, id_livro);
                
            try (ResultSet result = stmt.executeQuery()) {
                
                while (result.next()){
                    LivroFilial livroFilial = new LivroFilial();
                    Filial filial = new Filial();
                    Livro livro = new Livro();
                    
                    livro.setId(result.getLong("id_livro"));
                    filial.setId(result.getInt("id_filial"));
                    livroFilial.setEstoque(result.getInt("estoque"));
                    
                    livroFilial.setLivro(livro);
                    livroFilial.setFilial(filial);
                    
                    listaLivroFilial.add(livroFilial);
                }
            }
            catch (Exception e){
                System.out.println(e);
            }
          
            }
        
        for(LivroFilial tmp: listaLivroFilial){
            tmp.setFilial(DaoFilial.consultaPorId(tmp.getFilial().getId()));
            tmp.setLivro(DaoLivro.consultaPorId(tmp.getLivro().getId()));
        }
        
        return listaLivroFilial;
    }
    
    //atualiza o estoque do livro-filial
    public static void atualizaEstoqueLivroFilial(Integer filial_id,Integer quantidade, Long livro_id) throws SQLException{
        
        String query = "UPDATE livro_filial "
                    + "SET estoque = ((livro_filial.estoque) - (?)) "
                    + "WHERE livro_filial.id_filial = ? "
                    + "AND livro_filial.id_livro = ?";
        
        try (Connection conn = ConnectionUtils.getConnection();
                PreparedStatement stmt = conn.prepareStatement(query)) {
            
            stmt.setLong(1, filial_id);
            stmt.setInt(2, quantidade);
            stmt.setLong(3, livro_id);
            stmt.executeUpdate();
        }
    }
    
    public static LivroFilial obterPorId(Long livro_id, Integer filial_id) throws SQLException{
        LivroFilial livroFilial = new LivroFilial();
        
        String query = "SELECT * FROM livro_filial "
                    +  "WHERE livro_filial.id_livro = ?"
                    +  "AND livro_filial.id_filial = ?";
        
                    
        try (Connection conn = ConnectionUtils.getConnection();
                PreparedStatement stmt = conn.prepareStatement(query)) {
            
            stmt.setLong(1, livro_id);
            stmt.setLong(2, filial_id);
            
            try (ResultSet result = stmt.executeQuery()) {
                
                while (result.next()){
                    Filial filial = new Filial();
                    Livro livro = new Livro();
                    
                    livro.setId(result.getLong("id_livro"));
                    filial.setId(result.getInt("id_filial"));
                    livroFilial.setEstoque(result.getInt("estoque"));
                    
                    livroFilial.setLivro(livro);
                    livroFilial.setFilial(filial);
                }
            }
            livroFilial.setFilial(DaoFilial.consultaPorId(livroFilial.getFilial().getId()));
            livroFilial.setLivro(DaoLivro.consultaPorId(livroFilial.getLivro().getId()));

            return livroFilial;
        }
    }
    
}
