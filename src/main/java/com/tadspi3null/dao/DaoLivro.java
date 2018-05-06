/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tadspi3null.dao;

import com.tadspi3null.connect.ConnectionUtils;
import com.tadspi3null.models.Categoria;
import com.tadspi3null.models.Livro;
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
public class DaoLivro {
    
    public static void inserirLivro(Livro livro) throws SQLException{
        
        long id_livro = 0;
        
        String query = "INSERT INTO livro (titulo,valor,descricao,idioma,autor,"
                + "edicao,numero_paginas,isbn,editora, id_categoria) VALUES (?,?,?,?,?,?,?,?,?,?)";
        
        try (Connection conn = ConnectionUtils.getConnection();
                PreparedStatement stmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
                
                stmt.setString(1, livro.getTitulo());
                stmt.setDouble(2, livro.getValor());
                stmt.setString(3, livro.getDescricao());
                stmt.setString(4, livro.getIdioma());
                stmt.setString(5, livro.getAutor());
                stmt.setString(6, livro.getEdicao());
                stmt.setString(7, livro.getNumeroPaginas());
                stmt.setString(8, livro.getIsbn());
                stmt.setString(9, livro.getEditora());
                stmt.setLong(10, livro.getCategoria().getId());
                
                stmt.executeUpdate();
                
                ResultSet generatedKeys = stmt.getGeneratedKeys();
                if (generatedKeys.next()) {
                    id_livro = (generatedKeys.getInt(1));
                }
                
                livro.setId(id_livro);
            }
    }
    
    public static void atualizarLivro(Livro livro) throws SQLException{
        
        String query = "UPDATE livro SET titulo=?, valor=?, descricao=?,"
                + "idioma=?, autor=?, edicao=?, numero_paginas=?, isbn=?, editora=?, id_categoria=? "
                + " WHERE (id=?)";
        
        try (Connection conn = ConnectionUtils.getConnection();
                PreparedStatement stmt = conn.prepareStatement(query)) {
                
                stmt.setString(1, livro.getTitulo());
                stmt.setDouble(2, livro.getValor());
                stmt.setString(3, livro.getDescricao());
                stmt.setString(4, livro.getIdioma());
                stmt.setString(5, livro.getAutor());
                stmt.setString(6, livro.getEdicao());
                stmt.setString(7, livro.getNumeroPaginas());
                stmt.setString(8, livro.getIsbn());
                stmt.setString(9, livro.getEditora());
                stmt.setLong(10, livro.getCategoria().getId());
                
                stmt.executeUpdate();
            }
        }
        
    public static Livro excluirLivro(Livro livro) throws SQLException{
        
        // Prepara uma string para fazer UPDATE no banco de dados
        String sql = "UPDATE livro SET removido=? WHERE id=?";
        
        // conexao para abertura e fechamento
        Connection connection = null;
        
        // atraves da conexao, ira executar comandos sql
        PreparedStatement preparedStatement = null;
        
        try{
            // abre uma conxao com o banco de dados
            connection = ConnectionUtils.getConnection();
            
            // Cria um statement para execução de instruções SQL
            preparedStatement = connection.prepareStatement(sql);
            
            // exclui logicamente o livro
            preparedStatement.setBoolean(1, true);
            preparedStatement.setLong(2, livro.getId());
            
            // executa o comando sql
            preparedStatement.execute();
            
        } finally {
            //Se o statement ainda estiver aberto, realiza seu fechamento
            if (preparedStatement != null && !preparedStatement.isClosed()) {
                preparedStatement.close();
            }
            //Se a conexão ainda estiver aberta, realiza seu fechamento
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
        return livro;
    }
    
    public static Livro consultaPorId(String id) throws SQLException{
        /*
        Returns an unique book record, because this search is done by id
        */
        
        String query = "SELECT * FROM livro WHERE livro.id=? AND livro.removido = false";
        
        try (Connection conn = ConnectionUtils.getConnection();
                PreparedStatement stmt = conn.prepareStatement(query)) {
            
            stmt.setString(1, id);
            
            try (ResultSet result = stmt.executeQuery()) {
                
                result.first();
                        
                Livro livro = new Livro();
                
                livro.setId(result.getInt("id"));
                livro.setTitulo(result.getString("titulo"));
                livro.setDescricao(result.getString("descricao"));
                livro.setAutor(result.getString("autor"));
                livro.setEditora(result.getString("editora"));
                livro.setEdicao(result.getString("edicao"));
                livro.setIdioma(result.getString("idioma"));
                livro.setIsbn(result.getString("isbn"));
                livro.setValor(result.getDouble("valor"));
                livro.setNumeroPaginas(result.getString("numero_paginas"));
                
                Categoria categoria = DaoCategoria.obterCategoria(result.getLong("id_categoria"));
                livro.setCategoria(categoria);
                
                return livro;
            }
            catch(Exception e){
                System.out.println("No books found with this id"+ e.getMessage());
                return null;
            }
        }
    }
    
    public static ArrayList<Livro> consutarLivros(String titulo) throws SQLException{
        
        ArrayList <Livro> listaLivro = new ArrayList<>();
        
        String query = "SELECT * FROM livro WHERE livro.removido = false";
        if (!titulo.isEmpty()){
            query = "SELECT * FROM livro WHERE livro.titulo LIKE ? AND livro.removido = false";
        }
     
        try (Connection conn = ConnectionUtils.getConnection();
                PreparedStatement stmt = conn.prepareStatement(query)) {
            
            if (!titulo.isEmpty()){
                stmt.setString(1, titulo);
            }
            
            try (ResultSet result = stmt.executeQuery()) {
                
                while (result.next()){
                    Livro livro = new Livro();
                
                    livro.setId(result.getLong("id"));
                    livro.setTitulo(result.getString("titulo"));
                    livro.setAutor(result.getString("autor"));
                    livro.setEditora(result.getString("editora"));
                    livro.setEdicao(result.getString("edicao"));
                    livro.setIdioma(result.getString("idioma"));
                    livro.setIsbn(result.getString("isbn"));
                    livro.setValor(result.getDouble("valor"));
                    livro.setNumeroPaginas(result.getString("numero_paginas"));
                    
                    Categoria categoria = DaoCategoria.obterCategoria(result.getLong("id_categoria"));
                    livro.setCategoria(categoria);
                    
                    listaLivro.add(livro);
                
                }
            }
            catch (Exception e){
                System.out.println(e);
            }
        }
        catch (Exception e){
            System.out.println(e);
        }
        
        
        return listaLivro;
    }
}
