package server;

import remote.IRemoteBoard;
import remote.IRemoteClient;

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


    @Override
    public void joinBoard(IRemoteClient client) throws RemoteException {
        boolean access = false;
        if(this.manager == null){
            // make the first client being the manager
            client.createManager();
            client.setManager(client.getName() + "(manager)");
        }else{
            // client need to ask manager to join the white board
            try{
                access = client.askJoin(client.getName());
            }catch (Exception e){
                e.printStackTrace();
            }
        }

        if(access) {
            manager.addClient(client);
        }

        for (IRemoteClient c: manager.getClientList()){
            c.updateClientList();
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
            c.updateClientList();
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


//   @Override
//    public void broadCast(Message message) throws RemoteException {
//
//    }

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

}
