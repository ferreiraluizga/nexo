package model;

/**
 *
 * @author vitor
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
    
    public Compra getCompra() {
        return compra;
    }

    public void setCompra(Compra compra) {
        this.compra = compra;
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
