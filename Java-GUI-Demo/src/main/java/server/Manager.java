package server;

import remote.IRemoteBoard;
import remote.IRemoteClient;

import java.rmi.RemoteException;
import java.util.ArrayList;

public class Manager {

    private ArrayList<IRemoteClient> clientList;

    public void Manager(){
        //this.clientList = new ArrayList<>();
    }

    public void addClient(IRemoteClient client){
        if(this.clientList == null){
            this.clientList = new ArrayList<>();
        }
        this.clientList.add(client);
        System.out.println(this.clientList.size());
    }

    public ArrayList<IRemoteClient> getClientList() {
        return clientList;
    }

    public void removeClient(IRemoteClient client){
        this.clientList.remove(client);
    }

    /**
     * find manager and ask for join permission
     */
    public boolean askJoin(String name) throws RemoteException {
        for(IRemoteClient client:this.clientList){
            if(client.isManager()){
                return client.askJoin(name);
            }
        }
        return false;
    }
}
