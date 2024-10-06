package controller;

import dao.CargoDAO;
import java.sql.*;
import java.util.List;
import model.Cargo;

/**
 *
 * @author Rebeca
 */

public class CargoController {
    
    // método público para cadastrar cargo no sistema
    public static void cadastrarCargo(String nome, String desc, Float salario) throws SQLException {
        Cargo cargo = new Cargo(nome, desc, salario);
        CargoDAO.cadastrarCargo(cargo);
    }
    
    // método público para listar cargos cadastrados no sistema
    public static List<Cargo> listarCargo() throws SQLException {
        return CargoDAO.listarCargo();
    }
    
    // método público para buscar cargo pelo nome
    public static List<Cargo> buscarPorNome(String nome) throws SQLException {
        return CargoDAO.buscarPorNome(nome);
    }
    
    // método público para editar dados de um cargo cadastrado
    public static void editarCargo(int cod_cargo, String nome, String desc, Float salario) throws SQLException {
        Cargo cargo = new Cargo(nome, desc, salario);
        cargo.setCod_cargo(cod_cargo);
        CargoDAO.editarCargo(cargo);
    }
    
    // método público para deletar cargo cadastrado
    public static void deletarCargo(int cod_cargo) throws SQLException {
        CargoDAO.deletarCargo(cod_cargo);
    }
    
}