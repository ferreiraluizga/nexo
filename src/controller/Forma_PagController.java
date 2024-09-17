/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.Forma_PagDAO;
import java.sql.*;
import java.util.List;
import model.Forma_Pag;

/**
 *
 * @author Admin
 */
public class Forma_PagController {
    
        // método para cadastrar cliente
    public static void cadastrarForma_Pag(String nome_forma) throws SQLException {
        Forma_Pag forma = new Forma_Pag(nome_forma);
        Forma_PagDAO.cadastrarForma_Pag(forma);
    }
    
    // método para listar clientes cadastrados
    public static List<Forma_Pag> listarForma_Pag() throws SQLException {
        return Forma_PagDAO.listarForma_Pag();
    }
    
    // método para editar dados de um cliente cadastrado
    public static void editarForma_Pag(int cod_forma_pag, String nome_forma) throws SQLException {
        Forma_Pag forma = new Forma_Pag(nome_forma);
        forma.setCod_forma_pag(cod_forma_pag);
        Forma_PagDAO.editarForma_Pag(forma);
    }
    
    // método para deletar cliente cadastrado
    public static void deletarForma_Pag(int cod_forma_pag) throws SQLException {
        Forma_PagDAO.deletarForma_Pag(cod_forma_pag);
    }
    
}

