package stokkontrol;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;

public class AnaEkran extends javax.swing.JFrame {

    Connection con = null;
    Statement st = null;
    ResultSet rs = null;
    PreparedStatement st1 = null;

    public AnaEkran() {
        super("Ana Ekran");

        initComponents();

        MalzemeListeGuncelle();
        GönderilenListeGuncelle();
    }

    private void MalzemeListeGuncelle() {

        try {
            DefaultTableModel dm = (DefaultTableModel) JtblMalzemeler.getModel();
            dm.getDataVector().removeAllElements();
            JtblMalzemeler.repaint();

            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/depo_stok", "postgres", "198573999");
            st = con.createStatement();

            rs = st.executeQuery("SELECT * FROM depo");

            while (rs.next()) {
                String malzemeadi = rs.getString("malzemeadi");
                String adet = rs.getString("adet");
                String parcano = rs.getString("parcano");
                String serino = rs.getString("serino");
                String depokonumu = rs.getString("depokonumu");
                String gelisturu = rs.getString("gelisturu");

                String tbData[] = {malzemeadi, adet, parcano, serino, depokonumu, gelisturu};
                DefaultTableModel tblModel = (DefaultTableModel) JtblMalzemeler.getModel();

                tblModel.addRow(tbData);
            }
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Hata: " + ex.toString());

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Veritabanına bağlantı sağlanamadı! " + ex.toString());
        }
    }

    private void GönderilenListeGuncelle() {

        try {
            DefaultTableModel dm = (DefaultTableModel) JtblGonderilen.getModel();
            dm.getDataVector().removeAllElements();
            JtblGonderilen.repaint();

            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/depo_stok", "postgres", "198573999");
            st = con.createStatement();

            rs = st.executeQuery("SELECT * FROM gonderilen");

            while (rs.next()) {
                String malzemeadi = rs.getString("malzemeadi");
                String adet = rs.getString("adet");
                String parcano = rs.getString("parcano");
                String serino = rs.getString("serino");
                String gonderilenbolum = rs.getString("gonderilenbolum");
                String gonderenpersonel = rs.getString("gonderenpersonel");
                String zimmetlipersonel = rs.getString("zimmetlipersonel");
                String tarih = rs.getString("tarih");

                String tbData[] = {malzemeadi, adet, parcano, serino, gonderilenbolum, gonderenpersonel, zimmetlipersonel, tarih};
                DefaultTableModel tblModel = (DefaultTableModel) JtblGonderilen.getModel();

                tblModel.addRow(tbData);
            }
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Hata: " + ex.toString());

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Veritabanına bağlantı sağlanamadı! " + ex.toString());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFrame1 = new javax.swing.JFrame();
        jFrame2 = new javax.swing.JFrame();
        jMenuItem1 = new javax.swing.JMenuItem();
        jRadioButtonMenuItem1 = new javax.swing.JRadioButtonMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        jDialog1 = new javax.swing.JDialog();
        jPanel1 = new javax.swing.JPanel();
        txtAdet = new javax.swing.JTextField();
        txtMalzemeadi = new javax.swing.JTextField();
        txtSerino = new javax.swing.JTextField();
        txtParcano = new javax.swing.JTextField();
        cmbGonderilenBolum = new javax.swing.JComboBox<>();
        txtGPersonel = new javax.swing.JTextField();
        cmbDepoKonumu = new javax.swing.JComboBox<>();
        txtZPersonel = new javax.swing.JTextField();
        cmbGelisTuru = new javax.swing.JComboBox<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnguncelle = new javax.swing.JButton();
        btntemizle = new javax.swing.JButton();
        btnsilme = new javax.swing.JButton();
        btnekle = new javax.swing.JButton();
        btnGonder = new javax.swing.JButton();
        btnAzalanMalzemeler = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        JtblGonderilen = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        JtblMalzemeler = new javax.swing.JTable();

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jFrame2Layout = new javax.swing.GroupLayout(jFrame2.getContentPane());
        jFrame2.getContentPane().setLayout(jFrame2Layout);
        jFrame2Layout.setHorizontalGroup(
            jFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame2Layout.setVerticalGroup(
            jFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        jMenuItem1.setText("jMenuItem1");

        jRadioButtonMenuItem1.setSelected(true);
        jRadioButtonMenuItem1.setText("jRadioButtonMenuItem1");

        jMenu3.setText("jMenu3");

        jCheckBoxMenuItem1.setSelected(true);
        jCheckBoxMenuItem1.setText("jCheckBoxMenuItem1");

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(0, 0, 0, 0));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setLocation(new java.awt.Point(0, 0));
        setMaximizedBounds(new java.awt.Rectangle(0, 0, 0, 0));
        setSize(new java.awt.Dimension(0, 0));

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        txtMalzemeadi.setToolTipText("");

        cmbGonderilenBolum.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-", "Üretim Atölye", "Mekanik Atölye", "Uçak Atölye", "Elektrik Atölye", "Kalite Kontrol", "Roks", "Hürsim" }));
        cmbGonderilenBolum.setToolTipText("");

        txtGPersonel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGPersonelActionPerformed(evt);
            }
        });

        cmbDepoKonumu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-", "SM1", "SM2", "SM5", "SM8", "" }));

        cmbGelisTuru.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Satın Alma", "Üretim" }));

        jTable1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Malzeme Adı", "Adet", "Parça No", "Seri No", "Depo Konumu", "Geliş türü", "Gönderilen Bölüm", "Gönderen Personel", "Zimmetli Personel"
            }
        ));
        jScrollPane3.setViewportView(jTable1);

        btnguncelle.setText("Güncelle");
        btnguncelle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguncelleActionPerformed(evt);
            }
        });

        btntemizle.setText("Temizle");
        btntemizle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btntemizleActionPerformed(evt);
            }
        });

        btnsilme.setText("Sil");
        btnsilme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsilmeActionPerformed(evt);
            }
        });

        btnekle.setText("Ekle");
        btnekle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnekleActionPerformed(evt);
            }
        });

        btnGonder.setText("Malzeme Çıkış");
        btnGonder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGonderActionPerformed(evt);
            }
        });

        btnAzalanMalzemeler.setText("Azalan Malzemeler");
        btnAzalanMalzemeler.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAzalanMalzemelerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 1323, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtMalzemeadi, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(txtAdet, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(txtParcano, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(txtSerino, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(cmbDepoKonumu, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(cmbGelisTuru, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(cmbGonderilenBolum, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(txtGPersonel, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(txtZPersonel, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnekle, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnguncelle, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnsilme, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btntemizle, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnGonder, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnAzalanMalzemeler)
                        .addGap(319, 319, 319)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtMalzemeadi, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtAdet, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtParcano, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtGPersonel, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtZPersonel, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbDepoKonumu)
                            .addComponent(txtSerino)
                            .addComponent(cmbGelisTuru)
                            .addComponent(cmbGonderilenBolum))))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnekle, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnguncelle, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnsilme, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btntemizle, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnGonder, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnAzalanMalzemeler, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 20, Short.MAX_VALUE))
        );

        JtblGonderilen.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.black, java.awt.Color.white, null, null));
        JtblGonderilen.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Malzeme Adı", "Adet", "Parça No", "Seri No", "Gönderilen Bölüm", "Gönderen Personel", "Zimmetli Personel", "Tarih"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(JtblGonderilen);

        jLabel3.setText("Stoktaki Malzemeler");

        jLabel4.setText("Çıkışı Yapılan Malzemeler");

        JtblMalzemeler.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        JtblMalzemeler.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Malzeme Adı", "Adet", "Parça No", "Seri No", "Depo Konumu", "Geliş Türü"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        JtblMalzemeler.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JtblMalzemelerMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(JtblMalzemeler);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1311, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addGap(24, 24, 24))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(6, 6, 6)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addComponent(jLabel4)
                .addGap(6, 6, 6)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnekleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnekleActionPerformed
        String malzemeadi = txtMalzemeadi.getText();
        String adet = txtAdet.getText();
        String parcano = txtParcano.getText();
        String serino = txtSerino.getText();
        String depokonumu = (String) cmbDepoKonumu.getSelectedItem();
        String gelisturu = (String) cmbGelisTuru.getSelectedItem();

        try {

            if (malzemeadi.equals("") || adet.equals("") || parcano.equals("") || serino.equals("") || depokonumu.equals("-") || gelisturu.equals("")) {

                JOptionPane.showMessageDialog(this, "Lütfen Boş Alanları Doldurunuz!");

            } else {
                Class.forName("org.postgresql.Driver");

                con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/depo_stok", "postgres", "198573999");
                st = con.createStatement();

                String sql = "INSERT INTO depo VALUES ('" + malzemeadi + "', '" + adet + "', '" + parcano + "', '" + serino + "', '" + depokonumu + "', '" + gelisturu + "')";

                st.executeUpdate(sql);
                JOptionPane.showMessageDialog(null, malzemeadi + "  adlı ürün eklenmiştir.");
                MalzemeListeGuncelle();

            }

        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Hata: " + ex.toString());

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Veritabanına bağlantı sağlanamadı! " + ex.toString());
        }

    }//GEN-LAST:event_btnekleActionPerformed

    private void btnguncelleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguncelleActionPerformed

        try {
            String malzemeadi = txtMalzemeadi.getText();
            Class.forName("org.postgresql.Driver");

            con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/depo_stok", "postgres", "198573999");

            String sorgu = "UPDATE depo SET malzemeadi='" + txtMalzemeadi.getText() + "'"
                    + ",adet='" + txtAdet.getText() + "'"
                    + ",parcano='" + txtParcano.getText() + "'"
                    + ",serino='" + txtSerino.getText() + "'"
                    + ",depokonumu='" + cmbDepoKonumu.getSelectedItem() + "'"
                    + ",gelisturu='" + cmbGelisTuru.getSelectedItem() + "' where malzemeadi='" + malzemeadi + "'";

            st = con.createStatement();
            st.executeUpdate(sorgu);

            JOptionPane.showMessageDialog(null, "Ürün Güncellemesi Tamamlanmıştır.");

        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Hata: " + ex.toString());

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Veritabanına bağlantı sağlanamadı! " + ex.toString());
        }

        MalzemeListeGuncelle();
    }//GEN-LAST:event_btnguncelleActionPerformed

    private void btnsilmeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsilmeActionPerformed
        try {
            String malzemeadi = txtMalzemeadi.getText();
            Class.forName("org.postgresql.Driver");

            con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/depo_stok", "postgres", "198573999");

            String sorgu = "DELETE FROM depo WHERE malzemeadi='" + malzemeadi + "'";

            st = con.createStatement();
            st.executeUpdate(sorgu);

            JOptionPane.showMessageDialog(null, malzemeadi + "  adlı malzeme silinmişitir.");

        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Hata: " + ex.toString());

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Veritabanına bağlantı sağlanamadı! " + ex.toString());
        }

        MalzemeListeGuncelle();
    }//GEN-LAST:event_btnsilmeActionPerformed

    private void btntemizleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntemizleActionPerformed
        txtMalzemeadi.setText("");
        txtAdet.setText("");
        txtParcano.setText("");
        txtSerino.setText("");
        cmbDepoKonumu.setSelectedItem("-");
        cmbGonderilenBolum.setSelectedItem("-");
        txtGPersonel.setText("");
        txtZPersonel.setText("");

    }//GEN-LAST:event_btntemizleActionPerformed

    private void JtblMalzemelerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JtblMalzemelerMouseClicked

        DefaultTableModel tblModel = (DefaultTableModel) JtblMalzemeler.getModel();
        int index = JtblMalzemeler.getSelectedRow();

        txtMalzemeadi.setText(tblModel.getValueAt(index, 0).toString());
        txtAdet.setText(tblModel.getValueAt(index, 1).toString());
        txtParcano.setText(tblModel.getValueAt(index, 2).toString());
        txtSerino.setText(tblModel.getValueAt(index, 3).toString());
        cmbDepoKonumu.setSelectedItem(tblModel.getValueAt(index, 4).toString());
        cmbGelisTuru.setSelectedItem(tblModel.getValueAt(index, 5).toString());

    }//GEN-LAST:event_JtblMalzemelerMouseClicked

    private void btnGonderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGonderActionPerformed
        String malzemeadi = txtMalzemeadi.getText();
        String adet = txtAdet.getText();
        String parcano = txtParcano.getText();
        String serino = txtSerino.getText();
        String gonderilenbolum = (String) cmbGonderilenBolum.getSelectedItem();
        String gonderenpersonel = txtGPersonel.getText();
        String zimmetlipersonel = txtZPersonel.getText();

        SimpleDateFormat dt = new SimpleDateFormat("d/M/y h:m:s");
        Date tarih = new Date();
        try {

            if (malzemeadi.equals("") || adet.equals("") || parcano.equals("") || serino.equals("") || gonderilenbolum.equals("-") || gonderenpersonel.equals("") || zimmetlipersonel.equals("")) {

                JOptionPane.showMessageDialog(this, "Lütfen Gerekli Alanları Doldurunuz!");

            } else {
                Class.forName("org.postgresql.Driver");

                con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/depo_stok", "postgres", "198573999");
                st = con.createStatement();

                String sql = "INSERT INTO gonderilen VALUES ('" + malzemeadi + "', '" + adet + "', '" + parcano + "', '" + serino + "', '" + gonderilenbolum + "','" + gonderenpersonel + "','" + zimmetlipersonel + "', '" + tarih + "')";

                String sorgu = "UPDATE depo SET adet=" + "(select adet-" + txtAdet.getText() + " from depo where malzemeadi='" + malzemeadi + "')" + " where malzemeadi='" + malzemeadi + "'";

                st.executeUpdate(sql);
                st.executeUpdate(sorgu);
                JOptionPane.showMessageDialog(null, malzemeadi + "  adlı malzemenin depo çıkışı yapılmıştır.");

                GönderilenListeGuncelle();
                MalzemeListeGuncelle();
            }

        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Hata: " + ex.toString());

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Veritabanına bağlantı sağlanamadı! " + ex.toString());
        }


    }//GEN-LAST:event_btnGonderActionPerformed

    private void txtGPersonelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGPersonelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGPersonelActionPerformed

    private void btnAzalanMalzemelerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAzalanMalzemelerActionPerformed
        AzalanMalzemeler open = new AzalanMalzemeler();
        open.setVisible(true);
            
    }//GEN-LAST:event_btnAzalanMalzemelerActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AnaEkran().setVisible(true);
                try {
                    UIManager.setLookAndFeel( UIManager.getSystemLookAndFeelClassName() );
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(AnaEkran.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InstantiationException ex) {
                    Logger.getLogger(AnaEkran.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                    Logger.getLogger(AnaEkran.class.getName()).log(Level.SEVERE, null, ex);
                } catch (UnsupportedLookAndFeelException ex) {
                    Logger.getLogger(AnaEkran.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable JtblGonderilen;
    private javax.swing.JTable JtblMalzemeler;
    private javax.swing.JButton btnAzalanMalzemeler;
    private javax.swing.JButton btnGonder;
    private javax.swing.JButton btnekle;
    private javax.swing.JButton btnguncelle;
    private javax.swing.JButton btnsilme;
    private javax.swing.JButton btntemizle;
    private javax.swing.JComboBox<String> cmbDepoKonumu;
    private javax.swing.JComboBox<String> cmbGelisTuru;
    private javax.swing.JComboBox<String> cmbGonderilenBolum;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JFrame jFrame2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtAdet;
    private javax.swing.JTextField txtGPersonel;
    private javax.swing.JTextField txtMalzemeadi;
    private javax.swing.JTextField txtParcano;
    private javax.swing.JTextField txtSerino;
    private javax.swing.JTextField txtZPersonel;
    // End of variables declaration//GEN-END:variables
}
