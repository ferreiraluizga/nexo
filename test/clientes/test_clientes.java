/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clientes;

import controller.ClienteController;
import java.sql.SQLException;
import java.util.List;
import model.Cliente;
import model.ClubeFidelidade;

/**
 *
 * @author ferreiraluizga
 */
public class test_clientes {
    
    public static void main(String[] args) throws SQLException {
        Cliente cliente = new Cliente();
        cliente.setNome_cli("Cliente Teste");
        cliente.setTelefone("11998922549");
        cliente.setAtivo_clube(0);
        
        List<Cliente> lista = ClienteController.listarCliente();
        
        System.out.println(lista);
    }
    
}
