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
    public static void cadastrarClubeFidelidade(Cliente cliente, String cpf, String email) throws SQLException {
        ClubeFidelidade clube = new ClubeFidelidade(cliente, cpf, email);
        ClubeFidelidadeDAO.cadastrarClube(clube);
    }
    
    // método para listar clubes cadastrados
    public static List<ClubeFidelidade> listarClube() throws SQLException {
        return ClubeFidelidadeDAO.listarClube();
    }
    
    // método para editar dados de um clube cadastrado
    public static void editarClubeFidelidade(Cliente cliente, String cpf, String email) throws SQLException {
        ClubeFidelidade clube = new ClubeFidelidade(cliente, cpf, email);
        ClubeFidelidadeDAO.editarClube(clube);
    }
    
    // método para deletar clube cadastrado
    public static void deletarClubeFidelidade(int cod_cli) throws SQLException {
        ClubeFidelidadeDAO.deletarClube(cod_cli);
    }
    
}
