/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package atm_v1;

import atm_v1.processData.Customer;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author at01
 */
public class ChuyenKhoan extends javax.swing.JFrame {
    static ArrayList<Customer> list;
     SingIn singin;
    /**
     * Creates new form ChuyenKhoan
     */
    public ChuyenKhoan() {
        initComponents();
        this.list=singin.list;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtSTK = new javax.swing.JTextField();
        txtTien = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel1.setText("Chuyển tiền tới số Tài Khoản");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel2.setText("Chuyển số tiền ");

        txtSTK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSTKActionPerformed(evt);
            }
        });

        txtTien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTienActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/thuchien.png"))); // NOI18N
        jButton1.setText("OK");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jButton1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButton1KeyPressed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/thuchien.png"))); // NOI18N
        jButton2.setText("Cancel");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jButton2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButton2KeyPressed(evt);
            }
        });

        jLabel3.setText("VNĐ");

        jMenu1.setBackground(new java.awt.Color(255, 255, 51));
        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/chuyentien.gif"))); // NOI18N
        jMenu1.setText("Chuyển Khoản");
        jMenu1.setToolTipText("");
        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtSTK))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(89, 89, 89)
                        .addComponent(txtTien, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSTK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtTien, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(47, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        int d=0;
        for(int i=0;i<list.size();i++){
            if(list.get(i).pass.equals(singin.password))
            {
                d=i;
            }
        }
        int _tk=Integer.parseInt(txtSTK.getText());
        //checkFormat: Kiem tra so tien can chuyen la 1 so
        boolean checkFormat=true;
        try {
             _tk =(int) Double.parseDouble(txtSTK.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
            checkFormat=false;
            setjTextField1(txtSTK);
        }
        
        String acount=txtSTK.getText();
        JOptionPane.showMessageDialog(this, "Test: "+list.get(d).name);
        //Check1: Kiem tra tai khoan nguoi nhan trung TK nguoi gui
        boolean check1=txtSTK.getText().equals(list.get(d).so_tk);
        if(txtSTK.getText().length()!= 0){
            JOptionPane.showMessageDialog(this, "OK");
            //Check: Kiem tra nguoi nhan co trong DataBase ko?
            boolean check=false;
            for(int i=0;i<list.size();i++){
                if(list.get(i).so_tk.equals(txtSTK.getText()))
                    check=true;
            }
            //Check jTextFiled2 khac Null
            if(txtSTK.getText().length()!=0){
                //Check nguoi nhan co trong DataBase
                if(check){
                    //Check trung tai khoan nguoi gui
                    if(!txtTien.getText().equals(list.get(d).so_tk)){
                        JOptionPane.showMessageDialog(this, "OK");
                        //checkFormat: Kiem tra so tien can chuyen la 1 so
                        try {
                             _tk =(int) Double.parseDouble(txtTien.getText());
                        } catch (NumberFormatException e) {
                            JOptionPane.showMessageDialog(this, e.getMessage());
                            checkFormat=false;
                           setjTextField1(txtTien);
                        }
                        //Check so tien phai la so
                        if(checkFormat){
                            /////////////////////////////////////
                            if(_tk%10==0&&_tk>0){
                                if(list.get(d).tk-50<_tk){
                                        JOptionPane.showMessageDialog(this, "Tai khoan khong du");
                                        setjTextField1(txtTien);
                                }
                                else{
                                    list.get(d).tk-=_tk;
                                    processData prD=new processData();
                                    File f=new File("dataATM.txt");
                                    try {            
                                        prD.writeListToFile(list, f);
                                    } catch (FileNotFoundException ex) {
                                        Logger.getLogger(RutTien.class.getName()).log(Level.SEVERE, null, ex);
                                    } catch (IOException ex) {
                                        Logger.getLogger(RutTien.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                    JOptionPane.showMessageDialog(this, "Chuyen khoan thanh cong");
                                    this.dispose();
                                    new giaodien().setVisible(true);
                                }
                            }
                            else{
                                 JOptionPane.showMessageDialog(this, "So tien chuyen khoan phai la boi cua 10 va khong am.");
                                 setjTextField2(txtTien);
                            }
                            ////////////////////////////////////
                        }
                        else{
                            JOptionPane.showMessageDialog(this, "So tien ban nhap khong dung");
                            //setjTextField1(jTextField1);//
                            setjTextField2(txtTien);
                        }
                    }
                    else{
                        JOptionPane.showMessageDialog(this, "Khong the chuyen khoan cho chinh ban.");
                        setjTextField1(txtSTK);
                    }

                }
                else{
                    JOptionPane.showMessageDialog(this, "TK nguoi nhan khong dung");
                    setjTextField1(txtSTK);
                }

            }
            if(txtTien.getText().length()==0){
                JOptionPane.showMessageDialog(this, "Ban chua nhap so tien can chuyen");
                setjTextField2(txtTien);
            }
        }
        if(txtSTK.getText().length()==0){
            JOptionPane.showMessageDialog(this, "Ban chua nhap TK");
            setjTextField1(txtSTK);
        }
            //Check1:kiem tra tai khoan nguoi nhan trung TK nguoi gui
            if(!check1){
                if(checkFormat){
                   if(!check1){
                        JOptionPane.showMessageDialog(this, "So TK khong dung!");
                        setjTextField1(txtSTK);
                    }
                    else{
                        if(_tk%10==0){
                            if(_tk>list.get(d).tk-50){
                                JOptionPane.showMessageDialog(this, "TK cua ban khong du!");
                                setjTextField1(txtTien);
                            }
                            else{
                                list.get(d).tk-=_tk;
                                for(int i=0;i<list.size();i++){
                                    if(list.get(i).so_tk.equals(acount)){
                                        list.get(i).tk+=_tk;
                                    }
                                }
                                processData prD=new processData();
                                File f=new File("dataATM.txt");
                                try {                               
                                    prD.writeListToFile(list, f);
                                } catch (FileNotFoundException ex) {
                                    Logger.getLogger(ChuyenKhoan.class.getName()).log(Level.SEVERE, null, ex);
                                } catch (IOException ex) {
                                    Logger.getLogger(ChuyenKhoan.class.getName()).log(Level.SEVERE, null, ex);
                                }

                                JOptionPane.showMessageDialog(this, "Chuyen khoan thanh cong!");
                                this.dispose();
                            }
                        }
                        else {
                            JOptionPane.showMessageDialog(this, "So tien can chuyen phai la boi cua 10.");
                               setjTextField1(txtTien);
                       }
                   }
                }
                else{
                    JOptionPane.showMessageDialog(this, "So tien can chuyen khong dung");
                                setjTextField2(txtTien);
               }    
           }
            //Check tai khoan nguoi nhan trung TK nguoi gui
            else{
                JOptionPane.showMessageDialog(this, "Khong the chuyen cho TK cua ban");
    setjTextField1(txtSTK);
           }
        


    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        this.dispose();
        //new giaodien().setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void txtSTKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSTKActionPerformed
        // TODO add your handling code here:
        jButton1ActionPerformed(evt);
    }//GEN-LAST:event_txtSTKActionPerformed

    private void txtTienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTienActionPerformed
        // TODO add your handling code here:
        jButton1ActionPerformed(evt);
    }//GEN-LAST:event_txtTienActionPerformed

    private void jButton1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton1KeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            jButton1ActionPerformed(null);
        }
    }//GEN-LAST:event_jButton1KeyPressed

    private void jButton2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton2KeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            jButton2ActionPerformed(null);
        }
    }//GEN-LAST:event_jButton2KeyPressed

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
            java.util.logging.Logger.getLogger(ChuyenKhoan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ChuyenKhoan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ChuyenKhoan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ChuyenKhoan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ChuyenKhoan().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JTextField txtSTK;
    private javax.swing.JTextField txtTien;
    // End of variables declaration//GEN-END:variables

    public void setjTextField1(JTextField jTextField1) {
        this.txtSTK = jTextField1;
    }

    public void setjTextField2(JTextField jTextField2) {
        this.txtTien = jTextField2;
    }
    public void loadck(String stk) {
        Connection con = null;
        ResultSet rs = null;
        CallableStatement cstmt = null;

        try {
            cstmt = con.prepareCall("{call getCustomerId(?)}");
            cstmt.setString(1, stk);
            rs = cstmt.executeQuery();
            while (rs.next()) {
                cstmt = con.prepareCall("{call getCustomer}");
                txtTien.setText(stk);

            }
        } catch (SQLException ex) {
            Logger.getLogger(SingIn.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
}