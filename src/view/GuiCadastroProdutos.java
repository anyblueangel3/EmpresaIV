package view;

import controller.ControllerCadForProduto;
import dao.CatDAO;
import dao.ProDAO;
import dao.UnidadesDAO;
import empresaiv.BD;
import empresaiv.GuiMenuPrincipal;
import empresaiv.Util;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 *
 * @author Ronaldo Rodrigues Godoi
 */
public class GuiCadastroProdutos extends JPanel{
    
    JLabel lbCad_pro; //, lbLargura, lbAltura;
    
    boolean inclusao = false;
    
    JLabel lbId, lbDescricao, lbCategoria, lbQuantidade, lbUnidade,
           lbPreco_venda, lbPreco_ultima_compra, lbData_cadastro;
    
    JLabel lbDescricao_categoria, lbDescricao_unidade;
    
    JButton btGravar, btAlterar, btExcluir, btNovo, btLocalizar, btCancelar, btSair;
    
    JButton btCadForProduto;
    
    JTextField tfId, tfDescricao, tfCategoria, tfQuantidade, tfUnidade,
           tfPreco_venda, tfPreco_ultima_compra, tfData_cadastro;
    
     Date nova_data = new Date();
     DateFormat formatoData = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    
    private ProDAO produtos;
    private CatDAO categorias;
    private UnidadesDAO unidades;
    private Util util = new Util();
        
    public GuiCadastroProdutos() {
        
        inicializarComponentes();
        definirEventos();
        
    }
    
    public void inicializarComponentes() {

        setLayout(null);
        
        //Dimension tela = Toolkit.getDefaultToolkit().getScreenSize();
        //lbLargura = new JLabel(""+tela.width);
        //lbAltura = new JLabel(""+tela.height);
        //int altura = 1000;
        //int largura = 1800;
                
        lbCad_pro = new JLabel("Cadastro de Produtos");
        
        lbId = new JLabel("Código do Produto: ");
        lbDescricao = new JLabel("Descrição: ");
        lbCategoria = new JLabel("Categoria: ");
        lbDescricao_categoria = new JLabel("Descrição da Categoria: ");
        lbQuantidade = new JLabel("Quantidade em Estoque: ");
        lbUnidade = new JLabel("Unidade: ");
        lbDescricao_unidade = new JLabel("Unidade: ");
        lbPreco_venda = new JLabel("Preço de Venda: ");
        lbPreco_ultima_compra = new JLabel("Preço da última compra: ");
        lbData_cadastro = new JLabel("Data de Cadastro: ");
                
        tfId = new JTextField(10);
        tfDescricao = new JTextField(60);
        tfCategoria = new JTextField(10);
        tfQuantidade = new JTextField(10);
        tfUnidade = new JTextField(10); 
        tfPreco_venda = new JTextField(10);
        tfPreco_ultima_compra = new JTextField(10);
        tfData_cadastro = new JTextField(16);
        
        //tfData_cadastro.setText(formatoData.format(nova_data.getTime()));
        
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
        
        btCadForProduto = new JButton(" Fornecedor deste produto ");
        
        lbCad_pro.setBounds(35, 75, 150, 25);
        
        lbId.setBounds(35, 175, 150, 25);
        tfId.setBounds(200, 175, 150, 25);
        lbDescricao.setBounds(500, 175, 170, 25);
        tfDescricao.setBounds(600, 175, 270, 25);
        lbCategoria.setBounds(35, 250, 100, 25);
        tfCategoria.setBounds(120, 250, 80, 25);
        lbDescricao_categoria.setBounds(35, 275, 300, 25);
        lbQuantidade.setBounds(480, 250, 200, 25);
        tfQuantidade.setBounds(700, 250, 100, 25);
        lbUnidade.setBounds(35, 325, 100, 25);
        tfUnidade.setBounds(105, 325, 100, 25);
        lbDescricao_unidade.setBounds(35, 350, 400, 25);
        lbPreco_venda.setBounds(400, 325, 150, 25);
        tfPreco_venda.setBounds(520, 325, 150, 25);
        lbPreco_ultima_compra.setBounds(35, 400, 250, 25);
        tfPreco_ultima_compra.setBounds(245, 400, 150, 25);
        lbData_cadastro.setBounds(435, 400, 150, 25);
        tfData_cadastro.setBounds(600, 400, 225, 25);
        
        btNovo.setBounds     (45, 550, 75, 75);
        btLocalizar.setBounds(145, 550, 75, 75);
        btGravar.setBounds   (245, 550, 75, 75);
        btAlterar.setBounds  (345, 550, 75, 75);
        btExcluir.setBounds  (445, 550, 75, 75);
        btCancelar.setBounds (545, 550, 75, 75);
        btSair.setBounds     (645, 550, 75, 75);
        //lbLargura.setBounds  (745, 550, 75, 75);
        //lbAltura.setBounds   (845, 550, 75, 75);
        
        btCadForProduto.setBounds(35, 475, 270, 50);
        
        add(lbCad_pro);
        
        add(lbId);
        add(tfId);
        add(lbDescricao);
        add(tfDescricao);
        add(lbCategoria);
        add(tfCategoria);
        add(lbDescricao_categoria);
        add(lbQuantidade);
        add(tfQuantidade);
        add(lbUnidade);
        add(tfUnidade); 
        add(lbDescricao_unidade);
        add(lbPreco_venda);
        add(tfPreco_venda);
        add(lbPreco_ultima_compra);
        add(tfPreco_ultima_compra);
        add(lbData_cadastro);
        add(tfData_cadastro);
        
        //add(lbLargura);
        //add(lbAltura);
        
        add(btNovo);
        add(btLocalizar);
        add(btGravar);
        add(btAlterar);
        add(btExcluir);
        add(btCancelar);
        add(btSair);
        
        add(btCadForProduto);
        
        ativaBotaoCampoTF(false);
        setBotoes(true, true, false, false, false, false);
        produtos = new ProDAO();
        categorias = new CatDAO();
        unidades = new UnidadesDAO();
         
    }
    
    public void definirEventos() {
        
        btCadForProduto.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                GuiCadForProduto jFrame2 = new GuiCadForProduto(produtos.produto);
                jFrame2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                jFrame2.setVisible(true);
            }
        });
        
        tfId.addFocusListener(new FocusAdapter() {
            public void focusLost(FocusEvent e) {
                if(inclusao == true) {
                    produtos.produto.setId(tfId.getText());
                    if(produtos.localizar()) {
                        JOptionPane.showMessageDialog(null, "Produto já cadastrado!");
                        tfId.requestFocus();
                    }
                }
                return;
            }
        });
            
        tfCategoria.addFocusListener(new FocusAdapter() {
            public void focusLost(FocusEvent e) {
                categorias.categoria.setId(tfCategoria.getText());
                if(!categorias.localizar()) {
                    JOptionPane.showMessageDialog(null, "Categoria não cadastrada!");
                    tfCategoria.requestFocus();
                } else {
                    lbDescricao_categoria.setText("Descrição da Categoria: " + 
                            categorias.categoria.getDescricao());
                    tfUnidade.requestFocus();
                }
                return;
            }
        });
        
        tfUnidade.addFocusListener(new FocusAdapter() {
            public void focusLost(FocusEvent e) {
                unidades.unidade.setId(tfUnidade.getText());
                if(!unidades.localizar()) {
                    JOptionPane.showMessageDialog(null, "Unidade não cadastrada!");
                    tfUnidade.requestFocus();
                } else {
                    lbDescricao_unidade.setText("Unidade: " + 
                            unidades.unidade.getDescricao());
                    tfPreco_venda.requestFocus();
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
                ativaBotaoCampoTF(true);
                inclusao = true;
                limparCampos();
                setBotoes(false, false, true, false, false, true);
                tfId.requestFocus();
            }
        });
        
        btCancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ativaBotaoCampoTF(false);
                inclusao = false;
                limparCampos();
            }
        });
        
        btGravar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
                if(tfId.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Código do produto não pode ser vazio!");
                    tfId.requestFocus();
                    return;
                } 
                
                if(tfDescricao.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Descrição do Produto não pode ser vazia!");
                    tfDescricao.requestFocus();
                    return;
                }
                
                if(tfCategoria.equals("")) {
                    JOptionPane.showMessageDialog(null, "Categoria do produto não pode ser vazia!");
                    tfCategoria.requestFocus();
                    return;
                }
                
                if(tfUnidade.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "A unidade não pode estar vazia!");
                    tfUnidade.requestFocus();
                    return;
                }
                
                try {
                    Double numero = Double.parseDouble(tfPreco_venda.getText());
                } catch (Exception erro) {
                    JOptionPane.showMessageDialog(null, "O preço contém caracteres invalidos!");
                    tfQuantidade.requestFocus();
                    return;
                }
                
                
                if(tfData_cadastro.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "A data de cadastro não pode ser vazia");
                    tfData_cadastro.requestFocus();
                    return;
                }
                
                produtos.produto.setId(tfId.getText());
                produtos.produto.setDescricao(tfDescricao.getText());
                produtos.produto.setCategoria(tfCategoria.getText());
                produtos.produto.setQuantidade(util.spaceToDouble(tfQuantidade.getText()));
                produtos.produto.setUnidade(tfUnidade.getText());
                produtos.produto.setPreco_venda(Double.parseDouble(tfPreco_venda.getText()));
                produtos.produto.setPreco_ultima_compra(util.spaceToDouble(tfPreco_ultima_compra.getText()));
                produtos.produto.setData_cadastro(tfData_cadastro.getText());
                
                JOptionPane.showMessageDialog(null, produtos.atualizar(ProDAO.INCLUSAO));
                limparCampos();
                ativaBotaoCampoTF(false);
                inclusao = false;
            }
        });
        
        btAlterar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                produtos.produto.setId(tfId.getText());
                produtos.produto.setDescricao(tfDescricao.getText());
                produtos.produto.setCategoria(tfCategoria.getText());
                produtos.produto.setQuantidade(util.spaceToDouble(tfQuantidade.getText()));
                produtos.produto.setUnidade(tfUnidade.getText());
                produtos.produto.setPreco_venda(Double.parseDouble(tfPreco_venda.getText()));
                produtos.produto.setPreco_ultima_compra(util.spaceToDouble(tfPreco_ultima_compra.getText()));
                produtos.produto.setPreco_ultima_compra(0.00);
                produtos.produto.setData_cadastro(tfData_cadastro.getText());
                JOptionPane.showMessageDialog(null, produtos.atualizar(ProDAO.ALTERACAO));
                limparCampos();
                ativaBotaoCampoTF(false);
            }
        });
        
        btExcluir.addActionListener(new ActionListener(){ 
            public void actionPerformed(ActionEvent e) {
                produtos.produto.setId(tfId.getText());
                produtos.localizar();
                int n = JOptionPane.showConfirmDialog(null, produtos.produto.getDescricao(),
                        " Excluir o produto? ", JOptionPane.YES_NO_OPTION);
                if(n == JOptionPane.YES_OPTION) {
                    JOptionPane.showMessageDialog(null, produtos.atualizar(ProDAO.EXCLUSAO));
                    limparCampos();
                    ativaBotaoCampoTF(false);
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
        tfDescricao.setText("");
        tfCategoria.setText("");
        lbDescricao_categoria.setText("Descrição da Categoria: ");
        tfQuantidade.setText("");
        tfUnidade.setText("");
        lbDescricao_unidade.setText("Unidade: ");
        tfPreco_venda.setText("");
        tfPreco_ultima_compra.setText("");
        tfData_cadastro.setText(formatoData.format(nova_data.getTime()));
        setBotoes(true, true, false, false, false, false);
    }
    
    public void atualizarCampos() {
        produtos.produto.setId(tfId.getText());
        if(produtos.localizar()) {
            categorias.categoria.setId(produtos.produto.getCategoria());
            if(categorias.localizar()) {
                    lbDescricao_categoria.setText("Descrição da Categoria: " + 
                            categorias.categoria.getDescricao());
            } else {
                    lbDescricao_categoria.setText("Descrição da Categoria: Não cadastrada");
            }
            tfId.setText(produtos.produto.getId());
            tfDescricao.setText(produtos.produto.getDescricao());
            tfCategoria.setText(produtos.produto.getCategoria());
            tfQuantidade.setText(produtos.produto.getQuantidade().toString());
            tfUnidade.setText(produtos.produto.getUnidade());
            unidades.unidade.setId(tfUnidade.getText());
            if(unidades.localizar()) {
                    lbDescricao_unidade.setText("Unidade: " + 
                            unidades.unidade.getDescricao());
            } else {
                    lbDescricao_unidade.setText("Unidade: Não cadastrada");
            }
            tfPreco_venda.setText(produtos.produto.getPreco_venda().toString());
            tfPreco_ultima_compra.setText(produtos.produto.getPreco_ultima_compra().toString());
            tfData_cadastro.setText(produtos.produto.getData_cadastro());
            setBotoes(true, true, false, true, true, true);
            ativaBotaoCampoTF(true);
        } else {
            JOptionPane.showMessageDialog(null, "Produto não encontrado! " + produtos.produto.getId());
            limparCampos();
            ativaBotaoCampoTF(false);
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
    
    private void ativaBotaoCampoTF(boolean ativa) {
        btCadForProduto.setEnabled(ativa);
        // tfId.setEnabled(ativa);
        tfDescricao.setEnabled(ativa);
        tfCategoria.setEnabled(ativa);
        tfQuantidade.setEditable(false);
        tfUnidade.setEnabled(ativa);
        tfPreco_venda.setEnabled(ativa);
        tfPreco_ultima_compra.setEditable(false);
        tfData_cadastro.setEnabled(ativa);
    }    
    
}

/*
Table: produtos
Columns:
id varchar(10) PK 
descricao varchar(60) 
categoria varchar(10) 
quantidade double 
unidade varchar(10) 
preco_venda double 
preco_ultima_compra double 
data_cadastro datetime
*/
        