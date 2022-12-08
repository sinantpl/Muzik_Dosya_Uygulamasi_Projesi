
import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sİnan
 */
public class album extends javax.swing.JFrame {

    /**
     * Creates new form album
     */
    public album() {
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
            String sql="select * from musicapp.albumtablo";
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
         statement.setString(2, sarkiadi_txt.getText());
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
        
        
        public void  MusicInsert () throws SQLException{
         Connection connect=null;
         DB db=new DB();
         PreparedStatement statement =null;
         
         try{
         connect = db.getConnection();
         String sql="insert into musicapp.sarki (sarkiadi,sarkitarih,sanatci,album,muziktur,muziksure,dinlenmesayi)"
                 +"values(?,?,?,?,?,?,?)";
         statement=connect.prepareStatement(sql);
         statement.setString(1, sarkiadi_txt.getText());
         statement.setString(2, tarih_txt.getText());
         statement.setString(3, sanatci_txt.getText());
         statement.setString(4, album_txt.getText());
         statement.setString(5, tur_txt.getText());
         statement.setString(6, "-");
         statement.setString(7, "0");
         statement.executeUpdate();

         }catch(SQLException exception){
             db.ShowError(exception);
             JOptionPane.showMessageDialog(null,"Şarkı Eklenemedi");
         }finally{
             statement.close();
             connect.close();
         }
         
             
    }
       
     public void  MusicUpdate (int id,String ad,String tarih,String sanatci,String album,String tur,String sure,int dsayi) throws SQLException{
         Connection connect=null;
         DB db=new DB();
         PreparedStatement statement =null;
         
         try{
         connect = db.getConnection();
         String sql="Update sarki set sarkiadi='"+ad+"',"+"sarkitarih='"+tarih+"',"+"sanatci='"+sanatci+"',"+"album='"+album+"',"+"muziktur='"+
                 tur+"',"+"muziksure='"+sure+"',"+"dinlenmesayi='"+dsayi+"' where idsarki="+id;
         
                 
         statement=connect.prepareStatement(sql);
         
         statement.executeUpdate();

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
         

         }catch(SQLException exception){
             db.ShowError(exception);
             JOptionPane.showMessageDialog(null,"Şarkı Silinemedi");
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
         String sql="insert into musicapp.sanatcitablo (sanatciadi)"
                 +"values(?)";
         statement=connect.prepareStatement(sql);
         statement.setString(1, sanatci_txt.getText());
         statement.executeUpdate();

         }catch(SQLException exception){
             db.ShowError(exception);
             JOptionPane.showMessageDialog(null,"Sanatçı Eklenemedi");
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
         statement.setString(2, sarkiadi_txt.getText());
         statement.setString(3, sanatci_txt.getText());
         statement.setString(4, tarih_txt.getText());
         statement.setString(5, tur_txt.getText());
         
         statement.executeUpdate();
         JOptionPane.showMessageDialog(null,"Albüm Başarıyla Eklendi");
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
         JOptionPane.showMessageDialog(null,"Albüm Başarıyla Güncellendi");
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
         
         JOptionPane.showMessageDialog(null,"Album Silindi");
         }catch(SQLException exception){
             db.ShowError(exception);
             JOptionPane.showMessageDialog(null,"Album Silinemedi");
         }finally{
             statement.close();
             connect.close();
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        album_txt = new javax.swing.JTextField();
        sarkiadi_txt = new javax.swing.JTextField();
        sanatci_txt = new javax.swing.JTextField();
        tarih_txt = new javax.swing.JTextField();
        tur_txt = new javax.swing.JTextField();
        ekle = new javax.swing.JButton();
        sil = new javax.swing.JButton();
        güncelle = new javax.swing.JButton();
        dönme = new javax.swing.JButton();
        temizle = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
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
        jScrollPane1.setBounds(52, 383, 1056, 279);

        jLabel1.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 14)); // NOI18N
        jLabel1.setText("Albüm Adı:");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(52, 57, 109, 25);

        jLabel2.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 14)); // NOI18N
        jLabel2.setText("Şarkı Adı:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(52, 107, 109, 25);

        jLabel3.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 14)); // NOI18N
        jLabel3.setText("Sanatçı:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(52, 150, 109, 25);

        jLabel4.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 14)); // NOI18N
        jLabel4.setText("Tarih:");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(52, 203, 109, 25);

        jLabel5.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 14)); // NOI18N
        jLabel5.setText("Tür:");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(52, 253, 109, 25);

        album_txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                album_txtActionPerformed(evt);
            }
        });
        getContentPane().add(album_txt);
        album_txt.setBounds(166, 58, 550, 22);

        sarkiadi_txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sarkiadi_txtActionPerformed(evt);
            }
        });
        getContentPane().add(sarkiadi_txt);
        sarkiadi_txt.setBounds(166, 108, 550, 22);

        sanatci_txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sanatci_txtActionPerformed(evt);
            }
        });
        getContentPane().add(sanatci_txt);
        sanatci_txt.setBounds(166, 150, 550, 22);

        tarih_txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tarih_txtActionPerformed(evt);
            }
        });
        getContentPane().add(tarih_txt);
        tarih_txt.setBounds(166, 204, 550, 22);

        tur_txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tur_txtActionPerformed(evt);
            }
        });
        getContentPane().add(tur_txt);
        tur_txt.setBounds(166, 254, 550, 22);

        ekle.setBackground(new java.awt.Color(255, 204, 0));
        ekle.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 18)); // NOI18N
        ekle.setText("ALBÜM EKLE");
        ekle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ekleActionPerformed(evt);
            }
        });
        getContentPane().add(ekle);
        ekle.setBounds(52, 341, 140, 29);

        sil.setBackground(new java.awt.Color(255, 204, 0));
        sil.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 18)); // NOI18N
        sil.setText("ALBÜM SIL");
        sil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                silActionPerformed(evt);
            }
        });
        getContentPane().add(sil);
        sil.setBounds(266, 341, 140, 29);

        güncelle.setBackground(new java.awt.Color(255, 204, 0));
        güncelle.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 18)); // NOI18N
        güncelle.setText("ALBÜM GÜNCELLE");
        güncelle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                güncelleActionPerformed(evt);
            }
        });
        getContentPane().add(güncelle);
        güncelle.setBounds(471, 341, 180, 29);

        dönme.setBackground(new java.awt.Color(153, 255, 255));
        dönme.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 18)); // NOI18N
        dönme.setText("ÖNCEKI EKRANA DÖN");
        dönme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dönmeActionPerformed(evt);
            }
        });
        getContentPane().add(dönme);
        dönme.setBounds(829, 47, 227, 42);

        temizle.setBackground(new java.awt.Color(255, 102, 102));
        temizle.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 18)); // NOI18N
        temizle.setText("TEMIZLE");
        temizle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                temizleActionPerformed(evt);
            }
        });
        getContentPane().add(temizle);
        temizle.setBounds(829, 193, 227, 42);

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/arkaplanı.png"))); // NOI18N
        getContentPane().add(jLabel6);
        jLabel6.setBounds(0, 0, 1170, 850);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1170, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 850, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 1170, 850);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void album_txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_album_txtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_album_txtActionPerformed

    private void sarkiadi_txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sarkiadi_txtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sarkiadi_txtActionPerformed

    private void sanatci_txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sanatci_txtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sanatci_txtActionPerformed

    private void tarih_txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tarih_txtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tarih_txtActionPerformed

    private void tur_txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tur_txtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tur_txtActionPerformed

    private void ekleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ekleActionPerformed
        
        try {
            AlbumInsert();
            MusicInsert();
            SanatciInsert();
            TurInsert();
            TabloDoldur();
        } catch (SQLException ex) {
            Logger.getLogger(admin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_ekleActionPerformed

    private void silActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_silActionPerformed
        
        int id= (int)jTable1.getValueAt(jTable1.getSelectedRow(), 0);
        String sarkiadi=jTable1.getValueAt(jTable1.getSelectedRow(), 2).toString();
        try {
            AlbumDelete(id);
            MusicDelete(id);
             TurDelete(id);
        } catch (SQLException ex) {
            Logger.getLogger(admin.class.getName()).log(Level.SEVERE, null, ex);
        }
        TabloDoldur();
                     
    }//GEN-LAST:event_silActionPerformed

    private void güncelleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_güncelleActionPerformed
        
        int id= (int)jTable1.getValueAt(jTable1.getSelectedRow(), 0);
            String album=album_txt.getText();
            String sarkiadi=sarkiadi_txt.getText();
            String sanatci=sanatci_txt.getText();
            String tarih=tarih_txt.getText();
            String tur=tur_txt.getText();
            
            
        try {
            AlbumUpdate(id,album, sarkiadi, sanatci, tarih, tur);
            MusicUpdate(id,sarkiadi, tarih, sanatci, album, tur, null,0);
            TurUpdate(id,tur,sarkiadi);
        } catch (SQLException ex) {
            Logger.getLogger(admin.class.getName()).log(Level.SEVERE, null, ex);
        }
            TabloDoldur();
       
    }//GEN-LAST:event_güncelleActionPerformed

    private void dönmeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dönmeActionPerformed
         admin menu4 = new admin();
        menu4.setSize(1172, 787);
        menu4.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_dönmeActionPerformed

    private void jTable1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MousePressed
        album_txt.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 1).toString());
        sarkiadi_txt.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 2).toString());
        sanatci_txt.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 3).toString());
        tarih_txt.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 4).toString());
        tur_txt.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 5).toString());
    }//GEN-LAST:event_jTable1MousePressed

    private void temizleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_temizleActionPerformed
        album_txt.setText(null);
        sarkiadi_txt.setText(null);
        sanatci_txt.setText(null);
        tarih_txt.setText(null);
        tur_txt.setText(null);
        
    }//GEN-LAST:event_temizleActionPerformed

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
            java.util.logging.Logger.getLogger(album.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(album.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(album.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(album.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new album().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField album_txt;
    private javax.swing.JButton dönme;
    private javax.swing.JButton ekle;
    private javax.swing.JButton güncelle;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField sanatci_txt;
    private javax.swing.JTextField sarkiadi_txt;
    private javax.swing.JButton sil;
    private javax.swing.JTextField tarih_txt;
    private javax.swing.JButton temizle;
    private javax.swing.JTextField tur_txt;
    // End of variables declaration//GEN-END:variables
}
