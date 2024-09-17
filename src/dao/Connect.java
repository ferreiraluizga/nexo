package dao;

import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author vitor
 */

public class Connect {

    private static Connection con;
    private static String url = "jdbc:mysql://localhost:3306/db_mercado?useSSL=false&serverTimezone=UTC";
    private static String user = "root";
    private static String password = "";

    // método para conectar aplicação ao banco de dados
    public static Connection getConnection() {
        try {
            con = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro de Conexão", JOptionPane.ERROR_MESSAGE);
        }
        return con;
    }

}
