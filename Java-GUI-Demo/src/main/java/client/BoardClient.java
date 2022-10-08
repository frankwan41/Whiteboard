/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package client;

import javax.swing.*;
import java.awt.Color;

/**
 *
 * @author ycw
 */
public class BoardClient extends javax.swing.JFrame {
    

    /**
     * Creates new form BoardClient
     */
    public BoardClient() {
        initComponents();
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
        boardPanel = new javax.swing.JPanel();
        drawLabel = new javax.swing.JLabel();
        inputPanel = new javax.swing.JScrollPane();
        inputArea = new javax.swing.JTextArea();
        sendButton = new javax.swing.JButton();
        clearButton = new javax.swing.JButton();
        listPanel = new javax.swing.JPanel();
        userListLabel = new javax.swing.JLabel();
        userListPanel = new javax.swing.JScrollPane();
        userList = new javax.swing.JList<>();
        chatPanel = new javax.swing.JPanel();
        chatLabel = new javax.swing.JLabel();
        chatBoxPanel = new javax.swing.JScrollPane();
        chatList = new javax.swing.JList<>();
        menuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        newBoard = new javax.swing.JMenuItem();
        fileSave = new javax.swing.JMenuItem();
        fileSaveAs = new javax.swing.JMenuItem();
        fileClose = new javax.swing.JMenuItem();
        shapeMenu = new javax.swing.JMenu();
        drawLine = new javax.swing.JRadioButtonMenuItem();
        drawRect = new javax.swing.JRadioButtonMenuItem();
        drawTri = new javax.swing.JRadioButtonMenuItem();
        drawCir = new javax.swing.JRadioButtonMenuItem();
        colorMenu = new javax.swing.JMenu();
        textMenu = new javax.swing.JMenu();
        drawingMenu = new javax.swing.JMenu();
        cursorMenu = new javax.swing.JMenu();
        currentTool = new javax.swing.JMenu();
        currentColor = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        boardPanel.setBackground(new java.awt.Color(255, 255, 255));

        drawLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        drawLabel.setText("Drawing Section");

        javax.swing.GroupLayout boardPanelLayout = new javax.swing.GroupLayout(boardPanel);
        boardPanel.setLayout(boardPanelLayout);
        boardPanelLayout.setHorizontalGroup(
            boardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(boardPanelLayout.createSequentialGroup()
                .addComponent(drawLabel)
                .addGap(0, 339, Short.MAX_VALUE))
        );
        boardPanelLayout.setVerticalGroup(
            boardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(boardPanelLayout.createSequentialGroup()
                .addComponent(drawLabel)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        inputPanel.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        inputPanel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        inputArea.setColumns(20);
        inputArea.setLineWrap(true);
        inputArea.setRows(5);
        inputArea.setText("sdfa ijdj ajid ijs ifjaijfij jid fjai fij djalf jad jkfjaijdij kfjijf ad kfiakdj ifka jid akfj ij idkasj da d\n\n\n\nd\nas\nf\ns\nd\na\nf\n");
        inputPanel.setViewportView(inputArea);

        sendButton.setText("Send");

        clearButton.setText("Clear");
        clearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButtonActionPerformed(evt);
            }
        });

        userListLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        userListLabel.setText("Participants");
        userListLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        userList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        userListPanel.setViewportView(userList);

        javax.swing.GroupLayout listPanelLayout = new javax.swing.GroupLayout(listPanel);
        listPanel.setLayout(listPanelLayout);
        listPanelLayout.setHorizontalGroup(
            listPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(userListPanel)
            .addGroup(listPanelLayout.createSequentialGroup()
                .addComponent(userListLabel)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        listPanelLayout.setVerticalGroup(
            listPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(listPanelLayout.createSequentialGroup()
                .addComponent(userListLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(userListPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE)
                .addContainerGap())
        );

        chatLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        chatLabel.setText("Chat");
        chatLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        chatList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        chatBoxPanel.setViewportView(chatList);

        javax.swing.GroupLayout chatPanelLayout = new javax.swing.GroupLayout(chatPanel);
        chatPanel.setLayout(chatPanelLayout);
        chatPanelLayout.setHorizontalGroup(
            chatPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(chatBoxPanel)
            .addGroup(chatPanelLayout.createSequentialGroup()
                .addComponent(chatLabel)
                .addGap(0, 147, Short.MAX_VALUE))
        );
        chatPanelLayout.setVerticalGroup(
            chatPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(chatPanelLayout.createSequentialGroup()
                .addComponent(chatLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chatBoxPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
                .addContainerGap())
        );

        menuBar.setMaximumSize(new java.awt.Dimension(200, 30));
        menuBar.setMinimumSize(new java.awt.Dimension(20, 20));
        menuBar.setPreferredSize(new java.awt.Dimension(300, 27));

        fileMenu.setIcon(new javax.swing.ImageIcon("/Users/ycw/Desktop/distributed system/Project2/Whiteboard/Java-GUI-Demo/src/main/java/icon/folder.png")); // NOI18N
        fileMenu.setText("File");

        newBoard.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        newBoard.setIcon(new javax.swing.ImageIcon("/Users/ycw/Desktop/distributed system/Project2/Whiteboard/Java-GUI-Demo/src/main/java/icon/newboard.png")); // NOI18N
        newBoard.setText("New Board");
        newBoard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newBoardActionPerformed(evt);
            }
        });
        fileMenu.add(newBoard);

        fileSave.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        fileSave.setIcon(new javax.swing.ImageIcon("/Users/ycw/Desktop/distributed system/Project2/Whiteboard/Java-GUI-Demo/src/main/java/icon/save.png")); // NOI18N
        fileSave.setText("Save");
        fileSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fileSaveActionPerformed(evt);
            }
        });
        fileMenu.add(fileSave);

        fileSaveAs.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        fileSaveAs.setIcon(new javax.swing.ImageIcon("/Users/ycw/Desktop/distributed system/Project2/Whiteboard/Java-GUI-Demo/src/main/java/icon/saveas.png")); // NOI18N
        fileSaveAs.setText("Save As");
        fileSaveAs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fileSaveAsActionPerformed(evt);
            }
        });
        fileMenu.add(fileSaveAs);

        fileClose.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        fileClose.setIcon(new javax.swing.ImageIcon("/Users/ycw/Desktop/distributed system/Project2/Whiteboard/Java-GUI-Demo/src/main/java/icon/close.png")); // NOI18N
        fileClose.setText("Close Board");
        fileClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fileCloseActionPerformed(evt);
            }
        });
        fileMenu.add(fileClose);

        menuBar.add(fileMenu);

        shapeMenu.setIcon(new javax.swing.ImageIcon("/Users/ycw/Desktop/distributed system/Project2/Whiteboard/Java-GUI-Demo/src/main/java/icon/shape.png")); // NOI18N
        shapeMenu.setText("Shape");
        shapeMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                shapeMenuMouseClicked(evt);
            }
        });

        drawLine.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        buttonGroup1.add(drawLine);
        drawLine.setText("Line");
        drawLine.setIcon(new javax.swing.ImageIcon("/Users/ycw/Desktop/distributed system/Project2/Whiteboard/Java-GUI-Demo/src/main/java/icon/line.png")); // NOI18N
        drawLine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                drawLineActionPerformed(evt);
            }
        });
        shapeMenu.add(drawLine);

        drawRect.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        buttonGroup1.add(drawRect);
        drawRect.setText("Rectangle");
        drawRect.setIcon(new javax.swing.ImageIcon("/Users/ycw/Desktop/distributed system/Project2/Whiteboard/Java-GUI-Demo/src/main/java/icon/rectangle.png")); // NOI18N
        shapeMenu.add(drawRect);

        drawTri.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_T, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        buttonGroup1.add(drawTri);
        drawTri.setText("Triangle");
        drawTri.setIcon(new javax.swing.ImageIcon("/Users/ycw/Desktop/distributed system/Project2/Whiteboard/Java-GUI-Demo/src/main/java/icon/triangle.png")); // NOI18N
        shapeMenu.add(drawTri);

        drawCir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        buttonGroup1.add(drawCir);
        drawCir.setText("Circle");
        drawCir.setIcon(new javax.swing.ImageIcon("/Users/ycw/Desktop/distributed system/Project2/Whiteboard/Java-GUI-Demo/src/main/java/icon/circle.png")); // NOI18N
        drawCir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                drawCirActionPerformed(evt);
            }
        });
        shapeMenu.add(drawCir);

        menuBar.add(shapeMenu);

        colorMenu.setIcon(new javax.swing.ImageIcon("/Users/ycw/Desktop/distributed system/Project2/Whiteboard/Java-GUI-Demo/src/main/java/icon/color.png")); // NOI18N
        colorMenu.setText("Color");
        menuBar.add(colorMenu);

        textMenu.setIcon(new javax.swing.ImageIcon("/Users/ycw/Desktop/distributed system/Project2/Whiteboard/Java-GUI-Demo/src/main/java/icon/text.png")); // NOI18N
        textMenu.setText("Text");
        menuBar.add(textMenu);

        drawingMenu.setIcon(new javax.swing.ImageIcon("/Users/ycw/Desktop/distributed system/Project2/Whiteboard/Java-GUI-Demo/src/main/java/icon/freedraw.png")); // NOI18N
        menuBar.add(drawingMenu);

        cursorMenu.setIcon(new javax.swing.ImageIcon("/Users/ycw/Desktop/distributed system/Project2/Whiteboard/Java-GUI-Demo/src/main/java/icon/cursor.png")); // NOI18N
        menuBar.add(cursorMenu);

        currentTool.setBackground(java.awt.Color.lightGray);
        currentTool.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        currentTool.setIcon(new javax.swing.ImageIcon("/Users/ycw/Desktop/distributed system/Project2/Whiteboard/Java-GUI-Demo/src/main/java/icon/cursor.png")); // NOI18N
        currentTool.setOpaque(true);
        menuBar.add(currentTool);

        currentColor.setBackground(java.awt.Color.lightGray);
        currentColor.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        currentColor.setText("current color");
        currentColor.setOpaque(true);
        menuBar.add(currentColor);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(boardPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(sendButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(clearButton)
                        .addGap(27, 27, 27))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(inputPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(listPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(chatPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(4, 4, 4))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(boardPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addComponent(listPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chatPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(inputPanel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sendButton)
                    .addComponent(clearButton)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void fileSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fileSaveActionPerformed
        // TODO add your handling code here:
    
    }//GEN-LAST:event_fileSaveActionPerformed

    private void fileSaveAsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fileSaveAsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fileSaveAsActionPerformed

    private void fileCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fileCloseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fileCloseActionPerformed

    private void newBoardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newBoardActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_newBoardActionPerformed

    private void shapeMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_shapeMenuMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_shapeMenuMouseClicked

    private void drawLineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_drawLineActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_drawLineActionPerformed

    private void drawCirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_drawCirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_drawCirActionPerformed

    private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_clearButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel boardPanel;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JScrollPane chatBoxPanel;
    private javax.swing.JLabel chatLabel;
    private javax.swing.JList<String> chatList;
    private javax.swing.JPanel chatPanel;
    private javax.swing.JButton clearButton;
    private javax.swing.JMenu colorMenu;
    private javax.swing.JMenu currentColor;
    private javax.swing.JMenu currentTool;
    private javax.swing.JMenu cursorMenu;
    private javax.swing.JRadioButtonMenuItem drawCir;
    private javax.swing.JLabel drawLabel;
    private javax.swing.JRadioButtonMenuItem drawLine;
    private javax.swing.JRadioButtonMenuItem drawRect;
    private javax.swing.JRadioButtonMenuItem drawTri;
    private javax.swing.JMenu drawingMenu;
    private javax.swing.JMenuItem fileClose;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JMenuItem fileSave;
    private javax.swing.JMenuItem fileSaveAs;
    private javax.swing.JTextArea inputArea;
    private javax.swing.JScrollPane inputPanel;
    private javax.swing.JPanel listPanel;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem newBoard;
    private javax.swing.JButton sendButton;
    private javax.swing.JMenu shapeMenu;
    private javax.swing.JMenu textMenu;
    private javax.swing.JList<String> userList;
    private javax.swing.JLabel userListLabel;
    private javax.swing.JScrollPane userListPanel;
    // End of variables declaration//GEN-END:variables
}
