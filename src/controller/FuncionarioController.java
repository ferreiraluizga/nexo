package controller;

import dao.FuncionarioDAO;
import java.sql.SQLException;
import model.Funcionario;

/**
 *
 * @author ferreiraluizga
 */

public class FuncionarioController {
    
    public static Funcionario validarAdm(String user, String senha) throws SQLException {
        return FuncionarioDAO.validarAdm(user, senha);
    }
    
}
