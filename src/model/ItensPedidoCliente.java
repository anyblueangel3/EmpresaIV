package model;

import java.sql.Date;

/**
 *
 * @author Ronaldo Rodrigues Godoi
 */
public class ItensPedidoCliente {
    
    private int id, id_pedido_cli;
    private String id_produto;
    private double quantidade, preco;
    private Date data_entrega;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_pedido_cli() {
        return id_pedido_cli;
    }

    public void setId_pedido_cli(int id_pedido_cli) {
        this.id_pedido_cli = id_pedido_cli;
    }

    public String getId_produto() {
        return id_produto;
    }

    public void setId_produto(String id_produto) {
        this.id_produto = id_produto;
    }

    public double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(double quantidade) {
        this.quantidade = quantidade;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public Date getData_entrega() {
        return data_entrega;
    }

    public void setData_entrega(Date data_entrega) {
        this.data_entrega = data_entrega;
    }
        
}

/*
Table: item_pedido_cli
Columns:
id int AI PK 
id_pedido_cli varchar(10) 
id_produto varchar(10) 
quantidade double 
unidade varchar(10) 
preco double 
data_entrega datetime
*/