package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Produto;
import model.Compra;

/**
 *
 * @author ferreiraluizga
 */

public class CompraDAO {

    // método que cadastra produtos no banco de dados
    public static void cadastrarCompra(Compra compra) throws SQLException {
        String sql = "INSERT INTO compra (Cod_Func, Cod_Cli, Data_Compra, Cod_Forma_Pag) VALUES (?, ?, ?, ?)";
        try (Connection con = Connect.getConnection(); PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, compra.getCod_Func());
            stmt.setFloat(2, compra.getCod_Cli());
            stmt.setDate(3, (Date) compra.getData_Compra());
            stmt.setInt(4, compra.getCod_Forma_Pag());
            stmt.execute();
            JOptionPane.showMessageDialog(null, "Compra cadastrada com sucesso", "Cadastro", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar compra: " + e.getMessage());
        }
    }

    // método que lista os produtos cadastrados no banco de dados
    public static List<Compra> listarCompra() throws SQLException {
        List<Compra> compras = new ArrayList<>();

        String sql = "SELECT * FROM produto";
        try (Connection con = Connect.getConnection(); PreparedStatement stmt = con.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Compra compra = new Compra();
                compra.setCod_Compra(rs.getInt("Cod_Prod"));
                compra.setCod_Func(rs.getInt("Cod_Func"));
                compra.setCod_Cli(rs.getInt("Cod_Cli"));
                compra.setData_Compra(rs.getDate("Data_Compra"));
                compra.setCod_Forma_Pag(rs.getInt("Cod_Forma_Pag"));
                compras.add(compra);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar produtos: " + e.getMessage());
        }

        return compras;
    }

    // método que deleta produtos cadastrados no banco de dados
    public static void deletarProduto(int id_compra) throws SQLException {
        ProdutosCompraDAO.deletarProdutosCompra(id_compra);
        String sql = "DELETE FROM produto WHERE Cod_Prod=?";
        try (Connection con = Connect.getConnection(); PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, id_compra);
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Compra deletada com sucesso", "Deletar", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao deletar compra: " + e.getMessage());
        }
    }

}
