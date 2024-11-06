package model;

/**
 *
 * @author ferreiraluizga
 */

public class ClubeFidelidade {
    
    private Cliente cliente;
    private String cpf;
    private String email;
    
    public ClubeFidelidade() {}
    
    public ClubeFidelidade(Cliente cliente, String cpf, String email) {
        this.cliente = cliente;
        this.cpf = cpf;
        this.email = email;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
    
}
