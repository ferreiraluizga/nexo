package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Cargo;
import model.Funcionario;

/**
 *
 * @author ferreiraluizga
 */

public class FuncionarioDAO {
    
    // método que cadastra cliente no banco de dados
    public static void cadastrarFuncionario(Funcionario func) throws SQLException {
        String sql = "INSERT INTO funcionario (Nome_Func, Nasc_Func, CPF_Func, Cod_Cargo, Email_Func, Senha_Func) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection con = Connect.getConnection(); PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, func.getNome_Func());
            stmt.setDate(2, (Date) func.getNasc_Func());
            stmt.setString(3, func.getCPF_Func());
            stmt.setInt(4, func.getCargo().getCod_cargo());
            stmt.setString(5, func.getEmail_Func());
            stmt.setString(6, func.getSenha_Func());
            stmt.execute();
            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    int id_func = generatedKeys.getInt(1);
                    cadastrarTelefone(id_func, func.getTelefone());
                }
            }
            JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso", "Cadastro", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar cliente: " + e.getMessage());
        }
    }
    
    private static void cadastrarTelefone(int cod_func, String telefone) throws SQLException {
        String sql = "INSERT INTO fone_func (Cod_Func, Fone_Func) VALUES (?, ?)";
        try (Connection con = Connect.getConnection(); PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, cod_func);
            stmt.setString(2, telefone);
            stmt.execute();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar telefone: " + e.getMessage());
        }
    }
    
    public static List<Funcionario> listarFuncionario() throws SQLException {
        List<Funcionario> funcionarios = new ArrayList<>();

        String sql = "SELECT * FROM funcionario INNER JOIN cargo ON funcionario.Cod_Cargo = cargo.Cod_Cargo";
        try (Connection con = Connect.getConnection(); PreparedStatement stmt = con.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Funcionario func = new Funcionario();
                Cargo cargo = new Cargo();
                
                cargo.setCod_cargo(rs.getInt("Cod_Cargo"));
                cargo.setNome_cargo(rs.getString("Nome_Cargo"));
                cargo.setDesc_cargo(rs.getString("Desc_Cargo"));
                cargo.setSalario_cargo(rs.getFloat("Salario_Cargo"));
                
                func.setCod_Func(rs.getInt("Cod_Func"));
                func.setNome_Func(rs.getString("Nome_Func"));
                func.setNasc_Func(rs.getDate("Nasc_Func"));
                func.setCPF_Func(rs.getString("CPF_Func"));
                func.setEmail_Func(rs.getString("Email_Func"));
                func.setSenha_Func(rs.getString("Senha_Func"));
                func.setCargo(cargo);
                func.setTelefone(primeiroTelefone(rs.getInt("Cod_Func")));
                funcionarios.add(func);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar clientes: " + e.getMessage());
        }

        return funcionarios;
    }
    
    private static String primeiroTelefone(int cod_cli) throws SQLException {
        String sql = "SELECT * FROM fone_cli WHERE Cod_Cli = ? LIMIT 1";
        try (Connection con = Connect.getConnection(); PreparedStatement stmt = con.prepareStatement(sql);) {
            stmt.setInt(1, cod_cli);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getString("Fone_Cli");
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar clientes: " + e.getMessage());
        }
        return null;
    }
    
    public static void editarCliente(Funcionario func) throws SQLException {
        editarTelefone(func.getCod_Func(), func.getTelefone());
        String sql = "UPDATE Cliente SET Nome_Func=?, Nasc_Func=?, CPF_Func=?, Cod_Cargo=?, Email_Func=?, Senha_Func=? WHERE Cod_Func=?";
        try (Connection con = Connect.getConnection(); PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(7, func.getCod_Func());
            stmt.setString(1, func.getNome_Func());
            stmt.setDate(2, (Date) func.getNasc_Func());
            stmt.setString(3, func.getCPF_Func());
            stmt.setInt(4, func.getCargo().getCod_cargo());
            stmt.setString(5, func.getEmail_Func());
            stmt.setString(6, func.getSenha_Func());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Cadastro atualizado com sucesso", "Editar", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar cliente: " + e.getMessage());
        }
    }
    
    private static void editarTelefone(int cod_func, String telefone) throws SQLException {
        String sql = "UPDATE Fone_Func SET Fone_Func=? WHERE Cod_Func=?";
        try (Connection con = Connect.getConnection(); PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, cod_func);
            stmt.setString(2, telefone);
            stmt.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar telefone: " + e.getMessage());
        }
    }
    
    // método que deleta clientes cadastrados no banco de dados
    public static void deletarFuncionario(int cod_func) throws SQLException {
        deletarTelefone(cod_func);
        String sql = "DELETE FROM Funcionario WHERE Cod_Func=?";
        try (Connection con = Connect.getConnection(); PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, cod_func);
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Cliente deletado com sucesso", "Deletar", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao deletar Cliente: " + e.getMessage());
        }
    }
    
    private static void deletarTelefone(int cod_func) throws SQLException {
        String sql = "DELETE FROM Fone_Func WHERE Cod_Func=?";
        try (Connection con = Connect.getConnection(); PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, cod_func);
            stmt.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao deletar telefone: " + e.getMessage());
        }
    }
    
    public static Funcionario validarAdm(String user, String senha) throws SQLException {
        Funcionario func = new Funcionario();
        Cargo cargo = new Cargo();
        
        String sql = "SELECT * FROM funcionario INNER JOIN cargo ON funcionario.Cod_Cargo = cargo.Cod_Cargo WHERE Email_Func = ? AND Senha_Func = ?";
        try (Connection con = Connect.getConnection(); PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, user);
            stmt.setString(2, senha);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                cargo.setCod_cargo(rs.getInt("Cod_Cargo"));
                cargo.setNome_cargo(rs.getString("Nome_Cargo"));
                cargo.setDesc_cargo(rs.getString("Desc_Cargo"));
                cargo.setSalario_cargo(rs.getFloat("Salario_Cargo"));
                
                func.setCod_Func(rs.getInt("Cod_Func"));
                func.setNome_Func(rs.getString("Nome_Func"));
                func.setCargo(cargo);
                func.setEmail_Func(rs.getString("Email_Func"));
            }
            return func;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao deletar telefone: " + e.getMessage());
        }
        return null;
    }
    
}
