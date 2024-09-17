/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.MarcaDAO;
import java.sql.*;
import java.util.List;
import model.Marca;

/**
 *
 * @author Admin
 */
public class MarcaController {
    
        // método para cadastrar cliente
    public static void cadastrarMarca(String nome_marca) throws SQLException {
        Marca marca = new Marca(nome_marca);
        MarcaDAO.cadastrarMarca(marca);
    }
    
    // método para listar clientes cadastrados
    public static List<Marca> listarMarca() throws SQLException {
        return MarcaDAO.listarMarca();
    }
    
        public static List<Marca> buscarPorNome(String nome) throws SQLException {
        return MarcaDAO.buscarPorNome(nome);
    }
    
    // método para editar dados de um cliente cadastrado
    public static void editarMarca(int cod_marca, String nome_marca) throws SQLException {
        Marca marca = new Marca(nome_marca);
        marca.setCod_marca(cod_marca);
        MarcaDAO.editarMarca(marca);
    }
    
    // método para deletar cliente cadastrado
    public static void deletarMarca(int cod_marca) throws SQLException {
        MarcaDAO.deletarMarca(cod_marca);
    }
    
}

