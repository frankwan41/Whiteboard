package server;

import org.junit.experimental.theories.Theories;
import remote.IRemoteBoard;
import remote.IRemoteClient;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 * White board server interface - shared between server and clients
 *
 */

public class BoardServant extends UnicastRemoteObject implements IRemoteBoard {
    private  Manager manager;
    boolean access = false;

    public BoardServant() throws RemoteException{
        this.manager = new Manager();
    }

    /**
     * client joins the board, handle difference between manager join and user join
     * @param client client remote class
     */
    @Override
    public void joinBoard(IRemoteClient client, String name) throws RemoteException {
        if(this.manager.getClientList() == null){
            // make the first client being the manager and add to the client list
            client.setManager(name + "(manager)");
            this.manager.addClient(client);
            System.out.println("Manager "+name+ " create thr board!");
        }else{
            // client need to ask manager to join the white board
            try{
                client.createBoard(this,name, false);
                client.setV(false);
                client.setClient(name);
                access = manager.askJoin(name);
                // check if access is granted
                if(access) {
                    client.setV(true);
                    manager.addClient(client);
                    // get current board
                    try {
                        client.updateOpenBoard(currentBoard());
                    }catch (IOException e){
                        JOptionPane.showMessageDialog(null,"Seems the board is missing!");
                        System.exit(1);
                    }
                    System.out.println("Client "+name+" join the board!");
                }else {
                    client.closeBoard(false);
                    return;
                }
            }catch (Exception e){
                JOptionPane.showMessageDialog(null,"The board connection lost, please try again!");
            }
        }

        client.synMessages(synMessages());
        // get a list of clients names
        ArrayList<String> names = new ArrayList<>();
        for(IRemoteClient c:manager.getClientList()){
            names.add(c.getName());
        }
        // update client's client list and messages
        for (IRemoteClient c: manager.getClientList()){
            c.updateClientList(names);
        }



    }

    /***
     *
     * @param name
     * @throws RemoteException
     * Client exit the board (not include manager)
     */
    @Override
    public void exitBoard(String name) throws RemoteException {
        for(IRemoteClient c: manager.getClientList()){
            if (c.getName().equals(name)){
                manager.removeClient(c);
                System.out.println("Client " + c.getName() + " leave the room!");
                break;
            }
        }
        ArrayList<String> names = new ArrayList<>();
        for(IRemoteClient c:manager.getClientList()){
            names.add(c.getName());
        }
        for(IRemoteClient c: manager.getClientList()){
            c.updateClientList(names);
        }

    }

    /***
     * Get the manager's current board image
     * @return
     * @throws IOException
     */
    @Override
    public byte[] currentBoard() throws IOException {
        // get the current board state of the manager
        IRemoteClient the_manager = manager.getClientList().get(0);
        byte[] currentState = the_manager.getCurrentBoard();

        return currentState;
    }

    /***
     * Only manager can call
     * clear the board to blank
     * @throws RemoteException
     */
    @Override
    public void newBoard() throws RemoteException {
        for (IRemoteClient c: manager.getClientList()){
            if(!c.isManager()){
                c.clearBoard();
            }
        }

    }

    /***
     * Manager can open an existing painted image
     * @param boardState
     * @throws IOException
     */
    @Override
    public void openBoard(byte[] boardState) throws IOException {
        for (IRemoteClient c: manager.getClientList()){
            if(!c.isManager()){
                c.updateOpenBoard(boardState);
            }
        }
    }

    /***
     * Manager can close the board, all the clients will be removed
     * @param managerName
     * @throws RemoteException
     */
    @Override
    public void closeAllBoard(String managerName) throws RemoteException {

        Collections.reverse(manager.getClientList());
        ArrayList<IRemoteClient> clientList = new ArrayList<>(manager.getClientList());
        for(IRemoteClient c: clientList){
            manager.removeClient(c);
            if (c.getName().equals(managerName)){
                this.manager = new Manager();
                System.out.println("The manager '"+managerName+ "' quit, all clients are removed!");
            }
            c.closeBoard(true);
        }

    }

    /***
     * Manager can kick client
     * @param userName
     * @throws RemoteException
     */
    @Override
    public void kickUser(String userName) throws RemoteException {
        for (IRemoteClient c: manager.getClientList()){
            if(c.getName().equals(userName)){
                manager.removeClient(c);
                System.out.println("Client " + userName + " is kicked out by manager!");
                c.closeBoard(true);
                break;
            }
        }
        ArrayList<String> names = new ArrayList<>();
        for(IRemoteClient c:manager.getClientList()){
            names.add(c.getName());
        }
        for (IRemoteClient c: manager.getClientList()){
            c.updateClientList(names);
            c.notification(userName + " is kicked out by manager");
        }
    }

    /**
     * check if the client list already has identical name
     * @param name name for input client
     * @return true if the list has the same name
     * @throws RemoteException
     */
    @Override
    public boolean checkName(String name) throws RemoteException {
        if(manager.getClientList() == null){
            return false;
        }
        for(IRemoteClient client:manager.getClientList()){
            if(name.equals(client.getName())){
                return true;
            }
        }
        return false;
    }

    /**
     * draw different shapes according to different modes
     * @param mode shape name
     * @param start start location of mouse
     * @param end end location of mouse
     * @throws RemoteException
     */
    @Override
    public void draw(String name, String mode, Point start, Point end, Color color, String text) throws RemoteException {
        for(IRemoteClient client: manager.getClientList()){
            if(!client.getName().equals(name)){
                client.draw(mode, start, end, color, text);
            }
        }
    }

    /**
     * check if client list is empty
     * @return true if empty
     * @throws RemoteException
     */
    @Override
    public boolean isEmpty() throws RemoteException {
        if(manager.getClientList() == null){
            return true;
        }
        return false;
    }

    /**
     * synchronize current messages
     * @return a list of messages
     * @throws RemoteException
     */
    @Override
    public ArrayList<String> synMessages() throws RemoteException {
        return manager.getMessages();
    }

    /**
     * add one message at a time
     * @param name the client who sends the message
     * @param text message content
     * @throws RemoteException
     */
    @Override
    public void addMessage(String name, String text) throws RemoteException {
        String message = name + ": " + text;
        manager.addMessage(message);
        for(IRemoteClient client: manager.getClientList()){
            client.addMessage(message);
        }
    }

}
