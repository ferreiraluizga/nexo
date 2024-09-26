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
    private CategoriaProduto categoria;
    
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

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor forn) {
        this.fornecedor = forn;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public CategoriaProduto getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaProduto categoria) {
        this.categoria = categoria;
    }

}
