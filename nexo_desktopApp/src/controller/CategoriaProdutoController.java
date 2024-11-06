package controller;

import dao.CategoriaProdutoDAO;
import java.sql.*;
import java.util.List;
import model.CategoriaProduto;

/**
 *
 * @author Rebeca
 */

public class CategoriaProdutoController {
    
    // método para cadastrar categoria
    public static void cadastrarCategoria(String nome, String desc) throws SQLException {
        CategoriaProduto categoria = new CategoriaProduto(nome, desc);
        CategoriaProdutoDAO.cadastrarCategoria(categoria);
    }
    
    // método para listar categorias cadastradas
    public static List<CategoriaProduto> listarCategoria() throws SQLException {
        return CategoriaProdutoDAO.listarCategoria();
    }
    
    // método para buscar categoria pelo nome
    public static List<CategoriaProduto> buscarPorNome(String nome) throws SQLException {
        return CategoriaProdutoDAO.buscarPorNome(nome);
    }
    
    // método para editar dados de um categoria cadastrado
    public static void editarCategoria(int cod_categoria, String nome, String desc) throws SQLException {
        CategoriaProduto categoria = new CategoriaProduto(nome, desc);
        categoria.setCod_categoria(cod_categoria);
        CategoriaProdutoDAO.editarCategoria(categoria);
    }
    
    // método para deletar categoria cadastrado
    public static void deletarCategoria(int cod_categoria) throws SQLException {
        CategoriaProdutoDAO.deletarCategoria(cod_categoria);
    }
    
}
