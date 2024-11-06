package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Cliente;
import model.ClubeFidelidade;

/**
 *
 * @author ferreiraluizga
 */
public class ClubeFidelidadeDAO {

    // método que cadastra cliente no clube
    public static void cadastrarClube(ClubeFidelidade cliente) throws SQLException {
        atualizarStatus(cliente.getCliente().getCod_cli(), 1);
        String sql = "INSERT INTO clube_fidelidade (Cod_Cli, CPF_Clube, Email_Clube) VALUES (?, ?, ?)";
        try (Connection con = Connect.getConnection(); PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, cliente.getCliente().getCod_cli());
            stmt.setString(2, cliente.getCpf());
            stmt.setString(3, cliente.getEmail());
            stmt.execute();
            JOptionPane.showMessageDialog(null, "Cliente cadastrado no clube", "Cadastro", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar cliente: " + e.getMessage());
        }
    }

    // método para listar clientes do clube
    public static List<ClubeFidelidade> listarClube() throws SQLException {
        List<ClubeFidelidade> clientes = new ArrayList<>();

        String sql = "SELECT * FROM clube_fidelidade INNER JOIN cliente ON clube_fidelidade.Cod_cli = cliente.Cod_Cli";
        try (Connection con = Connect.getConnection(); PreparedStatement stmt = con.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                ClubeFidelidade clienteClube = new ClubeFidelidade();
                Cliente cliente = new Cliente();

                cliente.setCod_cli(rs.getInt("Cod_Cli"));
                cliente.setNome_cli(rs.getString("Nome_Cli"));
                cliente.setTelefone(primeiroTelefone(rs.getInt("Cod_Cli")));
                clienteClube.setCpf(rs.getString("CPF_Clube"));
                clienteClube.setEmail(rs.getString("Email_Clube"));
                clienteClube.setCliente(cliente);
                clientes.add(clienteClube);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar clientes do clube: " + e.getMessage());
        }

        return clientes;
    }

    // método para buscar clientes do clube
    public static List<ClubeFidelidade> buscarPorNome(String nome) throws SQLException {
        List<ClubeFidelidade> clientes = new ArrayList<>();
        String sql = "SELECT * FROM clube_fidelidade "
                + "INNER JOIN cliente ON clube_fidelidade.Cod_cli = cliente.Cod_Cli "
                + "WHERE Nome_Cli LIKE ? "
                + "ORDER BY Nome_Cli";

        try (Connection con = Connect.getConnection(); PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, "%" + nome + "%");
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    ClubeFidelidade clienteClube = new ClubeFidelidade();
                    Cliente cliente = new Cliente();

                    cliente.setCod_cli(rs.getInt("Cod_Cli"));
                    cliente.setNome_cli(rs.getString("Nome_Cli"));
                    cliente.setAtivo_clube(rs.getInt("Ativo_Clube"));
                    cliente.setTelefone(primeiroTelefone(rs.getInt("Cod_Cli")));
                    clienteClube.setCpf(rs.getString("CPF_Clube"));
                    clienteClube.setEmail(rs.getString("Email_Clube"));
                    clienteClube.setCliente(cliente);
                    clientes.add(clienteClube);
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar clientes do clube: " + e.getMessage());
        }

        return clientes;
    }

    // método para listar clube por id
    public static ClubeFidelidade buscarClubePorId(int cod_cli) throws SQLException {
        ClubeFidelidade cliente_clube = new ClubeFidelidade();

        String sql = "SELECT * FROM clube_fidelidade INNER JOIN cliente ON clube_fidelidade.Cod_cli = cliente.Cod_Cli WHERE clube_fidelidade.Cod_Cli = ?";
        try (Connection con = Connect.getConnection(); PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, cod_cli);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Cliente cliente = new Cliente();

                    cliente.setCod_cli(rs.getInt("Cod_Cli"));
                    cliente.setNome_cli(rs.getString("Nome_Cli"));
                    cliente.setAtivo_clube(rs.getInt("Ativo_Clube"));
                    cliente.setTelefone(primeiroTelefone(rs.getInt("Cod_Cli")));

                    cliente_clube.setCpf(rs.getString("CPF_Clube"));
                    cliente_clube.setEmail(rs.getString("Email_Clube"));
                    cliente_clube.setCliente(cliente);
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar clientes do clube: " + e.getMessage());
        }

        return cliente_clube;
    }
    
    // método para pegar primeiro telefone do cliente
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

    // método para editar cliente do clube
    public static void editarClube(ClubeFidelidade cliente) throws SQLException {
        String sql = "UPDATE clube_fidelidade SET CPF_Clube=?, Email_Clube=? WHERE Cod_Cli=?";
        try (Connection con = Connect.getConnection(); PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(3, cliente.getCliente().getCod_cli());
            stmt.setString(1, cliente.getCpf());
            stmt.setString(2, cliente.getEmail());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Cadastro atualizado com sucesso", "Editar", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar cliente: " + e.getMessage());
        }
    }

    // método para deletar cliente do clube
    public static void deletarClube(int cod_cli) throws SQLException {
        atualizarStatus(cod_cli, 0);
        String sql = "DELETE FROM clube_fidelidade WHERE Cod_Cli=?";
        try (Connection con = Connect.getConnection(); PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, cod_cli);
            stmt.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao deletar telefone: " + e.getMessage());
        }
    }

    // método para atualizar status do clube
    private static void atualizarStatus(int cod_cli, int ativo_clube) {
        String sql = "UPDATE cliente SET Ativo_Clube=? WHERE Cod_Cli=?";
        try (Connection con = Connect.getConnection(); PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, ativo_clube);
            stmt.setInt(2, cod_cli);
            stmt.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar telefone: " + e.getMessage());
        }
    }

}
