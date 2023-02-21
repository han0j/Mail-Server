package Transmission.Messages;

import Transmission.*;

public class TextMessage {
    User sender;
    String subject;
    String body;

    //====================CONSTRUCTOR====================
    public TextMessage(User sender, String subject, String body) {
        this.sender = sender;
        this.subject = subject;
        this.body = body;
    }
    //===================================================

    //----------Mutators/Accessors----------
    public User getUser() {
        return sender;
    }
    public String getSubject() {
        return subject;
    }
    public String getBody() {
        return body;
    }
    //--------------------------------------
}