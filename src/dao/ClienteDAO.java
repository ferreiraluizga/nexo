package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Cliente;

/**
 *
 * @author ferreiraluizga
 */

public class ClienteDAO {
    
    // método que cadastra cliente no banco de dados
    public static void cadastrarCliente(Cliente cliente) throws SQLException {
        String sql = "INSERT INTO Cliente (Nome_Cli, Ativo_Clube) VALUES (?, ?)";
        try (Connection con = Connect.getConnection(); PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, cliente.getNome_cli());
            stmt.setInt(2, cliente.getAtivo_clube());
            stmt.execute();
            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    int id_cli = generatedKeys.getInt(1);
                    cadastrarTelefone(id_cli, cliente.getTelefone());
                }
            }
            JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso", "Cadastro", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar cliente: " + e.getMessage());
        }
    }
    
    private static void cadastrarTelefone(int cod_cli, String telefone) throws SQLException {
        String sql = "INSERT INTO Fone_Cli (Cod_Cli, Fone_Cli) VALUES (?, ?)";
        try (Connection con = Connect.getConnection(); PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, cod_cli);
            stmt.setString(2, telefone);
            stmt.execute();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar telefone: " + e.getMessage());
        }
    }

    // método que lista os clientes cadastrados no banco de dados
    public static List<Cliente> listarCliente() throws SQLException {
        List<Cliente> clientes = new ArrayList<>();

        String sql = "SELECT * FROM Cliente";
        try (Connection con = Connect.getConnection(); PreparedStatement stmt = con.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setCod_cli(rs.getInt("Cod_Cli"));
                cliente.setNome_cli(rs.getString("Nome_Cli"));
                cliente.setAtivo_clube(rs.getInt("Ativo_Clube"));
                clientes.add(cliente);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar clientes: " + e.getMessage());
        }

        return clientes;
    }

    // método que busca um cliente pelo nome no banco de dados
    public static List<Cliente> buscarPorNome(String nome) throws SQLException {
        List<Cliente> clientes = new ArrayList<>();

        String sql = "SELECT * FROM Cliente WHERE Nome_Cli like ? ORDER BY Nome_Cli";
        try (Connection con = Connect.getConnection(); PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, "%" + nome + "%");
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Cliente cliente = new Cliente();
                    cliente.setCod_cli(rs.getInt("Cod_Cli"));
                    cliente.setNome_cli(rs.getString("Nome_Cli"));
                    cliente.setAtivo_clube(rs.getInt("Ativo_Clube"));
                    clientes.add(cliente);
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar cliente: " + e.getMessage());
        }

        return clientes;
    }
    
    // método que edita clientes cadastrados no banco de dados
    public static void editarCliente(Cliente cliente) throws SQLException {
        editarTelefone(cliente.getCod_cli(), cliente.getTelefone());
        String sql = "UPDATE Cliente SET Nome_Cli=?, Ativo_Clube=? WHERE Cod_Cli=?";
        try (Connection con = Connect.getConnection(); PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(3, cliente.getCod_cli());
            stmt.setString(1, cliente.getNome_cli());
            stmt.setInt(2, cliente.getAtivo_clube());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Cadastro atualizado com sucesso", "Editar", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar cliente: " + e.getMessage());
        }
    }
    
    private static void editarTelefone(int cod_cli, String telefone) throws SQLException {
        String sql = "UPDATE Fone_Cli SET Fone_Cli=? WHERE Cod_Cli=?";
        try (Connection con = Connect.getConnection(); PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(2, cod_cli);
            stmt.setString(1, telefone);
            stmt.execute();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar telefone: " + e.getMessage());
        }
    }
    
    // método que deleta clientes cadastrados no banco de dados
    public static void deletarCliente(int id_cli) throws SQLException {
        deletarTelefone(id_cli);
        String sql = "DELETE FROM Cliente WHERE Cod_Cli=?";
        try (Connection con = Connect.getConnection(); PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, id_cli);
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Cliente deletado com sucesso", "Deletar", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao deletar Cliente: " + e.getMessage());
        }
    }
    
    private static void deletarTelefone(int cod_cli) throws SQLException {
        String sql = "DELETE FROM Fone_Cli WHERE Cod_Cli=?";
        try (Connection con = Connect.getConnection(); PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, cod_cli);
            stmt.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao deletar telefone: " + e.getMessage());
        }
    }
    
}
