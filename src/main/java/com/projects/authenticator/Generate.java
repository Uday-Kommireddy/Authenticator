package com.projects.authenticator;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class Generate implements Generator{
    private final String chars = "ABCDEFGHIJKLMNOPQRSTUVWYXZabcdefghijklmnopqrstuvwxyz$@%&*_";
    private final String numbers = "0874352169";
    private final int OTPLength = 4;
    private final int PasswordLength = 6;
    /*Get Random Object*/
    private Random getRandomObject()
    {
        Random random = new Random();
        return random;
    }

    @Override
    public void generateOTP() throws IOException{
        String OTP = new String("");
        Random random = getRandomObject();
        BufferedWriter writer = new BufferedWriter(new FileWriter("auth.txt"));
        /*Generating OTP*/
        for(int i=0;i<OTPLength;i++)
        {
            OTP += numbers.charAt(random.nextInt(numbers.length()));
        }
        writer.write(OTP);
        writer.close();

    }

    @Override
    public void generatePassword() throws IOException{
        //Initialize a new String
        String password = new String("");
        //Buffer Writer
        BufferedWriter writer = new BufferedWriter(new FileWriter("auth.txt"));
        //Get Random Object
        Random random = getRandomObject();
        for(int i=0;i<PasswordLength;i++)
        {
            password += chars.charAt(random.nextInt(chars.length()));
        }
        writer.write(password);
        writer.close();
    }
    
}
