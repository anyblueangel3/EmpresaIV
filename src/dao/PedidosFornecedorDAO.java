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
import model.Fornecedores;
import model.ItensPedidoFornecedorEstendida;
import model.PedidosFornecedor;
import model.Produtos;

/**
 *
 * @author Ronaldo Rodrigues Godoi
 */
public class PedidosFornecedorDAO {
    BD bd;
    private PreparedStatement statement;
    private ResultSet resultSet;
    public String sql;
    public PedidosFornecedor pedidoFornecedor;
    public ItensPedidoFornecedorEstendida itemPedidoFornecedorEstendida;
    public Produtos produto;
    public Fornecedores fornecedor;
    public DateFormat formatoData = new SimpleDateFormat("yyyy-MM-dd");

    public PedidosFornecedorDAO() {
        fornecedor = new Fornecedores();
        pedidoFornecedor = new PedidosFornecedor();
        itemPedidoFornecedorEstendida = new ItensPedidoFornecedorEstendida();
        produto = new Produtos();
    }
    // Parei aqui...
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
                itemPedidoFornecedorEstendida.setPreco(produto.getPreco_venda());
                itemPedidoFornecedorEstendida.setDescricao_produto(produto.getDescricao());
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
        pedidoFornecedor.setId(id_pedido);
        sql = "SELECT * FROM pedidos_for WHERE id = ?;";
        try {
            statement = bd.connection.prepareStatement(sql);
            statement.setString(1, String.valueOf(id_pedido));
            resultSet = statement.executeQuery();
            if(resultSet.next()) {
                pedidoFornecedor.setId(resultSet.getInt(1));
                pedidoFornecedor.setId_fornecedor(resultSet.getString(2));
                pedidoFornecedor.setId_endereco_entrega(resultSet.getString(3));
                pedidoFornecedor.setCondicao_pag(resultSet.getString(4));
                pedidoFornecedor.setData_pedido(resultSet.getDate(5));
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
    
    public ArrayList<ItensPedidoFornecedorEstendida> carregarListaItens() {
        ArrayList<ItensPedidoFornecedorEstendida> listaItens = new ArrayList<>();
        ItensPedidoFornecedorEstendida itemPedido;
        bd = BD.getInstance();
        sql = "SELECT f.id,"
                + " f.id_pedido_for,"
                + " f.id_produto,"
                + " f.quantidade,"
                + " f.preco,"
                + " f.data_entrega,"
                + " p.descricao FROM item_pedido_for AS f LEFT JOIN produtos AS p"
                + " ON  f.id_produto = p.id"
                + " WHERE f.id_pedido_for = ?;";
        try {
            statement = bd.connection.prepareStatement(sql);
            statement.setString(1, String.valueOf(pedidoFornecedor.getId()));
            resultSet = statement.executeQuery();
            int numeroItem = 0;
            while(resultSet.next()) {
                numeroItem++;
                itemPedido = new ItensPedidoFornecedorEstendida();
                itemPedido.setId(resultSet.getInt(1));
                itemPedido.setId_pedido_for(resultSet.getInt(2));
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
            sql = "UPDATE pedidos_for SET id_fornecedor = ?,"
                    + " id_endereco_entrega = ?,"
                    + " condicao_pag = ?,"
                    + " data_pedido = ?"
               + " WHERE id = ?;";
            PreparedStatement statement = bd.connection.prepareStatement(sql);
            statement.setString(1, pedidoFornecedor.getId_fornecedor());
            statement.setString(2, pedidoFornecedor.getId_endereco_entrega());
            statement.setString(3, pedidoFornecedor.getCondicao_pag());
            statement.setDate(4, (Date) pedidoFornecedor.getData_pedido());
            statement.setInt(5, pedidoFornecedor.getId());
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
            sql = "INSERT INTO pedidos_for (id_fornecedor,"
                    + " id_endereco_entrega,"
                    + " condicao_pag,"
                    + " data_pedido)"
                    + " VALUES (?, ?, ?, ?)";
            PreparedStatement statement = bd.connection.prepareStatement(sql,
                    Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, pedidoFornecedor.getId_fornecedor());
            statement.setString(2, pedidoFornecedor.getId_endereco_entrega());
            statement.setString(3, pedidoFornecedor.getCondicao_pag());
            statement.setDate(4, (Date) pedidoFornecedor.getData_pedido());
            statement.executeUpdate();
            resultSet = statement.getGeneratedKeys();
            if (resultSet != null && resultSet.next()) {
                pedidoFornecedor.setId(resultSet.getInt(1));
            } else {
                JOptionPane.showMessageDialog(null, "Não inseriu!");
                return false;
            }
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir: " + erro.toString() + "\n" + sql);
            return false;
        } finally {
            BD.getInstance().close();
        }
        return true;
    }
    
    public boolean excluir1() {
        bd = BD.getInstance();
        try {
            sql = "DELETE FROM pedidos_for WHERE id = ?;";
            PreparedStatement statement = bd.connection.prepareStatement(sql);
            statement.setInt(1, pedidoFornecedor.getId());
            statement.executeUpdate();
            sql = "DELETE FROM item_pedido_for WHERE id_pedido_for = ?;";
            PreparedStatement statement2 = bd.connection.prepareStatement(sql);
            statement2.setInt(1, pedidoFornecedor.getId());
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
            sql = "UPDATE item_pedido_for SET"
                    + " id_produto = ?,"
                    + " quantidade = ?,"
                    + " preco = ?"
               + " WHERE id = ?;";
            PreparedStatement statement = bd.connection.prepareStatement(sql);
            statement.setString(1, itemPedidoFornecedorEstendida.getId_produto());
            statement.setDouble(2, itemPedidoFornecedorEstendida.getQuantidade());
            statement.setDouble(3, itemPedidoFornecedorEstendida.getPreco());
            statement.setInt(4, itemPedidoFornecedorEstendida.getId());
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
            sql = "INSERT INTO item_pedido_for (id_pedido_for,"
                    + " id_produto,"
                    + " quantidade,"
                    + " preco)"
                    + " VALUES (?, ?, ?, ?)";
            PreparedStatement statement = bd.connection.prepareStatement(sql,
                    Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, pedidoFornecedor.getId());
            statement.setString(2, itemPedidoFornecedorEstendida.getId_produto());
            statement.setDouble(3, itemPedidoFornecedorEstendida.getQuantidade());
            statement.setDouble(4, itemPedidoFornecedorEstendida.getPreco());
            statement.executeUpdate();
            resultSet = statement.getGeneratedKeys();
            if (resultSet != null && resultSet.next()) {
                itemPedidoFornecedorEstendida.setId(resultSet.getInt(1));
            } else {
                JOptionPane.showMessageDialog(null, "Não inseriu!");
                return false;
            }
        } catch (SQLException erro) {
            System.out.println("Erro ao inserir item: " + erro.toString() + "\n" + sql);
            return false;
        } finally {
            BD.getInstance().close();
        }
        return true;
    }
    
    public boolean excluir2() {
        bd = BD.getInstance();
        try {
            sql = "DELETE FROM item_pedido_for WHERE id = ?;";
            PreparedStatement statement = bd.connection.prepareStatement(sql);
            statement.setInt(1, itemPedidoFornecedorEstendida.getId());
            statement.executeUpdate();
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir item!\n" + erro);
            return false;
        } finally {
            BD.getInstance().close();
        }
        return true;
    }

    public boolean baixarEstoque(ArrayList<ItensPedidoFornecedorEstendida> listaItens) {
        if(listaItens.size() == 0) {
            JOptionPane.showMessageDialog(null, "Lista de itens vazia! Inclua itens ou apague pedido.");
            return false;
        }
        bd = BD.getInstance();
        try {
            for(int i = 0; i < listaItens.size(); i++) {
                sql = "UPDATE produtos SET quantidade = (quantidade + ?),"
                        + " preco_ultima_compra = ?"
                    + " WHERE id = ?;";
                PreparedStatement statement = bd.connection.prepareStatement(sql);
                statement.setDouble(1, listaItens.get(i).getQuantidade());
                statement.setDouble(2, listaItens.get(i).getPreco());
                statement.setString(3, listaItens.get(i).getId_produto());
                statement.executeUpdate();
                sql = "UPDATE item_pedido_for SET data_entrega = ?"
                    + " WHERE id = ?;";
                PreparedStatement statement2 = bd.connection.prepareStatement(sql);
                statement2.setDate(1, listaItens.get(i).getData_entrega());
                statement2.setInt(2, listaItens.get(i).getId());
                statement2.executeUpdate();
            }
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Erro ao baixar estoque!\n" + erro);
            return false;
        } finally {
            BD.getInstance().close();
        }
        return true;
    }
    
    public boolean pedidoBaixado() {
        bd = BD.getInstance();
        try {
            sql = "SELECT data_entrega FROM item_pedido_for WHERE id_pedido_for = ?;";
            PreparedStatement statement = bd.connection.prepareStatement(sql);
            statement.setInt(1, pedidoFornecedor.getId());
            resultSet = statement.executeQuery();
            if(resultSet.next()) {
                itemPedidoFornecedorEstendida.setData_entrega(resultSet.getDate(1));
                if(itemPedidoFornecedorEstendida.getData_entrega() == null) {
                    return true;
                } else {
                    return false;
                }
            } else {
                JOptionPane.showMessageDialog(null, "Pedido sem itens cadastrados, exclua pedido!");
                return false;
            }
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Erro ao localizar entrega de pedido!\n" + erro);
            return true;
        } finally {
            BD.getInstance().close();
        }
    }
}