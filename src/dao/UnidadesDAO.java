package dao;

import model.Unidades;
import empresaiv.BD;
import java.sql.*;

/**
 *
 * @author Ronaldo R. Godoi
 */
public class UnidadesDAO {
    
    public Unidades unidade;
    public BD bd;
    private PreparedStatement statement;
    private ResultSet resultSet;
    private String men, sql;
    public static final byte INCLUSAO = 1;
    public static final byte ALTERACAO = 2;
    public static final byte EXCLUSAO = 3;
    
    public UnidadesDAO() {
        bd = BD.getInstance();
        unidade = new Unidades();
    }
    
    public boolean localizar() {
        sql = "select * from unidades where id = ?";
        try {
            statement = bd.connection.prepareStatement(sql);
            statement.setString(1, unidade.getId());
            resultSet = statement.executeQuery();
            resultSet.next();
            unidade.setId(resultSet.getString(1));
            unidade.setDescricao(resultSet.getString(2));
            unidade.setData_cadastro(resultSet.getString(3));
            return true;
        } catch(SQLException erro) {
            System.out.println("erro: " + erro.toString() + sql + unidade.getId());
            return false;
        }
    }
    
    public String atualizar(int operacao) {
        men = "Operação realizada com sucesso!";
        try {
            if(operacao == INCLUSAO) {
                sql = "insert into unidades values (?, ?, ?)";                
                statement = bd.connection.prepareStatement(sql);
                statement.setString(1, unidade.getId());
                statement.setString(2, unidade.getDescricao());
                statement.setString(3, unidade.getData_cadastro());
            } else if(operacao == ALTERACAO) {
                sql = "update unidades set descricao = ?,"
                    + " data_cadastro = ? where id = ?";
                statement = bd.connection.prepareStatement(sql);
                statement.setString(1, unidade.getDescricao());
                statement.setString(2, unidade.getData_cadastro());
                statement.setString(3, unidade.getId());
            } else if(operacao == EXCLUSAO) {
                sql = "delete from unidades where id = ?";
                statement = bd.connection.prepareStatement(sql);
                statement.setString(1, unidade.getId());
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
Table: unidades
Columns:
id varchar(10) PK 
descricao varchar(40) 
data_cadastro datetime
*/