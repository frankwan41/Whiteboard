/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package client;

/**
 *
 * @author ycw
 */
public class ClientServant {

    private static BoardClient board;
    
    public static void main(String[] args) {

        /* Create and display the form */
        board = new BoardClient();
        board.setVisible(true);
        board.setSize(500,500);
        
    }

    
}
