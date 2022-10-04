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
        this.clientList.add(client);
    }

    public ArrayList<IRemoteClient> getClientList() {
        return clientList;
    }

    public void removeClient(IRemoteClient client){
        this.clientList.remove(client);
    }



}
