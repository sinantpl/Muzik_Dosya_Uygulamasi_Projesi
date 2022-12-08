
import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;
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
public class Kullanici3 extends javax.swing.JFrame {

    /**
     * Creates new form Kullanici3
     */
    
    static String muziktur;
    static String sarkiadi;
    static String sanatci;
    
    static String takipad;
    
    static int idkullanici;
    static String kullaniciadi;
    static String kullaniciemail;
    static String kullanicitur;
    static String kullaniciulke;
    static String secilensarki;
    
    public Kullanici3() {
        initComponents();
        TabloDoldurSarkilar();
        TabloDoldurTopPop();
        TabloDoldurTopRock();
        TabloDoldurTopRap();
        TabloDoldurTopHepsi();
        TabloDoldurPrKullanicilar();
        HesapTuru();
        hesapadi_txt.setText(Kullanici2.ad);
        hesaptur_txt.setText(Kullanici2.tur);
        PopEkle(hesapadi_txt.getText());
        RockEkle(hesapadi_txt.getText());
        RapEkle(hesapadi_txt.getText());
        TakipTablo(hesapadi_txt.getText());
        Odeme();
    }
   public void Odeme(){
       if(hesaptur_txt.getText()=="Premium"){
       Random r=new Random(); //random sınıfı
        int a=r.nextInt(2);
        
        System.out.println("Random Sayı: "+a);
        if(a==0){
           JOptionPane.showMessageDialog(null,"Lütfen Üyelik Ücretini Ödeyiniz !!!"); 
           odeme_txt.setText("Ödenmemiş");
        }else{
            odeme_txt.setText("Ödenmiş");
        }
       }else{
           odemelabel.setVisible(false);
           odeme_txt.setEnabled(false);
       }
   }
    public void TakipPop(String ad){
         Connection connect=null;
         DB db=new DB();
         PreparedStatement statement =null;
         ResultSet rs = null;
        try {
            connect = db.getConnection();
            String sql="select distinct "+ad+".muziktur, "+ad+".sarkiadi, "+ad+".sanatci from "+ad+" where muziktur='Pop'";
            statement=connect.prepareStatement(sql);
             rs = statement.executeQuery();
             uyepop.setModel(DbUtils.resultSetToTableModel (rs));
             connect.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(Kullanici3.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void TakipRock(String ad){
         Connection connect=null;
         DB db=new DB();
         PreparedStatement statement =null;
         ResultSet rs = null;
        try {
            connect = db.getConnection();
            String sql="select distinct "+ad+".muziktur, "+ad+".sarkiadi, "+ad+".sanatci from "+ad+" where muziktur='Rock'";
            statement=connect.prepareStatement(sql);
             rs = statement.executeQuery();
             uyerock.setModel(DbUtils.resultSetToTableModel (rs));
             connect.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(Kullanici3.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void TakipRap(String ad){
         Connection connect=null;
         DB db=new DB();
         PreparedStatement statement =null;
         ResultSet rs = null;
        try {
            connect = db.getConnection();
            String sql="select distinct "+ad+".muziktur, "+ad+".sarkiadi, "+ad+".sanatci from "+ad+" where muziktur='Rap'";
            statement=connect.prepareStatement(sql);
             rs = statement.executeQuery();
             uyerap.setModel(DbUtils.resultSetToTableModel (rs));
             connect.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(Kullanici3.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void PopEkle(String ad){
         Connection connect=null;
         DB db=new DB();
         PreparedStatement statement =null;
         ResultSet rs = null;
        try {
            connect = db.getConnection();
            String sql="select distinct "+ad+".muziktur, "+ad+".sarkiadi, "+ad+".sanatci from "+ad+" where muziktur='Pop'";
            statement=connect.prepareStatement(sql);
             rs = statement.executeQuery();
             poptable.setModel(DbUtils.resultSetToTableModel (rs));
             connect.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(Kullanici3.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     public void RockEkle(String ad){
         Connection connect=null;
         DB db=new DB();
         PreparedStatement statement =null;
         ResultSet rs = null;
        try {
            connect = db.getConnection();
            String sql="select distinct "+ad+".muziktur, "+ad+".sarkiadi, "+ad+".sanatci from "+ad+" where muziktur='Rock'";
            statement=connect.prepareStatement(sql);
             rs = statement.executeQuery();
             rocktable.setModel(DbUtils.resultSetToTableModel (rs));
             connect.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(Kullanici3.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
      public void RapEkle(String ad){
         Connection connect=null;
         DB db=new DB();
         PreparedStatement statement =null;
         ResultSet rs = null;
        try {
            connect = db.getConnection();
            String sql="select distinct "+ad+".muziktur, "+ad+".sarkiadi, "+ad+".sanatci from "+ad+" where muziktur='Rap'";
            statement=connect.prepareStatement(sql);
             rs = statement.executeQuery();
             raptable.setModel(DbUtils.resultSetToTableModel (rs));
             connect.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(Kullanici3.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void SarkiEkle(String ad){
        
        Connection connect=null;
         DB db=new DB();
         PreparedStatement statement =null;
         
        try {
            connect = db.getConnection();
            String sql="insert into musicapp."+ad+" (muziktur,sarkiadi,sanatci)"
                 +"values(?,?,?)";
            statement=connect.prepareStatement(sql);
            statement.setString(1, muziktur);
            statement.setString(2, sarkiadi);
            statement.setString(3, sanatci);
            statement.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(Kullanici3.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,"Şarkı Listenize Eklenemedi!!!");
        }
         
    }
    public void RapTumEkle(String ad,String tablo){
    
         Connection connect=null;
         DB db=new DB();
         PreparedStatement statement =null;
        try {
            connect = db.getConnection();
            String sql="INSERT INTO "+ad+" (muziktur, sarkiadi, sanatci)\n" +
            "SELECT muziktur, sarkiadi, sanatci\n" +
            "FROM "+tablo+" \n" +
            "WHERE "+tablo+".muziktur='Rap'";
            statement=connect.prepareStatement(sql);
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Kullanici3.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }
    public void PopTumEkle(String ad,String tablo){
    
         Connection connect=null;
         DB db=new DB();
         PreparedStatement statement =null;
        try {
            connect = db.getConnection();
            String sql="INSERT INTO "+ad+" (muziktur, sarkiadi, sanatci)\n" +
            "SELECT muziktur, sarkiadi, sanatci\n" +
            "FROM "+tablo+" \n" +
            "WHERE "+tablo+".muziktur='Pop'";
            statement=connect.prepareStatement(sql);
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Kullanici3.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }
    public void RockTumEkle(String ad,String tablo){
    
         Connection connect=null;
         DB db=new DB();
         PreparedStatement statement =null;
        try {
            connect = db.getConnection();
            String sql="INSERT INTO "+ad+" (muziktur, sarkiadi, sanatci)\n" +
            "SELECT muziktur, sarkiadi, sanatci\n" +
            "FROM "+tablo+" \n" +
            "WHERE "+tablo+".muziktur='Rock'";
            statement=connect.prepareStatement(sql);
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Kullanici3.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }
    
    public void TakipEt(String ad){
        Connection connect=null;
        DB db=new DB();
        PreparedStatement statement =null;
        
        try {
            connect = db.getConnection();
            String sql="insert into musicapp."+ad+"takip (kullaniciadi,kullaniciemail,kullanicitur,kullaniciulke)"
                 +"values(?,?,?,?)";
            statement=connect.prepareStatement(sql);
            statement.setString(1, kullaniciadi);
            statement.setString(2, kullaniciemail);
            statement.setString(3, kullanicitur);
            statement.setString(4, kullaniciulke);
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Kullanici3.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void TakipTablo(String ad){
         Connection connect=null;
         DB db=new DB();
         PreparedStatement statement =null;
         ResultSet rs = null;
        try {
            connect = db.getConnection();
            String sql="select distinct "+ad+"takip.idkullanici, "+ad+"takip.kullaniciadi, "+ad+"takip.kullaniciemail, "+ad+"takip.kullanicitur, "+ad+"takip.kullaniciulke from "+ad+"takip ";
            statement=connect.prepareStatement(sql);
             rs = statement.executeQuery();
             takipkullanicilar.setModel(DbUtils.resultSetToTableModel (rs));
             connect.close();
        } catch (SQLException ex) {
            Logger.getLogger(Kullanici3.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     public void HesapTuru(){
            
            String sql_sorgu="select count(idkullanici) as giris2 from musicapp.kullanici where kullaniciadi='"+Kullanici2.ad+"'and kullanicitur='Premium'";
            ResultSet rs=DB.basla();
            rs=DB.sorgulama(sql_sorgu);
        try {
            while (rs.next()) {
            if (rs.getInt("giris2")==1) {
                Kullanici2.tur="Premium";
            }else
                Kullanici2.tur="Normal";
            }
        } catch (SQLException ex) {
            Logger.getLogger(Kullanici2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void TabloDoldurSarkilar(){
        Connection connect=null;
         DB db=new DB();
         PreparedStatement statement =null;
          ResultSet rs = null;
        try {
            connect = db.getConnection();
            String sql="select * from musicapp.sarki ";
            statement=connect.prepareStatement(sql);
             rs = statement.executeQuery();
             sarkilartable.setModel(DbUtils.resultSetToTableModel (rs));
             connect.close();
        } catch (SQLException ex) {
            Logger.getLogger(admin.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public void TabloDoldurTopPop(){
        Connection connect=null;
         DB db=new DB();
         PreparedStatement statement =null;
          ResultSet rs = null;
        try {
            connect = db.getConnection();
            String sql="SELECT sarkiadi,sanatci,dinlenmesayi FROM musicapp.sarki where muziktur='Pop' order by dinlenmesayi desc LIMIT 10 ";
            statement=connect.prepareStatement(sql);
             rs = statement.executeQuery();
             toppop.setModel(DbUtils.resultSetToTableModel (rs));
             connect.close();
        } catch (SQLException ex) {
            Logger.getLogger(admin.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public void TabloDoldurTopRock(){
        Connection connect=null;
         DB db=new DB();
         PreparedStatement statement =null;
          ResultSet rs = null;
        try {
            connect = db.getConnection();
            String sql="SELECT sarkiadi,sanatci,dinlenmesayi FROM musicapp.sarki where muziktur='Rock' order by dinlenmesayi desc LIMIT 10 ";
            statement=connect.prepareStatement(sql);
             rs = statement.executeQuery();
             toprock.setModel(DbUtils.resultSetToTableModel (rs));
             connect.close();
        } catch (SQLException ex) {
            Logger.getLogger(admin.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public void TabloDoldurTopRap(){
        Connection connect=null;
         DB db=new DB();
         PreparedStatement statement =null;
          ResultSet rs = null;
        try {
            connect = db.getConnection();
            String sql="SELECT sarkiadi,sanatci,dinlenmesayi FROM musicapp.sarki where muziktur='Rap' order by dinlenmesayi desc LIMIT 10 ";
            statement=connect.prepareStatement(sql);
             rs = statement.executeQuery();
             toprap.setModel(DbUtils.resultSetToTableModel (rs));
             connect.close();
        } catch (SQLException ex) {
            Logger.getLogger(admin.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void TabloDoldurTopHepsi(){
        Connection connect=null;
         DB db=new DB();
         PreparedStatement statement =null;
          ResultSet rs = null;
        try {
            connect = db.getConnection();
            String sql="SELECT sarkiadi,sanatci,dinlenmesayi FROM musicapp.sarki order by dinlenmesayi desc LIMIT 10  ";
            statement=connect.prepareStatement(sql);
             rs = statement.executeQuery();
             
               tophepsi.setModel(DbUtils.resultSetToTableModel (rs));
               connect.close();  
             
             
        } catch (SQLException ex) {
            Logger.getLogger(admin.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void TabloDoldurPrKullanicilar(){
        Connection connect=null;
         DB db=new DB();
         PreparedStatement statement =null;
          ResultSet rs = null;
        try {
            connect = db.getConnection();
            String sql="SELECT idkullanici,kullaniciadi,kullaniciemail,kullanicitur,kullaniciulke FROM musicapp.kullanici where kullanicitur='Premium' ";
            statement=connect.prepareStatement(sql);
             rs = statement.executeQuery();
             prkullanicilar.setModel(DbUtils.resultSetToTableModel (rs));
             connect.close();
        } catch (SQLException ex) {
            Logger.getLogger(admin.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public void DinlenmeArttir(String ad){
        Connection connect=null;
         DB db=new DB();
         PreparedStatement statement =null;
          ResultSet rs = null;
        try {
            connect = db.getConnection();
            String sql="Update sarki Set dinlenmesayi=dinlenmesayi+1 where sarkiadi='"+ad+"'";
            statement=connect.prepareStatement(sql);
             statement.executeUpdate();
             connect.close();
        } catch (SQLException ex) {
            Logger.getLogger(admin.class.getName()).log(Level.SEVERE, null, ex);
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

        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        poptable = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        rocktable = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        raptable = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        odemelabel = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        toppop = new javax.swing.JTable();
        jScrollPane6 = new javax.swing.JScrollPane();
        toprock = new javax.swing.JTable();
        jScrollPane7 = new javax.swing.JScrollPane();
        toprap = new javax.swing.JTable();
        jScrollPane8 = new javax.swing.JScrollPane();
        sarkilartable = new javax.swing.JTable();
        jScrollPane9 = new javax.swing.JScrollPane();
        prkullanicilar = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        rapeklebuton = new javax.swing.JButton();
        popeklebuton = new javax.swing.JButton();
        rockeklebuton = new javax.swing.JButton();
        listeneeklebuton = new javax.swing.JButton();
        sarkical = new javax.swing.JButton();
        sarkieklebuton = new javax.swing.JButton();
        hesapadi_txt = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane11 = new javax.swing.JScrollPane();
        uyerap = new javax.swing.JTable();
        jScrollPane13 = new javax.swing.JScrollPane();
        uyerock = new javax.swing.JTable();
        jScrollPane12 = new javax.swing.JScrollPane();
        uyepop = new javax.swing.JTable();
        jScrollPane10 = new javax.swing.JScrollPane();
        tophepsi = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        odeme_txt = new javax.swing.JLabel();
        hesaptur_txt = new javax.swing.JLabel();
        takipgoster = new javax.swing.JButton();
        takipetbuton = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jScrollPane14 = new javax.swing.JScrollPane();
        takipkullanicilar = new javax.swing.JTable();
        jLabel19 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 204, 204));
        jLabel1.setText("Hesaba Ait Çalma Listeleri");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(10, 160, 320, 50);

        jLabel7.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 0, 0));
        jLabel7.setText("Kullanıcı Adı:");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(30, 50, 130, 31);

        poptable.setBackground(new java.awt.Color(0, 153, 153));
        poptable.setForeground(new java.awt.Color(255, 255, 255));
        poptable.setModel(new javax.swing.table.DefaultTableModel(
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
        poptable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                poptableMousePressed(evt);
            }
        });
        jScrollPane2.setViewportView(poptable);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(10, 240, 300, 130);

        rocktable.setBackground(new java.awt.Color(0, 153, 153));
        rocktable.setForeground(new java.awt.Color(255, 255, 255));
        rocktable.setModel(new javax.swing.table.DefaultTableModel(
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
        rocktable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                rocktableMousePressed(evt);
            }
        });
        jScrollPane3.setViewportView(rocktable);

        getContentPane().add(jScrollPane3);
        jScrollPane3.setBounds(10, 410, 300, 130);

        raptable.setBackground(new java.awt.Color(0, 153, 153));
        raptable.setForeground(new java.awt.Color(255, 255, 255));
        raptable.setModel(new javax.swing.table.DefaultTableModel(
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
        raptable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                raptableMousePressed(evt);
            }
        });
        jScrollPane4.setViewportView(raptable);

        getContentPane().add(jScrollPane4);
        jScrollPane4.setBounds(10, 590, 300, 130);

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 30)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(52, 255, 255));
        jLabel2.setText("RAP");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(130, 540, 66, 50);

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 30)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 255, 255));
        jLabel3.setText("POP");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(130, 200, 60, 50);

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 30)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 255, 255));
        jLabel4.setText("ROCK");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(120, 370, 72, 50);

        odemelabel.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 24)); // NOI18N
        odemelabel.setForeground(new java.awt.Color(255, 0, 0));
        odemelabel.setText("Ödeme Bilgisi:");
        getContentPane().add(odemelabel);
        odemelabel.setBounds(30, 130, 140, 31);

        jLabel14.setBackground(new java.awt.Color(255, 255, 255));
        jLabel14.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 30)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 204, 204));
        jLabel14.setText("Hesap Bilgileri");
        getContentPane().add(jLabel14);
        jLabel14.setBounds(50, 0, 190, 50);

        jLabel15.setBackground(new java.awt.Color(255, 255, 255));
        jLabel15.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 30)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 204, 0));
        jLabel15.setText("RAP");
        getContentPane().add(jLabel15);
        jLabel15.setBounds(1000, 490, 80, 50);

        toppop.setBackground(new java.awt.Color(0, 153, 153));
        toppop.setForeground(new java.awt.Color(255, 255, 255));
        toppop.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane5.setViewportView(toppop);

        getContentPane().add(jScrollPane5);
        jScrollPane5.setBounds(1210, 190, 320, 100);

        toprock.setBackground(new java.awt.Color(0, 153, 153));
        toprock.setForeground(new java.awt.Color(255, 255, 255));
        toprock.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane6.setViewportView(toprock);

        getContentPane().add(jScrollPane6);
        jScrollPane6.setBounds(1210, 330, 320, 100);

        toprap.setBackground(new java.awt.Color(0, 153, 153));
        toprap.setForeground(new java.awt.Color(255, 255, 255));
        toprap.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane7.setViewportView(toprap);

        getContentPane().add(jScrollPane7);
        jScrollPane7.setBounds(1210, 480, 320, 100);

        sarkilartable.setBackground(new java.awt.Color(0, 153, 153));
        sarkilartable.setForeground(new java.awt.Color(255, 255, 255));
        sarkilartable.setModel(new javax.swing.table.DefaultTableModel(
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
        sarkilartable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                sarkilartableMousePressed(evt);
            }
        });
        jScrollPane8.setViewportView(sarkilartable);

        getContentPane().add(jScrollPane8);
        jScrollPane8.setBounds(464, 60, 680, 220);

        prkullanicilar.setBackground(new java.awt.Color(0, 153, 153));
        prkullanicilar.setForeground(new java.awt.Color(255, 255, 255));
        prkullanicilar.setModel(new javax.swing.table.DefaultTableModel(
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
        prkullanicilar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                prkullanicilarMousePressed(evt);
            }
        });
        jScrollPane9.setViewportView(prkullanicilar);

        getContentPane().add(jScrollPane9);
        jScrollPane9.setBounds(320, 340, 430, 100);

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 30)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(204, 204, 0));
        jLabel5.setText("Şarkı Listesi");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(740, 10, 230, 44);

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 30)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(204, 0, 204));
        jLabel8.setText("TOP 10/ROCK");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(1286, 290, 190, 40);

        rapeklebuton.setBackground(new java.awt.Color(255, 102, 102));
        rapeklebuton.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 18)); // NOI18N
        rapeklebuton.setText("Rap Listesini Ekle");
        rapeklebuton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rapeklebutonActionPerformed(evt);
            }
        });
        getContentPane().add(rapeklebuton);
        rapeklebuton.setBounds(890, 640, 270, 30);

        popeklebuton.setBackground(new java.awt.Color(255, 102, 102));
        popeklebuton.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 18)); // NOI18N
        popeklebuton.setText("Pop Listesini Ekle");
        popeklebuton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                popeklebutonActionPerformed(evt);
            }
        });
        getContentPane().add(popeklebuton);
        popeklebuton.setBounds(360, 640, 190, 29);

        rockeklebuton.setBackground(new java.awt.Color(255, 102, 102));
        rockeklebuton.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 18)); // NOI18N
        rockeklebuton.setText("Rock Listesini Ekle");
        rockeklebuton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rockeklebutonActionPerformed(evt);
            }
        });
        getContentPane().add(rockeklebuton);
        rockeklebuton.setBounds(620, 640, 230, 29);

        listeneeklebuton.setBackground(new java.awt.Color(255, 102, 102));
        listeneeklebuton.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 18)); // NOI18N
        listeneeklebuton.setText("Şarkıyı Listene Ekle");
        listeneeklebuton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listeneeklebutonActionPerformed(evt);
            }
        });
        getContentPane().add(listeneeklebuton);
        listeneeklebuton.setBounds(620, 680, 230, 30);

        sarkical.setBackground(new java.awt.Color(255, 102, 102));
        sarkical.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 18)); // NOI18N
        sarkical.setText("Şarkıyı Çal");
        sarkical.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sarkicalActionPerformed(evt);
            }
        });
        getContentPane().add(sarkical);
        sarkical.setBounds(320, 270, 130, 30);

        sarkieklebuton.setBackground(new java.awt.Color(255, 102, 102));
        sarkieklebuton.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 18)); // NOI18N
        sarkieklebuton.setText("Şarkı Ekle");
        sarkieklebuton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sarkieklebutonActionPerformed(evt);
            }
        });
        getContentPane().add(sarkieklebuton);
        sarkieklebuton.setBounds(320, 230, 130, 30);

        hesapadi_txt.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 24)); // NOI18N
        getContentPane().add(hesapadi_txt);
        hesapadi_txt.setBounds(170, 50, 143, 31);

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 30)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(204, 0, 204));
        jLabel9.setText("TOP 10/POP");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(1292, 150, 200, 50);

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 30)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(204, 204, 0));
        jLabel10.setText("Takip Edilen Üyeler");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(850, 300, 380, 40);

        uyerap.setBackground(new java.awt.Color(0, 153, 153));
        uyerap.setForeground(new java.awt.Color(255, 255, 255));
        uyerap.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        uyerap.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                uyerapMousePressed(evt);
            }
        });
        jScrollPane11.setViewportView(uyerap);

        getContentPane().add(jScrollPane11);
        jScrollPane11.setBounds(880, 540, 290, 90);

        uyerock.setBackground(new java.awt.Color(0, 153, 153));
        uyerock.setForeground(new java.awt.Color(255, 255, 255));
        uyerock.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        uyerock.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                uyerockMousePressed(evt);
            }
        });
        jScrollPane13.setViewportView(uyerock);

        getContentPane().add(jScrollPane13);
        jScrollPane13.setBounds(600, 540, 270, 90);

        uyepop.setBackground(new java.awt.Color(0, 153, 153));
        uyepop.setForeground(new java.awt.Color(255, 255, 255));
        uyepop.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        uyepop.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                uyepopMousePressed(evt);
            }
        });
        jScrollPane12.setViewportView(uyepop);

        getContentPane().add(jScrollPane12);
        jScrollPane12.setBounds(320, 540, 270, 90);

        tophepsi.setBackground(new java.awt.Color(0, 153, 153));
        tophepsi.setForeground(new java.awt.Color(255, 255, 255));
        tophepsi.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane10.setViewportView(tophepsi);

        getContentPane().add(jScrollPane10);
        jScrollPane10.setBounds(1210, 50, 320, 100);

        jLabel11.setBackground(new java.awt.Color(255, 255, 255));
        jLabel11.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 30)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(204, 0, 204));
        jLabel11.setText("TOP 10/RAP");
        getContentPane().add(jLabel11);
        jLabel11.setBounds(1291, 440, 190, 40);

        jLabel12.setBackground(new java.awt.Color(255, 255, 255));
        jLabel12.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 30)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(204, 0, 204));
        jLabel12.setText("TOP 10");
        getContentPane().add(jLabel12);
        jLabel12.setBounds(1331, 0, 100, 50);

        jLabel13.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 24)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 0, 0));
        jLabel13.setText("Hesap Türü:");
        getContentPane().add(jLabel13);
        jLabel13.setBounds(30, 90, 108, 31);

        odeme_txt.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 24)); // NOI18N
        getContentPane().add(odeme_txt);
        odeme_txt.setBounds(170, 130, 143, 31);

        hesaptur_txt.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 24)); // NOI18N
        getContentPane().add(hesaptur_txt);
        hesaptur_txt.setBounds(170, 90, 143, 31);

        takipgoster.setBackground(new java.awt.Color(255, 102, 102));
        takipgoster.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 18)); // NOI18N
        takipgoster.setText("Çalma Liste Göster");
        takipgoster.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                takipgosterActionPerformed(evt);
            }
        });
        getContentPane().add(takipgoster);
        takipgoster.setBounds(1010, 450, 180, 40);

        takipetbuton.setBackground(new java.awt.Color(255, 102, 102));
        takipetbuton.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 18)); // NOI18N
        takipetbuton.setText("Takip Et");
        takipetbuton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                takipetbutonActionPerformed(evt);
            }
        });
        getContentPane().add(takipetbuton);
        takipetbuton.setBounds(330, 450, 100, 40);

        jLabel16.setBackground(new java.awt.Color(255, 255, 255));
        jLabel16.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 30)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(204, 204, 0));
        jLabel16.setText("Seçilen Üyeye Ait Çalma Listeleri");
        getContentPane().add(jLabel16);
        jLabel16.setBounds(570, 460, 420, 50);

        jLabel17.setBackground(new java.awt.Color(255, 255, 255));
        jLabel17.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 30)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 204, 0));
        jLabel17.setText("POP");
        getContentPane().add(jLabel17);
        jLabel17.setBounds(430, 500, 110, 40);

        jLabel18.setBackground(new java.awt.Color(255, 255, 255));
        jLabel18.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 30)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 204, 0));
        jLabel18.setText("ROCK");
        getContentPane().add(jLabel18);
        jLabel18.setBounds(700, 500, 160, 40);

        takipkullanicilar.setBackground(new java.awt.Color(0, 153, 153));
        takipkullanicilar.setForeground(new java.awt.Color(255, 255, 255));
        takipkullanicilar.setModel(new javax.swing.table.DefaultTableModel(
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
        takipkullanicilar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                takipkullanicilarMousePressed(evt);
            }
        });
        jScrollPane14.setViewportView(takipkullanicilar);

        getContentPane().add(jScrollPane14);
        jScrollPane14.setBounds(770, 340, 430, 100);

        jLabel19.setBackground(new java.awt.Color(255, 255, 255));
        jLabel19.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 30)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(204, 204, 0));
        jLabel19.setText("Premium Üyeler");
        getContentPane().add(jLabel19);
        jLabel19.setBounds(440, 300, 270, 50);

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/arkaplanı.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 1730, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 950, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 1730, 940);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void sarkieklebutonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sarkieklebutonActionPerformed
        
        SarkiEkle(hesapadi_txt.getText());
        PopEkle(hesapadi_txt.getText());
        RockEkle(hesapadi_txt.getText());
        RapEkle(hesapadi_txt.getText());
    }//GEN-LAST:event_sarkieklebutonActionPerformed

    private void sarkilartableMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sarkilartableMousePressed
        
        muziktur=(String) sarkilartable.getValueAt(sarkilartable.getSelectedRow(), 5);
        sarkiadi=(String) sarkilartable.getValueAt(sarkilartable.getSelectedRow(), 1);
        sanatci=(String) sarkilartable.getValueAt(sarkilartable.getSelectedRow(), 3);
        
    }//GEN-LAST:event_sarkilartableMousePressed

    private void takipetbutonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_takipetbutonActionPerformed
        // TODO add your handling code here:
        TakipEt(hesapadi_txt.getText());
        TakipTablo(hesapadi_txt.getText());
        
    }//GEN-LAST:event_takipetbutonActionPerformed

    private void prkullanicilarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_prkullanicilarMousePressed
        // TODO add your handling code here:
        
        idkullanici=(int) prkullanicilar.getValueAt(prkullanicilar.getSelectedRow(), 0);
        kullaniciadi=(String) prkullanicilar.getValueAt(prkullanicilar.getSelectedRow(), 1);
        kullaniciemail=(String) prkullanicilar.getValueAt(prkullanicilar.getSelectedRow(), 2);
        kullanicitur=(String) prkullanicilar.getValueAt(prkullanicilar.getSelectedRow(), 3);
        kullaniciulke=(String) prkullanicilar.getValueAt(prkullanicilar.getSelectedRow(), 4);
        
    }//GEN-LAST:event_prkullanicilarMousePressed

    private void takipkullanicilarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_takipkullanicilarMousePressed
        // TODO add your handling code here:
        takipad=(String) takipkullanicilar.getValueAt(takipkullanicilar.getSelectedRow(), 1);
    }//GEN-LAST:event_takipkullanicilarMousePressed

    private void takipgosterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_takipgosterActionPerformed
        // TODO add your handling code here:
        TakipPop(takipad);
        TakipRock(takipad);
        TakipRap(takipad);
    }//GEN-LAST:event_takipgosterActionPerformed

    private void listeneeklebutonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listeneeklebutonActionPerformed
        // TODO add your handling code here:
        SarkiEkle(hesapadi_txt.getText());
        PopEkle(hesapadi_txt.getText());
        RockEkle(hesapadi_txt.getText());
        RapEkle(hesapadi_txt.getText());
    }//GEN-LAST:event_listeneeklebutonActionPerformed

    private void uyepopMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_uyepopMousePressed
        // TODO add your handling code here:
        muziktur=(String) uyepop.getValueAt(uyepop.getSelectedRow(), 0);
        sarkiadi=(String) uyepop.getValueAt(uyepop.getSelectedRow(), 1);
        sanatci=(String) uyepop.getValueAt(uyepop.getSelectedRow(), 2);
    }//GEN-LAST:event_uyepopMousePressed

    private void uyerockMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_uyerockMousePressed
        // TODO add your handling code here:
        muziktur=(String) uyerock.getValueAt(uyerock.getSelectedRow(), 0);
        sarkiadi=(String) uyerock.getValueAt(uyerock.getSelectedRow(), 1);
        sanatci=(String) uyerock.getValueAt(uyerock.getSelectedRow(), 2);
    }//GEN-LAST:event_uyerockMousePressed

    private void uyerapMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_uyerapMousePressed
        // TODO add your handling code here:
        muziktur=(String) uyerap.getValueAt(uyerap.getSelectedRow(), 0);
        sarkiadi=(String) uyerap.getValueAt(uyerap.getSelectedRow(), 1);
        sanatci=(String) uyerap.getValueAt(uyerap.getSelectedRow(), 2);
    }//GEN-LAST:event_uyerapMousePressed

    private void rockeklebutonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rockeklebutonActionPerformed
        // TODO add your handling code here:
        String ad = hesapadi_txt.getText();
        String tablo = takipad;
        RockTumEkle(ad,tablo);
        RockEkle(hesapadi_txt.getText());
    }//GEN-LAST:event_rockeklebutonActionPerformed

    private void popeklebutonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_popeklebutonActionPerformed
        // TODO add your handling code here:
        String ad = hesapadi_txt.getText();
        String tablo = takipad;
        PopTumEkle(ad,tablo);
        PopEkle(hesapadi_txt.getText());
    }//GEN-LAST:event_popeklebutonActionPerformed

    private void rapeklebutonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rapeklebutonActionPerformed
        // TODO add your handling code here:
        String ad = hesapadi_txt.getText();
        String tablo = takipad;
        RapTumEkle(ad,tablo);
        RapEkle(hesapadi_txt.getText());
    }//GEN-LAST:event_rapeklebutonActionPerformed

    private void sarkicalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sarkicalActionPerformed
        DinlenmeArttir(secilensarki);
        TabloDoldurSarkilar();
        TabloDoldurTopPop();
        TabloDoldurTopRock();
        TabloDoldurTopRap();
        TabloDoldurTopHepsi();
    }//GEN-LAST:event_sarkicalActionPerformed

    private void poptableMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_poptableMousePressed
       secilensarki=(String) poptable.getValueAt(poptable.getSelectedRow(), 1);
    }//GEN-LAST:event_poptableMousePressed

    private void rocktableMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rocktableMousePressed
        secilensarki=(String) rocktable.getValueAt(rocktable.getSelectedRow(), 1);
    }//GEN-LAST:event_rocktableMousePressed

    private void raptableMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_raptableMousePressed
        secilensarki=(String) raptable.getValueAt(raptable.getSelectedRow(), 1);
    }//GEN-LAST:event_raptableMousePressed

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
            java.util.logging.Logger.getLogger(Kullanici3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Kullanici3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Kullanici3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Kullanici3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Kullanici3().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel hesapadi_txt;
    private javax.swing.JLabel hesaptur_txt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JButton listeneeklebuton;
    private javax.swing.JLabel odeme_txt;
    private javax.swing.JLabel odemelabel;
    private javax.swing.JButton popeklebuton;
    private javax.swing.JTable poptable;
    private javax.swing.JTable prkullanicilar;
    private javax.swing.JButton rapeklebuton;
    private javax.swing.JTable raptable;
    private javax.swing.JButton rockeklebuton;
    private javax.swing.JTable rocktable;
    private javax.swing.JButton sarkical;
    private javax.swing.JButton sarkieklebuton;
    private javax.swing.JTable sarkilartable;
    private javax.swing.JButton takipetbuton;
    private javax.swing.JButton takipgoster;
    private javax.swing.JTable takipkullanicilar;
    private javax.swing.JTable tophepsi;
    private javax.swing.JTable toppop;
    private javax.swing.JTable toprap;
    private javax.swing.JTable toprock;
    private javax.swing.JTable uyepop;
    private javax.swing.JTable uyerap;
    private javax.swing.JTable uyerock;
    // End of variables declaration//GEN-END:variables
}
