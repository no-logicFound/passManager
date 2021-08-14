package com.example.pwdManager;

import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;
import java.security.MessageDigest;

public class Encryption {
    byte[] digestedPassword = {};
    String generatedPassword;
    //byte[] salt;

    // get the string version of the password from user
    private String getPasswordFromUser() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Password : ");
        String password = sc.nextLine();
        sc.close();
        if(password.isEmpty()){
            password = "password";}
        return password;

    }

    // change password to --> byte[] digestPassword
    private void digestPassword (String password){
        byte[] bytePassword = password.getBytes(StandardCharsets.UTF_8);

        try {
            MessageDigest md = MessageDigest.getInstance("SHA-512");
            // change password to byte array
            digestedPassword = md.digest(bytePassword);
        }catch (NoSuchAlgorithmException e){
            e.printStackTrace();
        }
        //System.out.println(Arrays.toString(digestedPassword));
    }

    // takes byte[] digestedPassword to it's hashed version
    private String hashPassword (byte[] bytes){
        StringBuilder sb = new StringBuilder();
        for (byte aByte : bytes) {
            sb.append(Integer.toString((aByte & 0xff) + 0x100, 16).substring(1));
        }
        generatedPassword = sb.toString();

        System.out.println(generatedPassword);
        return generatedPassword;
    }

     private String getPassword(){
        return getPasswordFromUser();
    }

    String convertPwdToHash(){
        digestPassword(getPassword());
        return hashPassword(digestedPassword);
    }

}
