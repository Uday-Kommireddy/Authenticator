package com.projects.authenticator;
import java.util.*;
import java.io.IOException;

//import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AuthenticatorApplication {

	public static void main(String[] args) throws IOException {
		//SpringApplication.run(AuthenticatorApplication.class, args);
		//Scanner
		Scanner sc = new Scanner(System.in);
		//Generate class OBJECT
		Generate request = new Generate();
		//User Input
		//Get User NUmber
		System.out.println("Enter Phone Number :");
		String Number = sc.nextLine();
		System.out.println("Enter choice of Authentication\n 1) OTP \n 2) Password");
		String choice = new String("");
		choice = sc.nextLine();
		switch(choice)
		{
			case "1" : request.generateOTP();
			           break;
			case "2" : request.generatePassword();
					   break;
		}
		SendAuth send = new SendAuth();
		//Sending Messages
		send.sendSMS(Number);

		//Closing SC
		sc.close();


	}

}
