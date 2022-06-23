package model;

import java.sql.Date;


/**
 *
 * @author Ronaldo Rodrigues Godoi
 */
public class PedidosCliente {

    private int id;
    private String id_cliente, id_endereco_entrega, condicao_pag;
    private Date data_pedido; 
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(String id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getId_endereco_entrega() {
        return id_endereco_entrega;
    }

    public void setId_endereco_entrega(String id_endereco_entrega) {
        this.id_endereco_entrega = id_endereco_entrega;
    }

    public String getCondicao_pag() {
        return condicao_pag;
    }

    public void setCondicao_pag(String condicao_pag) {
        this.condicao_pag = condicao_pag;
    }

    public Date getData_pedido() {
        return data_pedido;
    }

    public void setData_pedido(Date data_pedido) {
        this.data_pedido = data_pedido;
    }
   
}

/*
Table: pedidos_cli
Columns:
id int AI PK 
id_cliente varchar(16) 
id_endereco_entrega varchar(10) 
condicao_pag varchar(10) 
data_pedido datetime
*/