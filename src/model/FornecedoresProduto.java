package model;

/**
 *
 * @author Ronaldo R. Godoi
 */
public class FornecedoresProduto {

    private String id, id_produto, id_fornecedor, preco, data_compra, data_cadastro;
    
    public String getId() {
        return id;
    }

    // Este campo é auto-incremento e não pode ser setado
    //public void setId(String id) {
    //    this.id = id;
    //}

    public String getId_produto() {
        return id_produto;
    }

    public void setId_produto(String id_produto) {
        this.id_produto = id_produto;
    }

    public String getId_fornecedor() {
        return id_fornecedor;
    }

    public void setId_fornecedor(String id_fornecedor) {
        this.id_fornecedor = id_fornecedor;
    }

    public String getPreco() {
        return preco;
    }

    public void setPreco(String preco) {
        this.preco = preco;
    }

    public String getData_compra() {
        return data_compra;
    }

    public void setData_compra(String data_compra) {
        this.data_compra = data_compra;
    }

    public String getData_cadastro() {
        return data_cadastro;
    }

    public void setData_cadastro(String data_cadastro) {
        this.data_cadastro = data_cadastro;
    }
        
}

/*
Table: fornec_produto
Columns:
id int AI PK 
id_produto varchar(10) 
id_fornecedor varchar(16) 
preco double 
data_compra datetime 
data_cadastro datetime
*/