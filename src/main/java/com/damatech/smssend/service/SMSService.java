package com.damatech.smssend.service;

import com.damatech.smssend.model.SMSPojo;
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
    //Datas of the Twilio:
    private final String ACCOUNT_SID ="Take the SID in the Console of the Twilio";

    private final String AUTH_TOKEN = "Take the Token in the Console of the Twilio";

    private final String FROM_NUMBER = "+Take the Number in the Console of the Twilio";

    public void send(SMSPojo sms) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

        Message message = Message.creator(new PhoneNumber(sms.getTo()), new PhoneNumber(FROM_NUMBER), sms.getMessage())
                .create();
        System.out.println("here is my id:"+message.getSid());// Unique resource ID created to manage this transaction

    }

    public void receive(MultiValueMap<String, String> smscallback) {
    }

}