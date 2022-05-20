package com.projects.authenticator;
import java.io.BufferedReader;
import java.io.FileReader;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

import io.jsonwebtoken.io.IOException;


public class SendAuth {
    public static final String ACCOUNT_SID = "AC81d8ae74e2a76c1e12b3052ad1e729e2";
    public static final String AUTH_TOKEN = "3ae35833c691eb31c37261739f84eb40";

    //Method for converting Msg to String
    public String getAuth() throws IOException, java.io.IOException
    {
        //Temp Stringbuilder to store the content
        StringBuilder resultStringBuilder = new StringBuilder("");
        //File Reader
        FileReader fr = new FileReader("auth.txt");
        //Writer
        BufferedReader br = new BufferedReader(fr);
        try{
            String line;
            while ((line=br.readLine())!= null)
            {
                //Appending line to String
                resultStringBuilder.append(line);
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        //Closing the writer
        br.close();
        //Returning Content
        return resultStringBuilder.toString();
    }
    //Send Messages usong Twilio API
    public void sendSMS(String number) throws IOException, java.io.IOException
    {
        //Twilio Console Details 
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        //Getting Msg as String from file, that we created earlier
        String msg = getAuth();
        //Sending Message
        Message newmessage = Message.creator(new PhoneNumber("+91"+number), new PhoneNumber("+14422455771"), msg).create();
        System.out.println(newmessage.getSid());
    }
    
}
