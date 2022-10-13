package remote;

import java.awt.*;
import java.rmi.*;
import java.util.ArrayList;

/** RMI Remote interface - must be shared between client and server.
 * All methods must throw RemoteException.
 * All parameters and return types must be either primitives or Serializable.
 *
 * Clients or Managers can invoke these methods to ask server execute methods
 */

public interface IRemoteBoard extends Remote{
    // get previous chat messages
    ArrayList<String> synMessages() throws RemoteException;

    // add one chat message
    void addMessage(String name, String text) throws RemoteException;

    // client join the white board with unique username
    void joinBoard(IRemoteClient client, String name) throws RemoteException;

    // client exit and broadcast to all clients and refresh clients list
    void exitBoard(IRemoteClient client) throws RemoteException;

    // get peers list
    ArrayList<IRemoteClient> getPeerList() throws RemoteException;

    // the new client should obtain the current state of the white board
    byte[] currentBoard() throws RemoteException;

    // For manager
    // create new white board
    void newBoard() throws  RemoteException;

    // open an existing white board
    void openBoard(byte[] boardState) throws RemoteException;

    // Close the white board
    void closeBoard() throws RemoteException;

    // Kick out a certain user
    void kickUser(String userName) throws RemoteException;

    // check identical name
    boolean checkName(String name) throws RemoteException;

    // update client's whiteboard and draw a line
    void draw(String name, String mode, Point start, Point end, Color color) throws RemoteException;

    // check empty client list
    boolean isEmpty() throws RemoteException;
}
