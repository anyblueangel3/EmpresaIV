package dao;

import model.For_entregas;
import empresaiv.BD;
import java.sql.*;

/**
 *
 * @author Ronaldo Rodrigues Godoi
 */
public class EndEntForDAO {
    
    public For_entregas for_entrega;
    public BD bd;
    private PreparedStatement statement;
    private ResultSet resultSet;
    private String men, sql;
    public static final byte INCLUSAO = 1;
    public static final byte ALTERACAO = 2;
    public static final byte EXCLUSAO = 3;
    
    public EndEntForDAO() {
        bd = BD.getInstance();
        for_entrega = new For_entregas();
    }
    
    public boolean localizar() {
        sql = "select * from for_entrega where id = ?";
        try {
            statement = bd.connection.prepareStatement(sql);
            statement.setString(1, for_entrega.getId());
            resultSet = statement.executeQuery();
            resultSet.next();
            for_entrega.setId_fornecedor(resultSet.getString(2));
            for_entrega.setTelefone(resultSet.getString(3));
            for_entrega.setCep(resultSet.getString(4));
            for_entrega.setEndereco(resultSet.getString(5));
            for_entrega.setNumero(resultSet.getString(6));
            for_entrega.setComplemento(resultSet.getString(7));
            for_entrega.setBairro(resultSet.getString(8));
            for_entrega.setCidade(resultSet.getString(9));
            for_entrega.setEstado(resultSet.getString(10));
            return true;
        } catch(SQLException erro) {
            System.out.println("erro: " + erro.toString() + sql + for_entrega.getId());
            return false;
        }
    }
    
    public String atualizar(int operacao) {
        men = "Operação realizada com sucesso!";
        try {
            if(operacao == INCLUSAO) {
                sql = "insert into for_entrega values (?, ?, ?, ?, ?, ?, ? , ?, ?, ?)";                
                statement = bd.connection.prepareStatement(sql);
                statement.setString(1, for_entrega.getId());
                statement.setString(2, for_entrega.getId_fornecedor());
                statement.setString(3, for_entrega.getTelefone());
                statement.setString(4, for_entrega.getCep());
                statement.setString(5, for_entrega.getEndereco());
                statement.setString(6, for_entrega.getNumero());
                statement.setString(7, for_entrega.getComplemento());
                statement.setString(8, for_entrega.getBairro());
                statement.setString(9, for_entrega.getCidade());
                statement.setString(10, for_entrega.getEstado());    
            } else if(operacao == ALTERACAO) {
                sql = "update for_entrega set id_fornecedor = ?,"
                        + " telefone = ?,"
                        + " cep = ?,"
                        + " endereco = ?,"
                        + " numero = ?,"
                        + " complemento = ?,"
                        + " bairro = ?,"
                        + " cidade = ?,"
                        + " estado = ? where id = ?";
                statement = bd.connection.prepareStatement(sql);
                statement.setString(10, for_entrega.getId());
                statement.setString(1, for_entrega.getId_fornecedor());
                statement.setString(2, for_entrega.getTelefone());
                statement.setString(3, for_entrega.getCep());
                statement.setString(4, for_entrega.getEndereco());
                statement.setString(5, for_entrega.getNumero());
                statement.setString(6, for_entrega.getComplemento());
                statement.setString(7, for_entrega.getBairro());
                statement.setString(8, for_entrega.getCidade());
                statement.setString(9, for_entrega.getEstado());
            } else if(operacao == EXCLUSAO) {
                sql = "delete from for_entrega where id = ?";
                statement = bd.connection.prepareStatement(sql);
                statement.setString(1, for_entrega.getId());
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
Table: cli_entrega
Columns:
id varchar(10) PK 
id_fornecedor varchar(16) 
telefone varchar(20) 
cep varchar(9) 
endereco varchar(60) 
numero int 
complemento varchar(40) 
bairro varchar(60) 
cidade varchar(40) 
estado varchar(2)
*/
