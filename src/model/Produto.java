/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author vitor
 */

public class Produto {

    private int cod_produto;
    private String nome_prod;
    private float preco_prod;
    private int quant_estoque;
    private Fornecedor fornecedor;
    private Marca marca;
    private Categoria_Produto categoria;
    
    public Produto() {}

    public int getCod_Produto() {
        return cod_produto;
    }

    public void setCod_Produto(int Cod_Produto) {
        this.cod_produto = Cod_Produto;
    }

    public String getNome_Prod() {
        return nome_prod;
    }

    public void setNome_Prod(String Nome_Prod) {
        this.nome_prod = Nome_Prod;
    }

    public float getPreco_Prod() {
        return preco_prod;
    }

    public void setPreco_Prod(float Preco_Prod) {
        this.preco_prod = Preco_Prod;
    }

    public int getQuant_Estoque() {
        return quant_estoque;
    }

    public void setQuant_Estoque(int Quant_Estoque) {
        this.quant_estoque = Quant_Estoque;
    }

    public int getCod_Forn() {
        return fornecedor.getCod_forn();
    }

    public void setCod_Forn(int Cod_Forn) {
        if (this.fornecedor == null) {
            this.fornecedor = new Fornecedor();
        }
        this.fornecedor.setCod_forn(Cod_Forn);    
    }

    public int getCod_Marca() {
        return marca.getCod_marca();
    }

    public void setCod_Marca(int Cod_Marca) {
        if (this.marca == null) {
            this.marca = new Marca();
        }
        this.marca.setCod_marca(Cod_Marca); 
    }

    public int getCod_Categoria() {
        return categoria.getCod_categoria();
    }

    public void setCod_Categoria(int Cod_Categoria) {
        if (this.categoria == null) {
            this.categoria = new Categoria_Produto();
        }
        this.categoria.setCod_categoria(Cod_Categoria); 
    }

}
