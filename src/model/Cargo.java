package model;

/**
 * 
 * @author Rebeca
 * 
 */

public class Cargo {
    private int cod_cargo;
    private String nome_cargo;
    private String desc_cargo;
    private float salario_cargo;
    
    public Cargo() {}
    
    public Cargo(String nome_cargo, String desc_cargo, float salario_cargo) {
        this.nome_cargo = nome_cargo;
        this.desc_cargo = desc_cargo;
        this.salario_cargo = salario_cargo;
    }

    public int getCod_cargo() {
        return cod_cargo;
    }

    public void setCod_cargo(int cod_cargo) {
        this.cod_cargo = cod_cargo;
    }

    public String getNome_cargo() {
        return nome_cargo;
    }

    public void setNome_cargo(String nome_cargo) {
        this.nome_cargo = nome_cargo;
    }

    public String getDesc_cargo() {
        return desc_cargo;
    }

    public void setDesc_cargo(String desc_cargo) {
        this.desc_cargo = desc_cargo;
    }

    public float getSalario_cargo() {
        return salario_cargo;
    }

    public void setSalario_cargo(float salario_cargo) {
        this.salario_cargo = salario_cargo;
    }
}
