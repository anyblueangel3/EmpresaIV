package dao;

import empresaiv.BD;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Clientes;
import model.ItensPedidoCliente;
import model.ItensPedidoClienteEstendida;
import model.PedidosCliente;
import model.Produtos;

/**
 *
 * @author Ronaldo Rodrigues Godoi
 */
public class PedidosClienteDAO {
    BD bd;
    private PreparedStatement statement;
    private ResultSet resultSet;
    public String sql;
    public PedidosCliente pedidoCliente;
    public ItensPedidoClienteEstendida itemPedidoClienteEstendida;
    public Produtos produto;
    public Clientes cliente;
    public DateFormat formatoData = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

    public PedidosClienteDAO() {
        cliente = new Clientes();
        pedidoCliente = new PedidosCliente();
        itemPedidoClienteEstendida = new ItensPedidoClienteEstendida();
        produto = new Produtos();
    }

    public boolean localizarProduto(String id_produto) {
        bd = BD.getInstance();
        produto.setId(id_produto);
        sql = "SELECT * FROM produtos WHERE id = ?;";
        try {
            statement = bd.connection.prepareStatement(sql);
            statement.setString(1, produto.getId());
            resultSet = statement.executeQuery();
            if(resultSet.next()) {
                produto.setId(resultSet.getString(1));
                produto.setDescricao(resultSet.getString(2));
                produto.setCategoria(resultSet.getString(3));
                produto.setQuantidade(resultSet.getDouble(4));
                produto.setUnidade(resultSet.getString(5));
                produto.setPreco_venda(resultSet.getDouble(6));
                produto.setPreco_ultima_compra(resultSet.getDouble(7));
                produto.setData_cadastro(resultSet.getString(8));
                itemPedidoClienteEstendida.setPreco(produto.getPreco_venda());
                return true;
            }
        } catch (SQLException erro) {
            System.out.println("erro: " + erro.toString() + sql + produto.getId());
            return false;
        } finally {
            BD.getInstance().close();
        }
        return false;
    }

    public boolean localizarPedido(int id_pedido) {
        bd = BD.getInstance();
        pedidoCliente.setId(id_pedido);
        sql = "SELECT * FROM pedidos_cli WHERE id = ?;";
        try {
            statement = bd.connection.prepareStatement(sql);
            statement.setString(1, String.valueOf(id_pedido));
            resultSet = statement.executeQuery();
            if(resultSet.next()) {
                pedidoCliente.setId(resultSet.getInt(1));
                pedidoCliente.setId_cliente(resultSet.getString(2));
                pedidoCliente.setId_endereco_entrega(resultSet.getString(3));
                pedidoCliente.setCondicao_pag(resultSet.getString(4));
                pedidoCliente.setData_pedido(resultSet.getDate(5));
                return true;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Problemas na localização!\n" + e);
            return false;
        } finally {
            BD.getInstance().close();
        }
        return false;
    }
    
    public ArrayList<ItensPedidoClienteEstendida> carregarListaItens() {
        ArrayList<ItensPedidoClienteEstendida> listaItens = new ArrayList<>();
        ItensPedidoClienteEstendida itemPedido;
        bd = BD.getInstance();
        sql = "SELECT i.id,"
                + " i.id_pedido_cli,"
                + " i.id_produto,"
                + " i.quantidade,"
                + " i.preco,"
                + " i.data_entrega,"
                + " p.descricao FROM item_pedido_cli AS i LEFT JOIN produtos AS p"
                + " ON  i.id_produto = p.id"
                + " WHERE i.id_pedido_cli = ?;";
        try {
            statement = bd.connection.prepareStatement(sql);
            statement.setString(1, String.valueOf(pedidoCliente.getId()));
            resultSet = statement.executeQuery();
            int numeroItem = 0;
            while(resultSet.next()) {
                numeroItem++;
                itemPedido = new ItensPedidoClienteEstendida();
                itemPedido.setId(resultSet.getInt(1));
                itemPedido.setId_pedido_cli(resultSet.getInt(2));
                itemPedido.setId_produto(resultSet.getString(3));
                itemPedido.setQuantidade(resultSet.getDouble(4));
                itemPedido.setPreco(resultSet.getDouble(5));
                itemPedido.setData_entrega(resultSet.getDate(6));
                itemPedido.setNumero_item(numeroItem);
                itemPedido.setDescricao_produto(resultSet.getString(7));
                listaItens.add(itemPedido);
            }
            System.out.println("numeroItem = " + numeroItem);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Problemas na localização dos itens!\n" + e);
        } finally {
            BD.getInstance().close();
        }
        return listaItens;
    }
    
    public boolean alterar1() {
        bd = BD.getInstance();
        try {
            sql = "UPDATE pedidos_cli SET id_cliente = ?,"
                    + " id_endereco_entrega = ?,"
                    + " condicao_pag = ?,"
                    + " data_pedido = ?"
               + " WHERE id = ?;";
            PreparedStatement statement = bd.connection.prepareStatement(sql);
            statement.setString(1, pedidoCliente.getId_cliente());
            statement.setString(2, pedidoCliente.getId_endereco_entrega());
            statement.setString(3, pedidoCliente.getCondicao_pag());
            statement.setDate(4, (Date) pedidoCliente.getData_pedido());
            statement.setInt(5, pedidoCliente.getId());
            statement.executeUpdate();
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "erro: " + erro.toString() + " \n" + sql);
            return false;
        } finally {
            BD.getInstance().close();
        }
        return true;
    }
    
    public boolean gravar1() {
        bd = BD.getInstance();
        try {
            sql = "insert into pedidos_cli (id_cliente,"
                    + " id_endereco_entrega,"
                    + " condicao_pag,"
                    + " data_pedido)"
                    + " values (?, ?, ?, ?)";
            PreparedStatement statement = bd.connection.prepareStatement(sql,
                    Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, pedidoCliente.getId_cliente());
            statement.setString(2, pedidoCliente.getId_endereco_entrega());
            statement.setString(3, pedidoCliente.getCondicao_pag());
            statement.setDate(4, (Date) pedidoCliente.getData_pedido());
            statement.executeUpdate();
            resultSet = statement.getGeneratedKeys();
            if (resultSet != null && resultSet.next()) {
                pedidoCliente.setId(resultSet.getInt(1));
            } else {
                System.out.println("Não inseriu");
                return false;
            }
        } catch (SQLException erro) {
            System.out.println("erro: " + erro.toString() + " " + sql);
            return false;
        } finally {
            BD.getInstance().close();
        }
        return true;
    }
    
    public boolean excluir1() {
        bd = BD.getInstance();
        try {
            sql = "DELETE FROM pedidos_cli WHERE id = ?;";
            PreparedStatement statement = bd.connection.prepareStatement(sql);
            statement.setInt(1, pedidoCliente.getId());
            statement.executeUpdate();
            sql = "DELETE FROM item_pedido_cli WHERE id_pedido_cli = ?;";
            PreparedStatement statement2 = bd.connection.prepareStatement(sql);
            statement2.setInt(1, pedidoCliente.getId());
            statement2.executeUpdate();
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Erro ao excluír! \n" + erro);
            return false;
        } finally {
            BD.getInstance().close();
        }
        return true;
    }

    public boolean alterar2() {
        bd = BD.getInstance();
        try {
            sql = "UPDATE item_pedido_cli SET"
                    + " id_produto = ?,"
                    + " quantidade = ?,"
                    + " preco = ?"
               + " WHERE id = ?;";
            PreparedStatement statement = bd.connection.prepareStatement(sql);
            statement.setString(1, itemPedidoClienteEstendida.getId_produto());
            statement.setDouble(2, itemPedidoClienteEstendida.getQuantidade());
            statement.setDouble(3, itemPedidoClienteEstendida.getPreco());
            statement.setInt(4, itemPedidoClienteEstendida.getId());
            //statement.setDate(5, (Date) itemPedidoClienteEstendida.getData_entrega());
            statement.executeUpdate();
            return true;
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Erro ao gravar alteração de item!\n"
            + erro);
        } finally {
            BD.getInstance().close();
        }
        return false;
    }
    
    public boolean gravar2() {
        bd = BD.getInstance();
        try {
            sql = "insert into item_pedido_cli (id_pedido_cli,"
                    + " id_produto,"
                    + " quantidade,"
                    + " preco)"
                    + " values (?, ?, ?, ?)";
            PreparedStatement statement = bd.connection.prepareStatement(sql,
                    Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, pedidoCliente.getId());
            statement.setString(2, itemPedidoClienteEstendida.getId_produto());
            statement.setDouble(3, itemPedidoClienteEstendida.getQuantidade());
            statement.setDouble(4, itemPedidoClienteEstendida.getPreco());
            //statement.setDate(5, (Date) itemPedidoClienteEstendida.getData_entrega());
            statement.executeUpdate();
            resultSet = statement.getGeneratedKeys();
            if (resultSet != null && resultSet.next()) {
                itemPedidoClienteEstendida.setId(resultSet.getInt(1));
            } else {
                System.out.println("Não inseriu");
                return false;
            }
        } catch (SQLException erro) {
            System.out.println("erro: " + erro.toString() + " " + sql);
            return false;
        } finally {
            BD.getInstance().close();
        }
        return true;
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