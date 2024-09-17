package model;

/**
*
* @author rebeca
*/

public class Fornecedor {
    private int cod_forn;
    private String nome_fantasia;
    private String cnpj_forn;
    private String fone_forn;
    private String email_forn;
    private String nome_resp;
    
    public Fornecedor() {}

    public int getCod_forn() {
        return cod_forn;
    }

    public void setCod_forn(int cod_forn) {
        this.cod_forn = cod_forn;
    }

    public String getNome_fantasia() {
        return nome_fantasia;
    }

    public void setNome_fantasia(String nome_fantasia) {
        this.nome_fantasia = nome_fantasia;
    }

    public String getCnpj_forn() {
        return cnpj_forn;
    }

    public void setCnpj_forn(String cnpj_forn) {
        this.cnpj_forn = cnpj_forn;
    }

    public String getFone_forn() {
        return fone_forn;
    }

    public void setFone_forn(String fone_forn) {
        this.fone_forn = fone_forn;
    }

    public String getEmail_forn() {
        return email_forn;
    }

    public void setEmail_forn(String email_forn) {
        this.email_forn = email_forn;
    }

    public String getNome_resp() {
        return nome_resp;
    }

    public void setNome_resp(String nome_resp) {
        this.nome_resp = nome_resp;
    }
    
}
