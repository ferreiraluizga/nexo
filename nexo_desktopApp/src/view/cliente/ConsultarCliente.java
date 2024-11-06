package view.cliente;

import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import controller.ClienteController;
import controller.ClubeFidelidadeController;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import model.Cliente;
import model.ClubeFidelidade;
import net.sf.jasperreports.engine.JRException;
import resources.utilitaries.Utilitaries;

/**
 *
 * @author rebeca
 */
public class ConsultarCliente extends javax.swing.JPanel {

    public ConsultarCliente() {
        initComponents();
        tabbedPane.setEnabledAt(1, false);
        listarClientes(1, null);
        styleComponents();
        Utilitaries.formatarCampo(txtTelefone, "(##) #####-####");
        Utilitaries.formatarCampo(txtCpf, "###.###.###-##");
    }

    // método para estilizar componentes
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

        txtNomeConsultar.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Digite o nome do cliente");
    }

    // método para listar clientes cadastrados ao iniciar a tela
    private void listarClientes(int opcao, String nome) {
        if (comboBoxFiltro.getSelectedIndex() == 0) {
            List<Cliente> clientes = new ArrayList<>();
            switch (opcao) {
                case 1:
                    try {
                        clientes = ClienteController.listarCliente();
                    } catch (SQLException ex) {
                        Logger.getLogger(ConsultarCliente.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                case 2:
                    try {
                        clientes = ClienteController.buscarPorNome(nome);
                    } catch (SQLException ex) {
                        Logger.getLogger(ConsultarCliente.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                default:
                    throw new AssertionError();
            }

            DefaultTableModel model = (DefaultTableModel) tblCliente.getModel();
            model.setRowCount(0);
            int columnSize[] = {10, 150, 100, 50, 100, 150};
            for (int i = 0; i < tblCliente.getColumnCount(); i++) {
                tblCliente.getColumnModel().getColumn(i).setPreferredWidth(columnSize[i]);
            }
            for (Cliente cliente : clientes) {
                Object[] row = new Object[6];
                row[0] = cliente.getCod_cli();
                row[1] = cliente.getNome_cli();
                row[2] = cliente.getTelefone();
                if (cliente.getAtivo_clube() == 0) {
                    row[3] = "Não";
                    row[4] = "";
                    row[5] = "";
                } else {
                    try {
                        ClubeFidelidade clube = ClubeFidelidadeController.buscarClubePorId(cliente.getCod_cli());
                        row[3] = "Sim";
                        row[4] = clube.getCpf();
                        if (clube.getEmail() == null) {
                            row[5] = "E-Mail não cadastrado";
                        } else {
                            row[5] = clube.getEmail();
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(ConsultarCliente.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                model.addRow(row);
            }
        } else {
            List<ClubeFidelidade> clube = new ArrayList<>();

            switch (opcao) {
                case 1:
                    try {
                        clube = ClubeFidelidadeController.listarClube();
                    } catch (SQLException ex) {
                        Logger.getLogger(ConsultarCliente.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                case 2:
                    try {
                        clube = ClubeFidelidadeController.buscarPorNome(nome);
                    } catch (SQLException ex) {
                        Logger.getLogger(ConsultarCliente.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                default:
                    throw new AssertionError();
            }

            DefaultTableModel model = (DefaultTableModel) tblCliente.getModel();
            model.setRowCount(0);
            int columnSize[] = {10, 150, 100, 50, 100, 150};
            for (int i = 0; i < tblCliente.getColumnCount(); i++) {
                tblCliente.getColumnModel().getColumn(i).setPreferredWidth(columnSize[i]);
            }
            for (ClubeFidelidade cliente : clube) {
                Object[] row = new Object[6];
                row[0] = cliente.getCliente().getCod_cli();
                row[1] = cliente.getCliente().getNome_cli();
                row[2] = cliente.getCliente().getTelefone();
                row[3] = "Sim";
                row[4] = cliente.getCpf();
                if (cliente.getEmail() == null) {
                    row[5] = "E-Mail não cadastrado";
                } else {
                    row[5] = cliente.getEmail();
                }
                model.addRow(row);
            }
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelRound1 = new resources.graphicComponents.PanelRound();
        lblTitulo = new javax.swing.JLabel();
        panelRound3 = new resources.graphicComponents.PanelRound();
        tabbedPane = new javax.swing.JTabbedPane();
        panelConsultar = new resources.graphicComponents.PanelRound();
        lblNomeConsultar = new javax.swing.JLabel();
        txtNomeConsultar = new javax.swing.JTextField();
        scrollPane = new javax.swing.JScrollPane();
        tblCliente = new javax.swing.JTable();
        btnBuscar = new javax.swing.JButton();
        btnDeletar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnRefresh = new javax.swing.JButton();
        comboBoxFiltro = new javax.swing.JComboBox<>();
        btnRelatorio = new javax.swing.JButton();
        panelEditar = new resources.graphicComponents.PanelRound();
        btnAtualizar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        lblNome = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        lblTelefone = new javax.swing.JLabel();
        txtTelefone = new javax.swing.JFormattedTextField();
        lblCpf = new javax.swing.JLabel();
        txtCpf = new javax.swing.JFormattedTextField();
        lblClube = new javax.swing.JLabel();
        comboBoxClube = new javax.swing.JComboBox<>();
        lblEmail = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        txtId = new javax.swing.JFormattedTextField();
        lblId = new javax.swing.JLabel();

        panelRound1.setBackground(new java.awt.Color(30, 64, 92));
        panelRound1.setRoundBottomLeft(20);
        panelRound1.setRoundBottomRight(20);
        panelRound1.setRoundTopLeft(20);
        panelRound1.setRoundTopRight(20);

        lblTitulo.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(255, 255, 255));
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("Clientes");

        javax.swing.GroupLayout panelRound1Layout = new javax.swing.GroupLayout(panelRound1);
        panelRound1.setLayout(panelRound1Layout);
        panelRound1Layout.setHorizontalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelRound1Layout.setVerticalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
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
        lblNomeConsultar.setText("Insira o nome do Cliente");

        txtNomeConsultar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNomeConsultarKeyReleased(evt);
            }
        });

        tblCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nome", "Telefone", "Ativo no Clube", "CPF", "Email"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblCliente.getTableHeader().setReorderingAllowed(false);
        scrollPane.setViewportView(tblCliente);

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
        btnDeletar.setText("  Deletar Registro Selecionado");
        btnDeletar.setBorderPainted(false);
        btnDeletar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDeletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeletarActionPerformed(evt);
            }
        });

        btnEditar.setIcon(new FlatSVGIcon(getClass().getResource("/resources/img/edit.svg")));
        btnEditar.setText("  Editar Registro Selecionado");
        btnEditar.setBorderPainted(false);
        btnEditar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
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

        comboBoxFiltro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "NEXOClub" }));
        comboBoxFiltro.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        comboBoxFiltro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxFiltroActionPerformed(evt);
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
                        .addComponent(btnDeletar, javax.swing.GroupLayout.DEFAULT_SIZE, 281, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(btnEditar, javax.swing.GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(btnRelatorio, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelConsultarLayout.createSequentialGroup()
                        .addGroup(panelConsultarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtNomeConsultar)
                            .addComponent(lblNomeConsultar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(comboBoxFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(scrollPane, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(19, 19, 19))
        );
        panelConsultarLayout.setVerticalGroup(
            panelConsultarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelConsultarLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(panelConsultarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelConsultarLayout.createSequentialGroup()
                        .addComponent(lblNomeConsultar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNomeConsultar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboBoxFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(scrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 295, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(panelConsultarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelConsultarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnDeletar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnRelatorio, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnRefresh, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18))
        );

        tabbedPane.addTab("Consultar", panelConsultar);

        panelEditar.setBackground(new java.awt.Color(29, 77, 117));

        btnAtualizar.setText("Atualizar Cadastro");
        btnAtualizar.setToolTipText("");
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

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Alterar dados do Cliente");

        lblNome.setForeground(new java.awt.Color(255, 255, 255));
        lblNome.setText("Nome Completo");

        lblTelefone.setForeground(new java.awt.Color(255, 255, 255));
        lblTelefone.setText("Telefone");

        lblCpf.setForeground(new java.awt.Color(255, 255, 255));
        lblCpf.setText("CPF");

        lblClube.setForeground(new java.awt.Color(255, 255, 255));
        lblClube.setText("Ativo no Clube");

        comboBoxClube.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Não", "Sim" }));
        comboBoxClube.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        comboBoxClube.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxClubeActionPerformed(evt);
            }
        });

        lblEmail.setForeground(new java.awt.Color(255, 255, 255));
        lblEmail.setText("E-Mail");

        txtId.setEnabled(false);

        lblId.setForeground(new java.awt.Color(255, 255, 255));
        lblId.setText("Id");

        javax.swing.GroupLayout panelEditarLayout = new javax.swing.GroupLayout(panelEditar);
        panelEditar.setLayout(panelEditarLayout);
        panelEditarLayout.setHorizontalGroup(
            panelEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEditarLayout.createSequentialGroup()
                .addGap(113, 113, 113)
                .addGroup(panelEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelEditarLayout.createSequentialGroup()
                        .addComponent(btnAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelEditarLayout.createSequentialGroup()
                        .addGroup(panelEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(comboBoxClube, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblClube, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panelEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblEmail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtEmail)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelEditarLayout.createSequentialGroup()
                        .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtCpf))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelEditarLayout.createSequentialGroup()
                        .addComponent(lblTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblCpf, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panelEditarLayout.createSequentialGroup()
                        .addGroup(panelEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(lblId, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panelEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtNome)
                            .addComponent(lblNome, javax.swing.GroupLayout.PREFERRED_SIZE, 518, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(138, Short.MAX_VALUE))
        );
        panelEditarLayout.setVerticalGroup(
            panelEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelEditarLayout.createSequentialGroup()
                .addContainerGap(77, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(panelEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNome)
                    .addComponent(lblId))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTelefone)
                    .addComponent(lblCpf))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblClube)
                    .addComponent(lblEmail))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboBoxClube, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(110, 110, 110))
        );

        tabbedPane.addTab("Editar", panelEditar);

        javax.swing.GroupLayout panelRound3Layout = new javax.swing.GroupLayout(panelRound3);
        panelRound3.setLayout(panelRound3Layout);
        panelRound3Layout.setHorizontalGroup(
            panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound3Layout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addComponent(tabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );
        panelRound3Layout.setVerticalGroup(
            panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound3Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(tabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, 451, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelRound1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelRound3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelRound1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
            listarClientes(2, nome);
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnDeletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeletarActionPerformed
        int selectedRow = tblCliente.getSelectedRow();
        if (selectedRow != -1) {
            int id_cliente = (int) tblCliente.getValueAt(selectedRow, 0);

            Object[] options = {"Deletar Cliente", "Remover do NEXOClub", "Cancelar"};

            int option = JOptionPane.showOptionDialog(
                    null,
                    "Selecione uma operação de remoção:",
                    "Deletar",
                    JOptionPane.YES_NO_CANCEL_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    options,
                    null);

            if (option == 0) {
                int status = JOptionPane.showConfirmDialog(null, "Deseja deletar o cliente?", "Deletar", JOptionPane.YES_NO_OPTION);
                if (status == JOptionPane.YES_OPTION) {
                    try {
                        ClienteController.deletarCliente(id_cliente);
                        listarClientes(1, null);
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(null, "Erro ao deletar cliente: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                    }
                }
            } else if (option == 1) {
                int status = JOptionPane.showConfirmDialog(null, "Deseja remover o cliente do NEXOClub?", "Remover do Clube", JOptionPane.YES_NO_OPTION);
                if (status == JOptionPane.YES_OPTION) {
                    try {
                        ClubeFidelidadeController.deletarClubeFidelidade(id_cliente);
                        listarClientes(1, null);
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(null, "Erro ao remover cliente do Clube de Fidelidade: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Selecione um registro para deletar ou remover", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnDeletarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        int selectedRow = tblCliente.getSelectedRow();
        if (selectedRow != -1) {
            tabbedPane.setEnabledAt(1, true);
            tabbedPane.setSelectedIndex(1);
            int id = (int) tblCliente.getValueAt(selectedRow, 0);
            String ativo_clube = (String) tblCliente.getValueAt(selectedRow, 3);
            try {
                if (ativo_clube.equals("Não")) {
                    Cliente cliente = ClienteController.buscarPorId(id);
                    txtId.setText(String.valueOf(id));
                    txtNome.setText(cliente.getNome_cli());
                    txtTelefone.setText(cliente.getTelefone());
                    comboBoxClube.setSelectedIndex(0);
                } else {
                    ClubeFidelidade cliente = ClubeFidelidadeController.buscarClubePorId(id);
                    txtId.setText(String.valueOf(cliente.getCliente().getCod_cli()));
                    txtNome.setText(cliente.getCliente().getNome_cli());
                    txtTelefone.setText(cliente.getCliente().getTelefone());
                    comboBoxClube.setSelectedIndex(1);
                    lblCpf.setVisible(true);
                    lblCpf.setVisible(true);
                    lblCpf.setVisible(true);
                    lblCpf.setVisible(true);
                    txtCpf.setText(cliente.getCpf());
                    txtEmail.setText(cliente.getEmail());
                }
            } catch (SQLException ex) {
                Logger.getLogger(ConsultarCliente.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Selecione um registro para editar", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        Utilitaries.limparCampos(panelConsultar);
        listarClientes(1, null);
        txtNomeConsultar.requestFocus();
        comboBoxFiltro.setSelectedIndex(0);
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void btnAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizarActionPerformed
        boolean clienteAtivo = false;

        try {
            clienteAtivo = ClienteController.verificarClienteNoClube(Integer.parseInt(txtId.getText()));
        } catch (SQLException ex) {
            Logger.getLogger(ConsultarCliente.class.getName()).log(Level.SEVERE, null, ex);
        }

        int id_cliente = Integer.parseInt(txtId.getText());
        String nome = txtNome.getText();
        String telefone = txtTelefone.getText().replaceAll("[^0-9]", "");
        int ativo_clube = comboBoxClube.getSelectedIndex();
        String cpf = txtCpf.getText().replaceAll("[^0-9]", "");
        String email = txtEmail.getText();

        try {
            if (comboBoxClube.getSelectedIndex() == 1) {
                if (clienteAtivo == true) {
                    ClienteController.editarCliente(id_cliente, nome, ativo_clube, telefone);
                    ClubeFidelidadeController.editarClubeFidelidade(id_cliente, cpf, email);
                } else {
                    ClienteController.editarCliente(id_cliente, nome, ativo_clube, telefone);
                    ClubeFidelidadeController.cadastrarClubeFidelidade(id_cliente, cpf, email);
                }
            } else {
                if (clienteAtivo == true) {
                    ClubeFidelidadeController.deletarClubeFidelidade(id_cliente);
                    ClienteController.editarCliente(id_cliente, nome, ativo_clube, telefone);
                } else {
                    ClienteController.editarCliente(id_cliente, nome, ativo_clube, telefone);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConsultarCliente.class.getName()).log(Level.SEVERE, null, ex);
        }

        tabbedPane.setEnabledAt(1, false);
        tabbedPane.setSelectedIndex(0);
        listarClientes(1, null);
    }//GEN-LAST:event_btnAtualizarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        int statusConfirm = JOptionPane.showConfirmDialog(null, "Deseja cancelar a edição?", "Cancelar", JOptionPane.YES_NO_OPTION);
        if (statusConfirm == JOptionPane.YES_OPTION) {
            tabbedPane.setEnabledAt(1, false);
            tabbedPane.setSelectedIndex(0);
        }
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void comboBoxClubeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxClubeActionPerformed
        if (comboBoxClube.getSelectedIndex() == 1) {
            lblCpf.setVisible(true);
            txtCpf.setVisible(true);
            lblEmail.setVisible(true);
            txtEmail.setVisible(true);
        } else {
            lblCpf.setVisible(false);
            txtCpf.setVisible(false);
            lblEmail.setVisible(false);
            txtEmail.setVisible(false);
        }
    }//GEN-LAST:event_comboBoxClubeActionPerformed

    private void txtNomeConsultarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNomeConsultarKeyReleased
        String nome = txtNomeConsultar.getText();
        listarClientes(2, nome);
    }//GEN-LAST:event_txtNomeConsultarKeyReleased

    private void comboBoxFiltroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxFiltroActionPerformed
        listarClientes(1, null);
    }//GEN-LAST:event_comboBoxFiltroActionPerformed

    private void btnRelatorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRelatorioActionPerformed
        Object[] options = {"Relatório de Clientes", "Relatório do NEXOClub", "Cancelar"};

        int option = JOptionPane.showOptionDialog(
                null,
                "Qual relatório você deseja imprimir?",
                "Relatórios",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                null);

        if (option == 0) {
            try {
                Utilitaries.imprimirRelatorio(null, "cliente.jrxml", false, 0);
            } catch (JRException | SQLException ex) {
                Logger.getLogger(ConsultarCliente.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (option == 1) {
            try {
                Utilitaries.imprimirRelatorio(null, "nexoclub.jrxml", false, 0);
            } catch (JRException | SQLException ex) {
                Logger.getLogger(ConsultarCliente.class.getName()).log(Level.SEVERE, null, ex);
            }
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
    private javax.swing.JComboBox<String> comboBoxClube;
    private javax.swing.JComboBox<String> comboBoxFiltro;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lblClube;
    private javax.swing.JLabel lblCpf;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblNomeConsultar;
    private javax.swing.JLabel lblTelefone;
    private javax.swing.JLabel lblTitulo;
    private resources.graphicComponents.PanelRound panelConsultar;
    private resources.graphicComponents.PanelRound panelEditar;
    private resources.graphicComponents.PanelRound panelRound1;
    private resources.graphicComponents.PanelRound panelRound3;
    private javax.swing.JScrollPane scrollPane;
    private javax.swing.JTabbedPane tabbedPane;
    private javax.swing.JTable tblCliente;
    private javax.swing.JFormattedTextField txtCpf;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JFormattedTextField txtId;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtNomeConsultar;
    private javax.swing.JFormattedTextField txtTelefone;
    // End of variables declaration//GEN-END:variables
}
