package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Produto;

/**
 *
 * @author ferreiraluizga
 */

public class ProdutoDAO {

    // método que cadastra produtos no banco de dados
    public static void cadastrarProduto(Produto produto) throws SQLException {
        String sql = "INSERT INTO produto (Nome_Prod, Preco_Prod, Quant_Estoque, Cod_Forn, Cod_Marca, Cod_Categoria) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection con = Connect.getConnection(); PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, produto.getNome_Prod());
            stmt.setFloat(2, produto.getPreco_Prod());
            stmt.setInt(3, produto.getQuant_Estoque());
            stmt.setInt(4, produto.getCod_Forn());
            stmt.setInt(5, produto.getCod_Marca());
            stmt.setInt(6, produto.getCod_Categoria());
            stmt.execute();
            JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso", "Cadastro", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar produto: " + e.getMessage());
        }
    }

    // método que lista os produtos cadastrados no banco de dados
    public static List<Produto> listarProduto() throws SQLException {
        List<Produto> produtos = new ArrayList<>();

        String sql = "SELECT * FROM produto";
        try (Connection con = Connect.getConnection(); PreparedStatement stmt = con.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Produto produto = new Produto();
                produto.setCod_Produto(rs.getInt("Cod_Prod"));
                produto.setNome_Prod(rs.getString("Nome_Prod"));
                produto.setPreco_Prod(rs.getFloat("Preco_Prod"));
                produto.setQuant_Estoque(rs.getInt("Quant_Estoque"));
                produto.setCod_Forn(rs.getInt("Cod_Forn"));
                produto.setCod_Marca(rs.getInt("Cod_Marca"));
                produto.setCod_Categoria(rs.getInt("Cod_Categoria"));
                produtos.add(produto);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar produtos: " + e.getMessage());
        }

        return produtos;
    }

    // método que busca um produto pelo nome no banco de dados
    public static List<Produto> buscarPorNome(String nome) throws SQLException {
        List<Produto> produtos = new ArrayList<>();

        String sql = "SELECT * FROM produto WHERE Nome_Cli like ? ORDER BY Nome_Prod";
        try (Connection con = Connect.getConnection(); PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, "%" + nome + "%");
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Produto produto = new Produto();
                    produto.setCod_Produto(rs.getInt("Cod_Prod"));
                    produto.setNome_Prod(rs.getString("Nome_Prod"));
                    produto.setPreco_Prod(rs.getFloat("Preco_Prod"));
                    produto.setQuant_Estoque(rs.getInt("Quant_Estoque"));
                    produto.setCod_Forn(rs.getInt("Cod_Forn"));
                    produto.setCod_Marca(rs.getInt("Cod_Marca"));
                    produto.setCod_Categoria(rs.getInt("Cod_Categoria"));
                    produtos.add(produto);
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar cliente: " + e.getMessage());
        }

        return produtos;
    }

    // método que edita produtos cadastrados no banco de dados
    public static void editarProduto(Produto produto) throws SQLException {
        String sql = "UPDATE produto SET Nome_Prod=?, Preco_Prod=?, Quant_Estoque=?, Cod_Forn=?, Cod_Marca=?, Cod_Categoria=? WHERE Cod_Prod=?";
        try (Connection con = Connect.getConnection(); PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(7, produto.getCod_Produto());
            stmt.setString(1, produto.getNome_Prod());
            stmt.setFloat(2, produto.getPreco_Prod());
            stmt.setInt(3, produto.getQuant_Estoque());
            stmt.setInt(4, produto.getCod_Forn());
            stmt.setInt(5, produto.getCod_Marca());
            stmt.setInt(6, produto.getCod_Categoria());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Produto atualizado com sucesso", "Editar", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar produto: " + e.getMessage());
        }
    }

    // método que deleta produtos cadastrados no banco de dados
    public static void deletarProduto(int id_prod) throws SQLException {
        String sql = "DELETE FROM produto WHERE Cod_Prod=?";
        try (Connection con = Connect.getConnection(); PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, id_prod);
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Produto deletado com sucesso", "Deletar", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao deletar produto: " + e.getMessage());
        }
    }

}
