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
    
    public static void cadastrarProdCompra(int cod_compra, int cod_prod, int quant_prod) throws SQLException {
        Compra compra = new Compra();
        compra.setCod_Compra(cod_compra);
        
        Produto prod = new Produto();
        prod.setCod_Produto(cod_prod);
        
        ProdCompra prodCompra = new ProdCompra(compra, prod, quant_prod);
        
        ProdCompraDAO.cadastrarProdCompra(prodCompra);
    }
    
    public static void deletarProdCompra(int cod_compra) throws SQLException {
        ProdCompraDAO.deletarProdCompra(cod_compra);
    }
    
}
