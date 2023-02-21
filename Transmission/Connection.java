package Transmission;

import Main.*;
import Database.*;
import Transmission.Messages.Notifications.*;
import Transmission.Messages.Requests.*;

import java.io.*;
import java.net.*;

public class Connection extends Thread {
    User user;
    Server server;
    int valid;
    DBManager dbmanager;
    //Transmission data
    ObjectInputStream input;
    ObjectOutputStream output;

    public Connection(Socket socket, DBManager dbmanager) {
        try {
            input = new ObjectInputStream(socket.getInputStream());
            output = new ObjectOutputStream(socket.getOutputStream());

            //0 - Successful login
            //1 - Username not found
            //2 - Password incorrect

            LoginRequest loginrequest = (LoginRequest) input.readObject();
            if (dbmanager.requestLogin(loginrequest.getUsername(), loginrequest.getPassword()) == 0) {
                output.writeObject(new LoginNotification(0));
                System.out.println("New user [" + loginrequest.getUsername() + "] connected");
                start();
            } else if (dbmanager.requestLogin(loginrequest.getUsername(), loginrequest.getPassword()) == 1) {
                output.writeObject(new LoginNotification(1));
                server.removeConnection(this);
            } else {
                output.writeObject(new LoginNotification(2));
                server.removeConnection(this);
            }

            this.dbmanager = dbmanager;
        } catch (IOException ex) {
            System.out.println("IOException in Transmission.Constructor");
        } catch (ClassNotFoundException ex) {
            System.out.println("ClassNotFoundException in Transmission.Constructor");
        }
    }

    public void run() {
        //Check for requests
        while (true) {

        }
    }
}