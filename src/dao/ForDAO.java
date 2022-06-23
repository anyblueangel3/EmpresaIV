package dao;

import model.Fornecedores;
import empresaiv.BD;
import java.sql.*;

/**
 *
 * @author Ronaldo R. Godoi
 */
public class ForDAO {
    
    public Fornecedores fornecedor;
    public BD bd;
    private PreparedStatement statement;
    private ResultSet resultSet;
    private String men, sql;
    public static final byte INCLUSAO = 1;
    public static final byte ALTERACAO = 2;
    public static final byte EXCLUSAO = 3;
    
    public ForDAO() {
        bd = BD.getInstance();
        fornecedor = new Fornecedores();
    }
    
    public boolean localizar() {
        sql = "select * from fornecedores where id_cgc_cpf = ?";
        try {
            statement = bd.connection.prepareStatement(sql);
            statement.setString(1, fornecedor.getId_cgc_cpf());
            resultSet = statement.executeQuery();
            resultSet.next();
            fornecedor.setId_cgc_cpf(resultSet.getString(1));
            fornecedor.setFisica_juridica(resultSet.getString(2));
            fornecedor.setNome_razao(resultSet.getString(3));
            fornecedor.setEmail(resultSet.getString(4));
            fornecedor.setTelefone(resultSet.getString(5));
            fornecedor.setCep(resultSet.getString(6));
            fornecedor.setEndereco(resultSet.getString(7));
            fornecedor.setNumero(resultSet.getString(8));
            fornecedor.setComplemento(resultSet.getString(9));
            fornecedor.setBairro(resultSet.getString(10));
            fornecedor.setCidade(resultSet.getString(11));
            fornecedor.setEstado(resultSet.getString(12));
            fornecedor.setData_cadastro("" + resultSet.getString(13));
            return true;
        } catch(SQLException erro) {
            System.out.println("erro: " + erro.toString() + sql + fornecedor.getId_cgc_cpf());
            return false;
        }
    }
    
    public String atualizar(int operacao) {
        men = "Operação realizada com sucesso!";
        try {
            if(operacao == INCLUSAO) {
                sql = "insert into fornecedores values (?, ?, ?, ?, ?, ?, ? , ?, ?, ?, ?, ?, ?)";                
                statement = bd.connection.prepareStatement(sql);
                
                statement.setString(1, fornecedor.getId_cgc_cpf());
                statement.setString(2, fornecedor.getFisica_juridica());
                statement.setString(3, fornecedor.getNome_razao());
                statement.setString(4, fornecedor.getEmail());
                statement.setString(5, fornecedor.getTelefone());
                statement.setString(6, fornecedor.getCep());
                statement.setString(7, fornecedor.getEndereco());
                statement.setString(8, fornecedor.getNumero());
                statement.setString(9, fornecedor.getComplemento());
                statement.setString(10, fornecedor.getBairro());
                statement.setString(11, fornecedor.getCidade());
                statement.setString(12, fornecedor.getEstado());
                statement.setString(13, fornecedor.getData_cadastro());
                
            } else if(operacao == ALTERACAO) {
                sql = "update fornecedores set fisica_juridica = ?,"
                        + " nome_razao = ?,"
                        + " email = ?,"
                        + " telefone = ?,"
                        + " cep = ?,"
                        + " endereco = ?,"
                        + " numero = ?,"
                        + " complemento = ?,"
                        + " bairro = ?,"
                        + " cidade = ?,"
                        + " estado = ?,"
                        + " data_cadastro = ? where id_cgc_cpf = ?";
                statement = bd.connection.prepareStatement(sql);
                statement.setString(13, fornecedor.getId_cgc_cpf());
                statement.setString(1, fornecedor.getFisica_juridica());
                statement.setString(2, fornecedor.getNome_razao());
                statement.setString(3, fornecedor.getEmail());
                statement.setString(4, fornecedor.getTelefone());
                statement.setString(5, fornecedor.getCep());
                statement.setString(6, fornecedor.getEndereco());
                statement.setString(7, fornecedor.getNumero());
                statement.setString(8, fornecedor.getComplemento());
                statement.setString(9, fornecedor.getBairro());
                statement.setString(10, fornecedor.getCidade());
                statement.setString(11, fornecedor.getEstado());
                statement.setString(12, fornecedor.getData_cadastro());
            } else if(operacao == EXCLUSAO) {
                sql = "delete from fornecedores where id_cgc_cpf = ?";
                statement = bd.connection.prepareStatement(sql);
                statement.setString(1, fornecedor.getId_cgc_cpf());
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
Columns:
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