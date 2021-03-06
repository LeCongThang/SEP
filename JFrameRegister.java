/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.JRootPane;
import Common.EmailValidator;
import Entities.EndUser;
import Bus.*;
import Common.*;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author Administrator
 */
public class JFrameRegister extends javax.swing.JFrame {

    EndUser e = new EndUser();
    Account_Bus a = new Account_Bus();
    Common c = new Common();

    /**
     * Creates new form JFrameRegister
     */
    public JFrameRegister() {
        initComponents();
        setLocationRelativeTo(null);
        getContentPane().setBackground(new java.awt.Color(0,153,100));
        JRootPane rootPane = this.getRootPane();
        rootPane.setDefaultButton(btnRegister);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblEmail = new javax.swing.JLabel();
        btnRegister = new javax.swing.JButton();
        txtEmailRegister = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("REGISTER ACCOUNT");

        lblEmail.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblEmail.setText("Email:");

        btnRegister.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/1468064777_add_user.png"))); // NOI18N
        btnRegister.setText("Register");
        btnRegister.setToolTipText("Register");
        btnRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegisterActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(77, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(txtEmailRegister, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnRegister, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(120, 120, 120))))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(13, 13, 13)
                    .addComponent(lblEmail)
                    .addContainerGap(339, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(66, Short.MAX_VALUE)
                .addComponent(txtEmailRegister, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnRegister)
                .addGap(57, 57, 57))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(65, 65, 65)
                    .addComponent(lblEmail)
                    .addContainerGap(107, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
public boolean checkusernameagian(String username) {
        for (EndUser us : a.finllusername()) {
            if (us.getEmail().toUpperCase().equalsIgnoreCase(username.toUpperCase())) {
                return true;
            }
        }
        return false;
    }

    void Register() {
        try {

            String email = this.txtEmailRegister.getText();

            String password = "m2tpj";

            if (email.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Email is empty");
            } else if (!email.isEmpty() && !password.isEmpty()) {

                if (checkusernameagian(email)) {
                    JOptionPane.showMessageDialog(null, "Email already exists");
                } else {
                    e.setEmail(email);
                    e.setPass(password);
                    if (a.create(e)) {
                        JOptionPane.showMessageDialog(null, "Register successfully! Please check email to get password");
                        JFrameMain f = new JFrameMain(txtEmailRegister.getText());
                        f.setVisible(true);
                        this.dispose();
                    } else {
                        JOptionPane.showMessageDialog(null, "Register failure");

                    }
                }
            }

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e.getMessage());

        }

    }
   
    private void btnRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegisterActionPerformed

        EmailValidator emailValidator = new EmailValidator();
        if (!emailValidator.validate(txtEmailRegister.getText().trim())) {
            JOptionPane.showMessageDialog(null, "Email Invalid!");
        } else {
            final String username = "hoavosac07101995@gmail.com";
            final String password = "Lecongthangandkutit07101995";
            Properties p = new Properties();
            p.put("mail.smtp.auth", "true");
            p.put("mail.smtp.starttls.enable", "true");
            p.put("mail.smtp.host", "smtp.gmail.com");
            p.put("mail.smtp.port", "587");
            Session s = Session.getInstance(p, new javax.mail.Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(username, password);
                }
            });
            try {
                Message msg = new MimeMessage(s);
                msg.setFrom(new InternetAddress("hoavosac07101995@gmail.com"));
                msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(txtEmailRegister.getText()));
                msg.setSubject("LogTime Software_Register Account");
                msg.setContent("<p>Your password is: <h4 style=color:red;>m2tpj</h4></p> <p>Thank you!</p>", "text/html;");
                Transport.send(msg);
                Register();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Fail! Please, check the network connection!");
            }

    }//GEN-LAST:event_btnRegisterActionPerformed

    }

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
            java.util.logging.Logger.getLogger(JFrameRegister.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrameRegister.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrameRegister.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrameRegister.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFrameRegister().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegister;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JTextField txtEmailRegister;
    // End of variables declaration//GEN-END:variables
}
