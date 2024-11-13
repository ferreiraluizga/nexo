package dao;

import java.io.File;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import model.Cargo;
import model.Funcionario;
import resources.utilitaries.ImageDatabase;

/**
 *
 * @author ferreiraluizga
 */
public class FuncionarioDAO {

    // método público para cadastrar funcionario
    public static void cadastrarFuncionario(Funcionario func, ImageIcon img_func) throws SQLException {
        String sql = "INSERT INTO funcionario (Nome_Func, Nasc_Func, CPF_Func, Cod_Cargo, Email_Func, Senha_Func) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection con = Connect.getConnection(); PreparedStatement stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, func.getNome_Func());
            stmt.setDate(2, Date.valueOf(func.getNasc_Func()));
            stmt.setString(3, func.getCPF_Func());
            stmt.setInt(4, func.getCargo().getCod_cargo());
            stmt.setString(5, func.getEmail_Func());
            stmt.setString(6, func.getSenha_Func());
            stmt.execute();
            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    int id_func = generatedKeys.getInt(1);
                    cadastrarTelefone(id_func, func.getTelefone());
                    ImageDatabase.saveImage(id_func, img_func);
                }
            }
            JOptionPane.showMessageDialog(null, "Funcionário cadastrado com sucesso", "Cadastro", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar funcionário: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    // método privado para cadastrar telefone do funcionario
    private static void cadastrarTelefone(int cod_func, String telefone) throws SQLException {
        String sql = "INSERT INTO fone_func (Cod_Func, Fone_Func) VALUES (?, ?)";
        try (Connection con = Connect.getConnection(); PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, cod_func);
            stmt.setString(2, telefone);
            stmt.execute();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar telefone: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    // método público para listar funcionarios
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
                func.setNasc_Func(rs.getDate("Nasc_Func").toLocalDate());
                func.setCPF_Func(rs.getString("CPF_Func"));
                func.setEmail_Func(rs.getString("Email_Func"));
                func.setSenha_Func(rs.getString("Senha_Func"));
                func.setCargo(cargo);
                func.setTelefone(primeiroTelefone(rs.getInt("Cod_Func")));
                funcionarios.add(func);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar funcionários: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }

        return funcionarios;
    }

    // método público para buscar funcionario por nome
    public static List<Funcionario> buscarPorNome(String nome) throws SQLException {
        List<Funcionario> funcionarios = new ArrayList<>();

        String sql = "SELECT * FROM funcionario INNER JOIN cargo ON funcionario.Cod_Cargo = cargo.Cod_Cargo "
                + "WHERE Nome_Func like ? ORDER BY Nome_Func";
        try (Connection con = Connect.getConnection(); PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, nome + "%");
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Funcionario func = new Funcionario();
                    Cargo cargo = new Cargo();

                    cargo.setCod_cargo(rs.getInt("Cod_Cargo"));
                    cargo.setNome_cargo(rs.getString("Nome_Cargo"));
                    cargo.setDesc_cargo(rs.getString("Desc_Cargo"));
                    cargo.setSalario_cargo(rs.getFloat("Salario_Cargo"));

                    func.setCod_Func(rs.getInt("Cod_Func"));
                    func.setNome_Func(rs.getString("Nome_Func"));
                    func.setNasc_Func(rs.getDate("Nasc_Func").toLocalDate());
                    func.setCPF_Func(rs.getString("CPF_Func"));
                    func.setEmail_Func(rs.getString("Email_Func"));
                    func.setSenha_Func(rs.getString("Senha_Func"));
                    func.setCargo(cargo);
                    func.setTelefone(primeiroTelefone(rs.getInt("Cod_Func")));
                    funcionarios.add(func);
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar funcionário: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }

        return funcionarios;
    }

    // método público para buscar funcionario por id
    public static Funcionario buscarPorId(int id) throws SQLException {
        Funcionario func = new Funcionario();

        String sql = "SELECT * FROM funcionario INNER JOIN cargo ON funcionario.Cod_Cargo = cargo.Cod_Cargo "
                + "WHERE Cod_Func = ?";
        try (Connection con = Connect.getConnection(); PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Cargo cargo = new Cargo();

                    cargo.setCod_cargo(rs.getInt("Cod_Cargo"));
                    cargo.setNome_cargo(rs.getString("Nome_Cargo"));
                    cargo.setDesc_cargo(rs.getString("Desc_Cargo"));
                    cargo.setSalario_cargo(rs.getFloat("Salario_Cargo"));

                    func.setCod_Func(rs.getInt("Cod_Func"));
                    func.setNome_Func(rs.getString("Nome_Func"));
                    func.setNasc_Func(rs.getDate("Nasc_Func").toLocalDate());
                    func.setCPF_Func(rs.getString("CPF_Func"));
                    func.setEmail_Func(rs.getString("Email_Func"));
                    func.setSenha_Func(rs.getString("Senha_Func"));
                    func.setCargo(cargo);
                    func.setTelefone(primeiroTelefone(rs.getInt("Cod_Func")));
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar funcionário: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }

        return func;
    }

    // método privado que busca telefone primário do funcionário
    private static String primeiroTelefone(int cod_Func) throws SQLException {
        String sql = "SELECT * FROM fone_func WHERE Cod_Func = ? LIMIT 1";
        try (Connection con = Connect.getConnection(); PreparedStatement stmt = con.prepareStatement(sql);) {
            stmt.setInt(1, cod_Func);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getString("Fone_Func");
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar clientes: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }

    // método público para editar funcionario
    public static void editarFuncionario(Funcionario func, ImageIcon img_func) throws SQLException {
        String sql = "UPDATE funcionario SET Nome_Func=?, Nasc_Func=?, CPF_Func=?, Cod_Cargo=?, Email_Func=? WHERE Cod_Func=?";
        String sqlSenha = "UPDATE funcionario SET Senha_Func=? WHERE Cod_Func=?";

        try (Connection con = Connect.getConnection(); PreparedStatement stmt = con.prepareStatement(sql)) {
            if (!func.getSenha_Func().isEmpty()) {
                try (PreparedStatement stmtSenha = con.prepareStatement(sqlSenha)) {
                    stmtSenha.setString(1, func.getSenha_Func());
                    stmtSenha.setInt(2, func.getCod_Func());
                    stmtSenha.executeUpdate();
                }
            }
            stmt.setString(1, func.getNome_Func());
            stmt.setDate(2, Date.valueOf(func.getNasc_Func()));
            stmt.setString(3, func.getCPF_Func());
            stmt.setInt(4, func.getCargo().getCod_cargo());
            stmt.setString(5, func.getEmail_Func());
            stmt.setInt(6, func.getCod_Func());
            editarTelefone(func.getCod_Func(), func.getTelefone());
            ImageDatabase.updateImage(func.getCod_Func(), img_func);
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Cadastro atualizado com sucesso", "Editar", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao editar funcionário: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    // método privado para editar telefone do funcionario
    private static void editarTelefone(int cod_func, String telefone) throws SQLException {
        String sql = "UPDATE fone_func SET Fone_Func=? WHERE Cod_Func=?";
        try (Connection con = Connect.getConnection(); PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, cod_func);
            stmt.setString(2, telefone);
            stmt.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao editar telefone: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    // método público para deletar funcionario cadastrado
    public static void deletarFuncionario(int cod_func) throws SQLException {
        deletarTelefone(cod_func);
        deletarImagem(cod_func);
        String sql = "DELETE FROM funcionario WHERE Cod_Func=?";
        try (Connection con = Connect.getConnection(); PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, cod_func);
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Cliente deletado com sucesso", "Deletar", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao deletar Cliente: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    // método privado para deletar telefone do funcionario
    private static void deletarTelefone(int cod_func) throws SQLException {
        String sql = "DELETE FROM fone_func WHERE Cod_Func=?";
        try (Connection con = Connect.getConnection(); PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, cod_func);
            stmt.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao deletar telefone: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    // método privado para deletar imagem do banco de dados
    private static void deletarImagem(int cod_func) throws SQLException {
        String sql = "DELETE FROM img_func WHERE Cod_Func=?";
        try (Connection con = Connect.getConnection(); PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, cod_func);
            stmt.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao deletar imagem: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    // método público para validar login no sistema
    public static Funcionario validarFunc(String user, String senha) throws SQLException {
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
                func.setSenha_Func(rs.getString("Senha_Func"));
                func.setTelefone(primeiroTelefone(rs.getInt("Cod_Func")));
            }
            return func;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao validar funcionario: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }

        return null;
    }

    // método para alterar informações de login do usuário
    public static void alterarLogin(int cod_func, String senha, String telefone, ImageIcon img_func) throws SQLException {
        editarTelefone(cod_func, telefone);
        if (!senha.isEmpty()) {
            String sql = "UPDATE funcionario SET Senha_Func=? WHERE Cod_Func=?";
            try (Connection con = Connect.getConnection(); PreparedStatement stmt = con.prepareStatement(sql)) {
                stmt.setString(1, senha);
                stmt.setInt(2, cod_func);
                ImageDatabase.updateImage(cod_func, img_func);
                stmt.executeUpdate();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Erro ao editar telefone: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
        JOptionPane.showMessageDialog(null, "Login atualizado com sucesso", "Editar", JOptionPane.INFORMATION_MESSAGE);
    }

}
