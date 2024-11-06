package dao;

/**
*
* @author rebeca
*/

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Marca;

public class MarcaDAO {
    
    // método público para cadastrar marca no sistema
    public static void cadastrarMarca(Marca marca) throws SQLException {
        String sql = "INSERT INTO marca (Nome_Marca) VALUES (?)";
        try (Connection con = Connect.getConnection(); PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, marca.getNome_marca());
            stmt.execute();
            JOptionPane.showMessageDialog(null, "Marca cadastrada com sucesso", "Cadastro", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar marcas: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    // método público para listar marcas cadastradas no sistema
    public static List<Marca> listarMarca() throws SQLException {
        List<Marca> marcas = new ArrayList<>();
 
        String sql = "SELECT * FROM marca";
        try (Connection con = Connect.getConnection(); PreparedStatement stmt = con.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Marca marca = new Marca();
                marca.setCod_marca(rs.getInt("Cod_Marca"));
                marca.setNome_marca(rs.getString("Nome_Marca"));
                marcas.add(marca);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar marcas: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
 
        return marcas;
    }
 
    // método público para buscar uma marca pelo nome no sistema
    public static List<Marca> buscarPorNome(String nome) throws SQLException {
        List<Marca> marcas = new ArrayList<>();
 
        String sql = "SELECT * FROM marca WHERE Nome_Marca like ? ORDER BY Nome_Marca";
        try (Connection con = Connect.getConnection(); PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, nome + "%");
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                Marca marca = new Marca();
                marca.setCod_marca(rs.getInt("Cod_Marca"));
                marca.setNome_marca(rs.getString("Nome_Marca"));
                marcas.add(marca);
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar marcas: " + e.getMessage());
        }
 
        return marcas;
    }
    
    // método público para editar uma marca cadastrada no sistema
    public static void editarMarca(Marca marca) throws SQLException {
        String sql = "UPDATE marca SET Nome_Marca=? WHERE Cod_Marca=?";
        try (Connection con = Connect.getConnection(); PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(2, marca.getCod_marca());
            stmt.setString(1, marca.getNome_marca());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Cadastro atualizado com sucesso", "Editar", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao editar marca: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    // método público para deletar uma marca cadastrada no sistema
    public static void deletarMarca(int id_marca) throws SQLException {
        String sql = "DELETE FROM marca WHERE Cod_Marca=?";
        try (Connection con = Connect.getConnection(); PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, id_marca);
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Marca deletada com sucesso", "Deletar", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao deletar marca: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}