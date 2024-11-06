package controller;

import dao.MarcaDAO;
import java.sql.*;
import java.util.List;
import model.Marca;

/**
 *
 * @author Vitor
 */
public class MarcaController {

    // método público para cadastrar marca
    public static void cadastrarMarca(String nome_marca) throws SQLException {
        Marca marca = new Marca(nome_marca);
        MarcaDAO.cadastrarMarca(marca);
    }

    // método público para listar marcas
    public static List<Marca> listarMarca() throws SQLException {
        return MarcaDAO.listarMarca();
    }
    
    // método público para buscar marcas pelo nome
    public static List<Marca> buscarPorNome(String nome) throws SQLException {
        return MarcaDAO.buscarPorNome(nome);
    }

    // método público para editar dados de uma marca cadastrada
    public static void editarMarca(int cod_marca, String nome_marca) throws SQLException {
        Marca marca = new Marca(nome_marca);
        marca.setCod_marca(cod_marca);
        MarcaDAO.editarMarca(marca);
    }

    // método público para deletar marca cadastrada
    public static void deletarMarca(int cod_marca) throws SQLException {
        MarcaDAO.deletarMarca(cod_marca);
    }

}
