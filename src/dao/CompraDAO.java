package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Cliente;
import model.Produto;
import model.Compra;
import model.FormaPag;
import model.Funcionario;

/**
 *
 * @author ferreiraluizga
 */

public class CompraDAO {

    // método que cadastra produtos no banco de dados
    public static void cadastrarCompra(Compra compra) throws SQLException {
        String sql = "INSERT INTO compra (Cod_Func, Cod_Cli, Data_Compra, Cod_Forma_Pag) VALUES (?, ?, ?, ?)";
        try (Connection con = Connect.getConnection(); PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, compra.getFunc().getCod_Func());
            stmt.setFloat(2, compra.getCliente().getCod_cli());
            stmt.setDate(3, (Date) compra.getData_Compra());
            stmt.setInt(4, compra.getForma_Pag().getCod_forma_pag());
            stmt.execute();
            JOptionPane.showMessageDialog(null, "Compra cadastrada com sucesso", "Cadastro", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar compra: " + e.getMessage());
        }
    }

    // método que lista os produtos cadastrados no banco de dados
    public static List<Compra> listarCompra() throws SQLException {
        List<Compra> compras = new ArrayList<>();

        String sql = "SELECT * FROM compra "
                + "INNER JOIN funcionario ON compra.Cod_Func = funcionario.Cod_Func "
                + "INNER JOIN cliente ON compra.Cod_Cli = cliente.Cod_Cli "
                + "INNER JOIN forma_pag ON compra.Cod_Forma_Pag = forma_pag.Cod_Forma_Pag";
        try (Connection con = Connect.getConnection(); PreparedStatement stmt = con.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Compra compra = new Compra();
                Funcionario func = new Funcionario();
                Cliente cliente = new Cliente();
                FormaPag forma = new FormaPag();
                
                func.setCod_Func(rs.getInt("Cod_Func"));
                
                cliente.setCod_cli(rs.getInt("Cod_Cli"));
                
                forma.setCod_forma_pag(rs.getInt("Cod_Forma_Pag"));
                
                compra.setCod_Compra(rs.getInt("Cod_Compra"));
                compra.setFunc(func);
                compra.setCliente(cliente);
                compra.setData_Compra(rs.getDate("Data_Compra"));
                compra.setForma_Pag(forma);
                compras.add(compra);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar produtos: " + e.getMessage());
        }

        return compras;
    }

    // método que deleta produtos cadastrados no banco de dados
    public static void deletarCompra(int id_compra) throws SQLException {
        ProdCompraDAO.deletarProdCompra(id_compra);
        String sql = "DELETE FROM compra WHERE Cod_Prod=?";
        try (Connection con = Connect.getConnection(); PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, id_compra);
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Compra deletada com sucesso", "Deletar", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao deletar compra: " + e.getMessage());
        }
    }

}
