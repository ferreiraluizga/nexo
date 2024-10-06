package controller;

import dao.CompraDAO;
import java.sql.*;
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
    public static void cadastrarCompra(Funcionario func, Cliente cliente, Date data, FormaPag forma_pag) throws SQLException {
        Compra compra = new Compra(func, cliente, data, forma_pag);
        CompraDAO.cadastrarCompra(compra);
    }
    
    // método para listar compras cadastradas
    public static List<Compra> listarCompra() throws SQLException {
        return CompraDAO.listarCompra();
    }
    
    
    // método para deletar compra cadastrada
    public static void deletarCompra(int id_compra) throws SQLException {
        CompraDAO.deletarCompra(id_compra);
    }
    
}
