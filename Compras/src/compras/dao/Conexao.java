/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compras.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author G0NN4 CRY
 */
public class Conexao {
    private static Connection con = null;
    
    private static void criaConexao(){
        try {
            //carregar o drive do MySQL na memoria
            Class.forName("com.mysql.jdbc.Driver");
            // estabelecer a conexão com o banco de dados
            con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/compras", "root", "");
            
            // definir algumas configuraçoes
        } catch (Exception ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error: " + ex.getMessage());
        }
    }
    
    public static Connection getConexao() {
        if (con == null)
            criaConexao();
        return con;
    }
}
