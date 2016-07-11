/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import Bus.*;
import Entities.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Administrator
 */
public class JFrameTime extends javax.swing.JInternalFrame {

    /**
     * Creates new form JFrameTime
     */
    Timer timer;
    Tags_Bus tb = new Tags_Bus();
    LogTime_Bus ltb = new LogTime_Bus();

    int s = 0;
    int m = 0;
    int h = 0;
    //int d = 0;

    public JFrameTime() {
        initComponents();

        LoadTag();
        LoadTable();
        AutoCompletion.enable(cboTags);
        dcDate.setDateFormatString("yyyy/MM/dd");
        timer = new Timer(1000, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

                s = s + 1;
                if (s > 59) {
                    s = 0;
                    m = m + 1;

                } else if (m > 59 && s > 59) {
                    m = 0;
                    h = h + 1;

                } else if (s == 0 && m == 0 && h == 8) {
                    timer.stop();
                    Object[] options1 = {"Save", "Cancel"};
                    JPanel panel = new JPanel();
                    panel.add(new JLabel("Tags is overtime. Do you want Save?"));
                    int result = JOptionPane.showOptionDialog(null, panel, "Enter a Number",
                            JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE,
                            null, options1, null);
                    if (result == JOptionPane.YES_OPTION) {
                        Time time = new Time();
                        LogTime_Bus ltb = new LogTime_Bus();
                        int id = tb.GetIdCbo(cboTags.getSelectedItem().toString(), LogTimeMain.Username);
                        int second = Integer.parseInt(lblSecond.getText()) + Integer.parseInt(lblMinute.getText()) * 60 + Integer.parseInt(lblHour.getText()) * 3600;
                        try {
                            Date parsedDate1 = dateFormat.parse(txtStartTime.getText());
                            Timestamp timestamp1 = new java.sql.Timestamp(parsedDate1.getTime());
                            Timestamp timestamp2 = new java.sql.Timestamp(parsedDate1.getTime() + second * 1000);
//                            if (timestamp2.toString().substring(11).equals( "23:59:59.0")) {
//                                
//                                txtFinishTime.setText(timestamp2.toString().substring(11));
//                                time.setFinishTime(timestamp2);
//                                time.setEndUser(LogTimeMain.Username);
//                                time.setDescription(txtDes.getText());
//                                time.setTags(id);
//                                time.setTimes(second);
//                                time.setStartTime(timestamp1);
//                                if (ltb.Create(time)) {
//                                    JOptionPane.showMessageDialog(null, "Successful!");
//                                    LoadTable();
//                                    Clear();
//                                } else {
//                                    JOptionPane.showMessageDialog(null, "fail");
//                                }
//                            } else {
                            txtFinishTime.setText(timestamp2.toString().substring(11));
                            time.setFinishTime(timestamp2);
                            time.setEndUser(LogTimeMain.Username);
                            time.setDescription(txtDes.getText());
                            time.setTags(id);
                            time.setTimes(second);
                            time.setStartTime(timestamp1);
                            if (ltb.Create(time)) {
                                JOptionPane.showMessageDialog(null, "Successful!");
                                LoadTable();
                                Clear();
                            } else {
                                JOptionPane.showMessageDialog(null, "fail");
                            }
                            //}
                        } catch (ParseException ex) {
                            Logger.getLogger(JFrameTime.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
                lblSecond.setText("0" + Integer.toString(s));
                lblMinute.setText("0" + Integer.toString(m));
                if (Integer.toString(s).length() == 2) {
                    lblSecond.setText(Integer.toString(s));

                } else if (Integer.toString(m).length() == 2) {
                    lblMinute.setText(Integer.toString(m));

                }
                lblHour.setText("0" + Integer.toString(h));

            }
        });

    }

    void LoadTable() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        DefaultTableModel dt = new DefaultTableModel();
        dt.addColumn("DateofTags");
        dt.addColumn("StartTime");
        dt.addColumn("FinishTime");
        dt.addColumn("Tags");
        dt.addColumn("Description");
        dt.addColumn("ID");
        for (Time t : ltb.findall(LogTimeMain.Username)) {
            dt.addRow(new Object[]{t.getdateogTags(), sdf.format(t.getStartTime()), sdf.format(t.getFinishTime()), tb.find(t.getTags()).getTagName(), t.getDescription(), t.getId()});
        }
        tblTimes.setModel(dt);
        tblTimes.repaint();
        tblTimes.validate();
    }

    void LoadTag() {
        DefaultComboBoxModel dc = new DefaultComboBoxModel();
        for (Tags t : tb.findall(LogTimeMain.Username)) {
            dc.addElement(t.getTagName());

        }
        cboTags.setModel(dc);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTimes = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        lblMinute = new javax.swing.JLabel();
        lblSecond = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        lblHour = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtStartTime = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtFinishTime = new javax.swing.JTextField();
        btnfinishTime = new javax.swing.JButton();
        btnStarttime = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDes = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cboTags = new javax.swing.JComboBox();
        dcDate = new com.toedter.calendar.JDateChooser();
        jLabel7 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        btnStop = new javax.swing.JButton();
        btnStart = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setClosable(true);
        setTitle("LOG TIMES");
        setPreferredSize(new java.awt.Dimension(777, 432));

        tblTimes.setModel(new javax.swing.table.DefaultTableModel(
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
        tblTimes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblTimesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblTimes);

        jPanel2.setBackground(new java.awt.Color(0, 153, 100));
        jPanel2.setPreferredSize(new java.awt.Dimension(180, 180));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText(":");

        lblMinute.setFont(new java.awt.Font("Tahoma", 1, 35)); // NOI18N
        lblMinute.setForeground(new java.awt.Color(255, 255, 255));
        lblMinute.setText("00");

        lblSecond.setFont(new java.awt.Font("Tahoma", 1, 35)); // NOI18N
        lblSecond.setForeground(new java.awt.Color(255, 255, 255));
        lblSecond.setText("00");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 40)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Timer");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText(":");

        lblHour.setFont(new java.awt.Font("Tahoma", 1, 35)); // NOI18N
        lblHour.setForeground(new java.awt.Color(255, 255, 255));
        lblHour.setText("00");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(lblHour)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addComponent(lblMinute)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblSecond))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel8)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(76, Short.MAX_VALUE)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMinute)
                    .addComponent(lblSecond)
                    .addComponent(jLabel10)
                    .addComponent(lblHour)
                    .addComponent(jLabel11))
                .addGap(75, 75, 75))
        );

        jPanel3.setBackground(new java.awt.Color(0, 153, 100));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel3.setPreferredSize(new java.awt.Dimension(180, 180));
        jPanel3.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Date:");
        jPanel3.add(jLabel2);
        jLabel2.setBounds(10, 60, 40, 30);
        jPanel3.add(txtStartTime);
        txtStartTime.setBounds(80, 100, 150, 25);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("End Time:");
        jPanel3.add(jLabel3);
        jLabel3.setBounds(270, 100, 60, 30);
        jPanel3.add(txtFinishTime);
        txtFinishTime.setBounds(330, 100, 150, 25);

        btnfinishTime.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/1463741518_access-time.png"))); // NOI18N
        btnfinishTime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnfinishTimeActionPerformed(evt);
            }
        });
        jPanel3.add(btnfinishTime);
        btnfinishTime.setBounds(480, 100, 25, 25);

        btnStarttime.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/1463741518_access-time.png"))); // NOI18N
        btnStarttime.setToolTipText("Get Time now.");
        btnStarttime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStarttimeActionPerformed(evt);
            }
        });
        jPanel3.add(btnStarttime);
        btnStarttime.setBounds(230, 100, 25, 25);

        txtDes.setColumns(20);
        txtDes.setRows(5);
        jScrollPane2.setViewportView(txtDes);

        jPanel3.add(jScrollPane2);
        jScrollPane2.setBounds(80, 140, 430, 70);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Description:");
        jPanel3.add(jLabel4);
        jLabel4.setBounds(10, 150, 70, 15);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Tags:");
        jPanel3.add(jLabel5);
        jLabel5.setBounds(270, 60, 50, 30);

        cboTags.setEditable(true);
        cboTags.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cboTags.setAutoscrolls(true);
        cboTags.setPreferredSize(new java.awt.Dimension(56, 24));
        jPanel3.add(cboTags);
        cboTags.setBounds(330, 65, 175, 24);
        jPanel3.add(dcDate);
        dcDate.setBounds(80, 65, 175, 25);

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Start Time:");
        jPanel3.add(jLabel7);
        jLabel7.setBounds(10, 100, 80, 30);

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/1468020124_download.png"))); // NOI18N
        jButton5.setText("Add");
        jButton5.setToolTipText("Add");
        jButton5.setPreferredSize(new java.awt.Dimension(40, 40));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton5);
        jButton5.setBounds(295, 220, 100, 40);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/1468017867_common-new-edit-compose-glyph.png"))); // NOI18N
        jButton1.setText("Edit");
        jButton1.setToolTipText("Update");
        jButton1.setPreferredSize(new java.awt.Dimension(40, 40));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton1);
        jButton1.setBounds(405, 220, 100, 40);

        btnStop.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/1468018013_black_4_audio_stop.png"))); // NOI18N
        btnStop.setText("Stop");
        btnStop.setToolTipText("Pause/Stop");
        btnStop.setPreferredSize(new java.awt.Dimension(40, 40));
        btnStop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStopActionPerformed(evt);
            }
        });
        jPanel3.add(btnStop);
        btnStop.setBounds(185, 220, 100, 40);

        btnStart.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/1468017997_icon-play.png"))); // NOI18N
        btnStart.setText("Start");
        btnStart.setToolTipText("Start");
        btnStart.setPreferredSize(new java.awt.Dimension(40, 40));
        btnStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStartActionPerformed(evt);
            }
        });
        jPanel3.add(btnStart);
        btnStart.setBounds(85, 220, 90, 40);

        jLabel1.setBackground(new java.awt.Color(0, 153, 100));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("LOG TIME");
        jPanel3.add(jLabel1);
        jLabel1.setBounds(190, 10, 180, 40);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 725, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 527, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 268, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnfinishTimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnfinishTimeActionPerformed
        // TODO add your handling code here:
        DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        Date date = new Date();
        txtFinishTime.setText(dateFormat.format(date));
    }//GEN-LAST:event_btnfinishTimeActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        Time t = new Time();
        LogTime_Bus ltb = new LogTime_Bus();
        int id = tb.GetIdCbo(cboTags.getSelectedItem().toString(), LogTimeMain.Username);
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");

            String start = txtStartTime.getText().trim();
            String finish = txtFinishTime.getText().trim();
            if (dcDate.getDate() == null) {
                JOptionPane.showMessageDialog(null, "Date isn't selected!");
            } else if (start.isEmpty()) {
                JOptionPane.showMessageDialog(null, "StartTime is null!");
            } else if (finish.isEmpty()) {
                JOptionPane.showMessageDialog(null, "FinishTime is null!");
            } else {
                String date = sdf.format(dcDate.getDate());
                String a1 = date + " " + start;
                Date parsedDate1 = dateFormat.parse(a1);
                Timestamp timestamp1 = new java.sql.Timestamp(parsedDate1.getTime());
                String a2 = date + " " + finish;
                Date parsedDate2 = dateFormat.parse(a2);
                Timestamp timestamp2 = new java.sql.Timestamp(parsedDate2.getTime());
                Long a = (parsedDate2.getTime() - parsedDate1.getTime()) / 1000;
                if (a <= 0) {
                    JOptionPane.showMessageDialog(null, "FinishTime can't equal or less than StartTime");
                } else {
                    t.setStartTime(timestamp1);
                    t.setFinishTime(timestamp2);
                    t.setEndUser(LogTimeMain.Username);
                    t.setDescription(txtDes.getText());
                    t.setTags(id);
                    t.setTimes(a);
                    t.setdateogTags(dcDate.getDate());
                    if (ltb.Create(t)) {
                        JOptionPane.showMessageDialog(null, "Successful!");
                        LoadTable();
                        Clear();
                    } else {
                        JOptionPane.showMessageDialog(null, "fail");
                    }
                }
            }
        } catch (ParseException ex) {
            Logger.getLogger(JFrameTime.class.getName()).log(Level.SEVERE, null, ex);
        }

        //JOptionPane.showMessageDialog(null, id);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void btnStarttimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStarttimeActionPerformed

        DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        Date date = new Date();
        txtStartTime.setText(dateFormat.format(date));
        txtFinishTime.setText(dateFormat.format(date));
    }//GEN-LAST:event_btnStarttimeActionPerformed

    private void btnStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStartActionPerformed
        // TODO add your handling code here:
        String start = txtStartTime.getText();
        String finish = txtFinishTime.getText();
        if (dcDate.getDate() == null) {
            JOptionPane.showMessageDialog(null, "Date isn't selected!");
        } else if (start.isEmpty()) {
            JOptionPane.showMessageDialog(null, "StartTime is null!");
        } else if (finish.isEmpty()) {
            JOptionPane.showMessageDialog(null, "FinishTime is null!");
        } else {
            timer.start();

        }
    }//GEN-LAST:event_btnStartActionPerformed
    void Clear() {
        txtFinishTime.setText("");
        txtStartTime.setText("");
        txtDes.setText("");

        lblHour.setText("00");
        lblMinute.setText("00");
        lblSecond.setText("00");
        LoadTag();

    }
    private void btnStopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStopActionPerformed
        // TODO add your handling code here:
        int id = tb.GetIdCbo(cboTags.getSelectedItem().toString(), LogTimeMain.Username);
        Time time = new Time();
        LogTime_Bus ltb = new LogTime_Bus();
        timer.stop();
//        Object[] options1 = {"Stop", "Continue"};
//        JPanel panel = new JPanel();
//        panel.add(new JLabel("Stop or Continue?"));
//        int result = JOptionPane.showOptionDialog(null, panel, "Notice",
//                JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE,
//                null, options1, null);
        int second = Integer.parseInt(lblSecond.getText()) + Integer.parseInt(lblMinute.getText()) * 60 + Integer.parseInt(lblHour.getText()) * 3600;
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        try {

            String start = txtStartTime.getText().trim();
            //String finish = txtFinishTime.getText().trim();
            String date = sdf.format(dcDate.getDate());
            String a1 = date + " " + start;
            Date parsedDate1 = dateFormat.parse(a1);
            Timestamp timestamp1 = new java.sql.Timestamp(parsedDate1.getTime());
//                String a2 = date + " " + finish;
//                Date parsedDate2 = dateFormat.parse(a2);
//                Timestamp timestamp2 = new java.sql.Timestamp(parsedDate2.getTime());
            // Date parsedDate1 = dateFormat.parse(txtStartTime.getText());
            // Timestamp timestamp1 = new java.sql.Timestamp(parsedDate1.getTime());
            Timestamp timestamp2 = new java.sql.Timestamp(parsedDate1.getTime() + second * 1000);
            txtFinishTime.setText(timestamp2.toString().substring(11));
            time.setFinishTime(timestamp2);
            time.setEndUser(LogTimeMain.Username);
            time.setDescription(txtDes.getText());
            time.setTags(id);
            time.setTimes(second);
            time.setStartTime(timestamp1);
            time.setdateogTags(dcDate.getDate());
            if (ltb.Create(time)) {
                JOptionPane.showMessageDialog(null, "Successful!");
                LoadTable();
                Clear();
            } else {
                JOptionPane.showMessageDialog(null, "fail");
            }
        } catch (ParseException ex) {
            Logger.getLogger(JFrameTime.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnStopActionPerformed

    private void tblTimesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTimesMouseClicked
        // TODO add your handling code here:
        int ID = Integer.parseInt(tblTimes.getValueAt(tblTimes.getSelectedRow(), 5).toString());
        Time t = ltb.find(ID);
        if (t != null) {
            dcDate.setDate(t.getdateogTags());
            txtStartTime.setText(t.getStartTime().toString().substring(11).replace("-", "/"));
            txtFinishTime.setText(t.getFinishTime().toString().substring(11).replace("-", "/"));
            txtDes.setText(t.getDescription());
            cboTags.getModel().setSelectedItem(tb.find(t.getTags()).getTagName());
        }
    }//GEN-LAST:event_tblTimesMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Time t = new Time();
        LogTime_Bus ltb = new LogTime_Bus();
        //Calendar cal = Calendar.getInstance();
        int id = tb.GetIdCbo(cboTags.getSelectedItem().toString(), LogTimeMain.Username);
        try {
            int ID = Integer.parseInt(tblTimes.getValueAt(tblTimes.getSelectedRow(), 5).toString());

            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            try {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");

                String start = txtStartTime.getText().trim();
                String finish = txtFinishTime.getText().trim();
                if (dcDate.getDate() == null) {
                    JOptionPane.showMessageDialog(null, "Date isn't selected!");
                } else if (start.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "StartTime is null!");
                } else if (finish.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "FinishTime is null!");
                } else {
                    String date = sdf.format(dcDate.getDate());
                    String a1 = date + " " + start;
                    Date parsedDate1 = dateFormat.parse(a1);
                    Timestamp timestamp1 = new java.sql.Timestamp(parsedDate1.getTime());
                    String a2 = date + " " + finish;
                    Date parsedDate2 = dateFormat.parse(a2);
                    Timestamp timestamp2 = new java.sql.Timestamp(parsedDate2.getTime());
                    Long a = (parsedDate2.getTime() - parsedDate1.getTime()) / 1000;
                    if (a <= 0) {
                        JOptionPane.showMessageDialog(null, "FinishTime can't equal or less than StartTime");
                    } else {
                        t.setStartTime(timestamp1);
                        t.setFinishTime(timestamp2);
                        t.setEndUser(LogTimeMain.Username);
                        t.setDescription(txtDes.getText());
                        t.setTags(id);
                        t.setTimes((parsedDate2.getTime() - parsedDate1.getTime()) / 1000);
                        t.setId(ID);
                        t.setdateogTags(dcDate.getDate());
                        if (ltb.Update(t)) {
                            JOptionPane.showMessageDialog(null, "Successful!");
                            LoadTable();
                            Clear();
                        } else {
                            JOptionPane.showMessageDialog(null, "fail");
                        }
                    }
                }
            } catch (ParseException ex) {
                Logger.getLogger(JFrameTime.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Time is not selected!");
        }
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnStart;
    private javax.swing.JButton btnStarttime;
    private javax.swing.JButton btnStop;
    private javax.swing.JButton btnfinishTime;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox cboTags;
    private com.toedter.calendar.JDateChooser dcDate;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblHour;
    private javax.swing.JLabel lblMinute;
    private javax.swing.JLabel lblSecond;
    private javax.swing.JTable tblTimes;
    private javax.swing.JTextArea txtDes;
    private javax.swing.JTextField txtFinishTime;
    private javax.swing.JTextField txtStartTime;
    // End of variables declaration//GEN-END:variables
}
