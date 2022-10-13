/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package client;

import remote.IRemoteBoard;
import remote.IRemoteClient;

import javax.swing.*;
import java.awt.*;
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
        this.name = "";
        this.isManager = false;
    }

    public static void main(String[] args) {


        try{
            // find remote interface
            Registry registry = LocateRegistry.getRegistry(4321);
            IRemoteBoard remoteBoard = (IRemoteBoard) registry.lookup("WhiteBoard");

            // ask for client name
            IRemoteClient remoteClient = new ClientServant();
            String name = JOptionPane.showInputDialog("What is your name?");

            //check empty name
            if(name.equals("")){
                JOptionPane.showMessageDialog(null,"Can't use empty name!", "Warning!", JOptionPane.WARNING_MESSAGE);
                System.exit(0);
            }else{
                // check identical name
                if(remoteBoard.checkName(name)){
                    JOptionPane.showMessageDialog(null,"Can't use identical name!", "Warning!", JOptionPane.WARNING_MESSAGE);
                    System.exit(0);
                }else{
                    // create board and check if client is a manager
                    if(remoteBoard.isEmpty()){
                        createBoard(remoteBoard, name+"(manager)");
                    }else {
                        createBoard(remoteBoard, name);
                    }

                    // add client to the server list
                    remoteBoard.joinBoard(remoteClient, name);
                }

            }
        } catch (AccessException e) {
            JOptionPane.showMessageDialog(null,"Access denied", "Warning!", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
            System.exit(0);
        } catch (NotBoundException e) {
            JOptionPane.showMessageDialog(null,"The port already in use or port number is incorrect",  "Warning!", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
            System.exit(0);
        } catch (RemoteException e) {
            JOptionPane.showMessageDialog(null,"lost connection to RMI",  "Warning!", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
            System.exit(0);
        } catch (NullPointerException e){
            JOptionPane.showMessageDialog(null,"some variables are null",  "Warning!", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
            System.exit(0);
        }

    }


    public static void createBoard(IRemoteBoard remoteBoard, String name){
        /* Create and display the form */
        board = new BoardClient(remoteBoard, name);
        board.setVisible(true);
        board.setSize(500,500);
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
        System.out.println(clientList.size());
    }

    @Override
    public byte[] getCurrentBoard() throws RemoteException {
        return new byte[0];
    }

    @Override
    public void clearBoard() throws RemoteException {

    }

    @Override
    public void updateOpenBoard(byte[] boardState) throws RemoteException {

    }

    @Override
    public void closeBoard() throws RemoteException {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                JOptionPane.showMessageDialog(null,"Sorry, you are not allowed tn enter",  "Access denied!", JOptionPane.ERROR_MESSAGE);
                board.dispose();
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
    public void draw(String mode, Point start, Point end, Color color) throws RemoteException {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(name);
                Graphics g = board.getBoardPanel().getGraphics();
                board.remoteDraw(g, mode, start, end, color);
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
}
