package controller;

import dao.FornecedorDAO;
import java.sql.*;
import java.util.List;
import model.Fornecedor;

/**
 *
 * @author ferreiraluizga
 */

public class FornecedorController {
    
    // método para cadastrar cliente
    public static void cadastrarFornecedor(String nome_fantasia, String cnpj_forn, String fone_forn, String email_forn, String nome_resp) throws SQLException {
        Fornecedor fornecedor = new Fornecedor(nome_fantasia, cnpj_forn, fone_forn, email_forn, nome_resp);
        FornecedorDAO.cadastrarFornecedor(fornecedor);
    }
    
    // método para listar clientes cadastrados
    public static List<Fornecedor> listarFornecedor() throws SQLException {
        return FornecedorDAO.listarFornecedor();
    }
    
    // método para buscar cliente pelo nome
    public static List<Fornecedor> buscarPorNome(String nome) throws SQLException {
        return FornecedorDAO.buscarPorNome(nome);
    }
    
    // método para editar dados de um cliente cadastrado
    public static void editarFornecedor(int cod_forn, String nome_fantasia, String cnpj_forn, String fone_forn, String email_forn, String nome_resp) throws SQLException {
        Fornecedor fornecedor = new Fornecedor(nome_fantasia, cnpj_forn, fone_forn, email_forn, nome_resp);
        fornecedor.setCod_forn(cod_forn);
        FornecedorDAO.editarFornecedor(fornecedor);
    }
    
    // método para deletar cliente cadastrado
    public static void deletarFornecedor(int cod_forn) throws SQLException {
        FornecedorDAO.deletarFornecedor(cod_forn);
    }
    
}
