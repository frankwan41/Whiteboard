package server;

import remote.IRemoteBoard;
import remote.IRemoteClient;

import java.rmi.RemoteException;
import java.util.ArrayList;

public class Manager {

    private ArrayList<IRemoteClient> clientList;
    private ArrayList<String> messages;

    public void Manager(){

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

    /**
     * get current messages list
     * @return a list of messages
     */
    public ArrayList<String> getMessages(){
        return this.messages;
    }

    /**
     * add one message
     * @param text message content
     */
    public void addMessage(String text){
        if(messages == null){
            messages = new ArrayList<>();
            messages.add(text);
        }else {
            messages.add(text);
        }
    }
}
