package dao;

import model.Produtos;
import empresaiv.BD;
import java.sql.*;

/**
 *
 * @author Ronaldo R. Godoi
 */
public class ProDAO {
    
    public Produtos produto;
    public BD bd;
    private PreparedStatement statement;
    private ResultSet resultSet;
    private String men, sql;
    public static final byte INCLUSAO = 1;
    public static final byte ALTERACAO = 2;
    public static final byte EXCLUSAO = 3;
    
    public ProDAO() {
        bd = BD.getInstance();
        produto = new Produtos();
    }
    
    public boolean localizar() {
        sql = "select * from produtos where id = ?";
        try {
            statement = bd.connection.prepareStatement(sql);
            statement.setString(1, produto.getId());
            resultSet = statement.executeQuery();
            resultSet.next();
            
            produto.setId(resultSet.getString(1));
            produto.setDescricao(resultSet.getString(2));
            produto.setCategoria(resultSet.getString(3));
            produto.setQuantidade(Double.parseDouble(resultSet.getString(4)));
            produto.setUnidade(resultSet.getString(5));
            produto.setPreco_venda(Double.parseDouble(resultSet.getString(6)));
            produto.setPreco_ultima_compra(Double.parseDouble(resultSet.getString(7)));
            produto.setData_cadastro(resultSet.getString(8));
            return true;
        } catch(SQLException erro) {
            System.out.println("erro: " + erro.toString() + sql + produto.getId());
            return false;
        }
    }
    
    public String atualizar(int operacao) {
        men = "Operação realizada com sucesso!";
        try {
            if(operacao == INCLUSAO) {
                sql = "insert into produtos values (?, ?, ?, ?, ?, ?, ? , ?)";                
                statement = bd.connection.prepareStatement(sql);
                statement.setString(1, produto.getId());
                statement.setString(2, produto.getDescricao());
                statement.setString(3, produto.getCategoria());
                statement.setString(4, produto.getQuantidade().toString());
                statement.setString(5, produto.getUnidade());
                statement.setString(6, produto.getPreco_venda().toString());
                statement.setString(7, produto.getPreco_ultima_compra().toString());
                statement.setString(8, produto.getData_cadastro());
            } else if(operacao == ALTERACAO) {
                sql = "update produtos set descricao = ?,"
                        + " categoria = ?,"
                        + " quantidade = ?,"
                        + " unidade = ?,"
                        + " preco_venda = ?,"
                        + " preco_ultima_compra = ?,"
                        + " data_cadastro = ? where id = ?";
                statement = bd.connection.prepareStatement(sql);
                statement.setString(8, produto.getId());
                statement.setString(1, produto.getDescricao());
                statement.setString(2, produto.getCategoria());
                statement.setString(3, produto.getQuantidade().toString());
                statement.setString(4, produto.getUnidade());
                statement.setString(5, produto.getPreco_venda().toString());
                statement.setString(6, produto.getPreco_ultima_compra().toString());
                statement.setString(7, produto.getData_cadastro());
            } else if(operacao == EXCLUSAO) {
                sql = "delete from produtos where id = ?";
                statement = bd.connection.prepareStatement(sql);
                statement.setString(1, produto.getId());
            }
            
            if(statement.executeUpdate() == 0) {
                men = "Falha na operação!";
            }
            
        } catch (SQLException erro) {
            men = "Falha na operação! " + erro.toString()+" "+sql;
        }
        
        return men;
        
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