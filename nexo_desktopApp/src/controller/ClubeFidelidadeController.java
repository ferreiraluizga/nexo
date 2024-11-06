package controller;

import dao.ClubeFidelidadeDAO;
import java.sql.*;
import java.util.List;
import model.Cliente;
import model.ClubeFidelidade;

/**
 *
 * @author Rebeca
 */

public class ClubeFidelidadeController {
    
    // método para cadastrar clube
    public static void cadastrarClubeFidelidade(int cod_cli, String cpf, String email) throws SQLException {
        Cliente cliente = new Cliente();
        cliente.setCod_cli(cod_cli);
        
        ClubeFidelidade clube = new ClubeFidelidade(cliente, cpf, email);
        ClubeFidelidadeDAO.cadastrarClube(clube);
    }
    
    // método para listar clubes cadastrados
    public static List<ClubeFidelidade> listarClube() throws SQLException {
        return ClubeFidelidadeDAO.listarClube();
    }
    
    // método para listar por id
    public static ClubeFidelidade buscarClubePorId(int cod_cli) throws SQLException {
        return ClubeFidelidadeDAO.buscarClubePorId(cod_cli);
    }
    
    // método para buscar por nome
    public static List<ClubeFidelidade> buscarPorNome(String nome) throws SQLException {
        return ClubeFidelidadeDAO.buscarPorNome(nome);
    }
    
    // método para editar dados de um clube cadastrado
    public static void editarClubeFidelidade(int cod_cli, String cpf, String email) throws SQLException {
        Cliente cliente = new Cliente();
        cliente.setCod_cli(cod_cli);
        
        ClubeFidelidade clube = new ClubeFidelidade(cliente, cpf, email);
        ClubeFidelidadeDAO.editarClube(clube);
    }
    
    // método para deletar clube cadastrado
    public static void deletarClubeFidelidade(int cod_cli) throws SQLException {
        ClubeFidelidadeDAO.deletarClube(cod_cli);
    }
    
    
}
