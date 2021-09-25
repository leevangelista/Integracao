/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compras.dao;

import compras.model.Compra;
import compras.model.Compra_Item;
import compras.model.Fornecedor;
import compras.model.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author G0NN4 CRY
 */
public class compraItemDAO implements IDAO {

    @Override
    public void inserir(Object objeto) throws BancoDeDadosException {
        Compra_Item ci = (Compra_Item) objeto; //cast

        Connection con = Conexao.getConexao();
        PreparedStatement ps = null;

        try {

            ps = con.prepareStatement("INSERT INTO compras_itens(quantidade, valor, compras_id, produtos_id) VALUE(?, ?, ?, ?)");
            ps.setInt(1, ci.getQuantidade());
            ps.setDouble(2, ci.getValor());
            ps.setInt(3, ci.getCompras_id().getId());
            ps.setInt(4, ci.getProdutos_id().getId());

            if (ps.executeUpdate() > 0) {
                ci.setId(this.getIdInserido());
            }

        } catch (SQLException ex) {

            throw new BancoDeDadosException(ex.getMessage());

        } finally {
            try {
                ps.close();
            } catch (SQLException ex) {
                throw new BancoDeDadosException(ex.getMessage());
            }
        }
    }

    private int getIdInserido() throws BancoDeDadosException {

        Connection con = Conexao.getConexao();
        Statement st = null;
        ResultSet rs = null;

        try {

            st = con.createStatement();
            rs = st.executeQuery("SELECT LAST_INSERT_ID() AS ultimo_id");

            rs.first();

            return rs.getInt("ultimo_id");

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
    }

    @Override
    public void atualizar(Object objeto) throws BancoDeDadosException {
        Compra_Item ci = (Compra_Item) objeto; //cast

        Connection con = Conexao.getConexao();
        PreparedStatement ps = null;

        try {
            // quantidade, valor, compras_id, produtos_id
            ps = con.prepareStatement("UPDATE compras_itens SET quantidade = ?, valor = ?, compras_id = ?, produtos_id = ? WHERE id = ?");

            ps.setInt(1, ci.getQuantidade());
            ps.setDouble(2, ci.getValor());
            ps.setInt(3, ci.getCompras_id().getId());
            ps.setInt(4, ci.getProdutos_id().getId());
            ps.setInt(5, ci.getId());

            ps.executeUpdate();

        } catch (SQLException ex) {

            throw new BancoDeDadosException(ex.getMessage());

        } finally {
            try {
                ps.close();
            } catch (SQLException ex) {
                throw new BancoDeDadosException(ex.getMessage());
            }
        }
    }

    @Override
    public Object buscaPorId(int id) throws BancoDeDadosException {
        Connection con = Conexao.getConexao();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Compra_Item ci = null;

        try {

            ps = con.prepareStatement("SELECT * FROM compras WHERE id = ?");
            ps.setInt(1, id);

            rs = ps.executeQuery();

            rs.first();

            ci = new Compra_Item();

            this.preencheObjeto(ci, rs);

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
        return ci;
    }

    @Override
    public int excluir(int id) throws BancoDeDadosException {
        Connection con = Conexao.getConexao();
        PreparedStatement ps = null;

        int totRegistroAfetado = 0;

        try {

            ps = con.prepareStatement("DELETE FROM compras_itens WHERE id = ?");
            ps.setInt(1, id);

            totRegistroAfetado = ps.executeUpdate();

        } catch (SQLException ex) {

            throw new BancoDeDadosException(ex.getMessage());

        } finally {
            try {
                ps.close();
            } catch (SQLException ex) {
                throw new BancoDeDadosException(ex.getMessage());
            }
        }

        return totRegistroAfetado;
    }

    public ArrayList<Compra_Item> buscaTodos() throws BancoDeDadosException {

        Connection con = Conexao.getConexao();
        Statement st = null;
        ResultSet rs = null;
        ArrayList<Compra_Item> lista = new ArrayList<Compra_Item>();

        try {

            st = con.createStatement();

            rs = st.executeQuery("SELECT * FROM compras_itens");

            while (rs.next()) {

                Compra_Item ci = new Compra_Item();
                this.preencheObjeto(ci, rs);

                lista.add(ci);
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

    private void preencheObjeto(Compra_Item ci, ResultSet rs) throws SQLException, BancoDeDadosException {

        // quantidade, valor, compras_id, produtos_id
        ci.setQuantidade(rs.getInt("quantidade"));
        ci.setId(rs.getInt("id"));
        ci.setValor(rs.getDouble("valor"));

        compraDAO cmdao = new compraDAO();
        Compra c = cmdao.buscaPorId(rs.getInt("compras_id"));
        ci.setCompras_id(c);

        produtoDAO prodao = new produtoDAO();
        Produto p = prodao.buscaPorId(rs.getInt("produtos_id"));
        ci.setProdutos_id(p);
    }

}
