/*
Manages the database and returns requested data
 */

package Database;

import java.io.*;
import java.util.*;

public class DBManager {
    HashMap<String, String> logins;


    public DBManager() {
        try {
            File databasefile = new File("Database/db.bin");
            ObjectInputStream input = new ObjectInputStream(new FileInputStream(databasefile));
            logins = (HashMap<String, String>) input.readObject();
        } catch (IOException ex) {
            System.out.println("IOException in DBManager.Constructor");
        } catch (ClassNotFoundException ex) {
            System.out.println("ClassNotFoundException in DBManager.Constructor");
        }
    }

    //Codes:
    //0 - Successful login
    //1 - Username not found
    //2 - Password incorrect
    public int requestLogin(String username, String password) {
        if (logins.containsKey(username)) {
            if (logins.get(username).equals(password)) {
                return 0;
            } else {
                return 1;
            }
        } else {
            return 1;
        }
    }

}
