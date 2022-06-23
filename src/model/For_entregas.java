package model;

/**
 *
 * @author Ronaldo Rodrigues Godoi
 */
public class For_entregas {
        
    private String id, id_fornecedor, telefone, cep, endereco, numero, complemento,
            cidade, bairro, estado;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId_fornecedor() {
        return id_fornecedor;
    }

    public void setId_fornecedor(String id_fornecedor) {
        this.id_fornecedor = id_fornecedor;
    }

    public String getTelefone() {
        return telefone;
    }
    
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
}

/*
Table: cli_entrega
Columns:
id varchar(10) PK 
id_fornecedor varchar(10) 
cep varchar(9) 
endereco varchar(60) 
numero int 
complemento varchar(40) 
cidade varchar(40) 
bairro varchar(60)
*/