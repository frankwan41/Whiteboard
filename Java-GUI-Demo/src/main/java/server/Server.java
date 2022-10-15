package server;

import javax.swing.*;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server {

    private static int serverPort;

    public static void main(String[] args)
    {
//        if(args.length != 2){
//            JOptionPane.showMessageDialog(null,
//                    "Arguments must consist of two components, IPAddress and Port. ", "WARNING",
//                            JOptionPane.WARNING_MESSAGE);
//            System.exit(1);
//        }
//        try {
//            serverPort = Integer.parseInt(args[1]);
//        }catch (NumberFormatException e){
//            JOptionPane.showMessageDialog(null,"The port number must be correct integer format",
//                    "WARNING",JOptionPane.WARNING_MESSAGE);
//            System.exit(1);
//        }
        serverPort = 3200;

        try{
            BoardServant board = new BoardServant();
            Registry registry = LocateRegistry.createRegistry(serverPort);
            registry.bind("WhiteBoard",board);
            JOptionPane.showMessageDialog(null,"The board is ready on port " + serverPort);
        }catch (RemoteException e){
            // Log: The port already in use or port number is incorrect
            JOptionPane.showMessageDialog(null,"The port already in use");
            System.exit(1);
        }catch (AlreadyBoundException e){
            // Log: The binding name is already in use
            JOptionPane.showMessageDialog(null,"The RMI registry binding name is already in use");
            System.exit(1);
        }


    }


}
