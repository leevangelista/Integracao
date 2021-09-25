package compras.controller;

import compras.dao.BancoDeDadosException;
import compras.dao.compraDAO;
import compras.dao.fornecedorDAO;
import compras.model.Compra;
import compras.model.Fornecedor;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Pedro
 */
public class ComprasController {

    private compraDAO db;
    private Compra compra = null;
    private Fornecedor fornecedor = null;
    private ArrayList<Compra> listaCompras;
    private ArrayList<Fornecedor> listaFornecedores;
    private int indice = 0;

    public ComprasController() throws BancoDeDadosException {
        this.db = new compraDAO();
        this.listaCompras = db.buscaTodos();
    }

    public void salvar(String dat_compra, String nota_fiscal, Double valor_total, int indiceFornecedor) throws BancoDeDadosException {

        Compra c;

        if (this.compra != null) {

            c = this.compra;

            Calendar ultimaCompra = Calendar.getInstance();
            Date d = new Date(dat_compra);
            ultimaCompra.setTime(d);

            c.setDat_compra(ultimaCompra);

            c.setNota_fiscal(nota_fiscal);
            c.setValor_total(valor_total);

            buscarTodoOsFornecedores();
            Fornecedor f = this.listaFornecedores.get(indiceFornecedor);
            c.setFornecedor(f);

            this.listaCompras.set(indice, c);

            this.db.atualizar(c);

            this.indice = 0;
            this.compra = null;

        }
    }

    public void cadastrar(String data_compra, String nota_fiscal, Double valor_total, int indiceFornecedor) throws BancoDeDadosException {

        Compra c = new Compra();

        c.setNota_fiscal(nota_fiscal);
        c.setValor_total(valor_total);

        Fornecedor f = this.listaFornecedores.get(indiceFornecedor);
        c.setFornecedor(f);

        Calendar dataCompra = Calendar.getInstance();
        Date d = new Date(data_compra);
        dataCompra.setTime(d);

        c.setDat_compra(dataCompra);

        this.db.inserir(c);

        this.listaCompras.add(c);

    }

    public int excluir(int indice) throws BancoDeDadosException {

        int reg = this.db.excluir(indice);

        return reg;

    }

    public Compra getCompras() {
        return this.compra;
    }

    public void buscarTodoOsFornecedores() throws BancoDeDadosException {
        fornecedorDAO fdao = new fornecedorDAO();
        this.listaFornecedores = fdao.buscaTodos();
        fdao = null;
    }

    public ArrayList<Fornecedor> getListaFornecedoresCadastrados() {
        return this.listaFornecedores;
    }

    public ArrayList<Compra> getListaCompras() {
        return this.listaCompras;
    }

    public void setCompraSelecionado(int indice) throws BancoDeDadosException {
        this.indice = indice;
        this.compra = this.listaCompras.get(indice);
    }

}
