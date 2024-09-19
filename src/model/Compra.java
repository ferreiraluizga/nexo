package model;

/**
 *
 * @author Vitor
 */

import java.util.Date;

public class Compra {
    private int cod_compra;  
    private Funcionario func;  
    private Cliente cliente;  
    private Date data_compra;  
    private Forma_Pag forma;  
    
    public int getCod_Compra() {
        return cod_compra;
    }

    public void setCod_Compra(int Cod_Compra) {
        this.cod_compra = Cod_Compra;
    }

    public int getCod_Func() {
        return func.getCod_Func();
    }

    public void setCod_Func(int Cod_Func) {
        if (this.func == null) {
            this.func = new Funcionario();
        }
        this.func.setCod_Func(Cod_Func);
    }

    public int getCod_Cli() {
        return cliente.getCod_cli();
    }

    public void setCod_Cli(int Cod_Cli) {
        if (this.cliente == null) {
            this.cliente = new Cliente();
        }
        this.cliente.setCod_cli(Cod_Cli);
    }

    public Date getData_Compra() {
        return data_compra;
    }

    public void setData_Compra(Date Data_Compra) {
        this.data_compra = Data_Compra;
    }

    public int getCod_Forma_Pag() {
        return forma.getCod_forma_pag();
    }

    public void setCod_Forma_Pag(int Cod_Forma_Pag) {
        if (this.forma == null) {
            this.forma = new Forma_Pag();
        }
        this.forma.setCod_forma_pag(Cod_Forma_Pag);
    }

}
