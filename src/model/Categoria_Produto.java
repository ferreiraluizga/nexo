package model;

/**
*
* @author rebeca
*/

public class Categoria_Produto {
    private int cod_categoria;
    private String nome_categoria;
    private String desc_categoria;
    
    public Categoria_Produto() {}
    
    public Categoria_Produto(String nome_categoria, String desc_categoria) {
        this.nome_categoria = nome_categoria;
        this.desc_categoria = desc_categoria;
    }

    public int getCod_categoria() {
        return cod_categoria;
    }

    public void setCod_categoria(int cod_categoria) {
        this.cod_categoria = cod_categoria;
    }

    public String getNome_categoria() {
        return nome_categoria;
    }

    public void setNome_categoria(String nome_categoria) {
        this.nome_categoria = nome_categoria;
    }

    public String getDesc_categoria() {
        return desc_categoria;
    }

    public void setDesc_categoria(String desc_categoria) {
        this.desc_categoria = desc_categoria;
    }
    
}
