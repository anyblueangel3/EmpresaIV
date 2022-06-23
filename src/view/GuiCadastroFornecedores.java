package view;

import dao.ForDAO;
import empresaiv.BD;
import empresaiv.GuiMenuPrincipal;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.*;

/**
 *
 * @author Ronaldo Rodrigues Godoi
 */
public class GuiCadastroFornecedores extends JPanel {
    
    JLabel lbCad_for; //, lbLargura, lbAltura;
    
    boolean inclusao = false;
    
    JLabel lbId_cgc_cpf, lbFisica_juridica, lbNome_razao, lbEmail, lbTelefone,
           lbCep, lbEndereco, lbNumero, lbComplemento, lbBairro, lbCidade,
           lbEstado, lbData_cadastro;
    

    JButton btGravar, btAlterar, btExcluir, btNovo, btLocalizar, btCancelar, btSair;
    
    JTextField tfId_cgc_cpf, tfFisica_juridica, tfNome_razao, tfEmail, tfTelefone,
            tfCep, tfEndereco, tfNumero, tfComplemento, tfBairro, tfCidade,
            tfEstado, tfData_cadastro;
    
    JComboBox<String> cbFisJur, cbEstado;
    String[] cbFisJurItem = {"1", "2", ""};
    String[] cbEstadoItem = {"AC", "AL", "AP", "AM", "BA", "CE", "ES", "GO",
                             "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE",
                             "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP",
                             "SE", "TO", "DF", ""};
    String estado;
    JScrollPane sp1, sp2;

      
    Date nova_data = new Date();
    DateFormat formatoData = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    
    private ForDAO fornecedores;
        
    public GuiCadastroFornecedores() {
        inicializarComponentes();
        definirEventos();
    }
    
    private void inicializarComponentes() {
        setLayout(null);
        
        //Dimension tela = Toolkit.getDefaultToolkit().getScreenSize();
        //lbLargura = new JLabel(""+tela.width);
        //lbAltura = new JLabel(""+tela.height);
        //int altura = 1000;
        //int largura = 1800;
        //setBounds(0, 0, largura, altura);
        
        lbCad_for = new JLabel("Cadastro de Fornecedores");
        
        cbFisJur = new JComboBox(cbFisJurItem);
        cbEstado = new JComboBox(cbEstadoItem);
        sp1 = new JScrollPane(cbFisJur);
        sp2 = new JScrollPane(cbEstado);
        
        lbId_cgc_cpf = new JLabel("CPF ou CGC: ");
        lbFisica_juridica = new JLabel("Pessoa física ou jurídica: ");
        lbNome_razao = new JLabel("Nome ou Razão Social: ");
        lbEmail = new JLabel("Email: ");
        lbTelefone = new JLabel("Telefone: ");
        lbCep = new JLabel("CEP: ");
        lbEndereco = new JLabel("Endereço: ");
        lbNumero = new JLabel("Número:");
        lbComplemento = new JLabel("Complemento: ");
        lbBairro = new JLabel("Bairro: ");
        lbCidade = new JLabel("Cidade: ");
        lbEstado = new JLabel("Estado: ");
        lbData_cadastro = new JLabel("Data de cadastro: ");
        
        tfId_cgc_cpf = new JTextField(20);
        tfFisica_juridica = new JTextField(1);
        tfNome_razao = new JTextField(60);
        tfEmail = new JTextField(80);
        tfTelefone = new JTextField(17); 
        tfCep = new JTextField(9);
        tfEndereco = new JTextField(60);
        tfNumero = new JTextField(10);
        tfComplemento = new JTextField(40);
        tfBairro = new JTextField(60);
        tfCidade = new JTextField(40);
        tfEstado = new JTextField(2);
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
        
        lbCad_for.setBounds(35, 75, 250, 25);
        lbId_cgc_cpf.setBounds(35, 175, 100, 25);
        tfId_cgc_cpf.setBounds(115, 175, 150, 25);
        lbFisica_juridica.setBounds(280, 175, 160, 25);
        sp1.setBounds(450, 175, 45, 30);
        lbNome_razao.setBounds(500, 175, 170, 25);
        tfNome_razao.setBounds(660, 175, 270, 25);
        lbEmail.setBounds(35, 250, 100, 25);
        tfEmail.setBounds(120, 250, 300, 25);
        lbTelefone.setBounds(450, 250, 100, 25);
        tfTelefone.setBounds(520, 250, 100, 25);
        lbCep.setBounds(35, 325, 100, 25);
        tfCep.setBounds(75, 325, 100, 25);
        lbEndereco.setBounds(200, 325, 100, 25);
        tfEndereco.setBounds(270, 325, 300, 25);
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
        lbData_cadastro.setBounds(600, 475, 150, 25);
        tfData_cadastro.setBounds(720, 475, 150, 25);
        
        btNovo.setBounds     (45, 550, 75, 75);
        btLocalizar.setBounds(145, 550, 75, 75);
        btGravar.setBounds   (245, 550, 75, 75);
        btAlterar.setBounds  (345, 550, 75, 75);
        btExcluir.setBounds  (445, 550, 75, 75);
        btCancelar.setBounds (545, 550, 75, 75);
        btSair.setBounds     (645, 550, 75, 75);
        //lbLargura.setBounds  (745, 550, 75, 75);
        //lbAltura.setBounds   (845, 550, 75, 75);
        
        add(lbCad_for);
        //add(lbLargura);
        //add(lbAltura);
        add(lbId_cgc_cpf);
        add(tfId_cgc_cpf);
        add(lbFisica_juridica);
        add(sp1);
        add(lbNome_razao);
        add(tfNome_razao);
        add(lbEmail);
        add(tfEmail);
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
        add(lbData_cadastro);
        add(tfData_cadastro);
        
        add(btNovo);
        add(btLocalizar);
        add(btGravar);
        add(btAlterar);
        add(btExcluir);
        add(btCancelar);
        add(btSair);
        
        ativaDesativaTF(false);
        setBotoes(true, true, false, false, false, false);
        fornecedores = new ForDAO();
    }
    
    private void definirEventos() {
        
        tfId_cgc_cpf.addFocusListener(new FocusAdapter() {
            public void focusLost(FocusEvent e) {
                if(inclusao == true) {
                    fornecedores.fornecedor.setId_cgc_cpf(tfId_cgc_cpf.getText());
                    if(fornecedores.localizar()) {
                        JOptionPane.showMessageDialog(null, "Fornecedor já cadastrado!");
                        tfId_cgc_cpf.requestFocus();
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
                tfId_cgc_cpf.requestFocus();
            }
        });
        
        btGravar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
                if(tfId_cgc_cpf.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "O CPF ou CGC não podem ser vazios!");
                    tfId_cgc_cpf.requestFocus();
                    return;
                } 
                
                if(tfNome_razao.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "O nome ou razão social não podem ser vazios!");
                    tfNome_razao.requestFocus();
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
                
                if(tfData_cadastro.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "A data de cadastro não pode ser vazia");
                    tfData_cadastro.requestFocus();
                    return;
                }
                
                fornecedores.fornecedor.setId_cgc_cpf(tfId_cgc_cpf.getText());
                fornecedores.fornecedor.setFisica_juridica(cbFisJur.getSelectedItem()+"");
                fornecedores.fornecedor.setNome_razao(tfNome_razao.getText());
                fornecedores.fornecedor.setEmail(tfEmail.getText());
                fornecedores.fornecedor.setTelefone(tfTelefone.getText());
                fornecedores.fornecedor.setCep(tfCep.getText());
                fornecedores.fornecedor.setEndereco(tfEndereco.getText());
                fornecedores.fornecedor.setNumero(tfNumero.getText());
                fornecedores.fornecedor.setComplemento(tfComplemento.getText());
                fornecedores.fornecedor.setBairro(tfBairro.getText());
                fornecedores.fornecedor.setCidade(tfCidade.getText());
                fornecedores.fornecedor.setEstado(cbEstado.getSelectedItem()+"");
                fornecedores.fornecedor.setData_cadastro(tfData_cadastro.getText());
                
                JOptionPane.showMessageDialog(null, fornecedores.atualizar(ForDAO.INCLUSAO));
                limparCampos();
                ativaDesativaTF(false);
                inclusao = false;
            }
        });
        
        btAlterar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                fornecedores.fornecedor.setId_cgc_cpf(tfId_cgc_cpf.getText());
                fornecedores.fornecedor.setFisica_juridica(cbFisJur.getSelectedItem()+"");
                fornecedores.fornecedor.setNome_razao(tfNome_razao.getText());
                fornecedores.fornecedor.setEmail(tfEmail.getText());
                fornecedores.fornecedor.setTelefone(tfTelefone.getText());
                fornecedores.fornecedor.setCep(tfCep.getText());
                fornecedores.fornecedor.setEndereco(tfEndereco.getText());
                fornecedores.fornecedor.setNumero(tfNumero.getText());
                fornecedores.fornecedor.setComplemento(tfComplemento.getText());
                fornecedores.fornecedor.setBairro(tfBairro.getText());
                fornecedores.fornecedor.setCidade(tfCidade.getText());
                fornecedores.fornecedor.setEstado(cbEstado.getSelectedItem()+"");
                fornecedores.fornecedor.setData_cadastro(tfData_cadastro.getText());
                JOptionPane.showMessageDialog(null, fornecedores.atualizar(ForDAO.ALTERACAO));
                limparCampos();
                ativaDesativaTF(false);
            }
        });
        
        btExcluir.addActionListener(new ActionListener(){ 
            public void actionPerformed(ActionEvent e) {
                fornecedores.fornecedor.setId_cgc_cpf(tfId_cgc_cpf.getText());
                fornecedores.localizar();
                int n = JOptionPane.showConfirmDialog(null, fornecedores.fornecedor.getNome_razao(),
                        " Excluir o fornecedor? ", JOptionPane.YES_NO_OPTION);
                if(n == JOptionPane.YES_OPTION) {
                    JOptionPane.showMessageDialog(null, fornecedores.atualizar(ForDAO.EXCLUSAO));
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
    
    private void limparCampos() {
        
        tfId_cgc_cpf.setText("");
        cbFisJur.setSelectedIndex(2);
        tfNome_razao.setText("");
        tfEmail.setText("");
        tfTelefone.setText("");
        tfCep.setText("");
        tfEndereco.setText("");
        tfNumero.setText("");
        tfComplemento.setText("");
        tfBairro.setText("");
        tfCidade.setText("");
        cbEstado.setSelectedIndex(27);
        tfData_cadastro.setText(formatoData.format(nova_data.getTime()));
        
        setBotoes(true, true, false, false, false, false);
    }
    
    private void atualizarCampos() {
        fornecedores.fornecedor.setId_cgc_cpf(tfId_cgc_cpf.getText());
        if(fornecedores.localizar()) {
            ativaDesativaTF(true);
            if(fornecedores.fornecedor.getFisica_juridica().equals("1")) 
                {cbFisJur.setSelectedIndex(0);}
            else
                {cbFisJur.setSelectedIndex(1);}
            tfId_cgc_cpf.setText(fornecedores.fornecedor.getId_cgc_cpf());
            tfFisica_juridica.setText(fornecedores.fornecedor.getFisica_juridica());
            tfNome_razao.setText(fornecedores.fornecedor.getNome_razao());
            tfEmail.setText(fornecedores.fornecedor.getEmail());
            tfTelefone.setText(fornecedores.fornecedor.getTelefone());
            tfCep.setText(fornecedores.fornecedor.getCep());
            tfEndereco.setText(fornecedores.fornecedor.getEndereco());
            tfNumero.setText(fornecedores.fornecedor.getNumero());
            tfComplemento.setText(fornecedores.fornecedor.getComplemento());
            tfBairro.setText(fornecedores.fornecedor.getBairro());
            tfCidade.setText(fornecedores.fornecedor.getCidade());
            estado = fornecedores.fornecedor.getEstado();
            for(int i = 0; i < 28; i++) 
                if(cbEstadoItem[i].equals(estado)) cbEstado.setSelectedIndex(i);
            tfEstado.setText(cbEstado.getSelectedItem()+"");
            tfData_cadastro.setText(fornecedores.fornecedor.getData_cadastro());
            setBotoes(true, true, false, true, true, true);
        } else {
            JOptionPane.showMessageDialog(null, "Cliente não encontrado! " + fornecedores.fornecedor.getId_cgc_cpf());
            limparCampos();
            ativaDesativaTF(false);
        }
    }
    
    private void setBotoes(boolean bNovo, boolean bLocalizar, boolean bGravar,
            boolean bAlterar, boolean bExcluir, boolean bCancelar) {
        btNovo.setEnabled(bNovo);
        btLocalizar.setEnabled(bLocalizar);
        btGravar.setEnabled(bGravar);
        btAlterar.setEnabled(bAlterar);
        btExcluir.setEnabled(bExcluir);
        btCancelar.setEnabled(bCancelar);
    }
    
    private void ativaDesativaTF(boolean ativa) {
        // tfId_cgc_cpf.setEnabled(ativa);
        cbFisJur.setEnabled(ativa);
        tfFisica_juridica.setEnabled(ativa);
        tfNome_razao.setEnabled(ativa);
        tfEmail.setEnabled(ativa);
        tfTelefone.setEnabled(ativa);
        tfCep.setEnabled(ativa);
        tfEndereco.setEnabled(ativa);
        tfNumero.setEnabled(ativa);
        tfComplemento.setEnabled(ativa);
        tfBairro.setEnabled(ativa);
        tfCidade.setEnabled(ativa);
        cbEstado.setEnabled(ativa);
        tfEstado.setEnabled(ativa);
        tfData_cadastro.setEnabled(ativa);
    }
    
}

/*
id_cgc_cpf varchar(16) PK 
fisica_juridica varchar(1) 
nome_razao varchar(60) 
email varchar(80) 
telefone varchar(20) 
cep varchar(9) 
endereco varchar(60) 
numero int 
complemento varchar(40) 
bairro varchar(60) 
cidade varchar(40) 
estado varchar(2) 
data_cadastro datetime
*/