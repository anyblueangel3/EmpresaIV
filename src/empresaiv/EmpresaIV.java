package empresaiv;

import dao.UsuariosDAO;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import model.Usuarios;

/**
 *
 * @author Ronaldo R. Godoi
 */
public class EmpresaIV extends JFrame {
    
    private JTextField tfLogin;
    private JLabel lbSenha;
    private JLabel lbLogin;
    private JButton btLogar;
    private JButton btCancelar;
    private JPasswordField pfSenha;
    private static EmpresaIV frame;
    Usuarios aUsuario = new Usuarios();
    private UsuariosDAO usuarios;

    public EmpresaIV() {
        
        inicializarComponentes();
        definirEventos();
        
    }
    
    private void inicializarComponentes() {
        
        setTitle("Login no Sistema");
        setBounds(0, 0, 400, 200);
        setLayout(null);
        tfLogin = new JTextField(5);
        pfSenha = new JPasswordField(5);
        lbSenha = new JLabel("Senha: ");
        lbLogin = new JLabel("Login: ");
        btLogar = new JButton("Logar");
        btCancelar = new JButton("Cancelar");
        tfLogin.setBounds(100, 30, 120, 25);
        lbLogin.setBounds(30, 30, 80, 25);
        lbSenha.setBounds(30, 75, 80, 25);
        pfSenha.setBounds(100, 75, 120, 25);
        btLogar.setBounds(20, 120, 100, 25);
        btCancelar.setBounds(125, 120, 100, 25);
        add(tfLogin);
        add(lbSenha);
        add(lbLogin);
        add(btLogar);
        add(btCancelar);
        add(pfSenha);
        usuarios = new UsuariosDAO();
    }
    
    private void definirEventos() {
        
        btLogar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(tfLogin.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Login não pode estar em branco!");
                    return;
                }
                String senha = String.valueOf(pfSenha.getPassword());
                if(tfLogin.getText().equals("java") && senha.equals("java")) {
                    declaraUsuario();
                    BD.getInstance().close();
                    frame.setVisible(false);
                    GuiMenuPrincipal.abrir(aUsuario); // Aqui vai o código para chamar o exemplo 8.3
                } else {
                    usuarios.usuario.setNome(tfLogin.getText());
                    usuarios.localizar();
                    if(usuarios.usuario.getNome().equals(tfLogin.getText()) && usuarios.usuario.getSenha().equals(senha)) {
                            declaraUsuario(usuarios.usuario);
                            BD.getInstance().close();
                            frame.setVisible(false);
                            GuiMenuPrincipal.abrir(aUsuario);
                    } else {
                        JOptionPane.showMessageDialog(null, "Login ou senha incorretos!");
                    }
                }
            }
        });
        
        btCancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        
    }
    
    private void declaraUsuario() {
        aUsuario.setId(0);
        aUsuario.setNome("java");
        aUsuario.setSenha("java");
        aUsuario.setCadastroClientes(true);
        aUsuario.setCadastroFornecedores(true);
        aUsuario.setCadastroProdutos(true);
        aUsuario.setCadastroCategoria(true);
        aUsuario.setCadastroEnderecoEntregaCliente(true);
        aUsuario.setCadastroEnderecoEntregaFornecedor(true);
        aUsuario.setCadastroFornecedoresProduto(true);
        aUsuario.setCadastroUnidades(true);
        aUsuario.setPedidoCliente(true);
        aUsuario.setPedidoFornecedor(true);
        aUsuario.setConsultaClientes(true);
        aUsuario.setConsultaFornecedor(true);
        aUsuario.setConsultaProduto(true);
        aUsuario.setConsultaCategoria(true);
        aUsuario.setConsultaEnderecoEntregaCliente(true);
        aUsuario.setConsultaEnderecoEntregaFornecedor(true);
        aUsuario.setRelatorioClientes(true);
        aUsuario.setRelatorioFornecedor(true);
        aUsuario.setRelatorioProduto(true);
        aUsuario.setRelatorioCategoria(true);
        aUsuario.setRelatorioUnidades(true);
    }
    
    private void declaraUsuario(Usuarios aUsuario) {
        this.aUsuario.setId(aUsuario.getId());
        this.aUsuario.setNome(aUsuario.getNome());
        this.aUsuario.setSenha(aUsuario.getSenha());
        this.aUsuario.setCadastroClientes(aUsuario.isCadastroClientes());
        this.aUsuario.setCadastroFornecedores(aUsuario.isCadastroFornecedores());
        this.aUsuario.setCadastroProdutos(aUsuario.isCadastroProdutos());
        this.aUsuario.setCadastroCategoria(aUsuario.isCadastroCategoria());
        this.aUsuario.setCadastroEnderecoEntregaCliente(aUsuario.isCadastroEnderecoEntregaCliente());
        this.aUsuario.setCadastroEnderecoEntregaFornecedor(aUsuario.isCadastroEnderecoEntregaFornecedor());
        this.aUsuario.setCadastroFornecedoresProduto(aUsuario.isCadastroFornecedoresProduto());
        this.aUsuario.setCadastroUnidades(aUsuario.isCadastroUnidades());
        this.aUsuario.setPedidoCliente(aUsuario.isPedidoCliente());
        this.aUsuario.setPedidoFornecedor(aUsuario.isPedidoFornecedor());
        this.aUsuario.setConsultaClientes(aUsuario.isConsultaClientes());
        this.aUsuario.setConsultaFornecedor(aUsuario.isConsultaFornecedor());
        this.aUsuario.setConsultaProduto(aUsuario.isConsultaProduto());
        this.aUsuario.setConsultaCategoria(aUsuario.isConsultaCategoria());
        this.aUsuario.setConsultaEnderecoEntregaCliente(aUsuario.isConsultaEnderecoEntregaCliente());
        this.aUsuario.setConsultaEnderecoEntregaFornecedor(aUsuario.isConsultaEnderecoEntregaFornecedor());
        this.aUsuario.setRelatorioClientes(aUsuario.isRelatorioClientes());
        this.aUsuario.setRelatorioFornecedor(aUsuario.isRelatorioFornecedor());
        this.aUsuario.setRelatorioProduto(aUsuario.isRelatorioProduto());
        this.aUsuario.setRelatorioCategoria(aUsuario.isRelatorioCategoria());
        this.aUsuario.setRelatorioUnidades(aUsuario.isRelatorioUnidades());  
    }
    
    public static void main(String[] args) {
        
        SwingUtilities.invokeLater(new Runnable() { 
            public void run() {
                frame = new EmpresaIV();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                Dimension tela = Toolkit.getDefaultToolkit().getScreenSize();
                frame.setLocation((tela.width - frame.getSize().width) / 2,
                        (tela.height - frame.getSize().height) / 2);
                frame.setVisible(true);
            }
        });
        
    }
    
}
