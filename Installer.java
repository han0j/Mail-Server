import java.io.*;
import java.util.*;

public class Installer {

    public static void main(String[] args) {
        try {
            File databasefile = new File("Database/db.bin");
            databasefile.createNewFile();
            ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(databasefile));
            HashMap<String, String> logins = new HashMap<String, String>();
            logins.put("admin", "password");
            output.writeObject(logins);
            output.close();
        } catch (IOException ex) {
            System.out.println("IOException in Installer.main");
        }
    }
}
