package view.funcionario;

import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import controller.CargoController;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Cargo;
import resources.utilitaries.Utilitaries;

/**
 *
 * @author ferreiraluizga
 */
public class ConsultarCargo extends javax.swing.JPanel {

    public ConsultarCargo() {
        initComponents();
        tabbedPane.setEnabledAt(1, false);
        listarCargos(1, null);
        styleComponents();
    }
    
    // método para estilizar componentes usando a biblioteca FlatLaf
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
    private void listarCargos(int opcao, String nome) {
        List<Cargo> cargos = new ArrayList<>();

        switch (opcao) {
            case 1:
                try {
                    cargos = CargoController.listarCargo();
                } catch (SQLException ex) {
                    Logger.getLogger(ConsultarCargo.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            case 2:
                try {
                    cargos = CargoController.buscarPorNome(nome);
                } catch (SQLException ex) {
                    Logger.getLogger(ConsultarCargo.class.getName()).log(Level.SEVERE, null, ex);
                }
            default:
                throw new AssertionError();
        }
        
        DefaultTableModel model = (DefaultTableModel) tblCargo.getModel();
        model.setRowCount(0);
        int columnSize[] = {10, 100, 200, 50};
        for (int i = 0; i < tblCargo.getColumnCount(); i++) {
            tblCargo.getColumnModel().getColumn(i).setPreferredWidth(columnSize[i]);
        }
        for (Cargo cargo : cargos) {
            Object[] row = new Object[4];
            row[0] = cargo.getCod_cargo();
            row[1] = cargo.getNome_cargo();
            row[2] = cargo.getDesc_cargo();
            row[3] = cargo.getSalario_cargo();
            model.addRow(row);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelRound2 = new resources.graphicComponents.PanelRound();
        lblTitulo = new javax.swing.JLabel();
        panelRound3 = new resources.graphicComponents.PanelRound();
        tabbedPane = new javax.swing.JTabbedPane();
        panelConsultar = new resources.graphicComponents.PanelRound();
        lblNomeConsultar = new javax.swing.JLabel();
        txtNomeConsultar = new javax.swing.JTextField();
        scrollPane = new javax.swing.JScrollPane();
        tblCargo = new javax.swing.JTable();
        btnBuscar = new javax.swing.JButton();
        btnDeletar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnRefresh = new javax.swing.JButton();
        panelEditar = new resources.graphicComponents.PanelRound();
        lblNome = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        lblSalario = new javax.swing.JLabel();
        lblId = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        btnAtualizar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        lblDesc = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDesc = new javax.swing.JTextArea();
        txtSalario = new javax.swing.JTextField();

        panelRound2.setBackground(new java.awt.Color(30, 64, 92));
        panelRound2.setRoundBottomLeft(20);
        panelRound2.setRoundBottomRight(20);
        panelRound2.setRoundTopLeft(20);
        panelRound2.setRoundTopRight(20);

        lblTitulo.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(255, 255, 255));
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("Cargos");

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
        lblNomeConsultar.setText("Insira o nome do Cargo");

        tblCargo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nome", "Descrição do Cargo", "Salário"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Float.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblCargo.getTableHeader().setReorderingAllowed(false);
        scrollPane.setViewportView(tblCargo);
        if (tblCargo.getColumnModel().getColumnCount() > 0) {
            tblCargo.getColumnModel().getColumn(0).setResizable(false);
            tblCargo.getColumnModel().getColumn(1).setResizable(false);
            tblCargo.getColumnModel().getColumn(2).setResizable(false);
            tblCargo.getColumnModel().getColumn(3).setResizable(false);
        }

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

        javax.swing.GroupLayout panelConsultarLayout = new javax.swing.GroupLayout(panelConsultar);
        panelConsultar.setLayout(panelConsultarLayout);
        panelConsultarLayout.setHorizontalGroup(
            panelConsultarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelConsultarLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(panelConsultarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblNomeConsultar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelConsultarLayout.createSequentialGroup()
                        .addComponent(btnDeletar, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(scrollPane)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelConsultarLayout.createSequentialGroup()
                        .addComponent(txtNomeConsultar)
                        .addGap(18, 18, 18)
                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18))
        );
        panelConsultarLayout.setVerticalGroup(
            panelConsultarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelConsultarLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(panelConsultarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelConsultarLayout.createSequentialGroup()
                        .addComponent(lblNomeConsultar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNomeConsultar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(scrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panelConsultarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelConsultarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnDeletar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        tabbedPane.addTab("Consultar", panelConsultar);

        panelEditar.setBackground(new java.awt.Color(29, 77, 117));

        lblNome.setForeground(new java.awt.Color(255, 255, 255));
        lblNome.setText("Nome do Cargo");

        lblSalario.setForeground(new java.awt.Color(255, 255, 255));
        lblSalario.setText("Salário do Cargo");

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

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Alterar dados do Cargo");

        lblDesc.setForeground(new java.awt.Color(255, 255, 255));
        lblDesc.setText("Descrição do Cargo");

        txtDesc.setColumns(20);
        txtDesc.setRows(5);
        jScrollPane1.setViewportView(txtDesc);

        javax.swing.GroupLayout panelEditarLayout = new javax.swing.GroupLayout(panelEditar);
        panelEditar.setLayout(panelEditarLayout);
        panelEditarLayout.setHorizontalGroup(
            panelEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEditarLayout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addGroup(panelEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelEditarLayout.createSequentialGroup()
                        .addComponent(btnAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDesc, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelEditarLayout.createSequentialGroup()
                        .addGroup(panelEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(lblId, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panelEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtNome)
                            .addComponent(lblNome, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panelEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblSalario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtSalario, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(71, 71, 71))
        );
        panelEditarLayout.setVerticalGroup(
            panelEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEditarLayout.createSequentialGroup()
                .addGap(112, 112, 112)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(panelEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblId)
                    .addComponent(lblNome)
                    .addComponent(lblSalario))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSalario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblDesc)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panelEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(96, 96, 96))
        );

        tabbedPane.addTab("Editar", panelEditar);

        javax.swing.GroupLayout panelRound3Layout = new javax.swing.GroupLayout(panelRound3);
        panelRound3.setLayout(panelRound3Layout);
        panelRound3Layout.setHorizontalGroup(
            panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound3Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(tabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, 857, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
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
            .addComponent(panelRound3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelRound2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelRound2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelRound3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        Utilitaries.limparCampos(panelConsultar);
        listarCargos(1, null);
        txtNomeConsultar.requestFocus();
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        int selectedRow = tblCargo.getSelectedRow();
        if (selectedRow != -1) {
            tabbedPane.setEnabledAt(1, true);
            tabbedPane.setSelectedIndex(1);

            int id = (int) tblCargo.getValueAt(selectedRow, 0);
            String nome = (String) tblCargo.getValueAt(selectedRow, 1);
            String desc = (String) tblCargo.getValueAt(selectedRow, 2);
            float salario = (float) tblCargo.getValueAt(selectedRow, 3);

            txtId.setText(String.valueOf(id));
            txtNome.setText(nome);
            txtDesc.setText(desc);
            txtSalario.setText(String.valueOf(salario));
        } else {
            JOptionPane.showMessageDialog(null, "Selecione um registro para editar", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnDeletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeletarActionPerformed
        int selectedRow = tblCargo.getSelectedRow();
        if (selectedRow != -1) {
            int id_cargo = (int) tblCargo.getValueAt(selectedRow, 0);
            int status = JOptionPane.showConfirmDialog(null, "Deseja deletar o cargo?", "Deletar", JOptionPane.YES_NO_OPTION);
            if (status == JOptionPane.YES_OPTION) {
                try {
                    CargoController.deletarCargo(id_cargo);
                    listarCargos(1, null);
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Erro ao deletar cargo: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Selecione um registro para deletar", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnDeletarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        String nome;
        if (txtNomeConsultar.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Insira um nome para continuar", "Atenção", JOptionPane.WARNING_MESSAGE);
        } else {
            nome = txtNomeConsultar.getText();
            listarCargos(2, nome);
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        int status = JOptionPane.showConfirmDialog(null, "Deseja cancelar a edição?", "Cancelar", JOptionPane.YES_NO_OPTION);
        if (status == JOptionPane.YES_OPTION) {
            tabbedPane.setEnabledAt(1, false);
            tabbedPane.setSelectedIndex(0);
        }
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizarActionPerformed
        int id_cargo = Integer.parseInt(txtId.getText());
        String nome = txtNome.getText();
        String desc = txtDesc.getText();
        float salario = Float.parseFloat(txtSalario.getText());
        try {
            CargoController.editarCargo(id_cargo, nome, desc, salario);
            tabbedPane.setEnabledAt(1, false);
            tabbedPane.setSelectedIndex(0);
            listarCargos(1, null);
        } catch (SQLException ex) {
            Logger.getLogger(ConsultarCargo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnAtualizarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtualizar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnDeletar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblDesc;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblNomeConsultar;
    private javax.swing.JLabel lblSalario;
    private javax.swing.JLabel lblTitulo;
    private resources.graphicComponents.PanelRound panelConsultar;
    private resources.graphicComponents.PanelRound panelEditar;
    private resources.graphicComponents.PanelRound panelRound2;
    private resources.graphicComponents.PanelRound panelRound3;
    private javax.swing.JScrollPane scrollPane;
    private javax.swing.JTabbedPane tabbedPane;
    private javax.swing.JTable tblCargo;
    private javax.swing.JTextArea txtDesc;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtNomeConsultar;
    private javax.swing.JTextField txtSalario;
    // End of variables declaration//GEN-END:variables
}