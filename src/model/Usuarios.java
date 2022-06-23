package model;

/**
 *
 * @author Ronaldo Rodrigues Godoi
 */
public class Usuarios {
    private int id;
    private String nome, senha;
    private boolean cadastroClientes, cadastroFornecedores, cadastroProdutos,
            cadastroCategoria, cadastroEnderecoEntregaCliente, 
            cadastroEnderecoEntregaFornecedor, cadastroFornecedoresProduto,
            cadastroUnidades, pedidoCliente, pedidoFornecedor, consultaClientes,
            consultaFornecedor, consultaProduto, consultaCategoria,
            consultaEnderecoEntregaCliente, consultaEnderecoEntregaFornecedor,
            relatorioClientes, relatorioFornecedor, relatorioProduto, 
            relatorioCategoria, relatorioUnidades;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public boolean isCadastroClientes() {
        return cadastroClientes;
    }

    public void setCadastroClientes(boolean cadastroClientes) {
        this.cadastroClientes = cadastroClientes;
    }

    public boolean isCadastroFornecedores() {
        return cadastroFornecedores;
    }

    public void setCadastroFornecedores(boolean cadastroFornecedores) {
        this.cadastroFornecedores = cadastroFornecedores;
    }

    public boolean isCadastroProdutos() {
        return cadastroProdutos;
    }

    public void setCadastroProdutos(boolean cadastroProdutos) {
        this.cadastroProdutos = cadastroProdutos;
    }

    public boolean isCadastroCategoria() {
        return cadastroCategoria;
    }

    public void setCadastroCategoria(boolean cadastroCategoria) {
        this.cadastroCategoria = cadastroCategoria;
    }

    public boolean isCadastroEnderecoEntregaCliente() {
        return cadastroEnderecoEntregaCliente;
    }

    public void setCadastroEnderecoEntregaCliente(boolean cadastroEnderecoEntregaCliente) {
        this.cadastroEnderecoEntregaCliente = cadastroEnderecoEntregaCliente;
    }

    public boolean isCadastroEnderecoEntregaFornecedor() {
        return cadastroEnderecoEntregaFornecedor;
    }

    public void setCadastroEnderecoEntregaFornecedor(boolean cadastroEnderecoEntregaFornecedor) {
        this.cadastroEnderecoEntregaFornecedor = cadastroEnderecoEntregaFornecedor;
    }

    public boolean isCadastroFornecedoresProduto() {
        return cadastroFornecedoresProduto;
    }

    public void setCadastroFornecedoresProduto(boolean cadastroFornecedoresProduto) {
        this.cadastroFornecedoresProduto = cadastroFornecedoresProduto;
    }

    public boolean isCadastroUnidades() {
        return cadastroUnidades;
    }

    public void setCadastroUnidades(boolean cadastroUnidades) {
        this.cadastroUnidades = cadastroUnidades;
    }

    public boolean isPedidoCliente() {
        return pedidoCliente;
    }

    public void setPedidoCliente(boolean pedidoCliente) {
        this.pedidoCliente = pedidoCliente;
    }

    public boolean isPedidoFornecedor() {
        return pedidoFornecedor;
    }

    public void setPedidoFornecedor(boolean pedidoFornecedor) {
        this.pedidoFornecedor = pedidoFornecedor;
    }

    public boolean isConsultaClientes() {
        return consultaClientes;
    }

    public void setConsultaClientes(boolean consultaClientes) {
        this.consultaClientes = consultaClientes;
    }

    public boolean isConsultaFornecedor() {
        return consultaFornecedor;
    }

    public void setConsultaFornecedor(boolean consultaFornecedor) {
        this.consultaFornecedor = consultaFornecedor;
    }

    public boolean isConsultaProduto() {
        return consultaProduto;
    }

    public void setConsultaProduto(boolean consultaProduto) {
        this.consultaProduto = consultaProduto;
    }

    public boolean isConsultaCategoria() {
        return consultaCategoria;
    }

    public void setConsultaCategoria(boolean consultaCategoria) {
        this.consultaCategoria = consultaCategoria;
    }

    public boolean isConsultaEnderecoEntregaCliente() {
        return consultaEnderecoEntregaCliente;
    }

    public void setConsultaEnderecoEntregaCliente(boolean consultaEnderecoEntregaCliente) {
        this.consultaEnderecoEntregaCliente = consultaEnderecoEntregaCliente;
    }

    public boolean isConsultaEnderecoEntregaFornecedor() {
        return consultaEnderecoEntregaFornecedor;
    }

    public void setConsultaEnderecoEntregaFornecedor(boolean consultaEnderecoEntregaFornecedor) {
        this.consultaEnderecoEntregaFornecedor = consultaEnderecoEntregaFornecedor;
    }

    public boolean isRelatorioClientes() {
        return relatorioClientes;
    }

    public void setRelatorioClientes(boolean relatorioClientes) {
        this.relatorioClientes = relatorioClientes;
    }

    public boolean isRelatorioFornecedor() {
        return relatorioFornecedor;
    }

    public void setRelatorioFornecedor(boolean relatorioFornecedor) {
        this.relatorioFornecedor = relatorioFornecedor;
    }

    public boolean isRelatorioProduto() {
        return relatorioProduto;
    }

    public void setRelatorioProduto(boolean relatorioProduto) {
        this.relatorioProduto = relatorioProduto;
    }

    public boolean isRelatorioCategoria() {
        return relatorioCategoria;
    }

    public void setRelatorioCategoria(boolean relatorioCategoria) {
        this.relatorioCategoria = relatorioCategoria;
    }

    public boolean isRelatorioUnidades() {
        return relatorioUnidades;
    }

    public void setRelatorioUnidades(boolean relatorioUnidades) {
        this.relatorioUnidades = relatorioUnidades;
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

