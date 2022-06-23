package DAO;

import model.ModelCadForProduto;
import empresaiv.ConexaoMySql;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import model.Fornecedores;
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
            System.out.println("Id produto: " + pModelCadForProduto.getId_produto());
            return this.insertSQL(
                "INSERT INTO fornec_produto ("
                    + "id_produto,"
                    + "id_fornecedor,"
                    + "preco,"
                    + "data_compra,"
                    + "data_cadastro"
                + ") VALUES ("
                    + "'" + pModelCadForProduto.getId_produto() + "',"
                    + "'" + pModelCadForProduto.getId_fornecedor() + "',"
                    + "'" + pModelCadForProduto.getPreco() + "',"
                    + "'" + pModelCadForProduto.getData_compra() + "', "
                    + "'" + pModelCadForProduto.getData_cadastro() +"'"
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
    public ModelCadForProduto getCadForProdutoDAO(int pId){
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
                    + "id_produto = '" + pModelCadForProduto.getId_produto() + "',"
                    + "id_fornecedor = '" + pModelCadForProduto.getId_fornecedor() + "',"
                    + "preco = '" + pModelCadForProduto.getPreco() + "',"
                    + "data_compra = '" + pModelCadForProduto.getData_compra() + "',"
                    + "data_cadastro = '" + pModelCadForProduto.getData_cadastro() + "'"
                + " WHERE "
                    + "id = '" + pModelCadForProduto.getId() + "'"
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
    public boolean excluirCadForProdutoDAO(String pId_produto, String pId_fornecedor){
        System.out.println("Exclusão produto: " + pId_produto + " fornecedor: " + pId_fornecedor);
        try {
            this.conectar();
            this.executarUpdateDeleteSQL(
                "DELETE FROM fornec_produto "
                + "WHERE "
                + "id_produto = " + pId_produto
                + " AND id_fornecedor = " + pId_fornecedor  
                + ";"
            );
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }finally {
            this.fecharConexao();
        }
    }
    
    public ArrayList<Fornecedores> getListaFornecedorProd(String pId_produto) {
        ArrayList<Fornecedores> listaFornecedores = new ArrayList();
        ArrayList<ModelCadForProduto> listaModelCadForProduto = new ArrayList();
        Fornecedores fornecedor = new Fornecedores();
        ModelCadForProduto modelCadForProduto;
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "id,"
                    + "id_produto,"
                    + "id_fornecedor,"
                    + "preco,"
                    + "data_compra,"
                    + "data_cadastro"
                    + " FROM"
                    + " fornec_produto"
                    + " where id_produto = " + pId_produto
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
                listaModelCadForProduto.add(modelCadForProduto);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            //this.fecharConexao();
        }
           
        for(int i = 0; i < listaModelCadForProduto.size(); i++) {
            modelCadForProduto = new ModelCadForProduto();
            modelCadForProduto.setId_fornecedor(listaModelCadForProduto.get(i).getId_fornecedor());
            
            try {
                this.executarSQL(
                        "SELECT "
                        + "id_cgc_cpf, "
                        + "nome_razao, "
                        + "telefone, "
                        + "cidade, "
                        + "estado "
                        + "from fornecedores "
                        + "where id_cgc_cpf = " + modelCadForProduto.getId_fornecedor());
                fornecedor = new Fornecedores();
                if(this.getResultSet().next()) {
                    fornecedor.setId_cgc_cpf(this.getResultSet().getString(1));
                    fornecedor.setNome_razao(this.getResultSet().getString(2));
                    fornecedor.setTelefone(this.getResultSet().getString(3));
                    fornecedor.setCidade(this.getResultSet().getString(4));
                    fornecedor.setEstado(this.getResultSet().getString(5));
                    listaFornecedores.add(fornecedor);
                } else {
                    fornecedor.setId_cgc_cpf(modelCadForProduto.getId_fornecedor());
                    fornecedor.setNome_razao("Não cadastrado");
                    fornecedor.setTelefone("");
                    fornecedor.setCidade("");
                    fornecedor.setEstado("");
                    listaFornecedores.add(fornecedor);
                }
                
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        this.fecharConexao();
        // Ordenar lista de fornecedores: listaFornecedores...
        listaFornecedores.sort(Comparator.comparing(Fornecedores::getNome_razao));
        return listaFornecedores;
        
    }
    
    public boolean localizafornecedorDAO(String Id_fornecedor) {
        boolean retornoBooleano = false;
        try {
            this.conectar();
            this.executarSQL(
            "SELECT "
                + "id_cgc_cpf, "
                + "nome_razao "
                + "from fornecedores "
                + "where id_cgc_cpf = " + Id_fornecedor);
                Fornecedores fornecedor = new Fornecedores();
                if(this.getResultSet().next()) {
                    retornoBooleano = true;
                    fornecedor.setId_cgc_cpf(this.getResultSet().getString(1));
                    fornecedor.setNome_razao(this.getResultSet().getString(2));
                }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        System.out.println("retornoBooleano: " + retornoBooleano);
        return retornoBooleano;
    }
    
    public ModelCadForProduto localizaFornecedorProdutoDAO(String id_produto, String id_fornecedor) {
        ModelCadForProduto fornecedorProduto = new ModelCadForProduto();
        try {
            this.conectar();
            this.executarSQL(
            "SELECT * FROM fornec_produto "
            + "WHERE id_produto = " + id_produto
            + " AND id_fornecedor = " + id_fornecedor);
            if(this.getResultSet().next()) {
                fornecedorProduto.setId(this.getResultSet().getInt(1));
                fornecedorProduto.setId_produto(this.getResultSet().getString(2));
                fornecedorProduto.setId_fornecedor(this.getResultSet().getString(3));
                fornecedorProduto.setPreco(this.getResultSet().getDouble(4));
                fornecedorProduto.setData_compra(this.getResultSet().getString(5));
                fornecedorProduto.setData_cadastro(this.getResultSet().getString(6));
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return fornecedorProduto;
    }
    
}

/*
Table: fornec_produto
Columns:
id int AI PK 
id_produto varchar(10) 
id_fornecedor varchar(16) 
preco double 
data_compra datetime 
data_cadastro datetime
*/