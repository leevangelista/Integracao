/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compras.view;

import Utilitarios.GerenciadorDeArquivo;
import compras.controller.ProdutosController;
import compras.dao.BancoDeDadosException;
import Utilitarios.Utilitarios;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import compras.model.Fornecedor; 

/**
 *
 * @author rodri
 */
public class Produto extends javax.swing.JFrame {

    private ProdutosController controlador;

    public Produto() throws BancoDeDadosException, ParseException {
        initComponents();
        this.setLocationRelativeTo(null);

        this.controlador = new ProdutosController();
        preencheTabela();
    }

    public void preencheTabela() {

        limpaTabela();

        for (int i = 0; i < this.controlador.getListaProdutos().size(); i++) {

            ((DefaultTableModel) this.jtProdutos.getModel()).addRow(
                    new Object[]{
                        this.controlador.getListaProdutos().get(i).getId(),
                        this.controlador.getListaProdutos().get(i).getNome(),
                        this.controlador.getListaProdutos().get(i).getEstoque(),
                        this.controlador.getListaProdutos().get(i).getValor_custo(),
                        this.controlador.getListaProdutos().get(i).getValor_venda(),
                        Utilitarios.formatarData(this.controlador.getListaProdutos().get(i).getDat_ultima_compra()),
                        this.controlador.getListaProdutos().get(i).getFornecedor().getNome_fantasia()
                    }
            );
        }
    }

    private void limpaTabela() {

        for (int i = 1; i < this.controlador.getListaProdutos().size(); i++) {
            if (((DefaultTableModel) this.jtProdutos.getModel()).getRowCount() > 0) {
                ((DefaultTableModel) this.jtProdutos.getModel()).removeRow(i - 1);
            }

        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtProdutos = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Produtos");

        jtProdutos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome", "Estoque", "Valor Custo", "Valor Venda", "Ultima compra", "Fornecedor"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Double.class, java.lang.Double.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jtProdutos);

        jButton1.setText("Voltar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Importar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 849, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(0, 756, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jButton2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton1)))
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        Menu menu = new Menu();
        menu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        String diretorio = "C:\\Compras";
        String nomeArquivo = "Produtos.csv";
        String linha = "";
        try {
            ArrayList<String> dados = GerenciadorDeArquivo.leituraDeDadosEmArquivo(new File(diretorio+"\\"+nomeArquivo));
            for (String dado : dados) {
                String produto[] = dado.split(";");
                controlador.salvarProduto(Integer.parseInt(produto[0]),
                                          produto[1],
                                          Integer.parseInt(produto[2]),
                                          Double.parseDouble(produto[3]),
                                          Double.parseDouble(produto[4]), 
                                          produto[5], 
                                          Integer.parseInt(produto[6]));
                        ArrayList<String> l = new ArrayList<String>();
                        l.add(linha);
                        try {
                            GerenciadorDeArquivo.gravaEmArquivo("C:\\Compras\\Pronto\\prontoFornecedor.csv", l);
                        } catch (IOException ex1) {
                            Logger.getLogger(Produto.class.getName()).log(Level.SEVERE, null, ex1);
                        };
                        break;
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(rootPane, "Ocorreu um erro no processo de leitura. Verifique se o arquivo está correto.");
        } catch (BancoDeDadosException ex) {
            linha = linha+';'+ex.getMessage();
            ArrayList<String> l = new ArrayList<String>();
            l.add(linha);
            try {
                GerenciadorDeArquivo.gravaEmArquivo("C:\\Compras\\Erro\\erroFornecedor.csv", l);
            } catch (IOException ex1) {
                Logger.getLogger(Produto.class.getName()).log(Level.SEVERE, null, ex1);
            }
            JOptionPane.showMessageDialog(rootPane, "Ocorreu um erro no banco de dados durante o salvamento. Verifique se algum dado do arquivo está coerente com a documentação.");
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Produto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Produto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Produto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Produto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Produto().setVisible(true);
                } catch (BancoDeDadosException | ParseException ex) {
                    Logger.getLogger(Produto.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtProdutos;
    // End of variables declaration//GEN-END:variables
}
