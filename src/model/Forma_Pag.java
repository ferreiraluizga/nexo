package model;

/**
*
* @author rebeca
*/

public class Forma_Pag {
    private int cod_forma_pag;
    private String nome_forma;
    
    public Forma_Pag() {}
    
    public Forma_Pag(String nome_forma) {
        this.nome_forma = nome_forma;
    }

    public int getCod_forma_pag() {
        return cod_forma_pag;
    }

    public void setCod_forma_pag(int cod_forma_pag) {
        this.cod_forma_pag = cod_forma_pag;
    }

    public String getNome_forma() {
        return nome_forma;
    }

    public void setNome_forma(String nome_forma) {
        this.nome_forma = nome_forma;
    }
}
