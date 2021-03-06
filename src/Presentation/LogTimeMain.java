/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import java.awt.Desktop;
import java.awt.Dimension;
import java.net.URL;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;

/**
 *
 * @author Administrator
 */
public class LogTimeMain extends javax.swing.JFrame {

    /**
     * Creates new form LogTimeMain
     */
    static String Username = "";

    public LogTimeMain(String username) {
        initComponents();
        setLocationRelativeTo(null);
        Username = username;
        lblTK.setText(Username);
        lblTK.setToolTipText(username);
    }

    public LogTimeMain() {
        initComponents();
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JToolBar.Separator();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JToolBar.Separator();
        jButton7 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jSeparator6 = new javax.swing.JToolBar.Separator();
        jButton14 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        jToolBar2 = new javax.swing.JToolBar();
        btnLogtime = new javax.swing.JButton();
        btnTags = new javax.swing.JButton();
        btnReport = new javax.swing.JButton();
        jSeparator5 = new javax.swing.JToolBar.Separator();
        btnSetting = new javax.swing.JButton();
        btnAccount = new javax.swing.JButton();
        jSeparator7 = new javax.swing.JToolBar.Separator();
        jButton19 = new javax.swing.JButton();
        btnAbout = new javax.swing.JButton();
        jSeparator8 = new javax.swing.JToolBar.Separator();
        btnLogout = new javax.swing.JButton();
        jSeparator9 = new javax.swing.JToolBar.Separator();
        lblTK = new javax.swing.JLabel();

        jToolBar1.setRollover(true);

        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/1462746769_preferences-system-time.png"))); // NOI18N
        jButton8.setText("Log Times");
        jButton8.setFocusable(false);
        jButton8.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton8.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(jButton8);

        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/1462746848_tag.png"))); // NOI18N
        jButton9.setText("Tags");
        jButton9.setFocusable(false);
        jButton9.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton9.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(jButton9);

        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/1462746967_graphs.png"))); // NOI18N
        jButton10.setText("Reports");
        jButton10.setFocusable(false);
        jButton10.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton10.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton10);
        jToolBar1.add(jSeparator3);

        jButton12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/1462747947_addressbook.png"))); // NOI18N
        jButton12.setText("About Us");
        jButton12.setFocusable(false);
        jButton12.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton12.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(jButton12);

        jButton13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/1462748050_internet-explorer.png"))); // NOI18N
        jButton13.setText("Web Version");
        jButton13.setFocusable(false);
        jButton13.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton13.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(jButton13);
        jToolBar1.add(jSeparator4);

        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/1462747688_sign-up.png"))); // NOI18N
        jButton7.setText("Account");
        jButton7.setFocusable(false);
        jButton7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton7.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(jButton7);

        jButton11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/1462747857_Exit.png"))); // NOI18N
        jButton11.setText("Log out");
        jButton11.setFocusable(false);
        jButton11.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton11.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(jButton11);
        jToolBar1.add(jSeparator6);

        jButton14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/1462749155_setting.png"))); // NOI18N
        jButton14.setText("Settings");
        jButton14.setFocusable(false);
        jButton14.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton14.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(jButton14);
        jToolBar1.add(jSeparator1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("LOG TIME SOFTWARE");
        setBackground(new java.awt.Color(6, 12, 2));
        setResizable(false);

        jToolBar2.setRollover(true);

        btnLogtime.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/1462746769_preferences-system-time.png"))); // NOI18N
        btnLogtime.setText("Log Times");
        btnLogtime.setFocusable(false);
        btnLogtime.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnLogtime.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnLogtime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogtimeActionPerformed(evt);
            }
        });
        jToolBar2.add(btnLogtime);

        btnTags.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/1462746848_tag.png"))); // NOI18N
        btnTags.setText("Tags");
        btnTags.setFocusable(false);
        btnTags.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnTags.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnTags.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTagsActionPerformed(evt);
            }
        });
        jToolBar2.add(btnTags);

        btnReport.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/1462746967_graphs.png"))); // NOI18N
        btnReport.setText("Reports");
        btnReport.setFocusable(false);
        btnReport.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnReport.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReportActionPerformed(evt);
            }
        });
        jToolBar2.add(btnReport);
        jToolBar2.add(jSeparator5);

        btnSetting.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/1462749155_setting.png"))); // NOI18N
        btnSetting.setText("Settings");
        btnSetting.setFocusable(false);
        btnSetting.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSetting.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnSetting.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSettingActionPerformed(evt);
            }
        });
        jToolBar2.add(btnSetting);

        btnAccount.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/1462747688_sign-up.png"))); // NOI18N
        btnAccount.setText("Account");
        btnAccount.setFocusable(false);
        btnAccount.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAccount.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAccountActionPerformed(evt);
            }
        });
        jToolBar2.add(btnAccount);
        jToolBar2.add(jSeparator7);

        jButton19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/1462748050_internet-explorer.png"))); // NOI18N
        jButton19.setText("Web Version");
        jButton19.setFocusable(false);
        jButton19.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton19.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton19ActionPerformed(evt);
            }
        });
        jToolBar2.add(jButton19);

        btnAbout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/1462747947_addressbook.png"))); // NOI18N
        btnAbout.setText("About Us");
        btnAbout.setFocusable(false);
        btnAbout.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAbout.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnAbout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAboutActionPerformed(evt);
            }
        });
        jToolBar2.add(btnAbout);
        jToolBar2.add(jSeparator8);

        btnLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/1462747857_Exit.png"))); // NOI18N
        btnLogout.setText("Log out");
        btnLogout.setFocusable(false);
        btnLogout.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnLogout.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });
        jToolBar2.add(btnLogout);
        jToolBar2.add(jSeparator9);

        lblTK.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        lblTK.setForeground(new java.awt.Color(0, 51, 153));
        lblTK.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/1463610008_googleplus.png"))); // NOI18N
        lblTK.setText("jLabel1");
        jToolBar2.add(lblTK);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar2, javax.swing.GroupLayout.DEFAULT_SIZE, 777, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar2, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(432, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton10ActionPerformed

    private void btnReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReportActionPerformed
        
    }//GEN-LAST:event_btnReportActionPerformed
    void CloseTabs() {
        
    }
    private void btnLogtimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogtimeActionPerformed
        // TODO add your handling code here:
        

    }//GEN-LAST:event_btnLogtimeActionPerformed

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
       
        Common.Common.DeleteSession();
        JFrameMain f = new JFrameMain(lblTK.getText());
        f.setVisible(true);
        this.dispose();


        // TODO add your handling code here:
    }//GEN-LAST:event_btnLogoutActionPerformed

    private void btnTagsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTagsActionPerformed
JFrameTags t = new JFrameTags();
        this.getContentPane().add(t);
        Dimension desktopSize = this.getSize();
        Dimension jInternalFrameSize = t.getSize();
        t.setLocation((desktopSize.width - jInternalFrameSize.width) / 2 - 3,
                (desktopSize.height - jInternalFrameSize.height) / 2 + 35);
        t.setVisible(true);
        //t.toFront();
// TODO add your handling code here:
    }//GEN-LAST:event_btnTagsActionPerformed

    private void jButton19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton19ActionPerformed

        
    }//GEN-LAST:event_jButton19ActionPerformed

    private void btnAboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAboutActionPerformed
       
    }//GEN-LAST:event_btnAboutActionPerformed

    private void btnAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAccountActionPerformed

        CloseTabs();
        JFrameAccount t = new JFrameAccount(lblTK.getText());
        this.getContentPane().add(t);
        Dimension desktopSize = this.getSize();
        Dimension jInternalFrameSize = t.getSize();
        t.setLocation((desktopSize.width - jInternalFrameSize.width) / 2 - 3,
                (desktopSize.height - jInternalFrameSize.height) / 2 + 35);
        t.setVisible(true);
        
    }//GEN-LAST:event_btnAccountActionPerformed

    private void btnSettingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSettingActionPerformed
        
    }//GEN-LAST:event_btnSettingActionPerformed

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
            java.util.logging.Logger.getLogger(LogTimeMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LogTimeMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LogTimeMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LogTimeMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LogTimeMain().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAbout;
    private javax.swing.JButton btnAccount;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnLogtime;
    private javax.swing.JButton btnReport;
    private javax.swing.JButton btnSetting;
    private javax.swing.JButton btnTags;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator3;
    private javax.swing.JToolBar.Separator jSeparator4;
    private javax.swing.JToolBar.Separator jSeparator5;
    private javax.swing.JToolBar.Separator jSeparator6;
    private javax.swing.JToolBar.Separator jSeparator7;
    private javax.swing.JToolBar.Separator jSeparator8;
    private javax.swing.JToolBar.Separator jSeparator9;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JToolBar jToolBar2;
    private javax.swing.JLabel lblTK;
    // End of variables declaration//GEN-END:variables
}
