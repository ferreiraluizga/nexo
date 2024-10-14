package view.produto;

import com.formdev.flatlaf.FlatClientProperties;
import controller.FornecedorController;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import resources.utilitaries.Utilitaries;

/**
 *
 * @author vitor
 */

public class CadastrarForn extends javax.swing.JPanel {

    public CadastrarForn() {
        initComponents();
        styleComponents();
        Utilitaries.formatarCampo(txtCnpj, "##.###.###/####-##");
        Utilitaries.formatarCampo(txtTelefone, "(##) #####-####");
    }
    
    // método para estilizar componentes
    private void styleComponents() {
        txtNomeFantasia.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Digite o nome da empresa");
        txtCnpj.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Digite o CPNPJ fornecedor");
        txtEmail.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Digite o e-mail do fornecedor");
        txtNomeResp.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Digite o nome do fornecedor");
        txtTelefone.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Digite o telefone do fornecedor");
        btnCadastrar.putClientProperty(FlatClientProperties.OUTLINE, false);
        btnCadastrar.putClientProperty(FlatClientProperties.STYLE, "background: #28A745; foreground: #FFFFFF");
        btnCadastrar.setFocusPainted(false);
    }
    
    // método para limpar campos
    private void limparCampos() {
        Utilitaries.limparCampos(panelRound1);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelRound2 = new resources.graphicComponents.PanelRound();
        lblTitulo1 = new javax.swing.JLabel();
        panelRound1 = new resources.graphicComponents.PanelRound();
        lblNomeFantasia = new javax.swing.JLabel();
        txtNomeFantasia = new javax.swing.JTextField();
        lblCnpj = new javax.swing.JLabel();
        lblNomeResp = new javax.swing.JLabel();
        txtNomeResp = new javax.swing.JTextField();
        lblTelefone = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        btnCadastrar = new javax.swing.JButton();
        txtCnpj = new javax.swing.JFormattedTextField();
        txtTelefone = new javax.swing.JFormattedTextField();
        btnLimpar = new javax.swing.JButton();

        panelRound2.setBackground(new java.awt.Color(30, 64, 92));
        panelRound2.setRoundBottomLeft(20);
        panelRound2.setRoundBottomRight(20);
        panelRound2.setRoundTopLeft(20);
        panelRound2.setRoundTopRight(20);

        lblTitulo1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblTitulo1.setForeground(new java.awt.Color(255, 255, 255));
        lblTitulo1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo1.setText("Cadastro de Fornecedores");

        javax.swing.GroupLayout panelRound2Layout = new javax.swing.GroupLayout(panelRound2);
        panelRound2.setLayout(panelRound2Layout);
        panelRound2Layout.setHorizontalGroup(
            panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo1, javax.swing.GroupLayout.DEFAULT_SIZE, 505, Short.MAX_VALUE)
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

        lblNomeFantasia.setForeground(new java.awt.Color(255, 255, 255));
        lblNomeFantasia.setText("Nome Fantasia");

        lblCnpj.setForeground(new java.awt.Color(255, 255, 255));
        lblCnpj.setText("CNPJ");

        lblNomeResp.setForeground(new java.awt.Color(255, 255, 255));
        lblNomeResp.setText("Nome do Responsável");

        lblTelefone.setForeground(new java.awt.Color(255, 255, 255));
        lblTelefone.setText("Telefone");

        lblEmail.setForeground(new java.awt.Color(255, 255, 255));
        lblEmail.setText("E-Mail");

        btnCadastrar.setText("Cadastrar Fornecedor");
        btnCadastrar.setBorderPainted(false);
        btnCadastrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarActionPerformed(evt);
            }
        });

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtEmail)
                    .addComponent(lblEmail, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblNomeResp, javax.swing.GroupLayout.DEFAULT_SIZE, 253, Short.MAX_VALUE)
                            .addComponent(txtNomeResp)
                            .addComponent(txtNomeFantasia)
                            .addComponent(lblNomeFantasia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblCnpj, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblTelefone, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtCnpj, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
                            .addComponent(txtTelefone)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelRound1Layout.createSequentialGroup()
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
                    .addComponent(lblNomeFantasia)
                    .addComponent(lblCnpj))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNomeFantasia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCnpj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNomeResp)
                    .addComponent(lblTelefone))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNomeResp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(lblEmail)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCadastrar)
                    .addComponent(btnLimpar))
                .addContainerGap(25, Short.MAX_VALUE))
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
        String nome_fantasia, cnpj_forn, email_forn, nome_resp, fone_forn;
        if (txtNomeFantasia.getText().isEmpty() || txtCnpj.getText().equals("__.___.___/____-__") || txtEmail.getText().isEmpty() || txtNomeResp.getText().isEmpty() || txtTelefone.getText().equals("(__) _____-____")) {
            JOptionPane.showMessageDialog(panelRound1, "Preencha todos os campos para enviar", "Atenção", JOptionPane.WARNING_MESSAGE);
        } else {
            nome_fantasia = txtNomeFantasia.getText();
            cnpj_forn = txtCnpj.getText().replaceAll("[^0-9]", "");
            email_forn = txtEmail.getText();
            nome_resp = txtNomeResp.getText();
            fone_forn = txtTelefone.getText();
            try {
                FornecedorController.cadastrarFornecedor(nome_fantasia, cnpj_forn, fone_forn, email_forn, nome_resp);
                limparCampos();
            } catch (SQLException ex) {
                Logger.getLogger(CadastrarForn.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnCadastrarActionPerformed

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        limparCampos();
    }//GEN-LAST:event_btnLimparActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JLabel lblCnpj;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblNomeFantasia;
    private javax.swing.JLabel lblNomeResp;
    private javax.swing.JLabel lblTelefone;
    private javax.swing.JLabel lblTitulo1;
    private resources.graphicComponents.PanelRound panelRound1;
    private resources.graphicComponents.PanelRound panelRound2;
    private javax.swing.JFormattedTextField txtCnpj;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtNomeFantasia;
    private javax.swing.JTextField txtNomeResp;
    private javax.swing.JFormattedTextField txtTelefone;
    // End of variables declaration//GEN-END:variables
}
