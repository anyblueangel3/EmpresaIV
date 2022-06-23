package DAO;

import model.ModelCadForProduto;
import conexoes.ConexaoMySql;
import java.util.ArrayList;
/**
*
* @author Ronaldo R. Godoi
*/
public class DAOCadForProduto extends ConexaoMySql {

    /**
    * grava CadForProduto
    * @param pModelCadForProduto
    * @return int
    */
    public int salvarCadForProdutoDAO(ModelCadForProduto pModelCadForProduto){
        try {
            this.conectar();
            return this.insertSQL(
                "INSERT INTO fornec_produto ("
                    + "pk_id,"
                    + "id_produto,"
                    + "id_fornecedor,"
                    + "preco,"
                    + "data_compra,"
                    + "data_cadastro"
                + ") VALUES ("
                    + "'" + pModelCadForProduto.getId() + "',"
                    + "'" + pModelCadForProduto.getId_produto() + "',"
                    + "'" + pModelCadForProduto.getId_fornecedor() + "',"
                    + "'" + pModelCadForProduto.getPreco() + "',"
                    + "'" + pModelCadForProduto.getData_compra() + "',"
                    + "'" + pModelCadForProduto.getData_cadastro() + "'"
                + ");"
            );
        }catch(Exception e){
            e.printStackTrace();
            return 0;
        }finally{
            this.fecharConexao();
        }
    }

    /**
    * recupera CadForProduto
    * @param pId
    * @return ModelCadForProduto
    */
    public ModelCadForProduto getCadForProdutoDAO(Int pId){
        ModelCadForProduto modelCadForProduto = new ModelCadForProduto();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "pk_id,"
                    + "id_produto,"
                    + "id_fornecedor,"
                    + "preco,"
                    + "data_compra,"
                    + "data_cadastro"
                 + " FROM"
                     + " fornec_produto"
                 + " WHERE"
                     + " pk_id = '" + pId + "'"
                + ";"
            );

            while(this.getResultSet().next()){
                modelCadForProduto.setId(this.getResultSet().getInt(1));
                modelCadForProduto.setId_produto(this.getResultSet().getString(2));
                modelCadForProduto.setId_fornecedor(this.getResultSet().getString(3));
                modelCadForProduto.setPreco(this.getResultSet().getDouble(4));
                modelCadForProduto.setData_compra(this.getResultSet().getString(5));
                modelCadForProduto.setData_cadastro(this.getResultSet().getString(6));
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return modelCadForProduto;
    }

    /**
    * recupera uma lista de CadForProduto
        * @return ArrayList
    */
    public ArrayList<ModelCadForProduto> getListaCadForProdutoDAO(){
        ArrayList<ModelCadForProduto> listamodelCadForProduto = new ArrayList();
        ModelCadForProduto modelCadForProduto = new ModelCadForProduto();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "pk_id,"
                    + "id_produto,"
                    + "id_fornecedor,"
                    + "preco,"
                    + "data_compra,"
                    + "data_cadastro"
                 + " FROM"
                     + " fornec_produto"
                + ";"
            );

            while(this.getResultSet().next()){
                modelCadForProduto = new ModelCadForProduto();
                modelCadForProduto.setId(this.getResultSet().getInt(1));
                modelCadForProduto.setId_produto(this.getResultSet().getString(2));
                modelCadForProduto.setId_fornecedor(this.getResultSet().getString(3));
                modelCadForProduto.setPreco(this.getResultSet().getDouble(4));
                modelCadForProduto.setData_compra(this.getResultSet().getString(5));
                modelCadForProduto.setData_cadastro(this.getResultSet().getString(6));
                listamodelCadForProduto.add(modelCadForProduto);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return listamodelCadForProduto;
    }

    /**
    * atualiza CadForProduto
    * @param pModelCadForProduto
    * @return boolean
    */
    public boolean atualizarCadForProdutoDAO(ModelCadForProduto pModelCadForProduto){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                "UPDATE fornec_produto SET "
                    + "pk_id = '" + pModelCadForProduto.getId() + "',"
                    + "id_produto = '" + pModelCadForProduto.getId_produto() + "',"
                    + "id_fornecedor = '" + pModelCadForProduto.getId_fornecedor() + "',"
                    + "preco = '" + pModelCadForProduto.getPreco() + "',"
                    + "data_compra = '" + pModelCadForProduto.getData_compra() + "',"
                    + "data_cadastro = '" + pModelCadForProduto.getData_cadastro() + "'"
                + " WHERE "
                    + "pk_id = '" + pModelCadForProduto.getId() + "'"
                + ";"
            );
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }finally{
            this.fecharConexao();
        }
    }

    /**
    * exclui CadForProduto
    * @param pId
    * @return boolean
    */
    public boolean excluirCadForProdutoDAO(Int pId){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                "DELETE FROM fornec_produto "
                + " WHERE "
                    + "pk_id = '" + pId + "'"
                + ";"
            );
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }finally{
            this.fecharConexao();
        }
    }
}