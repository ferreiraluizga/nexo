package view;

import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.intellijthemes.FlatCarbonIJTheme;
import controller.FuncionarioController;
import java.awt.Toolkit;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import model.Funcionario;
import resources.graphicComponents.FontLoader;
import resources.utilitaries.Utilitaries;

/**
 *
 * @author ferreiraluizga
 */
public class Login extends javax.swing.JFrame {

    public Login() {
        initComponents();
        getRootPane().setDefaultButton(btnEntrar);
        Utilitaries.setImage(lblImg, "white_logo.png");
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/resources/img/app_logo.png")));
        styleComponents();
    }

    // função privada para estilização de componentes
    private void styleComponents() {
        txtUser.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Digite seu nome de usuário");
        txtSenha.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Digite sua senha");
        txtSenha.putClientProperty(FlatClientProperties.STYLE, "showRevealButton:true");
        txtUser.putClientProperty("JComponent.roundRect", true);
        txtSenha.putClientProperty("JComponent.roundRect", true);
        btnEntrar.putClientProperty("JButton.buttonType", "roundRect");
        btnEntrar.putClientProperty(FlatClientProperties.OUTLINE, false);
        btnEntrar.putClientProperty(FlatClientProperties.STYLE, "background: #6495ED; foreground: #FFFFFF; borderColor: null");
        btnEntrar.setFocusPainted(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        gradientPanel1 = new resources.graphicComponents.GradientPanel();
        lblImg = new javax.swing.JLabel();
        btnEntrar = new javax.swing.JButton();
        txtSenha = new javax.swing.JPasswordField();
        lblSenha = new javax.swing.JLabel();
        txtUser = new javax.swing.JTextField();
        lblUser = new javax.swing.JLabel();
        lblTitulo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("NEXO: Login");
        setResizable(false);

        gradientPanel1.setGradientColor1(new java.awt.Color(38, 111, 163));
        gradientPanel1.setGradientColor2(new java.awt.Color(34, 73, 104));

        lblImg.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        btnEntrar.setFont(new java.awt.Font("Poppins SemiBold", 0, 12)); // NOI18N
        btnEntrar.setText("Entrar");
        btnEntrar.setToolTipText("Fazer Login");
        btnEntrar.setBorderPainted(false);
        btnEntrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEntrarActionPerformed(evt);
            }
        });

        lblSenha.setForeground(new java.awt.Color(255, 255, 255));
        lblSenha.setText("Senha");

        lblUser.setForeground(new java.awt.Color(255, 255, 255));
        lblUser.setText("Usuário");

        lblTitulo.setFont(new java.awt.Font("Poppins", 1, 24)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(255, 255, 255));
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("Fazer Login");
        lblTitulo.setToolTipText("");

        javax.swing.GroupLayout gradientPanel1Layout = new javax.swing.GroupLayout(gradientPanel1);
        gradientPanel1.setLayout(gradientPanel1Layout);
        gradientPanel1Layout.setHorizontalGroup(
            gradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gradientPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(gradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.CENTER, gradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                        .addComponent(lblTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, 293, Short.MAX_VALUE)
                        .addComponent(lblImg, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnEntrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtSenha)
                    .addComponent(txtUser)
                    .addGroup(gradientPanel1Layout.createSequentialGroup()
                        .addGroup(gradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblSenha)
                            .addComponent(lblUser))
                        .addGap(0, 253, Short.MAX_VALUE)))
                .addGap(35, 35, 35))
        );
        gradientPanel1Layout.setVerticalGroup(
            gradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gradientPanel1Layout.createSequentialGroup()
                .addContainerGap(41, Short.MAX_VALUE)
                .addComponent(lblImg, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(lblTitulo)
                .addGap(18, 18, 18)
                .addComponent(lblUser)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(lblSenha)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(btnEntrar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(gradientPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(gradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEntrarActionPerformed
        String user, senha;

        if (txtUser.getText().isEmpty() || String.valueOf(txtSenha.getPassword()).isEmpty()) {
            JOptionPane.showMessageDialog(null, "Insira usuário e senha para continuar", "Atenção", JOptionPane.WARNING_MESSAGE);
        } else {
            user = txtUser.getText();
            senha = String.valueOf(txtSenha.getPassword());
            try {
                Funcionario validacao = FuncionarioController.validarFunc(user, senha);
                if (validacao.getNome_Func() != null) {
                    Funcionario func = new Funcionario();
                    func.setEmail_Func(validacao.getEmail_Func());
                    func.setNome_Func(validacao.getNome_Func());
                    func.setCod_Func(validacao.getCod_Func());
                    func.setCargo(validacao.getCargo());
                    JOptionPane.showMessageDialog(null, "Seja bem-vindo(a)" + func.getNome_Func()
                                    + "\nE-mail: " + func.getEmail_Func()
                                    + "\nCódigo de Funcionário: " + func.getCod_Func()
                                    + "\nCargo: " + func.getCargo().getNome_cargo(), "Bem-vindo!", JOptionPane.INFORMATION_MESSAGE);
                    this.dispose();
                    new Dashboard(func).setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Usuário ou Senha incorretos", "Acesso Negado", JOptionPane.ERROR_MESSAGE);
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Erro ao cadastrar cliente: " + e.getMessage());
            }
        }
    }//GEN-LAST:event_btnEntrarActionPerformed

    public static void main(String args[]) {
        FlatCarbonIJTheme.setup();
        UIManager.put("defaultFont", FontLoader.loadFont("Poppins.ttf", 13f));
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEntrar;
    private resources.graphicComponents.GradientPanel gradientPanel1;
    private javax.swing.JLabel lblImg;
    private javax.swing.JLabel lblSenha;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblUser;
    private javax.swing.JPasswordField txtSenha;
    private javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables
}
