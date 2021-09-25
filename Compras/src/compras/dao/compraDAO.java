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
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author G0NN4 CRY
 */
public class compraDAO implements IDAO {

    @Override
    public void inserir(Object objeto) throws BancoDeDadosException {
        Compra c = (Compra)objeto; //cast
        
        Connection con = Conexao.getConexao();
        PreparedStatement ps = null;
        
        try {
            
            ps = con.prepareStatement("INSERT INTO compras(dat_compra, nota_fiscal, valor_total, fornecedores_id) VALUE(?, ?, ?, ?)");
            ps.setDate(1, new java.sql.Date( c.getDat_compra().getTime().getTime() ));
            ps.setString(2, c.getNota_fiscal());
            ps.setDouble(3, c.getValor_total());
            
            ps.setInt(4, c.getFornecedor().getId());
            
            if ( ps.executeUpdate() > 0 )
                c.setId( this.getIdInserido() );
            
            
        } catch (SQLException ex) {
        
            throw new BancoDeDadosException(ex.getMessage());           
        
        } finally{
            try {
                ps.close();
            } catch (SQLException ex) {
                throw new BancoDeDadosException(ex.getMessage()); 
            }
        }
    }
    
    private int getIdInserido() throws BancoDeDadosException{
        
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
        
        } finally{
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
        Compra c = (Compra)objeto; //cast
        
        Connection con = Conexao.getConexao();
        PreparedStatement ps = null;
        
        try {
            
            ps = con.prepareStatement("UPDATE compras SET dat_compra = ?, nota_fiscal = ?, valor_total = ?, fornecedores_id = ? WHERE id = ?");
            
            ps.setDate(1, new java.sql.Date( c.getDat_compra().getTime().getTime() ));
            ps.setString(2, c.getNota_fiscal());
            ps.setDouble(3, c.getValor_total());
            ps.setInt(4, c.getFornecedor().getId());
            ps.setInt(5, c.getId());
            
            ps.executeUpdate();
            
            
        } catch (SQLException ex) {
        
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
    public Compra buscaPorId(int id) throws BancoDeDadosException {
        Connection con = Conexao.getConexao();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Compra c = null;
        
        try {
            
            ps = con.prepareStatement("SELECT * FROM compras WHERE id = ?");
            ps.setInt(1, id);
            
            rs = ps.executeQuery();
            
            rs.first();
            
            c = new Compra();
            
            this.preencheObjeto(c, rs);
            
        } catch (SQLException ex) {
        
            throw new BancoDeDadosException(ex.getMessage());
        
        } finally{
            try {
                ps.close();
                rs.close();
            } catch (SQLException ex) {
                throw new BancoDeDadosException(ex.getMessage()); 
            }
        }
        
        return c;
    }

    @Override
    public int excluir(int id) throws BancoDeDadosException {
        Connection con = Conexao.getConexao();
        PreparedStatement ps = null;

        int totRegistroAfetado = 0;

        try {

            ps = con.prepareStatement("DELETE FROM compras WHERE id = ?");
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
    
    public ArrayList<Compra> buscaTodos() throws BancoDeDadosException{
        
        Connection con = Conexao.getConexao();
        Statement st = null;
        ResultSet rs = null;
        ArrayList<Compra> lista = new ArrayList<Compra>();
        
        try {
            
            st = con.createStatement();       
            
            rs = st.executeQuery("SELECT * FROM compras");
            
            while( rs.next() ){
                
                    Compra c = new Compra();
                this.preencheObjeto(c, rs);
             
                lista.add(c);
            }     
            
                   
            
        } catch (SQLException ex) {
        
            throw new BancoDeDadosException(ex.getMessage());
        
        } finally{
            try {
                st.close();
                rs.close();
            } catch (SQLException ex) {
                throw new BancoDeDadosException(ex.getMessage()); 
            }
        }
        
        return lista;
    }

    private void preencheObjeto(Compra c, ResultSet rs) throws SQLException, BancoDeDadosException {
        
        // dat_compra, nota_fiscal, valor_total, fornecedor
        Calendar n = Calendar.getInstance();
        n.setTimeInMillis(rs.getDate("dat_compra").getTime());
        c.setDat_compra(n);
        
        c.setNota_fiscal(rs.getString("nota_fiscal"));
        c.setId(rs.getInt("id"));
        c.setValor_total(rs.getDouble("valor_total"));

        fornecedorDAO fordao = new fornecedorDAO();
        Fornecedor f = fordao.buscaPorId(rs.getInt("fornecedores_id"));            
        c.setFornecedor(f);
    }

}
