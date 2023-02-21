/*
Notifies a user of the result of their login attempt.
 */

package Transmission.Messages.Notifications;

public class LoginNotification {
    //The result of the attempt
    //0 - Successful login
    //1 - Username not found
    //2 - Password incorrect
    int result;

    //====================CONSTRUCTOR====================
    public LoginNotification(int result) {
        this.result = result;
    }
    //===================================================

    //----------Mutators/Accessors----------
    public int getResult() {
        return result;
    }
    //--------------------------------------
}