package view.produto;

import com.formdev.flatlaf.FlatClientProperties;
import controller.CategoriaProdutoController;
import controller.FornecedorController;
import controller.MarcaController;
import controller.ProdutoController;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.CategoriaProduto;
import model.Fornecedor;
import model.Marca;
import resources.utilitaries.Utilitaries;

/**
 *
 * @author ferreiraluizga
 */

public class CadastrarProduto extends javax.swing.JPanel {

    public CadastrarProduto() {
        initComponents();
        atribuirFornecedores();
        atribuirCategorias();
        atribuirMarcas();
        styleComponents();
    }
    
    // método para atribuir fornecedores ao select (combo box)
    private void atribuirFornecedores() {
        List<Fornecedor> fornecedores = new ArrayList<>();
        try {
            fornecedores = FornecedorController.listarFornecedor();
        } catch (SQLException ex) {
            Logger.getLogger(CadastrarProduto.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (Fornecedor forn : fornecedores) {
            String temp = forn.getCod_forn() + " - " + forn.getNome_fantasia();
            comboBoxForn.addItem(temp);
        }
    }
    
    // método para atribuir categorias ao select (combo box)
    private void atribuirCategorias() {
        List<CategoriaProduto> categorias = new ArrayList<>();
        try {
            categorias = CategoriaProdutoController.listarCategoria();
        } catch (SQLException ex) {
            Logger.getLogger(CadastrarProduto.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (CategoriaProduto categoria : categorias) {
            String temp = categoria.getCod_categoria() + " - " + categoria.getNome_categoria();
            comboBoxCategoria.addItem(temp);
        }
    }
    
    // método para atribuir categorias ao select (combo box)
    private void atribuirMarcas() {
        List<Marca> marcas = new ArrayList<>();
        try {
            marcas = MarcaController.listarMarca();
        } catch (SQLException ex) {
            Logger.getLogger(CadastrarProduto.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (Marca marca : marcas) {
            String temp = marca.getCod_marca() + " - " + marca.getNome_marca();
            comboBoxMarca.addItem(temp);
        }
    }
    
    // método para estilizar componentes
    private void styleComponents() {
        txtNome.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Digite o nome do produto");
        txtPreco.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Digite o preço do produto");
        btnCadastrar.putClientProperty(FlatClientProperties.OUTLINE, false);
        btnCadastrar.putClientProperty(FlatClientProperties.STYLE, "background: #28A745; foreground: #FFFFFF");
        btnCadastrar.setFocusPainted(false);
    }
    
    // método para limpar campos
    private void limparCampos() {
        Utilitaries.limparCampos(panelRound1);
        comboBoxCategoria.setSelectedIndex(0);
        comboBoxForn.setSelectedIndex(0);
        comboBoxMarca.setSelectedIndex(0);
        txtQuant.setValue(0);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelRound2 = new resources.graphicComponents.PanelRound();
        lblTitulo1 = new javax.swing.JLabel();
        panelRound1 = new resources.graphicComponents.PanelRound();
        lblNome = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        lblPreco = new javax.swing.JLabel();
        lblQuant = new javax.swing.JLabel();
        lblForn = new javax.swing.JLabel();
        lblCategoria = new javax.swing.JLabel();
        btnCadastrar = new javax.swing.JButton();
        txtPreco = new javax.swing.JFormattedTextField();
        txtQuant = new javax.swing.JSpinner();
        comboBoxForn = new javax.swing.JComboBox<>();
        comboBoxCategoria = new javax.swing.JComboBox<>();
        lblMarca = new javax.swing.JLabel();
        comboBoxMarca = new javax.swing.JComboBox<>();
        btnLimpar = new javax.swing.JButton();

        panelRound2.setBackground(new java.awt.Color(30, 64, 92));
        panelRound2.setRoundBottomLeft(20);
        panelRound2.setRoundBottomRight(20);
        panelRound2.setRoundTopLeft(20);
        panelRound2.setRoundTopRight(20);

        lblTitulo1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblTitulo1.setForeground(new java.awt.Color(255, 255, 255));
        lblTitulo1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo1.setText("Cadastro de Produtos");

        javax.swing.GroupLayout panelRound2Layout = new javax.swing.GroupLayout(panelRound2);
        panelRound2.setLayout(panelRound2Layout);
        panelRound2Layout.setHorizontalGroup(
            panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo1, javax.swing.GroupLayout.DEFAULT_SIZE, 482, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelRound2Layout.setVerticalGroup(
            panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo1, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
                .addContainerGap())
        );

        panelRound1.setBackground(new java.awt.Color(30, 64, 92));
        panelRound1.setRoundBottomLeft(20);
        panelRound1.setRoundBottomRight(20);
        panelRound1.setRoundTopLeft(20);
        panelRound1.setRoundTopRight(20);

        lblNome.setForeground(new java.awt.Color(255, 255, 255));
        lblNome.setText("Nome do Produto");

        lblPreco.setForeground(new java.awt.Color(255, 255, 255));
        lblPreco.setText("Preço");

        lblQuant.setForeground(new java.awt.Color(255, 255, 255));
        lblQuant.setText("Quantidade em Estoque");

        lblForn.setForeground(new java.awt.Color(255, 255, 255));
        lblForn.setText("Fornecedor");

        lblCategoria.setForeground(new java.awt.Color(255, 255, 255));
        lblCategoria.setText("Categoria");

        btnCadastrar.setText("Cadastrar Produto");
        btnCadastrar.setBorderPainted(false);
        btnCadastrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarActionPerformed(evt);
            }
        });

        comboBoxForn.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione um Fornecedor" }));
        comboBoxForn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        comboBoxCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione uma Categoria" }));
        comboBoxCategoria.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        lblMarca.setForeground(new java.awt.Color(255, 255, 255));
        lblMarca.setText("Marca");

        comboBoxMarca.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione uma Marca" }));
        comboBoxMarca.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btnLimpar.setText("Limpar");
        btnLimpar.setBorderPainted(false);
        btnLimpar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelRound1Layout = new javax.swing.GroupLayout(panelRound1);
        panelRound1.setLayout(panelRound1Layout);
        panelRound1Layout.setHorizontalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addComponent(comboBoxCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(comboBoxMarca, 0, 207, Short.MAX_VALUE))
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addComponent(lblCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblMarca, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound1Layout.createSequentialGroup()
                        .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtNome)
                            .addComponent(lblNome, javax.swing.GroupLayout.DEFAULT_SIZE, 253, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblPreco, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtPreco)))
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtQuant, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblQuant, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblForn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(comboBoxForn, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addComponent(btnCadastrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(btnLimpar)))
                .addGap(25, 25, 25))
        );
        panelRound1Layout.setVerticalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNome)
                    .addComponent(lblPreco))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPreco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblQuant)
                    .addComponent(lblForn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtQuant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboBoxForn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCategoria)
                    .addComponent(lblMarca))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboBoxCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboBoxMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCadastrar)
                    .addComponent(btnLimpar))
                .addGap(25, 25, 25))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelRound2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelRound1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelRound2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelRound1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
        String nome;
        float preco;
        int quant;
        Fornecedor forn = new Fornecedor();
        CategoriaProduto categoria = new CategoriaProduto();
        Marca marca = new Marca();
        
        if (txtNome.getText().isEmpty() || txtPreco.getText().isEmpty() || Integer.parseInt((String) txtQuant.getValue()) < 1 || comboBoxForn.getSelectedIndex() == 0 || comboBoxCategoria.getSelectedIndex() == 0 || comboBoxMarca.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(panelRound1, "Preencha todos os campos para enviar", "Atenção", JOptionPane.WARNING_MESSAGE);
        } else {
            nome = txtNome.getText();
            preco = Float.parseFloat(txtPreco.getText());
            quant = (int) txtQuant.getValue();
            String fornTemp = String.valueOf(comboBoxForn.getSelectedItem()).replaceAll("\\D.*", "");
            String categoriaTemp = String.valueOf(comboBoxCategoria.getSelectedItem()).replaceAll("\\D.*", "");
            String marcaTemp = String.valueOf(comboBoxMarca.getSelectedItem()).replaceAll("\\D.*", "");
            forn.setCod_forn(Integer.parseInt(fornTemp));
            categoria.setCod_categoria(Integer.parseInt(categoriaTemp));
            marca.setCod_marca(Integer.parseInt(marcaTemp));
            try {
                ProdutoController.cadastrarProduto(nome, preco, quant, forn, marca, categoria);
                limparCampos();
            } catch (SQLException ex) {
                Logger.getLogger(CadastrarProduto.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnCadastrarActionPerformed

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        limparCampos();
    }//GEN-LAST:event_btnLimparActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JComboBox<String> comboBoxCategoria;
    private javax.swing.JComboBox<String> comboBoxForn;
    private javax.swing.JComboBox<String> comboBoxMarca;
    private javax.swing.JLabel lblCategoria;
    private javax.swing.JLabel lblForn;
    private javax.swing.JLabel lblMarca;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblPreco;
    private javax.swing.JLabel lblQuant;
    private javax.swing.JLabel lblTitulo1;
    private resources.graphicComponents.PanelRound panelRound1;
    private resources.graphicComponents.PanelRound panelRound2;
    private javax.swing.JTextField txtNome;
    private javax.swing.JFormattedTextField txtPreco;
    private javax.swing.JSpinner txtQuant;
    // End of variables declaration//GEN-END:variables
}
