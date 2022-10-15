package client;

import remote.IRemoteBoard;
import remote.IRemoteClient;

import javax.swing.*;
import java.rmi.AccessException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class JoinWhiteBoard {

    private static int serverPort;
    private static String clientName;
    private static ClientServant client;


    public  JoinWhiteBoard(){}


    public static void main(String[] args) {

        parseArgs(args);

        try{
            // find remote interface
            Registry registry = LocateRegistry.getRegistry(serverPort);
            IRemoteBoard remoteBoard = (IRemoteBoard) registry.lookup("WhiteBoard");

            client = new ClientServant();

            if(remoteBoard.checkName(clientName)){
                JOptionPane.showMessageDialog(null,"The username has been taken" +
                        ", please choose another one!", "Warning!", JOptionPane.WARNING_MESSAGE);
                System.exit(1);
            }else{
                // create board and check if client is a manager
                if(!remoteBoard.isEmpty()){
                    Thread t = new Thread(new Runnable() {
                        @Override
                        public void run() {
                            JOptionPane.showMessageDialog(null,"Please wait the manager to " +
                                    "grant you access!","Wait",JOptionPane.INFORMATION_MESSAGE);
                        }
                    });
                    t.start();
//                    JOptionPane.showMessageDialog(null,"Please wait the manager to " +
//                                    "grant you access!","Wait",JOptionPane.INFORMATION_MESSAGE);
                    remoteBoard.joinBoard(client, clientName);
                }else{
                    JOptionPane.showMessageDialog(null,
                            "The manager is missing, the board haven't start yet!", "Warning!",
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
            JOptionPane.showMessageDialog(null,"Lost connection to RMI or your port number is incorrect",
                    "Warning!", JOptionPane.ERROR_MESSAGE);
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
        clientName = args[2];

    }

}
