package dao;

import model.Usuarios;
import empresaiv.BD;
import java.sql.*;

/**
 *
 * @author Ronaldo R. Godoi
 */
public class UsuariosDAO {
    
    public Usuarios usuario;
    public BD bd;
    private PreparedStatement statement;
    private ResultSet resultSet;
    private String men, sql;
    public static final byte INCLUSAO = 1;
    public static final byte ALTERACAO = 2;
    public static final byte EXCLUSAO = 3;
    
    public UsuariosDAO() {
        bd = BD.getInstance();
        usuario = new Usuarios();
    }
    
    public boolean localizar() {
        sql = "select * from usuarios where nome = ?";
        try {
            statement = bd.connection.prepareStatement(sql);
            statement.setString(1, String.valueOf(usuario.getNome()));
            resultSet = statement.executeQuery();
            resultSet.next();
            usuario.setId(resultSet.getInt(1));
            usuario.setNome(resultSet.getString(2));
            usuario.setSenha(resultSet.getString(3));
            usuario.setCadastroClientes(resultSet.getBoolean(4));
            usuario.setCadastroFornecedores(resultSet.getBoolean(5));
            usuario.setCadastroProdutos(resultSet.getBoolean(6));
            usuario.setCadastroCategoria(resultSet.getBoolean(7));
            usuario.setCadastroEnderecoEntregaCliente(resultSet.getBoolean(8));
            usuario.setCadastroEnderecoEntregaFornecedor(resultSet.getBoolean(9));
            usuario.setCadastroFornecedoresProduto(resultSet.getBoolean(10));
            usuario.setCadastroUnidades(resultSet.getBoolean(11));
            usuario.setPedidoCliente(resultSet.getBoolean(12));
            usuario.setPedidoFornecedor(resultSet.getBoolean(13));
            usuario.setConsultaClientes(resultSet.getBoolean(14));
            usuario.setConsultaFornecedor(resultSet.getBoolean(15));
            usuario.setConsultaProduto(resultSet.getBoolean(16));
            usuario.setConsultaCategoria(resultSet.getBoolean(17));
            usuario.setConsultaEnderecoEntregaCliente(resultSet.getBoolean(18));
            usuario.setConsultaEnderecoEntregaFornecedor(resultSet.getBoolean(19));
            usuario.setRelatorioClientes(resultSet.getBoolean(20));
            usuario.setRelatorioFornecedor(resultSet.getBoolean(21));
            usuario.setRelatorioProduto(resultSet.getBoolean(22));
            usuario.setRelatorioCategoria(resultSet.getBoolean(23));
            usuario.setRelatorioUnidades(resultSet.getBoolean(24));
            return true;
        } catch(SQLException erro) {
            System.out.println("erro: " + erro.toString() + sql + usuario.getId());
            return false;
        }
    }

    public String atualizar(int operacao) {
        men = "Operação realizada com sucesso!";
        try {
            if(operacao == INCLUSAO) {
                sql = "insert into usuarios (nome, "
                        + " senha,"
                        + " cadastroClientes,"
                        + " cadastroFornecedores,"
                        + " cadastroProdutos,"
                        + " cadastroCategoria,"
                        + " cadastroEnderecoEntregaCliente,"
                        + " cadastroEnderecoEntregaFornecedor,"
                        + " cadastroFornecedoresProduto,"
                        + " cadastroUnidades,"
                        + " pedidoCliente,"
                        + " pedidoFornecedor,"
                        + " consultaClientes,"
                        + " consultaFornecedor,"
                        + " consultaProduto,"
                        + " consultaCategoria,"
                        + " consultaEnderecoEntregaCliente,"
                        + " consultaEnderecoEntregaFornecedor,"
                        + " relatorioClientes,"
                        + " relatorioFornecedor,"
                        + " relatorioProduto,"
                        + " relatorioCategoria,"
                        + " relatorioUnidades)"
                        + " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?,"
                        + " ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,"
                        + " ?, ?, ?)";
                statement = bd.connection.prepareStatement(sql);
                statement.setString(1,usuario.getNome());
                statement.setString(2,usuario.getSenha());
                statement.setBoolean(3,usuario.isCadastroClientes());
                statement.setBoolean(4,usuario.isCadastroFornecedores());
                statement.setBoolean(5,usuario.isCadastroProdutos());
                statement.setBoolean(6,usuario.isCadastroCategoria());
                statement.setBoolean(7,usuario.isCadastroEnderecoEntregaCliente());
                statement.setBoolean(8,usuario.isCadastroEnderecoEntregaFornecedor());
                statement.setBoolean(9,usuario.isCadastroFornecedoresProduto());
                statement.setBoolean(10,usuario.isCadastroUnidades());
                statement.setBoolean(11,usuario.isPedidoCliente());
                statement.setBoolean(12,usuario.isPedidoFornecedor());
                statement.setBoolean(13,usuario.isConsultaClientes());
                statement.setBoolean(14,usuario.isConsultaFornecedor());
                statement.setBoolean(15,usuario.isConsultaProduto());
                statement.setBoolean(16,usuario.isConsultaCategoria());
                statement.setBoolean(17,usuario.isConsultaEnderecoEntregaCliente());
                statement.setBoolean(18,usuario.isConsultaEnderecoEntregaFornecedor());
                statement.setBoolean(19,usuario.isRelatorioClientes());
                statement.setBoolean(20,usuario.isRelatorioFornecedor());
                statement.setBoolean(21,usuario.isRelatorioProduto());
                statement.setBoolean(22,usuario.isRelatorioCategoria());
                statement.setBoolean(23,usuario.isRelatorioUnidades());
            } else if(operacao == ALTERACAO) {
                sql = "update usuarios set nome = ?,"
                    + " senha = ?,"
                    + " cadastroClientes = ?, "
                    + " cadastroFornecedores = ?,"
                    + " cadastroProdutos = ?,"
                    + " cadastroCategoria = ?,"
                    + " cadastroEnderecoEntregaCliente = ?,"
                    + " cadastroEnderecoEntregaFornecedor = ?,"
                    + " cadastroFornecedoresProduto = ?,"
                    + " cadastroUnidades = ?,"
                    + " pedidoCliente = ?,"
                    + " pedidoFornecedor = ?,"
                    + " consultaClientes = ?,"
                    + " consultaFornecedor = ?,"
                    + " consultaProduto = ?,"
                    + " consultaCategoria = ?,"
                    + " consultaEnderecoEntregaCliente = ?,"
                    + " consultaEnderecoEntregaFornecedor = ?,"
                    + " relatorioClientes = ?,"
                    + " relatorioFornecedor = ?,"
                    + " relatorioProduto = ?,"
                    + " relatorioCategoria = ?,"
                    + " relatorioUnidades = ?"
                    + " where id = ?";
                statement = bd.connection.prepareStatement(sql);
                statement.setString(1, usuario.getNome());
                statement.setString(2, usuario.getSenha());
                statement.setBoolean(3, usuario.isCadastroClientes());
                statement.setBoolean(4, usuario.isCadastroFornecedores());
                statement.setBoolean(5, usuario.isCadastroProdutos());
                statement.setBoolean(6, usuario.isCadastroCategoria());
                statement.setBoolean(7, usuario.isCadastroEnderecoEntregaCliente());
                statement.setBoolean(8, usuario.isCadastroEnderecoEntregaFornecedor());
                statement.setBoolean(9, usuario.isCadastroFornecedoresProduto());
                statement.setBoolean(10, usuario.isCadastroUnidades());
                statement.setBoolean(11, usuario.isPedidoCliente());
                statement.setBoolean(12, usuario.isPedidoFornecedor());
                statement.setBoolean(13, usuario.isConsultaClientes());
                statement.setBoolean(14, usuario.isConsultaFornecedor());
                statement.setBoolean(15, usuario.isConsultaProduto());
                statement.setBoolean(16, usuario.isConsultaCategoria());
                statement.setBoolean(17, usuario.isConsultaEnderecoEntregaCliente());
                statement.setBoolean(18, usuario.isConsultaEnderecoEntregaFornecedor());
                statement.setBoolean(19, usuario.isRelatorioClientes());
                statement.setBoolean(20, usuario.isRelatorioFornecedor());
                statement.setBoolean(21, usuario.isRelatorioProduto());
                statement.setBoolean(22, usuario.isRelatorioCategoria());
                statement.setBoolean(23, usuario.isRelatorioUnidades());
                statement.setInt(24, usuario.getId());
            } else if(operacao == EXCLUSAO) {
                sql = "delete from categorias where id = ?";
                statement = bd.connection.prepareStatement(sql);
                statement.setInt(1, usuario.getId());
            }
            
            if(statement.executeUpdate() == 0) {
                men = "Falha na operação!";
            }
            
        } catch (SQLException erro) {
            men = "Falha na operação! " + erro.toString();
        }
        
        return men;
        
    }
    
}

/*
id int AI PK 
Nome varchar(50) 
senha varchar(50) 
cadastroClientes tinyint(1) 
cadastroFornecedores tinyint(1) 
cadastroProdutos tinyint(1) 
cadastroCategoria tinyint(1) 
cadastroEnderecoEntregaCliente tinyint(1) 
cadastroEnderecoEntregaFornecedor tinyint(1) 
cadastroFornecedoresProduto tinyint(1) 
cadastroUnidades tinyint(1) 
pedidoCliente tinyint(1) 
pedidoFornecedor tinyint(1) 
consultaClientes tinyint(1) 
consultaFornecedor tinyint(1) 
consultaProduto tinyint(1) 
consultaCategoria tinyint(1) 
consultaEnderecoEntregaCliente tinyint(1) 
consultaEnderecoEntregaFornecedor tinyint(1) 
relatorioClientes tinyint(1) 
relatorioFornecedor tinyint(1) 
relatorioProduto tinyint(1) 
relatorioCategoria tinyint(1) 
relatorioUnidades tinyint(1)
*/