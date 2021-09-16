package com.thiendz.tool.autopadlet.view;

import com.thiendz.tool.autopadlet.model.Channel;
import com.thiendz.tool.autopadlet.model.Post;
import com.thiendz.tool.autopadlet.model.RespType;
import com.thiendz.tool.autopadlet.service.PadletChannelService;
import com.thiendz.tool.autopadlet.service.PadletCommentServiceImpl;
import com.thiendz.tool.autopadlet.service.PadletReactionServiceImpl;
import com.thiendz.tool.autopadlet.util.CounterComment;
import com.thiendz.tool.autopadlet.util.CounterReaction;
import com.thiendz.tool.autopadlet.util.MsgBox;
import com.thiendz.tool.autopadlet.util.RequestUtils;
import com.thiendz.tool.autopadlet.util.ThreadPool;
import com.thiendz.tool.autopadlet.util.Utils;

public class AutoPadletForm extends javax.swing.JFrame {

    public static AutoPadletForm autoPadletForm;

    public AutoPadletForm() {
        initComponents();
        init();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTabbedPane5 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        tfLink = new javax.swing.JTextField();
        btnGet = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        taNoti = new javax.swing.JTextArea();
        jLabel11 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        tfIdPost = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        tfCountReact = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        taNotiReaction = new javax.swing.JTextArea();
        btnAutoLike = new javax.swing.JButton();
        cbbThread = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        tfIdPostCmt = new javax.swing.JTextField();
        tfCountCmt = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        cbbThreadCmt = new javax.swing.JComboBox<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        taNotiCmt = new javax.swing.JTextArea();
        btnAutoComment = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        tfText = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("AutoPadlet - Code by PhamHuyThien");
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel1.setText("AutoPadlet");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("v1.0.0");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel3.setText("Code by PhamHuyThien");

        btnGet.setText("GET");
        btnGet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGetActionPerformed(evt);
            }
        });

        taNoti.setColumns(20);
        taNoti.setRows(5);
        jScrollPane1.setViewportView(taNoti);

        jLabel11.setText("URL CHANNEL:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfLink, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnGet, javax.swing.GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfLink, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGet)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnGet, tfLink});

        jTabbedPane5.addTab("HOME", jPanel1);

        jLabel4.setText("ID POST:");

        jLabel5.setText("REACTION COUNT:");

        tfCountReact.setText("10");

        jLabel6.setText("THREAD:");

        taNotiReaction.setColumns(20);
        taNotiReaction.setRows(5);
        jScrollPane2.setViewportView(taNotiReaction);

        btnAutoLike.setText("AUTO LIKE");
        btnAutoLike.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAutoLikeActionPerformed(evt);
            }
        });

        cbbThread.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "5", "10" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                        .addComponent(tfCountReact, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tfIdPost, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(btnAutoLike))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 368, Short.MAX_VALUE)
                            .addComponent(cbbThread, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(tfIdPost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(tfCountReact, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cbbThread, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnAutoLike)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnAutoLike, cbbThread, tfCountReact, tfIdPost});

        jTabbedPane5.addTab("AUTO LIKE", jPanel2);

        jLabel7.setText("ID POST:");

        tfCountCmt.setText("10");

        jLabel8.setText("COMMENT COUNT:");

        jLabel9.setText("THREAD:");

        cbbThreadCmt.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "5", "10" }));

        taNotiCmt.setColumns(20);
        taNotiCmt.setRows(5);
        jScrollPane3.setViewportView(taNotiCmt);

        btnAutoComment.setText("AUTO COMMENT");
        btnAutoComment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAutoCommentActionPerformed(evt);
            }
        });

        jLabel10.setText("TEXT:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(tfCountCmt, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(tfIdPostCmt, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel10))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnAutoComment)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 368, Short.MAX_VALUE)
                                .addComponent(cbbThreadCmt, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(tfText, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(tfIdPostCmt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(tfCountCmt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(cbbThreadCmt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(tfText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btnAutoComment)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnAutoComment, cbbThreadCmt, tfCountCmt, tfIdPostCmt, tfText});

        jTabbedPane5.addTab("AUTO COMMENT", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane5)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addGap(74, 74, 74)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane5)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGetActionPerformed
        buttonGetAction();
    }//GEN-LAST:event_btnGetActionPerformed

    private void btnAutoLikeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAutoLikeActionPerformed
        buttonAutoLikeAction();
    }//GEN-LAST:event_btnAutoLikeActionPerformed

    private void btnAutoCommentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAutoCommentActionPerformed
        buttonAutoCommentAction();
    }//GEN-LAST:event_btnAutoCommentActionPerformed

    private void buttonAutoCommentAction() {
        new Thread(() -> {
            long id = -1, countCmt = 1, countThread = 1;
            String text = null;
            try {
                id = Long.parseLong(tfIdPostCmt.getText());
            } catch (NumberFormatException e) {
                MsgBox.alert(this, "id wrong format.");
                return;
            }
            try {
                countCmt = Long.parseLong(tfCountCmt.getText());
            } catch (NumberFormatException e) {
                MsgBox.alert(this, "count reaction wrong format.");
                return;
            }
            try {
                countThread = Long.parseLong(cbbThreadCmt.getSelectedItem().toString());
            } catch (NumberFormatException e) {
                MsgBox.alert(this, "thread wrong format.");
                return;
            }
            CounterComment.reset();
            text = tfText.getText();
            btnAutoComment.setEnabled(false);
            taNotiCmt.setText("Loading...");
            Post post = new Post(id);
            PadletCommentServiceImpl[] padletCommentServiceImpls = new PadletCommentServiceImpl[(int) countCmt];
            String[] texts = text.split(";");
            for (int i = 0; i < countCmt; i++) {
                final String textRand = texts[Utils.RANDOM.nextInt(texts.length)];
                padletCommentServiceImpls[i] = new PadletCommentServiceImpl(post, textRand);
            }
            ThreadPool threadPool = new ThreadPool(padletCommentServiceImpls, (int) countThread);
            threadPool.execute();
            threadPool.await();
            btnAutoComment.setEnabled(true);
            MsgBox.alert(this, "Comment post id " + id + " done!");
        }).start();
    }

    private void buttonAutoLikeAction() {
        new Thread(() -> {
            long id = -1L, countReaction = 1L, countThread = 1L;
            try {
                id = Long.parseLong(tfIdPost.getText());
            } catch (NumberFormatException e) {
                MsgBox.alert(this, "id wrong format.");
                return;
            }
            try {
                countReaction = Long.parseLong(tfCountReact.getText());
            } catch (NumberFormatException e) {
                MsgBox.alert(this, "count reaction wrong format.");
                return;
            }
            try {
                countThread = Long.parseLong(cbbThread.getSelectedItem().toString());
            } catch (NumberFormatException e) {
                MsgBox.alert(this, "thread wrong format.");
                return;
            }
            CounterReaction.reset();
            btnAutoLike.setEnabled(false);
            taNotiReaction.setText("Loading...");
            Post post = new Post(id);
            PadletReactionServiceImpl[] padletReactionServiceImpls = new PadletReactionServiceImpl[(int) countReaction];
            for (int i = 0; i < countReaction; i++) {
                padletReactionServiceImpls[i] = new PadletReactionServiceImpl(post);
            }
            ThreadPool threadPool = new ThreadPool(padletReactionServiceImpls, (int) countThread);
            threadPool.execute();
            threadPool.await();
            btnAutoLike.setEnabled(true);
            MsgBox.alert(this, "Reaction post id " + id + " done!");
        }).start();
    }

    private void buttonGetAction() {
        String url = tfLink.getText();
        if (!RequestUtils.isUrl(url)) {
            MsgBox.alert(this, "URL wrong format.");
            return;
        }
        new Thread(() -> {
            btnGet.setEnabled(false);
            taNoti.setText("Loading...");
            RespType<Channel> respTypeChannel = PadletChannelService.get(url);
            if (respTypeChannel.getCode() < 0) {
                btnGet.setEnabled(true);
                taNoti.setText(respTypeChannel.getMessage());
                MsgBox.alert(this, respTypeChannel.getMessage());
                return;
            }
            StringBuilder noti = new StringBuilder();
            respTypeChannel.getData().getItems().forEach((item) -> {
                noti.append("============== ID ").append(item.getId()).append(" ==============\n")
                        .append("Title: ").append(item.getTitle()).append("\n")
                        .append("Desc: ").append(item.getDesc()).append("\n")
                        .append("Img: ").append(item.getImg()).append("\n")
                        .append("Date: ").append(item.getDate()).append("\n");
            });
            taNoti.setText(noti.toString());
            btnGet.setEnabled(true);
        }).start();
    }

    private void init() {
        taNoti.setText(
                "===============================================\n\n"
                + "Tool Name: AutoPadlet\n\n"
                + "Version: v1.0.0\n\n"
                + "Author: Pham Huy Thien (SystemError)\n\n"
                + "Contact: https://fb.com/ThienDz.SystemError\n\n"
                + "==============================================="
        );
    }

    public synchronized void appendNotiReaction(RespType<?> respTypeReaction) {
        CounterReaction.inc();
        int index = CounterReaction.get();
        String text = "> Account Clone #" + index + " => " + respTypeReaction.getMessage();
        String textOld = taNotiReaction.getText();
        taNotiReaction.setText(text + "\n" + textOld);
    }

    public synchronized void appendNotiComment(RespType<?> ReactTypeComment) {
        CounterComment.inc();
        int index = CounterComment.get();
        String text = "> Account Clone #" + index + " => " + ReactTypeComment.getMessage();
        String textOld = taNotiCmt.getText();
        taNotiCmt.setText(text + "\n" + textOld);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAutoComment;
    private javax.swing.JButton btnAutoLike;
    private javax.swing.JButton btnGet;
    private javax.swing.JComboBox<String> cbbThread;
    private javax.swing.JComboBox<String> cbbThreadCmt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane5;
    private javax.swing.JTextArea taNoti;
    private javax.swing.JTextArea taNotiCmt;
    private javax.swing.JTextArea taNotiReaction;
    private javax.swing.JTextField tfCountCmt;
    private javax.swing.JTextField tfCountReact;
    private javax.swing.JTextField tfIdPost;
    private javax.swing.JTextField tfIdPostCmt;
    private javax.swing.JTextField tfLink;
    private javax.swing.JTextField tfText;
    // End of variables declaration//GEN-END:variables
}
