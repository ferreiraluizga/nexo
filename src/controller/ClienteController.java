package controller;

import dao.ClienteDAO;
import java.sql.*;
import java.util.List;
import model.Cliente;

/**
 *
 * @author ferreiraluizga
 */

public class ClienteController {
    
    // método para cadastrar cliente
    public static int cadastrarCliente(String nome, int ativo_clube, String telefone) throws SQLException {
        Cliente cliente = new Cliente(nome, ativo_clube, telefone);
        return ClienteDAO.cadastrarCliente(cliente);
    }
    
    // método para listar clientes cadastrados
    public static List<Cliente> listarCliente() throws SQLException {
        return ClienteDAO.listarCliente();
    }
    
    // método para buscar cliente pelo nome
    public static List<Cliente> buscarPorNome(String nome) throws SQLException {
        return ClienteDAO.buscarPorNome(nome);
    }
    
    // método para editar dados de um cliente cadastrado
    public static void editarCliente(int cod_cli, String nome, int ativo_clube, String telefone) throws SQLException {
        Cliente cliente = new Cliente(nome, ativo_clube, telefone);
        cliente.setCod_cli(cod_cli);
        ClienteDAO.editarCliente(cliente);
    }
    
    // método para deletar cliente cadastrado
    public static void deletarCliente(int cod_cli) throws SQLException {
        ClienteDAO.deletarCliente(cod_cli);
    }
    
}
