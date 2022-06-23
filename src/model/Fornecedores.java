package model;

/**
 *
 * @author Ronaldo Rodrigues Godoi
 */
public class Fornecedores {
    private String id_cgc_cpf, fisica_juridica, nome_razao, email, telefone, cep, endereco,
            numero, complemento, bairro, cidade, estado, data_cadastro;

    public String getId_cgc_cpf() {
        return id_cgc_cpf;
    }
    
    public String getFisica_juridica() {
        return fisica_juridica;
    }

    public String getNome_razao() {
        return nome_razao;
    }
    
    public String getEmail() {
        return email;
    }
    
    public String getTelefone() {
        return telefone;
    }

    public String getCep() {
        return cep;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getNumero() {
        return numero;
    }

    public String getComplemento() {
        return complemento;
    }
    
    public String getBairro() {
        return bairro;
    }

    public String getCidade() {
        return cidade;
    }
    
    public String getEstado() {
        return estado;
    }


    public String getData_cadastro() {
        return data_cadastro;
    }

    public void setId_cgc_cpf(String id_cgc_cpf) {
        this.id_cgc_cpf = id_cgc_cpf;
    }
    
    public void setFisica_juridica(String fisica_juridica) {
        this.fisica_juridica = fisica_juridica;
    }
    
    public void setNome_razao(String nome_razao) {
        this.nome_razao = nome_razao;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public void setData_cadastro(String data_cadastro) {
        this.data_cadastro = data_cadastro;
    }
    
}