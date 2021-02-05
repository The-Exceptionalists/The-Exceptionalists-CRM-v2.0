package com.ironhack.TheExceptionalistsCRMv20.utils;

import com.ironhack.TheExceptionalistsCRMv20.ConsoleApp;

import java.util.Locale;
import java.util.Scanner;

import static com.ironhack.TheExceptionalistsCRMv20.utils.Output.fillWithSpaces;

public class Security {
    private static final String DEFAULT = (char) 27 + "[0m";
    private static final String BOLD = (char) 27 + "[1m";
    private static final String INVERSE = (char) 27 + "[7m";

    static private int loginAttempt = 0;

    public static void introLogin() {
        if (loginAttempt >= 3) {
            System.exit(ConsoleApp.getExitCode());
        }
        System.out.println(DEFAULT + "\n\n\n\n");
        System.out.println(DEFAULT + "\n\n\n\n");
        System.out.println(DEFAULT + "\n\n\n\n\n\n\n");
        System.out.println();
        System.out.println(fillWithSpaces(27) + INVERSE + BOLD + Buffer.getAppName() + DEFAULT);
        System.out.println("\n\n\n");
        System.out.println(fillWithSpaces(34) + "Username:".toUpperCase(Locale.ROOT));
        System.out.println();
        System.out.println(DEFAULT + "\n\n\n\n");
        System.out.println("\n\n\n");
        Scanner sc = new Scanner(System.in);
        String username = sc.nextLine();
        System.out.println(DEFAULT + "\n\n\n\n");
        System.out.println(DEFAULT + "\n\n\n\n");
        System.out.println(DEFAULT + "\n\n\n\n\n\n\n");
        System.out.println();
        System.out.println(fillWithSpaces(24) + INVERSE + BOLD + Buffer.getAppName() + DEFAULT);
        System.out.println("\n\n\n");
        System.out.println(fillWithSpaces(34) + "Password:".toUpperCase(Locale.ROOT));
        System.out.println();
        System.out.println(DEFAULT + "\n\n\n\n");
        System.out.println("\n\n\n");
        sc = new Scanner(System.in);
        String password = sc.nextLine();
        if (!username.equalsIgnoreCase("ironhacker") || !password.equals("bet4TE$t")) {
            loginAttempt++;
            System.out.println("Wrong credentials, try again. You have " + (3 - loginAttempt) + " attempts left.");
            System.out.println("You want to try again?");
            sc.nextLine();
            introLogin();
        }
        Buffer.setUserName(" " + username);
        System.out.println("Login completed.");
        try {
            Thread.sleep(700);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
