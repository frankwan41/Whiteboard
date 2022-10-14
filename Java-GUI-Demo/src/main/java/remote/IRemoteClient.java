package remote;

import java.awt.*;
import java.rmi.*;
import java.util.ArrayList;

/** RMI Remote interface - must be shared between client and server.
 * All methods must throw RemoteException.
 * All parameters and return types must be either primitives or Serializable.
 *
 * Board can invoke methods here to ask clients to execute methods
 */

public interface IRemoteClient extends Remote{
    // set the client information
    void setClient(String name) throws RemoteException;

    // get the client username
    String getName() throws RemoteException;

    // set the client to be the manager
    void setManager(String name) throws  RemoteException;

    // Client need to ask manager for permission to join the room
    boolean askJoin(String name) throws  RemoteException;

    // update clients' peer lists
    void updateClientList(ArrayList<String> clients) throws  RemoteException;

    // update self board while other clients did the drawing
    //void updateBoard(IRemoteMessage message) throws RemoteException;

    // get the current white board state(for client who join the board will get the current board state)
    byte[] getCurrentBoard() throws  RemoteException;

    // invoke when manager "new" the white board, clear all board drawing
    void clearBoard() throws  RemoteException;

    // invoke when manager "open" the existing board, all clients should obtain the board state
    void updateOpenBoard(byte[] boardState) throws  RemoteException;

    // invoke when the manager "close" the board
    void closeBoard() throws RemoteException;

    // check if client is a manager
    boolean isManager() throws RemoteException;

    // ask client to draw shapes
    void draw(String mode, Point start, Point end, Color color) throws RemoteException;

    // update chat when connect to the server
    void synMessages(ArrayList<String> text) throws RemoteException;

    // add one message
    void addMessage(String text) throws RemoteException;

    // notify every client that a client is kicked out
    void notification(String text) throws RemoteException;
}
