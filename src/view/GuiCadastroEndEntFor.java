package view;

import dao.CliDAO;
import dao.EndEntCliDAO;
import dao.EndEntForDAO;
import dao.ForDAO;
import empresaiv.BD;
import empresaiv.GuiMenuPrincipal;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author Ronaldo Rodrigues Godoi
 */
public class GuiCadastroEndEntFor extends JPanel {
    
    JLabel lbCad_end_ent_for, lbNome_razao;
    
    JLabel lbId, lbId_fornecedor, lbTelefone, lbCep, lbEndereco, lbNumero,
           lbComplemento, lbBairro, lbCidade, lbEstado;
    
    JButton btGravar, btAlterar, btExcluir, btNovo, btLocalizar, btCancelar, btSair;
    
    JTextField tfId, tfId_fornecedor, tfTelefone, tfCep, tfEndereco, tfNumero,
            tfComplemento, tfBairro, tfCidade, tfEstado;
    
    JScrollPane sp2;
    String estado;
    
    JComboBox<String> cbEstado;
    
    String[] cbEstadoItem = {"AC", "AL", "AP", "AM", "BA", "CE", "ES", "GO",
                             "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE",
                             "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP",
                             "SE", "TO", "DF", ""};

    private EndEntForDAO endEntFornecedores;
    private ForDAO fornecedores;
          
    public GuiCadastroEndEntFor() {
        
        inicializarComponentes();
        definirEventos();
        
    }
    
    public void inicializarComponentes() {
        setLayout(null);
        
        lbCad_end_ent_for = new JLabel("Cadastro de Endereço onde o Fornecedor vai entregar");
        
        cbEstado = new JComboBox(cbEstadoItem);
        sp2 = new JScrollPane(cbEstado);
        
        lbId = new JLabel("Id do endereço de Entrega");
        lbId_fornecedor = new JLabel("CPF ou CGC: ");
        lbTelefone = new JLabel("Telefone: ");
        lbCep = new JLabel("CEP: ");
        lbEndereco = new JLabel("Endereço: ");
        lbNumero = new JLabel("Número:");
        lbComplemento = new JLabel("Complemento: ");
        lbBairro = new JLabel("Bairro: ");
        lbCidade = new JLabel("Cidade: ");
        lbEstado = new JLabel("Estado: ");
        lbNome_razao = new JLabel("Nome ou Razão: ");
                
        tfId = new JTextField(10);
        tfId_fornecedor = new JTextField(20);
        tfTelefone = new JTextField(17); 
        tfCep = new JTextField(9);
        tfEndereco = new JTextField(60);
        tfNumero = new JTextField(10);
        tfComplemento = new JTextField(40);
        tfBairro = new JTextField(60);
        tfCidade = new JTextField(40);
        tfEstado = new JTextField(2);
        
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
        
        lbCad_end_ent_for.setBounds(35, 75, 300, 25);
        
        lbId.setBounds(35, 175, 200, 25);
        tfId.setBounds(250, 175, 75, 25);
        lbId_fornecedor.setBounds(35, 250, 100, 25);
        tfId_fornecedor.setBounds(140, 250, 150, 25);
        lbNome_razao.setBounds(35, 280, 400, 25);
        lbTelefone.setBounds(450, 250, 100, 25);
        tfTelefone.setBounds(520, 250, 100, 25);
        lbCep.setBounds(35, 325, 100, 25);
        tfCep.setBounds(75, 325, 100, 25);
        lbEndereco.setBounds(220, 325, 100, 25);
        tfEndereco.setBounds(295, 325, 300, 25);
        lbNumero.setBounds(665, 325, 100, 25);
        tfNumero.setBounds(735, 325, 100, 25);
        lbComplemento.setBounds(35, 400, 150, 25);
        tfComplemento.setBounds(130, 400, 225, 25);
        lbBairro.setBounds(400, 400, 50, 25);
        tfBairro.setBounds(495, 400, 250, 25);
        lbCidade.setBounds(35, 475, 200, 25);
        tfCidade.setBounds(90, 475, 280, 25);
        lbEstado.setBounds(450, 475, 100, 25);
        sp2.setBounds(500, 475, 50, 30);
                
        btNovo.setBounds     (45, 550, 75, 75);
        btLocalizar.setBounds(145, 550, 75, 75);
        btGravar.setBounds   (245, 550, 75, 75);
        btAlterar.setBounds  (345, 550, 75, 75);
        btExcluir.setBounds  (445, 550, 75, 75);
        btCancelar.setBounds (545, 550, 75, 75);
        btSair.setBounds     (645, 550, 75, 75);
        
        add(lbCad_end_ent_for);
        
        add(lbId);
        add(tfId);
        add(lbId_fornecedor);
        add(tfId_fornecedor);
        add(lbNome_razao);
        add(lbTelefone);
        add(tfTelefone);
        add(lbCep);
        add(tfCep);
        add(lbEndereco);
        add(tfEndereco);
        add(lbNumero);
        add(tfNumero);
        add(lbComplemento);
        add(tfComplemento);
        add(lbBairro);
        add(tfBairro);
        add(lbCidade);
        add(tfCidade);
        add(lbEstado);
        add(sp2);
        
        add(btNovo);
        add(btLocalizar);
        add(btGravar);
        add(btAlterar);
        add(btExcluir);
        add(btCancelar);
        add(btSair);
        
        ativaDesativaTF(false);
        setBotoes(true, true, false, false, false, false);
        tfId.requestFocus();
        endEntFornecedores = new EndEntForDAO();
        fornecedores = new ForDAO();
    }
    
    public void definirEventos() {
        
        tfId_fornecedor.addFocusListener(new FocusAdapter() {
            public void focusLost(FocusEvent e) {
                fornecedores.fornecedor.setId_cgc_cpf(tfId_fornecedor.getText());
                if(!fornecedores.localizar()) {
                    JOptionPane.showMessageDialog(null, "Fornecedor não cadastrado!");
                    tfId_fornecedor.requestFocus();
                } else {
                    tfTelefone.requestFocus();
                    lbNome_razao.setText("Nome ou Razão: " + 
                            fornecedores.fornecedor.getNome_razao());
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
                limparCampos();
                setBotoes(false, false, true, false, false, true);
                tfId.requestFocus();
            }
        });
        
        btCancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ativaDesativaTF(false);
                limparCampos();
                tfId.requestFocus();
            }
        });
        
        btGravar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
                if(tfId.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "O código do endereço de entrega não pode estar vazio!");
                    tfId.requestFocus();
                    return; 
                }
                
                if(tfId_fornecedor.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "O CPF ou CGC não podem ser vazios!");
                    tfId_fornecedor.requestFocus();
                    return;
                }
                
                if(tfCep.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "O CEP não pode ser vazio!");
                    tfCep.requestFocus();
                    return;
                }
                
                if(tfEndereco.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "O Endereço não pode ser vazio!");
                    tfEndereco.requestFocus();
                    return;
                }
                
                if(tfNumero.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "O número não pode ser vazio!");
                    tfNumero.requestFocus();
                    return;
                } else {
                    try {
                        int numero = Integer.parseInt(tfNumero.getText());
                    } catch (Exception erro) {
                        JOptionPane.showMessageDialog(null, "O número não pode contém caracteres invalidos!");
                        tfNumero.requestFocus();
                        return;
                    }
                }
                
                if(tfCidade.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "A cidade não pode ser vazia!");
                    tfCidade.requestFocus();
                    return;
                }
                
                if(tfBairro.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "O bairro não pode ser vazio");
                    tfBairro.requestFocus();
                    return;
                }
                
                tfEstado.setText(cbEstado.getSelectedItem() + "");
                
                if(tfEstado.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "O estado não pode estar vazio!");
                    tfEstado.requestFocus();
                    return;
                }
                
                endEntFornecedores.for_entrega.setId(tfId.getText());
                endEntFornecedores.for_entrega.setId_fornecedor(tfId_fornecedor.getText());
                endEntFornecedores.for_entrega.setTelefone(tfTelefone.getText());
                endEntFornecedores.for_entrega.setCep(tfCep.getText());
                endEntFornecedores.for_entrega.setEndereco(tfEndereco.getText());
                endEntFornecedores.for_entrega.setNumero(tfNumero.getText());
                endEntFornecedores.for_entrega.setComplemento(tfComplemento.getText());
                endEntFornecedores.for_entrega.setBairro(tfBairro.getText());
                endEntFornecedores.for_entrega.setCidade(tfCidade.getText());
                endEntFornecedores.for_entrega.setEstado(cbEstado.getSelectedItem()+"");
                                
                JOptionPane.showMessageDialog(null, endEntFornecedores.atualizar(EndEntForDAO.INCLUSAO));
                limparCampos();
                ativaDesativaTF(false);
                tfId.requestFocus();
                
            }
        });
        
        btAlterar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
                endEntFornecedores.for_entrega.setId(tfId.getText());
                endEntFornecedores.for_entrega.setId_fornecedor(tfId_fornecedor.getText());
                endEntFornecedores.for_entrega.setTelefone(tfTelefone.getText());
                endEntFornecedores.for_entrega.setCep(tfCep.getText());
                endEntFornecedores.for_entrega.setEndereco(tfEndereco.getText());
                endEntFornecedores.for_entrega.setNumero(tfNumero.getText());
                endEntFornecedores.for_entrega.setComplemento(tfComplemento.getText());
                endEntFornecedores.for_entrega.setBairro(tfBairro.getText());
                endEntFornecedores.for_entrega.setCidade(tfCidade.getText());
                endEntFornecedores.for_entrega.setEstado(cbEstado.getSelectedItem()+"");
                
                JOptionPane.showMessageDialog(null, endEntFornecedores.atualizar(EndEntCliDAO.ALTERACAO));
                limparCampos();
                ativaDesativaTF(false);
                tfId.requestFocus();
                
            }
        });
        
        btExcluir.addActionListener(new ActionListener(){ 
            public void actionPerformed(ActionEvent e) {
                endEntFornecedores.for_entrega.setId(tfId.getText());
                endEntFornecedores.localizar();
                int n = JOptionPane.showConfirmDialog(null, endEntFornecedores.for_entrega.getId_fornecedor(),
                        "Excluir o endereço onde o Fornecedor deve entregar? ", JOptionPane.YES_NO_OPTION);
                if(n == JOptionPane.YES_OPTION) {
                    JOptionPane.showMessageDialog(null, endEntFornecedores.atualizar(EndEntCliDAO.EXCLUSAO));
                    limparCampos();
                    ativaDesativaTF(false);
                }
                tfId.requestFocus();
            }
        });
        
        btLocalizar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                atualizarCampos();
                tfId.requestFocus();
            }
        });
        
    }
    
    public void limparCampos() {
        tfId.setText("");
        tfId_fornecedor.setText("");
        lbNome_razao.setText("Nome ou Razão: ");
        tfTelefone.setText("");
        tfCep.setText("");
        tfEndereco.setText("");
        tfNumero.setText("");
        tfComplemento.setText("");
        tfBairro.setText("");
        tfCidade.setText("");
        cbEstado.setSelectedIndex(27);
        tfEstado.setText("");
        setBotoes(true, true, false, false, false, false);
    }
    
    public void atualizarCampos() {
        endEntFornecedores.for_entrega.setId(tfId.getText());
        if(endEntFornecedores.localizar()) {
            tfId_fornecedor.setText(endEntFornecedores.for_entrega.getId_fornecedor());
            if(!fornecedores.localizar()) {
                lbNome_razao.setText("Nome ou Razão: ");
            } else {
                lbNome_razao.setText("Nome ou Razão: " + 
                        fornecedores.fornecedor.getNome_razao());
            }
            tfTelefone.setText(endEntFornecedores.for_entrega.getTelefone());
            tfCep.setText(endEntFornecedores.for_entrega.getCep());
            tfEndereco.setText(endEntFornecedores.for_entrega.getEndereco());
            tfNumero.setText(endEntFornecedores.for_entrega.getNumero());
            tfComplemento.setText(endEntFornecedores.for_entrega.getComplemento());
            tfBairro.setText(endEntFornecedores.for_entrega.getBairro());
            tfCidade.setText(endEntFornecedores.for_entrega.getCidade());
            estado = endEntFornecedores.for_entrega.getEstado();
            for(int i = 0; i < 28; i++) if(cbEstadoItem[i].equals(estado)) cbEstado.setSelectedIndex(i);
            tfEstado.setText(cbEstado.getSelectedItem() + "");
            setBotoes(true, true, false, true, true, true);
            ativaDesativaTF(true);
        } else {
            JOptionPane.showMessageDialog(null, "Endereço de entrega não encontrado! " + endEntFornecedores.for_entrega.getId());
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
        tfId_fornecedor.setEnabled(ativa);
        tfTelefone.setEnabled(ativa);
        tfCep.setEnabled(ativa);
        tfEndereco.setEnabled(ativa);
        tfNumero.setEnabled(ativa);
        tfComplemento.setEnabled(ativa);
        tfBairro.setEnabled(ativa);
        tfCidade.setEnabled(ativa);
        cbEstado.setEnabled(ativa);
        tfEstado.setEnabled(ativa);
    }    
    
}

/*
Table: for_entrega
Columns:
id varchar(10) PK 
id_cliente varchar(10) 
telefone varchar(20) 
cep varchar(9) 
endereco varchar(60) 
numero int 
complemento varchar(40) 
bairro varchar(60) 
cidade varchar(40) 
estado varchar(2)
*/