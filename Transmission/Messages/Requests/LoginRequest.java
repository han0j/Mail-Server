package Transmission.Messages.Requests;

public class LoginRequest extends Request {
    String username;
    String password;

    //====================CONSTRUCTOR====================
    public LoginRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }
    //===================================================

    //----------Mutators/Accessors----------
    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }
    //--------------------------------------
}