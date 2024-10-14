package view.funcionario;

import com.formdev.flatlaf.FlatClientProperties;
import controller.CargoController;
import controller.FuncionarioController;
import java.io.File;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import model.Cargo;
import resources.utilitaries.Utilitaries;

/**
 *
 * @author ferreiraluizga
 */

public class CadastrarFunc extends javax.swing.JPanel {

    public CadastrarFunc() {
        initComponents();
        atribuirCargos();
        Utilitaries.formatarCampo(txtNasc, "##/##/####");
        Utilitaries.formatarCampo(txtCpf, "###.###.###-##");
        Utilitaries.formatarCampo(txtTelefone, "(##) #####-####");
        styleComponents();
    }

    // método para estilizar componentes
    private void styleComponents() {
        txtNome.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Digite o nome do funcionário");
        txtEmail.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Digite o email do funcionário");
        txtSenha.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Digite a senha do funcionário");
        txtSenha.putClientProperty(FlatClientProperties.STYLE, "showRevealButton:true");
        btnCadastrar.putClientProperty(FlatClientProperties.OUTLINE, false);
        btnCadastrar.putClientProperty(FlatClientProperties.STYLE, "background: #28A745; foreground: #FFFFFF");
        btnCadastrar.setFocusPainted(false);
        btnImg.putClientProperty(FlatClientProperties.OUTLINE, false);
        btnImg.putClientProperty(FlatClientProperties.STYLE, "background: #6495ED; foreground: #FFFFFF");
        btnImg.setFocusPainted(false);
    }
    
    // método para atribuir cargos ao select (combo box)
    private void atribuirCargos() {
        List<Cargo> cargos = new ArrayList<>();
        try {
            cargos = CargoController.listarCargo();
        } catch (SQLException ex) {
            Logger.getLogger(CadastrarFunc.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (Cargo cargo : cargos) {
            String temp = cargo.getCod_cargo() + " - " + cargo.getNome_cargo();
            comboBoxCargo.addItem(temp);
        }
    }
    
    // método para limpar campos
    private void limparCampos() {
        Utilitaries.limparCampos(panelRound1);
        txtDominio.setText("@nexo.com.br");
        comboBoxCargo.setSelectedIndex(0);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelRound1 = new resources.graphicComponents.PanelRound();
        lblNome = new javax.swing.JLabel();
        lblNasc = new javax.swing.JLabel();
        lblCpf = new javax.swing.JLabel();
        lblCargo = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        lblSenha = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        comboBoxCargo = new javax.swing.JComboBox<>();
        txtEmail = new javax.swing.JTextField();
        txtSenha = new javax.swing.JPasswordField();
        txtCpf = new javax.swing.JFormattedTextField();
        btnImg = new javax.swing.JButton();
        btnCadastrar = new javax.swing.JButton();
        txtTelefone = new javax.swing.JFormattedTextField();
        lblTelefone = new javax.swing.JLabel();
        txtNasc = new javax.swing.JFormattedTextField();
        lblImg = new javax.swing.JLabel();
        txtDominio = new javax.swing.JTextField();
        btnLimpar = new javax.swing.JButton();
        panelRound2 = new resources.graphicComponents.PanelRound();
        lblTitulo = new javax.swing.JLabel();

        panelRound1.setBackground(new java.awt.Color(30, 64, 92));
        panelRound1.setRoundBottomLeft(20);
        panelRound1.setRoundBottomRight(20);
        panelRound1.setRoundTopLeft(20);
        panelRound1.setRoundTopRight(20);

        lblNome.setForeground(new java.awt.Color(255, 255, 255));
        lblNome.setText("Nome Completo");

        lblNasc.setForeground(new java.awt.Color(255, 255, 255));
        lblNasc.setText("Data de Nascimento");

        lblCpf.setForeground(new java.awt.Color(255, 255, 255));
        lblCpf.setText("CPF");

        lblCargo.setForeground(new java.awt.Color(255, 255, 255));
        lblCargo.setText("Cargo");

        lblEmail.setForeground(new java.awt.Color(255, 255, 255));
        lblEmail.setText("E-Mail");
        lblEmail.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        lblSenha.setForeground(new java.awt.Color(255, 255, 255));
        lblSenha.setText("Senha");

        comboBoxCargo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione um Cargo" }));
        comboBoxCargo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btnImg.setText("Selecionar Imagem");
        btnImg.setBorderPainted(false);
        btnImg.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnImg.setFocusPainted(false);
        btnImg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImgActionPerformed(evt);
            }
        });

        btnCadastrar.setText("Cadastrar Funcionário");
        btnCadastrar.setBorderPainted(false);
        btnCadastrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCadastrar.setFocusPainted(false);
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarActionPerformed(evt);
            }
        });

        lblTelefone.setForeground(new java.awt.Color(255, 255, 255));
        lblTelefone.setText("Telefone");

        txtDominio.setText("@nexo.com.br");
        txtDominio.setEnabled(false);

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
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound1Layout.createSequentialGroup()
                        .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtNome)
                            .addComponent(lblNome, javax.swing.GroupLayout.DEFAULT_SIZE, 342, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNasc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtNasc)))
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addGap(320, 320, 320)
                        .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblCargo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(comboBoxCargo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtCpf, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
                            .addComponent(lblCpf, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtTelefone, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
                            .addComponent(lblTelefone, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btnImg, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblImg, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblEmail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblSenha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtSenha)
                            .addGroup(panelRound1Layout.createSequentialGroup()
                                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound1Layout.createSequentialGroup()
                                        .addComponent(btnCadastrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnLimpar))
                                    .addGroup(panelRound1Layout.createSequentialGroup()
                                        .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, 0)
                                        .addComponent(txtDominio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGap(25, 25, 25))
        );
        panelRound1Layout.setVerticalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNome)
                    .addComponent(lblNasc))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNasc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCpf)
                    .addComponent(lblCargo)
                    .addComponent(lblTelefone))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboBoxCargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addComponent(lblEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDominio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(lblSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSenha)
                        .addGap(38, 38, 38))
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addComponent(lblImg, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnImg)
                    .addComponent(btnCadastrar)
                    .addComponent(btnLimpar))
                .addGap(25, 25, 25))
        );

        panelRound2.setBackground(new java.awt.Color(30, 64, 92));
        panelRound2.setRoundBottomLeft(20);
        panelRound2.setRoundBottomRight(20);
        panelRound2.setRoundTopLeft(20);
        panelRound2.setRoundTopRight(20);

        lblTitulo.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(255, 255, 255));
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("Cadastro de Funcionários");

        javax.swing.GroupLayout panelRound2Layout = new javax.swing.GroupLayout(panelRound2);
        panelRound2.setLayout(panelRound2Layout);
        panelRound2Layout.setHorizontalGroup(
            panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelRound2Layout.setVerticalGroup(
            panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelRound1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelRound2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(panelRound2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelRound1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
        String nome, cpf, telefone, email, senha;
        int cod_cargo;
        LocalDate nasc;
        
        if (txtNome.getText().isEmpty() || txtNasc.getText().equals("__/__/____") || txtCpf.getText().equals("___.___.___-__") || txtTelefone.getText().equals("(__) _____-____") || comboBoxCargo.getSelectedIndex() == 0 || txtEmail.getText().isEmpty() || txtSenha.getPassword().equals("")) {
            JOptionPane.showMessageDialog(panelRound1, "Preencha todos os campos para enviar", "Atenção", JOptionPane.WARNING_MESSAGE);
        } else {
            nome = txtNome.getText();
            nasc = Utilitaries.convertStringToDate(txtNasc.getText());
            cpf = txtCpf.getText().replaceAll("[^0-9]", "");
            telefone = txtTelefone.getText().replaceAll("[^0-9]", "");
            String cargoTemp = String.valueOf(comboBoxCargo.getSelectedItem()).replaceAll("\\D.*", "");
            cod_cargo = Integer.parseInt(cargoTemp);
            email = txtEmail.getText() + txtDominio.getText();
            senha = String.valueOf(txtSenha.getPassword());
            try {
                FuncionarioController.cadastrarFuncionario(nome, nasc, cpf, cod_cargo, email, senha, telefone);
                limparCampos();
            } catch (SQLException ex) {
                Logger.getLogger(CadastrarFunc.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnCadastrarActionPerformed

    private void btnImgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImgActionPerformed
        File f;

        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter fnwf = new FileNameExtensionFilter(".png, .jpg, .jpeg", "png", "jpg", "jpeg");
        fileChooser.addChoosableFileFilter(fnwf);
        int load = fileChooser.showOpenDialog(null);

        if (load == fileChooser.APPROVE_OPTION) {
            f = fileChooser.getSelectedFile();
            Utilitaries.setFileImage(lblImg, f);
        }
    }//GEN-LAST:event_btnImgActionPerformed

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        limparCampos();
    }//GEN-LAST:event_btnLimparActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JButton btnImg;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JComboBox<String> comboBoxCargo;
    private javax.swing.JLabel lblCargo;
    private javax.swing.JLabel lblCpf;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblImg;
    private javax.swing.JLabel lblNasc;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblSenha;
    private javax.swing.JLabel lblTelefone;
    private javax.swing.JLabel lblTitulo;
    private resources.graphicComponents.PanelRound panelRound1;
    private resources.graphicComponents.PanelRound panelRound2;
    private javax.swing.JFormattedTextField txtCpf;
    private javax.swing.JTextField txtDominio;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JFormattedTextField txtNasc;
    private javax.swing.JTextField txtNome;
    private javax.swing.JPasswordField txtSenha;
    private javax.swing.JFormattedTextField txtTelefone;
    // End of variables declaration//GEN-END:variables
}
