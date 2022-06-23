package view;

import dao.UsuariosDAO;
import empresaiv.BD;
import empresaiv.GuiMenuPrincipal;
import javax.swing.*;
import java.awt.event.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Ronaldo Rodrigues Godoi
 */
public class GuiCadastroUsuarios extends JPanel {
    
    JLabel lbCadastroUsuarios;
    
    boolean inclusao = false;
    
    JLabel lbId, lbNome, lbSenha;    
    
    JButton btGravar, btAlterar, btExcluir, btNovo, btLocalizar, btCancelar, btSair;
    
    JTextField tfId, tfNome;
    JPasswordField pfSenha;
    
    JCheckBox cbCadastroClientes, cbCadastroFornecedores,
        cbCadastroProdutos, cbCadastroCategoria, cbCadastroEnderecoEntregaCliente,
        cbCadastroEnderecoEntregaFornecedor, cbCadastroFornecedoresProduto,
        cbCadastroUnidades, cbPedidoCliente, cbPedidoFornecedor, cbConsultaClientes,
        cbConsultaFornecedor, cbConsultaProduto, cbConsultaCategoria,
        cbConsultaEnderecoEntregaCliente, cbConsultaEnderecoEntregaFornecedor,
        cbRelatorioClientes, cbRelatorioFornecedor, cbRelatorioProduto,
        cbRelatorioCategoria, cbRelatorioUnidades;
          
    Date nova_data = new Date();
    DateFormat formatoData = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    
    private UsuariosDAO usuarios;
        
    public GuiCadastroUsuarios() {
        
        inicializarComponentes();
        definirEventos();
        
    }
    
    public void inicializarComponentes() {
        setLayout(null);
        
        lbCadastroUsuarios = new JLabel("Cadastro de Usuários");
        
        lbId = new JLabel("Identificação: ");
        lbNome = new JLabel("Nome: ");
        lbSenha = new JLabel("Senha: ");
        
        tfId = new JTextField(20);
        tfId.setEditable(false);
        tfNome = new JTextField(80);
        pfSenha = new JPasswordField(50);
        
        cbCadastroClientes = new JCheckBox("Cadastro de Clientes");
        cbCadastroFornecedores = new JCheckBox("Cadastro de Fornecedores");
        cbCadastroProdutos = new JCheckBox("Cadastro de Produtos");
        cbCadastroCategoria = new JCheckBox("Cadastro de Categoria");
        cbCadastroEnderecoEntregaCliente = new JCheckBox("Cadastro de endereço de entrega de Cliente");
        cbCadastroEnderecoEntregaFornecedor = new JCheckBox("Cadastro onde o Fornecedor deve entregar");
        cbCadastroFornecedoresProduto = new JCheckBox("Cadastro de Ligação Produto-Fornecedores");
        cbCadastroUnidades = new JCheckBox("Cadastro de Unidades");
        cbPedidoCliente = new JCheckBox("Pedido de Cliente");
        cbPedidoFornecedor = new JCheckBox("Pedido de Fornecedor");
        cbConsultaClientes = new JCheckBox("Consulta Clientes");
        cbConsultaFornecedor = new JCheckBox("Consulta Fornecedor");
        cbConsultaProduto = new JCheckBox("Consulta Produto");
        cbConsultaCategoria = new JCheckBox("Consulta Categoria");
        cbConsultaEnderecoEntregaCliente = new JCheckBox("Consulta endereço de entrega aos Clientes");
        cbConsultaEnderecoEntregaFornecedor = new JCheckBox("Consulta endereço de entrega de Fornecedor");
        cbRelatorioClientes = new JCheckBox("Relatório de Clientes");
        cbRelatorioFornecedor = new JCheckBox("Relatório de Fornecedores");
        cbRelatorioProduto = new JCheckBox("Relatório de Produtos");
        cbRelatorioCategoria = new JCheckBox("Relatório de Categorias");
        cbRelatorioUnidades = new JCheckBox("Relatório de Unidades");
        
        btGravar = new JButton(null, new ImageIcon("c:/icones/icon12/gravar.gif"));
        btGravar.setToolTipText("Gravar");
        btAlterar = new JButton(null, new ImageIcon("c:/icones/icon12/alterar.gif"));
        btAlterar.setToolTipText("Alterar");
        btExcluir = new JButton(null, new ImageIcon("c:/icones/icon12/excluir.gif"));
        btExcluir.setToolTipText("Excluir");
        btLocalizar = new JButton(null, new ImageIcon("c:/icones/icon12/localizar.png"));
        btLocalizar.setToolTipText("Localizar");
        btNovo = new JButton(null, new ImageIcon("c:/icones/icon12/novo.gif"));
        btNovo.setToolTipText("Novo");
        btCancelar = new JButton(null, new ImageIcon("c:/icones/icon12/cancelar.gif"));
        btCancelar.setToolTipText("Cancelar");
        btSair = new JButton(null, new ImageIcon("c:/icones/icon12/sair.png"));
        btSair.setToolTipText("Sair");
        
        lbCadastroUsuarios.setBounds(35, 50, 150, 25);
        lbId.setBounds(35, 125, 100, 25);
        tfId.setBounds(130, 125, 150, 25);
        lbNome.setBounds(480, 125, 170, 25);
        tfNome.setBounds(620, 125, 270, 25);
        lbSenha.setBounds(35, 175, 100, 25);
        pfSenha.setBounds(120, 175, 300, 25);
        
        // (35coluna,75linha, 645coluna, 650linha) quadrado de colocação de campos
        
        cbCadastroClientes.setBounds(35, 225, 200, 25);
        cbCadastroFornecedores.setBounds(335, 225, 200, 25);
        cbCadastroProdutos.setBounds(635, 225, 200, 25);
        
        cbCadastroCategoria.setBounds(35, 275, 200, 25);
        cbCadastroEnderecoEntregaCliente.setBounds(335, 275, 280, 25);
        cbCadastroEnderecoEntregaFornecedor.setBounds(635, 275, 270, 25);
        
        cbCadastroFornecedoresProduto.setBounds(35, 325, 280, 25);
        cbCadastroUnidades.setBounds(335, 325, 200, 25);
        cbPedidoCliente.setBounds(635, 325, 200, 25);
        
        cbPedidoFornecedor.setBounds(35, 375, 200, 25);
        cbConsultaClientes.setBounds(335, 375, 200, 25);
        cbConsultaFornecedor.setBounds(635, 375, 200, 25);
        
        cbConsultaProduto.setBounds(35, 425, 200, 25);
        cbConsultaCategoria.setBounds(335, 425, 200, 25);
        cbConsultaEnderecoEntregaCliente.setBounds(635, 425, 280, 25);
        
        cbConsultaEnderecoEntregaFornecedor.setBounds(35, 475, 280, 25);
        cbRelatorioClientes.setBounds(335, 475, 200, 25);
        cbRelatorioFornecedor.setBounds(635, 475, 200, 25);
        
        cbRelatorioProduto.setBounds(35, 525, 200, 25);
        cbRelatorioCategoria.setBounds(335, 525, 200, 25);
        cbRelatorioUnidades.setBounds(635, 525, 200, 25);
        
        btNovo.setBounds     (45, 600, 75, 75);
        btLocalizar.setBounds(145, 600, 75, 75);
        btGravar.setBounds   (245, 600, 75, 75);
        btAlterar.setBounds  (345, 600, 75, 75);
        btExcluir.setBounds  (445, 600, 75, 75);
        btCancelar.setBounds (545, 600, 75, 75);
        btSair.setBounds     (645, 600, 75, 75);
               
        add(lbCadastroUsuarios);
        add(lbId);
        add(tfId);
        add(lbNome);
        add(tfNome);
        add(lbSenha);
        add(pfSenha);
        
        add(cbCadastroClientes);
        add(cbCadastroFornecedores);
        add(cbCadastroProdutos);
        add(cbCadastroCategoria);
        add(cbCadastroEnderecoEntregaCliente);
        add(cbCadastroEnderecoEntregaFornecedor);
        add(cbCadastroFornecedoresProduto);
        add(cbCadastroUnidades);
        add(cbPedidoCliente);
        add(cbPedidoFornecedor);
        add(cbConsultaClientes);
        add(cbConsultaFornecedor);
        add(cbConsultaProduto);
        add(cbConsultaCategoria);
        add(cbConsultaEnderecoEntregaCliente);
        add(cbConsultaEnderecoEntregaFornecedor);
        add(cbRelatorioClientes);
        add(cbRelatorioFornecedor);
        add(cbRelatorioProduto);
        add(cbRelatorioCategoria);
        add(cbRelatorioUnidades);
        
        add(btNovo);
        add(btLocalizar);
        add(btGravar);
        add(btAlterar);
        add(btExcluir);
        add(btCancelar);
        add(btSair);
        
        ativaDesativaTF(false);
        setBotoes(true, true, false, false, false, false);
        usuarios = new UsuariosDAO();
    }
    
    public void definirEventos() {
        
        tfNome.addFocusListener(new FocusAdapter() {
            public void focusLost(FocusEvent e) {
                if(inclusao == true) {
                    usuarios.usuario.setNome(tfNome.getText());
                    if(usuarios.localizar()) {
                        JOptionPane.showMessageDialog(null, "Usuário já cadastrado!");
                        tfNome.requestFocus();
                    }
                }
                return;
            }
        });
        
        btSair.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                GuiMenuPrincipal.liberaMenu();
                BD.getInstance().close();
                setVisible(false);
            }
        });
        
        btNovo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ativaDesativaTF(true);
                inclusao = true;
                limparCampos();
                setBotoes(false, false, true, false, false, true);
                tfNome.requestFocus();
            }
        });
        
        btCancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ativaDesativaTF(false);
                inclusao = false;
                limparCampos();
                tfNome.requestFocus();
            }
        });
        
                
        btGravar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
                if(tfNome.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "O nome não podem ser vazio!");
                    tfNome.requestFocus();
                    return;
                }
                
                if(pfSenha.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "A senha não pode ser vazia!");
                    pfSenha.requestFocus();
                    return;
                }
                
                usuarios.usuario.setNome(tfNome.getText());
                usuarios.usuario.setSenha(pfSenha.getText());
                usuarios.usuario.setCadastroClientes(cbCadastroClientes.isSelected());
                usuarios.usuario.setCadastroFornecedores(cbCadastroFornecedores.isSelected());
                usuarios.usuario.setCadastroProdutos(cbCadastroProdutos.isSelected());
                usuarios.usuario.setCadastroCategoria(cbCadastroCategoria.isSelected());
                usuarios.usuario.setCadastroEnderecoEntregaCliente(cbCadastroEnderecoEntregaCliente.isSelected());
                usuarios.usuario.setCadastroEnderecoEntregaFornecedor(cbCadastroEnderecoEntregaFornecedor.isSelected());
                usuarios.usuario.setCadastroFornecedoresProduto(cbCadastroFornecedoresProduto.isSelected());
                usuarios.usuario.setCadastroUnidades(cbCadastroUnidades.isSelected());
                usuarios.usuario.setPedidoCliente(cbPedidoCliente.isSelected());
                usuarios.usuario.setPedidoFornecedor(cbPedidoFornecedor.isSelected());
                usuarios.usuario.setConsultaClientes(cbConsultaClientes.isSelected());
                usuarios.usuario.setConsultaFornecedor(cbConsultaFornecedor.isSelected());
                usuarios.usuario.setConsultaProduto(cbConsultaProduto.isSelected());
                usuarios.usuario.setConsultaCategoria(cbConsultaCategoria.isSelected());
                usuarios.usuario.setConsultaEnderecoEntregaCliente(cbConsultaEnderecoEntregaCliente.isSelected());
                usuarios.usuario.setConsultaEnderecoEntregaFornecedor(cbConsultaEnderecoEntregaFornecedor.isSelected());
                usuarios.usuario.setRelatorioClientes(cbRelatorioClientes.isSelected());
                usuarios.usuario.setRelatorioFornecedor(cbRelatorioFornecedor.isSelected());
                usuarios.usuario.setRelatorioProduto(cbRelatorioProduto.isSelected());
                usuarios.usuario.setRelatorioCategoria(cbRelatorioCategoria.isSelected());
                usuarios.usuario.setRelatorioUnidades(cbRelatorioUnidades.isSelected());
                
                JOptionPane.showMessageDialog(null, usuarios.atualizar(UsuariosDAO.INCLUSAO));
                limparCampos();
                ativaDesativaTF(false);
                inclusao = false;
            }
        });
        
        btAlterar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                usuarios.usuario.setId(Integer.valueOf(tfId.getText()));
                usuarios.usuario.setNome(tfNome.getText());
                usuarios.usuario.setCadastroClientes(cbCadastroClientes.isSelected());
                usuarios.usuario.setCadastroFornecedores(cbCadastroFornecedores.isSelected());
                usuarios.usuario.setCadastroProdutos(cbCadastroProdutos.isSelected());
                usuarios.usuario.setCadastroCategoria(cbCadastroCategoria.isSelected());
                usuarios.usuario.setCadastroEnderecoEntregaCliente(cbCadastroEnderecoEntregaCliente.isSelected());
                usuarios.usuario.setCadastroEnderecoEntregaFornecedor(cbCadastroEnderecoEntregaFornecedor.isSelected());
                usuarios.usuario.setCadastroFornecedoresProduto(cbCadastroFornecedoresProduto.isSelected());
                usuarios.usuario.setCadastroUnidades(cbCadastroUnidades.isSelected());
                usuarios.usuario.setPedidoCliente(cbPedidoCliente.isSelected());
                usuarios.usuario.setPedidoFornecedor(cbPedidoFornecedor.isSelected());
                usuarios.usuario.setConsultaClientes(cbConsultaClientes.isSelected());
                usuarios.usuario.setConsultaFornecedor(cbConsultaFornecedor.isSelected());
                usuarios.usuario.setConsultaProduto(cbConsultaProduto.isSelected());
                usuarios.usuario.setConsultaCategoria(cbConsultaCategoria.isSelected());
                usuarios.usuario.setConsultaEnderecoEntregaCliente(cbConsultaEnderecoEntregaCliente.isSelected());
                usuarios.usuario.setConsultaEnderecoEntregaFornecedor(cbConsultaEnderecoEntregaFornecedor.isSelected());
                usuarios.usuario.setRelatorioClientes(cbRelatorioClientes.isSelected());
                usuarios.usuario.setRelatorioFornecedor(cbRelatorioFornecedor.isSelected());
                usuarios.usuario.setRelatorioProduto(cbRelatorioProduto.isSelected());
                usuarios.usuario.setRelatorioCategoria(cbRelatorioCategoria.isSelected());
                usuarios.usuario.setRelatorioUnidades(cbRelatorioUnidades.isSelected());
                
                JOptionPane.showMessageDialog(null, usuarios.atualizar(UsuariosDAO.ALTERACAO));
                limparCampos();
                ativaDesativaTF(false);
            }
        });
        
        btExcluir.addActionListener(new ActionListener(){ 
            public void actionPerformed(ActionEvent e) {
                usuarios.usuario.setId(Integer.valueOf(tfId.getText()));
                usuarios.localizar();
                int n = JOptionPane.showConfirmDialog(null, usuarios.usuario.getNome(),
                        " Excluir o cliente? ", JOptionPane.YES_NO_OPTION);
                if(n == JOptionPane.YES_OPTION) {
                    JOptionPane.showMessageDialog(null, usuarios.atualizar(UsuariosDAO.EXCLUSAO));
                    limparCampos();
                    ativaDesativaTF(false);
                }
            }
        });
        
        btLocalizar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                atualizarCampos();
            }
        });
        
    }
    
    public void limparCampos() {
        
        tfId.setText("");
        tfNome.setText("");
        pfSenha.setText("");
        
        cbCadastroClientes.setSelected(false);
        cbCadastroFornecedores.setSelected(false);
        cbCadastroProdutos.setSelected(false);
        cbCadastroCategoria.setSelected(false);
        cbCadastroEnderecoEntregaCliente.setSelected(false);
        cbCadastroEnderecoEntregaFornecedor.setSelected(false);
        cbCadastroFornecedoresProduto.setSelected(false);
        cbCadastroUnidades.setSelected(false);
        cbPedidoCliente.setSelected(false);
        cbPedidoFornecedor.setSelected(false);
        cbConsultaClientes.setSelected(false);
        cbConsultaFornecedor.setSelected(false);
        cbConsultaProduto.setSelected(false);
        cbConsultaCategoria.setSelected(false);
        cbConsultaEnderecoEntregaCliente.setSelected(false);
        cbConsultaEnderecoEntregaFornecedor.setSelected(false);
        cbRelatorioClientes.setSelected(false);
        cbRelatorioFornecedor.setSelected(false);
        cbRelatorioProduto.setSelected(false);
        cbRelatorioCategoria.setSelected(false);
        cbRelatorioUnidades.setSelected(false);
        setBotoes(true, true, false, false, false, false);
    }
    
    public void atualizarCampos() {
        usuarios.usuario.setNome(tfNome.getText());
        if(usuarios.localizar()) {
            ativaDesativaTF(true);
            tfId.setText(String.valueOf(usuarios.usuario.getId()));
            tfNome.setText(usuarios.usuario.getNome());
            pfSenha.setText(usuarios.usuario.getSenha());
            cbCadastroClientes.setSelected(usuarios.usuario.isCadastroClientes());
            cbCadastroFornecedores.setSelected(usuarios.usuario.isCadastroFornecedores());
            cbCadastroProdutos.setSelected(usuarios.usuario.isCadastroProdutos());
            cbCadastroCategoria.setSelected(usuarios.usuario.isCadastroCategoria());
            cbCadastroEnderecoEntregaCliente.setSelected(usuarios.usuario.isCadastroEnderecoEntregaCliente());
            cbCadastroEnderecoEntregaFornecedor.setSelected(usuarios.usuario.isCadastroEnderecoEntregaFornecedor());
            cbCadastroFornecedoresProduto.setSelected(usuarios.usuario.isCadastroFornecedoresProduto());
            cbCadastroUnidades.setSelected(usuarios.usuario.isCadastroUnidades());
            cbPedidoCliente.setSelected(usuarios.usuario.isPedidoCliente());
            cbPedidoFornecedor.setSelected(usuarios.usuario.isPedidoFornecedor());
            cbConsultaClientes.setSelected(usuarios.usuario.isConsultaClientes());
            cbConsultaFornecedor.setSelected(usuarios.usuario.isConsultaFornecedor());
            cbConsultaProduto.setSelected(usuarios.usuario.isConsultaProduto());
            cbConsultaCategoria.setSelected(usuarios.usuario.isConsultaCategoria());
            cbConsultaEnderecoEntregaCliente.setSelected(usuarios.usuario.isConsultaEnderecoEntregaCliente());
            cbConsultaEnderecoEntregaFornecedor.setSelected(usuarios.usuario.isConsultaEnderecoEntregaFornecedor());
            cbRelatorioClientes.setSelected(usuarios.usuario.isRelatorioClientes());
            cbRelatorioFornecedor.setSelected(usuarios.usuario.isRelatorioFornecedor());
            cbRelatorioProduto.setSelected(usuarios.usuario.isRelatorioProduto());
            cbRelatorioCategoria.setSelected(usuarios.usuario.isRelatorioCategoria());
            cbRelatorioUnidades.setSelected(usuarios.usuario.isRelatorioUnidades());
            setBotoes(true, true, false, true, true, true);
        } else {
            JOptionPane.showMessageDialog(null, "Usuario não encontrado! " + usuarios.usuario.getNome());
            limparCampos();
            ativaDesativaTF(false);
        }
    }
    
    public void setBotoes(boolean bNovo, boolean bLocalizar, boolean bGravar,
            boolean bAlterar, boolean bExcluir, boolean bCancelar) {
        btNovo.setEnabled(bNovo);
        btLocalizar.setEnabled(bLocalizar);
        btGravar.setEnabled(bGravar);
        btAlterar.setEnabled(bAlterar);
        btExcluir.setEnabled(bExcluir);
        btCancelar.setEnabled(bCancelar);
    }
    
    private void ativaDesativaTF(boolean ativa) {
        pfSenha.setEnabled(ativa);
        cbCadastroClientes.setEnabled(ativa);
        cbCadastroFornecedores.setEnabled(ativa);
        cbCadastroProdutos.setEnabled(ativa);
        cbCadastroCategoria.setEnabled(ativa);
        cbCadastroEnderecoEntregaCliente.setEnabled(ativa);
        cbCadastroEnderecoEntregaFornecedor.setEnabled(ativa);
        cbCadastroFornecedoresProduto.setEnabled(ativa);
        cbCadastroUnidades.setEnabled(ativa);
        cbPedidoCliente.setEnabled(ativa);
        cbPedidoFornecedor.setEnabled(ativa);
        cbConsultaClientes.setEnabled(ativa);
        cbConsultaFornecedor.setEnabled(ativa);
        cbConsultaProduto.setEnabled(ativa);
        cbConsultaCategoria.setEnabled(ativa);
        cbConsultaEnderecoEntregaCliente.setEnabled(ativa);
        cbConsultaEnderecoEntregaFornecedor.setEnabled(ativa);
        cbRelatorioClientes.setEnabled(ativa);
        cbRelatorioFornecedor.setEnabled(ativa);
        cbRelatorioProduto.setEnabled(ativa);
        cbRelatorioCategoria.setEnabled(ativa);
        cbRelatorioUnidades.setEnabled(ativa);
    }    
    
}
/*
id int AI PK 
Nome varchar(50) 
senha varchar(50) 
cadastroClientes tinyint(1) 
cadastroFornecedores tinyint(1) 
cadastroProdutos tinyint(1) 
cadastroCategoria tinyint(1) 
cadastroEnderecoEntregaCliente tinyint(1) 
cadastroEnderecoEntregaFornecedor tinyint(1) 
cadastroFornecedoresProduto tinyint(1) 
cadastroUnidades tinyint(1) 
pedidoCliente tinyint(1) 
pedidoFornecedor tinyint(1) 
consultaClientes tinyint(1) 
consultaFornecedor tinyint(1) 
consultaProduto tinyint(1) 
consultaCategoria tinyint(1) 
consultaEnderecoEntregaCliente tinyint(1) 
consultaEnderecoEntregaFornecedor tinyint(1) 
relatorioClientes tinyint(1) 
relatorioFornecedor tinyint(1) 
relatorioProduto tinyint(1) 
relatorioCategoria tinyint(1) 
relatorioUnidades tinyint(1)
*/