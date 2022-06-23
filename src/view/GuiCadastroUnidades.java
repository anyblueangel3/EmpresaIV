package view;

import dao.UnidadesDAO;
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
 * @author Ronaldo R. Godoi
 */
public class GuiCadastroUnidades extends JPanel {
    
    JLabel lbCad_unidades; //, lbLargura, lbAltura;
    
    boolean inclusao = false;
    
    JLabel lbId, lbDescricao, lbData_cadastro;
    
    JButton btGravar, btAlterar, btExcluir, btNovo, btLocalizar, btCancelar, btSair;
    
    JTextField tfId, tfDescricao, tfData_cadastro;
    
    Date nova_data = new Date();
    DateFormat formatoData = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    
    private UnidadesDAO unidades;
        
    public GuiCadastroUnidades() {
        
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
                
        lbCad_unidades = new JLabel("Cadastro de Unidades de compra e venda");
        
        lbId = new JLabel("Código da unidade: ");
        lbDescricao = new JLabel("Descrição: ");
        lbData_cadastro = new JLabel("Data de Cadastro: ");
                
        tfId = new JTextField(10);
        tfDescricao = new JTextField(40);
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
        
        lbCad_unidades.setBounds(35, 75, 250, 25);
        
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
                
        add(lbCad_unidades);
        
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
        unidades = new UnidadesDAO();
    }
    
    public void definirEventos() {
        
        tfId.addFocusListener(new FocusAdapter() {
            public void focusLost(FocusEvent e) {
                if(inclusao == true) {
                    unidades.unidade.setId(tfId.getText());
                    if(unidades.localizar()) {
                        JOptionPane.showMessageDialog(null, "Unidade já cadastrada!");
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
                    JOptionPane.showMessageDialog(null, "Código da unidade não pode ser vazio!");
                    tfId.requestFocus();
                    return;
                } 
                
                if(tfDescricao.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Descrição da unidade não pode ser vazia!");
                    tfDescricao.requestFocus();
                    return;
                }
         
                
                if(tfData_cadastro.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "A data de cadastro não pode ser vazia");
                    tfData_cadastro.requestFocus();
                    return;
                }
                
                unidades.unidade.setId(tfId.getText());
                unidades.unidade.setDescricao(tfDescricao.getText());
                unidades.unidade.setData_cadastro(tfData_cadastro.getText());
                JOptionPane.showMessageDialog(null, unidades.atualizar(UnidadesDAO.INCLUSAO));
                limparCampos();
                ativaDesativaTF(false);
                inclusao = false;
            }
        });
        
        btAlterar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                unidades.unidade.setId(tfId.getText());
                unidades.unidade.setDescricao(tfDescricao.getText());
                unidades.unidade.setData_cadastro(tfData_cadastro.getText());
                JOptionPane.showMessageDialog(null, unidades.atualizar(UnidadesDAO.ALTERACAO));
                limparCampos();
                ativaDesativaTF(false);
            }
        });
        
        btExcluir.addActionListener(new ActionListener(){ 
            public void actionPerformed(ActionEvent e) {
                unidades.unidade.setId(tfId.getText());
                unidades.localizar();
                int n = JOptionPane.showConfirmDialog(null, unidades.unidade.getDescricao(),
                        " Excluir o unidade? ", JOptionPane.YES_NO_OPTION);
                if(n == JOptionPane.YES_OPTION) {
                    JOptionPane.showMessageDialog(null, unidades.atualizar(UnidadesDAO.EXCLUSAO));
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
        unidades.unidade.setId(tfId.getText());
        if(unidades.localizar()) {
            ativaDesativaTF(true);
            tfId.setText(unidades.unidade.getId());
            tfDescricao.setText(unidades.unidade.getDescricao());
            tfData_cadastro.setText(unidades.unidade.getData_cadastro());
            setBotoes(true, true, false, true, true, true);
        } else {
            JOptionPane.showMessageDialog(null, "Unidade não encontrado! " + unidades.unidade.getId());
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
        tfDescricao.setEnabled(ativa);
        tfData_cadastro.setEnabled(ativa);
    }
    
}

/*
Table: unidades
Columns:
id varchar(10) 
descricao varchar(40) 
data_cadastro datetime
*/