package model;
/**
*
* @author Ronaldo R. Godoi
*/
public class ModelCadForProduto {

    private int id;
    private String id_produto;
    private String id_fornecedor;
    private double preco;
    private String data_compra;
    private String data_cadastro;

    /**
    * Construtor
    */
    public ModelCadForProduto(){}

    /**
    * seta o valor de id
    * @param pId
    */
    public void setId(int pId){
        this.id = pId;
    }
    /**
    * @return pk_id
    */
    public int getId(){
        return this.id;
    }

    /**
    * seta o valor de id_produto
    * @param pId_produto
    */
    public void setId_produto(String pId_produto){
        this.id_produto = pId_produto;
    }
    /**
    * @return id_produto
    */
    public String getId_produto(){
        return this.id_produto;
    }

    /**
    * seta o valor de id_fornecedor
    * @param pId_fornecedor
    */
    public void setId_fornecedor(String pId_fornecedor){
        this.id_fornecedor = pId_fornecedor;
    }
    /**
    * @return id_fornecedor
    */
    public String getId_fornecedor(){
        return this.id_fornecedor;
    }

    /**
    * seta o valor de preco
    * @param pPreco
    */
    public void setPreco(double pPreco){
        this.preco = pPreco;
    }
    /**
    * @return preco
    */
    public double getPreco(){
        return this.preco;
    }

    /**
    * seta o valor de data_compra
    * @param pData_compra
    */
    public void setData_compra(String pData_compra){
        this.data_compra = pData_compra;
    }
    /**
    * @return data_compra
    */
    public String getData_compra(){
        return this.data_compra;
    }

    /**
    * seta o valor de data_cadastro
    * @param pData_cadastro
    */
    public void setData_cadastro(String pData_cadastro){
        this.data_cadastro = pData_cadastro;
    }
    /**
    * @return data_cadastro
    */
    public String getData_cadastro(){
        return this.data_cadastro;
    }

    @Override
    public String toString(){
        return "ModelCadForProduto {" + "::id = " + this.id + "::id_produto = " + this.id_produto + "::id_fornecedor = " + this.id_fornecedor + "::preco = " + this.preco + "::data_compra = " + this.data_compra + "::data_cadastro = " + this.data_cadastro +  "}";
    }
}