package model;

import java.time.LocalDate;

/**
 *
 * @author Vitor
 */

public class Funcionario {
    
    private int Cod_Func;  
    private String Nome_Func;  
    private LocalDate Nasc_Func; 
    private String CPF_Func;  
    private Cargo Cargo;  
    private String Email_Func;  
    private String Senha_Func; 
    private String Telefone;
    
    public Funcionario() {}
    
    public Funcionario(String nome_func, LocalDate nasc_func, String cpf_func, Cargo cargo, String email_func, String senha_func, String telefone) {
        this.Nome_Func = nome_func;
        this.Nasc_Func = nasc_func;
        this.CPF_Func = cpf_func;
        this.Cargo = cargo;
        this.Email_Func = email_func;
        this.Senha_Func = senha_func;
        this.Telefone = telefone;
    }
    
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

    public LocalDate getNasc_Func() {
        return Nasc_Func;
    }

    public void setNasc_Func(LocalDate Nasc_Func) {
        this.Nasc_Func = Nasc_Func;
    }

    public String getCPF_Func() {
        return CPF_Func;
    }

    public void setCPF_Func(String CPF_Func) {
        this.CPF_Func = CPF_Func;
    }

    public Cargo getCargo() {
        return Cargo;
    }

    public void setCargo(Cargo cargo) {
        this.Cargo = cargo;
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
        return Telefone;
    }

    public void setTelefone(String telefone) {
        this.Telefone = telefone;
    }

}
