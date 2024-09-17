/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Admin
 */
import java.util.Date;

public class Compra {
    private int Cod_Compra;  
    private int Cod_Func;  
    private int Cod_Cli;  
    private Date Data_Compra;  
    private int Cod_Forma_Pag;  
    
    public int getCod_Compra() {
        return Cod_Compra;
    }

    public void setCod_Compra(int Cod_Compra) {
        this.Cod_Compra = Cod_Compra;
    }

    public int getCod_Func() {
        return Cod_Func;
    }

    public void setCod_Func(int Cod_Func) {
        this.Cod_Func = Cod_Func;
    }

    public int getCod_Cli() {
        return Cod_Cli;
    }

    public void setCod_Cli(int Cod_Cli) {
        this.Cod_Cli = Cod_Cli;
    }

    public Date getData_Compra() {
        return Data_Compra;
    }

    public void setData_Compra(Date Data_Compra) {
        this.Data_Compra = Data_Compra;
    }

    public int getCod_Forma_Pag() {
        return Cod_Forma_Pag;
    }

    public void setCod_Forma_Pag(int Cod_Forma_Pag) {
        this.Cod_Forma_Pag = Cod_Forma_Pag;
    }

}
