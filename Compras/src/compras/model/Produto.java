/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compras.model;

import java.util.Calendar;

/**
 *
 * @author rodrigo
 */
public class Produto {
    private int id;
    private String nome;
    private int estoque;
    private double valor_custo;
    private double valor_venda;
    private Calendar dat_ultima_compra;
    private Fornecedor fornecedor;

    public Produto() {
        this.id                     = 0;
        this.nome                   = "";
        this.estoque                = 0;
        this.valor_custo            = 0;
        this.valor_venda            = 0;
        this.dat_ultima_compra      = Calendar.getInstance();
        this.fornecedor             = new Fornecedor();
    }
    public Produto(int id, String nome, int estoque, double valor_custo, double valor_venda, Calendar dat_ultima_compra, Fornecedor fornecedor) {
        this.id                     = id;
        if (nome == null) {
            nome                    = "";
        }
        this.nome                   = nome;
        
        this.estoque                = estoque;
        this.valor_custo            = valor_custo;
        this.valor_venda            = valor_venda;
        
        if ( dat_ultima_compra == null ) {
            dat_ultima_compra       = Calendar.getInstance();
        }
        this.dat_ultima_compra      = dat_ultima_compra;
        
        if (fornecedor == null) {
            fornecedor              = new Fornecedor();
        }
        this.fornecedor             = fornecedor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if ((nome != null) && (!nome.equals(""))) {
            this.nome = nome;
        }
        else {
            System.out.println("A Descrição do Nome é Obrigatória!");
        }
        this.nome = nome;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

    public double getValor_custo() {
        return valor_custo;
    }

    public void setValor_custo(double valor_custo) {
        this.valor_custo = valor_custo;
    }

    public double getValor_venda() {
        return valor_venda;
    }

    public void setValor_venda(double valor_venda) {
        this.valor_venda = valor_venda;
    }

    public Calendar getDat_ultima_compra() {
        return dat_ultima_compra;
    }

    public void setDat_ultima_compra(Calendar dat_ultima_compra) {
        if ( dat_ultima_compra != null ){
            this.dat_ultima_compra = dat_ultima_compra;
        }
        else {
            System.out.println("A Data é Obrigatória!");
        }
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        if ( fornecedor != null ) {
            this.fornecedor = fornecedor;
        }
        else {
            System.out.println("Informe o Fornecedor!");
        }
    }
}
