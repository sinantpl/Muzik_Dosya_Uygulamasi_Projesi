import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.mysql.jdbc.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;
import sun.misc.MessageUtils;


/**
 *
 * @author Sİnan
 */
public class Kullanici2 extends javax.swing.JFrame {

    static String ad;
    static String sifre;
    static String tur;
    
    public Kullanici2() {
        initComponents();
        
    }
   
   

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        kad_text = new javax.swing.JTextField();
        ksif_pass = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();
        dönme = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 18)); // NOI18N
        jLabel1.setText("Şifre:");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(20, 210, 107, 44);

        jLabel2.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 18)); // NOI18N
        jLabel2.setText("Kullanıcı Adı:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(20, 140, 107, 44);

        kad_text.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kad_textActionPerformed(evt);
            }
        });
        getContentPane().add(kad_text);
        kad_text.setBounds(150, 150, 355, 22);

        ksif_pass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ksif_passActionPerformed(evt);
            }
        });
        getContentPane().add(ksif_pass);
        ksif_pass.setBounds(150, 220, 355, 22);

        jButton1.setBackground(new java.awt.Color(0, 153, 102));
        jButton1.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 18)); // NOI18N
        jButton1.setText("GIRIS");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(130, 300, 301, 63);

        dönme.setBackground(new java.awt.Color(153, 255, 255));
        dönme.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 18)); // NOI18N
        dönme.setText("ÖNCEKI EKRANA DÖN");
        dönme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dönmeActionPerformed(evt);
            }
        });
        getContentPane().add(dönme);
        dönme.setBounds(10, 420, 190, 50);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/arkaplanı.png"))); // NOI18N
        getContentPane().add(jLabel3);
        jLabel3.setBounds(0, 0, 570, 540);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 570, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 540, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 570, 540);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void kad_textActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kad_textActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_kad_textActionPerformed

    private void ksif_passActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ksif_passActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ksif_passActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
 
        ad=kad_text.getText();
        sifre=ksif_pass.getText();
         String sql_sorgu="select count(idkullanici) as giris from kullanici where kullaniciadi='"+ad+"'and kullanicisifre='"+sifre+"'";

        ResultSet rs=DB.basla();
        rs=DB.sorgulama(sql_sorgu);
        try {
            while (rs.next()) {
                if (rs.getInt("giris")==1) {
                    Kullanici3 menu7 = new Kullanici3();
                    menu7.setSize(1624,883);
                    menu7.setVisible(true);
                    setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(null,"Giris yapilamadi");
                }
                
            }
        } catch (SQLException ex) {            
            Logger.getLogger(Kullanici2.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,"HATA!!!");
        }
        
      
        
             
        
         
    }//GEN-LAST:event_jButton1ActionPerformed

    private void dönmeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dönmeActionPerformed
        Kullanici menu6 = new Kullanici();
        menu6.setSize(570, 600);
        menu6.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_dönmeActionPerformed

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
            java.util.logging.Logger.getLogger(Kullanici2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Kullanici2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Kullanici2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Kullanici2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Kullanici2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton dönme;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField kad_text;
    private javax.swing.JPasswordField ksif_pass;
    // End of variables declaration//GEN-END:variables
}
