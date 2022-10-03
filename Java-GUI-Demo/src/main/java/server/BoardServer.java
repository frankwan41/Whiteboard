package server;

import remote.IBoardServer;

import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;

/**
 * White board server interface - shared between server and clients
 *
 */

public class BoardServer extends UnicastRemoteObject implements IBoardServer {
    private  Manager manager;

    public BoardServer() throws RemoteException{
        this.manager = new Manager();
    }


    @Override
    public void joinBoard(Client client) throws RemoteException {
        boolean access = false;
        boolean unique = false;
        if(this.manager == null){
            // make the first client being the manager
            client.createManager();
            client.setName(client.getName() + "(manager)");
        }else{
            // client need to ask manager to join the white board
            try{
                while (!unique) {
                    for (Client c : manager.getClientList()) {
                        if (c.getName().equals(client.getName())) {
                            // A popup window shows the "username has been taken, please choose another one"
                        }else{
                            unique = true;
                        }
                    }
                }
                access = client.askJoin();
            }catch (Exception e){
                e.printStackTrace();
            }
        }

        if(access) {
            manager.addClient(client);
        }

        for (Client c: manager.getClientList()){
            c.updateClientList();
        }


    }

    @Override
    public void exitBoard(Client client) throws RemoteException {
        for(Client c: manager.getClientList()){
            if (c.getName().equals(client.getName())){
                manager.removeClient(c);
                System.out.println(c.getName() + " leave the room!");
            }
        }
        for(Client c: manager.getClientList()){
            c.updateClientList();
        }

    }

    @Override
    public List<Clients> getPeerList() throws RemoteException {
        return manager.getClientList();
    }

    @Override
    public byte[] currentBoard() throws RemoteException {
        byte[] currentState = null;
        for(Client c: manager.getClientList()){
            c.
        }
        return null
    }

    @Override
    public void broadCast(Message message) throws RemoteException {

    }

    @Override
    public void newBoard() throws RemoteException {

    }

    @Override
    public void openBoard() throws RemoteException {

    }

    @Override
    public void closeBoard() throws RemoteException {

    }

    @Override
    public void kickUser() throws RemoteException {

    }

    @Override
    public void managerExit() throws RemoteException {

    }
}
