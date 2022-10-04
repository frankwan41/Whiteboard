package remote;

import java.rmi.*;

/** RMI Remote interface - must be shared between client and server.
 * All methods must throw RemoteException.
 * All parameters and return types must be either primitives or Serializable.
 *
 * Board can invoke methods here to ask clients to execute methods
 */

public interface IRemoteClient extends Remote{
    // create the manager
    public void createManager() throws RemoteException;

    // get the client username
    public String getName() throws RemoteException;

    // set the client to be the manager
    public void setManager(String name) throws  RemoteException;

    // Client need to ask manager for permission to join the room
    public boolean askJoin() throws  RemoteException;

    // update clients' peer lists
    public void updateClientList() throws  RemoteException;

    // get the current white board state
    public byte[] getCurrentState() throws  RemoteException;

    // invoke when manager "new" the white board, clear all board drawing
    public void clearBoard() throws  RemoteException;

    // invoke when manager "open" the existing board, all clients should obtain the board state
    public void updateBoard(byte[] boardState) throws  RemoteException;

    // invoke when the manager "close" the board
    public void closeBoard() throws RemoteException;



}
