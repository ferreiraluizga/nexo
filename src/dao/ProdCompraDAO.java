package dao;

import java.sql.*;
import javax.swing.JOptionPane;
import model.ProdCompra;

/**
 *
 * @author ferreiraluizga
 */

public class ProdCompraDAO {
    
    // método para cadastrar produtos de uma compra que depende do cadastro de uma nova compra
    public static void cadastrarProdCompra(ProdCompra produtosCompra) throws SQLException {
        String sql = "INSERT INTO prod_compra (Cod_Compra, Cod_Prod, Quant_Prod) VALUES (?, ?, ?)";
        try (Connection con = Connect.getConnection(); PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, produtosCompra.getCompra().getCod_Compra());
            stmt.setInt(2, produtosCompra.getProd().getCod_Produto());
            stmt.setInt(3, produtosCompra.getQuant_Prod());
            stmt.execute();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar produtos da compra: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    // método para deletar produtos de uma compra, que é acionado ao deletar uma compra
    public static void deletarProdCompra(int cod_compra) throws SQLException {
        String sql = "DELETE FROM prod_compra WHERE Cod_Compra=?";
        try (Connection con = Connect.getConnection(); PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, cod_compra);
            stmt.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao deletar produtos da compra: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    
}
