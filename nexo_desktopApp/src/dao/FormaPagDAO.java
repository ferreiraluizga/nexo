package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.FormaPag;

/**
 *
 * @author vitor
 */

public class FormaPagDAO {

    // método que cadastra forma de pagamento no banco de dados
    public static void cadastrarForma(FormaPag forma) throws SQLException {
        String sql = "INSERT INTO forma_pag (Nome_Forma) VALUES (?)";
        try (Connection con = Connect.getConnection(); PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, forma.getNome_forma());
            stmt.execute();
            JOptionPane.showMessageDialog(null, "Forma de Pagamento cadastrada com sucesso", "Cadastro", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar forma de pagamento: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    // método que lista as formas de pagamento cadastradas no banco de dados
    public static List<FormaPag> listarForma() throws SQLException {
        List<FormaPag> formas = new ArrayList<>();
        String sql = "SELECT * FROM forma_pag";
        try (Connection con = Connect.getConnection(); PreparedStatement stmt = con.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                FormaPag forma = new FormaPag();
                forma.setCod_forma_pag(rs.getInt("Cod_Forma_Pag"));
                forma.setNome_forma(rs.getString("Nome_Forma"));
                formas.add(forma);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar formas de pagamento: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
        return formas;
    }

    // método que edita uma forma de pagamento cadastrada no banco de dados
    public static void editarForma(FormaPag forma) throws SQLException {
        String sql = "UPDATE forma_pag SET Nome_Forma=? WHERE Cod_Forma_Pag=?";
        try (Connection con = Connect.getConnection(); PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(2, forma.getCod_forma_pag());
            stmt.setString(1, forma.getNome_forma());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Cadastro atualizado com sucesso", "Editar", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao editar forma de pagamento: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    // método que deleta formas de pagamento cadastradas no banco de dados
    public static void deletarForma(int id_forma) throws SQLException {
        String sql = "DELETE FROM forma_pag WHERE Cod_Forma_Pag=?";
        try (Connection con = Connect.getConnection(); PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, id_forma);
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Forma de Pagamento deletada com sucesso", "Deletar", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao deletar forma de pagamento: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

}
