package com.example.pwdManager;

import java.io.IOException;

public class Runnable {

    public static void main(String[] args) throws IOException {
        boolean isFirstTime = new Auth().isFirstTime();

        if(isFirstTime){
            String masterPass = new Auth().createMasterPass();
            String hashedMasterPass = new Encryption().convertPwdToHash(masterPass);
        }
        new Menu().showMenu();
        new Menu().executeMenu();
            // I'll add master-pass to the database
    }
}
