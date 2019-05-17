package com.igorpystovit.model.SmsSender;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

public class SmsSender {
    // Find your Account Sid and Auth Token at twilio.com/console
    public static final String ACCOUNT_SID =
            "AC08b5ec0fc76a1866ff056001a3ecd051";
    public static final String AUTH_TOKEN =
            "a0ae992a8128afdea677a85dcf8ea2a1";

    public static void sendMessage(String messageContent){
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

        Message message = Message
                .creator(new PhoneNumber("+380988099430"), // to
                        new PhoneNumber("+12055489843"), // from
                        messageContent)
                .create();
    }
    public static void main(String[] args) {
        sendMessage("Test messa");
    }
}

