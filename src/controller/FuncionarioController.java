package controller;

import dao.FuncionarioDAO;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import model.Cargo;
import model.Funcionario;

/**
 *
 * @author ferreiraluizga
 */

public class FuncionarioController {
    
    public static void cadastrarFuncionario(String nome_func, Date nasc_func, String cpf_func, int cod_cargo, String email_func, String senha_func, String telefone) throws SQLException {
        Cargo cargo = new Cargo();
        cargo.setCod_cargo(cod_cargo);
        Funcionario func = new Funcionario(nome_func, nasc_func, cpf_func, cargo, email_func, senha_func, telefone);
        FuncionarioDAO.cadastrarFuncionario(func);
    }
    
    public static List<Funcionario> listarFuncionario() throws SQLException {
        return FuncionarioDAO.listarFuncionario();
    }
    
    public static void editarCliente(String nome_func, Date nasc_func, String cpf_func, int cod_cargo, String email_func, String senha_func, String telefone) throws SQLException {
        Cargo cargo = new Cargo();
        cargo.setCod_cargo(cod_cargo);
        Funcionario func = new Funcionario(nome_func, nasc_func, cpf_func, cargo, email_func, senha_func, telefone);
        FuncionarioDAO.editarCliente(func);
    }
    
    public static void deletarFuncionario(int cod_func) throws SQLException {
        FuncionarioDAO.deletarFuncionario(cod_func);
    }
    
    public static Funcionario validarAdm(String user, String senha) throws SQLException {
        return FuncionarioDAO.validarAdm(user, senha);
    }
    
    
}
