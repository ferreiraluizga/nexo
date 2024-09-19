package controller;

import dao.Categoria_ProdutoDAO;
import java.sql.*;
import java.util.List;
import model.Categoria_Produto;

/**
 *
 * @author Rebeca
 */

public class Categoria_ProdutoController {
    
    // método para cadastrar categoria
    public static void cadastrarCategoria(String nome, String desc) throws SQLException {
        Categoria_Produto categoria = new Categoria_Produto(nome, desc);
        Categoria_ProdutoDAO.cadastrarCategoria(categoria);
    }
    
    // método para listar categorias cadastrados
    public static List<Categoria_Produto> listarCategoria() throws SQLException {
        return Categoria_ProdutoDAO.listarCategoria();
    }
    
    // método para buscar categoria pelo nome
    public static List<Categoria_Produto> buscarPorNome(String nome) throws SQLException {
        return Categoria_ProdutoDAO.buscarPorNome(nome);
    }
    
    // método para editar dados de um categoria cadastrado
    public static void editarCategoria(int cod_categoria, String nome, String desc) throws SQLException {
        Categoria_Produto categoria = new Categoria_Produto(nome, desc);
        categoria.setCod_categoria(cod_categoria);
        Categoria_ProdutoDAO.editarCategoria(categoria);
    }
    
    // método para deletar categoria cadastrado
    public static void deletarCategoria(int cod_categoria) throws SQLException {
        Categoria_ProdutoDAO.deletarCategoria(cod_categoria);
    }
    
}
