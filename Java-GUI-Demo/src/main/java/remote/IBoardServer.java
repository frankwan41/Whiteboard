package remote;

import java.rmi.*;

/** RMI Remote interface - must be shared between client and server.
 * All methods must throw RemoteException.
 * All parameters and return types must be either primitives or Serializable.
 *
 * Clients or Managers can invoke these methods
 */

public interface IBoardServer {
    // For joined clients

    // client join the white board with unique username
    public void joinBoard(Client client) throws RemoteException;

    // client exit and broadcast to all clients and refresh clients list
    public void exitBoard(Client client) throws RemoteException;

    // get peers list
    public List<Clients> getPeerList() throws RemoteException;

    // the new client should obtain the current state of the white board
    public data currentBoard() throws RemoteException;

    // broadcast message to all clients
    public void broadCast(Message message) throws RemoteException;

    // For manager
    // create new white board
    public void newBoard() throws  RemoteException;

    // open an existing white board
    public void openBoard() throws RemoteException;

    // Close the white board
    public void closeBoard() throws RemoteException;

    // Kick out a certain user
    public void kickUser() throws RemoteException;

    // manager exit the board, the board will be closed
    public void managerExit() throws RemoteException;


}
