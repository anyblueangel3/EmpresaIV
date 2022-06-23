package view;

import dao.CatDAO;
import empresaiv.BD;
import empresaiv.GuiMenuPrincipal;
import java.awt.*;
import java.awt.event.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.*; 

/**
 *
 * @author Ronaldo Rodrigues Godoi
 */
public class GuiCadastroCategorias extends JPanel {

    JLabel lbCad_categorias; //, lbLargura, lbAltura;
    
    JLabel lbId, lbDescricao, lbData_cadastro;
    
    private boolean inclusao = false;
    
    JButton btGravar, btAlterar, btExcluir, btNovo, btLocalizar, btCancelar, btSair;
    
    JTextField tfId, tfDescricao, tfData_cadastro;
    
    Date nova_data = new Date();
    DateFormat formatoData = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    
    private CatDAO categorias;
        
    public GuiCadastroCategorias() {
        
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
                
        lbCad_categorias = new JLabel("Cadastro de Categorias");
        
        lbId = new JLabel("Código da Categoria: ");
        lbDescricao = new JLabel("Descrição: ");
        lbData_cadastro = new JLabel("Data de Cadastro: ");
                
        tfId = new JTextField(10);
        tfDescricao = new JTextField(60);
        tfData_cadastro = new JTextField(16);
        
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
        
        lbCad_categorias.setBounds(35, 75, 150, 25);
        
        lbId.setBounds(35, 175, 150, 25);
        tfId.setBounds(200, 175, 100, 25);
        lbDescricao.setBounds(35, 250, 100, 25);
        tfDescricao.setBounds(155, 250, 270, 25);
        lbData_cadastro.setBounds(35, 325, 120, 25);
        tfData_cadastro.setBounds(170, 325, 225, 25);
        
        btNovo.setBounds     (45, 550, 75, 75);
        btLocalizar.setBounds(145, 550, 75, 75);
        btGravar.setBounds   (245, 550, 75, 75);
        btAlterar.setBounds  (345, 550, 75, 75);
        btExcluir.setBounds  (445, 550, 75, 75);
        btCancelar.setBounds (545, 550, 75, 75);
        btSair.setBounds     (645, 550, 75, 75);
        //lbLargura.setBounds  (745, 550, 75, 75);
        //lbAltura.setBounds   (845, 550, 75, 75);
                
        add(lbCad_categorias);
        
        add(lbId);
        add(tfId);
        add(lbDescricao);
        add(tfDescricao);
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

        ativaDesativaTF(false);
        setBotoes(true, true, false, false, false, false);
        categorias = new CatDAO();
    }
    
    public void definirEventos() {
        
        tfId.addFocusListener(new FocusAdapter() {
            public void focusLost(FocusEvent e) {
                if(inclusao == true) {
                    categorias.categoria.setId(tfId.getText());
                    if(categorias.localizar()) {
                        JOptionPane.showMessageDialog(null, "Categoria já cadastrado!");
                        tfId.requestFocus();
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
            }
        });
        
        btCancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ativaDesativaTF(false);
                inclusao = false;
                limparCampos();
            }
        });
        
        btGravar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
                if(tfId.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Código da categoria não pode ser vazio!");
                    tfId.requestFocus();
                    return;
                } 
                
                if(tfDescricao.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Descrição da Categoria não pode ser vazia!");
                    tfDescricao.requestFocus();
                    return;
                }
         
                
                if(tfData_cadastro.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "A data de cadastro não pode ser vazia");
                    tfData_cadastro.requestFocus();
                    return;
                }
                
                categorias.categoria.setId(tfId.getText());
                categorias.categoria.setDescricao(tfDescricao.getText());
                categorias.categoria.setData_cadastro(tfData_cadastro.getText());
                JOptionPane.showMessageDialog(null, categorias.atualizar(CatDAO.INCLUSAO));
                limparCampos();
                ativaDesativaTF(false);
                inclusao = false;
            }
        });
        
        btAlterar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                categorias.categoria.setId(tfId.getText());
                categorias.categoria.setDescricao(tfDescricao.getText());
                categorias.categoria.setData_cadastro(tfData_cadastro.getText());
                JOptionPane.showMessageDialog(null, categorias.atualizar(CatDAO.ALTERACAO));
                limparCampos();
                ativaDesativaTF(false);
            }
        });
        
        btExcluir.addActionListener(new ActionListener(){ 
            public void actionPerformed(ActionEvent e) {
                categorias.categoria.setId(tfId.getText());
                categorias.localizar();
                int n = JOptionPane.showConfirmDialog(null, categorias.categoria.getDescricao(),
                        " Excluir a categoria? ", JOptionPane.YES_NO_OPTION);
                if(n == JOptionPane.YES_OPTION) {
                    JOptionPane.showMessageDialog(null, categorias.atualizar(CatDAO.EXCLUSAO));
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
        tfDescricao.setText("");
        tfData_cadastro.setText(formatoData.format(nova_data.getTime()));
        setBotoes(true, true, false, false, false, false);
    }
    
    public void atualizarCampos() {
        categorias.categoria.setId(tfId.getText());
        if(categorias.localizar()) {
            tfId.setText(categorias.categoria.getId());
            tfDescricao.setText(categorias.categoria.getDescricao());
            tfData_cadastro.setText(categorias.categoria.getData_cadastro());
            setBotoes(true, true, false, true, true, true);
            ativaDesativaTF(true);
        } else {
            JOptionPane.showMessageDialog(null, "Categoria não encontrado! " + categorias.categoria.getId());
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
        //tfId.setEnabled(ativa);
        tfDescricao.setEnabled(ativa);
        tfData_cadastro.setEnabled(ativa);
    }
    
}

/*
Table: categorias
Columns:
id varchar(10) 
descricao varchar(60) 
data_cadastro datetime
*/
        