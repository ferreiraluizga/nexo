package dao;

/**
*
* @author rebeca
*/

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Cargo;

public class CargoDAO {
     public static void cadastrarCargo(Cargo cargo) throws SQLException {
        String sql = "INSERT INTO cargo (Nome_Cargo, Desc_Cargo, Salario_Cargo) VALUES (?, ?, ?)";
        try (Connection con = Connect.getConnection(); PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, cargo.getNome_cargo());
            stmt.setString(2, cargo.getDesc_cargo());
            stmt.setFloat(3, cargo.getSalario_cargo());
            stmt.execute();
            JOptionPane.showMessageDialog(null, "Cargo cadastrado com sucesso", "Cadastro", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar cargo: " + e.getMessage());
        }
    }
     public static List<Cargo> listarCargo() throws SQLException {
        List<Cargo> cargos = new ArrayList<>();
 
        String sql = "SELECT * FROM cargo";
        try (Connection con = Connect.getConnection(); PreparedStatement stmt = con.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Cargo cargo = new Cargo();
                cargo.setCod_cargo(rs.getInt("Cod_Cargo"));
                cargo.setNome_cargo(rs.getString("Nome_Cargo"));
                cargo.setDesc_cargo(rs.getString("Desc_Cargo"));
                cargo.setSalario_cargo(rs.getFloat("Salario_Cargo"));
                cargos.add(cargo);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar cargos: " + e.getMessage());
        }
 
        return cargos;
    }
 
    // método que busca um cargo pelo nome no banco de dados
    public static List<Cargo> buscarPorNome(String nome) throws SQLException {
        List<Cargo> cargos = new ArrayList<>();
 
        String sql = "SELECT * FROM cargo WHERE Nome_Cargo like ? ORDER BY Nome_Cargo";
        try (Connection con = Connect.getConnection(); PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, "%" + nome + "%");
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                Cargo cargo = new Cargo();
                cargo.setCod_cargo(rs.getInt("Cod_Cargo"));
                cargo.setNome_cargo(rs.getString("Nome_Cargo"));
                cargo.setDesc_cargo(rs.getString("Desc_Cargo"));
                cargo.setSalario_cargo(rs.getFloat("Salario_Cargo"));
                cargos.add(cargo);
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar cargos: " + e.getMessage());
        }
 
        return cargos;
    }
    
    // método que edita cargos cadastrados no banco de dados
    public static void editarCargo(Cargo cargo) throws SQLException {
        String sql = "UPDATE cargo SET Nome_Cargo=?, Desc_Cargo=?, Salario_Cargo=? WHERE Cod_Cargo=?";
        try (Connection con = Connect.getConnection(); PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(4, cargo.getCod_cargo());
            stmt.setString(1, cargo.getNome_cargo());
            stmt.setString(2, cargo.getDesc_cargo());
            stmt.setFloat(3, cargo.getSalario_cargo());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Cadastro atualizado com sucesso", "Editar", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar cargos: " + e.getMessage());
        }
    }
    
    // método que deleta cargos cadastrados no banco de dados
    public static void deletarCargo(int id_cargo) throws SQLException {
        String sql = "DELETE FROM cargo WHERE Cod_Cargo=?";
        try (Connection con = Connect.getConnection(); PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, id_cargo);
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Cargo deletado com sucesso", "Deletar", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao deletar cargos: " + e.getMessage());
        }
    }
}