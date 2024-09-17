package dao;

/**
*
* @author rebeca
*/

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Categoria_Produto;

public class Categoria_ProdutoDAO {
    
     public static void cadastrarCategoria(Categoria_Produto categoria_produto) throws SQLException {
        String sql = "INSERT INTO Categoria_Produto (Nome_Categoria, Desc_Categoria) VALUES (?, ?)";
        try (Connection con = Connect.getConnection(); PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, categoria_produto.getNome_categoria());
            stmt.setString(2, categoria_produto.getDesc_categoria());
            stmt.execute();
            JOptionPane.showMessageDialog(null, "Categoria do produto cadastrado com sucesso", "Cadastro", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar categoria do produto: " + e.getMessage());
        }
    }
     
    public static List<Categoria_Produto> listarCategoria() throws SQLException {
        List<Categoria_Produto> categorias = new ArrayList<>();
 
        String sql = "SELECT * FROM Categoria_Produto";
        try (Connection con = Connect.getConnection(); PreparedStatement stmt = con.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Categoria_Produto categoria = new Categoria_Produto();
                categoria.setCod_categoria(rs.getInt("Cod_Categoria"));
                categoria.setNome_categoria(rs.getString("Nome_Categoria"));
                categoria.setDesc_categoria(rs.getString("Desc_Categoria"));
                categorias.add(categoria);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar categorias: " + e.getMessage());
        }
 
        return categorias;
    }
 
    // método que busca uma categoria pelo nome no banco de dados
    public static List<Categoria_Produto> buscarPorNome(String nome) throws SQLException {
        List<Categoria_Produto> categorias = new ArrayList<>();
 
        String sql = "SELECT * FROM Categoria_Produto WHERE Nome_Categoria like ? ORDER BY Nome_Categoria";
        try (Connection con = Connect.getConnection(); PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, "%" + nome + "%");
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                Categoria_Produto categoria = new Categoria_Produto();
                categoria.setCod_categoria(rs.getInt("Cod_Categoria"));
                categoria.setNome_categoria(rs.getString("Nome_Categoria"));
                categoria.setDesc_categoria(rs.getString("Desc_Categoria"));
                categorias.add(categoria);
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar categorias: " + e.getMessage());
        }
 
        return categorias;
    }
    
    // método que edita cargos cadastrados no banco de dados
    public static void editarCategoria(Categoria_Produto categoria) throws SQLException {
        String sql = "UPDATE Cargo SET Nome_Categoria=?, Desc_Categoria=? WHERE Cod_Categoria=?";
        try (Connection con = Connect.getConnection(); PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(3, categoria.getCod_categoria());
            stmt.setString(1, categoria.getNome_categoria());
            stmt.setString(2, categoria.getDesc_categoria());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Cadastro atualizado com sucesso", "Editar", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar categorias: " + e.getMessage());
        }
    }
    
    // método que deleta cargos cadastrados no banco de dados
    public static void deletarCategoria(int id_categoria) throws SQLException {
        String sql = "DELETE FROM Categoria_Produto WHERE Cod_Categoria=?";
        try (Connection con = Connect.getConnection(); PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, id_categoria);
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Categoria deletada com sucesso", "Deletar", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao deletar a categoria: " + e.getMessage());
        }
    }
}