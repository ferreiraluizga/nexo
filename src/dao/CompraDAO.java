package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Cliente;
import model.Compra;
import model.FormaPag;
import model.Funcionario;

/**
 *
 * @author ferreiraluizga
 */
public class CompraDAO {

    // método que cadastra compras no banco de dados
    public static int cadastrarCompra(Compra compra) throws SQLException {
        String sql = "INSERT INTO compra (Cod_Func, Cod_Cli, Data_Compra, Cod_Forma_Pag) VALUES (?, ?, ?, ?)";
        try (Connection con = Connect.getConnection(); PreparedStatement stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setInt(1, compra.getFunc().getCod_Func());
            stmt.setInt(2, compra.getCliente().getCod_cli());
            stmt.setDate(3, Date.valueOf(compra.getData_Compra()));
            stmt.setInt(4, compra.getForma_Pag().getCod_forma_pag());
            stmt.execute();
            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    return generatedKeys.getInt(1);
                }
            }
            JOptionPane.showMessageDialog(null, "Compra cadastrada com sucesso", "Cadastro", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar compra: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
        return 0;
    }

    // método que lista as compras cadastradas no banco de dados
    public static List<Compra> listarCompra() throws SQLException {
        List<Compra> compras = new ArrayList<>();

        String sql = "SELECT * FROM compra "
                + "INNER JOIN funcionario ON compra.Cod_Func = funcionario.Cod_Func "
                + "INNER JOIN cliente ON compra.Cod_Cli = cliente.Cod_Cli "
                + "INNER JOIN forma_pag ON compra.Cod_Forma_Pag = forma_pag.Cod_Forma_Pag";
        try (Connection con = Connect.getConnection(); PreparedStatement stmt = con.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Compra compra = new Compra();
                Funcionario func = new Funcionario();
                Cliente cliente = new Cliente();
                FormaPag forma = new FormaPag();

                func.setCod_Func(rs.getInt("Cod_Func"));
                func.setNome_Func(rs.getString("Nome_Func"));

                cliente.setCod_cli(rs.getInt("Cod_Cli"));
                cliente.setNome_cli(rs.getString("Nome_Cli"));
                cliente.setAtivo_clube(rs.getInt("Ativo_Clube"));

                forma.setCod_forma_pag(rs.getInt("Cod_Forma_Pag"));
                forma.setNome_forma(rs.getString("Nome_Forma"));

                compra.setCod_Compra(rs.getInt("Cod_Compra"));
                compra.setFunc(func);
                compra.setCliente(cliente);
                compra.setData_Compra(rs.getDate("Data_Compra").toLocalDate());
                compra.setForma_Pag(forma);
                compras.add(compra);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar compras: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }

        return compras;
    }

    // método que buca as compras cadastradas no banco de dados pelo id
    public static List<Compra> buscarPorId(int id) throws SQLException {
        List<Compra> compras = new ArrayList<>();

        String sql = "SELECT * FROM compra "
                + "INNER JOIN funcionario ON compra.Cod_Func = funcionario.Cod_Func "
                + "INNER JOIN cliente ON compra.Cod_Cli = cliente.Cod_Cli "
                + "INNER JOIN forma_pag ON compra.Cod_Forma_Pag = forma_pag.Cod_Forma_Pag "
                + "WHERE compra.Cod_Compra = ?";
        try (Connection con = Connect.getConnection(); PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Compra compra = new Compra();
                    Funcionario func = new Funcionario();
                    Cliente cliente = new Cliente();
                    FormaPag forma = new FormaPag();

                    func.setCod_Func(rs.getInt("Cod_Func"));
                    func.setNome_Func(rs.getString("Nome_Func"));

                    cliente.setCod_cli(rs.getInt("Cod_Cli"));
                    cliente.setNome_cli(rs.getString("Nome_Cli"));
                    cliente.setAtivo_clube(rs.getInt("Ativo_Clube"));

                    forma.setCod_forma_pag(rs.getInt("Cod_Forma_Pag"));
                    forma.setNome_forma(rs.getString("Nome_Forma"));

                    compra.setCod_Compra(rs.getInt("Cod_Compra"));
                    compra.setFunc(func);
                    compra.setCliente(cliente);
                    compra.setData_Compra(rs.getDate("Data_Compra").toLocalDate());
                    compra.setForma_Pag(forma);
                    compras.add(compra);
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar compras: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }

        return compras;
    }
    
    // método que busca as compras cadastradas no banco de dados pelo nome do funcionario
    public static List<Compra> buscarPorFuncionario(String nome) throws SQLException {
        List<Compra> compras = new ArrayList<>();

        String sql = "SELECT * FROM compra "
                + "INNER JOIN funcionario ON compra.Cod_Func = funcionario.Cod_Func "
                + "INNER JOIN cliente ON compra.Cod_Cli = cliente.Cod_Cli "
                + "INNER JOIN forma_pag ON compra.Cod_Forma_Pag = forma_pag.Cod_Forma_Pag "
                + "WHERE funcionario.Nome_Func like ? ORDER BY Nome_Func";
        try (Connection con = Connect.getConnection(); PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, "%" + nome + "%");
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Compra compra = new Compra();
                    Funcionario func = new Funcionario();
                    Cliente cliente = new Cliente();
                    FormaPag forma = new FormaPag();

                    func.setCod_Func(rs.getInt("Cod_Func"));
                    func.setNome_Func(rs.getString("Nome_Func"));

                    cliente.setCod_cli(rs.getInt("Cod_Cli"));
                    cliente.setNome_cli(rs.getString("Nome_Cli"));
                    cliente.setAtivo_clube(rs.getInt("Ativo_Clube"));

                    forma.setCod_forma_pag(rs.getInt("Cod_Forma_Pag"));
                    forma.setNome_forma(rs.getString("Nome_Forma"));

                    compra.setCod_Compra(rs.getInt("Cod_Compra"));
                    compra.setFunc(func);
                    compra.setCliente(cliente);
                    compra.setData_Compra(rs.getDate("Data_Compra").toLocalDate());
                    compra.setForma_Pag(forma);
                    compras.add(compra);
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar compras: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }

        return compras;
    }
    
    // método que busca as compras cadastradas no banco de dados pelo nome do cliente
    public static List<Compra> buscarPorCliente(String nome) throws SQLException {
        List<Compra> compras = new ArrayList<>();

        String sql = "SELECT * FROM compra "
                + "INNER JOIN funcionario ON compra.Cod_Func = funcionario.Cod_Func "
                + "INNER JOIN cliente ON compra.Cod_Cli = cliente.Cod_Cli "
                + "INNER JOIN forma_pag ON compra.Cod_Forma_Pag = forma_pag.Cod_Forma_Pag "
                + "WHERE cliente.Nome_Cli like ? ORDER BY Nome_Cli";
        try (Connection con = Connect.getConnection(); PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, "%" + nome + "%");
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Compra compra = new Compra();
                    Funcionario func = new Funcionario();
                    Cliente cliente = new Cliente();
                    FormaPag forma = new FormaPag();

                    func.setCod_Func(rs.getInt("Cod_Func"));
                    func.setNome_Func(rs.getString("Nome_Func"));

                    cliente.setCod_cli(rs.getInt("Cod_Cli"));
                    cliente.setNome_cli(rs.getString("Nome_Cli"));
                    cliente.setAtivo_clube(rs.getInt("Ativo_Clube"));

                    forma.setCod_forma_pag(rs.getInt("Cod_Forma_Pag"));
                    forma.setNome_forma(rs.getString("Nome_Forma"));

                    compra.setCod_Compra(rs.getInt("Cod_Compra"));
                    compra.setFunc(func);
                    compra.setCliente(cliente);
                    compra.setData_Compra(rs.getDate("Data_Compra").toLocalDate());
                    compra.setForma_Pag(forma);
                    compras.add(compra);
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar compras: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }

        return compras;
    }

    // método que deleta compras cadastradas no banco de dados
    public static void deletarCompra(int id_compra) throws SQLException {
        ProdCompraDAO.deletarProdCompra(id_compra);
        String sql = "DELETE FROM compra WHERE Cod_Compra=?";
        try (Connection con = Connect.getConnection(); PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, id_compra);
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Compra deletada com sucesso", "Deletar", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao deletar compra: " + e.getMessage());
        }
    }

    // método para calcular o valor total da compra de acordo com os preços atuais dos produtos
    public static float calcularValorTotalCompra(int id_compra) {
        float valorTotal = 0.0f;
        String sql = "SELECT SUM(produto.Preco_Prod * prod_compra.Quant_Prod) AS total_compra "
                + "FROM prod_compra "
                + "JOIN produto ON produto.Cod_Prod = prod_compra.Cod_Prod "
                + "WHERE prod_compra.Cod_Compra = ?";

        try (Connection con = Connect.getConnection(); PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, id_compra);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    valorTotal = rs.getFloat("total_compra");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return valorTotal;
    }

}
