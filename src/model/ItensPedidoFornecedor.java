package model;

import java.sql.Date;

/**
 *
 * @author Ronaldo Rodrigues Godoi
 */
public class ItensPedidoFornecedor {
    private int id, id_pedido_for;
    private String id_produto;
    private double quantidade, preco;
    private Date data_entrega;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_pedido_for() {
        return id_pedido_for;
    }

    public void setId_pedido_for(int id_pedido_for) {
        this.id_pedido_for = id_pedido_for;
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
Table: item_pedido_for
Columns:
id int AI PK 
id_pedido_for int 
id_produto varchar(10) 
quantidade double 
preco double 
data_entrega datetime
*/