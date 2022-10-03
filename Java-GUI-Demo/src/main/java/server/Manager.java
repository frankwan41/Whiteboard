package server;

import java.util.ArrayList;

public class Manager {

    private ArrayList<Client> clientList;

    public void Manager(){
        this.clientList = new ArrayList<Client>();
    }

    public void addClient(Client client){
        this.clientList.add(client);
    }

    public ArrayList<Client> getClientList() {
        return clientList;
    }

    public void removeClient(Client client){
        this.clientList.remove(client);
    }



}
