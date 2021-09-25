/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compras.dao;

import compras.model.Compra;
import compras.model.Fornecedor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;

/**
 *
 * @author G0NN4 CRY
 */
public class fornecedorDAO implements IDAO {

    @Override
    public void inserir(Object objeto) throws BancoDeDadosException {
        Fornecedor f = (Fornecedor)objeto;
        Connection con = Conexao.getConexao();
        PreparedStatement ps = null;
        
        try {
            ps = con.prepareStatement("INSERT INTO fornecedores(id, razao_social, nome_fantasia, cnpj, telefone, email) VALUE(?, ?, ?, ?, ?, ?)");
            ps.setInt(1, f.getId());
            ps.setString(2, f.getRazao_social().replaceAll("\"", ""));
            ps.setString(3, f.getNome_fantasia().replaceAll("\"", ""));
            ps.setString(4, f.getCnpj().replaceAll("\"", ""));
            ps.setString(5, f.getTelefone().replaceAll("\"", ""));
            ps.setString(6, f.getEmail().replaceAll("\"", ""));
            
            ps.executeUpdate();
        } catch (SQLException ex) {   
            System.out.println(ex.getMessage());
            throw new BancoDeDadosException(ex.getMessage());           
        } finally{
            try {
                ps.close();
            } catch (SQLException ex) {
                throw new BancoDeDadosException(ex.getMessage()); 
            }
        }
    }

    private int getIdInserido() throws BancoDeDadosException {
        return 0;
    }

    @Override
    public void atualizar(Object objeto) throws BancoDeDadosException {
        Fornecedor f = (Fornecedor)objeto;
        Connection con = Conexao.getConexao();
        PreparedStatement ps = null;
        
         try {
            ps = con.prepareStatement("UPDATE fornecedores SET razao_social=?, nome_fantasia=?, cnpj=?, telefone=?, email=? WHERE id=?");
            ps.setString(1, f.getRazao_social().replaceAll("\"", ""));
            ps.setString(2, f.getNome_fantasia().replaceAll("\"", ""));
            ps.setString(3, f.getCnpj().replaceAll("\"", ""));
            ps.setString(4, f.getTelefone().replaceAll("\"", ""));
            ps.setString(5, f.getEmail().replaceAll("\"", ""));
            ps.setInt(6, f.getId());
            
            ps.executeUpdate();
        } catch (SQLException ex) {   
            ex.printStackTrace();
            System.out.println(ex.getMessage());
            throw new BancoDeDadosException(ex.getMessage());           
        } finally{
            try {
                ps.close();
            } catch (SQLException ex) {
                throw new BancoDeDadosException(ex.getMessage()); 
            }
        }
    }

    @Override
    public Fornecedor buscaPorId(int id) throws BancoDeDadosException {
        Connection con = Conexao.getConexao();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Fornecedor f = null;

        try {

            ps = con.prepareStatement("SELECT * FROM fornecedores WHERE id = ?");
            ps.setInt(1, id);

            rs = ps.executeQuery();

            rs.first();

            f = new Fornecedor();

            this.preencheObjeto(f, rs);

        } catch (SQLException ex) {

            throw new BancoDeDadosException(ex.getMessage());

        } finally {
            try {
                ps.close();
                rs.close();
            } catch (SQLException ex) {
                throw new BancoDeDadosException(ex.getMessage());
            }
        }
        return f;
    }

    @Override
    public int excluir(int id) throws BancoDeDadosException {
        return 0;
    }

    public ArrayList<Fornecedor> buscaTodos() throws BancoDeDadosException {
        Connection con = Conexao.getConexao();
        Statement st = null;
        ResultSet rs = null;
        ArrayList<Fornecedor> lista = new ArrayList<Fornecedor>();

        try {

            st = con.createStatement();

            rs = st.executeQuery("SELECT * FROM fornecedores");

            while (rs.next()) {

                Fornecedor f = new Fornecedor();
                this.preencheObjeto(f, rs);

                lista.add(f);
            }

        } catch (SQLException ex) {

            throw new BancoDeDadosException(ex.getMessage());

        } finally {
            try {
                st.close();
                rs.close();
            } catch (SQLException ex) {
                throw new BancoDeDadosException(ex.getMessage());
            }
        }
        return lista;
    }

    private void preencheObjeto(Fornecedor f, ResultSet rs) throws SQLException, BancoDeDadosException {

        f.setId(rs.getInt("id"));
        f.setRazao_social(rs.getString("razao_social"));
        f.setNome_fantasia(rs.getString("nome_fantasia"));
        f.setCnpj(rs.getString("cnpj"));
        f.setTelefone(rs.getString("telefone"));
        f.setEmail(rs.getString("email"));
    }
}
