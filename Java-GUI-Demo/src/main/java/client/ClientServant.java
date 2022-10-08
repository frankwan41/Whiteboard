/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package client;

import remote.IRemoteBoard;
import remote.IRemoteClient;

import javax.swing.*;
import java.rmi.AccessException;
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
    private ArrayList<IRemoteClient> clientList;

    public ClientServant() throws RemoteException {
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
                    // add client to the server list
                    remoteBoard.joinBoard(remoteClient, name);
                }

            }
        } catch (AccessException e) {
            JOptionPane.showMessageDialog(null,"Access denied", "Warning!", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        } catch (NotBoundException e) {
            JOptionPane.showMessageDialog(null,"The port already in use or port number is incorrect",  "Warning!", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        } catch (RemoteException e) {
            JOptionPane.showMessageDialog(null,"Can't connect to RMI",  "Warning!", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        } catch (NullPointerException e){
            JOptionPane.showMessageDialog(null,"some variables are null",  "Warning!", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
            System.exit(0);
        }

        /* Create and display the form */
        board = new BoardClient();
        board.setVisible(true);
        board.setSize(500,500);
        
    }


    @Override
    public void createManager() throws RemoteException {

    }

    @Override
    public String getName() throws RemoteException {
        return this.name;
    }

    @Override
    public void setManager(String name) throws RemoteException {
        this.isManager = true;
        this.name = name;
    }

    @Override
    public boolean askJoin(String name) throws RemoteException {
        return false;
    }

    @Override
    public void updateClientList(ArrayList<IRemoteClient> clients) throws RemoteException {
        clientList = clients;
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

    }

    @Override
    public boolean isManager() throws RemoteException {
        return this.isManager;
    }

}
