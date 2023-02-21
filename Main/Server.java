/*
Main system managing users and connections
 */

package Main;

import Database.DBManager;
import Transmission.*;

import java.io.*;
import java.net.*;
import java.util.*;

public class Server {
    //Server data
    String name;
    DBManager dbmanager;
    //Transmission data
    int port;
    HashSet<Connection> connections;

    //====================CONSTRUCTOR====================
    public Server(String name, int port) {
        dbmanager = new DBManager("Database/db.bin");

        this.name = name;
        this.port = port;
    }
    //===================================================

    public void init() {
        try {
            System.out.println("Starting server...");
            ServerSocket serversocket = new ServerSocket(port);
            System.out.println("==========SERVER==========");
            System.out.println("Server started!");
            System.out.println("IP: " + InetAddress.getLocalHost().getHostAddress());
            System.out.println("Port: " + port);
            System.out.println("==========================");

            //Wait for incoming connections and establish connection
            while (true) {
                //Server receives connection and starts it
                Socket socket = serversocket.accept();
                connections.add(new Connection(socket, dbmanager));
            }
        } catch (IOException ex) {
            System.out.println("IOException in Server.init");
        }
    }

    public void removeConnection(Connection connection) {
        connections.remove(connection);
    }

    //----------Mutators/Accessors----------

    //--------------------------------------

    //Main method
    //args - {name, port}
    public static void main(String[] args) {
        Server server = new Server(args[0], Integer.parseInt(args[1]));
        server.init();
    }
}