package view;

import dao.PedidosClienteDAO;
import empresaiv.BD;
import empresaiv.GuiMenuPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import model.Clientes;
import model.ItensPedidoCliente;
import model.ItensPedidoClienteEstendida;
import model.PedidosCliente;
import model.Produtos;
import empresaiv.Util;
import java.util.Calendar;

/**
 *
 * @author Ronaldo Rodrigues Godoi
 */
public class GuiPedidoCliente extends JPanel {

    ArrayList<ItensPedidoClienteEstendida> listaItens = new ArrayList<>();

    Util util = new Util();

    Date nova_data = new Date();
    DateFormat formatoData = new SimpleDateFormat("yyyy-MM-dd");

    JTextField tfId_pedido, tfId_cliente, tfId_endereco_entrega,
            tfIdCondicao_pag, tfData_pedido, tfId_item, tfId_produto, tfQuantidade,
            tfPreco, tfData_entrega;

    JLabel lbTituloTela, lbId_pedido, lbId_cliente, lbId_endereco_entrega,
            lbIdCondicao_pag, lbData_pedido, lbId_item, lbId_produto, lbQuantidade,
            lbPreco, lbData_entrega;

    JButton btSair, btNovo1, btGravar1, btAlterar1, btExcluir1, btNovo2,
            btGravar2, btAlterar2, btExcluir2, btBaixarEstoque, btLocalizar,
            btLimpar, btLimpar2;

    int numeroItens, linha;

    boolean baixado = false;

    JTable tbPedido;
    DefaultTableModel tableModel = new DefaultTableModel(new String[]{}, 0) {
    };
    JScrollPane scrollTable;
    String[] colunas = {"Id item", "Id produto",
        "Descrição do produto", "Quantidade",
        "Preco", "Total"};

    PedidosClienteDAO pedidosDAO;

    public GuiPedidoCliente() {

        inicializarComponentes();
        definirEventos();

    }

    private void inicializarComponentes() {

        setLayout(null);

        btSair = new JButton(" SAIR ");
        btNovo1 = new JButton(" Novo Pedido ");
        btGravar1 = new JButton(" Gravar Pedido");
        btAlterar1 = new JButton(" Gravar Alteração ");
        btExcluir1 = new JButton(" Excluir Pedido ");
        btLimpar = new JButton(" Limpar Dados ");

        btNovo2 = new JButton(" Novo Item ");
        btGravar2 = new JButton(" Gravar Item ");
        btAlterar2 = new JButton(" Alterar Item ");
        btExcluir2 = new JButton(" Excluir Item ");
        btLimpar2 = new JButton(" Limpar Item ");

        btBaixarEstoque = new JButton(" Baixar Estoque ");
        btLocalizar = new JButton(" Localizar ");

        lbTituloTela = new JLabel("Pedido a Cliente");
        lbId_pedido = new JLabel("Id do Pedido: ");
        lbId_cliente = new JLabel("Id do Cliente: ");
        lbId_endereco_entrega = new JLabel("Id do Endereço de entrega: ");
        lbIdCondicao_pag = new JLabel("Id da Condição de pagamento: ");
        lbData_pedido = new JLabel("Data do pedido: ");

        lbId_item = new JLabel("Id do Item: ");
        lbId_produto = new JLabel("Id do Produto: ");
        lbQuantidade = new JLabel("Quantidade: ");
        lbPreco = new JLabel("Preço: ");
        lbData_entrega = new JLabel("Data de entrega: ");

        tfId_pedido = new JTextField(10);
        tfId_cliente = new JTextField(10);
        tfId_endereco_entrega = new JTextField(10);
        tfIdCondicao_pag = new JTextField(10);
        tfData_pedido = new JTextField(20);

        tfId_item = new JTextField(10);
        tfId_produto = new JTextField(10);
        tfQuantidade = new JTextField(10);
        tfPreco = new JTextField(10);
        tfData_entrega = new JTextField(20);

        lbTituloTela.setBounds(35, 25, 200, 25);
        lbId_pedido.setBounds(35, 80, 100, 25);
        lbId_cliente.setBounds(140, 80, 100, 25);
        lbId_endereco_entrega.setBounds(250, 80, 200, 25);
        lbIdCondicao_pag.setBounds(35, 140, 200, 25);
        lbData_pedido.setBounds(240, 140, 100, 25);

        lbId_item.setBounds(35, 250, 100, 25);
        lbId_produto.setBounds(140, 250, 100, 25);
        lbQuantidade.setBounds(245, 250, 110, 25);
        lbPreco.setBounds(360, 250, 50, 25);

        tfId_pedido.setBounds(35, 110, 100, 25);
        tfId_cliente.setBounds(140, 110, 100, 25);
        tfId_endereco_entrega.setBounds(250, 110, 100, 25);
        tfIdCondicao_pag.setBounds(35, 170, 100, 25);
        tfData_pedido.setBounds(240, 170, 150, 25);

        tfId_item.setBounds(35, 280, 100, 25);
        tfId_produto.setBounds(140, 280, 100, 25);
        tfQuantidade.setBounds(245, 280, 110, 25);
        tfPreco.setBounds(360, 280, 110, 25);

        btSair.setBounds(600, 25, 150, 25);
        btNovo1.setBounds(600, 100, 150, 25);
        btGravar1.setBounds(600, 130, 150, 25);
        btAlterar1.setBounds(600, 160, 150, 25);
        btExcluir1.setBounds(600, 190, 150, 25);
        btLocalizar.setBounds(790, 100, 150, 25);
        btLimpar.setBounds(790, 130, 150, 25);

        btNovo2.setBounds(500, 280, 130, 25);
        btGravar2.setBounds(660, 280, 130, 25);
        btAlterar2.setBounds(500, 310, 130, 25);
        btExcluir2.setBounds(660, 310, 130, 25);
        btLimpar2.setBounds(820, 280, 130, 25);

        btBaixarEstoque.setBounds(790, 25, 150, 25);

        scrollTable = new JScrollPane();
        scrollTable.setBounds(35, 350, 800, 380);
        for (int i = 0; i < 6; i++) {
            tableModel.addColumn(colunas[i]);
        }

        tbPedido = new JTable(tableModel);
        tbPedido.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        scrollTable.setViewportView(tbPedido);

        add(btSair);
        add(btNovo1);
        add(btGravar1);
        add(btAlterar1);
        add(btExcluir1);
        add(btBaixarEstoque);
        add(btLocalizar);
        add(btLimpar);

        add(btNovo2);
        add(btGravar2);
        add(btAlterar2);
        add(btExcluir2);
        add(btLimpar2);

        add(lbTituloTela);
        add(lbTituloTela);
        add(lbId_pedido);
        add(lbId_cliente);
        add(lbId_endereco_entrega);
        add(lbIdCondicao_pag);
        add(lbData_pedido);
        add(lbId_item);
        add(lbId_produto);
        add(lbQuantidade);
        add(lbPreco);
        add(lbData_entrega);

        add(tfId_pedido);
        add(tfId_cliente);
        add(tfId_endereco_entrega);
        add(tfIdCondicao_pag);
        add(tfData_pedido);

        add(tfId_item);
        add(tfId_produto);
        add(tfQuantidade);
        add(tfPreco);
        add(tfData_entrega);

        add(scrollTable);

        pedidosDAO = new PedidosClienteDAO();
        setBotoesPedido(true, false, false, false, true, true, false);
        setBotoesItem(false);
        setTFPedido(false);
        setTFItem(false, false);
    }

    private void definirEventos() {

        /*
        * Eventos do Cabeçalho do Pedido
        **/
        btSair.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                GuiMenuPrincipal.liberaMenu();
                BD.getInstance().close();
                setVisible(false);
            }
        });

        btNovo1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                tableModel.setNumRows(0);
                numeroItens = 0;
                listaItens.clear();
                limparCamposPedido();
                limparCamposItem();
                setTFPedido(true);
                setTFItem(false, false);
                setBotoesItem(false);
                tfId_pedido.setEditable(false);
            }
        });

        btLocalizar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                listaItens.clear();
                int Id_pedido = util.spaceToInt(tfId_pedido.getText());
                setBotoesItem(false);
                setTFPedido(false);
                if (!pedidosDAO.localizarPedido(Id_pedido)) {
                    JOptionPane.showMessageDialog(null, "Pedido não cadastrado!");
                } else {
                    listaItens = pedidosDAO.carregarListaItens();
                    if (listaItens.size() == 0) {
                        JOptionPane.showMessageDialog(null, "Pedido não tem itens cadastrados, exclua o pedido!");
                        btExcluir1.setEnabled(true);
                    } else {
                        tfId_pedido.setText(String.valueOf(pedidosDAO.pedidoCliente.getId()));
                        tfId_cliente.setText(pedidosDAO.pedidoCliente.getId_cliente());
                        tfId_endereco_entrega.setText(pedidosDAO.pedidoCliente.getId_endereco_entrega());
                        tfIdCondicao_pag.setText(pedidosDAO.pedidoCliente.getCondicao_pag());
                        tfData_pedido.setText("" + pedidosDAO.pedidoCliente.getData_pedido());
                        tableModel.setNumRows(0);
                        for (int i = 0; i < listaItens.size(); i++) {
                            tableModel.addRow(new Object[]{
                                listaItens.get(i).getId(),
                                listaItens.get(i).getId_produto(),
                                listaItens.get(i).getDescricao_produto(),
                                listaItens.get(i).getQuantidade(),
                                listaItens.get(i).getPreco(),
                                listaItens.get(i).getQuantidade() * listaItens.get(i).getPreco()
                            });
                        }
                        limparCamposItem();
                        if (!pedidosDAO.pedidoBaixado()) {
                            // novo1, gravar1, alterar1, excluir1, localizar, limpar, baixarEstoque
                            setBotoesPedido(true, false, false, false, false, true, false);
                            setBotoesItem(false);
                            JOptionPane.showMessageDialog(null, "Pedido baixado!");
                            baixado = true;
                        } else {
                            // novo1, gravar1, alterar1, excluir1, localizar, limpar, baixarEstoque
                            setBotoesPedido(true, false, true, true, true, true, true);
                            //btNovo2, btGravar2, btAlterar2, btExcluir2, btLimpar2
                            setBotoesItem(true);
                            setTFPedido(true);
                            setTFItem(false, false);
                            JOptionPane.showMessageDialog(null, "Pedido não baixado!");
                            baixado = false;
                        }
                    }
                }
                return;
            }
        });

        btAlterar1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                pedidosDAO.pedidoCliente.setId(Integer.parseInt(tfId_pedido.getText()));
                pedidosDAO.pedidoCliente.setId_cliente(tfId_cliente.getText());
                pedidosDAO.pedidoCliente.setId_endereco_entrega(tfId_endereco_entrega.getText());
                pedidosDAO.pedidoCliente.setCondicao_pag(tfIdCondicao_pag.getText());
                try {
                    nova_data = formatoData.parse(tfData_pedido.getText());
                    java.sql.Date sqlData = new java.sql.Date(nova_data.getTime());
                    pedidosDAO.pedidoCliente.setData_pedido(sqlData);
                } catch (ParseException erro) {
                    JOptionPane.showMessageDialog(null, "Erro ao converter a data");
                    return;
                }
                if (!pedidosDAO.alterar1()) {
                    JOptionPane.showMessageDialog(null, "Problema para alterar cabeçalho do Pedido!");
                } else {
                    JOptionPane.showMessageDialog(null, "Cabeçalho do Pedido alterado com sucesso!");
                }
                return;
            }
        });

        btLimpar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                limparCamposPedido();
                limparCamposItem();
                // novo1, gravar1, alterar1, excluir1, localizar, limpar, baixarEstoque
                setBotoesPedido(true, false, false, false, true, true, false);
                setBotoesItem(false);
                setTFPedido(false);
                setTFItem(false, false);
                tfId_pedido.setEditable(true);
                tableModel.setNumRows(0);
            }
        });

        btGravar1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                tableModel.setNumRows(0);

                pedidosDAO.pedidoCliente.setId_cliente(tfId_cliente.getText());
                pedidosDAO.pedidoCliente.setId_endereco_entrega(tfId_endereco_entrega.getText());
                pedidosDAO.pedidoCliente.setCondicao_pag(tfIdCondicao_pag.getText());

                try {
                    nova_data = formatoData.parse(tfData_pedido.getText());
                    java.sql.Date sqlData = new java.sql.Date(nova_data.getTime());
                    pedidosDAO.pedidoCliente.setData_pedido(sqlData);
                } catch (ParseException erro) {
                    JOptionPane.showMessageDialog(null, "Erro ao converter a data");
                    return;
                }
                if (!pedidosDAO.gravar1()) {
                    JOptionPane.showMessageDialog(null, "Erro. Pedido não gravado com sucesso!");
                    return;
                } else {
                    JOptionPane.showMessageDialog(null, "Pedido gravado com sucesso!");
                    tfId_pedido.setText(String.valueOf(pedidosDAO.pedidoCliente.getId()));
                    // novo1, gravar1, alterar1, excluir1, localizar, limpar, baixarEstoque
                    setBotoesPedido(false, false, true, true, false, false, false);
                    setBotoesItem(true, true, false, false, false);
                    setTFItem(false, false);
                    return;
                }
            }
        });

        btExcluir1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (pedidosDAO.excluir1()) {
                    tableModel.setNumRows(0);
                    JOptionPane.showMessageDialog(null, "Pedido excluído com sucesso!");
                    limparCamposPedido();
                    // novo1, gravar1, alterar1, excluir1, localizar, limpar, baixarEstoque
                    setBotoesPedido(true, false, false, false, false, true, false);
                    setBotoesItem(false);
                } else {
                    JOptionPane.showMessageDialog(null, "Não consegui excluír pedido!");
                }
                return;
            }
        });

        btBaixarEstoque.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Date today = Calendar.getInstance().getTime();
                String hojeString = formatoData.format(today);
                java.sql.Date sqlData = java.sql.Date.valueOf(hojeString);
                for (int i = 0; i < listaItens.size(); i++) {
                    listaItens.get(i).setData_entrega(sqlData);
                }
                if (!pedidosDAO.baixarEstoque(listaItens)) {
                    JOptionPane.showMessageDialog(null, "Pedido não baixado!");
                    baixado = true;
                } else {
                    baixado = false;
                    JOptionPane.showMessageDialog(null, "Pedido baixado com sucesso!");
                }
                tableModel.setNumRows(0);
                limparCamposPedido();
                limparCamposItem();
                setTFPedido(false);
                setTFItem(false, false);
                tfId_pedido.setEditable(true);
                // novo1, gravar1, alterar1, excluir1, localizar, limpar, baixarEstoque
                setBotoesPedido(true, false, false, false, true, true, false);
                return;
            }
        });

        /*
        * Eventos dos Itens do Pedido
         */
        btNovo2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                baixado = false;
                limparCamposItem();
                setTFItem(false, true);
                tfId_produto.requestFocus();
            }
        });

        tbPedido.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                if (baixado) {
                    JOptionPane.showMessageDialog(null, "Pedido baixado no estoque,\n"
                            + " não pode alterar nem excluir!");
                    return;
                }
                linha = tbPedido.getSelectedRow();
                System.out.println("Linha do pedido: " + linha);
                if (linha != -1) {
                    tfId_item.setText(String.valueOf(listaItens.get(linha).getId()));
                    tfId_produto.setText(listaItens.get(linha).getId_produto());
                    tfQuantidade.setText(String.valueOf(listaItens.get(linha).getQuantidade()));
                    tfPreco.setText(String.valueOf(listaItens.get(linha).getPreco()));
                    setTFItem(false, true);
                    //btNovo2, btGravar2, btAlterar2, btExcluir2, btLimpar2
                    setBotoesItem(true, false, true, true, true);
                    tfId_produto.requestFocus();
                }
                return;
            }
        });

        btLimpar2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                limparCamposItem();
                //btNovo2, btGravar2, btAlterar2, btExcluir2, btLimpar2
                setBotoesItem(true, false, false, false, false);
                setTFItem(false, false);
                return;
            }
        });

        btAlterar2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Double quantidade = util.spaceToDouble(tfQuantidade.getText());
                if (quantidade <= 0) {
                    JOptionPane.showMessageDialog(null, "Quantidade não pode ser zero!");
                    tfQuantidade.requestFocus();
                    return;
                }
                Double preco = util.spaceToDouble(tfPreco.getText());
                if (preco <= 0) {
                    JOptionPane.showMessageDialog(null, "Preço não pode ser zero!");
                    tfPreco.requestFocus();
                    return;
                }

                if (!pedidosDAO.localizarProduto(tfId_produto.getText())) {
                    JOptionPane.showMessageDialog(null, "Produto não cadastrado!");
                    tfId_produto.requestFocus();
                    return;
                }

                pedidosDAO.itemPedidoClienteEstendida = new ItensPedidoClienteEstendida();

                pedidosDAO.itemPedidoClienteEstendida.setId_pedido_cli(pedidosDAO.pedidoCliente.getId());
                pedidosDAO.itemPedidoClienteEstendida.setId(Integer.parseInt(tfId_item.getText()));
                pedidosDAO.itemPedidoClienteEstendida.setId_produto(tfId_produto.getText());
                pedidosDAO.itemPedidoClienteEstendida.setQuantidade(quantidade);
                pedidosDAO.itemPedidoClienteEstendida.setPreco(preco);
                pedidosDAO.itemPedidoClienteEstendida.setDescricao_produto(pedidosDAO.produto.getDescricao());

                if (!pedidosDAO.alterar2()) {
                    JOptionPane.showMessageDialog(null, "Erro ao gravar alteração!");
                } else {
                    listaItens.get(linha).setId_produto(
                            pedidosDAO.itemPedidoClienteEstendida.getId_produto());
                    listaItens.get(linha).setQuantidade(
                            pedidosDAO.itemPedidoClienteEstendida.getQuantidade());
                    listaItens.get(linha).setPreco(
                            pedidosDAO.itemPedidoClienteEstendida.getPreco());
                    listaItens.get(linha).setDescricao_produto(pedidosDAO.produto.getDescricao());

                    tableModel.setNumRows(0);
                    for (int i = 0; i < listaItens.size(); i++) {
                        tableModel.addRow(new Object[]{
                            listaItens.get(i).getId(),
                            listaItens.get(i).getId_produto(),
                            listaItens.get(i).getDescricao_produto(),
                            listaItens.get(i).getQuantidade(),
                            listaItens.get(i).getPreco(),
                            listaItens.get(i).getQuantidade() * listaItens.get(i).getPreco()
                        });
                    }
                    limparCamposItem();
                    //btNovo2, btGravar2, btAlterar2, btExcluir2, btLimpar2
                    setBotoesItem(true, false, false, false, false);
                    setTFPedido(true);
                    setTFItem(false, false);
                }
                return;
            }
        });

        tfId_produto.addFocusListener(new FocusAdapter() {
            public void focusLost(FocusEvent e) {
                if (!pedidosDAO.localizarProduto(tfId_produto.getText())) {
                    JOptionPane.showMessageDialog(null, "Produto não cadastrado!");
                    tfId_produto.requestFocus();
                    return;
                } else {
                    System.out.println("Preço de venda: " + pedidosDAO.produto.getPreco_venda());
                    tfPreco.setText(String.valueOf(pedidosDAO.produto.getPreco_venda()));
                    return;
                }
            }
        });

        btGravar2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                Double quantidade = util.spaceToDouble(tfQuantidade.getText());
                if (quantidade <= 0) {
                    JOptionPane.showMessageDialog(null, "Quantidade não pode ser zero!");
                    tfQuantidade.requestFocus();
                    return;
                }
                Double preco = util.spaceToDouble(tfPreco.getText());
                if (preco <= 0) {
                    JOptionPane.showMessageDialog(null, "Preço não pode ser zero!");
                    tfPreco.requestFocus();
                    return;
                }

                pedidosDAO.itemPedidoClienteEstendida = new ItensPedidoClienteEstendida();

                pedidosDAO.itemPedidoClienteEstendida.setId_pedido_cli(pedidosDAO.pedidoCliente.getId());
                pedidosDAO.itemPedidoClienteEstendida.setId_produto(tfId_produto.getText());
                pedidosDAO.itemPedidoClienteEstendida.setQuantidade(quantidade);
                pedidosDAO.itemPedidoClienteEstendida.setPreco(preco);
                pedidosDAO.itemPedidoClienteEstendida.setDescricao_produto(pedidosDAO.produto.getDescricao());

                if (pedidosDAO.gravar2()) {
                    tfId_item.setText(String.valueOf(pedidosDAO.itemPedidoClienteEstendida.getId()));
                    numeroItens++;
                    listaItens.add(pedidosDAO.itemPedidoClienteEstendida);
                    // novo1, gravar1, alterar1, excluir1, localizar, limpar, baixarEstoque
                    setBotoesPedido(true, false, true, true, true, true, true);
                    // Inserindo item de pedido de cliente na tabela de itens
                    int cont = listaItens.size() - 1;
                    tableModel.addRow(new Object[]{
                        listaItens.get(cont).getId(),
                        listaItens.get(cont).getId_produto(),
                        listaItens.get(cont).getDescricao_produto(),
                        listaItens.get(cont).getQuantidade(),
                        listaItens.get(cont).getPreco(),
                        listaItens.get(cont).getQuantidade() * listaItens.get(cont).getPreco()
                    });
                    JOptionPane.showMessageDialog(null, "Item gravado com sucesso!");
                    limparCamposItem();
                    setTFItem(false, false);
                } else {
                    JOptionPane.showMessageDialog(null, "Não consegui gravar o Item!");
                }
            }
        });

        btExcluir2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                pedidosDAO.itemPedidoClienteEstendida.setId(Integer.parseInt(tfId_item.getText()));
                if (!pedidosDAO.excluir2()) {
                    JOptionPane.showMessageDialog(null, "Problema ao excluir item!");
                } else {
                    listaItens.remove(linha);
                    tableModel.setNumRows(0);
                    for (int i = 0; i < listaItens.size(); i++) {
                        tableModel.addRow(new Object[]{
                            listaItens.get(i).getId(),
                            listaItens.get(i).getId_produto(),
                            listaItens.get(i).getDescricao_produto(),
                            listaItens.get(i).getQuantidade(),
                            listaItens.get(i).getPreco(),
                            listaItens.get(i).getQuantidade() * listaItens.get(i).getPreco()
                        });
                    }
                }
                return;
            }
        });

    }

    private void setBotoesPedido(boolean novo1, boolean gravar1, boolean alterar1,
            boolean excluir1, boolean localizar, boolean limpar, boolean baixarEstoque) {
        btNovo1.setEnabled(novo1);
        btGravar1.setEnabled(gravar1);
        btAlterar1.setEnabled(alterar1);
        btExcluir1.setEnabled(excluir1);
        btLocalizar.setEnabled(localizar);
        btLimpar.setEnabled(limpar);
        btBaixarEstoque.setEnabled(baixarEstoque);
    }

    private void setBotoesItem(boolean novo2, boolean gravar2, boolean alterar2,
            boolean excluir2, boolean limpar2) {
        btNovo2.setEnabled(novo2);
        btGravar2.setEnabled(gravar2);
        btAlterar2.setEnabled(alterar2);
        btExcluir2.setEnabled(excluir2);
        btLimpar2.setEnabled(limpar2);
    }

    private void setBotoesItem(boolean portas) {
        btNovo2.setEnabled(portas);
        btGravar2.setEnabled(portas);
        btAlterar2.setEnabled(portas);
        btExcluir2.setEnabled(portas);
        btLimpar2.setEnabled(portas);
    }

    private void setTFPedido(boolean portas) {
        //tfId_pedido.setEditable(porta);
        tfId_cliente.setEditable(portas);
        tfId_endereco_entrega.setEditable(portas);
        tfIdCondicao_pag.setEditable(portas);
        tfData_pedido.setEditable(portas);
    }

    private void setTFItem(boolean portaId, boolean portaOutros) {
        tfId_item.setEditable(portaId);
        tfId_produto.setEditable(portaOutros);
        tfQuantidade.setEditable(portaOutros);
        tfPreco.setEditable(portaOutros);
    }

    public void limparCamposPedido() {
        tfId_pedido.setText("");
        tfId_cliente.setText("");
        tfId_endereco_entrega.setText("");
        tfIdCondicao_pag.setText("");
        nova_data = new Date();
        tfData_pedido.setText(formatoData.format(nova_data.getTime()));
        // novo1, gravar1, alterar1, excluir1, localizar, limpar, baixarEstoque
        setBotoesPedido(false, true, false, false, false, true, false);
        setBotoesItem(false);
    }

    public void limparCamposItem() {
        tfId_item.setText("");
        tfId_produto.setText("");
        tfQuantidade.setText("");
        tfPreco.setText("");
        setTFItem(false, true);
        setBotoesItem(true, true, false, false, false);
    }

}

/*
Table: pedidos_cli
Columns:
id varchar(10) PK 
id_cliente varchar(16) 
id_endereco_entrega varchar(10) 
condicao_pag varchar(10) 
data_pedido datetime

Table: item_pedido_cli
Columns:
id varchar(10) PK 
id_pedido_cli varchar(10) 
id_produto varchar(10) 
quantidade double 
unidade varchar(10) 
preco double 
data_entrega datetime
 */
