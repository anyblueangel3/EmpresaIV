package model;

/**
 *
 * @author Ronaldo Rodrigues Godoi
 */
public class Categorias {
    
    private String id, descricao, data_cadastro;

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

    public String getData_cadastro() {
        return data_cadastro;
    }

    public void setData_cadastro(String data_cadastro) {
        this.data_cadastro = data_cadastro;
    }

}


/*
Table: unidades
Columns:
id varchar(10) PK 
descricao varchar(40) 
data_cadastro datetime
*/