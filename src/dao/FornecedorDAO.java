package dao;

/**
*
* @author rebeca
*/

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Fornecedor;

public class FornecedorDAO {
    
    // método público para cadastrar fornecedor
    public static void cadastrarFornecedor(Fornecedor fornecedor) throws SQLException {
        String sql = "INSERT INTO fornecedor (Nome_Fantasia, CNPJ_Forn, Fone_Forn, Email_Forn, Nome_Resp) VALUES (?, ?, ?, ?, ?)";
        try (Connection con = Connect.getConnection(); PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, fornecedor.getNome_fantasia());
            stmt.setString(2, fornecedor.getCnpj_forn());
            stmt.setString(3, fornecedor.getFone_forn());
            stmt.setString(4, fornecedor.getEmail_forn());
            stmt.setString(5, fornecedor.getNome_resp());
            stmt.execute();
            JOptionPane.showMessageDialog(null, "Fornecedor cadastrado com sucesso", "Cadastro", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar fornecedores: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    // método público para listar fornecedores cadastrados
    public static List<Fornecedor> listarFornecedor() throws SQLException {
        List<Fornecedor> fornecedores = new ArrayList<>();
 
        String sql = "SELECT * FROM fornecedor";
        try (Connection con = Connect.getConnection(); PreparedStatement stmt = con.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Fornecedor fornecedor = new Fornecedor();
                fornecedor.setCod_forn(rs.getInt("Cod_Forn"));
                fornecedor.setNome_fantasia(rs.getString("Nome_Fantasia"));
                fornecedor.setCnpj_forn(rs.getString("CNPJ_Forn"));
                fornecedor.setFone_forn(rs.getString("Fone_Forn"));
                fornecedor.setEmail_forn(rs.getString("Email_Forn"));
                fornecedor.setNome_resp(rs.getString("Nome_Resp"));
                fornecedores.add(fornecedor);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar fornecedores: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
 
        return fornecedores;
    }
 
    // método público que busca um fornecedor pelo nome no sistema
    public static List<Fornecedor> buscarPorNome(String nome) throws SQLException {
        List<Fornecedor> fornecedores = new ArrayList<>();
 
        String sql = "SELECT * FROM fornecedor WHERE Nome_Fantasia like ? ORDER BY Nome_Fantasia";
        try (Connection con = Connect.getConnection(); PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, nome + "%");
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Fornecedor fornecedor = new Fornecedor();
                    fornecedor.setCod_forn(rs.getInt("Cod_Forn"));
                    fornecedor.setNome_fantasia(rs.getString("Nome_Fantasia"));
                    fornecedor.setCnpj_forn(rs.getString("CNPJ_Forn"));
                    fornecedor.setFone_forn(rs.getString("Fone_Forn"));
                    fornecedor.setEmail_forn(rs.getString("Email_Forn"));
                    fornecedor.setNome_resp(rs.getString("Nome_Resp"));
                    fornecedores.add(fornecedor);
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar fornecedores: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
 
        return fornecedores;
    }
    
    // método público que edita fornecedores cadastrados no sistema
    public static void editarFornecedor(Fornecedor fornecedor) throws SQLException {
        String sql = "UPDATE fornecedor SET Nome_Fantasia=?, CNPJ_Forn=?, Fone_Forn=?, Email_Forn=?, Nome_Resp=? WHERE Cod_Forn=?";
        try (Connection con = Connect.getConnection(); PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(6, fornecedor.getCod_forn());
            stmt.setString(1, fornecedor.getNome_fantasia());
            stmt.setString(2, fornecedor.getCnpj_forn());
            stmt.setString(3, fornecedor.getFone_forn());
            stmt.setString(4, fornecedor.getEmail_forn());
            stmt.setString(5, fornecedor.getNome_resp());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Cadastro atualizado com sucesso", "Editar", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao editar fornecedores: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    // método públicoque deleta fornecedores cadastrados no banco de dados
    public static void deletarFornecedor(int id_forn) throws SQLException {
        String sql = "DELETE FROM fornecedor WHERE Cod_Forn=?";
        try (Connection con = Connect.getConnection(); PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, id_forn);
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Fornecedor deletado com sucesso", "Deletar", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao deletar fornecedores: " + e.getMessage());
        }
    }
}
