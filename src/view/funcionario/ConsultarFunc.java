package view.funcionario;

import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import controller.CargoController;
import controller.FuncionarioController;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Cargo;
import model.Funcionario;
import resources.utilitaries.Utilitaries;

/**
 *
 * @author ferreiraluizga
 */
public class ConsultarFunc extends javax.swing.JPanel {

    public ConsultarFunc() {
        initComponents();
        tabbedPane.setEnabledAt(1, false);
        listarFuncionarios(1, null);
        atribuirCargos();
        styleComponents();
        Utilitaries.formatarCampo(txtNasc, "##/##/####");
        Utilitaries.formatarCampo(txtCpf, "###.###.###-##");
        Utilitaries.formatarCampo(txtTelefone, "(##) #####-####");
    }

    private void atribuirCargos() {
        List<Cargo> cargos = new ArrayList<>();
        try {
            cargos = CargoController.listarCargo();
        } catch (SQLException ex) {
            Logger.getLogger(ConsultarCargo.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (Cargo cargo : cargos) {
            String temp = cargo.getCod_cargo() + " - " + cargo.getNome_cargo();
            comboBoxCargo.addItem(temp);
        }
    }

    private void styleComponents() {
        btnBuscar.putClientProperty(FlatClientProperties.STYLE, "background: null; foreground: #FFFFFF; border: null");
        btnBuscar.setFocusPainted(false);
        btnRefresh.putClientProperty(FlatClientProperties.STYLE, "background: null; foreground: #FFFFFF; border: null");
        btnRefresh.setFocusPainted(false);

        btnDeletar.putClientProperty(FlatClientProperties.OUTLINE, false);
        btnDeletar.putClientProperty(FlatClientProperties.STYLE, "background: #DC3545; foreground: #FFFFFF");
        btnDeletar.setFocusPainted(false);
        btnEditar.putClientProperty(FlatClientProperties.OUTLINE, false);
        btnEditar.putClientProperty(FlatClientProperties.STYLE, "background: #28A745; foreground: #FFFFFF");
        btnEditar.setFocusPainted(false);
        btnRelatorio.putClientProperty(FlatClientProperties.OUTLINE, false);
        btnRelatorio.putClientProperty(FlatClientProperties.STYLE, "background: #6495ED; foreground: #FFFFFF");
        btnRelatorio.setFocusPainted(false);

        btnAtualizar.putClientProperty("JButton.buttonType", "roundRect");
        btnAtualizar.putClientProperty(FlatClientProperties.OUTLINE, false);
        btnAtualizar.putClientProperty(FlatClientProperties.STYLE, "background: #28A745; foreground: #FFFFFF");
        btnAtualizar.setFocusPainted(false);
        btnCancelar.putClientProperty("JButton.buttonType", "roundRect");
        btnCancelar.putClientProperty(FlatClientProperties.OUTLINE, false);
        btnCancelar.putClientProperty(FlatClientProperties.STYLE, "background: #DC3545; foreground: #FFFFFF");
        btnCancelar.setFocusPainted(false);

        txtNomeConsultar.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Digite o nome do funcionário");

        txtSenha.putClientProperty(FlatClientProperties.STYLE, "showRevealButton:true");
    }

    // método para listar clientes cadastrados ao iniciar a tela
    private void listarFuncionarios(int opcao, String nome) {
        List<Funcionario> funcionarios = new ArrayList<>();

        switch (opcao) {
            case 1:
                try {
                    funcionarios = FuncionarioController.listarFuncionario();
                } catch (SQLException ex) {
                    Logger.getLogger(ConsultarCargo.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            case 2:
                try {
                    funcionarios = FuncionarioController.buscarPorNome(nome);
                } catch (SQLException ex) {
                    Logger.getLogger(ConsultarCargo.class.getName()).log(Level.SEVERE, null, ex);
                }
            default:
                throw new AssertionError();
        }

        DefaultTableModel model = (DefaultTableModel) tblFunc.getModel();
        model.setRowCount(0);
        int columnSize[] = {10, 200, 100, 100, 100};
        for (int i = 0; i < tblFunc.getColumnCount(); i++) {
            tblFunc.getColumnModel().getColumn(i).setPreferredWidth(columnSize[i]);
        }
        for (Funcionario func : funcionarios) {
            Object[] row = new Object[5];
            row[0] = func.getCod_Func();
            row[1] = func.getNome_Func();
            row[2] = func.getTelefone();
            row[3] = func.getEmail_Func();
            row[4] = func.getCargo().getCod_cargo() + " - " + func.getCargo().getNome_cargo();
            model.addRow(row);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelRound8 = new resources.graphicComponents.PanelRound();
        lblTitulo5 = new javax.swing.JLabel();
        panelRound3 = new resources.graphicComponents.PanelRound();
        tabbedPane = new javax.swing.JTabbedPane();
        panelConsultar = new resources.graphicComponents.PanelRound();
        lblNomeConsultar = new javax.swing.JLabel();
        txtNomeConsultar = new javax.swing.JTextField();
        scrollPane = new javax.swing.JScrollPane();
        tblFunc = new javax.swing.JTable();
        btnBuscar = new javax.swing.JButton();
        btnDeletar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnRefresh = new javax.swing.JButton();
        btnRelatorio = new javax.swing.JButton();
        lblImg = new javax.swing.JLabel();
        panelEditar = new resources.graphicComponents.PanelRound();
        lblNome = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        lblNasc = new javax.swing.JLabel();
        lblId = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        btnAtualizar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        lblSubtitulo = new javax.swing.JLabel();
        lblCpf = new javax.swing.JLabel();
        txtCpf = new javax.swing.JFormattedTextField();
        txtTelefone = new javax.swing.JFormattedTextField();
        lblTelefone = new javax.swing.JLabel();
        comboBoxCargo = new javax.swing.JComboBox<>();
        lblCargo = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        lblSenha = new javax.swing.JLabel();
        txtNasc = new javax.swing.JFormattedTextField();
        txtSenha = new javax.swing.JPasswordField();

        panelRound8.setBackground(new java.awt.Color(30, 64, 92));
        panelRound8.setRoundBottomLeft(20);
        panelRound8.setRoundBottomRight(20);
        panelRound8.setRoundTopLeft(20);
        panelRound8.setRoundTopRight(20);

        lblTitulo5.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblTitulo5.setForeground(new java.awt.Color(255, 255, 255));
        lblTitulo5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo5.setText("Funcionários");

        javax.swing.GroupLayout panelRound8Layout = new javax.swing.GroupLayout(panelRound8);
        panelRound8.setLayout(panelRound8Layout);
        panelRound8Layout.setHorizontalGroup(
            panelRound8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelRound8Layout.setVerticalGroup(
            panelRound8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo5, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                .addContainerGap())
        );

        panelRound3.setBackground(new java.awt.Color(30, 64, 92));
        panelRound3.setRoundBottomLeft(20);
        panelRound3.setRoundBottomRight(20);
        panelRound3.setRoundTopLeft(20);
        panelRound3.setRoundTopRight(20);

        tabbedPane.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);
        tabbedPane.setTabPlacement(javax.swing.JTabbedPane.LEFT);
        tabbedPane.setName(""); // NOI18N

        panelConsultar.setBackground(new java.awt.Color(29, 77, 117));

        lblNomeConsultar.setForeground(new java.awt.Color(255, 255, 255));
        lblNomeConsultar.setText("Insira o nome do Funcionário");
        lblNomeConsultar.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        tblFunc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nome", "Telefone", "E-Mail", "Cargo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblFunc.getTableHeader().setReorderingAllowed(false);
        scrollPane.setViewportView(tblFunc);

        btnBuscar.setBackground(new java.awt.Color(29, 77, 117));
        btnBuscar.setIcon(new FlatSVGIcon(getClass().getResource("/resources/img/search.svg")));
        btnBuscar.setBorderPainted(false);
        btnBuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnDeletar.setIcon(new FlatSVGIcon(getClass().getResource("/resources/img/delete.svg")));
        btnDeletar.setText("Deletar Registro Selecionado");
        btnDeletar.setBorderPainted(false);
        btnDeletar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDeletar.setIconTextGap(5);
        btnDeletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeletarActionPerformed(evt);
            }
        });

        btnEditar.setIcon(new FlatSVGIcon(getClass().getResource("/resources/img/edit.svg")));
        btnEditar.setText("Editar Registro Selecionado");
        btnEditar.setBorderPainted(false);
        btnEditar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEditar.setIconTextGap(5);
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnRefresh.setBackground(new java.awt.Color(29, 77, 117));
        btnRefresh.setIcon(new FlatSVGIcon(getClass().getResource("/resources/img/refresh.svg")));
        btnRefresh.setBorderPainted(false);
        btnRefresh.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        btnRelatorio.setIcon(new FlatSVGIcon(getClass().getResource("/resources/img/receipt.svg")));
        btnRelatorio.setText("Imprimir Relatório");
        btnRelatorio.setBorderPainted(false);
        btnRelatorio.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRelatorio.setIconTextGap(5);
        btnRelatorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRelatorioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelConsultarLayout = new javax.swing.GroupLayout(panelConsultar);
        panelConsultar.setLayout(panelConsultarLayout);
        panelConsultarLayout.setHorizontalGroup(
            panelConsultarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelConsultarLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(panelConsultarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelConsultarLayout.createSequentialGroup()
                        .addGroup(panelConsultarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtNomeConsultar)
                            .addComponent(lblNomeConsultar, javax.swing.GroupLayout.DEFAULT_SIZE, 653, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblImg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelConsultarLayout.createSequentialGroup()
                        .addComponent(btnDeletar, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnRelatorio, javax.swing.GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(scrollPane))
                .addGap(25, 25, 25))
        );
        panelConsultarLayout.setVerticalGroup(
            panelConsultarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelConsultarLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(panelConsultarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelConsultarLayout.createSequentialGroup()
                        .addComponent(lblImg, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(panelConsultarLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelConsultarLayout.createSequentialGroup()
                        .addComponent(lblNomeConsultar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNomeConsultar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(scrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(panelConsultarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelConsultarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnDeletar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnRelatorio, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18))
        );

        tabbedPane.addTab("Consultar", panelConsultar);

        panelEditar.setBackground(new java.awt.Color(29, 77, 117));

        lblNome.setForeground(new java.awt.Color(255, 255, 255));
        lblNome.setText("Nome Completo");

        lblNasc.setForeground(new java.awt.Color(255, 255, 255));
        lblNasc.setText("Data de Nascimento");

        lblId.setForeground(new java.awt.Color(255, 255, 255));
        lblId.setText("Id");

        txtId.setEnabled(false);

        btnAtualizar.setText("Atualizar Cadastro");
        btnAtualizar.setBorderPainted(false);
        btnAtualizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtualizarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.setBorderPainted(false);
        btnCancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        lblSubtitulo.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblSubtitulo.setForeground(new java.awt.Color(255, 255, 255));
        lblSubtitulo.setText("Alterar dados do Funcionário");

        lblCpf.setForeground(new java.awt.Color(255, 255, 255));
        lblCpf.setText("CPF");

        lblTelefone.setForeground(new java.awt.Color(255, 255, 255));
        lblTelefone.setText("Telefone");

        comboBoxCargo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione um Cargo" }));

        lblCargo.setForeground(new java.awt.Color(255, 255, 255));
        lblCargo.setText("Cargo");

        lblEmail.setForeground(new java.awt.Color(255, 255, 255));
        lblEmail.setText("E-Mail");

        lblSenha.setForeground(new java.awt.Color(255, 255, 255));
        lblSenha.setText("Senha");

        javax.swing.GroupLayout panelEditarLayout = new javax.swing.GroupLayout(panelEditar);
        panelEditar.setLayout(panelEditarLayout);
        panelEditarLayout.setHorizontalGroup(
            panelEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEditarLayout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addGroup(panelEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblSubtitulo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelEditarLayout.createSequentialGroup()
                        .addGroup(panelEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelEditarLayout.createSequentialGroup()
                                .addGroup(panelEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(lblId, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(panelEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtNome)
                                    .addComponent(lblNome, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18))
                            .addGroup(panelEditarLayout.createSequentialGroup()
                                .addGroup(panelEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtCpf, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
                                    .addComponent(lblCpf, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(panelEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtTelefone, javax.swing.GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE)
                                    .addComponent(lblTelefone, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(panelEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNasc, javax.swing.GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
                            .addComponent(comboBoxCargo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblCargo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtNasc)))
                    .addGroup(panelEditarLayout.createSequentialGroup()
                        .addGroup(panelEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(lblEmail, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtEmail, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnAtualizar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 322, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(panelEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnCancelar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblSenha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtSenha))))
                .addGap(71, 71, 71))
        );
        panelEditarLayout.setVerticalGroup(
            panelEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEditarLayout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addComponent(lblSubtitulo)
                .addGap(18, 18, 18)
                .addGroup(panelEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblId)
                    .addComponent(lblNome)
                    .addComponent(lblNasc))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNasc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCpf)
                    .addComponent(lblTelefone)
                    .addComponent(lblCargo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboBoxCargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEmail)
                    .addComponent(lblSenha))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(99, 99, 99))
        );

        tabbedPane.addTab("Editar", panelEditar);

        javax.swing.GroupLayout panelRound3Layout = new javax.swing.GroupLayout(panelRound3);
        panelRound3.setLayout(panelRound3Layout);
        panelRound3Layout.setHorizontalGroup(
            panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound3Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(tabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, 914, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );
        panelRound3Layout.setVerticalGroup(
            panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound3Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(tabbedPane, javax.swing.GroupLayout.DEFAULT_SIZE, 470, Short.MAX_VALUE)
                .addGap(25, 25, 25))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelRound3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelRound8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelRound8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelRound3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        String nome;
        if (txtNomeConsultar.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Insira um nome para continuar", "Atenção", JOptionPane.WARNING_MESSAGE);
        } else {
            nome = txtNomeConsultar.getText();
            listarFuncionarios(2, nome);
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnDeletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeletarActionPerformed
        int selectedRow = tblFunc.getSelectedRow();
        if (selectedRow != -1) {
            int id_func = (int) tblFunc.getValueAt(selectedRow, 0);
            int status = JOptionPane.showConfirmDialog(null, "Deseja deletar o cargo?", "Deletar", JOptionPane.YES_NO_OPTION);
            if (status == JOptionPane.YES_OPTION) {
                try {
                    FuncionarioController.deletarFuncionario(id_func);
                    listarFuncionarios(1, null);
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Erro ao deletar cargo: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Selecione um registro para deletar", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnDeletarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        int selectedRow = tblFunc.getSelectedRow();
        if (selectedRow != -1) {
            tabbedPane.setEnabledAt(1, true);
            tabbedPane.setSelectedIndex(1);

            int id = (int) tblFunc.getValueAt(selectedRow, 0);
            Funcionario func = new Funcionario();
            try {
                func = FuncionarioController.buscarPorId(id);
            } catch (SQLException ex) {
                Logger.getLogger(ConsultarFunc.class.getName()).log(Level.SEVERE, null, ex);
            }

            txtId.setText(String.valueOf(id));
            txtNome.setText(func.getNome_Func());
            txtNasc.setText(Utilitaries.convertDateToString(func.getNasc_Func()));
            txtCpf.setText(func.getCPF_Func());
            txtTelefone.setText(func.getTelefone());
            comboBoxCargo.setSelectedIndex(func.getCargo().getCod_cargo());
            txtEmail.setText(func.getEmail_Func());
            txtSenha.setText(func.getSenha_Func());
        } else {
            JOptionPane.showMessageDialog(null, "Selecione um registro para editar", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        Utilitaries.limparCampos(panelConsultar);
        listarFuncionarios(1, null);
        txtNomeConsultar.requestFocus();
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void btnAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizarActionPerformed
        int cod_func = Integer.parseInt(txtId.getText());
        String nome = txtNome.getText();
        LocalDate nasc = Utilitaries.convertStringToDate(txtNasc.getText());
        String cpf = txtCpf.getText().replaceAll("[\\.\\s-]", "");
        String telefone = txtTelefone.getText().replaceAll("[()\\s-]", "");
        String cargoTemp = String.valueOf(comboBoxCargo.getSelectedItem()).replaceAll("\\D.*", "");
        int cod_cargo = Integer.parseInt(cargoTemp);
        String email = txtEmail.getText();
        String senha = String.valueOf(txtSenha.getPassword());
        try {
            FuncionarioController.editarFuncionario(cod_func, nome, nasc, cpf, cod_cargo, email, senha, telefone);
            tabbedPane.setEnabledAt(1, false);
            tabbedPane.setSelectedIndex(0);
            listarFuncionarios(1, null);
        } catch (SQLException ex) {
            Logger.getLogger(ConsultarCargo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnAtualizarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        int status = JOptionPane.showConfirmDialog(null, "Deseja cancelar a edição?", "Cancelar", JOptionPane.YES_NO_OPTION);
        if (status == JOptionPane.YES_OPTION) {
            tabbedPane.setEnabledAt(1, false);
            tabbedPane.setSelectedIndex(0);
        }
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnRelatorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRelatorioActionPerformed
        int selectedRow = tblFunc.getSelectedRow();
        if (selectedRow != -1) {
            int id = (int) tblFunc.getValueAt(selectedRow, 0);
        } else {
            JOptionPane.showMessageDialog(null, "Selecione um registro para imprimir o relatório", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnRelatorioActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtualizar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnDeletar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnRelatorio;
    private javax.swing.JComboBox<String> comboBoxCargo;
    private javax.swing.JLabel lblCargo;
    private javax.swing.JLabel lblCpf;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblImg;
    private javax.swing.JLabel lblNasc;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblNomeConsultar;
    private javax.swing.JLabel lblSenha;
    private javax.swing.JLabel lblSubtitulo;
    private javax.swing.JLabel lblTelefone;
    private javax.swing.JLabel lblTitulo5;
    private resources.graphicComponents.PanelRound panelConsultar;
    private resources.graphicComponents.PanelRound panelEditar;
    private resources.graphicComponents.PanelRound panelRound3;
    private resources.graphicComponents.PanelRound panelRound8;
    private javax.swing.JScrollPane scrollPane;
    private javax.swing.JTabbedPane tabbedPane;
    private javax.swing.JTable tblFunc;
    private javax.swing.JFormattedTextField txtCpf;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtId;
    private javax.swing.JFormattedTextField txtNasc;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtNomeConsultar;
    private javax.swing.JPasswordField txtSenha;
    private javax.swing.JFormattedTextField txtTelefone;
    // End of variables declaration//GEN-END:variables
}
