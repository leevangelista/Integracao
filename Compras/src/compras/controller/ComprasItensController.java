/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compras.controller;

import compras.dao.BancoDeDadosException;
import compras.dao.compraDAO;
import compras.dao.compraItemDAO;
import compras.dao.produtoDAO;
import compras.model.Compra;
import compras.model.Compra_Item;
import compras.model.Produto;
import java.util.ArrayList;

/**
 *
 * @author Pedro
 */
public class ComprasItensController {

    private Compra_Item compraItem = null;
    private compraItemDAO db;
    private ArrayList<Compra_Item> listaCompraItens;
    private ArrayList<Produto> listaProdutos;
    private ArrayList<Compra> listaCompras;
    private int indice = 0;

    public ComprasItensController() throws BancoDeDadosException {
        this.db = new compraItemDAO();
        this.listaCompraItens = db.buscaTodos();
    }

    public void cadastrar(int quantidade, double valor, int indiceCompra, int indiceProduto) throws BancoDeDadosException {

        Compra_Item compra = new Compra_Item();

        compra.setQuantidade(quantidade);
        compra.setValor(valor);

        Compra c = this.listaCompras.get(indiceCompra);
        compra.setCompras_id(c);

        Produto p = this.listaProdutos.get(indiceProduto);
        compra.setProdutos_id(p);

        this.db.inserir(compra);

        this.listaCompraItens.add(compra);

    }

    public void salvar(int quantidade, double valor, int indiceCompra, int indiceProduto) throws BancoDeDadosException {
        Compra_Item compraItem;

        if (this.compraItem != null) {

            compraItem = this.compraItem;

            compraItem.setQuantidade(quantidade);
            compraItem.setValor(valor);

            buscarTodasAsCompras();
            Compra c = this.listaCompras.get(indiceCompra);
            compraItem.setCompras_id(c);

            buscarTodosProdutos();
            Produto p = this.listaProdutos.get(indiceProduto);
            compraItem.setProdutos_id(p);

            this.listaCompraItens.set(indice, compraItem);

            this.db.atualizar(compraItem);

            this.indice = 0;
            this.compraItem = null;

        }

    }

    public int excluir(int indice) throws BancoDeDadosException {

        int reg = this.db.excluir(indice);

        return reg;

    }

    public ArrayList<Compra_Item> getListaComprasItens() {
        return this.listaCompraItens;
    }

    public void buscarTodasAsCompras() throws BancoDeDadosException {
        compraDAO cdao = new compraDAO();
        this.listaCompras = cdao.buscaTodos();
        cdao = null;
    }

    public void buscarTodosProdutos() throws BancoDeDadosException {
        produtoDAO pdao = new produtoDAO();
        this.listaProdutos = pdao.buscaTodos();
        pdao = null;
    }

    public ArrayList<Compra> getListaComprasCadastrados() {
        return this.listaCompras;
    }

    public ArrayList<Produto> getListaProdutosCadastrados() {
        return this.listaProdutos;
    }

    public void setCompraItensSelecionado(int indice) throws BancoDeDadosException {
        this.indice = indice;
        this.compraItem = this.listaCompraItens.get(indice);
    }

    public Compra_Item getCompraItens() {
        return this.compraItem;
    }

}
