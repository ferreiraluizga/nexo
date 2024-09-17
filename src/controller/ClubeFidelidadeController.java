package controller;

import dao.ClubeFidelidadeDAO;
import java.sql.*;
import java.util.List;
import model.ClubeFidelidade;

/**
 *
 * @author Rebeca
 */

public class ClubeFidelidadeController {
    
    // método para cadastrar clube
    public static void cadastrarClubeFidelidade(int cod_cli, String cpf, String email) throws SQLException {
        ClubeFidelidade clube = new ClubeFidelidade(cod_cli, cpf, email);
        ClubeFidelidadeDAO.cadastrarClube(clube);
    }
    
    // método para listar clubes cadastrados
    public static List<ClubeFidelidade> listarClube() throws SQLException {
        return ClubeFidelidadeDAO.listarClube();
    }
    
    // método para editar dados de um clube cadastrado
    public static void editarClubeFidelidade(int cod_cli, String cpf, String email) throws SQLException {
        ClubeFidelidade clube = new ClubeFidelidade(cod_cli, cpf, email);
        clube.setCod_cli(cod_cli);
        ClubeFidelidadeDAO.editarClube(clube);
    }
    
    // método para deletar clube cadastrado
    public static void deletarClubeFidelidadee(int cod_cli) throws SQLException {
        ClubeFidelidadeDAO.deletarClube(cod_cli);
    }
    
}
