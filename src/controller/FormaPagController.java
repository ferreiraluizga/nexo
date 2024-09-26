/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.FormaPagDAO;
import java.sql.*;
import java.util.List;
import model.FormaPag;

/**
 *
 * @author Admin
 */
public class FormaPagController {
    
        // método para cadastrar cliente
    public static void cadastrarForma_Pag(String nome_forma) throws SQLException {
        FormaPag forma = new FormaPag(nome_forma);
        FormaPagDAO.cadastrarForma(forma);
    }
    
    // método para listar clientes cadastrados
    public static List<FormaPag> listarForma_Pag() throws SQLException {
        return FormaPagDAO.listarForma();
    }
    
    // método para editar dados de um cliente cadastrado
    public static void editarForma_Pag(int cod_forma_pag, String nome_forma) throws SQLException {
        FormaPag forma = new FormaPag(nome_forma);
        forma.setCod_forma_pag(cod_forma_pag);
        FormaPagDAO.editarForma(forma);
    }
    
    // método para deletar cliente cadastrado
    public static void deletarForma_Pag(int cod_forma_pag) throws SQLException {
        FormaPagDAO.deletarForma(cod_forma_pag);
    }
    
}

