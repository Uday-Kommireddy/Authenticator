package com.projects.authenticator;

import java.io.IOException;

public interface Generator {
    /*1) Generate an random OTP(preferred 6 digited) [Initail idea was to store them in an Dict for a stipulated time, check the generated OTP in or not] */
    public void generateOTP() throws IOException;
    /* 2) Generate an random password with special characters(preferred and used length of 6), idea was same as above*/
    public void generatePassword() throws IOException; 
    
}
