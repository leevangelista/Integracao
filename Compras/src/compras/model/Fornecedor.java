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
public class Fornecedor {
    private int id;
    private String razao_social;
    private String nome_fantasia;
    private String cnpj;
    private String telefone;
    private String email;

    public Fornecedor() {
        this.id                 = 0;
        this.razao_social       = "";
        this.nome_fantasia      = "";
        this.cnpj               = "";
        this.telefone           = "";
        this.email              = "";
    }
    public Fornecedor(int id, String razao_social, String nome_fantasia, String cnpj, String telefone, String email) {
        
        if (razao_social == null) {
            razao_social = "";
        }
        if (nome_fantasia == null) {
            nome_fantasia = "";
        }
        if (cnpj == null) {
            cnpj = "";
        }
        this.id = id;
        this.razao_social       = razao_social;
        this.nome_fantasia      = nome_fantasia;
        this.cnpj               = cnpj;
        this.telefone           = telefone;
        this.email              = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRazao_social() {
        if (razao_social == null){
            razao_social = "";
        }
        return razao_social;
    }

    public void setRazao_social(String razao_social) {
        if ((razao_social != null) && (!razao_social.equals(""))) {
            this.razao_social = razao_social;
        }
        else {
            System.out.println("A Descrição da Razão Social é Obrigatória!");
        }
    }

    public String getNome_fantasia() {
        if (nome_fantasia == null){
            nome_fantasia = "";
        }
        return nome_fantasia;
    }

    public void setNome_fantasia(String nome_fantasia) {        
        if ((nome_fantasia != null) && (!nome_fantasia.equals(""))) {
            this.nome_fantasia = nome_fantasia;
        }
        else {
            System.out.println("A Descrição do Nome fantasia é Obrigatória!");
        }
    }

    public String getCnpj() {
        if (cnpj == null){
            cnpj = "";
        }
        return cnpj;
    }

    public void setCnpj(String cnpj) {        
        if ((cnpj != null) && (!cnpj.equals(""))) {
            this.cnpj = cnpj;
        }
        else {
            System.out.println("CNPJ Obrigatório!");
        }
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
}
