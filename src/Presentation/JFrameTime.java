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
    Timer t;
    Tags_Bus tb = new Tags_Bus();
    LogTime_Bus ltb = new LogTime_Bus();

    int s = 0;
    int m = 0;
    int h = 0;
    int d = 0;

    public JFrameTime() {
        initComponents();
        LoadTag();
        LoadTable();
        t = new Timer(300, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                d = d + 1;
                if (d % 2 == 0) {
                    lblDoing.setVisible(true);
                } else {
                    lblDoing.setVisible(false);
                }
            }
        });
        timer = new Timer(1000, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
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
                    panel.add(new JLabel("Tag is overtime. Do you want Save?"));
                    int result = JOptionPane.showOptionDialog(null, panel, "Enter a Number",
                            JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE,
                            null, options1, null);
                    if (result == JOptionPane.YES_OPTION) {
                        Time time = new Time();
                        LogTime_Bus ltb = new LogTime_Bus();
                        int id = tb.GetIdCbo(cboTags.getSelectedItem().toString(), LogTimeMain.Username);
                        int second = Integer.parseInt(lblSecond.getText()) + Integer.parseInt(lblMinute.getText()) * 60 + Integer.parseInt(lblHour.getText()) * 3600;
                        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                        try {

                            Date parsedDate1 = dateFormat.parse(txtStartTime.getText());
                            Timestamp timestamp1 = new java.sql.Timestamp(parsedDate1.getTime());
                            Timestamp timestamp2 = new java.sql.Timestamp(parsedDate1.getTime() + second * 1000);
                            txtFinishTime.setText(timestamp2.toString());
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
        dt.addColumn("Id");
        dt.addColumn("StartTime");
        dt.addColumn("FinishTime");
        dt.addColumn("Tags");
        for (Time t : ltb.findall(LogTimeMain.Username)) {
            dt.addRow(new Object[]{t.getId(), sdf.format(t.getStartTime()), sdf.format(t.getFinishTime()), tb.find(t.getTags()).getTagName()});
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

        jScrollPane1 = new javax.swing.JScrollPane();
        tblTimes = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        lblMinute = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lblSecond = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        lblHour = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lblDoing = new javax.swing.JLabel();
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
        jPanel5 = new javax.swing.JPanel();
        jButton5 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        btnStart = new javax.swing.JButton();
        btnStop = new javax.swing.JButton();

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

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));
        jPanel1.setPreferredSize(new java.awt.Dimension(180, 180));

        lblMinute.setFont(new java.awt.Font("Tahoma", 1, 35)); // NOI18N
        lblMinute.setForeground(new java.awt.Color(255, 255, 255));
        lblMinute.setText("00");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Total Hours:");

        lblSecond.setFont(new java.awt.Font("Tahoma", 1, 35)); // NOI18N
        lblSecond.setForeground(new java.awt.Color(255, 255, 255));
        lblSecond.setText("00");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText(":");

        lblHour.setFont(new java.awt.Font("Tahoma", 1, 35)); // NOI18N
        lblHour.setForeground(new java.awt.Color(255, 255, 255));
        lblHour.setText("00");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText(":");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(jLabel8)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(lblHour)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addComponent(lblMinute)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblSecond))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel8)
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMinute)
                    .addComponent(lblSecond)
                    .addComponent(jLabel10)
                    .addComponent(lblHour)
                    .addComponent(jLabel11))
                .addContainerGap(58, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(0, 153, 153));
        jPanel2.setPreferredSize(new java.awt.Dimension(180, 180));

        lblDoing.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        lblDoing.setForeground(new java.awt.Color(255, 255, 255));
        lblDoing.setText("Doing");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(38, Short.MAX_VALUE)
                .addComponent(lblDoing)
                .addGap(36, 36, 36))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addComponent(lblDoing)
                .addContainerGap(71, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(0, 153, 153));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel3.setPreferredSize(new java.awt.Dimension(180, 180));
        jPanel3.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Start Time:");
        jPanel3.add(jLabel2);
        jLabel2.setBounds(10, 20, 80, 30);
        jPanel3.add(txtStartTime);
        txtStartTime.setBounds(90, 20, 200, 20);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("End Time:");
        jPanel3.add(jLabel3);
        jLabel3.setBounds(20, 60, 60, 20);
        jPanel3.add(txtFinishTime);
        txtFinishTime.setBounds(90, 60, 200, 20);

        btnfinishTime.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/1463741518_access-time.png"))); // NOI18N
        btnfinishTime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnfinishTimeActionPerformed(evt);
            }
        });
        jPanel3.add(btnfinishTime);
        btnfinishTime.setBounds(305, 60, 25, 25);

        btnStarttime.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/1463741518_access-time.png"))); // NOI18N
        btnStarttime.setToolTipText("Get Time now.");
        btnStarttime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStarttimeActionPerformed(evt);
            }
        });
        jPanel3.add(btnStarttime);
        btnStarttime.setBounds(305, 20, 25, 25);

        txtDes.setColumns(20);
        txtDes.setRows(5);
        jScrollPane2.setViewportView(txtDes);

        jPanel3.add(jScrollPane2);
        jScrollPane2.setBounds(90, 140, 240, 84);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Description:");
        jPanel3.add(jLabel4);
        jLabel4.setBounds(10, 150, 70, 15);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Tags:");
        jPanel3.add(jLabel5);
        jLabel5.setBounds(40, 100, 50, 20);

        cboTags.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cboTags.setPreferredSize(new java.awt.Dimension(56, 24));
        jPanel3.add(cboTags);
        cboTags.setBounds(90, 100, 240, 24);

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Have End Time"));
        jPanel5.setForeground(new java.awt.Color(0, 153, 153));
        jPanel5.setToolTipText("");

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/1467295273_Add.png"))); // NOI18N
        jButton5.setToolTipText("Add");
        jButton5.setPreferredSize(new java.awt.Dimension(40, 40));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/1467295555_refresh.png"))); // NOI18N
        jButton1.setToolTipText("Update");
        jButton1.setPreferredSize(new java.awt.Dimension(40, 40));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel3.add(jPanel5);
        jPanel5.setBounds(350, 143, 140, 80);

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("No End Time"));
        jPanel6.setForeground(new java.awt.Color(0, 153, 153));
        jPanel6.setToolTipText("");

        btnStart.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/1467295156_Play.png"))); // NOI18N
        btnStart.setToolTipText("Start");
        btnStart.setPreferredSize(new java.awt.Dimension(40, 40));
        btnStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStartActionPerformed(evt);
            }
        });

        btnStop.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/1467295422_Pause.png"))); // NOI18N
        btnStop.setToolTipText("Pause/Stop");
        btnStop.setPreferredSize(new java.awt.Dimension(40, 40));
        btnStop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStopActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnStart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(btnStop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnStart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnStop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.add(jPanel6);
        jPanel6.setBounds(350, 44, 140, 80);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 527, Short.MAX_VALUE))
                .addGap(18, 18, 18))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnfinishTimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnfinishTimeActionPerformed
        // TODO add your handling code here:
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        txtFinishTime.setText(dateFormat.format(date));
    }//GEN-LAST:event_btnfinishTimeActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        Time t = new Time();
        LogTime_Bus ltb = new LogTime_Bus();
        //Calendar cal = Calendar.getInstance();
        int id = tb.GetIdCbo(cboTags.getSelectedItem().toString(), LogTimeMain.Username);
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        try {
            String start = txtStartTime.getText();
            String finish = txtFinishTime.getText();
            if (start.isEmpty()) {
                JOptionPane.showMessageDialog(null, "StartTime is null!");
            } else if (finish.isEmpty()) {
                JOptionPane.showMessageDialog(null, "FinishTime is null!");
            } else {
                Date parsedDate1 = dateFormat.parse(start);
                Timestamp timestamp1 = new java.sql.Timestamp(parsedDate1.getTime());
                Date parsedDate2 = dateFormat.parse(finish);
                Timestamp timestamp2 = new java.sql.Timestamp(parsedDate2.getTime());
                t.setStartTime(timestamp1);
                t.setFinishTime(timestamp2);
                t.setEndUser(LogTimeMain.Username);
                t.setDescription(txtDes.getText());
                t.setTags(id);
                t.setTimes((parsedDate2.getTime() - parsedDate1.getTime()) / 1000);
                if (ltb.Create(t)) {
                    JOptionPane.showMessageDialog(null, "Successful!");
                    LoadTable();
                    Clear();
                } else {
                    JOptionPane.showMessageDialog(null, "fail");
                }
            }
        } catch (ParseException ex) {
            Logger.getLogger(JFrameTime.class.getName()).log(Level.SEVERE, null, ex);
        }

        //JOptionPane.showMessageDialog(null, id);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void btnStarttimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStarttimeActionPerformed

        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        txtStartTime.setText(dateFormat.format(date));
        txtFinishTime.setText(dateFormat.format(date));
    }//GEN-LAST:event_btnStarttimeActionPerformed

    private void btnStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStartActionPerformed
        // TODO add your handling code here:
        String start = txtStartTime.getText();
        String finish = txtFinishTime.getText();
        if (start.isEmpty()) {
            JOptionPane.showMessageDialog(null, "StartTime is null!");
        } else if (finish.isEmpty()) {
            JOptionPane.showMessageDialog(null, "FinishTime is null!");
        } else {
            timer.start();
            t.start();
        }
    }//GEN-LAST:event_btnStartActionPerformed
    void Clear() {
        txtFinishTime.setText("");
        txtStartTime.setText("");
        txtDes.setText("");
        lblDoing.setText("Doing");
        lblDoing.setForeground(Color.white);
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
        t.stop();
        lblDoing.setText("Done");
        lblDoing.setVisible(true);
        lblDoing.setForeground(Color.orange);
        Object[] options1 = {"Stop", "Continue"};
        JPanel panel = new JPanel();
        panel.add(new JLabel("Stop or Continue?"));
        int result = JOptionPane.showOptionDialog(null, panel, "Notice",
                JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE,
                null, options1, null);
        if (result == JOptionPane.YES_OPTION) {

            int second = Integer.parseInt(lblSecond.getText()) + Integer.parseInt(lblMinute.getText()) * 60 + Integer.parseInt(lblHour.getText()) * 3600;
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            try {

                Date parsedDate1 = dateFormat.parse(txtStartTime.getText());
                Timestamp timestamp1 = new java.sql.Timestamp(parsedDate1.getTime());
                Timestamp timestamp2 = new java.sql.Timestamp(parsedDate1.getTime() + second * 1000);
                txtFinishTime.setText(timestamp2.toString());
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
            } catch (ParseException ex) {
                Logger.getLogger(JFrameTime.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            t.start();
            timer.start();
            lblDoing.setText("Doing");
            lblDoing.setForeground(Color.white);
        }


    }//GEN-LAST:event_btnStopActionPerformed

    private void tblTimesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTimesMouseClicked
        // TODO add your handling code here:
        int ID = Integer.parseInt(tblTimes.getValueAt(tblTimes.getSelectedRow(), 0).toString());
        Time t = ltb.find(ID);
        if (t != null) {
            txtStartTime.setText(t.getStartTime().toString().replace("-", "/"));
            txtFinishTime.setText(t.getFinishTime().toString().replace("-", "/"));
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
            int ID = Integer.parseInt(tblTimes.getValueAt(tblTimes.getSelectedRow(), 0).toString());

            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            try {
                Date parsedDate1 = dateFormat.parse(txtStartTime.getText());
                Timestamp timestamp1 = new java.sql.Timestamp(parsedDate1.getTime());
                Date parsedDate2 = dateFormat.parse(txtFinishTime.getText());
                Timestamp timestamp2 = new java.sql.Timestamp(parsedDate2.getTime());
                t.setStartTime(timestamp1);
                t.setFinishTime(timestamp2);
                t.setEndUser(LogTimeMain.Username);
                t.setDescription(txtDes.getText());
                t.setTags(id);
                t.setTimes((parsedDate2.getTime() - parsedDate1.getTime()) / 1000);
                t.setId(ID);
                if (ltb.Update(t)) {
                    JOptionPane.showMessageDialog(null, "Successful!");
                    LoadTable();
                    Clear();
                } else {
                    JOptionPane.showMessageDialog(null, "fail");
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
    private javax.swing.JComboBox cboTags;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblDoing;
    private javax.swing.JLabel lblHour;
    private javax.swing.JLabel lblMinute;
    private javax.swing.JLabel lblSecond;
    private javax.swing.JTable tblTimes;
    private javax.swing.JTextArea txtDes;
    private javax.swing.JTextField txtFinishTime;
    private javax.swing.JTextField txtStartTime;
    // End of variables declaration//GEN-END:variables
}
