package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.CategoriaProduto;

/**
*
* @author rebeca
*/

public class CategoriaProdutoDAO {
    
    // método público para cadastrar categoria 
    public static void cadastrarCategoria(CategoriaProduto categoria_produto) throws SQLException {
        String sql = "INSERT INTO categoria_produto (Nome_Categoria, Desc_Categoria) VALUES (?, ?)";
        try (Connection con = Connect.getConnection(); PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, categoria_produto.getNome_categoria());
            stmt.setString(2, categoria_produto.getDesc_categoria());
            stmt.execute();
            JOptionPane.showMessageDialog(null, "Categoria de Produto cadastrada com sucesso", "Cadastro", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar categoria de produto: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    // método público para listar categorias
    public static List<CategoriaProduto> listarCategoria() throws SQLException {
        List<CategoriaProduto> categorias = new ArrayList<>();
 
        String sql = "SELECT * FROM categoria_produto";
        try (Connection con = Connect.getConnection(); PreparedStatement stmt = con.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                CategoriaProduto categoria = new CategoriaProduto();
                categoria.setCod_categoria(rs.getInt("Cod_Categoria"));
                categoria.setNome_categoria(rs.getString("Nome_Categoria"));
                categoria.setDesc_categoria(rs.getString("Desc_Categoria"));
                categorias.add(categoria);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar categorias: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
 
        return categorias;
    }
 
    // método público que busca uma categoria pelo nome
    public static List<CategoriaProduto> buscarPorNome(String nome) throws SQLException {
        List<CategoriaProduto> categorias = new ArrayList<>();
 
        String sql = "SELECT * FROM categoria_produto WHERE Nome_Categoria like ? ORDER BY Nome_Categoria";
        try (Connection con = Connect.getConnection(); PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, "%" + nome + "%");
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                CategoriaProduto categoria = new CategoriaProduto();
                categoria.setCod_categoria(rs.getInt("Cod_Categoria"));
                categoria.setNome_categoria(rs.getString("Nome_Categoria"));
                categoria.setDesc_categoria(rs.getString("Desc_Categoria"));
                categorias.add(categoria);
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar categorias: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
 
        return categorias;
    }
    
    // método que edita categorias cadastradas no banco de dados
    public static void editarCategoria(CategoriaProduto categoria) throws SQLException {
        String sql = "UPDATE categoria_produto SET Nome_Categoria=?, Desc_Categoria=? WHERE Cod_Categoria=?";
        try (Connection con = Connect.getConnection(); PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(3, categoria.getCod_categoria());
            stmt.setString(1, categoria.getNome_categoria());
            stmt.setString(2, categoria.getDesc_categoria());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Cadastro atualizado com sucesso", "Editar", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao editar categoria: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    // método que deleta cargos cadastrados no banco de dados
    public static void deletarCategoria(int id_categoria) throws SQLException {
        String sql = "DELETE FROM categoria_produto WHERE Cod_Categoria=?";
        try (Connection con = Connect.getConnection(); PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, id_categoria);
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Categoria deletada com sucesso", "Deletar", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao deletar a categoria: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}