package model;

/**
 *
 * @author Usuario
 */
public class ItensPedidoClienteEstendida extends ItensPedidoCliente {
    private String descricao_produto;
    private int numero_item;

    public String getDescricao_produto() {
        return descricao_produto;
    }

    public void setDescricao_produto(String nome_produto) {
        this.descricao_produto = nome_produto;
    }

    public int getNumero_item() {
        return numero_item;
    }

    public void setNumero_item(int numero_item) {
        this.numero_item = numero_item;
    }
}
