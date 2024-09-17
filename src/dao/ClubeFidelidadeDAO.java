package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.ClubeFidelidade;

/**
 *
 * @author ferreiraluizga
 */
public class ClubeFidelidadeDAO {
    
    // método que cadastra cliente no banco de dados
    public static void cadastrarClube(ClubeFidelidade cliente) throws SQLException {
        atualizarStatus(cliente.getCod_cli(), 1);
        String sql = "INSERT INTO Clube_Fidelidade (Cod_Cli, CPF_Clube, Email_Clube) VALUES (?, ?, ?)";
        try (Connection con = Connect.getConnection(); PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, cliente.getCod_cli());
            stmt.setString(2, cliente.getCpf());
            stmt.setString(3, cliente.getEmail());
            stmt.execute();
            JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso", "Cadastro", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar cliente: " + e.getMessage());
        }
    }
    
    public static List<ClubeFidelidade> listarClube() throws SQLException {
        List<ClubeFidelidade> clientes = new ArrayList<>();

        String sql = "SELECT * FROM Cliente";
        try (Connection con = Connect.getConnection(); PreparedStatement stmt = con.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                ClubeFidelidade cliente = new ClubeFidelidade();
                cliente.setCod_cli(rs.getInt("Cod_Cli"));
                cliente.setCpf(rs.getString("CPF_Clube"));
                cliente.setEmail(rs.getString("Email_Clube"));
                clientes.add(cliente);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar clientes: " + e.getMessage());
        }

        return clientes;
    }
    
    public static void editarClube(ClubeFidelidade cliente) throws SQLException {
        String sql = "UPDATE Clube_Fidelidade SET CPF_Clube=?, Email_Clube=? WHERE Cod_Cli=?";
        try (Connection con = Connect.getConnection(); PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(3, cliente.getCod_cli());
            stmt.setString(1, cliente.getCpf());
            stmt.setString(2, cliente.getEmail());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Cadastro atualizado com sucesso", "Editar", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar cliente: " + e.getMessage());
        }
    }
    
    public static void deletarClube(int cod_cli) throws SQLException {
        atualizarStatus(cod_cli, 0);
        String sql = "DELETE FROM Clube_Fidelidade WHERE Cod_Cli=?";
        try (Connection con = Connect.getConnection(); PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, cod_cli);
            stmt.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao deletar telefone: " + e.getMessage());
        }
    }
    
    private static void atualizarStatus(int cod_cli, int ativo_clube) {
        String sql = "UPDATE Cliente SET Ativo_Clube=? WHERE Cod_Cli=?";
        try (Connection con = Connect.getConnection(); PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, ativo_clube);
            stmt.setInt(2, cod_cli);
            stmt.execute();
            con.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar telefone: " + e.getMessage());
        }
    }
    
}