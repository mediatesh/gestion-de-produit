/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestion;

import DB_Connect.Parameter;
import DB_Connect.ResultSetTableModel;
import DB_Connect.db_connection;
import static java.lang.Integer.parseInt;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author mediatech
 */
public class Vente extends javax.swing.JPanel {

    /**
     * Creates new form Vente
     */
    ResultSet rs;
    db_connection db;
    int old, dec, now;
    public Vente() {
        db = new db_connection(new Parameter().HOST_DB, new Parameter().USERNAME_DB, new Parameter().PASSWORD_DB, new Parameter().IPHOST, new Parameter().PORT);
        initComponents();
        table();
    }
    public void table() {
        String t[] = {"Code_produit","Nom_Produit","remise","Prix","Stock"};
        rs = db.querySelect(t, "produit");
        tbl_prod.setModel(new ResultSetTableModel(rs));
    }
    public boolean test_stock() throws SQLException {
        boolean teststock;
        rs = db.querySelectAll("produit","Code_produit='" + String.valueOf(tbl_prod.getValueAt(tbl_prod.getSelectedRow(), 0)) + "'");
        while (rs.next()) {
            old = rs.getInt("stock");
        }
        dec = Integer.parseInt(quantite.getText());
        if (old < dec) {
            teststock = false;
        } else {
            teststock = true;
        }
        return teststock;
    }
    public void def(String code,String quantite) throws SQLException {
        rs = db.querySelectAll("produit", "Code_produit='" + code + "'");
        while (rs.next()) {
            old = rs.getInt("stock");
        }
        dec = Integer.parseInt(quantite);
        now = old - dec;
         String nvstock = Integer.toString(now);

        String a = String.valueOf(nvstock);
        String[] colon = {"stock"};
        String[] isi = {a};
        System.out.println(db.queryUpdate("produit", colon, isi, "Code_produit='" + code + "'"));
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        commande = new javax.swing.JTable();
        quantite = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_prod = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        head = new javax.swing.JLabel();
        num_fac = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(85, 65, 118));

        commande.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Code  Produit", "nom", "prix vente", "Quantite", "Totale"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Float.class, java.lang.Integer.class, java.lang.Float.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(commande);

        jButton1.setBackground(new java.awt.Color(50, 194, 77));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Ajouter au Vente");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        tbl_prod.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "code_produit", "Nom_Produit", "remise", "prix", "stock "
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tbl_prod.setGridColor(new java.awt.Color(255, 255, 255));
        tbl_prod.setRowHeight(30);
        tbl_prod.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_prodMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_prod);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Quantité  :");

        jButton2.setBackground(new java.awt.Color(34, 167, 240));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Imprimer");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        head.setBackground(new java.awt.Color(85, 65, 118));
        head.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        head.setForeground(new java.awt.Color(255, 255, 255));
        head.setOpaque(true);

        num_fac.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Numero de facture");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(head, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 816, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(quantite, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(num_fac, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(head, javax.swing.GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(quantite, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(num_fac, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents
    Object[] row = new Object[5];
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if (quantite.getText().equals("")) {
            
            head.setText("SVP entrer quelque chose");
            head.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestion/img/error.png")));
            head.setBackground(new java.awt.Color(242,38,19));
        } else{
            try { 
                if (!test_stock()) {
                    head.setText("le stock est Limiter");
                    head.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestion/img/error.png")));
                    head.setBackground(new java.awt.Color(242,38,19));
                } else {
                    DefaultTableModel model = (DefaultTableModel)commande.getModel();
        
                    float p=Float.parseFloat(tbl_prod.getValueAt(tbl_prod.getSelectedRow(), 3).toString());
                    float r = 1-Float.parseFloat(tbl_prod.getValueAt(tbl_prod.getSelectedRow(), 2).toString())/100;

                    int q=Integer.parseInt(quantite.getText());
                    row[0]=String.valueOf(tbl_prod.getValueAt(tbl_prod.getSelectedRow(), 0));
                    row[1]=String.valueOf(tbl_prod.getValueAt(tbl_prod.getSelectedRow(), 1));
                    row[2]=p*r;
                    row[3]=q;
                    row[4]=p*r*q;
                    model.addRow(row);
                }
            } catch (SQLException ex) {
                Logger.getLogger(Vente.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tbl_prodMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_prodMouseClicked
        
    }//GEN-LAST:event_tbl_prodMouseClicked
    String[] data = new String[7];
    String[] inf = new String[1];
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        
        Date s = new Date();
        SimpleDateFormat vdate = new SimpleDateFormat("dd-MM-yyyy");
        String date= vdate.format(s);
        int rows=commande.getRowCount();
        String[] colon = {"Num_Facture","code_produit", "Nom_produit", "Prix", "Quantite", "Date", "Totale"};
        String[] col = {"stock"};
        
        for(int i = 0; i<rows; i++){
            data[0]=num_fac.getText();
            data[1]=String.valueOf(commande.getValueAt(i, 0));
            data[2]= String.valueOf(commande.getValueAt(i, 1));
            data[3]=String.valueOf(commande.getValueAt(i, 2));
            data[4]=String.valueOf(commande.getValueAt(i, 3));
            data[5]=date;
            data[6]=String.valueOf(commande.getValueAt(i, 4));
            
            try {
                def(data[0],data[4]);
                table();
            } catch (SQLException ex) {
                Logger.getLogger(Vente.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println(db.queryInsert("vente", colon, data)+" "+date);
       }
        head.setText("Votre commande a bien ajouter");
        head.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestion/img/error.png")));
        head.setBackground(new java.awt.Color(50,194,77));
        
        MessageFormat header = new MessageFormat("Facture \n Totale de facture : ");
        MessageFormat footer = new MessageFormat("Page{0,number,integer}");
        try{
            commande.print(JTable.PrintMode.NORMAL, header, footer);
        }catch(java.awt.print.PrinterException e){
            System.err.format("Cannot print", e.getMessage());
        }
        this.printComponents(null);
        
    }//GEN-LAST:event_jButton2ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable commande;
    private javax.swing.JLabel head;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField num_fac;
    private javax.swing.JTextField quantite;
    private javax.swing.JTable tbl_prod;
    // End of variables declaration//GEN-END:variables
}