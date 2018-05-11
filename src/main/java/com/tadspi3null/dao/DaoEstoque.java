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
        
        String query = "UPDATE livro_filial SET estoque=? WHERE livro_filial.id_livro=? AND livro_filial.id_filial=?";
        try (Connection conn = ConnectionUtils.getConnection();
                PreparedStatement stmt = conn.prepareStatement(query)) {
            
            stmt.setLong(1, estoque);
            stmt.setLong(2, livroFilial.getLivro().getId());
            stmt.setLong(3, livroFilial.getFilial().getId());
            
            stmt.executeUpdate();
        }
        
        
    }
    
    public static ArrayList<LivroFilial> obterEstoque(long id_livro) throws SQLException{
        
        String query = "SELECT * FROM livro_filial WHERE livro_filial.id_livro = ?";
        
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
}