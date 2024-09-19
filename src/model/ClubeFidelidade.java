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

    public int getCod_cli() {
        return cliente.getCod_cli();
    }

    public void setCod_cli(int cod_cli) {
        if (this.cliente == null) {
            this.cliente = new Cliente();
        }
        this.cliente.setCod_cli(cod_cli);
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
