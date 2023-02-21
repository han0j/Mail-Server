package Transmission;

import java.io.Serializable;

public class User implements Serializable {
    String username;

    //====================CONSTRUCTOR====================
    public User(String username) {
        this.username = username;
    }
    //===================================================



    //----------Mutators/Accessors----------
    public String getUsername() {
        return username;
    }
    //--------------------------------------
}