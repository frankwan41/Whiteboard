package remote;

import java.rmi.*;
import java.util.ArrayList;

/** RMI Remote interface - must be shared between client and server.
 * All methods must throw RemoteException.
 * All parameters and return types must be either primitives or Serializable.
 *
 * Clients or Managers can invoke these methods to ask server execute methods
 */

public interface IRemoteBoard extends Remote{
    // For joined clients

    // client join the white board with unique username
    public void joinBoard(IRemoteClient client) throws RemoteException;

    // client exit and broadcast to all clients and refresh clients list
    public void exitBoard(IRemoteClient client) throws RemoteException;

    // get peers list
    public ArrayList<IRemoteClient> getPeerList() throws RemoteException;

    // the new client should obtain the current state of the white board
    public byte[] currentBoard() throws RemoteException;

    // broadcast message to all clients
//    public void broadCast(Message message) throws RemoteException;

    // For manager
    // create new white board
    public void newBoard() throws  RemoteException;

    // open an existing white board
    public void openBoard(byte[] boardState) throws RemoteException;

    // Close the white board
    public void closeBoard() throws RemoteException;

    // Kick out a certain user
    public void kickUser(String userName) throws RemoteException;



}
