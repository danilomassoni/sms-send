package com.damatech.smssend;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;


@Component
public class SMSService {

    //@Value("${twilio.account.sid}")
    //private String ACCOUNT_SID;

   // @Value("${twilio.auth.token}")
   // private String AUTH_TOKEN;

    private final String ACCOUNT_SID ="AC585a3367b2637f64bfd51e2912579cf6";

    private final String AUTH_TOKEN = "6404f384d97f68437b139b95c120675f";

    private final String FROM_NUMBER = "+13262667744";

    public void send(SMSPojo sms) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

        Message message = Message.creator(new PhoneNumber(sms.getTo()), new PhoneNumber(FROM_NUMBER), sms.getMessage())
                .create();
        System.out.println("here is my id:"+message.getSid());// Unique resource ID created to manage this transaction

    }

    public void receive(MultiValueMap<String, String> smscallback) {
    }

}