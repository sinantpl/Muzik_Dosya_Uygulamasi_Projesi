import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.mysql.jdbc.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Kullanici extends javax.swing.JFrame {

    /**
     * Creates new form Kullanici
     */
    public Kullanici() {
        initComponents();
    }
     
    public void KullaniciTablo(String ad){
        Connection connect=null;
        DB db=new DB();
        PreparedStatement statement =null;
        
        try {
            connect = db.getConnection();
            String sql="CREATE  TABLE musicapp."+ad+" (\n" +
                "idkullanici INT UNSIGNED AUTO_INCREMENT , \n" +
                "muziktur VARCHAR(50) NOT NULL,\n" +
                "sarkiadi VARCHAR(50) NOT NULL, \n" +
                "sanatci VARCHAR(50) NOT NULL,\n" +
                "PRIMARY KEY ( idkullanici)\n" +
                ");";
            statement=connect.prepareStatement(sql);
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Kullanici.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void KullaniciTakip(String ad){
        Connection connect=null;
        DB db=new DB();
        PreparedStatement statement =null;
        
        try {
            connect = db.getConnection();
            String sql="CREATE  TABLE musicapp."+ad+"takip (\n" +
                "idkullanici INT UNSIGNED AUTO_INCREMENT , \n" +
                "kullaniciadi VARCHAR(50) NOT NULL,\n" +
                "kullaniciemail VARCHAR(50) NOT NULL, \n" +
                "kullanicitur VARCHAR(50) NOT NULL,\n" +
                "kullaniciulke VARCHAR(50) NOT NULL,\n" +
                "PRIMARY KEY ( idkullanici)\n" +
                ");";
            statement=connect.prepareStatement(sql);
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Kullanici.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void  Insert () throws SQLException{
         Connection connect=null;
         DB db=new DB();
         PreparedStatement statement =null;
         
         try{
         connect = db.getConnection();
         String sql="insert into musicapp.kullanici (kullaniciadi,kullaniciemail,kullanicisifre,kullanicitur,kullaniciulke)"
                 +"values(?,?,?,?,?)";
         statement=connect.prepareStatement(sql);
         statement.setString(1, ad_text.getText());
         statement.setString(2, mail_text.getText());
         statement.setString(3, sifre_password.getText());
         statement.setString(4, jComboBox1.getSelectedItem().toString());
         statement.setString(5, ulke_text.getText());
         statement.executeUpdate();
         JOptionPane.showMessageDialog(null,"Kayıt Başarıyla Eklendi");
         }catch(SQLException exception){
             db.ShowError(exception);
         }finally{
             statement.close();
             connect.close();
         }
         
             
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        ad_text = new javax.swing.JTextField();
        ulke_text = new javax.swing.JTextField();
        sifre_password = new javax.swing.JPasswordField();
        mail_text = new javax.swing.JTextField();
        kaydolbutonu = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        temizle = new javax.swing.JButton();
        dönme = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 102, 102));
        jLabel1.setText("ÜYE KAYIT FORMU");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(190, 30, 190, 50);

        jLabel2.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 14)); // NOI18N
        jLabel2.setText("Ülke:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(20, 330, 70, 20);

        jLabel7.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 14)); // NOI18N
        jLabel7.setText("Kullanıcı Adı:");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(20, 100, 70, 20);

        jLabel9.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 14)); // NOI18N
        jLabel9.setText("Sifre:");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(20, 210, 30, 20);

        jLabel10.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 14)); // NOI18N
        jLabel10.setText("Üyelik Tipi:");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(20, 270, 70, 20);

        jButton1.setBackground(new java.awt.Color(204, 204, 255));
        jButton1.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 18)); // NOI18N
        jButton1.setText("ZATEN BIR HESABIM VAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(130, 430, 310, 50);

        ad_text.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ad_textActionPerformed(evt);
            }
        });
        getContentPane().add(ad_text);
        ad_text.setBounds(100, 100, 370, 22);

        ulke_text.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ulke_textActionPerformed(evt);
            }
        });
        getContentPane().add(ulke_text);
        ulke_text.setBounds(100, 330, 370, 22);
        getContentPane().add(sifre_password);
        sifre_password.setBounds(100, 210, 370, 22);

        mail_text.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mail_textActionPerformed(evt);
            }
        });
        getContentPane().add(mail_text);
        mail_text.setBounds(100, 150, 370, 22);

        kaydolbutonu.setBackground(new java.awt.Color(0, 153, 51));
        kaydolbutonu.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 18)); // NOI18N
        kaydolbutonu.setText("KAYIT OL");
        kaydolbutonu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kaydolbutonuActionPerformed(evt);
            }
        });
        getContentPane().add(kaydolbutonu);
        kaydolbutonu.setBounds(130, 370, 310, 50);

        jLabel11.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 14)); // NOI18N
        jLabel11.setText("E-mail:");
        getContentPane().add(jLabel11);
        jLabel11.setBounds(20, 150, 40, 20);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Premium", "Normal" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBox1);
        jComboBox1.setBounds(100, 270, 90, 22);

        temizle.setBackground(new java.awt.Color(255, 102, 102));
        temizle.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 18)); // NOI18N
        temizle.setText("TEMIZLE");
        temizle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                temizleActionPerformed(evt);
            }
        });
        getContentPane().add(temizle);
        temizle.setBounds(350, 490, 190, 50);

        dönme.setBackground(new java.awt.Color(153, 255, 255));
        dönme.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 18)); // NOI18N
        dönme.setText("ÖNCEKI EKRANA DÖN");
        dönme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dönmeActionPerformed(evt);
            }
        });
        getContentPane().add(dönme);
        dönme.setBounds(10, 490, 190, 50);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/arkaplanı.png"))); // NOI18N
        getContentPane().add(jLabel3);
        jLabel3.setBounds(0, 0, 570, 600);
        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 570, 600);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        setVisible(false);
        Kullanici2 menu3 = new Kullanici2();
        menu3.setSize(570, 540);
        menu3.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void ad_textActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ad_textActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ad_textActionPerformed

    private void ulke_textActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ulke_textActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ulke_textActionPerformed

    private void mail_textActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mail_textActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mail_textActionPerformed

    private void kaydolbutonuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kaydolbutonuActionPerformed
        try {
            Insert();
            KullaniciTablo(ad_text.getText());
            KullaniciTakip(ad_text.getText());
        } catch (SQLException ex) {
            Logger.getLogger(Kullanici.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_kaydolbutonuActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void temizleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_temizleActionPerformed
        ad_text.setText(null);
        mail_text.setText(null);
        sifre_password.setText(null);
        ulke_text.setText(null);
        jComboBox1.setSelectedIndex(0);
    }//GEN-LAST:event_temizleActionPerformed

    private void dönmeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dönmeActionPerformed
        Giris menu6 = new Giris();
        menu6.setSize(570, 540);
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
            java.util.logging.Logger.getLogger(Kullanici.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Kullanici.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Kullanici.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Kullanici.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Kullanici().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField ad_text;
    private javax.swing.JButton dönme;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton kaydolbutonu;
    private javax.swing.JTextField mail_text;
    private javax.swing.JPasswordField sifre_password;
    private javax.swing.JButton temizle;
    private javax.swing.JTextField ulke_text;
    // End of variables declaration//GEN-END:variables
}
