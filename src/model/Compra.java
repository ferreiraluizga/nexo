package model;

import java.time.LocalDate;

/**
 *
 * @author Vitor
 */

public class Compra {
    private int cod_compra;  
    private Funcionario func;  
    private Cliente cliente;  
    private LocalDate data_compra;  
    private FormaPag forma;  
    
    public Compra () {}
    
    public Compra (Funcionario func, Cliente cliente, LocalDate data_compra, FormaPag forma) {
        this.func = func;
        this.cliente = cliente;
        this.data_compra = data_compra;
        this.forma = forma;
    }
    
    public int getCod_Compra() {
        return cod_compra;
    }

    public void setCod_Compra(int Cod_Compra) {
        this.cod_compra = Cod_Compra;
    }

    public Funcionario getFunc() {
        return func;
    }

    public void setFunc(Funcionario func) {
        this.func = func;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public LocalDate getData_Compra() {
        return data_compra;
    }

    public void setData_Compra(LocalDate Data_Compra) {
        this.data_compra = Data_Compra;
    }

    public FormaPag getForma_Pag() {
        return forma;
    }

    public void setForma_Pag(FormaPag forma) {
        this.forma = forma;
    }

}
