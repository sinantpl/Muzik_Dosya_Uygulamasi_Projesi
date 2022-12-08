import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.mysql.jdbc.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import sun.misc.MessageUtils;
import java.sql.ResultSet;
import net.proteanit.sql.DbUtils;
/**
 *
 * @author Sİnan
 */
public class admin extends javax.swing.JFrame {

    /**
     * Creates new form admin
     */
    public admin() {
        initComponents();
        TabloDoldur();
    }

    public void TabloDoldur(){
        Connection connect=null;
         DB db=new DB();
         PreparedStatement statement =null;
          ResultSet rs = null;
        try {
            connect = db.getConnection();
            String sql="select * from musicapp.sarki";
            statement=connect.prepareStatement(sql);
             rs = statement.executeQuery();
             jTable1.setModel(DbUtils.resultSetToTableModel (rs));
             connect.close();
        } catch (SQLException ex) {
            Logger.getLogger(admin.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void  TurInsert () throws SQLException{
         Connection connect=null;
         DB db=new DB();
         PreparedStatement statement =null;
         
         try{
         connect = db.getConnection();
         String sql="insert into musicapp.turtablo (muziktur,sarkiadi)"
                 +"values(?,?)";
         statement=connect.prepareStatement(sql);
         statement.setString(1, tur_txt.getText());
         statement.setString(2, sarki_txt.getText());
         statement.executeUpdate();
         
         }catch(SQLException exception){
             db.ShowError(exception);
             JOptionPane.showMessageDialog(null,"Şarkı Tür Tablosuna Eklenemedi");
         }finally{
             statement.close();
             connect.close();
         }
         
             
    }
    public void  TurDelete (int id) throws SQLException{
         Connection connect=null;
         DB db=new DB();
         PreparedStatement statement =null;
         
         try{
         connect = db.getConnection();
         String sql="DELETE from turtablo where idsarki="+id;
         statement=connect.prepareStatement(sql);
         
         statement.executeUpdate();
         
         
         }catch(SQLException exception){
             db.ShowError(exception);
            JOptionPane.showMessageDialog(null,"Şarkı Tür Tablosundan Silinemedi");
         }finally{
             statement.close();
             connect.close();
         }
         
        
    }
    public void  TurUpdate (int id,String tur,String sarki) throws SQLException{
         Connection connect=null;
         DB db=new DB();
         PreparedStatement statement =null;
         
         try{
         connect = db.getConnection();
         String sql="Update turtablo set muziktur='"+tur+"',"+"sarkiadi='"+sarki+"' where idsarki="+id;
         
                 
         statement=connect.prepareStatement(sql);
         
         statement.executeUpdate();

         }catch(SQLException exception){
             db.ShowError(exception);
             JOptionPane.showMessageDialog(null,"Şarkı Tür Tablosunda Güncellenemedi");
         }finally{
             statement.close();
             connect.close();
         }
         
         
             
    }
    
    
    public void  SanatciInsert () throws SQLException{
         Connection connect=null;
         DB db=new DB();
         PreparedStatement statement =null;
         
         try{
         connect = db.getConnection();
         String sql="insert into musicapp.sanatcitablo (sanatciadi,sanatciulke)"
                 +"values(?,?)";
         statement=connect.prepareStatement(sql);
         statement.setString(1, sanatci_txt.getText());
         statement.setString(2, "-");
         statement.executeUpdate();

         }catch(SQLException exception){
             db.ShowError(exception);
             JOptionPane.showMessageDialog(null,"Sanatçı Eklenemedi");
         }finally{
             statement.close();
             connect.close();
         }
         
             
    }
    public void  SanatciDelete (int id) throws SQLException{
         Connection connect=null;
         DB db=new DB();
         PreparedStatement statement =null;
         
         try{
         connect = db.getConnection();
         String sql="DELETE from musicapp.sanatcitablo where idsarki="+id;
         statement=connect.prepareStatement(sql);
         
         statement.executeUpdate();
         
         
         }catch(SQLException exception){
             db.ShowError(exception);
             JOptionPane.showMessageDialog(null,"Sanatçı Tablodan Silinemedi");
         }finally{
             statement.close();
             connect.close();
         }  
    }
    public void  SanatciUpdate (int id,String sanatciad) throws SQLException{
         Connection connect=null;
         DB db=new DB();
         PreparedStatement statement =null;
         
         try{
         connect = db.getConnection();
         String sql="Update musicapp.sanatcitablo set sanatciadi='"+sanatciad+"' where idsarki="+id;
         
         statement=connect.prepareStatement(sql);
         
         statement.executeUpdate();

         }catch(SQLException exception){
             db.ShowError(exception);
             JOptionPane.showMessageDialog(null,"Sanatçı Tablodan Güncellenemedi");
         }finally{
             statement.close();
             connect.close();
         }      
    }
    
    
    
    
    public void  MusicInsert () throws SQLException{
         Connection connect=null;
         DB db=new DB();
         PreparedStatement statement =null;
         
         try{
         connect = db.getConnection();
         String sql="insert into musicapp.sarki (sarkiadi,sarkitarih,sanatci,album,muziktur,muziksure,dinlenmesayi)"
                 +"values(?,?,?,?,?,?,?)";
         statement=connect.prepareStatement(sql);
         statement.setString(1, sarki_txt.getText());
         statement.setString(2, tarih_txt.getText());
         statement.setString(3, sanatci_txt.getText());
         statement.setString(4, album_txt.getText());
         statement.setString(5, tur_txt.getText());
         statement.setString(6, sure_txt.getText());
         statement.setString(7, dsayi_txt.getText());
         statement.executeUpdate();
         JOptionPane.showMessageDialog(null,"Şarkı Başarıyla Eklendi");
         }catch(SQLException exception){
             db.ShowError(exception);
             JOptionPane.showMessageDialog(null,"Şarkı Eklenemedi");
         }finally{
             statement.close();
             connect.close();
         }
         
             
    }
       
     public void  MusicUpdate (int id,String ad,String tarih,String sanatci,String album,String tur,String sure,String dsayi) throws SQLException{
         Connection connect=null;
         DB db=new DB();
         PreparedStatement statement =null;
         
         try{
         connect = db.getConnection();
         String sql="Update sarki set sarkiadi='"+ad+"',"+"sarkitarih='"+tarih+"',"+"sanatci='"+sanatci+"',"+"album='"+album+"',"+"muziktur='"+
                 tur+"',"+"muziksure='"+sure+"',"+"dinlenmesayi='"+dsayi+"' where idsarki="+id;
         
                 
         statement=connect.prepareStatement(sql);
         
         statement.executeUpdate();
         JOptionPane.showMessageDialog(null,"Şarkı Başarıyla Güncellendi");
         }catch(SQLException exception){
             db.ShowError(exception);
             JOptionPane.showMessageDialog(null,"Şarkı Güncellenemedi");
         }finally{
             statement.close();
             connect.close();
         }
         
         
             
    }
     public void  MusicDelete (int id) throws SQLException{
         Connection connect=null;
         DB db=new DB();
         PreparedStatement statement =null;
         
         try{
         connect = db.getConnection();
         String sql="DELETE from sarki where idsarki="+id;
         statement=connect.prepareStatement(sql);
         
         statement.executeUpdate();
         
         JOptionPane.showMessageDialog(null,"Şarkı Silindi");
         }catch(SQLException exception){
             db.ShowError(exception);
             JOptionPane.showMessageDialog(null,"Şarkı Silinemedi");
         }finally{
             statement.close();
             connect.close();
         }
         
        
    }
     
     
     public void  AlbumInsert () throws SQLException{
         Connection connect=null;
         DB db=new DB();
         PreparedStatement statement =null;
         
         try{
         connect = db.getConnection();
         String sql="insert into musicapp.albumtablo (album,sarkiadi,sanatci,sarkitarih,muziktur)"
                 +"values(?,?,?,?,?)";
         statement=connect.prepareStatement(sql);
         statement.setString(1, album_txt.getText());
         statement.setString(2, sarki_txt.getText());
         statement.setString(3, sanatci_txt.getText());
         statement.setString(4, tarih_txt.getText());
         statement.setString(5, tur_txt.getText());
         
         statement.executeUpdate();

         }catch(SQLException exception){
             db.ShowError(exception);
             JOptionPane.showMessageDialog(null,"Albüm Eklenemedi");
         }finally{
             statement.close();
             connect.close();
         }
         
             
    }
       
     public void  AlbumUpdate (int id,String album,String sarkiadi,String sanatci,String tarih,String tur) throws SQLException{
         Connection connect=null;
         DB db=new DB();
         PreparedStatement statement =null;
         
         try{
         connect = db.getConnection();
         String sql="Update albumtablo set album='"+album+"',"+"sarkiadi='"+sarkiadi+"',"+"sanatci='"+sanatci+"',"+"sarkitarih='"+tarih+"',"+"muziktur='"+
                 tur+"' where idsarki="+id;
         
                 
         statement=connect.prepareStatement(sql);
         
         statement.executeUpdate();

         }catch(SQLException exception){
             db.ShowError(exception);
             JOptionPane.showMessageDialog(null,"Albüm Güncellenemedi");
         }finally{
             statement.close();
             connect.close();
         }
         
         
             
    }
     public void  AlbumDelete (int id) throws SQLException{
         Connection connect=null;
         DB db=new DB();
         PreparedStatement statement =null;
         
         try{
         connect = db.getConnection();
         String sql="DELETE from albumtablo where idsarki="+id;
         statement=connect.prepareStatement(sql);
         
         statement.executeUpdate();
         

         }catch(SQLException exception){
             db.ShowError(exception);
             JOptionPane.showMessageDialog(null,"Album Silinemedi");
         }finally{
             statement.close();
             connect.close();
         }    
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        sarki_txt = new javax.swing.JTextField();
        tarih_txt = new javax.swing.JTextField();
        sanatci_txt = new javax.swing.JTextField();
        album_txt = new javax.swing.JTextField();
        tur_txt = new javax.swing.JTextField();
        sure_txt = new javax.swing.JTextField();
        dsayi_txt = new javax.swing.JTextField();
        ekle = new javax.swing.JButton();
        güncelle = new javax.swing.JButton();
        sil = new javax.swing.JButton();
        albumislemleri = new javax.swing.JButton();
        sanatciislemleri = new javax.swing.JButton();
        temizle = new javax.swing.JButton();
        dönme = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jTable1.setBackground(new java.awt.Color(0, 153, 153));
        jTable1.setForeground(new java.awt.Color(255, 255, 255));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTable1MousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(56, 431, 1001, 254);

        jLabel1.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 14)); // NOI18N
        jLabel1.setText("Şarkı :");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(81, 31, 109, 25);

        jLabel8.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 14)); // NOI18N
        jLabel8.setText("Sanatçı:");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(81, 117, 109, 25);

        jLabel9.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 14)); // NOI18N
        jLabel9.setText("Tarih:");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(81, 74, 109, 25);

        jLabel10.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 14)); // NOI18N
        jLabel10.setText("Tür:");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(81, 203, 109, 25);

        jLabel11.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 14)); // NOI18N
        jLabel11.setText("Albüm:");
        getContentPane().add(jLabel11);
        jLabel11.setBounds(81, 160, 109, 25);

        jLabel12.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 14)); // NOI18N
        jLabel12.setText("Süre:");
        getContentPane().add(jLabel12);
        jLabel12.setBounds(81, 246, 109, 25);

        jLabel13.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 14)); // NOI18N
        jLabel13.setText("Dinlenme Sayısı:");
        getContentPane().add(jLabel13);
        jLabel13.setBounds(81, 289, 109, 25);

        sarki_txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sarki_txtActionPerformed(evt);
            }
        });
        getContentPane().add(sarki_txt);
        sarki_txt.setBounds(232, 32, 550, 22);
        getContentPane().add(tarih_txt);
        tarih_txt.setBounds(232, 75, 550, 22);
        getContentPane().add(sanatci_txt);
        sanatci_txt.setBounds(232, 117, 550, 22);
        getContentPane().add(album_txt);
        album_txt.setBounds(232, 161, 550, 22);
        getContentPane().add(tur_txt);
        tur_txt.setBounds(232, 204, 550, 22);
        getContentPane().add(sure_txt);
        sure_txt.setBounds(232, 247, 550, 22);
        getContentPane().add(dsayi_txt);
        dsayi_txt.setBounds(232, 290, 550, 22);

        ekle.setBackground(new java.awt.Color(255, 204, 0));
        ekle.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 18)); // NOI18N
        ekle.setText("ŞARKI EKLE");
        ekle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ekleActionPerformed(evt);
            }
        });
        getContentPane().add(ekle);
        ekle.setBounds(56, 377, 120, 30);

        güncelle.setBackground(new java.awt.Color(255, 204, 0));
        güncelle.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 18)); // NOI18N
        güncelle.setText("ŞARKI GÜNCELLE");
        güncelle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                güncelleActionPerformed(evt);
            }
        });
        getContentPane().add(güncelle);
        güncelle.setBounds(209, 378, 160, 29);

        sil.setBackground(new java.awt.Color(255, 204, 0));
        sil.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 18)); // NOI18N
        sil.setText("ŞARKI SIL");
        sil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                silActionPerformed(evt);
            }
        });
        getContentPane().add(sil);
        sil.setBounds(410, 378, 110, 29);

        albumislemleri.setBackground(new java.awt.Color(204, 204, 255));
        albumislemleri.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 18)); // NOI18N
        albumislemleri.setText("ALBÜM ISLEMLERI");
        albumislemleri.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                albumislemleriActionPerformed(evt);
            }
        });
        getContentPane().add(albumislemleri);
        albumislemleri.setBounds(860, 18, 260, 53);

        sanatciislemleri.setBackground(new java.awt.Color(204, 204, 255));
        sanatciislemleri.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 18)); // NOI18N
        sanatciislemleri.setText("SANATCI ISLEMLERI");
        sanatciislemleri.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sanatciislemleriActionPerformed(evt);
            }
        });
        getContentPane().add(sanatciislemleri);
        sanatciislemleri.setBounds(860, 160, 260, 53);

        temizle.setBackground(new java.awt.Color(255, 102, 102));
        temizle.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 18)); // NOI18N
        temizle.setText("TEMIZLE");
        temizle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                temizleActionPerformed(evt);
            }
        });
        getContentPane().add(temizle);
        temizle.setBounds(860, 312, 260, 52);

        dönme.setBackground(new java.awt.Color(153, 255, 255));
        dönme.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 18)); // NOI18N
        dönme.setText("ÖNCEKI EKRANA DÖN");
        dönme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dönmeActionPerformed(evt);
            }
        });
        getContentPane().add(dönme);
        dönme.setBounds(599, 371, 200, 42);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/arkaplanı.png"))); // NOI18N
        getContentPane().add(jLabel2);
        jLabel2.setBounds(0, 0, 1170, 790);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1170, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 790, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 1170, 790);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void sarki_txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sarki_txtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sarki_txtActionPerformed

    private void jTable1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MousePressed
        sarki_txt.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 1).toString());
        tarih_txt.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 2).toString());
        sanatci_txt.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 3).toString());
        album_txt.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 4).toString());
        tur_txt.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 5).toString());
        sure_txt.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 6).toString());
        dsayi_txt.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 7).toString());
    }//GEN-LAST:event_jTable1MousePressed

    private void ekleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ekleActionPerformed
        try {
            MusicInsert();
            AlbumInsert();
            SanatciInsert();
            TurInsert();
            TabloDoldur();
        } catch (SQLException ex) {
            Logger.getLogger(admin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_ekleActionPerformed

    private void güncelleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_güncelleActionPerformed
        
       
            int id= (int)jTable1.getValueAt(jTable1.getSelectedRow(), 0);
            String ad=sarki_txt.getText();
            String tarih=tarih_txt.getText();
            String sanatci=sanatci_txt.getText();
            String album=album_txt.getText();
            String tur=tur_txt.getText();
            String sure=sure_txt.getText();
            String dsayi=dsayi_txt.getText();
            
        try {
            AlbumUpdate(id, album, ad, sanatci, tarih, tur);
            MusicUpdate(id,ad, tarih, sanatci, album, tur, sure, dsayi);
            SanatciUpdate(id,sanatci);
            TurUpdate(id,tur,ad);
        } catch (SQLException ex) {
            Logger.getLogger(admin.class.getName()).log(Level.SEVERE, null, ex);
        }
            TabloDoldur();
       
        
    }//GEN-LAST:event_güncelleActionPerformed

    private void silActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_silActionPerformed
        int id= (int)jTable1.getValueAt(jTable1.getSelectedRow(), 0);
        String sarkiadi=jTable1.getValueAt(jTable1.getSelectedRow(), 1).toString();
        try {
            MusicDelete(id);
            AlbumDelete(id);
            SanatciDelete(id);
            TurDelete(id);
        } catch (SQLException ex) {
            Logger.getLogger(admin.class.getName()).log(Level.SEVERE, null, ex);
        }
        TabloDoldur();
    }//GEN-LAST:event_silActionPerformed

    private void albumislemleriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_albumislemleriActionPerformed
        album menu4 = new album();
        menu4.setSize(1172, 787);
        menu4.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_albumislemleriActionPerformed

    private void sanatciislemleriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sanatciislemleriActionPerformed
        sanatci menu4 = new sanatci();
        menu4.setSize(1172, 787);
        menu4.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_sanatciislemleriActionPerformed

    private void temizleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_temizleActionPerformed
        sarki_txt.setText(null);
        tarih_txt.setText(null);
        sanatci_txt.setText(null);
        album_txt.setText(null);
        tur_txt.setText(null);
        sure_txt.setText(null);
        dsayi_txt.setText(null);
    }//GEN-LAST:event_temizleActionPerformed

    private void dönmeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dönmeActionPerformed
        Giris menu5 = new Giris();
        menu5.setSize(570, 540);
        menu5.setVisible(true);
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
            java.util.logging.Logger.getLogger(admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new admin().setVisible(true);
               
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField album_txt;
    private javax.swing.JButton albumislemleri;
    private javax.swing.JTextField dsayi_txt;
    private javax.swing.JButton dönme;
    private javax.swing.JButton ekle;
    private javax.swing.JButton güncelle;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField sanatci_txt;
    private javax.swing.JButton sanatciislemleri;
    private javax.swing.JTextField sarki_txt;
    private javax.swing.JButton sil;
    private javax.swing.JTextField sure_txt;
    private javax.swing.JTextField tarih_txt;
    private javax.swing.JButton temizle;
    private javax.swing.JTextField tur_txt;
    // End of variables declaration//GEN-END:variables
}
