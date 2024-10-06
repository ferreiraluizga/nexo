package controller;

import dao.FormaPagDAO;
import java.sql.*;
import java.util.List;
import model.FormaPag;

/**
 *
 * @author vitor
 */

public class FormaPagController {
    
    // método para cadastrar forma de pagametno
    public static void cadastrarForma_Pag(String nome_forma) throws SQLException {
        FormaPag forma = new FormaPag(nome_forma);
        FormaPagDAO.cadastrarForma(forma);
    }
    
    // método para listar formas de pagamento cadastradas
    public static List<FormaPag> listarForma_Pag() throws SQLException {
        return FormaPagDAO.listarForma();
    }
    
    // método para editar dados de uma forma de pagamento cadastrada
    public static void editarForma_Pag(int cod_forma_pag, String nome_forma) throws SQLException {
        FormaPag forma = new FormaPag(nome_forma);
        forma.setCod_forma_pag(cod_forma_pag);
        FormaPagDAO.editarForma(forma);
    }
    
    // método para deletar forma de pagamento cadastrada
    public static void deletarForma_Pag(int cod_forma_pag) throws SQLException {
        FormaPagDAO.deletarForma(cod_forma_pag);
    }
    
}

