package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.CategoriaProduto;
import model.Fornecedor;
import model.Marca;
import model.Produto;

/**
 *
 * @author ferreiraluizga
 */

public class ProdutoDAO {

    // método público que cadastra produtos no banco de dados
    public static void cadastrarProduto(Produto produto) throws SQLException {
        String sql = "INSERT INTO produto (Nome_Prod, Preco_Prod, Quant_Estoque, Cod_Forn, Cod_Marca, Cod_Categoria) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection con = Connect.getConnection(); PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, produto.getNome_Prod());
            stmt.setFloat(2, produto.getPreco_Prod());
            stmt.setInt(3, produto.getQuant_Estoque());
            stmt.setInt(4, produto.getFornecedor().getCod_forn());
            stmt.setInt(5, produto.getMarca().getCod_marca());
            stmt.setInt(6, produto.getCategoria().getCod_categoria());
            stmt.execute();
            JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso", "Cadastro", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar produto: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    // método público que lista os produtos cadastrados no banco de dados
    public static List<Produto> listarProduto() throws SQLException {
        List<Produto> produtos = new ArrayList<>();

        String sql = "SELECT * FROM produto "
                + "INNER JOIN fornecedor ON produto.Cod_Forn = fornecedor.Cod_Forn "
                + "INNER JOIN marca ON produto.Cod_Marca = marca.Cod_Marca "
                + "INNER JOIN categoria_produto ON produto.Cod_Categoria = categoria_produto.Cod_Categoria";
        try (Connection con = Connect.getConnection(); PreparedStatement stmt = con.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Produto produto = new Produto();
                Fornecedor fornecedor = new Fornecedor();
                Marca marca = new Marca();
                CategoriaProduto categoria = new CategoriaProduto();
                
                fornecedor.setCod_forn(rs.getInt("Cod_Forn"));
                fornecedor.setNome_fantasia(rs.getString("Nome_Fantasia"));
                fornecedor.setCnpj_forn(rs.getString("CNPJ_Forn"));
                fornecedor.setFone_forn(rs.getString("Fone_Forn"));
                fornecedor.setEmail_forn(rs.getString("Email_Forn"));
                fornecedor.setNome_resp(rs.getString("Nome_Resp"));
                
                marca.setCod_marca(rs.getInt("Cod_Marca"));
                marca.setNome_marca(rs.getString("Nome_Marca"));
                
                categoria.setCod_categoria(rs.getInt("Cod_Categoria"));
                categoria.setNome_categoria(rs.getString("Nome_Categoria"));
                categoria.setDesc_categoria(rs.getString("Desc_Categoria"));
                
                produto.setCod_Produto(rs.getInt("Cod_Prod"));
                produto.setNome_Prod(rs.getString("Nome_Prod"));
                produto.setPreco_Prod(rs.getFloat("Preco_Prod"));
                produto.setQuant_Estoque(rs.getInt("Quant_Estoque"));
                produto.setFornecedor(fornecedor);
                produto.setMarca(marca);
                produto.setCategoria(categoria);
                produtos.add(produto);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar produtos: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }

        return produtos;
    }

    // método que busca um produto pelo nome no banco de dados
    public static List<Produto> buscarPorNome(String nome) throws SQLException {
        List<Produto> produtos = new ArrayList<>();

        String sql = "SELECT * FROM produto "
                + "INNER JOIN fornecedor ON produto.Cod_Forn = fornecedor.Cod_Forn "
                + "INNER JOIN marca ON produto.Cod_Marca = marca.Cod_Marca "
                + "INNER JOIN categoria_produto ON produto.Cod_Categoria = categoria_produto.Cod_Categoria "
                + "WHERE Nome_Prod like ? ORDER BY Nome_Prod";
        try (Connection con = Connect.getConnection(); PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, nome + "%");
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                Produto produto = new Produto();
                Fornecedor fornecedor = new Fornecedor();
                Marca marca = new Marca();
                CategoriaProduto categoria = new CategoriaProduto();
                
                fornecedor.setCod_forn(rs.getInt("Cod_Forn"));
                fornecedor.setNome_fantasia(rs.getString("Nome_Fantasia"));
                fornecedor.setCnpj_forn(rs.getString("CNPJ_Forn"));
                fornecedor.setFone_forn(rs.getString("Fone_Forn"));
                fornecedor.setEmail_forn(rs.getString("Email_Forn"));
                fornecedor.setNome_resp(rs.getString("Nome_Resp"));
                
                marca.setCod_marca(rs.getInt("Cod_Marca"));
                marca.setNome_marca(rs.getString("Nome_Marca"));
                
                categoria.setCod_categoria(rs.getInt("Cod_Categoria"));
                categoria.setNome_categoria(rs.getString("Nome_Categoria"));
                categoria.setDesc_categoria(rs.getString("Desc_Categoria"));
                
                produto.setCod_Produto(rs.getInt("Cod_Prod"));
                produto.setNome_Prod(rs.getString("Nome_Prod"));
                produto.setPreco_Prod(rs.getFloat("Preco_Prod"));
                produto.setQuant_Estoque(rs.getInt("Quant_Estoque"));
                produto.setFornecedor(fornecedor);
                produto.setMarca(marca);
                produto.setCategoria(categoria);
                produtos.add(produto);
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar produto: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }

        return produtos;
    }
    
    // método que busca um produto pelo nome no banco de dados
    public static Produto buscarPorId(int id) throws SQLException {
        Produto prod = new Produto();

        String sql = "SELECT * FROM produto "
                + "INNER JOIN fornecedor ON produto.Cod_Forn = fornecedor.Cod_Forn "
                + "INNER JOIN marca ON produto.Cod_Marca = marca.Cod_Marca "
                + "INNER JOIN categoria_produto ON produto.Cod_Categoria = categoria_produto.Cod_Categoria "
                + "WHERE Cod_Prod = ?";
        try (Connection con = Connect.getConnection(); PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                Fornecedor fornecedor = new Fornecedor();
                Marca marca = new Marca();
                CategoriaProduto categoria = new CategoriaProduto();
                
                fornecedor.setCod_forn(rs.getInt("Cod_Forn"));
                fornecedor.setNome_fantasia(rs.getString("Nome_Fantasia"));
                fornecedor.setCnpj_forn(rs.getString("CNPJ_Forn"));
                fornecedor.setFone_forn(rs.getString("Fone_Forn"));
                fornecedor.setEmail_forn(rs.getString("Email_Forn"));
                fornecedor.setNome_resp(rs.getString("Nome_Resp"));
                
                marca.setCod_marca(rs.getInt("Cod_Marca"));
                marca.setNome_marca(rs.getString("Nome_Marca"));
                
                categoria.setCod_categoria(rs.getInt("Cod_Categoria"));
                categoria.setNome_categoria(rs.getString("Nome_Categoria"));
                categoria.setDesc_categoria(rs.getString("Desc_Categoria"));
                
                prod.setCod_Produto(rs.getInt("Cod_Prod"));
                prod.setNome_Prod(rs.getString("Nome_Prod"));
                prod.setPreco_Prod(rs.getFloat("Preco_Prod"));
                prod.setQuant_Estoque(rs.getInt("Quant_Estoque"));
                prod.setFornecedor(fornecedor);
                prod.setMarca(marca);
                prod.setCategoria(categoria);
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar produto: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }

        return prod;
    }

    // método público que edita produtos cadastrados no banco de dados
    public static void editarProduto(Produto produto) throws SQLException {
        String sql = "UPDATE produto SET Nome_Prod=?, Preco_Prod=?, Quant_Estoque=?, Cod_Forn=?, Cod_Marca=?, Cod_Categoria=? WHERE Cod_Prod=?";
        try (Connection con = Connect.getConnection(); PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(7, produto.getCod_Produto());
            stmt.setString(1, produto.getNome_Prod());
            stmt.setFloat(2, produto.getPreco_Prod());
            stmt.setInt(3, produto.getQuant_Estoque());
            stmt.setInt(4, produto.getFornecedor().getCod_forn());
            stmt.setInt(5, produto.getMarca().getCod_marca());
            stmt.setInt(6, produto.getCategoria().getCod_categoria());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Produto atualizado com sucesso", "Editar", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar produto: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    // método público que deleta produtos cadastrados no banco de dados
    public static void deletarProduto(int id_prod) throws SQLException {
        String sql = "DELETE FROM produto WHERE Cod_Prod=?";
        try (Connection con = Connect.getConnection(); PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, id_prod);
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Produto deletado com sucesso", "Deletar", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao deletar produto: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

}
