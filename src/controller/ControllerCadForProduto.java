package controller;

import model.ModelCadForProduto;
import DAO.DAOCadForProduto;
import java.util.ArrayList;
import model.Fornecedores;

/**
*
* @author Ronaldo R. Godoi
*/
public class ControllerCadForProduto {

    private DAOCadForProduto daoCadForProduto = new DAOCadForProduto();

    /**
    * grava CadForProduto
    * @param pModelCadForProduto
    * @return int
    */
    public int salvarCadForProdutoController(ModelCadForProduto pModelCadForProduto){
        return this.daoCadForProduto.salvarCadForProdutoDAO(pModelCadForProduto);
    }

    /**
    * recupera CadForProduto
    * @param pId
    * @return ModelCadForProduto
    */
    public ModelCadForProduto getCadForProdutoController(int pId){
        return this.daoCadForProduto.getCadForProdutoDAO(pId);
    }

    /**
    * recupera uma lista deCadForProduto
    * @param pId
    * @return ArrayList
    */
    public ArrayList<Fornecedores> getListaFornecedorProdController(String pId){
        return this.daoCadForProduto.getListaFornecedorProd(pId);
    }

    /**
    * atualiza CadForProduto
    * @param pModelCadForProduto
    * @return boolean
    */
    public boolean atualizarCadForProdutoController(ModelCadForProduto pModelCadForProduto){
        return this.daoCadForProduto.atualizarCadForProdutoDAO(pModelCadForProduto);
    }

    /**
    * exclui CadForProduto
    * @param pId
    * @return boolean
    */
    public boolean excluirCadForProdutoController(String pId_produto, String pId_fornecedor){
        return this.daoCadForProduto.excluirCadForProdutoDAO(pId_produto, pId_fornecedor);
    }
    
    /**
     * Localiza o fornecedor do produto
     * @param Id_produto
     * @param Id_fornecedor
     * @return 
     */
    public ModelCadForProduto localizaFornecedorProdutoController(String Id_produto, String Id_fornecedor) {
        return this.daoCadForProduto.localizaFornecedorProdutoDAO(Id_produto, Id_fornecedor);
    }
    
    public boolean localizaFornecedorController(String Id_fornecedor) {
        return this.daoCadForProduto.localizafornecedorDAO(Id_fornecedor);
    }
    
}