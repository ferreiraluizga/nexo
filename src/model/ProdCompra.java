package model;

/**
 *
 * @author Admin
 */

public class ProdCompra {
    private Compra compra;  
    private Produto produto; 
    private int quant_prod;
    
    public ProdCompra() {}
    
    public ProdCompra(Compra compra, Produto produto, int quant_prod) {
        this.compra = compra;
        this.produto = produto;
        this.quant_prod = quant_prod;
    }
    
    public int getCod_Compra() {
        return compra.getCod_Compra();
    }

    public void setCod_Compra(int Cod_Compra) {
        if (this.compra == null) {
            this.compra = new Compra();
        }
        this.compra.setCod_Compra(Cod_Compra);
    }

    public Produto getProd() {
        return produto;
    }

    public void setProd(Produto prod) {
        this.produto = prod;
    }

    public int getQuant_Prod() {
        return quant_prod;
    }

    public void setQuant_Prod(int Quant_Prod) {
        this.quant_prod = Quant_Prod;
    }
 
}
