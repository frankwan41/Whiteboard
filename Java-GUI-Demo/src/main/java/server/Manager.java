package server;

import remote.IRemoteBoard;
import remote.IRemoteClient;

import java.util.ArrayList;

public class Manager {

    private ArrayList<IRemoteClient> clientList;

    public void Manager(){
        this.clientList = new ArrayList<IRemoteClient>();
    }

    public void addClient(IRemoteClient client){
        System.out.println("here");
        this.clientList.add(client);
        System.out.println("all");
    }

    public ArrayList<IRemoteClient> getClientList() {
        return clientList;
    }

    public void removeClient(IRemoteClient client){
        this.clientList.remove(client);
    }



}
