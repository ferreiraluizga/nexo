package controller;

import dao.FuncionarioDAO;
import java.sql.*;
import java.time.LocalDate;
import java.util.List;
import javax.swing.ImageIcon;
import model.Cargo;
import model.Funcionario;

/**
 *
 * @author ferreiraluizga
 */

public class FuncionarioController {
    
    // método público para cadastrar funcionario no sistema
    public static void cadastrarFuncionario(String nome_func, LocalDate nasc_func, String cpf_func, int cod_cargo, String email_func, String senha_func, String telefone, ImageIcon img_func) throws SQLException {
        Cargo cargo = new Cargo();
        cargo.setCod_cargo(cod_cargo);
        Funcionario func = new Funcionario(nome_func, nasc_func, cpf_func, cargo, email_func, senha_func, telefone);
        FuncionarioDAO.cadastrarFuncionario(func, img_func);
    }
    
    // método público para listar funcionarios cadastrados no sistema
    public static List<Funcionario> listarFuncionario() throws SQLException {
        return FuncionarioDAO.listarFuncionario();
    }
    
    // método público para buscar funcionário pelo nome
    public static List<Funcionario> buscarPorNome(String nome) throws SQLException {
        return FuncionarioDAO.buscarPorNome(nome);
    }
    
    // método público para buscar funcionário por id
    public static Funcionario buscarPorId(int id) throws SQLException {
        return FuncionarioDAO.buscarPorId(id);
    }
    
    // método público para editar funcionario
    public static void editarFuncionario(int cod_func, String nome_func, LocalDate nasc_func, String cpf_func, int cod_cargo, String email_func, String senha_func, String telefone, ImageIcon img_func) throws SQLException {
        Cargo cargo = new Cargo();
        cargo.setCod_cargo(cod_cargo);
        Funcionario func = new Funcionario(nome_func, nasc_func, cpf_func, cargo, email_func, senha_func, telefone);
        func.setCod_Func(cod_func);
        FuncionarioDAO.editarFuncionario(func, img_func);
    }
    
    // método público para deletar funcionario
    public static void deletarFuncionario(int cod_func) throws SQLException {
        FuncionarioDAO.deletarFuncionario(cod_func);
    }
    
    // método público para validar login
    public static Funcionario validarFunc(String user, String senha) throws SQLException {
        return FuncionarioDAO.validarFunc(user, senha);
    }
    
    // método para alterar informações de login
    public static void alterarLogin(int cod_func, String senha, String telefone, ImageIcon img_func) throws SQLException {
        FuncionarioDAO.alterarLogin(cod_func, senha, telefone, img_func);
    }
    
}
