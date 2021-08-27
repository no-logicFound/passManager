package com.example.pwdManager;

import java.io.*;


public class Auth {

    String createMasterPass() throws IOException {

        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Please provide a secure master password that you will not forget: ");
        String firstInput = sc.readLine();

        System.out.print("Now re-enter the master password for verification: ");
        String secondInput = sc.readLine();


//        if(firstInput.equals(secondInput)){System.out.println("You're all set!! (✿◡‿◡)");}
//        else {
//            System.out.println("Nah, try again.");
//            createMasterPass();
//        }
        return secondInput;
    }

    boolean isFirstTime(){
        boolean firstTime = false;
        File file = new File("C:\\Users\\bradl\\Password Manager\\test.txt");

        if(!file.exists()){firstTime = true;
            try{file.createNewFile();}
            catch (IOException e){e.printStackTrace();}
        }
        return firstTime;
    }

    boolean isValidMasterPassword(String userInput){

        String password = new Encryption().convertPwdToHash(userInput);

        // compare given password to the stored masterPassword

        return false;
    }
}
