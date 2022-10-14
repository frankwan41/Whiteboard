package client;

import remote.IRemoteBoard;

import javax.swing.*;
import java.rmi.AccessException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class CreateWhiteBoard {

    private static int serverPort;
    private static String mangerName;
    private static ClientServant manager;


    public  CreateWhiteBoard(){}


    public static void main(String[] args) {

        parseArgs(args);

        try{
            // find remote interface
            Registry registry = LocateRegistry.getRegistry(serverPort);
            IRemoteBoard remoteBoard = (IRemoteBoard) registry.lookup("WhiteBoard");

            manager = new ClientServant();

            if(remoteBoard.checkName(mangerName)){
                JOptionPane.showMessageDialog(null,"The username has been taken" +
                        ", please choose another one!", "Warning!", JOptionPane.WARNING_MESSAGE);
                System.exit(1);
            }else{
                // create board and check if client is a manager
                if(remoteBoard.isEmpty()){
                    manager.createBoard(remoteBoard, mangerName+" (manager)", true);
                    // add client to the server list
                    remoteBoard.joinBoard(manager, mangerName);
                }else{
                    JOptionPane.showMessageDialog(null,
                            "The server board is already running, you can't create a new board!", "Warning!",
                            JOptionPane.ERROR_MESSAGE);
                    System.exit(1);

                }

            }
        } catch (AccessException e) {
            JOptionPane.showMessageDialog(null,"Access denied", "Warning!", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        } catch (NotBoundException e) {
            JOptionPane.showMessageDialog(null,"The port already in use or port number is incorrect",  "Warning!", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        } catch (RemoteException e) {
            JOptionPane.showMessageDialog(null,"lost connection to RMI",  "Warning!", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        } catch (NullPointerException e){
            JOptionPane.showMessageDialog(null,"Some variables are null",  "Warning!", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }

    }


    private static void parseArgs(String args[]){
        if(args.length != 3){
            JOptionPane.showMessageDialog(null,
                    "Arguments must consist of three components, IPAddress, Port, and username!", "WARNING",
                    JOptionPane.WARNING_MESSAGE);
            System.exit(1);
        }
        try {
            serverPort = Integer.parseInt(args[1]);
        }catch (NumberFormatException e){
            JOptionPane.showMessageDialog(null,"The port number must be correct integer format",
                    "WARNING",JOptionPane.WARNING_MESSAGE);
            System.exit(1);
        }
        if(args[2].equals("")){
            JOptionPane.showMessageDialog(null,"Can't use empty name!", "Warning!",
                        JOptionPane.WARNING_MESSAGE);
            System.exit(1);
        }
        mangerName = args[2];

    }

}
