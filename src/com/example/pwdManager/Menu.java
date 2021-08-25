package com.example.pwdManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Menu {
    private String referenceName, username, password;

    public void showMenu(){

        System.out.println("--------------------------");
        System.out.println("1 --> Enter reference name and/or username, password.");
        System.out.println("4 --> Exit.");
        System.out.println("--------------------------");
    }

    public void executeMenu() throws IOException {

        System.out.print("Choose from the menu above: ");

        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));

        br.readLine();


//        switch (in) {
//            case 1 -> {
//
//                System.out.print("Enter a reference name to the password: ");
//                referenceName = br.readLine();
//                System.out.print("Enter username: ");
//                username = br.readLine();
//                System.out.print("Enter password: ");
//                password = br.readLine();
//
//            }
//            case 4 -> {
//                System.out.println("Adios.");
//                System.exit(0);
//            }
    }
}
