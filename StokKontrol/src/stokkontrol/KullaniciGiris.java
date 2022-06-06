package stokkontrol;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class KullaniciGiris extends javax.swing.JFrame {

    Connection con = null;
    Statement st = null;
    ResultSet rs = null;

    public KullaniciGiris() {
        super("Kullanıcı Giriş Ekranı");
        initComponents();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btngiris = new javax.swing.JButton();
        txtsifre = new javax.swing.JTextField();
        txtisim = new javax.swing.JTextField();
        btnkayitol = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel1.setText("İsim");

        jLabel2.setText("Şifre");

        btngiris.setText("GİRİŞ");
        btngiris.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btngirisActionPerformed(evt);
            }
        });

        btnkayitol.setText("KAYIT OL");
        btnkayitol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnkayitolActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(113, 113, 113)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(48, 48, 48)
                        .addComponent(txtisim, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(53, 53, 53)
                        .addComponent(txtsifre)))
                .addGap(183, 183, 183))
            .addGroup(layout.createSequentialGroup()
                .addGap(155, 155, 155)
                .addComponent(btngiris, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnkayitol, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(118, 118, 118)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtisim, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtsifre, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btngiris, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnkayitol, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(127, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btngirisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btngirisActionPerformed

        String isim = txtisim.getText();
        String sifre = txtsifre.getText();

        try {
            if (isim.equals("") || sifre.equals("")) {
                JOptionPane.showMessageDialog(this, "Lütfen Boş Alanları Doldurunuz!");

            } else {
                Class.forName("org.postgresql.Driver");

                con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/depo_stok", "postgres", "198573999");
                st = con.createStatement();

                rs = st.executeQuery("SELECT * FROM kayit WHERE isim='" + isim + "' and sifre='" + sifre + "'");

                if (rs.next()) {

                    if (rs.getString("isim").equals(isim)) {
                        AnaEkran open = new AnaEkran();
                        open.setVisible(true);

                        KullaniciGiris close = new KullaniciGiris();
                        close.setVisible(false);
                        dispose();
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "isim veya şifre yanlış! ");
                }
            }
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Hata: " + ex.toString());

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Veritabanına bağlantı sağlanamadı! " + ex.toString());
        }
    }//GEN-LAST:event_btngirisActionPerformed

    private void btnkayitolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnkayitolActionPerformed
        KullaniciKayit open = new KullaniciKayit();
        open.setVisible(true);

        KullaniciGiris close = new KullaniciGiris();
        close.setVisible(false);
        dispose();
    }//GEN-LAST:event_btnkayitolActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new KullaniciGiris().setVisible(true);
                try {
                    UIManager.setLookAndFeel( UIManager.getSystemLookAndFeelClassName() );
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(KullaniciGiris.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InstantiationException ex) {
                    Logger.getLogger(KullaniciGiris.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                    Logger.getLogger(KullaniciGiris.class.getName()).log(Level.SEVERE, null, ex);
                } catch (UnsupportedLookAndFeelException ex) {
                    Logger.getLogger(KullaniciGiris.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btngiris;
    private javax.swing.JButton btnkayitol;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField txtisim;
    private javax.swing.JTextField txtsifre;
    // End of variables declaration//GEN-END:variables
}
