package dao;

import java.sql.*;
import javax.swing.JOptionPane;
import model.ProdCompra;

public class ProdutosCompraDAO {
    
    // método para cadastrar produtos de uma compra que depende do cadastro de uma nova compra
    public static void cadastrarProdutosCompra(ProdCompra produtosCompra) throws SQLException {
        String sql = "INSERT INTO tb_produtos_compra (Cod_Compra, Cod_Prod, quant_Prod) VALUES (?, ?, ?)";
        try (Connection con = Connect.getConnection(); PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, produtosCompra.getCod_Compra());
            stmt.setInt(2, produtosCompra.getCod_Prod());
            stmt.setInt(3, produtosCompra.getQuant_Prod());
            stmt.execute();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar produtos da compra: " + e.getMessage());
        }
    }
    
    // método para deletar produtos de uma compra, que é acionado ao deletar uma compra
    public static void deletarProdutosCompra(int id_compra) throws SQLException {
        String sql = "DELETE FROM prod_compra WHERE Cod_Compra=?";
        try (Connection con = Connect.getConnection(); PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, id_compra);
            stmt.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao deletar produtos da compra: " + e.getMessage());
        }
    }
    
}
