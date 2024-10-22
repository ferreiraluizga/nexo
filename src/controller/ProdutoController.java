package controller;

import dao.ProdutoDAO;
import java.sql.SQLException;
import java.util.List;
import model.CategoriaProduto;
import model.Fornecedor;
import model.Marca;
import model.Produto;

/**
 *
 * @author ferreiraluizga
 */
public class ProdutoController {
    
    // método público para cadastrar produto
    public static void cadastrarProduto(String nome_prod, float preco_prod, int quant_estoque, Fornecedor fornecedor, Marca marca, CategoriaProduto categoria) throws SQLException {
        Produto prod = new Produto(nome_prod, preco_prod, quant_estoque, fornecedor, marca, categoria);
        ProdutoDAO.cadastrarProduto(prod);
    }
    
    // método público para listar produtos
    public static List<Produto> listarProduto() throws SQLException {
        return ProdutoDAO.listarProduto();
    }
    
    // método público para buscar produtos
    public static List<Produto> buscarPorNome(String nome) throws SQLException {
        return ProdutoDAO.buscarPorNome(nome);
    }
    
    // método público para buscar produtos por id
    public static Produto buscarPorId(int id) throws SQLException {
        return ProdutoDAO.buscarPorId(id);
    }
    
    // método público para editar produtos cadastrados
    public static void editarProduto(int cod_prod, String nome_prod, float preco_prod, int quant_estoque, Fornecedor fornecedor, Marca marca, CategoriaProduto categoria) throws SQLException {
        Produto prod = new Produto(nome_prod, preco_prod, quant_estoque, fornecedor, marca, categoria);
        prod.setCod_Produto(cod_prod);
        ProdutoDAO.editarProduto(prod);
    }
    
    // método público para deletar produto
    public static void deletarProduto(int cod_prod) throws SQLException {
        ProdutoDAO.deletarProduto(cod_prod);
    }
    
    // método para atualizar estoque após compra efetuada
    public static void atualizarQuantidadeProduto(int cod_prod, int quant_prod) throws SQLException {
        Produto prod = new Produto();
        prod.setCod_Produto(cod_prod);
        prod.setQuant_Estoque(quant_prod);
        ProdutoDAO.atualizarQuantidadeProduto(prod);
    }
}
