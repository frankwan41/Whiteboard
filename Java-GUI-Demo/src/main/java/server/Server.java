package server;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.ExportException;

import javax.net.ServerSocketFactory;
import javax.swing.*;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Server {

    public static void main(String[] args)
    {
//        if(args.length != 3){
//            throw new IllegalArgumentException("Arguments must consist of three components, " +
//                    "IPAddress, Port, Username ");
//        }
        // port = Integer.parseInt(args[1])
        try{
            BoardServant board = new BoardServant();
            Registry registry = LocateRegistry.createRegistry(4321);
            registry.bind("WhiteBoard",board);
            JOptionPane.showMessageDialog(null,"the board is ready");
        }catch (RemoteException e){
            // Log: The port already in use or port number is incorrect
            JOptionPane.showMessageDialog(null,"The port already in use or port number is incorrect");
            System.exit(0);
        }catch (AlreadyBoundException e){
            // Log: The binding name is already in use
            JOptionPane.showMessageDialog(null,"The RMI registry binding name is already in use");
            System.exit(0);
        }


    }


}
