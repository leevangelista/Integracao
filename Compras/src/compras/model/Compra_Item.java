/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compras.model;

/**
 *
 * @author rodrigo
 */
public class Compra_Item {

    private int id;
    private int quantidade;
    private double valor;
    private Compra compras_id;
    private Produto produtos_id;

    public Compra_Item() {
        this.id = 0;
        this.quantidade = 0;
        this.valor = 0;
        this.compras_id = new Compra();
        this.produtos_id = new Produto();
    }

    public Compra_Item(int id, int quantidade, double valor, Compra compras_id, Produto produtos_id) {
        this.id = id;
        this.quantidade = quantidade;
        this.valor = valor;
        this.compras_id = compras_id;
        this.produtos_id = produtos_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        if (quantidade > 0) {
            this.quantidade = quantidade;
        } else {
            System.out.println("Informe a quantidade!");
        }
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        if (valor > 0) {
            this.valor = valor;
        } else {
            System.out.println("Informe o valor!");
        }
    }

    public Compra getCompras_id() {
        return compras_id;
    }

    public void setCompras_id(Compra compras_id) {
        if (compras_id == null) {
            compras_id = new Compra();
        } else {
            this.compras_id = compras_id;
        }
    }

    public Produto getProdutos_id() {
        return produtos_id;
    }

    public void setProdutos_id(Produto produtos_id) {
        if (produtos_id == null) {
            produtos_id = new Produto();
        } else {
            this.produtos_id = produtos_id;
        }
    }
}
