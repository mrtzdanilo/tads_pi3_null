/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tadspi3null.dao;

import com.tadspi3null.connect.ConnectionUtils;
import com.tadspi3null.models.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Danilo
 */
public class DaoUsuario {
    
    public static void inserirUsuario(Usuario usuario) throws SQLException{
        
        String query = "INSERT INTO usuario (nome, sobre_nome, sexo, funcao, dt_admissao) VALUES (?,?,?,?,?)";
        
        try (Connection conn = ConnectionUtils.getConnection();
                PreparedStatement stmt = conn.prepareStatement(query)) {
            
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getSobreNome());
            stmt.setString(3, usuario.getSexo());
            stmt.setString(4, usuario.getFuncao());
            java.sql.Date data = new java.sql.Date(usuario.getDtAdmissao().getTime());
            stmt.setDate(5, data);
            
            stmt.executeUpdate();
        }
    }
    
    public static Usuario obterUsuarioPorId(Long id) throws SQLException{
        Usuario usuario = new Usuario();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
        
        String query = "SELECT * FROM usuario WHERE usuario.id = ? AND removido = false";
        
        try (Connection conn = ConnectionUtils.getConnection();
                PreparedStatement stmt = conn.prepareStatement(query)) {
            
            stmt.setLong(1, id);
            
            try (ResultSet result = stmt.executeQuery()) {
                
                while(result.next()){
                    usuario.setId(result.getLong("id"));
                    usuario.setNome(result.getString("nome"));
                    usuario.setNome(result.getString("sobreNome"));
                    usuario.setFuncao(result.getString("funcao"));
                    usuario.setSexo(result.getString("sexo"));
                    Date dtAdmissao = result.getDate("dt_admissao");
                    usuario.setDtAdmissao(dtAdmissao);
                }
            }
        }
        
        return usuario;
    }
    
    public static void excluirUsuario(Usuario usuario) throws SQLException{
        
        String query = "UPDATE usuario SET removido=true WHERE usuario.id = ?";
        
        try (Connection conn = ConnectionUtils.getConnection();
                PreparedStatement stmt = conn.prepareStatement(query)) {
            
            stmt.setLong(1, usuario.getId());
            
            stmt.executeUpdate();
        }
    }
    
    public static void alterarUsuario(Usuario usuario) throws SQLException{
        
        String query = "UPDATE usuario SET nome=?, sobre_nome=?, sexo=?, da_admissao, "
                + "funcao=? WHERE usuario.id =?";
        
        try (Connection conn = ConnectionUtils.getConnection();
                PreparedStatement stmt = conn.prepareStatement(query)) {
            
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getSobreNome());
            stmt.setString(3, usuario.getSexo());
            java.sql.Date data = new java.sql.Date(usuario.getDtAdmissao().getTime());
            stmt.setDate(4, data);
            stmt.setLong(5, usuario.getId());
            
            stmt.executeUpdate();
        }
    }
    
    
}

