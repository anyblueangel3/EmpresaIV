package empresaiv;

import view.GuiCadastroCategorias;
import view.GuiCadastroClientes;
import view.GuiCadastroEndEntCli;
import view.GuiCadastroFornecedores;
import view.GuiCadastroProdutos;
import view.GuiCadastroUnidades;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import model.Usuarios;
import view.GuiCadastroEndEntFor;
import view.GuiCadastroUsuarios;
import view.GuiPedidoCliente;
import view.GuiPedidoFornecedor;

/**
 *
 * @author Ronaldo R. Godoi
 */
public class GuiMenuPrincipal extends JFrame {
    private Container contentPane;
    private JMenuBar mnBarra;
    private static JMenu mnArquivos, mnPedidos, mnConsultas, mnRelatorios;
    private JMenuItem miSair, miClientes, miFornecedores, miProdutos,
            miCategorias, miEndEntregaCliente, miEndEntregaFornecedor,
            miForProduto, miUnidades, miUsuarios;
    private JMenuItem miPedidoCliente, miPedidoFornecedor;
    private JMenuItem miRelatorioClientes, miRelatorioFornecedores,
            miRelatorioProdutos, miRelatorioCategorias, miRelatorioUnidades;
    private JMenuItem miConsultaClientes, miConsultaFornecedor, miConsultaProdutos,
            miConsultaCategorias, miConsultaEndEntregaCli, miConsultaEndEntregaFor;
    Usuarios ausuario = new Usuarios();
        
    public GuiMenuPrincipal(Usuarios ausuario) {
        this.ausuario = ausuario;
        inicializarComponentes();
        definirEventos();
    }
    
    public void inicializarComponentes () {
        setTitle("Aplicativo Empresa");
        setBounds(0, 0, 1000, 800);
        contentPane = getContentPane();
        mnBarra = new JMenuBar();
        mnArquivos = new JMenu("Arquivos");
        mnArquivos.setMnemonic('A');
        mnPedidos = new JMenu("Pedidos");
        mnPedidos.setMnemonic('P');
        mnConsultas = new JMenu("Consultas");
        mnConsultas.setMnemonic('C');
        mnRelatorios = new JMenu("Relatórios");
        mnRelatorios.setMnemonic('R');
        
        // Arquivos ou Cadastros
        miClientes = new JMenuItem("Cadastro de Clientes");
        miFornecedores = new JMenuItem("Cadastro de Fornecedores");
        miProdutos = new JMenuItem("Cadastro de Produtos");
        miCategorias = new JMenuItem("Cadastro de Categoria de Produto");
        miEndEntregaCliente = new JMenuItem("Cadastro de Endereço de Entrega de Cliente");
        miEndEntregaFornecedor = new JMenuItem("Cadastro de onde o Fornecedor deve entregar");
        miForProduto = new JMenuItem("Cadastro de vários Fornecedores de um Produto");
        miUnidades = new JMenuItem("Cadastro de Unidades de Venda e Compra");
        miUsuarios = new JMenuItem("Cadastro de Usuários");
        miSair = new JMenuItem("Sair", new ImageIcon("c:/icones/sair2.jpg"));
        miSair.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.ALT_MASK));
        
        // Pedidos
        miPedidoCliente = new JMenuItem("Pedidos de Clientes");
        miPedidoFornecedor = new JMenuItem("Pedidos para Fornecedor");
        
        // Consultas
        miConsultaClientes = new JMenuItem("Consulta Clientes");
        miConsultaFornecedor = new JMenuItem("Consulta Fornecedor");
        miConsultaProdutos = new JMenuItem("Consulta Produtos");
        miConsultaCategorias = new JMenuItem("Consulta Categorias");
        miConsultaEndEntregaCli = new JMenuItem("Consulta Endereço de Entrega de Cliente");
        miConsultaEndEntregaFor = new JMenuItem("Consulta Endereço em que o Fornecedor vai entregar");
        
        // Relatórios
        miRelatorioClientes = new JMenuItem("Relatório de Clientes");
        miRelatorioFornecedores = new JMenuItem("Relatório de Fornecedores");
        miRelatorioProdutos = new JMenuItem("Relatório de Produtos");
        miRelatorioCategorias = new JMenuItem("Relatório de Categorias");
        miRelatorioUnidades = new JMenuItem("Relatório de Unidades");
                
        //Menu Cadastros
        mnArquivos.add(miClientes);
        mnArquivos.add(miFornecedores);
        mnArquivos.add(miProdutos);
        mnArquivos.add(miCategorias);
        mnArquivos.add(miEndEntregaCliente);
        mnArquivos.add(miEndEntregaFornecedor);
        //mnArquivos.add(miForProduto);
        mnArquivos.add(miUnidades);
        mnArquivos.add(miUsuarios);
        mnArquivos.add(miSair);
        
        //Menu Pedidos
        mnPedidos.add(miPedidoCliente);
        mnPedidos.add(miPedidoFornecedor);
        
        //Menu Consultas
        mnConsultas.add(miConsultaClientes);
        mnConsultas.add(miConsultaFornecedor);
        mnConsultas.add(miConsultaProdutos);
        mnConsultas.add(miConsultaCategorias);
        mnConsultas.add(miConsultaEndEntregaCli);
        mnConsultas.add(miConsultaEndEntregaFor);
        
        //Menu Relatórios
        mnRelatorios.add(miRelatorioClientes);
        mnRelatorios.add(miRelatorioFornecedores);
        mnRelatorios.add(miRelatorioProdutos);
        mnRelatorios.add(miRelatorioCategorias);
        mnRelatorios.add(miRelatorioUnidades);
        
        mnBarra.add(mnArquivos);
        mnBarra.add(mnPedidos);
        mnBarra.add(mnConsultas);
        mnBarra.add(mnRelatorios);
        setJMenuBar(mnBarra);
        liberaMenu();
        travaUsuario(ausuario);
    }
    
    private void definirEventos() {
        
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent event) {
                if(mnArquivos.isEnabled()) {
                    System.out.println("Saindo do Aplicativo...");
                    //BD.getInstance().close();
                    System.exit(0);
                } else {
                    JOptionPane.showMessageDialog(null, "Clique no ícone/botão SAIR"
                            + " para voltar ao Menu principal. \nEntão"
                            + " clique no X para sair ou no menu Arquivo opção Sair");
                }                    
            }
        });
        
        miSair.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //BD.getInstance().close();
                System.exit(0);
            }
        });

        miClientes.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                bloqueiaMenu();
                GuiCadastroClientes label = new GuiCadastroClientes();
                contentPane.removeAll();
                contentPane.add(label);
                contentPane.validate();
            }
        });
        
        miFornecedores.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                bloqueiaMenu();
                GuiCadastroFornecedores label = new GuiCadastroFornecedores();
                contentPane.removeAll();
                contentPane.add(label);
                contentPane.validate();
            }
        });

        miProdutos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                bloqueiaMenu();
                GuiCadastroProdutos label = new GuiCadastroProdutos();
                contentPane.removeAll();
                contentPane.add(label);
                contentPane.validate();
            }
        });
        
        miCategorias.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                bloqueiaMenu();
                GuiCadastroCategorias label = new GuiCadastroCategorias();
                contentPane.removeAll();
                contentPane.add(label);
                contentPane.validate();
            }
        });
        
        miEndEntregaCliente.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                bloqueiaMenu();
                GuiCadastroEndEntCli label = new GuiCadastroEndEntCli();
                contentPane.removeAll();
                contentPane.add(label);
                contentPane.validate();
            }
        });
        
        miEndEntregaFornecedor.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
               bloqueiaMenu();
               GuiCadastroEndEntFor label = new GuiCadastroEndEntFor();
               contentPane.removeAll();
               contentPane.add(label);
               contentPane.validate();
           } 
        });
        
        miUnidades.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                bloqueiaMenu();
                GuiCadastroUnidades label = new GuiCadastroUnidades();
                contentPane.removeAll();
                contentPane.add(label);
                contentPane.validate();
            }
        });
        
        miUsuarios.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                bloqueiaMenu();
                GuiCadastroUsuarios label = new GuiCadastroUsuarios();
                contentPane.removeAll();
                contentPane.add(label);
                contentPane.validate();
            }
        });
        
        miPedidoCliente.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent e) {
               bloqueiaMenu();
               GuiPedidoCliente label = new GuiPedidoCliente();
               contentPane.removeAll();
               contentPane.add(label);
               contentPane.validate();
           }
        });
        
        miPedidoFornecedor.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent e) {
               bloqueiaMenu();
               GuiPedidoFornecedor label = new GuiPedidoFornecedor();
               contentPane.removeAll();
               contentPane.add(label);
               contentPane.validate();
           }
        });
        
        
        
    }
    
    private void bloqueiaMenu() {
        mnArquivos.setEnabled(false);
        mnPedidos.setEnabled(false);
        mnConsultas.setEnabled(false);
        mnRelatorios.setEnabled(false);
    }
    
    public static void liberaMenu() {
        mnArquivos.setEnabled(true);
        mnPedidos.setEnabled(true);
        mnConsultas.setEnabled(true);
        mnRelatorios.setEnabled(true);
    }
        
    public static void abrir(Usuarios ausuario) {
        GuiMenuPrincipal frame = new GuiMenuPrincipal(ausuario);
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        Dimension tela = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation((tela.width - frame.getSize().width) / 2,
                (tela.height - frame.getSize().height) / 2);
        frame.setVisible(true);
    }
    
    private void travaUsuario(Usuarios ausuario) {
        miClientes.setEnabled(ausuario.isCadastroClientes());
        miFornecedores.setEnabled(ausuario.isCadastroFornecedores());
        miProdutos.setEnabled(ausuario.isCadastroProdutos());
        miCategorias.setEnabled(ausuario.isCadastroCategoria());
        miEndEntregaCliente.setEnabled(ausuario.isCadastroEnderecoEntregaCliente());
        miEndEntregaFornecedor.setEnabled(ausuario.isCadastroEnderecoEntregaFornecedor());
        miForProduto.setEnabled(ausuario.isCadastroFornecedoresProduto());
        System.out.println("Assossiação de fornecedor e produto: " + ausuario.isCadastroFornecedoresProduto());
        miUnidades.setEnabled(ausuario.isCadastroUnidades());
        if (ausuario.getNome().equals("java")) { 
            miUsuarios.setEnabled(true); 
        } else { 
            miUsuarios.setEnabled(false);
        }
        miPedidoCliente.setEnabled(ausuario.isPedidoCliente());
        miPedidoFornecedor.setEnabled(ausuario.isPedidoFornecedor());
        miConsultaClientes.setEnabled(ausuario.isConsultaClientes());
        miConsultaFornecedor.setEnabled(ausuario.isConsultaFornecedor());
        miConsultaProdutos.setEnabled(ausuario.isConsultaProduto());
        miConsultaCategorias.setEnabled(ausuario.isConsultaCategoria());
        miConsultaEndEntregaCli.setEnabled(ausuario.isConsultaEnderecoEntregaCliente());
        miConsultaEndEntregaFor.setEnabled(ausuario.isConsultaEnderecoEntregaFornecedor());
        miRelatorioClientes.setEnabled(ausuario.isRelatorioClientes());
        miRelatorioFornecedores.setEnabled(ausuario.isRelatorioFornecedor());
        miRelatorioProdutos.setEnabled(ausuario.isRelatorioProduto());
        miRelatorioCategorias.setEnabled(ausuario.isRelatorioCategoria());
        miRelatorioUnidades.setEnabled(ausuario.isRelatorioUnidades());
    }
    
}