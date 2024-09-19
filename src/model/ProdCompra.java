package model;

/**
 *
 * @author Admin
 */

public class ProdCompra {
    private Compra compra;  
    private Produto produto; 
    private int quant_prod; 
    
    public int getCod_Compra() {
        return compra.getCod_Compra();
    }

    public void setCod_Compra(int Cod_Compra) {
        if (this.compra == null) {
            this.compra = new Compra();
        }
        this.compra.setCod_Compra(Cod_Compra);
    }

    public int getCod_Prod() {
        return produto.getCod_Produto();
    }

    public void setCod_Prod(int Cod_Prod) {
        if (this.produto == null) {
            this.produto = new Produto();
        }
        this.produto.setCod_Produto(Cod_Prod);
    }

    public int getQuant_Prod() {
        return quant_prod;
    }

    public void setQuant_Prod(int Quant_Prod) {
        this.quant_prod = Quant_Prod;
    }
 
}
