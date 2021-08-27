package com.example.pwdManager;

import java.io.IOException;

public class Runnable {

    static void initializeApp(String dbName, String masterPassTableName) throws IOException {
        new Menu().greetNewUser();
        new Database().createDatabaseIfNotExists(dbName);
        new Database().createMasterPassTable(masterPassTableName);

        String masterPass = new Auth().createMasterPass();
        String hashedMasterPass = new Encryption().convertPwdToHash(masterPass);
        new Database().insertMasterPassIntoTable(hashedMasterPass);
    }

    public static void main(String[] args) throws IOException {
        String dbName = Database.DB_NAME;
        String masterPassTableName = "master_password_holder";
        boolean isFirstTime = new Auth().isFirstTime();

        if(isFirstTime) {
            new Database().dropDatabaseIfExists(dbName);
            initializeApp(dbName, masterPassTableName);
            new Menu().showMenu();
            new Menu().executeMenu();
        }else {
            boolean hasAccess = new Auth().isValidMasterPassword();
            if (hasAccess){
                new Menu().greetNewUser();
                new Menu().showMenu();
                new Menu().executeMenu();
            }
        }

    }
}
