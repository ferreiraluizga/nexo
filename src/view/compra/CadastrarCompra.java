package view.compra;

import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import controller.ClienteController;
import controller.ClubeFidelidadeController;
import controller.CompraController;
import controller.FormaPagController;
import controller.ProdCompraController;
import controller.ProdutoController;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Cliente;
import model.ClubeFidelidade;
import model.Compra;
import model.FormaPag;
import model.Funcionario;
import model.Produto;
import net.sf.jasperreports.engine.JRException;
import resources.utilitaries.Utilitaries;

/**
 *
 * @author ferreiraluizga
 */
public class CadastrarCompra extends javax.swing.JPanel {

    private Funcionario func;

    public CadastrarCompra() {
        initComponents();
        listarProdutos(1, null);
        listarClientes(1, null);
        atribuirFormas();
        comboBoxParcela.setVisible(false);
        styleComponents();
    }

    public CadastrarCompra(Funcionario func) {
        initComponents();
        listarProdutos(1, null);
        listarClientes(1, null);
        atribuirFormas();
        comboBoxParcela.setVisible(false);
        this.func = func;
        styleComponents();
    }

    // método para atribuir cargos ao select (combo box)
    private void atribuirFormas() {
        List<FormaPag> formas = new ArrayList<>();
        try {
            formas = FormaPagController.listarForma_Pag();
        } catch (SQLException ex) {
            Logger.getLogger(CadastrarCompra.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (FormaPag forma : formas) {
            String temp = forma.getCod_forma_pag() + " - " + forma.getNome_forma();
            comboBoxPag.addItem(temp);
        }
    }

    // método para listar clientes cadastrados ao iniciar a tela
    private void listarProdutos(int opcao, String nome) {
        List<Produto> produtos = new ArrayList<>();

        switch (opcao) {
            case 1:
                try {
                produtos = ProdutoController.listarProduto();
            } catch (SQLException ex) {
                Logger.getLogger(CadastrarCompra.class.getName()).log(Level.SEVERE, null, ex);
            }
            break;
            case 2:
                try {
                produtos = ProdutoController.buscarPorNome(nome);
            } catch (SQLException ex) {
                Logger.getLogger(CadastrarCompra.class.getName()).log(Level.SEVERE, null, ex);
            }
            break;
            default:
                throw new AssertionError();
        }

        DefaultTableModel model = (DefaultTableModel) tblProd.getModel();
        model.setRowCount(0);
        int columnSize[] = {30, 200, 100, 100, 100};
        for (int i = 0; i < tblProd.getColumnCount(); i++) {
            tblProd.getColumnModel().getColumn(i).setPreferredWidth(columnSize[i]);
        }
        for (Produto prod : produtos) {
            Object[] row = new Object[5];
            row[0] = prod.getCod_Produto();
            row[1] = prod.getNome_Prod();
            row[2] = prod.getPreco_Prod();
            row[3] = prod.getCategoria().getNome_categoria();
            row[4] = prod.getMarca().getNome_marca();
            model.addRow(row);
        }
    }

    // método para listar clientes
    public void listarClientes(int opcao, String nome) {
        List<Cliente> clientes = new ArrayList<>();
        switch (opcao) {
            case 1:
                try {
                clientes = ClienteController.listarCliente();
            } catch (SQLException ex) {
                Logger.getLogger(CadastrarCompra.class.getName()).log(Level.SEVERE, null, ex);
            }
            break;
            case 2:
                try {
                clientes = ClienteController.buscarPorNome(nome);
            } catch (SQLException ex) {
                Logger.getLogger(CadastrarCompra.class.getName()).log(Level.SEVERE, null, ex);
            }
            break;
            default:
                throw new AssertionError();
        }

        DefaultTableModel model = (DefaultTableModel) tblCliente.getModel();
        model.setRowCount(0);
        int columnSize[] = {30, 150, 100, 50, 100};
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
            } else {
                try {
                    ClubeFidelidade clube = ClubeFidelidadeController.buscarClubePorId(cliente.getCod_cli());
                    row[3] = "Sim";
                    row[4] = clube.getCpf();
                } catch (SQLException ex) {
                    Logger.getLogger(CadastrarCompra.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            model.addRow(row);
        }
    }

    private void styleComponents() {
        txtNomeProd.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Digite o nome do produto");
        btnAdicionarCarrinho.putClientProperty(FlatClientProperties.OUTLINE, false);
        btnAdicionarCarrinho.putClientProperty(FlatClientProperties.STYLE, "background: #6495ED; foreground: #FFFFFF");
        btnAdicionarCarrinho.setFocusPainted(false);

        txtNomeCliente.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Digite o nome do produto");
        btnAdicionarCliente.putClientProperty(FlatClientProperties.OUTLINE, false);
        btnAdicionarCliente.putClientProperty(FlatClientProperties.STYLE, "background: #6495ED; foreground: #FFFFFF");
        btnAdicionarCliente.setFocusPainted(false);

        btnRemoverCarrinho.putClientProperty(FlatClientProperties.OUTLINE, false);
        btnRemoverCarrinho.putClientProperty(FlatClientProperties.STYLE, "background: #B8860B; foreground: #FFFFFF");
        btnRemoverCarrinho.setFocusPainted(false);

        btnFinalizar.putClientProperty(FlatClientProperties.OUTLINE, false);
        btnFinalizar.putClientProperty(FlatClientProperties.STYLE, "background: #28A745; foreground: #FFFFFF");
        btnFinalizar.setFocusPainted(false);

        btnCancelar.putClientProperty(FlatClientProperties.OUTLINE, false);
        btnCancelar.putClientProperty(FlatClientProperties.STYLE, "background: #DC3545; foreground: #FFFFFF");
        btnCancelar.setFocusPainted(false);
    }

    private void adicionarCarrinho(Produto prod, int qtd) {
        DefaultTableModel model = (DefaultTableModel) tblCompra.getModel();
        boolean prodAdicionado = false;

        for (int i = 0; i < model.getRowCount(); i++) {
            if ((int) model.getValueAt(i, 0) == prod.getCod_Produto()) {
                int novaQtd = (int) model.getValueAt(i, 3) + qtd;
                if (novaQtd > prod.getQuant_Estoque()) {
                    JOptionPane.showMessageDialog(null, "Não há quantidade em estoque o suficiente"
                            + "\nQuantidade em Estoque atual: " + prod.getQuant_Estoque(), "Erro", JOptionPane.ERROR_MESSAGE);
                    return;
                } else {
                    model.setValueAt(novaQtd, i, 3);
                    model.setValueAt(novaQtd * prod.getPreco_Prod(), i, 4);
                    prodAdicionado = true;
                }
                break;
            }
        }

        int columnSize[] = {10, 200, 100, 50, 100};
        for (int i = 0; i < tblCompra.getColumnCount(); i++) {
            tblCompra.getColumnModel().getColumn(i).setPreferredWidth(columnSize[i]);
        }

        if (!prodAdicionado) {
            if (qtd > prod.getQuant_Estoque()) {
                JOptionPane.showMessageDialog(null, "Não há quantidade em estoque o suficiente"
                        + "\nQuantidade em Estoque atual: " + prod.getQuant_Estoque(), "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            } else {
                Object[] row = new Object[5];
                row[0] = prod.getCod_Produto();
                row[1] = prod.getNome_Prod();
                row[2] = prod.getPreco_Prod();
                row[3] = qtd;
                row[4] = prod.getPreco_Prod() * qtd;
                model.addRow(row);
            }
        }

    }

    private void atualizarValores() {
        float total = calcularTotal();
        float desconto = calcularDesconto(total);
        float valorAPagar = total - desconto;
        txtTotal.setText(String.format("R$ %.2f", total));
        txtDesconto.setText(String.format("R$ %.2f", desconto));
        lblValorAPagar.setText(String.format("R$ %.2f", valorAPagar));
        definirParcelas(valorAPagar);
    }

    private float calcularDesconto(float total) {
        float desconto = 0f;
        if (txtClube.getText().toLowerCase().contains("sim")) {
            if (total >= 30 && total < 50) {
                desconto = total * 0.05f;
            } else if (total >= 50 && total <= 100) {
                desconto = total * 0.10f;
            } else if (total >= 100) {
                desconto = total * 0.15f;
            }
        }
        return desconto;
    }

    private float calcularTotal() {
        float total = 0f;
        DefaultTableModel model = (DefaultTableModel) tblCompra.getModel();
        for (int i = 0; i < model.getRowCount(); i++) {
            total += (float) model.getValueAt(i, 4);
        }
        return total;
    }

    private void definirParcelas(float totalPagar) {
        float valorParcela;
        int numParcelas;
        comboBoxParcela.removeAllItems();
        if (totalPagar <= 50) {
            numParcelas = 3;
        } else {
            numParcelas = 5;
        }
        for (int i = 1; i <= numParcelas; i++) {
            valorParcela = totalPagar / i;
            String temp = i + "x de " + String.format("R$ %.2f", valorParcela);
            comboBoxParcela.addItem(temp);
        }
    }

    private void cadastrarItensCarrinho(int cod_compra) throws SQLException {
        DefaultTableModel model = (DefaultTableModel) tblCompra.getModel();
        for (int i = 0; i < model.getRowCount(); i++) {
            Produto prod = new Produto();
            prod.setCod_Produto((int) model.getValueAt(i, 0));
            int quant = (int) model.getValueAt(i, 3);
            Compra compra = new Compra();
            compra.setCod_Compra(cod_compra);
            ProdutoController.atualizarQuantidadeProduto(prod.getCod_Produto(), quant);
            ProdCompraController.cadastrarProdCompra(compra, prod, quant);
        }
    }

    private void imprimirComprovante(int id_compra, float valor_total, float valor_desconto) throws JRException, SQLException {
        String valor_total_string = String.format("R$ %.2f", valor_total);
        String valor_desconto_string = String.format("R$ %.2f", valor_desconto);
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("id_compra", id_compra);
        parameters.put("valor_total", valor_total_string);
        parameters.put("valor_desconto", valor_desconto_string);
        Utilitaries.imprimirRelatorio(parameters, "comprovante_compra.jrxml", true, id_compra);
    }

    // método para limpar campos
    private void limparCampos() {
        Utilitaries.limparCampos(panelProduto);
        Utilitaries.limparCampos(panelCliente);
        Utilitaries.limparCampos(panelCompra);
        lblValorAPagar.setText("R$ 00,00");
        txtQtd.setValue(0);
        comboBoxPag.setSelectedIndex(0);
        DefaultTableModel model = (DefaultTableModel) tblCompra.getModel();
        model.setRowCount(0);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelProduto = new resources.graphicComponents.PanelRound();
        lblTituloProd = new javax.swing.JLabel();
        scrollPane = new javax.swing.JScrollPane();
        tblProd = new javax.swing.JTable();
        txtNomeProd = new javax.swing.JTextField();
        lblQtd = new javax.swing.JLabel();
        txtQtd = new javax.swing.JSpinner();
        btnAdicionarCarrinho = new javax.swing.JButton();
        panelCliente = new resources.graphicComponents.PanelRound();
        lblTituloCliente = new javax.swing.JLabel();
        scrollPane1 = new javax.swing.JScrollPane();
        tblCliente = new javax.swing.JTable();
        txtNomeCliente = new javax.swing.JTextField();
        btnAdicionarCliente = new javax.swing.JButton();
        panelCompra = new resources.graphicComponents.PanelRound();
        jLabel4 = new javax.swing.JLabel();
        lblTitular = new javax.swing.JLabel();
        txtTitular = new javax.swing.JTextField();
        lblTelefone = new javax.swing.JLabel();
        lblClube = new javax.swing.JLabel();
        txtTelefone = new javax.swing.JFormattedTextField();
        txtClube = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblCompra = new javax.swing.JTable();
        btnRemoverCarrinho = new javax.swing.JButton();
        lblTotal = new javax.swing.JLabel();
        lblDesconto = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        txtDesconto = new javax.swing.JTextField();
        lblPag = new javax.swing.JLabel();
        comboBoxPag = new javax.swing.JComboBox<>();
        comboBoxParcela = new javax.swing.JComboBox<>();
        panelRound5 = new resources.graphicComponents.PanelRound();
        jLabel7 = new javax.swing.JLabel();
        lblValorAPagar = new javax.swing.JLabel();
        btnFinalizar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        panelRound4 = new resources.graphicComponents.PanelRound();
        lblTitulo1 = new javax.swing.JLabel();

        panelProduto.setBackground(new java.awt.Color(30, 64, 92));
        panelProduto.setRoundTopLeft(20);

        lblTituloProd.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTituloProd.setForeground(new java.awt.Color(255, 255, 255));
        lblTituloProd.setText("Selecionar Produtos");

        tblProd.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nome do Produto", "Preço", "Categoria", "Marca"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Float.class, java.lang.String.class, java.lang.String.class
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
        tblProd.getTableHeader().setReorderingAllowed(false);
        scrollPane.setViewportView(tblProd);

        txtNomeProd.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNomeProdKeyReleased(evt);
            }
        });

        lblQtd.setForeground(new java.awt.Color(255, 255, 255));
        lblQtd.setText("Qtd:");

        btnAdicionarCarrinho.setIcon(new FlatSVGIcon(getClass().getResource("/resources/img/cart_add.svg")));
        btnAdicionarCarrinho.setText("Adicionar ao Carrinho");
        btnAdicionarCarrinho.setBorderPainted(false);
        btnAdicionarCarrinho.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAdicionarCarrinho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarCarrinhoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelProdutoLayout = new javax.swing.GroupLayout(panelProduto);
        panelProduto.setLayout(panelProdutoLayout);
        panelProdutoLayout.setHorizontalGroup(
            panelProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelProdutoLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(panelProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrollPane)
                    .addGroup(panelProdutoLayout.createSequentialGroup()
                        .addComponent(txtNomeProd)
                        .addGap(18, 18, 18)
                        .addComponent(lblQtd)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtQtd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnAdicionarCarrinho))
                    .addComponent(lblTituloProd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18))
        );
        panelProdutoLayout.setVerticalGroup(
            panelProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelProdutoLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(lblTituloProd)
                .addGap(18, 18, 18)
                .addComponent(scrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(panelProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNomeProd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblQtd)
                    .addComponent(txtQtd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAdicionarCarrinho))
                .addGap(18, 18, 18))
        );

        panelCliente.setBackground(new java.awt.Color(30, 64, 92));
        panelCliente.setRoundBottomLeft(20);

        lblTituloCliente.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTituloCliente.setForeground(new java.awt.Color(255, 255, 255));
        lblTituloCliente.setText("Selecionar Cliente");

        tblCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nome", "Telefone", "Cliente NEXOClub", "CPF"
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
        tblCliente.getTableHeader().setReorderingAllowed(false);
        scrollPane1.setViewportView(tblCliente);

        txtNomeCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNomeClienteKeyReleased(evt);
            }
        });

        btnAdicionarCliente.setText("Selecionar Cliente");
        btnAdicionarCliente.setBorderPainted(false);
        btnAdicionarCliente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAdicionarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarClienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelClienteLayout = new javax.swing.GroupLayout(panelCliente);
        panelCliente.setLayout(panelClienteLayout);
        panelClienteLayout.setHorizontalGroup(
            panelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelClienteLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(panelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(scrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 511, Short.MAX_VALUE)
                    .addComponent(lblTituloCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelClienteLayout.createSequentialGroup()
                        .addComponent(txtNomeCliente)
                        .addGap(18, 18, 18)
                        .addComponent(btnAdicionarCliente)))
                .addGap(19, 19, 19))
        );
        panelClienteLayout.setVerticalGroup(
            panelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelClienteLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(lblTituloCliente)
                .addGap(18, 18, 18)
                .addComponent(scrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNomeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAdicionarCliente))
                .addGap(18, 18, 18))
        );

        panelCompra.setBackground(new java.awt.Color(30, 64, 92));
        panelCompra.setRoundBottomRight(20);
        panelCompra.setRoundTopRight(20);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Dados da Compra");

        lblTitular.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTitular.setForeground(new java.awt.Color(255, 255, 255));
        lblTitular.setText("Titular:");

        txtTitular.setEnabled(false);

        lblTelefone.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTelefone.setForeground(new java.awt.Color(255, 255, 255));
        lblTelefone.setText("Telefone:");

        lblClube.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblClube.setForeground(new java.awt.Color(255, 255, 255));
        lblClube.setText("Cliente NEXOClub:");

        txtTelefone.setEnabled(false);

        txtClube.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtClube.setEnabled(false);

        tblCompra.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Produto", "Preço", "Qtd", "Subtotal"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Float.class, java.lang.Integer.class, java.lang.Float.class
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
        tblCompra.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(tblCompra);

        btnRemoverCarrinho.setIcon(new FlatSVGIcon(getClass().getResource("/resources/img/cart_remove.svg")));
        btnRemoverCarrinho.setText("Remover Produto do Carrinho");
        btnRemoverCarrinho.setBorderPainted(false);
        btnRemoverCarrinho.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRemoverCarrinho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoverCarrinhoActionPerformed(evt);
            }
        });

        lblTotal.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTotal.setForeground(new java.awt.Color(255, 255, 255));
        lblTotal.setText("Total:");

        lblDesconto.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblDesconto.setForeground(new java.awt.Color(255, 255, 255));
        lblDesconto.setText("Descontos do NEXOClub:");

        txtTotal.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtTotal.setEnabled(false);

        txtDesconto.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtDesconto.setEnabled(false);

        lblPag.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblPag.setForeground(new java.awt.Color(255, 255, 255));
        lblPag.setText("Forma de Pagamento:");

        comboBoxPag.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        comboBoxPag.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione uma Forma" }));
        comboBoxPag.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxPagActionPerformed(evt);
            }
        });

        comboBoxParcela.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        panelRound5.setBackground(new java.awt.Color(0, 51, 102));
        panelRound5.setRoundBottomRight(30);
        panelRound5.setRoundTopLeft(30);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 28)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Valor à Pagar:");

        lblValorAPagar.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        lblValorAPagar.setForeground(new java.awt.Color(255, 255, 255));
        lblValorAPagar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblValorAPagar.setText("R$ 00,00");

        btnFinalizar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnFinalizar.setText("Finalizar Compra");
        btnFinalizar.setBorderPainted(false);
        btnFinalizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnFinalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinalizarActionPerformed(evt);
            }
        });

        btnCancelar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.setBorderPainted(false);
        btnCancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelRound5Layout = new javax.swing.GroupLayout(panelRound5);
        panelRound5.setLayout(panelRound5Layout);
        panelRound5Layout.setHorizontalGroup(
            panelRound5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound5Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(panelRound5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRound5Layout.createSequentialGroup()
                        .addComponent(btnFinalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(lblValorAPagar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(12, 12, 12))
        );
        panelRound5Layout.setVerticalGroup(
            panelRound5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound5Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblValorAPagar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelRound5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnFinalizar, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(12, 12, 12))
        );

        javax.swing.GroupLayout panelCompraLayout = new javax.swing.GroupLayout(panelCompra);
        panelCompra.setLayout(panelCompraLayout);
        panelCompraLayout.setHorizontalGroup(
            panelCompraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCompraLayout.createSequentialGroup()
                .addGroup(panelCompraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelCompraLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnRemoverCarrinho))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelCompraLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(panelCompraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 502, Short.MAX_VALUE)
                            .addGroup(panelCompraLayout.createSequentialGroup()
                                .addComponent(lblTitular)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTitular))
                            .addGroup(panelCompraLayout.createSequentialGroup()
                                .addComponent(lblTelefone)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lblClube)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtClube))
                            .addGroup(panelCompraLayout.createSequentialGroup()
                                .addComponent(lblTotal)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lblDesconto)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtDesconto))
                            .addGroup(panelCompraLayout.createSequentialGroup()
                                .addComponent(lblPag)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(comboBoxPag, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(comboBoxParcela, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(panelRound5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(18, 18, 18))
        );
        panelCompraLayout.setVerticalGroup(
            panelCompraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCompraLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelCompraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTitular)
                    .addComponent(txtTitular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelCompraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTelefone)
                    .addComponent(lblClube)
                    .addComponent(txtClube, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRemoverCarrinho)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelCompraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTotal)
                    .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDesconto)
                    .addComponent(txtDesconto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelCompraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPag)
                    .addComponent(comboBoxPag, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboBoxParcela, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelRound5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );

        panelRound4.setBackground(new java.awt.Color(30, 64, 92));
        panelRound4.setRoundBottomLeft(20);
        panelRound4.setRoundBottomRight(20);
        panelRound4.setRoundTopLeft(20);
        panelRound4.setRoundTopRight(20);

        lblTitulo1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblTitulo1.setForeground(new java.awt.Color(255, 255, 255));
        lblTitulo1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo1.setText("Cadastrar Compra");

        javax.swing.GroupLayout panelRound4Layout = new javax.swing.GroupLayout(panelRound4);
        panelRound4.setLayout(panelRound4Layout);
        panelRound4Layout.setHorizontalGroup(
            panelRound4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo1, javax.swing.GroupLayout.DEFAULT_SIZE, 1074, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelRound4Layout.setVerticalGroup(
            panelRound4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo1, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelRound4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelProduto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelCompra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(panelRound4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panelProduto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(panelCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(panelCompra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtNomeProdKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNomeProdKeyReleased
        String nome = txtNomeProd.getText();
        listarProdutos(2, nome);
    }//GEN-LAST:event_txtNomeProdKeyReleased

    private void btnAdicionarCarrinhoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarCarrinhoActionPerformed
        int qtdProd = (int) txtQtd.getValue();
        int selectedRow = tblProd.getSelectedRow();
        if (selectedRow != -1) {
            if (qtdProd > 0) {
                int id = (int) tblProd.getValueAt(selectedRow, 0);
                try {
                    Produto prod = ProdutoController.buscarPorId(id);
                    adicionarCarrinho(prod, qtdProd);
                    atualizarValores();
                } catch (SQLException ex) {
                    Logger.getLogger(CadastrarCompra.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Insira uma quantidade válida", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Selecione um produto para adicionar ao carrinho", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnAdicionarCarrinhoActionPerformed

    private void txtNomeClienteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNomeClienteKeyReleased
        String nome = txtNomeCliente.getText();
        listarClientes(2, nome);
    }//GEN-LAST:event_txtNomeClienteKeyReleased

    private void btnAdicionarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarClienteActionPerformed
        int selectedRow = tblCliente.getSelectedRow();
        if (selectedRow != -1) {
            int id = (int) tblCliente.getValueAt(selectedRow, 0);
            try {
                Cliente cliente = ClienteController.buscarPorId(id);
                txtTitular.setText(cliente.getNome_cli());
                txtTelefone.setText(cliente.getTelefone());
                if (cliente.getAtivo_clube() == 0) {
                    txtClube.setText(cliente.getCod_cli() + " - Não");
                } else {
                    txtClube.setText(cliente.getCod_cli() + " - Sim");
                }
            } catch (SQLException ex) {
                Logger.getLogger(CadastrarCompra.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Selecione um cliente para a compra", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnAdicionarClienteActionPerformed

    private void comboBoxPagActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxPagActionPerformed
        String pag = comboBoxPag.getSelectedItem().toString();
        if (pag.contains("Crédito")) {
            comboBoxParcela.setVisible(true);
        } else {
            comboBoxParcela.setVisible(false);
        }
    }//GEN-LAST:event_comboBoxPagActionPerformed

    private void btnFinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinalizarActionPerformed
        Cliente cliente = new Cliente();
        LocalDateTime data_compra = LocalDateTime.now();
        FormaPag forma_pag = new FormaPag();
        DefaultTableModel model = (DefaultTableModel) tblCompra.getModel();
        float total, desconto;

        if (txtTitular.getText().isEmpty()) {
            int status = JOptionPane.showConfirmDialog(null, "Tem certeza que não selecionará um cliente?", "Cliente", JOptionPane.YES_NO_OPTION);
            if (status == JOptionPane.YES_OPTION) {
                txtTitular.setText("Cliente Não Cadastrado");
                txtClube.setText("Não");
                cliente.setCod_cli(1);
            } else {
                return;
            }
        } else {
            cliente.setCod_cli(Integer.parseInt(txtClube.getText().replaceAll("[^0-9]", "")));
        }

        if (model.getRowCount() == 0) {
            JOptionPane.showMessageDialog(null, "O Carrinho está vazio", "Atenção", JOptionPane.WARNING_MESSAGE);
        } else {
            total = calcularTotal();
            desconto = calcularDesconto(total);
            if (comboBoxPag.getSelectedIndex() == 0) {
                JOptionPane.showMessageDialog(null, "Selecione uma forma de pagamento", "Atenção", JOptionPane.WARNING_MESSAGE);
            } else {
                String pagTemp = String.valueOf(comboBoxPag.getSelectedItem()).replaceAll("\\D.*", "");
                forma_pag.setCod_forma_pag(Integer.parseInt(pagTemp));
                try {
                    int cod_compra = CompraController.cadastrarCompra(func, cliente, data_compra, forma_pag);
                    cadastrarItensCarrinho(cod_compra);
                    int status = JOptionPane.showConfirmDialog(null, "Deseja imprimir o comprovante da compra?", "Comprovante", JOptionPane.YES_NO_OPTION);
                    if (status == JOptionPane.YES_OPTION) {
                        imprimirComprovante(cod_compra, total, desconto);
                    }
                } catch (SQLException | JRException ex) {
                    Logger.getLogger(CadastrarCompra.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_btnFinalizarActionPerformed

    private void btnRemoverCarrinhoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverCarrinhoActionPerformed
        int selectedRow = tblProd.getSelectedRow();
        if (selectedRow != -1) {
            DefaultTableModel model = (DefaultTableModel) tblCompra.getModel();
            model.removeRow(selectedRow);
            atualizarValores();
        } else {
            JOptionPane.showMessageDialog(null, "Selecione um produto para remover do carrinho", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnRemoverCarrinhoActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        int status = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja cancelar a compra?", "Deletar", JOptionPane.YES_NO_OPTION);
        if (status == JOptionPane.YES_OPTION) {
            limparCampos();
        }
    }//GEN-LAST:event_btnCancelarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionarCarrinho;
    private javax.swing.JButton btnAdicionarCliente;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnFinalizar;
    private javax.swing.JButton btnRemoverCarrinho;
    private javax.swing.JComboBox<String> comboBoxPag;
    private javax.swing.JComboBox<String> comboBoxParcela;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblClube;
    private javax.swing.JLabel lblDesconto;
    private javax.swing.JLabel lblPag;
    private javax.swing.JLabel lblQtd;
    private javax.swing.JLabel lblTelefone;
    private javax.swing.JLabel lblTitular;
    private javax.swing.JLabel lblTitulo1;
    private javax.swing.JLabel lblTituloCliente;
    private javax.swing.JLabel lblTituloProd;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JLabel lblValorAPagar;
    private resources.graphicComponents.PanelRound panelCliente;
    private resources.graphicComponents.PanelRound panelCompra;
    private resources.graphicComponents.PanelRound panelProduto;
    private resources.graphicComponents.PanelRound panelRound4;
    private resources.graphicComponents.PanelRound panelRound5;
    private javax.swing.JScrollPane scrollPane;
    private javax.swing.JScrollPane scrollPane1;
    private javax.swing.JTable tblCliente;
    private javax.swing.JTable tblCompra;
    private javax.swing.JTable tblProd;
    private javax.swing.JTextField txtClube;
    private javax.swing.JTextField txtDesconto;
    private javax.swing.JTextField txtNomeCliente;
    private javax.swing.JTextField txtNomeProd;
    private javax.swing.JSpinner txtQtd;
    private javax.swing.JFormattedTextField txtTelefone;
    private javax.swing.JTextField txtTitular;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
}
