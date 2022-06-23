package controller;

import model.ModelCadForProduto;
import DAO.DAOCadForProduto;
import java.util.ArrayList;

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
    public ModelCadForProduto getCadForProdutoController(Int pId){
        return this.daoCadForProduto.getCadForProdutoDAO(pId);
    }

    /**
    * recupera uma lista deCadForProduto
    * @param pId
    * @return ArrayList
    */
    public ArrayList<ModelCadForProduto> getListaCadForProdutoController(){
        return this.daoCadForProduto.getListaCadForProdutoDAO();
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
    public boolean excluirCadForProdutoController(Int pId){
        return this.daoCadForProduto.excluirCadForProdutoDAO(pId);
    }
}