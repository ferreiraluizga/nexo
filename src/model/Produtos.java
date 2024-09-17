/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Admin
 */
public class Produtos {
    	private int Cod_Produtos; 
	private String Nome_Prod; 
	private float Preco_Prod; 
	private int Quant_Estoque; 
	private int Cod_Forn;
	private int Cod_Marca;
	private int Cod_Categoria;
        
    public int getCod_Produtos() {
        return Cod_Produtos;
    }

    public void setCod_Produtos(int Cod_Produtos) {
        this.Cod_Produtos = Cod_Produtos;
    }

    public String getNome_Prod() {
        return Nome_Prod;
    }

    public void setNome_Prod(String Nome_Prod) {
        this.Nome_Prod = Nome_Prod;
    }

    public float getPreco_Prod() {
        return Preco_Prod;
    }

    public void setPreco_Prod(float Preco_Prod) {
        this.Preco_Prod = Preco_Prod;
    }

    public int getQuant_Estoque() {
        return Quant_Estoque;
    }

    public void setQuant_Estoque(int Quant_Estoque) {
        this.Quant_Estoque = Quant_Estoque;
    }

    public int getCod_Forn() {
        return Cod_Forn;
    }

    public void setCod_Forn(int Cod_Forn) {
        this.Cod_Forn = Cod_Forn;
    }

    public int getCod_Marca() {
        return Cod_Marca;
    }

    public void setCod_Marca(int Cod_Marca) {
        this.Cod_Marca = Cod_Marca;
    }

    public int getCod_Categoria() {
        return Cod_Categoria;
    }

    public void setCod_Categoria(int Cod_Categoria) {
        this.Cod_Categoria = Cod_Categoria;
    }

}
