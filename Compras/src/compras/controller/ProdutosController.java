/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compras.controller;

import compras.dao.BancoDeDadosException;
import compras.dao.produtoDAO;
import compras.model.Fornecedor;
import compras.model.Produto;
import java.sql.Date;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;

/**
 *
 * @author Pedro
 */
public class ProdutosController {

    private Produto produto = null;
    private produtoDAO db;
    private ArrayList<Produto> listaProdutos;
    private int indice = 0;

    public ProdutosController() throws BancoDeDadosException, ParseException {
        this.db = new produtoDAO();
        this.listaProdutos = db.buscaTodos();
    }

    public Produto getProdutos() {
        return this.produto;
    }

    public ArrayList<Produto> getListaProdutos() {
        return this.listaProdutos;
    }
    
    public void salvarProduto(int idProduto,
                            String nome,
                            int estoque,
                            double valorCusto,
                            double valorVenda,
                            String datUltimaCompra,
                            int idFornecedor) throws BancoDeDadosException {
        Fornecedor fornecedor = new Fornecedor();
        fornecedor.setId(idFornecedor);
        Calendar dataUltimaCompra = Calendar.getInstance();
        Date data = Date.valueOf(datUltimaCompra.replaceAll("\"", ""));
        System.out.println(data);
        dataUltimaCompra.setTime(data);
        Produto produto = new Produto(idProduto, 
                                nome, 
                                estoque, 
                                valorCusto, 
                                valorVenda, 
                                dataUltimaCompra, 
                                fornecedor);
        db.inserir(produto);
        listaProdutos.add(produto);
    }
}
