package controller;

import dao.ProdCompraDAO;
import java.sql.SQLException;
import model.Compra;
import model.ProdCompra;
import model.Produto;

/**
 *
 * @author ferreiraluizga
 */

public class ProdCompraController {
    
    // método público para cadastrar produtos da compra
    public static void cadastrarProdCompra(Compra compra, Produto prod, int quant_prod) throws SQLException {
        ProdCompra prodCompra = new ProdCompra(compra, prod, quant_prod);        
        ProdCompraDAO.cadastrarProdCompra(prodCompra);
    }
    
    // método público para deletar produtos da compra
    public static void deletarProdCompra(int cod_compra) throws SQLException {
        ProdCompraDAO.deletarProdCompra(cod_compra);
    }
    
}
