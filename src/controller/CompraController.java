package controller;

import dao.CompraDAO;
import java.sql.*;
import java.time.LocalDate;
import java.util.List;
import model.Compra;
import model.Cliente;
import model.FormaPag;
import model.Funcionario;

/**
 *
 * @author rebeca
 */

public class CompraController {
    
    
    // método para cadastrar compra
    public static int cadastrarCompra(Funcionario func, Cliente cliente, LocalDate data, FormaPag forma_pag) throws SQLException {
        Compra compra = new Compra(func, cliente, data, forma_pag);
        return CompraDAO.cadastrarCompra(compra);
    }
    
    // método para listar compras cadastradas
    public static List<Compra> listarCompra() throws SQLException {
        return CompraDAO.listarCompra();
    }
    
    // método para buscar compra pelo id
    public static List<Compra> buscarPorId(int id) throws SQLException {
        return CompraDAO.buscarPorId(id);
    }
    
    // método para buscar compra pelo nome do funcionario
    public static List<Compra> buscarPorFuncionario(String nome) throws SQLException {
        return CompraDAO.buscarPorFuncionario(nome);
    }
    
    // método para buscar compra pelo nome do cliente
    public static List<Compra> buscarPorCliente(String nome) throws SQLException {
        return CompraDAO.buscarPorCliente(nome);
    }
    
    // método para deletar compra cadastrada
    public static void deletarCompra(int id_compra) throws SQLException {
        CompraDAO.deletarCompra(id_compra);
    }
    
    // método para calcular valor total da compra
    public static float calcularValorTotalCompra(int codCompra) {
        return CompraDAO.calcularValorTotalCompra(codCompra);
    }
    
}

