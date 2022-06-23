package view;

import dao.CliDAO;
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
public class GuiCadastroClientes extends JPanel{
    
    JLabel lbCad_cli; //, lbLargura, lbAltura;
    
    boolean inclusao = false;
    
    JLabel lbId_cgc_cpf, lbFisica_juridica, lbNome_razao, lbEmail, lbTelefone,
           lbCep, lbEndereco, lbNumero, lbComplemento, lbBairro, lbCidade,
           lbEstado, lbData_cadastro;
    

    JButton btGravar, btAlterar, btExcluir, btNovo, btLocalizar, btCancelar, btSair;
    
    JTextField tfId_cgc_cpf, tfFisica_juridica, tfNome_razao, tfEmail, tfTelefone,
            tfCep, tfEndereco, tfNumero, tfComplemento, tfBairro, tfCidade,
            tfEstado, tfData_cadastro;
    
    JComboBox<String> cbFisJur, cbEstado;
    String estado;
    String[] cbFisJurItem = {"1", "2", ""};
    String[] cbEstadoItem = {"AC", "AL", "AP", "AM", "BA", "CE", "ES", "GO",
                             "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE",
                             "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP",
                             "SE", "TO", "DF", ""};
    JScrollPane sp1, sp2;
      
    Date nova_data = new Date();
    DateFormat formatoData = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    
    private CliDAO clientes;
        
    public GuiCadastroClientes() {
        
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
        //setBounds(0, 0, largura, altura);
        
        lbCad_cli = new JLabel("Cadastro de Clientes");
                
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
        
        lbCad_cli.setBounds(35, 75, 150, 25);
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
        
        btNovo.setBounds     (45, 650, 75, 75);
        btLocalizar.setBounds(145, 650, 75, 75);
        btGravar.setBounds   (245, 650, 75, 75);
        btAlterar.setBounds  (345, 650, 75, 75);
        btExcluir.setBounds  (445, 650, 75, 75);
        btCancelar.setBounds (545, 650, 75, 75);
        btSair.setBounds     (645, 650, 75, 75);
        //lbLargura.setBounds  (745, 650, 75, 75);
        //lbAltura.setBounds   (845, 650, 75, 75);
        
        add(lbCad_cli);
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
        
        //setResizable(false);
        ativaDesativaTF(false);
        setBotoes(true, true, false, false, false, false);
        clientes = new CliDAO();
    }
    
    public void definirEventos() {
        
        tfId_cgc_cpf.addFocusListener(new FocusAdapter() {
            public void focusLost(FocusEvent e) {
                if(inclusao == true) {
                    clientes.cliente.setId_cgc_cpf(tfId_cgc_cpf.getText());
                    if(clientes.localizar()) {
                        JOptionPane.showMessageDialog(null, "Cliente já cadastrado!");
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
                
                clientes.cliente.setId_cgc_cpf(tfId_cgc_cpf.getText());
                clientes.cliente.setFisica_juridica(cbFisJur.getSelectedItem()+"");
                clientes.cliente.setNome_razao(tfNome_razao.getText());
                clientes.cliente.setEmail(tfEmail.getText());
                clientes.cliente.setTelefone(tfTelefone.getText());
                clientes.cliente.setCep(tfCep.getText());
                clientes.cliente.setEndereco(tfEndereco.getText());
                clientes.cliente.setNumero(tfNumero.getText());
                clientes.cliente.setComplemento(tfComplemento.getText());
                clientes.cliente.setBairro(tfBairro.getText());
                clientes.cliente.setCidade(tfCidade.getText());
                clientes.cliente.setEstado(cbEstado.getSelectedItem()+"");
                clientes.cliente.setData_cadastro(tfData_cadastro.getText());
                
                JOptionPane.showMessageDialog(null, clientes.atualizar(CliDAO.INCLUSAO));
                limparCampos();
                ativaDesativaTF(false);
                inclusao = false;
            }
        });
        
        btAlterar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                clientes.cliente.setId_cgc_cpf(tfId_cgc_cpf.getText());
                clientes.cliente.setFisica_juridica(cbFisJur.getSelectedItem()+"");
                clientes.cliente.setNome_razao(tfNome_razao.getText());
                clientes.cliente.setEmail(tfEmail.getText());
                clientes.cliente.setTelefone(tfTelefone.getText());
                clientes.cliente.setCep(tfCep.getText());
                clientes.cliente.setEndereco(tfEndereco.getText());
                clientes.cliente.setNumero(tfNumero.getText());
                clientes.cliente.setComplemento(tfComplemento.getText());
                clientes.cliente.setBairro(tfBairro.getText());
                clientes.cliente.setCidade(tfCidade.getText());
                clientes.cliente.setEstado(cbEstado.getSelectedItem()+"");
                clientes.cliente.setData_cadastro(tfData_cadastro.getText());
                JOptionPane.showMessageDialog(null, clientes.atualizar(CliDAO.ALTERACAO));
                limparCampos();
                ativaDesativaTF(false);
            }
        });
        
        btExcluir.addActionListener(new ActionListener(){ 
            public void actionPerformed(ActionEvent e) {
                clientes.cliente.setId_cgc_cpf(tfId_cgc_cpf.getText());
                clientes.localizar();
                int n = JOptionPane.showConfirmDialog(null, clientes.cliente.getNome_razao(),
                        " Excluir o cliente? ", JOptionPane.YES_NO_OPTION);
                if(n == JOptionPane.YES_OPTION) {
                    JOptionPane.showMessageDialog(null, clientes.atualizar(CliDAO.EXCLUSAO));
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
        
        tfId_cgc_cpf.setText("");
        cbFisJur.setSelectedIndex(2);
        tfFisica_juridica.setText("");
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
        tfEstado.setText("");
        tfData_cadastro.setText(formatoData.format(nova_data.getTime()));
        
        setBotoes(true, true, false, false, false, false);
    }
    
    public void atualizarCampos() {
        clientes.cliente.setId_cgc_cpf(tfId_cgc_cpf.getText());
        if(clientes.localizar()) {
            ativaDesativaTF(true);
            if(clientes.cliente.getFisica_juridica().equals("1")) 
                {cbFisJur.setSelectedIndex(0);}
            else
                {cbFisJur.setSelectedIndex(1);}
            tfId_cgc_cpf.setText(clientes.cliente.getId_cgc_cpf());
            tfNome_razao.setText(clientes.cliente.getNome_razao());
            tfEmail.setText(clientes.cliente.getEmail());
            tfTelefone.setText(clientes.cliente.getTelefone());
            tfCep.setText(clientes.cliente.getCep());
            tfEndereco.setText(clientes.cliente.getEndereco());
            tfNumero.setText(clientes.cliente.getNumero());
            tfComplemento.setText(clientes.cliente.getComplemento());
            tfBairro.setText(clientes.cliente.getBairro());
            tfCidade.setText(clientes.cliente.getCidade());
            estado = clientes.cliente.getEstado();
            for(int i = 0; i < 28; i++) if(cbEstadoItem[i].equals(estado)) cbEstado.setSelectedIndex(i);
            tfEstado.setText(cbEstado.getSelectedItem() + "");
            tfData_cadastro.setText(clientes.cliente.getData_cadastro());
            setBotoes(true, true, false, true, true, true);
        } else {
            JOptionPane.showMessageDialog(null, "Cliente não encontrado! " + clientes.cliente.getId_cgc_cpf());
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