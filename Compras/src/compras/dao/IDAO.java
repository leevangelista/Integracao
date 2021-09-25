/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compras.dao;

/**
 *
 * @author G0NN4 CRY
 */
public interface IDAO {
    
    //insert
    public abstract void inserir(Object objeto) throws BancoDeDadosException;
    //update
    public abstract void atualizar(Object objeto) throws BancoDeDadosException;
    //select
    public abstract Object buscaPorId(int id) throws BancoDeDadosException;
    //delete
    public abstract int excluir(int id) throws BancoDeDadosException;
    
}
