
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import static java.time.zone.ZoneRulesProvider.refresh;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Asus
 */
public class home extends javax.swing.JFrame {

    /**
     * Creates new form home
     */
    public home() {
        initComponents();
          showprod();
    }
     public void search(){
        String prodname = search.getText();
        
        try{
            String sql = "select * from producttbl where product_name like ?;";
           Class.forName("com.mysql.jdbc.Driver");
           Connection conn = (Connection)DriverManager.getConnection("jdbc:mysql://localhost/argiebsit2?", "root", "");
           PreparedStatement pstmt = conn.prepareStatement(sql);
           pstmt.setString(1, "%"+prodname+"%");
           ResultSet rs = pstmt.executeQuery();
           DefaultTableModel tbl = (DefaultTableModel)protbl.getModel();
           tbl.setRowCount(0);
           if(!rs.isBeforeFirst()){
               tbl.addRow(new Object[]{"NO DATA", "NO DATA", "NO DATA", "NO DATA"});
           }else{
               while(rs.next()){
                   tbl.addRow(new Object[]{rs.getString("id"),rs.getString("product_name"),rs.getString("quantity"),rs.getString("price")});
               }
           }
        } catch (ClassNotFoundException ex) {
        Logger.getLogger(home.class.getName()).log(Level.SEVERE, null, ex);
    } catch (SQLException ex) {
        Logger.getLogger(home.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
    public void showData(){
       String sql = "SELECT * FROM producttbl;";
    
    try{
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = (Connection)DriverManager.getConnection("jdbc:mysql://localhost/argiebsit2?", "root", "");
        PreparedStatement pst = con.prepareStatement(sql);
        
        
        ResultSet r = pst.executeQuery();
        
        DefaultTableModel tbl = (DefaultTableModel)protbl.getModel();
        tbl.setRowCount(0);
        
        while(r.next()){
            tbl.addRow(new Object[]{r.getString("id"),r.getString("product_name"),r.getString("quantity"),r.getString("price")});
            this.setVisible(true);
        }
        
        
    }   catch (ClassNotFoundException ex) {
            Logger.getLogger(home.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(home.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
    
    
    
    
    
public void showprod(){
    String sql = "select * from producttbl;";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = (Connection)DriverManager.getConnection("jdbc:mysql://localhost/argiebsit2?","root","");
            
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            DefaultTableModel tbl = (DefaultTableModel)protbl.getModel();
            tbl.setRowCount(0);
            while(rs.next()){
                tbl.addRow(new Object[]{rs.getInt("id"),rs.getString("product_name"),rs.getInt("quantity"),rs.getString("price")});
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(home.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(home.class.getName()).log(Level.SEVERE, null, ex);
        }
    
            
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        product = new javax.swing.JFrame();
        jLabel6 = new javax.swing.JLabel();
        prodn = new javax.swing.JTextField();
        spnq = new javax.swing.JSpinner();
        addproduct = new javax.swing.JButton();
        fmtp = new javax.swing.JFormattedTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        savebtn = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        protbl = new javax.swing.JTable();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        search = new javax.swing.JTextField();

        product.setMinimumSize(new java.awt.Dimension(400, 300));

        jLabel6.setText("Price:");

        addproduct.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        addproduct.setText("Insert Product");
        addproduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addproductActionPerformed(evt);
            }
        });

        jLabel4.setText("Product Name:");

        jLabel5.setText("Quantity:");

        savebtn.setText("Save");
        savebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                savebtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout productLayout = new javax.swing.GroupLayout(product.getContentPane());
        product.getContentPane().setLayout(productLayout);
        productLayout.setHorizontalGroup(
            productLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(productLayout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addGroup(productLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(productLayout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(productLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(productLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(productLayout.createSequentialGroup()
                                .addComponent(addproduct)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(savebtn))
                            .addComponent(fmtp, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(spnq, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(productLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(prodn, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        productLayout.setVerticalGroup(
            productLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(productLayout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(productLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(prodn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(productLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(spnq, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(productLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(fmtp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(productLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addproduct)
                    .addComponent(savebtn))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Add Product");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        protbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "product", "qty", "price"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        protbl.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(protbl);

        jButton5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton5.setText("Delete");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton6.setText("Edit");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Search Product:");

        search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jButton5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 433, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(search)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton6)
                        .addContainerGap())
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        product.setVisible(true);
        product.setAlwaysOnTop(true);

        // TODO add your handling code here:

    }//GEN-LAST:event_jButton1ActionPerformed

    private void addproductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addproductActionPerformed

        product pdc = new product();
        String pn = prodn.getText();
        int qty = (int) spnq.getValue();
        String price = fmtp.getText();
        //float price = Float.parseFloat(proprice.getValue().toString());
        //System.out.println(price);
        int r = pdc.add(pn, qty, price);
       showprod();
        
        if(r==1){
            JOptionPane.showMessageDialog(rootPane, "New Product Added Successfully");
        }else{

            // TODO add your handli
    }//GEN-LAST:event_addproductActionPerformed
    }
    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        int selRow = protbl.getSelectedRow();
        if (selRow== -1){
            JOptionPane.showMessageDialog(protbl,
                "Please Select Name From Table To Remove." , "Message",JOptionPane.WARNING_MESSAGE);
        }
        else{
            String name = protbl.getValueAt(selRow,1).toString();
            int opt = JOptionPane.showConfirmDialog(protbl, "ARE YOU SURE YOU WANT TO DELETE\n"
                +name,"WARNING", JOptionPane.YES_OPTION);
            if( opt== JOptionPane.YES_OPTION){
                int a = JOptionPane.showConfirmDialog(protbl," THIS WILL DELETE\n"
                    +name,"Confirmation",JOptionPane.ERROR_MESSAGE, JOptionPane.OK_CANCEL_OPTION );
                if (a== JOptionPane.OK_OPTION){
                    int ii = Integer.parseInt(protbl.getValueAt(selRow, 0).toString());
                    try{
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/argiebsit2?", "root", "");
                        String sql = " DELETE FROM `argiebsit2`.`producttbl` where id = ?; ";
                       
                        PreparedStatement pstmt = con.prepareStatement(sql);
                        pstmt.setInt(1, ii);
                        pstmt.executeUpdate();

                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(home.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (SQLException ex) {
                        Logger.getLogger(home.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    JOptionPane.showMessageDialog(protbl, "Product_name" +name+ "DELETED");
                }else{

                }
            }
            else{

            }
        }
        showData();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
      int row = protbl.getSelectedRow();
if(row==-1){
    JOptionPane.showMessageDialog(protbl, "PLEASE SELECT DATA ON THE TABLE","ERROR",JOptionPane.ERROR_MESSAGE);
}else{
    int opti = JOptionPane.showConfirmDialog(protbl, "ARE YOU SURE YOU WANT TO EDIT THIS DATA?","CONFIRMATION",JOptionPane.YES_NO_OPTION);
    if(opti==JOptionPane.YES_OPTION){
    String id = protbl.getValueAt(row, 0).toString();
    String prodname = protbl.getValueAt(row, 1).toString();
    String qu = protbl.getValueAt(row, 2).toString();
    String popri = protbl.getValueAt(row, 3).toString();
  
    prodn.setText(prodname);
    spnq.setToolTipText(qu);
    fmtp.setText(popri);
    this.setVisible(false);
    product.setVisible(true);
    }
}
product.setVisible(true);this.setVisible(false);product.setLocationRelativeTo(null);addproduct.setVisible(false);savebtn.setVisible(true);spnq.setEnabled(false);       // TODO add your handling code here:
                                 
        


// TODO add your handling code here:
    }//GEN-LAST:event_jButton6ActionPerformed

    private void savebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_savebtnActionPerformed

String prdname = prodn.getText();
String prqu = spnq.getToolTipText();
String prci = fmtp.getText();

try{
    String sql = "update product set product_name=?, price=? where id=?;";
    Class.forName("com.mysql.jdbc.Driver");
    Connection conn = (Connection)DriverManager.getConnection("jdbc:mysql://localhost/argiebsit2?", "root", "");
    PreparedStatement pstmt = conn.prepareStatement(sql);
   
    pstmt.setString(1, prdname);
    pstmt.setString(2, prci);
    
    if(prodn.getText().equals("") || fmtp.getText().equals("")){
        JOptionPane.showMessageDialog(product, "PLEASE FILL UP ALL FIELDS","WARNING",JOptionPane.WARNING_MESSAGE);
    }else{
        pstmt.executeUpdate();
        prodn.setText("");
        fmtp.setText("");
        product.setVisible(false);
        home mnp = new home();
        mnp.setVisible(true);
    }
    
}   catch (ClassNotFoundException ex) {
         Logger.getLogger(home.class.getName()).log(Level.SEVERE, null, ex);
    } catch (SQLException ex) {
        Logger.getLogger(home.class.getName()).log(Level.SEVERE, null, ex);
    }        // TODO add your handling code here:
    }//GEN-LAST:event_savebtnActionPerformed

    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchActionPerformed
    


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
            java.util.logging.Logger.getLogger(home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addproduct;
    private javax.swing.JFormattedTextField fmtp;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField prodn;
    private javax.swing.JFrame product;
    private javax.swing.JTable protbl;
    private javax.swing.JButton savebtn;
    private javax.swing.JTextField search;
    private javax.swing.JSpinner spnq;
    // End of variables declaration//GEN-END:variables

    private void clearProduct() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  
}

