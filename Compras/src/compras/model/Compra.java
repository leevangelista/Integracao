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
public class Compra {
    private int id;
    private Calendar dat_compra;
    private String nota_fiscal;
    private double valor_total;
    private Fornecedor fornecedor;

    public Compra() {
        this.id                 = 0;
        this.dat_compra         = Calendar.getInstance();
        this.nota_fiscal        = "";
        this.valor_total        = 0;
        this.fornecedor         = new Fornecedor();
    }
    public Compra(int id, Calendar dat_compra, String nota_fiscal, double valor_total, Fornecedor fornecedor) {
        //this.id                 = id;
        
        if (dat_compra == null) {
            dat_compra = Calendar.getInstance();
        }
        this.dat_compra         = dat_compra;
        
        if ( nota_fiscal == null ) {
            nota_fiscal = "";
        }
        this.nota_fiscal        = nota_fiscal;
        this.valor_total        = valor_total;
        this.fornecedor         = fornecedor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Calendar getDat_compra() {
        return dat_compra;
    }

    public void setDat_compra(Calendar dat_compra) {
        if (dat_compra != null) {
            this.dat_compra = dat_compra;
        }
        else {
            System.out.println("Data da Compra Obrigatória");
        }        
    }

    public String getNota_fiscal() {
        return nota_fiscal;
    }

    public void setNota_fiscal(String nota_fiscal) {
        this.nota_fiscal = nota_fiscal;
    }

    public double getValor_total() {
        return valor_total;
    }

    public void setValor_total(double valor_total) {
        this.valor_total = valor_total;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        if ( fornecedor == null ) {
            fornecedor = new Fornecedor();
        }
        this.fornecedor = fornecedor;
    }
    
}
