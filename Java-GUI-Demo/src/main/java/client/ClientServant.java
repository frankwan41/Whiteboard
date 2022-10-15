/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package client;

import remote.IRemoteBoard;
import remote.IRemoteClient;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.rmi.AccessException;
import java.rmi.ConnectException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

/**
 *
 * @author ycw
 */
public class ClientServant extends UnicastRemoteObject implements IRemoteClient {

    private static BoardClient board;
    private String name;
    private boolean isManager;
    private ArrayList<String> clientList;

    public ClientServant() throws RemoteException, NullPointerException {

    }

    public void createBoard(IRemoteBoard remoteBoard, String name, boolean isManager){
        /* Create and display the form */
        board = new BoardClient(remoteBoard, name, isManager);
        board.setVisible(true);
        board.setSize(700,500);
    }

    /**
     * set client name
     * @param name name of the client
     * @throws RemoteException
     */
    @Override
    public void setClient(String name) throws RemoteException {
        this.name = name;
    }

    /**
     * get client name
     * @return
     * @throws RemoteException
     */
    @Override
    public String getName() throws RemoteException {
        return this.name;
    }

    /**
     * set manager role
     * @param name set manager name
     * @throws RemoteException
     */
    @Override
    public void setManager(String name) throws RemoteException {
        this.isManager = true;
        this.name = name;
    }

    /**
     * ask if other client can join
     * @param name client name who wants to join
     * @return true if access is granted
     * @throws RemoteException
     */
    @Override
    public boolean askJoin(String name) throws RemoteException {
        String message = name + " client wants to join";
        int result = JOptionPane.showConfirmDialog(null, message, "Message", JOptionPane.YES_NO_OPTION);
        if(result == 0){
            return true;
        }
        return false;
    }

    /**
     * update client list when client joins or quits
     * @param clients list of current clients
     * @throws RemoteException
     */
    @Override
    public void updateClientList(ArrayList<String> clients) throws RemoteException {
        clientList = clients;
        board.updateList(clients);
    }

    @Override
    public byte[] getCurrentBoard() throws IOException {
        return board.getCurrentBoard();
    }

    @Override
    public void clearBoard() throws RemoteException {
        board.resetBoard();
    }

    @Override
    public void updateOpenBoard(byte[] bytes) throws IOException {
        board.updateBoard(bytes);
    }

    @Override
    public void closeBoard(boolean access) throws RemoteException {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                if (!isManager) {
                    if (access) {
                        JOptionPane.showMessageDialog(null, "Sorry, you are kicked " +
                                "out by the manager or the manager left the room", "Access denied!", JOptionPane.ERROR_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "Sorry, you are not allowed to enter", "Access denied!", JOptionPane.ERROR_MESSAGE);
                    }
                }
                System.exit(0);
            }
        });
        t.start();

    }

    /**
     * check if this client is a manager
     * @return true if manager
     * @throws RemoteException
     */
    @Override
    public boolean isManager() throws RemoteException {
        return this.isManager;
    }

    /**
     * remote server asks client to draw different shapes
     * @param mode shapes
     * @param start start point
     * @param end end point
     * @throws RemoteException
     */
    @Override
    public void draw(String mode, Point start, Point end, Color color, String text) throws RemoteException {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(name);
                board.remoteDraw(mode, start, end, color, text);
            }
        });
        t.start();
    }

    /**
     * synchronize previous chat when connect to the server
     * @param messages a list of messages
     */
    public void synMessages(ArrayList<String> messages){
        board.updateChat(messages);
    }

    /**
     * add one message
     * @param text message that we need to add
     * @throws RemoteException
     */
    @Override
    public void addMessage(String text) throws RemoteException {
        board.addMessage(text);
    }

    /**
     * notify every client a client is kicked out
     * @param text message
     * @throws RemoteException
     */
    @Override
    public void notification(String text) {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                board.notification(text);
            }
        });
        t.start();

    }
}
