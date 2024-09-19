package model;

/**
*
* @author rebeca
*/

public class Marca {
    private int cod_marca;
    private String nome_marca;
    
    public Marca() {}
    
    public Marca(String nome_marca) {
        this.nome_marca = nome_marca;
    }

    public int getCod_marca() {
        return cod_marca;
    }

    public void setCod_marca(int cod_marca) {
        this.cod_marca = cod_marca;
    }

    public String getNome_marca() {
        return nome_marca;
    }

    public void setNome_marca(String nome_marca) {
        this.nome_marca = nome_marca;
    }
    
}
