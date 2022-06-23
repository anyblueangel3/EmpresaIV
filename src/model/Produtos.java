package model;

/**
 *
 * @author Ronaldo Rodrigues Godoi
 */
public class Produtos {
    
    private String id, descricao, categoria, unidade, data_cadastro;
    private Double quantidade, preco_venda, preco_ultima_compra;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    public String getData_cadastro() {
        return data_cadastro;
    }

    public void setData_cadastro(String data_cadastro) {
        this.data_cadastro = data_cadastro;
    }

    public Double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Double quantidade) {
        this.quantidade = quantidade;
    }

    public Double getPreco_venda() {
        return preco_venda;
    }

    public void setPreco_venda(Double preco_venda) {
        this.preco_venda = preco_venda;
    }

    public Double getPreco_ultima_compra() {
        return preco_ultima_compra;
    }

    public void setPreco_ultima_compra(Double preco_ultima_compra) {
        this.preco_ultima_compra = preco_ultima_compra;
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