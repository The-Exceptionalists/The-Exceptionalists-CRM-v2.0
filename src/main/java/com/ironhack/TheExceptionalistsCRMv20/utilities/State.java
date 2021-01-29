package com.ironhack.TheExceptionalistsCRMv20.utilities;

import com.google.gson.*;
import com.google.gson.reflect.*;
import com.ironhack.TheExceptionalistsCRMv20.classes.Account;
import com.ironhack.TheExceptionalistsCRMv20.classes.Contact;
import com.ironhack.TheExceptionalistsCRMv20.classes.Lead;
import com.ironhack.TheExceptionalistsCRMv20.classes.Opportunity;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;


//We implement runnable so we can run the class on a specific Thread to save the database before closing the app

public class State implements Runnable {

    //Method called at application close to save all changes in your database. Your database is stored in JSON format stored in the resources folder
    public static void saveState() {
        writeLeads();
        writeAccounts();
    }

    // This method is called at application launch to restore de JSON database, so you can keep your data
    public static void restoreState() {
        readLeads();
        readAccounts();

    }

    //THis method gets all the leads of your current session and stores them using the Gson library
    private static void writeLeads() {
        List<Lead> leads = Storage.getAllLeads();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String path = "src/main/resources/Database/leads.json";
        try {
            FileWriter fileWriter = new FileWriter(path);
            gson.toJson(leads, fileWriter);
            fileWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //This method gets all the leads of your previous sessions
    private static void readLeads() {
        String path = "src/main/resources/Database/leads.json";
        Reader reader = null;
        List<Lead> leads = null;
        try {
            reader = Files.newBufferedReader(Paths.get(path));
            leads = new Gson().fromJson(reader, new TypeToken<List<Lead>>() {
            }.getType());
        } catch (IOException e) {
            System.out.println("No hay leads en la base de datos");
        }

        if (leads != null) {
            for (Lead lead : leads) {
                Storage.add(lead);
                Storage.setUpId();
            }
        }
    }

    //Writing accounts to json also saves the opportunities and contacts
    private static void writeAccounts() {
        List<Account> accounts = Storage.getAllAccounts();
        Gson gson;
        gson = new GsonBuilder().setPrettyPrinting().create();
        String path = "src/main/resources/Database/accounts.json";
        try {
            FileWriter fileWriter = new FileWriter(path);
            gson.toJson(accounts, fileWriter);
            fileWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    //Restores accounts and puts all their opportunities and contacts in the runtime

    private static void readAccounts() {


        String path = "src/main/resources/Database/accounts.json";
        Reader reader = null;
        List<Account> accounts = null;
        try {
            reader = Files.newBufferedReader(Paths.get(path));
            accounts = new Gson().fromJson(reader, new TypeToken<List<Account>>() {
            }.getType());
        } catch (IOException e) {
            System.out.println("No hay contactos en la base de datos");
        }

        if (accounts != null) {

            for (Account account : accounts) {
                Storage.add(account);
                Storage.setUpId();
                if (account.getOpportunityList() != null) {
                    for (Opportunity opportunity : account.getOpportunityList()) {
                        Storage.add(opportunity);
                        Storage.setUpId();
                    }
                }
                if (account.getContactList() != null) {

                    for (Contact contact : account.getContactList()) {
                        Storage.add(contact);
                        Storage.setUpId();
                    }
                }
            }
        }

    }

//Method overriden from Runnable to be able to launch it as new Thread

    @Override
    public void run() {
        writeLeads();
        writeAccounts();
        Thread.currentThread().interrupt();
    }
}
