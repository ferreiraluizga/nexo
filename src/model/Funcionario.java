package model;

import java.util.Date;

/**
 *
 * @author Vitor
 */

public class Funcionario {
    
    private int Cod_Func;  
    private String Nome_Func;  
    private Date Nasc_Func; 
    private String CPF_Func;  
    private Cargo Cargo;  
    private String Email_Func;  
    private String Senha_Func; 
    private String telefone;
    
    public int getCod_Func() {
        return Cod_Func;
    }

    public void setCod_Func(int Cod_Func) {
        this.Cod_Func = Cod_Func;
    }

    public String getNome_Func() {
        return Nome_Func;
    }

    public void setNome_Func(String Nome_Func) {
        this.Nome_Func = Nome_Func;
    }

    public Date getNasc_Func() {
        return Nasc_Func;
    }

    public void setNasc_Func(Date Nasc_Func) {
        this.Nasc_Func = Nasc_Func;
    }

    public String getCPF_Func() {
        return CPF_Func;
    }

    public void setCPF_Func(String CPF_Func) {
        this.CPF_Func = CPF_Func;
    }

    public int getCod_Cargo() {
        return Cargo.getCod_cargo();
    }

    public void setCod_Cargo(int Cod_Cargo) {
        if (this.Cargo == null) {
            this.Cargo = new Cargo();
        }
        this.Cargo.setCod_cargo(Cod_Cargo);
    }

    public String getEmail_Func() {
        return Email_Func;
    }

    public void setEmail_Func(String Email_Func) {
        this.Email_Func = Email_Func;
    }

    public String getSenha_Func() {
        return Senha_Func;
    }

    public void setSenha_Func(String Senha_Func) {
        this.Senha_Func = Senha_Func;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

}
