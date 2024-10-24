package view.compra;

import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import controller.ClienteController;
import controller.CompraController;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import model.Cliente;
import model.Compra;
import resources.utilitaries.Utilitaries;

/**
 *
 * @author ferreiraluizga
 */
public class ConsultarCompra extends javax.swing.JPanel {

    public ConsultarCompra() {
        initComponents();
        listarCompras();
        styleComponents();
    }

    private void styleComponents() {
        btnBuscar.putClientProperty(FlatClientProperties.STYLE, "background: null; foreground: #FFFFFF; border: null");
        btnBuscar.setFocusPainted(false);
        btnRefresh.putClientProperty(FlatClientProperties.STYLE, "background: null; foreground: #FFFFFF; border: null");
        btnRefresh.setFocusPainted(false);

        btnDeletar.putClientProperty(FlatClientProperties.OUTLINE, false);
        btnDeletar.putClientProperty(FlatClientProperties.STYLE, "background: #DC3545; foreground: #FFFFFF");
        btnDeletar.setFocusPainted(false);
        btnRelatorio.putClientProperty(FlatClientProperties.OUTLINE, false);
        btnRelatorio.putClientProperty(FlatClientProperties.STYLE, "background: #6495ED; foreground: #FFFFFF");
        btnRelatorio.setFocusPainted(false);

        txtNomeConsultar.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Digite de acordo com o filtro selecionado");
    }

    // método para listar clientes cadastrados ao iniciar a tela
    private void listarCompras() {
        try {
            List<Compra> compras = CompraController.listarCompra();

            DefaultTableModel model = (DefaultTableModel) tblCompra.getModel();
            model.setRowCount(0);
            int columnSize[] = {10, 100, 100, 100, 100, 100};
            for (int i = 0; i < tblCompra.getColumnCount(); i++) {
                tblCompra.getColumnModel().getColumn(i).setPreferredWidth(columnSize[i]);
            }
            for (Compra compra : compras) {
                Object[] row = new Object[6];
                row[0] = compra.getCod_Compra();
                row[1] = compra.getFunc().getNome_Func();
                row[2] = compra.getCliente().getNome_cli();
                row[3] = compra.getForma_Pag().getNome_forma();
                row[4] = compra.getData_Compra().toString();
                float temp = calcularTotalCompra(compra.getCod_Compra(), compra.getCliente().getCod_cli());
                row[5] = String.format("R$ %.2f", temp);
                model.addRow(row);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConsultarCompra.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void listarPorFiltro(int id, String nome) {
        if (comboBoxFiltro.getSelectedIndex() == 1) {
            try {
                List<Compra> compras = CompraController.buscarPorId(id);
                
                DefaultTableModel model = (DefaultTableModel) tblCompra.getModel();
                model.setRowCount(0);
                int columnSize[] = {10, 100, 100, 100, 100, 100};
                for (int i = 0; i < tblCompra.getColumnCount(); i++) {
                    tblCompra.getColumnModel().getColumn(i).setPreferredWidth(columnSize[i]);
                }
                for (Compra compra : compras) {
                    Object[] row = new Object[6];
                    row[0] = compra.getCod_Compra();
                    row[1] = compra.getFunc().getNome_Func();
                    row[2] = compra.getCliente().getNome_cli();
                    row[3] = compra.getForma_Pag().getNome_forma();
                    row[4] = compra.getData_Compra().toString();
                    float temp = calcularTotalCompra(compra.getCod_Compra(), compra.getCliente().getCod_cli());
                    row[5] = String.format("R$ %.2f", temp);
                    model.addRow(row);
                }
            } catch (SQLException ex) {
                Logger.getLogger(ConsultarCompra.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (comboBoxFiltro.getSelectedIndex() == 2) {
            try {
                List<Compra> compras = CompraController.buscarPorCliente(nome);
                
                DefaultTableModel model = (DefaultTableModel) tblCompra.getModel();
                model.setRowCount(0);
                int columnSize[] = {10, 100, 100, 100, 100, 100};
                for (int i = 0; i < tblCompra.getColumnCount(); i++) {
                    tblCompra.getColumnModel().getColumn(i).setPreferredWidth(columnSize[i]);
                }
                for (Compra compra : compras) {
                    Object[] row = new Object[6];
                    row[0] = compra.getCod_Compra();
                    row[1] = compra.getFunc().getNome_Func();
                    row[2] = compra.getCliente().getNome_cli();
                    row[3] = compra.getForma_Pag().getNome_forma();
                    row[4] = compra.getData_Compra().toString();
                    float temp = calcularTotalCompra(compra.getCod_Compra(), compra.getCliente().getCod_cli());
                    row[5] = String.format("R$ %.2f", temp);
                    model.addRow(row);
                }
            } catch (SQLException ex) {
                Logger.getLogger(ConsultarCompra.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (comboBoxFiltro.getSelectedIndex() == 3) {
            try {
                List<Compra> compras = CompraController.buscarPorFuncionario(nome);
                
                DefaultTableModel model = (DefaultTableModel) tblCompra.getModel();
                model.setRowCount(0);
                int columnSize[] = {10, 100, 100, 100, 100, 100};
                for (int i = 0; i < tblCompra.getColumnCount(); i++) {
                    tblCompra.getColumnModel().getColumn(i).setPreferredWidth(columnSize[i]);
                }
                for (Compra compra : compras) {
                    Object[] row = new Object[6];
                    row[0] = compra.getCod_Compra();
                    row[1] = compra.getFunc().getNome_Func();
                    row[2] = compra.getCliente().getNome_cli();
                    row[3] = compra.getForma_Pag().getNome_forma();
                    row[4] = compra.getData_Compra().toString();
                    float temp = calcularTotalCompra(compra.getCod_Compra(), compra.getCliente().getCod_cli());
                    row[5] = String.format("R$ %.2f", temp);
                    model.addRow(row);
                }
            } catch (SQLException ex) {
                Logger.getLogger(ConsultarCompra.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private float calcularTotalCompra(int id_compra, int id_cliente) {
        try {
            float totalReal = 0, desconto;
            float totalParcial = CompraController.calcularValorTotalCompra(id_compra);
            Cliente cliente = ClienteController.buscarPorId(id_cliente);
            if (cliente.getAtivo_clube() == 0) {
                totalReal = totalParcial;
            } else {
                desconto = calcularDesconto(totalParcial);
                totalReal = totalParcial - desconto;
            }
            return totalReal;
        } catch (SQLException ex) {
            Logger.getLogger(ConsultarCompra.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    private float calcularDesconto(float total) {
        float desconto = 0f;
        if (total >= 30 && total < 50) {
            desconto = total * 0.05f;
        } else if (total >= 50 && total <= 100) {
            desconto = total * 0.10f;
        } else if (total >= 100) {
            desconto = total * 0.15f;
        }
        return desconto;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelRound8 = new resources.graphicComponents.PanelRound();
        lblTitulo5 = new javax.swing.JLabel();
        panelRound3 = new resources.graphicComponents.PanelRound();
        panelConsultar = new resources.graphicComponents.PanelRound();
        comboBoxFiltro = new javax.swing.JComboBox<>();
        lblNomeConsultar = new javax.swing.JLabel();
        txtNomeConsultar = new javax.swing.JTextField();
        scrollPane = new javax.swing.JScrollPane();
        tblCompra = new javax.swing.JTable();
        btnBuscar = new javax.swing.JButton();
        btnDeletar = new javax.swing.JButton();
        btnRefresh = new javax.swing.JButton();
        btnRelatorio = new javax.swing.JButton();

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
                .addComponent(lblTitulo5, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
                .addContainerGap())
        );

        panelRound3.setBackground(new java.awt.Color(30, 64, 92));
        panelRound3.setRoundBottomLeft(20);
        panelRound3.setRoundBottomRight(20);
        panelRound3.setRoundTopLeft(20);
        panelRound3.setRoundTopRight(20);

        panelConsultar.setBackground(new java.awt.Color(29, 77, 117));

        comboBoxFiltro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Filtros de Busca", "Busca por Código", "Busca por Cliente", "Busca por Funcionário" }));

        lblNomeConsultar.setForeground(new java.awt.Color(255, 255, 255));
        lblNomeConsultar.setText("Digite de acordo com o filtro de busca");
        lblNomeConsultar.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        txtNomeConsultar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNomeConsultarKeyReleased(evt);
            }
        });

        tblCompra.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Funcionário", "Cliente", "Forma de Pagamento", "Data da Compra", "Valor Total"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblCompra.getTableHeader().setReorderingAllowed(false);
        scrollPane.setViewportView(tblCompra);

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
        btnDeletar.setText("Deletar Compra");
        btnDeletar.setBorderPainted(false);
        btnDeletar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDeletar.setIconTextGap(5);
        btnDeletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeletarActionPerformed(evt);
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
        btnRelatorio.setText("Imprimir Comprovante");
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
                .addGap(25, 25, 25)
                .addGroup(panelConsultarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelConsultarLayout.createSequentialGroup()
                        .addGroup(panelConsultarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNomeConsultar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtNomeConsultar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(comboBoxFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelConsultarLayout.createSequentialGroup()
                        .addComponent(btnDeletar, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnRelatorio, javax.swing.GroupLayout.DEFAULT_SIZE, 421, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(scrollPane))
                .addGap(25, 25, 25))
        );
        panelConsultarLayout.setVerticalGroup(
            panelConsultarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelConsultarLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(panelConsultarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelConsultarLayout.createSequentialGroup()
                        .addComponent(lblNomeConsultar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNomeConsultar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboBoxFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(scrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 283, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(panelConsultarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelConsultarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnDeletar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnRelatorio, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30))
        );

        javax.swing.GroupLayout panelRound3Layout = new javax.swing.GroupLayout(panelRound3);
        panelRound3.setLayout(panelRound3Layout);
        panelRound3Layout.setHorizontalGroup(
            panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound3Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(panelConsultar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );
        panelRound3Layout.setVerticalGroup(
            panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(panelConsultar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
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
        int id;
        String nome;
        if (txtNomeConsultar.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Insira um nome para continuar", "Atenção", JOptionPane.WARNING_MESSAGE);
        } else if (comboBoxFiltro.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "Defina um filtro de busca", "Atenção", JOptionPane.WARNING_MESSAGE);
        } else if (comboBoxFiltro.getSelectedIndex() == 1) {
            id = Integer.parseInt(txtNomeConsultar.getText());
            listarPorFiltro(id, null);
        } else {
            nome = txtNomeConsultar.getText();
            listarPorFiltro(0, nome);
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnDeletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeletarActionPerformed
        int selectedRow = tblCompra.getSelectedRow();
        if (selectedRow != -1) {
            int id_compra = (int) tblCompra.getValueAt(selectedRow, 0);
            int status = JOptionPane.showConfirmDialog(null, "Deseja deletar a compra?", "Deletar", JOptionPane.YES_NO_OPTION);
            if (status == JOptionPane.YES_OPTION) {
                try {
                    CompraController.deletarCompra(id_compra);
                    listarCompras();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Erro ao deletar cargo: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Selecione um registro para deletar", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnDeletarActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        Utilitaries.limparCampos(panelConsultar);
        listarCompras();
        txtNomeConsultar.requestFocus();
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void btnRelatorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRelatorioActionPerformed
        int selectedRow = tblCompra.getSelectedRow();
        if (selectedRow != -1) {
            int id = (int) tblCompra.getValueAt(selectedRow, 0);
            Utilitaries.abrirComprovanteCompra(id);
        } else {
            JOptionPane.showMessageDialog(null, "Selecione um registro para imprimir o relatório", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnRelatorioActionPerformed

    private void txtNomeConsultarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNomeConsultarKeyReleased
        if (comboBoxFiltro.getSelectedIndex() == 0) {
            listarCompras();
        } else if (comboBoxFiltro.getSelectedIndex() == 1) {
            int id = Integer.parseInt(txtNomeConsultar.getText());
            listarPorFiltro(id, null);
        } else {
            String nome = txtNomeConsultar.getText();
            listarPorFiltro(0, nome);
        }
    }//GEN-LAST:event_txtNomeConsultarKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnDeletar;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnRelatorio;
    private javax.swing.JComboBox<String> comboBoxFiltro;
    private javax.swing.JLabel lblNomeConsultar;
    private javax.swing.JLabel lblTitulo5;
    private resources.graphicComponents.PanelRound panelConsultar;
    private resources.graphicComponents.PanelRound panelRound3;
    private resources.graphicComponents.PanelRound panelRound8;
    private javax.swing.JScrollPane scrollPane;
    private javax.swing.JTable tblCompra;
    private javax.swing.JTextField txtNomeConsultar;
    // End of variables declaration//GEN-END:variables
}
