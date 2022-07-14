package model;

import java.sql.Date;

/**
 *
 * @author Ronaldo Rodrigues Godoi
 */
public class PedidosFornecedor {
    int id;
    String id_fornecedor, id_endereco_entrega, condicao_pag;
    Date data_pedido;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getId_fornecedor() {
        return id_fornecedor;
    }

    public void setId_fornecedor(String id_fornecedor) {
        this.id_fornecedor = id_fornecedor;
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
Table: pedidos_for
Columns:
id int AI PK 
id_fornecedor varchar(10) 
id_endereco_entrega varchar(10) 
condicao_pag varchar(10) 
data_pedido datetime
*/