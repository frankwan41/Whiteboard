package server;

import remote.IRemoteBoard;
import remote.IRemoteClient;

import java.awt.*;
import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

/**
 * White board server interface - shared between server and clients
 *
 */

public class BoardServant extends UnicastRemoteObject implements IRemoteBoard {
    private  Manager manager;

    public BoardServant() throws RemoteException{
        this.manager = new Manager();
    }

    /**
     * client joins the board
     * @param client client remote class
     * @throws RemoteException
     */
    @Override
    public void joinBoard(IRemoteClient client, String name) throws RemoteException {
        boolean access = false;
        if(this.manager.getClientList() == null){
            // make the first client being the manager and add to the client list
            client.setManager(name + "(manager)");
            this.manager.addClient(client);
            System.out.println("pass");
        }else{
            // client need to ask manager to join the white board
            try{
                client.setClient(name);
                access = manager.askJoin(client.getName());

                // check if access is granted
                if(access) {
                    manager.addClient(client);
                }else {
                    client.closeBoard();
                    return;
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }

        // update client's client list
        for (IRemoteClient c: manager.getClientList()){
            c.updateClientList(manager.getClientList());
        }


    }

    @Override
    public void exitBoard(IRemoteClient client) throws RemoteException {
        for(IRemoteClient c: manager.getClientList()){
            if (c.getName().equals(client.getName())){
                manager.removeClient(c);
                System.out.println(c.getName() + " leave the room!");
            }
        }
        for(IRemoteClient c: manager.getClientList()){
            c.updateClientList(manager.getClientList());
        }

    }

    @Override
    public ArrayList<IRemoteClient> getPeerList() throws RemoteException {
        return manager.getClientList();
    }

    @Override
    public byte[] currentBoard() throws RemoteException {
        // get the current board state of the manager
        IRemoteClient the_manager = manager.getClientList().get(0);
        byte[] currentState = the_manager.getCurrentBoard();

        return currentState;
    }

    @Override
    public void newBoard() throws RemoteException {
        for (IRemoteClient c: manager.getClientList()){
            c.clearBoard();
        }

    }

    @Override
    public void openBoard(byte[] boardState) throws RemoteException {
        for (IRemoteClient c: manager.getClientList()){
            c.updateOpenBoard(boardState);
        }
    }

    @Override
    public void closeBoard() throws RemoteException {
        for(IRemoteClient c: manager.getClientList()){
            manager.removeClient(c);
            c.closeBoard();
        }

    }

    @Override
    public void kickUser(String userName) throws RemoteException {
        for (IRemoteClient c: manager.getClientList()){
            if(c.getName().equals(userName)){
                manager.removeClient(c);
                System.out.println(userName + "is kicked out by manager!");
                c.closeBoard();
                break;
            }
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
    public void draw(String name, String mode, Point start, Point end) throws RemoteException {
        for(IRemoteClient client: manager.getClientList()){
            if(!client.getName().equals(name)){
                System.out.println(client.getName()+"  hhh "+name);
                client.draw(mode, start, end);
            }
        }
    }

}
