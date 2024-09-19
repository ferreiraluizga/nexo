package model;

/**
 *
 * @author ferreiraluizga
 */

public class Cliente {
    
    private int cod_cli;
    private String nome_cli;
    private int ativo_clube;
    private String telefone;
    
    public Cliente() {}
    
    public Cliente(String nome_cli, int ativo_clube, String telefone) {
        this.nome_cli = nome_cli;
        this.ativo_clube = ativo_clube;
        this.telefone = telefone;
    }

    public int getCod_cli() {
        return cod_cli;
    }

    public void setCod_cli(int cod_cli) {
        this.cod_cli = cod_cli;
    }

    public String getNome_cli() {
        return nome_cli;
    }

    public void setNome_cli(String nome_cli) {
        this.nome_cli = nome_cli;
    }

    public int getAtivo_clube() {
        return ativo_clube;
    }

    public void setAtivo_clube(int ativo_clube) {
        this.ativo_clube = ativo_clube;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
       
}
