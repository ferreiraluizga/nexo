package view;

import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import com.formdev.flatlaf.intellijthemes.FlatCarbonIJTheme;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.UIManager;
import model.Funcionario;
import resources.graphicComponents.FontLoader;
import resources.utilitaries.Utilitaries;
import view.cliente.CadastrarCliente;
import view.cliente.ConsultarCliente;
import view.compra.CadastrarCompra;
import view.compra.CadastrarForma;
import view.compra.ConsultarCompra;
import view.compra.ConsultarForma;
import view.funcionario.*;
import view.produto.*;

/**
 *
 * @author ferreiraluizga
 */

public class Dashboard extends javax.swing.JFrame {

    Funcionario func;

    public Dashboard() {
        initComponents();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/resources/img/app_logo.png")));
        setExtendedState(MAXIMIZED_BOTH);
        Utilitaries.setImage(lblDashboardLogo, "dashboard_logo.png");
    }

    public Dashboard(Funcionario func) {
        this.func = func;
        initComponents();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/resources/img/app_logo.png")));
        setExtendedState(MAXIMIZED_BOTH);
        lblUser.setText(func.getNome_Func());
        lblCargo.setText(func.getCargo().getNome_cargo());
        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lblDateTime.setText(Utilitaries.getHoraAtual() + " | " + Utilitaries.setDataAtual());
            }
        });
        timer.start();
        definirFuncionalidade(func.getCargo().getNome_cargo());
        Utilitaries.setImage(lblDashboardLogo, "dashboard_logo.png");
        Utilitaries.updateBody(body, new CadastrarCompra(func), false);
    }
    
    // método para definir funcionalidades de acordo com o cargo
    private void definirFuncionalidade(String nome_cargo) {
        switch (nome_cargo) {
            case "Gerente":
                menu_funcionarios.setEnabled(false);
                break;
            case "Operador de Caixa":
                menu_funcionarios.setEnabled(false);
                break;
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sidebar = new resources.graphicComponents.GradientPanel();
        imageAvatar1 = new resources.graphicComponents.ImageAvatar();
        lblUser = new javax.swing.JLabel();
        lblDateTime = new javax.swing.JLabel();
        lblCargo = new javax.swing.JLabel();
        lblDashboardLogo = new javax.swing.JLabel();
        body = new javax.swing.JPanel();
        menuBar = new javax.swing.JMenuBar();
        menu_configuracoes = new javax.swing.JMenu();
        menuAlterarLogin = new javax.swing.JMenuItem();
        menuEncerrarSessao = new javax.swing.JMenuItem();
        menuSair = new javax.swing.JMenuItem();
        menu_clientes = new javax.swing.JMenu();
        menuCadastrarCliente = new javax.swing.JMenuItem();
        menuConsultarCliente = new javax.swing.JMenuItem();
        menu_funcionarios = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        menuCadastrarFunc = new javax.swing.JMenuItem();
        menuConsultarFunc = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        menuCadastrarCargo = new javax.swing.JMenuItem();
        menuConsultarCargo = new javax.swing.JMenuItem();
        menu_produtos = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();
        menuCadastrarProduto = new javax.swing.JMenuItem();
        menuConsultarProduto = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        menuCadastrarCategoria = new javax.swing.JMenuItem();
        menuConsultarCategoria = new javax.swing.JMenuItem();
        jMenu7 = new javax.swing.JMenu();
        menuCadastrarMarca = new javax.swing.JMenuItem();
        menuConsultarMarca = new javax.swing.JMenuItem();
        jMenu8 = new javax.swing.JMenu();
        menuCadastrarForn = new javax.swing.JMenuItem();
        menuConsultarForn = new javax.swing.JMenuItem();
        menu_compras = new javax.swing.JMenu();
        menuCadastrarCompra = new javax.swing.JMenuItem();
        menuConsultarCompra = new javax.swing.JMenuItem();
        jMenu9 = new javax.swing.JMenu();
        menuCadastrarForma = new javax.swing.JMenuItem();
        menuConsultarForma = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("NEXO: Dashboard");

        sidebar.setGradientColor1(new java.awt.Color(38, 111, 163));
        sidebar.setGradientColor2(new java.awt.Color(34, 73, 104));

        lblUser.setFont(new java.awt.Font("Poppins", 1, 18)); // NOI18N
        lblUser.setForeground(new java.awt.Color(255, 255, 255));
        lblUser.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblUser.setText("Funcionario");

        lblDateTime.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblDateTime.setForeground(new java.awt.Color(255, 255, 255));
        lblDateTime.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDateTime.setText("HH:mm:ss DD/MM/YYYY");

        lblCargo.setForeground(new java.awt.Color(255, 255, 255));
        lblCargo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCargo.setText("Cargo");

        javax.swing.GroupLayout sidebarLayout = new javax.swing.GroupLayout(sidebar);
        sidebar.setLayout(sidebarLayout);
        sidebarLayout.setHorizontalGroup(
            sidebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sidebarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(sidebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(lblDashboardLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(imageAvatar1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(sidebarLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(lblCargo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(12, 12, 12))
            .addGroup(sidebarLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(lblDateTime, javax.swing.GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
                .addGap(6, 6, 6))
        );
        sidebarLayout.setVerticalGroup(
            sidebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sidebarLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(lblDashboardLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addComponent(imageAvatar1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblUser)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblCargo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 502, Short.MAX_VALUE)
                .addComponent(lblDateTime)
                .addGap(18, 18, 18))
        );

        body.setLayout(new java.awt.BorderLayout());

        menu_configuracoes.setIcon(new FlatSVGIcon(getClass().getResource("/resources/img/settings.svg")));
        menu_configuracoes.setText("Configurações");

        menuAlterarLogin.setText("Alterar Informações de Login");
        menuAlterarLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuAlterarLoginActionPerformed(evt);
            }
        });
        menu_configuracoes.add(menuAlterarLogin);

        menuEncerrarSessao.setText("Encerrar Sessão");
        menuEncerrarSessao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuEncerrarSessaoActionPerformed(evt);
            }
        });
        menu_configuracoes.add(menuEncerrarSessao);

        menuSair.setText("Sair");
        menuSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuSairActionPerformed(evt);
            }
        });
        menu_configuracoes.add(menuSair);

        menuBar.add(menu_configuracoes);

        menu_clientes.setIcon(new FlatSVGIcon(getClass().getResource("/resources/img/users.svg")));
        menu_clientes.setText("Clientes");

        menuCadastrarCliente.setText("Cadastrar Cliente");
        menuCadastrarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCadastrarClienteActionPerformed(evt);
            }
        });
        menu_clientes.add(menuCadastrarCliente);

        menuConsultarCliente.setText("Consultar Clientes");
        menuConsultarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuConsultarClienteActionPerformed(evt);
            }
        });
        menu_clientes.add(menuConsultarCliente);

        menuBar.add(menu_clientes);

        menu_funcionarios.setIcon(new FlatSVGIcon(getClass().getResource("/resources/img/building.svg")));
        menu_funcionarios.setText("Funcionários");

        jMenu3.setText("Funcionários");

        menuCadastrarFunc.setText("Cadastrar Funcionários");
        menuCadastrarFunc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCadastrarFuncActionPerformed(evt);
            }
        });
        jMenu3.add(menuCadastrarFunc);

        menuConsultarFunc.setText("Consultar Funcionários");
        menuConsultarFunc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuConsultarFuncActionPerformed(evt);
            }
        });
        jMenu3.add(menuConsultarFunc);

        menu_funcionarios.add(jMenu3);

        jMenu4.setText("Cargos");

        menuCadastrarCargo.setText("Cadastrar Cargos");
        menuCadastrarCargo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCadastrarCargoActionPerformed(evt);
            }
        });
        jMenu4.add(menuCadastrarCargo);

        menuConsultarCargo.setText("Consultar Cargos");
        menuConsultarCargo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuConsultarCargoActionPerformed(evt);
            }
        });
        jMenu4.add(menuConsultarCargo);

        menu_funcionarios.add(jMenu4);

        menuBar.add(menu_funcionarios);

        menu_produtos.setIcon(new FlatSVGIcon(getClass().getResource("/resources/img/products.svg")));
        menu_produtos.setText("Produtos");

        jMenu5.setText("Produtos");

        menuCadastrarProduto.setText("Cadastrar Produtos");
        menuCadastrarProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCadastrarProdutoActionPerformed(evt);
            }
        });
        jMenu5.add(menuCadastrarProduto);

        menuConsultarProduto.setText("Consultar Produtos");
        menuConsultarProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuConsultarProdutoActionPerformed(evt);
            }
        });
        jMenu5.add(menuConsultarProduto);

        menu_produtos.add(jMenu5);

        jMenu6.setText("Categorias");

        menuCadastrarCategoria.setText("Cadastrar Categorias");
        menuCadastrarCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCadastrarCategoriaActionPerformed(evt);
            }
        });
        jMenu6.add(menuCadastrarCategoria);

        menuConsultarCategoria.setText("Consultar Categorias");
        menuConsultarCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuConsultarCategoriaActionPerformed(evt);
            }
        });
        jMenu6.add(menuConsultarCategoria);

        menu_produtos.add(jMenu6);

        jMenu7.setText("Marcas");

        menuCadastrarMarca.setText("Cadastrar Marcas");
        menuCadastrarMarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCadastrarMarcaActionPerformed(evt);
            }
        });
        jMenu7.add(menuCadastrarMarca);

        menuConsultarMarca.setText("Consultar Marcas");
        menuConsultarMarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuConsultarMarcaActionPerformed(evt);
            }
        });
        jMenu7.add(menuConsultarMarca);

        menu_produtos.add(jMenu7);

        jMenu8.setText("Fornecedores");

        menuCadastrarForn.setText("Cadastrar Fornecedor");
        menuCadastrarForn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCadastrarFornActionPerformed(evt);
            }
        });
        jMenu8.add(menuCadastrarForn);

        menuConsultarForn.setText("Consultar Fornecedores");
        menuConsultarForn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuConsultarFornActionPerformed(evt);
            }
        });
        jMenu8.add(menuConsultarForn);

        menu_produtos.add(jMenu8);

        menuBar.add(menu_produtos);

        menu_compras.setIcon(new FlatSVGIcon(getClass().getResource("/resources/img/sell.svg")));
        menu_compras.setText("Compras");

        menuCadastrarCompra.setText("Cadastrar Compra");
        menuCadastrarCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCadastrarCompraActionPerformed(evt);
            }
        });
        menu_compras.add(menuCadastrarCompra);

        menuConsultarCompra.setText("Consultar Compras");
        menuConsultarCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuConsultarCompraActionPerformed(evt);
            }
        });
        menu_compras.add(menuConsultarCompra);

        jMenu9.setText("Formas de Pagamento");

        menuCadastrarForma.setText("Cadastrar Formas");
        menuCadastrarForma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCadastrarFormaActionPerformed(evt);
            }
        });
        jMenu9.add(menuCadastrarForma);

        menuConsultarForma.setText("Consultar Formas");
        menuConsultarForma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuConsultarFormaActionPerformed(evt);
            }
        });
        jMenu9.add(menuConsultarForma);

        menu_compras.add(jMenu9);

        menuBar.add(menu_compras);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(sidebar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(body, javax.swing.GroupLayout.DEFAULT_SIZE, 769, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sidebar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(body, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void menuCadastrarCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCadastrarCompraActionPerformed
        Utilitaries.updateBody(body, new CadastrarCompra(func), false);
    }//GEN-LAST:event_menuCadastrarCompraActionPerformed

    private void menuConsultarCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuConsultarCompraActionPerformed
        Utilitaries.updateBody(body, new ConsultarCompra(), true);
    }//GEN-LAST:event_menuConsultarCompraActionPerformed

    private void menuCadastrarProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCadastrarProdutoActionPerformed
        Utilitaries.updateBody(body, new CadastrarProduto(), true);
    }//GEN-LAST:event_menuCadastrarProdutoActionPerformed

    private void menuConsultarProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuConsultarProdutoActionPerformed
        Utilitaries.updateBody(body, new ConsultarProduto(), true);
    }//GEN-LAST:event_menuConsultarProdutoActionPerformed

    private void menuCadastrarCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCadastrarCategoriaActionPerformed
        Utilitaries.updateBody(body, new CadastrarCategoria(), true);
    }//GEN-LAST:event_menuCadastrarCategoriaActionPerformed

    private void menuConsultarCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuConsultarCategoriaActionPerformed
        Utilitaries.updateBody(body, new ConsultarCategoria(), true);
    }//GEN-LAST:event_menuConsultarCategoriaActionPerformed

    private void menuCadastrarMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCadastrarMarcaActionPerformed
        Utilitaries.updateBody(body, new CadastrarMarca(), true);
    }//GEN-LAST:event_menuCadastrarMarcaActionPerformed

    private void menuConsultarMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuConsultarMarcaActionPerformed
        Utilitaries.updateBody(body, new ConsultarMarca(), true);
    }//GEN-LAST:event_menuConsultarMarcaActionPerformed

    private void menuCadastrarFornActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCadastrarFornActionPerformed
        Utilitaries.updateBody(body, new CadastrarForn(), true);
    }//GEN-LAST:event_menuCadastrarFornActionPerformed

    private void menuConsultarFornActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuConsultarFornActionPerformed
        Utilitaries.updateBody(body, new ConsultarForn(), true);
    }//GEN-LAST:event_menuConsultarFornActionPerformed

    private void menuCadastrarFuncActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCadastrarFuncActionPerformed
        Utilitaries.updateBody(body, new CadastrarFunc(), true);
    }//GEN-LAST:event_menuCadastrarFuncActionPerformed

    private void menuConsultarFuncActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuConsultarFuncActionPerformed
        Utilitaries.updateBody(body, new ConsultarFunc(), true);
    }//GEN-LAST:event_menuConsultarFuncActionPerformed

    private void menuCadastrarCargoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCadastrarCargoActionPerformed
        Utilitaries.updateBody(body, new CadastrarCargo(), true);
    }//GEN-LAST:event_menuCadastrarCargoActionPerformed

    private void menuConsultarCargoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuConsultarCargoActionPerformed
        Utilitaries.updateBody(body, new ConsultarCargo(), true);
    }//GEN-LAST:event_menuConsultarCargoActionPerformed

    private void menuCadastrarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCadastrarClienteActionPerformed
        Utilitaries.updateBody(body, new CadastrarCliente(), true);
    }//GEN-LAST:event_menuCadastrarClienteActionPerformed

    private void menuConsultarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuConsultarClienteActionPerformed
        Utilitaries.updateBody(body, new ConsultarCliente(), true);
    }//GEN-LAST:event_menuConsultarClienteActionPerformed

    private void menuAlterarLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuAlterarLoginActionPerformed
        new AlterarLogin(func).setVisible(true);
    }//GEN-LAST:event_menuAlterarLoginActionPerformed

    private void menuEncerrarSessaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuEncerrarSessaoActionPerformed
        int status = JOptionPane.showConfirmDialog(null, "Deseja fechar o sistema?", "Sair", JOptionPane.YES_NO_OPTION);
        if (status == JOptionPane.YES_OPTION) {
            this.dispose();
            new Login().setVisible(true);
        }
    }//GEN-LAST:event_menuEncerrarSessaoActionPerformed

    private void menuSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuSairActionPerformed
        int status = JOptionPane.showConfirmDialog(null, "Deseja fechar o sistema?", "Sair", JOptionPane.YES_NO_OPTION);
        if (status == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_menuSairActionPerformed

    private void menuCadastrarFormaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCadastrarFormaActionPerformed
        Utilitaries.updateBody(body, new CadastrarForma(), true);
    }//GEN-LAST:event_menuCadastrarFormaActionPerformed

    private void menuConsultarFormaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuConsultarFormaActionPerformed
        Utilitaries.updateBody(body, new ConsultarForma(), true);
    }//GEN-LAST:event_menuConsultarFormaActionPerformed

    public static void main(String args[]) {
        FlatCarbonIJTheme.setup();
        UIManager.put("defaultFont", FontLoader.loadFont("Poppins.ttf", 13f));
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Dashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel body;
    private resources.graphicComponents.ImageAvatar imageAvatar1;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenu jMenu9;
    private javax.swing.JLabel lblCargo;
    private javax.swing.JLabel lblDashboardLogo;
    private javax.swing.JLabel lblDateTime;
    private javax.swing.JLabel lblUser;
    private javax.swing.JMenuItem menuAlterarLogin;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem menuCadastrarCargo;
    private javax.swing.JMenuItem menuCadastrarCategoria;
    private javax.swing.JMenuItem menuCadastrarCliente;
    private javax.swing.JMenuItem menuCadastrarCompra;
    private javax.swing.JMenuItem menuCadastrarForma;
    private javax.swing.JMenuItem menuCadastrarForn;
    private javax.swing.JMenuItem menuCadastrarFunc;
    private javax.swing.JMenuItem menuCadastrarMarca;
    private javax.swing.JMenuItem menuCadastrarProduto;
    private javax.swing.JMenuItem menuConsultarCargo;
    private javax.swing.JMenuItem menuConsultarCategoria;
    private javax.swing.JMenuItem menuConsultarCliente;
    private javax.swing.JMenuItem menuConsultarCompra;
    private javax.swing.JMenuItem menuConsultarForma;
    private javax.swing.JMenuItem menuConsultarForn;
    private javax.swing.JMenuItem menuConsultarFunc;
    private javax.swing.JMenuItem menuConsultarMarca;
    private javax.swing.JMenuItem menuConsultarProduto;
    private javax.swing.JMenuItem menuEncerrarSessao;
    private javax.swing.JMenuItem menuSair;
    private javax.swing.JMenu menu_clientes;
    private javax.swing.JMenu menu_compras;
    private javax.swing.JMenu menu_configuracoes;
    private javax.swing.JMenu menu_funcionarios;
    private javax.swing.JMenu menu_produtos;
    private resources.graphicComponents.GradientPanel sidebar;
    // End of variables declaration//GEN-END:variables
}
