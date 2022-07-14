package model;

/**
 *
 * @author Ronaldo Rodrigues Godoi
 */
public class ItensPedidoFornecedorEstendida 
extends ItensPedidoFornecedor {
    
    private String descricao_produto;
    private int numero_item;

    public String getDescricao_produto() {
        return descricao_produto;
    }

    public void setDescricao_produto(String descricao_produto) {
        this.descricao_produto = descricao_produto;
    }

    public int getNumero_item() {
        return numero_item;
    }

    public void setNumero_item(int numero_item) {
        this.numero_item = numero_item;
    }
    
}
