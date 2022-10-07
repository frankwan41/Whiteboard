package client;

import javax.swing.*;
import java.awt.*;

public class BoardClient extends JFrame{
    private JPanel mainPanel;
    private JPanel boardPanel;
    private JScrollPane clientList;
    private JScrollPane textPanel;
    private JMenuBar menuBar;
    private JMenu textMenu;
    private JMenu fileMenu;
    private JMenu shapeMenu;
    private JMenu colorMenu;
    private JMenuItem newBoard;
    private JMenuItem fileOpen;
    private JMenuItem fileSave;
    private JMenuItem fileSaveAs;
    private JMenuItem fileClose;
    private JMenuItem drawLine;
    private JMenuItem drawRect;
    private JMenuItem drawTri;
    private JMenuItem drawCir;


    public BoardClient(String appName){
        super(appName);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.pack();


    }

    public static void main(String[] args) {
        JFrame frame = new BoardClient("white board");
        frame.setVisible(true);
        frame.setSize(700,700);
    }
}
