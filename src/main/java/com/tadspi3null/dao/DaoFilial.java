/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tadspi3null.dao;

import com.tadspi3null.connect.ConnectionUtils;
import com.tadspi3null.models.Endereco;
import java.sql.Connection;
import java.sql.PreparedStatement;
import com.tadspi3null.models.Filial;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Danilo
 */
public class DaoFilial {
    public static Filial inserirFilial(Filial filial) throws SQLException{
        
        long id_endereco = DaoEndereco.inserirEndereco(filial);
        
        String query = "INSERT INTO filial (nome_fantasia, nome, cnpj, "
                + "inscricao_estadual, telefone, fax, email, id_endereco) VALUES (?,?,?,?,?,?,?,?)";
        
        try (Connection conn = ConnectionUtils.getConnection();
                PreparedStatement stmt = conn.prepareStatement(query)) {
            
            stmt.setString(1, filial.getNomeFantasia());
            stmt.setString(2, filial.getNome());
            stmt.setString(3, filial.getCnpj());
            stmt.setString(4, filial.getInscricaoEstadual());
            stmt.setString(5, filial.getTelefone());
            stmt.setString(6, filial.getFax());
            stmt.setString(7, filial.getEmail());
            stmt.setLong(8, id_endereco);
            
            stmt.executeUpdate(query);
        }
        return filial;
    }
    
     public static Filial atualizarFilial(Filial filial) throws SQLException{
        String query = "UPDATE filial SET (nome_fantasia=?, nome=?, CNPJ=?, "
                + "inscricao_estadual=?, telefone=?, fax=?, email=?)"
                + " WHERE (id=?)";
        
        try (Connection conn = ConnectionUtils.getConnection();
                PreparedStatement stmt = conn.prepareStatement(query)) {
            
            stmt.setString(1, filial.getNomeFantasia());
            stmt.setString(2, filial.getNome());
            stmt.setString(3, filial.getCnpj());
            stmt.setString(4, filial.getInscricaoEstadual());
            stmt.setString(5, filial.getTelefone());
            stmt.setString(6, filial.getFax());
            stmt.setString(7, filial.getEmail());
            stmt.setInt(8, filial.getId());
            
            stmt.executeUpdate(query);
        }
        return filial;
    }
     
    public static Filial excluirEndereco(Filial filial) throws SQLException{
        String query = "DELETE FROM filial WHERE (id=?)";
        
        try (Connection conn = ConnectionUtils.getConnection();
                PreparedStatement stmt = conn.prepareStatement(query)) {
            
            stmt.setInt(0, filial.getEndereco().getId());
            
            stmt.executeUpdate();
        }
        return filial;
    }
    
    public static ArrayList<Filial> consultaFilial(String nomeFantasia) throws SQLException{
        ArrayList<Filial> listaFilial = new ArrayList<>();
        
        String query = "SELECT * FROM filial WHERE filial.nome LIKE ?";
        
         try (Connection conn = ConnectionUtils.getConnection();
                PreparedStatement stmt = conn.prepareStatement(query)) {
            
             stmt.setString(1, nomeFantasia);
             
            try (ResultSet resultados = stmt.executeQuery()) {
                
                while(resultados.next()){
                    
                    Filial filial = new Filial();
                    
                    filial.setCnpj(resultados.getString("cnpj"));
                    filial.setNomeFantasia(resultados.getString("nome_fantasia"));
                    filial.setInscricaoEstadual(resultados.getString("inscricao_estadual"));
                    filial.setEmail(resultados.getString("email"));
                    filial.setTelefone(resultados.getString("telefone"));
                    filial.setFax(resultados.getString("fax"));
                    filial.getEndereco().setId(resultados.getInt("id_endereco"));
                    listaFilial.add(filial);
                }
            }
         }
         
         for(Filial filialTemp: listaFilial){
             filialTemp.setEndereco(DaoEndereco.obterEndereco(filialTemp.getEndereco().getId()));
         }
        
        return listaFilial;
    }
     
     
}
