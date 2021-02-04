package com.ironhack.TheExceptionalistsCRMv20.manager;

import com.ironhack.TheExceptionalistsCRMv20.ConsoleApp;
import com.ironhack.TheExceptionalistsCRMv20.enums.Industry;
import com.ironhack.TheExceptionalistsCRMv20.enums.PrintLayout;
import com.ironhack.TheExceptionalistsCRMv20.enums.Product;
import com.ironhack.TheExceptionalistsCRMv20.enums.Status;
import com.ironhack.TheExceptionalistsCRMv20.model.*;
import com.ironhack.TheExceptionalistsCRMv20.repository.*;
import com.ironhack.TheExceptionalistsCRMv20.utils.Buffer;
import com.ironhack.TheExceptionalistsCRMv20.utils.Output;
import com.ironhack.TheExceptionalistsCRMv20.utils.Validator;

import java.util.*;


public class CommandManager {
    private static LeadRepository leadRepository;
    private static ContactRepository contactRepository;
    private static OpportunityRepository opportunityRepository;
    private static AccountRepository accountRepository;
    private static SalesRepRepository salesRepRepository;
    private static String normalPrompt = "Introduce a command from the list:";
    private static String errorPrompt = "";


    public static void initRepos(LeadRepository leadRepository, ContactRepository contactRepository, OpportunityRepository opportunityRepository, AccountRepository accountRepository, SalesRepRepository salesRepRepository) {
        CommandManager.leadRepository = leadRepository;
        CommandManager.contactRepository = contactRepository;
        CommandManager.opportunityRepository = opportunityRepository;
        CommandManager.accountRepository = accountRepository;
        CommandManager.salesRepRepository = salesRepRepository;
    }

    public static void introduceCommand() {
        CommandManager.setCommandList();
        Output.printPage(errorPrompt, normalPrompt, PrintLayout.MENU_ON, false);
        errorPrompt = "";
        Scanner sc = new Scanner(System.in);
        String command = sc.nextLine();
        command = command.toLowerCase();

        if (Validator.validateCommand(command)) {
            processCommand(command);
        } else {
            errorPrompt = "Command not found";
        }
    }

    //Method that handles all commands and calls the required method
    public static void processCommand(String command) {
        String[] words = command.toLowerCase().split(" ");
        switch (words[0]) {
            case "new" -> createObject(words[1]);
            case "show" -> showList(words[1]);
            case "convert" -> convertLeadToOpportunity(Integer.parseInt(words[1]));
            case "lookup" -> showObject(words[1], Integer.parseInt(words[2]));
            case "close-won" -> closeOpportunity(Integer.parseInt(words[1]), Status.CLOSED_WON);
            case "close-lost" -> closeOpportunity(Integer.parseInt(words[1]), Status.CLOSED_LOST);
            case "report" -> showReport(words[1], words[3]);
            case "mean", "median", "max", "min" -> showStats(words[0], words[1]);
            case "help" -> helpPage();
            case "exit" -> saveChangesAndExit();
        }
    }

    private static void saveChangesAndExit() {
        ConsoleApp.ctx.close();
        System.exit(0);
    }

    private static void helpPage() {
        Output.printHelpPage();
        Scanner sc = new Scanner(System.in);
        String command = sc.nextLine();
    }


    //Method that handles the object creation
    private static void createObject(String word) {
        switch (word) {
            case "lead" -> {
                if (salesRepRepository.count() == 0L) {
                    //TODO: add a message, to tell the user, we need at least a salesRep. if not we go into a endless cicle.
                    Output.printPage("You should add at least a salesRep, before create a lead", "Press INTRO to continue", PrintLayout.SOLO_LAYOUT);
//                    System.out.println("You should add at least a salesRep, before create a lead");
                    Scanner sc = new Scanner(System.in);
                    sc.nextLine();
                    introduceCommand();
                }
                ;
                Lead lead = promptLead();
                leadRepository.save(lead);
//                System.out.println("New lead successfully added!");
            }
            case "salesrep" -> {
                SalesRep salesRep = promptSalesRep();
                salesRepRepository.save(salesRep);

//                System.out.println("New SalesRep successfully added!");
            }
        }
    }

    //Method that handles the show command
    public static void showList(String objectType) {
        switch (objectType) {
            case "leads" -> {
                List<Lead> leadList = leadRepository.findAll();
                printLeadList(leadList, 0);
            }
            case "opportunities" -> {
                List<Opportunity> opportunityList = opportunityRepository.findAll();
                printOpportunityList(opportunityList, 0);
            }
            case "contacts" -> {
                List<Contact> contactList = contactRepository.findAll();
                printContactList(contactList, 0);
            }
            case "accounts" -> {
                List<Account> accountList = accountRepository.findAll();
                printAccountList(accountList, 0);
            }
            case "salesreps" -> {
                List<SalesRep> salesRepList = salesRepRepository.findAll();
                printSalesRepList(salesRepList, 0);
            }
        }
    }

    //Method that handles the lead to opportunity conversion
    private static void convertLeadToOpportunity(int id) {
        try {
            //Searches a lead, changing the parameter id to the format used in Storage
            Lead lead = leadRepository.findById(id).get();
            Contact contact = leadToContact(lead);
            Opportunity opportunity = promptOpportunity(contact);
            opportunity.setSalesRep(lead.getSalesRep());
            Buffer.resetPromptMessages();
            String text = "Do you want to create a new Account? (YES / NO)";
            printItemPrompt(text);
            Scanner sc = new Scanner(System.in);
            String createNewAccount = sc.nextLine();
            createNewAccount.toLowerCase();
            while (!createNewAccount.equals("yes") && !createNewAccount.equals("no")) {
                Buffer.setPromptLineOne("Enter a correct response.");
                printItemPrompt(text);
                Buffer.resetPromptOne();
                sc = new Scanner(System.in);
                createNewAccount = sc.nextLine().toLowerCase();
            }
            if (createNewAccount.equals("yes")) {
                Account account = promptAccount(contact.getCompanyName(), contact, opportunity);
                opportunity.setAccount(account);
                contact.setAccount(account);
                //Adds all objects to the storage class
                contactRepository.save(contact);
                opportunityRepository.save(opportunity);
                accountRepository.save(account);
                leadRepository.deleteById(id);
            } else {
                text = "Enter an Account ID:";
                printItemPrompt(text);
                sc = new Scanner(System.in);
                String accountId = sc.nextLine();
                while(Validator.validateNumber(accountId) && accountRepository.findById(Integer.parseInt(accountId)).isEmpty()) {
                    Buffer.setPromptLineOne("Enter a valid and existing Account ID.");
                    printItemPrompt(text);
                    Buffer.resetPromptOne();
                    sc = new Scanner(System.in);
                    accountId = sc.nextLine();
                }
                Account account = accountRepository.findById(Integer.parseInt(accountId)).get();
                opportunity.setAccount(account);
                contact.setAccount(account);
                //Adds all objects to the storage class
                contactRepository.save(contact);
                opportunityRepository.save(opportunity);
                leadRepository.deleteById(id);
                printItemPrompt("Contact and Opportunity added - press INTRO");
                sc.nextLine();
            }
            //Return an error message if the id is not found
        } catch (IllegalArgumentException | NullPointerException | NoSuchElementException e) {
            Buffer.setPromptLineTwo("Convert Lead - press INTRO");
            Buffer.insertCentralPromptPoints(2);
            normalOneLinePrint("Lead with id " + id + " not found.");
            Buffer.resetPromptMessages();

        }
    }

    //Creates a Contact object from a Lead object
    private static Contact leadToContact(Lead lead) {
        String name = lead.getName();
        String email = lead.getEmail();
        String companyName = lead.getCompanyName();
        String phoneNumber = lead.getPhoneNumber();
        return new Contact(name, email, companyName, phoneNumber);
    }

    //Prompts all required parameters for the opportunity creation
    private static Opportunity promptOpportunity(Contact contact) {
        //Output for prompt Opportunity
        Buffer.resetPromptMessages();
        Buffer.initStringsRepository();
        Buffer.insertStringIntoRepository("New Opportunity creation", 7);
        Scanner sc = new Scanner(System.in);
        String text = "Type of truck (Hybrid, Flatbed or Box):";
        printItemPrompt(text);
        String product = sc.nextLine().toLowerCase();
        //Keeps asking for the correct value
        while (!Validator.validateProduct(product)) {
            Buffer.setPromptLineOne("Enter a correct product (Hybrid, Flatbed or Box): ");
            printItemPrompt(text);
            Buffer.resetPromptOne();
            product = sc.nextLine().toLowerCase();
        }
        Buffer.insertStringIntoRepository("Product type: " + product, 10);
        Product productEnum = findProductEnum(product);
        text = "Number of trucks: ";
        printItemPrompt(text);
        String number = sc.nextLine();
        //Keeps asking for the correct value
        while (!Validator.validateNumber(number)) {
            Buffer.setPromptLineOne("Enter a correct number of trucks: ");
            printItemPrompt(text);
            Buffer.resetPromptOne();
            number = sc.nextLine();
        }
        Buffer.insertStringIntoRepository("Number of trucks: " + number, 11);
        printItemPrompt("Opportunity created! - press INTRO");
        String retScanner = sc.nextLine();
        return new Opportunity(productEnum, Integer.parseInt(number), contact, Status.OPEN);
    }

    //Prompts all required parameters for the account creation
    private static Account promptAccount(String companyName, Contact contact, Opportunity opportunity) {
        //Output for prompt Account
        Buffer.resetPromptMessages();
        Buffer.initStringsRepository();
        Buffer.insertStringIntoRepository("New Account creation", 7);
        Scanner sc = new Scanner(System.in);
        String text = "Industries: Produce, Ecommerce, Manufacturing, Medical, Other";
        printItemPrompt(text);
        String industry = sc.nextLine().toLowerCase();
        //Keeps asking for the correct value
        while (!Validator.validateIndustry(industry)) {
            Buffer.setPromptLineOne("Enter a correct value:");
            printItemPrompt(text);
            Buffer.resetPromptOne();
            industry = sc.nextLine().toLowerCase();
        }
        Buffer.insertStringIntoRepository("Industry: " + industry, 10);
        Industry industryEnum = findIndustryEnum(industry);
        text = "Insert employee count: ";
        printItemPrompt(text);
        String employeeCount = sc.nextLine();
        //Keeps asking for the correct value
        while (!Validator.validateNumber(employeeCount)) {
            Buffer.setPromptLineOne("Enter a correct number of employees:");
            printItemPrompt(text);
            Buffer.resetPromptOne();
            employeeCount = sc.nextLine();
        }
        Buffer.insertStringIntoRepository("Number of employees: " + employeeCount, 11);
        text = "Insert city name:";
        printItemPrompt(text);
        String city = sc.nextLine();
        //Keeps asking for the correct value
        while (!Validator.validateName(city)) {
            Buffer.setPromptLineOne("Enter a correct value:");
            printItemPrompt(text);
            Buffer.resetPromptOne();
            city = sc.nextLine();
        }
        Buffer.insertStringIntoRepository("City name: " + city, 12);
        text = "Insert country: ";
        printItemPrompt(text);
        String country = sc.nextLine();
        //Keeps asking for the correct value
        while (!Validator.validateName(country)) {
            Buffer.setPromptLineOne("Enter a correct value:");
            printItemPrompt(text);
            Buffer.resetPromptOne();
            country = sc.nextLine();
        }
        Buffer.insertStringIntoRepository("Country: " + country, 13);
        printItemPrompt("New Account created - press INTRO");
        String retNext = sc.nextLine();
        return new Account(companyName, industryEnum, Integer.parseInt(employeeCount), city, country, contact, opportunity);
    }

    //Method that handles the lookup command
    public static void showObject(String objectType, int id) {
        //Searches an object, changing the parameter id to the format used in Storage
        Buffer.resetPromptMessages();
        Buffer.initStringsRepository();
        Buffer.setUpLayout();
        switch (objectType) {
            case "opportunity" -> {
                try {
                    Opportunity opportunity = opportunityRepository.findById(id).get();
                    Buffer.insertOpportunityStringRepository(opportunity, 1, 1);
                    Buffer.insertItemSolo();
                    Buffer.setPromptLineTwo("Lookup Opportunity - press INTRO");
                    Buffer.insertCentralPromptPoints(2);
                    Output.printScreen();
                    Scanner sc = new Scanner(System.in);
                    String next = sc.nextLine();
                } catch (IllegalArgumentException | NullPointerException | NoSuchElementException e) {
                    Buffer.setPromptLineTwo("Lookup Opportunity - press INTRO");
                    Buffer.insertCentralPromptPoints(2);
                    normalOneLinePrint("Opportunity with id " + id + " not found.");
                    Buffer.resetPromptMessages();
                }
            }
            case "lead" -> {
                try {
                    Lead lead = leadRepository.findById(id).get();
                    Buffer.insertLeadStringRepository(lead, 1, 1);
                    Buffer.insertItemSolo();
                    Buffer.setPromptLineTwo("Lookup Lead - press INTRO");
                    Buffer.insertCentralPromptPoints(2);
                    Output.printScreen();
                    Scanner sc = new Scanner(System.in);
                    String next = sc.nextLine();
                } catch (IllegalArgumentException | NullPointerException | NoSuchElementException e) {
                    Buffer.setPromptLineTwo("Lookup Lead - press INTRO");
                    Buffer.insertCentralPromptPoints(2);
                    normalOneLinePrint("Lead with id " + id + " not found.");
                    Buffer.resetPromptMessages();
                }
            }
            case "contact" -> {
                try {
                    Contact contact = contactRepository.findById(id).get();
                    Buffer.insertContactStringRepository(contact, 1, 1);
                    Buffer.insertItemSolo();
                    Buffer.setPromptLineTwo("Lookup Contact - press INTRO");
                    Buffer.insertCentralPromptPoints(2);
                    Output.printScreen();
                    Scanner sc = new Scanner(System.in);
                    String next = sc.nextLine();
                } catch (IllegalArgumentException | NullPointerException | NoSuchElementException e) {
                    Buffer.setPromptLineTwo("Lookup Contact - press INTRO");
                    Buffer.insertCentralPromptPoints(2);
                    normalOneLinePrint("Contact with id " + id + " not found.");
                    Buffer.resetPromptMessages();
                }
            }
            case "account" -> {
                try {
                    Account account = accountRepository.findById(id).get();
                    Buffer.insertAccountStringRepository(account, 1, 1);
                    Buffer.insertItemSolo();
                    Buffer.setPromptLineTwo("Lookup Account - press INTRO");
                    Buffer.insertCentralPromptPoints(2);
                    Output.printScreen();
                    Scanner sc = new Scanner(System.in);
                    String next = sc.nextLine();
                } catch (IllegalArgumentException | NullPointerException | NoSuchElementException e) {
                    Buffer.setPromptLineTwo("Lookup Account - press INTRO");
                    Buffer.insertCentralPromptPoints(2);
                    normalOneLinePrint("Account with id " + id + " not found.");
                    Buffer.resetPromptMessages();
                }
            }
            case "salesrep" -> {
                try {
                    SalesRep salesRep = salesRepRepository.findById(id).get();
                    Buffer.insertSalesRepStringRepository(salesRep, 1, 1);
                    Buffer.insertItemSolo();
                    Buffer.setPromptLineTwo("Lookup SalesRep - press INTRO");
                    Buffer.insertCentralPromptPoints(2);
                    Output.printScreen();
                    Scanner sc = new Scanner(System.in);
                    String next = sc.nextLine();
                } catch (IllegalArgumentException | NullPointerException | NoSuchElementException e) {
                    Buffer.setPromptLineTwo("Lookup SalesRep - press INTRO");
                    Buffer.insertCentralPromptPoints(2);
                    normalOneLinePrint("SalesRep with id " + id + " not found.");
                    Buffer.resetPromptMessages();
                }
            }
        }
    }

    //Closes an opportunity given an id and the status
    private static void closeOpportunity(int id, Status close) {
        Buffer.resetPromptMessages();
        Buffer.initStringsRepository();
        Buffer.setUpLayout();
        String text;
        try {
            //Searches an opportunity, changing the parameter id to the format used in Storage
            Opportunity opportunity = opportunityRepository.findById(id).get();
            //Compares the current value of status and it changes only if it's open
            if (opportunity.getStatus() == Status.OPEN) {
                opportunity.setStatus(close);
                opportunityRepository.save(opportunity);
                text = "Opportunity closed!";
                normalOneLinePrint(text);
            } else if (opportunity.getStatus() == Status.CLOSED_LOST) {
                text = "Opportunity already closed as lost.";
                normalOneLinePrint(text);
            } else if (opportunity.getStatus() == Status.CLOSED_WON) {
                text = "Opportunity already closed as won.";
                normalOneLinePrint(text);
            }
            //Return an error message if the id is not found
        } catch (IllegalArgumentException | NullPointerException | NoSuchElementException e) {
            text = "Opportunity with id " + id + " not found.";
            normalOneLinePrint(text);

        }
    }

    private static void normalOneLinePrint(String text) {
        Buffer.setPromptLineOne(text);
        Buffer.insertCentralPromptPoints(1);
        Output.printScreen();
        Buffer.resetPromptOne();
        Scanner sc = new Scanner(System.in);
        String next = sc.nextLine();
    }

    //Returns an enum depending on the String parameter
    private static Industry findIndustryEnum(String industry) {
        switch (industry) {
            case "produce" -> {
                return Industry.PRODUCE;
            }
            case "ecommerce" -> {
                return Industry.ECOMMERCE;
            }
            case "manufacturing" -> {
                return Industry.MANUFACTURING;
            }
            case "medical" -> {
                return Industry.MEDICAL;
            }
            case "other" -> {
                return Industry.OTHER;
            }
        }
        return null;
    }

    //Returns an enum depending on the String parameter
    private static Product findProductEnum(String product) {
        switch (product) {
            case "hybrid" -> {
                return Product.HYBRID;
            }
            case "flatbed" -> {
                return Product.FLATBED;
            }
            case "box" -> {
                return Product.BOX;
            }
        }
        return null;
    }

    //Prompts all required parameters for the SalesRep creation
    private static SalesRep promptSalesRep() {
        Buffer.initStringsRepository();
        Buffer.resetPromptMessages();
        Buffer.insertStringIntoRepository("New SalesRep creation", 7);
        String text = "Insert SalesRep name:";
        Scanner sc = new Scanner(System.in);
        printItemPrompt(text);
        String name = sc.nextLine();
        while (!Validator.validateName(name)) {
            Buffer.setPromptLineOne("Enter a correct name");
            printItemPrompt(text);
            Buffer.resetPromptOne();
            name = sc.nextLine();
        }
        Buffer.insertStringIntoRepository("Name: " + name, 11);
        printItemPrompt("SalesRep Created! - press INTRO");
        String nextRet = sc.nextLine();
        return new SalesRep(name);
    }

    //Prompts all required parameters for the lead creation
    private static Lead promptLead() {
        Buffer.initStringsRepository();
        Buffer.resetPromptMessages();
        Buffer.insertStringIntoRepository("New Lead creation", 7);
        String text = "Insert Lead name:";
        Scanner sc = new Scanner(System.in);
        printItemPrompt(text);
        String name = sc.nextLine();
        while (!Validator.validateName(name)) {
            Buffer.setPromptLineOne("Enter a correct name");
            printItemPrompt(text);
            Buffer.resetPromptOne();
            name = sc.nextLine();
        }
        Buffer.insertStringIntoRepository("Name: " + name, 11);
        text = "Insert Lead email: ";
        printItemPrompt(text);
        String email = sc.nextLine();
        while (!Validator.validateEmail(email)) {
            Buffer.setPromptLineOne("Enter a correct email"); //Be more specific with the format
            printItemPrompt(text);
            Buffer.resetPromptOne();
            email = sc.nextLine();
        }
        Buffer.insertStringIntoRepository("Email: " + email, 12);
        text = "Company name: ";
        printItemPrompt(text);
        String companyName = sc.nextLine();
        while (!Validator.validateCompanyName(companyName)) {
            Buffer.setPromptLineOne("Enter a correct company name"); //Be more specific with the format
            printItemPrompt(text);
            Buffer.resetPromptOne();
            companyName = sc.nextLine();
        }
        Buffer.insertStringIntoRepository("Company: " + companyName, 13);
        text = "Phone number: ";
        printItemPrompt(text);
        String phoneNumber = sc.nextLine();
        while (!Validator.validatePhoneNumber(phoneNumber)) {
            Buffer.setPromptLineOne("Enter a correct phone number"); //Be more specific with the format
            printItemPrompt(text);
            Buffer.resetPromptOne();
            phoneNumber = sc.nextLine();
        }
        Buffer.insertStringIntoRepository("Phone: " + phoneNumber, 14);
        //TODO SalesRep loop menu show-> show salesreps , correctid -> continue
        text = "SalesRep ID: ";
        printItemPrompt(text);
        String salesRepId = sc.nextLine();
        if (salesRepId.toLowerCase().startsWith("show ")) {
            showList("salesreps");
        } else {
            while (!Validator.validateNumber(salesRepId)) {
                if (salesRepId.startsWith("show")){
                    showList("salesreps");
                }
                Buffer.setPromptLineOne("Enter a correct SalesRep ID"); //Be more specific with the format
                printItemPrompt(text);
                Buffer.resetPromptOne();
                salesRepId = sc.nextLine();
            }
            while (!salesRepRepository.existsById(Integer.parseInt(salesRepId))) {
                if (salesRepId.startsWith("show")) {
                    showList("salesreps");
                }
                Buffer.setPromptLineOne("Enter a correct SalesRep ID"); //Be more specific with the format
                printItemPrompt(text);
                Buffer.resetPromptOne();
                salesRepId = sc.nextLine();
            }
        }
        Buffer.insertStringIntoRepository("SalesRep ID: " + salesRepId, 15);
        printItemPrompt("Lead Created! - press INTRO");
        String nextRet = sc.nextLine();
        return new Lead(name, email, companyName, phoneNumber, salesRepRepository.findById(Integer.parseInt(salesRepId)).get());
    }

    private static void printItemPrompt(String text) {
        Buffer.setPromptLineTwo(text);
        Buffer.insertCentralPromptPoints(1);
        Buffer.insertCentralPromptPoints(2);
        Buffer.insertItemSolo();
        Output.printScreen();
    }

    //Method that prints a list of leads
    private static void printLeadList(List<Lead> leadList, int index) {
        Buffer.resetScreenBuffer();
        Buffer.initStringsRepository();
        Buffer.resetPromptMessages();
        Buffer.setUpLayout();
        Buffer.insertItemList(6);

        int startingRepositoryIndex = 10;
        int finalCounter = index;
        for (int i = index; i < leadList.size() && i < index + 15; i++) {
            Buffer.insertStringIntoRepository(leadList.get(i).getIdToPrint(), startingRepositoryIndex++);
            Buffer.insertStringIntoRepository(leadList.get(i).getNameToPrint() + "  " +
                    leadList.get(i).getSalesRep().getIdToPrint(), startingRepositoryIndex++);
            finalCounter++;
        }
        if (finalCounter < leadList.size()) {
            Buffer.setPromptLineOne("Leads List");
            Buffer.insertCentralPromptPoints(1);
            Buffer.setPromptLineTwo("press INTRO to next page");
            printScreenBeforeAndPromptNext();
            printLeadList(leadList, finalCounter);
        } else if (leadList.size() == 0) {
            Buffer.setPromptLineTwo("Empty leads List - press INTRO");
            printScreenBeforeAndPromptNext();

        } else {
            Buffer.setPromptLineTwo("Leads List - press INTRO");
            printScreenBeforeAndPromptNext();
        }
    }

    private static void printScreenBeforeAndPromptNext() {
        Buffer.insertCentralPromptPoints(2);
        Output.printScreen();
        Scanner sc = new Scanner(System.in);
        String ret = sc.nextLine();
    }

    //Method that prints a list of opportunities
    private static void printOpportunityList(List<Opportunity> opportunityList, int index) {
        Buffer.resetScreenBuffer();
        Buffer.initStringsRepository();
        Buffer.resetPromptMessages();
        Buffer.setUpLayout();
        Buffer.insertItemList(6);

        int startingRepositoryIndex = 10;
        int finalCounter = index;
        for (int i = index; i < opportunityList.size() && i < index + 15; i++) {
            Buffer.insertStringIntoRepository(opportunityList.get(i).getIdToPrint(), startingRepositoryIndex++);
            Buffer.insertStringIntoRepository(opportunityList.get(i).getDecisionMaker().getNameToPrint() + "  " +
                    opportunityList.get(i).getSalesRep().getIdToPrint(), startingRepositoryIndex++);
            finalCounter++;
        }
        if (finalCounter < opportunityList.size()) {
            Buffer.setPromptLineOne("Opportunities List");
            Buffer.insertCentralPromptPoints(1);
            Buffer.setPromptLineTwo("press INTRO to next page");
            printScreenBeforeAndPromptNext();
            printOpportunityList(opportunityList, finalCounter);
        } else if (opportunityList.size() == 0) {
            Buffer.setPromptLineTwo("Empty Opportunities List - press INTRO");
            printScreenBeforeAndPromptNext();

        } else {
            Buffer.setPromptLineTwo("Opportunities List - press INTRO");
            printScreenBeforeAndPromptNext();
        }
    }

    //Method that prints a list of contacts
    private static void printContactList(List<Contact> contactList, int index) {
        Buffer.resetScreenBuffer();
        Buffer.initStringsRepository();
        Buffer.resetPromptMessages();
        Buffer.setUpLayout();
        Buffer.insertItemList(6);

        int startingRepositoryIndex = 10;
        int finalCounter = index;
        for (int i = index; i < contactList.size() && i < index + 15; i++) {
            Buffer.insertStringIntoRepository(contactList.get(i).getIdToPrint(), startingRepositoryIndex++);
            Buffer.insertStringIntoRepository(contactList.get(i).getNameToPrint(), startingRepositoryIndex++);
            finalCounter++;
        }
        if (finalCounter < contactList.size()) {
            Buffer.setPromptLineOne("Contacts List");
            Buffer.insertCentralPromptPoints(1);
            Buffer.setPromptLineTwo("press INTRO to next page");
            printScreenBeforeAndPromptNext();
            printContactList(contactList, finalCounter);
        } else if (contactList.size() == 0) {
            Buffer.setPromptLineTwo("Empty Contacts List - press INTRO");
            printScreenBeforeAndPromptNext();

        } else {
            Buffer.setPromptLineTwo("Contacts List - press INTRO");
            printScreenBeforeAndPromptNext();
        }
    }

    //Method that prints a list of accounts
    private static void printAccountList(List<Account> accountList, int index) {
        Buffer.resetScreenBuffer();
        Buffer.initStringsRepository();
        Buffer.resetPromptMessages();
        Buffer.setUpLayout();
        Buffer.insertItemList(6);

        int startingRepositoryIndex = 10;
        int finalCounter = index;
        for (int i = index; i < accountList.size() && i < index + 15; i++) {
            Buffer.insertStringIntoRepository(accountList.get(i).getIdToPrint(), startingRepositoryIndex++);
            Buffer.insertStringIntoRepository(accountList.get(i).getCompanyName(), startingRepositoryIndex++);
            finalCounter++;
        }
        if (finalCounter < accountList.size()) {
            Buffer.setPromptLineOne("Accounts List");
            Buffer.insertCentralPromptPoints(1);
            Buffer.setPromptLineTwo("press INTRO to next page");
            printScreenBeforeAndPromptNext();
            printAccountList(accountList, finalCounter);
        } else if (accountList.size() == 0) {
            Buffer.setPromptLineTwo("Accounts leads List - press INTRO");
            printScreenBeforeAndPromptNext();

        } else {
            Buffer.setPromptLineTwo("Accounts List - press INTRO");
            printScreenBeforeAndPromptNext();
        }
    }

    //Method that prints a list of accounts
    private static void printSalesRepList(List<SalesRep> salesRepList, int index) {
        Buffer.resetScreenBuffer();
        Buffer.initStringsRepository();
        Buffer.resetPromptMessages();
        Buffer.setUpLayout();
        Buffer.insertItemList(6);

        int startingRepositoryIndex = 10;
        int finalCounter = index;
        for (int i = index; i < salesRepList.size() && i < index + 15; i++) {
            Buffer.insertStringIntoRepository(salesRepList.get(i).getIdToPrint(), startingRepositoryIndex++);
            Buffer.insertStringIntoRepository(salesRepList.get(i).getNameToPrint(), startingRepositoryIndex++);
            finalCounter++;
        }
        if (finalCounter < salesRepList.size()) {
            Buffer.setPromptLineOne("SalesReps List");
            Buffer.insertCentralPromptPoints(1);
            Buffer.setPromptLineTwo("press INTRO to next page");
            printScreenBeforeAndPromptNext();
            printSalesRepList(salesRepList, finalCounter);
        } else if (salesRepList.size() == 0) {
            Buffer.setPromptLineTwo("SalesRep leads List - press INTRO");
            printScreenBeforeAndPromptNext();

        } else {
            Buffer.setPromptLineTwo("SalesRep List - press INTRO");
            printScreenBeforeAndPromptNext();
        }
    }

    private static void showReport(String stat, String criterion) {
        List<Object[]> result = new ArrayList<>();

        switch(criterion) {
            case "salesrep" -> {
                switch(stat) {
                    case "lead" -> { result = leadRepository.countOfLeadsBySalesReps(); }
                    case "opportunity" -> { result = opportunityRepository.countOfOpportunitiesBySalesReps(); }
                    case "closed-won" -> { result = opportunityRepository.countOfOpportunitiesBySalesRepsWhereClosedWon(); }
                    case "closed-lost" -> { result = opportunityRepository.countOfOpportunitiesBySalesRepsWhereClosedLost(); }
                    case "open" -> { result = opportunityRepository.countOfOpportunitiesBySalesRepsWhereOpen(); }
                }
            }
            case "product" -> {
                switch(stat) {
                    case "lead" -> { result = leadRepository.countOfLeadsByProduct(); }
                    case "opportunity" -> { result = opportunityRepository.countOfOpportunitiesByProduct(); }
                    case "closed-won" -> { result = opportunityRepository.countOfOpportunitiesByProductWhereClosedWon(); }
                    case "closed-lost" -> { result = opportunityRepository.countOfOpportunitiesByProductWhereClosedLost(); }
                    case "open" -> { result = opportunityRepository.countOfOpportunitiesByProductWhereOpen(); }
                }
            }
            case "country" -> {
                switch(stat) {
                    case "lead" -> { result = leadRepository.countOfLeadsByCountry(); }
                    case "opportunity" -> { result = opportunityRepository.countOfOpportuntiesByCountry(); }
                    case "closed-won" -> { result = opportunityRepository.countOfOpportuntiesByCountryWhereClosedWon(); }
                    case "closed-lost" -> { result = opportunityRepository.countOfOpportuntiesByCountryWhereClosedLost(); }
                    case "open" -> { result = opportunityRepository.countOfOpportuntiesByCountryWhereOpen(); }
                }
            }
            case "city" -> {
                switch(stat) {
                    case "lead" -> { result = leadRepository.countOfLeadsByCity(); }
                    case "opportunity" -> { result = opportunityRepository.countOfOpportuntiesByCity(); }
                    case "closed-won" -> { result = opportunityRepository.countOfOpportuntiesByCityWhereClosedWon(); }
                    case "closed-lost" -> { result = opportunityRepository.countOfOpportuntiesByCityWhereClosedLost(); }
                    case "open" -> { result = opportunityRepository.countOfOpportuntiesByCityWhereOpen(); }
                }
            }
            case "industry" -> {
                switch(stat) {
                    case "lead" -> { result = leadRepository.countOfLeadsByIndustry(); }
                    case "opportunity" -> { result = opportunityRepository.countOfOpportuntiesByIndustry(); }
                    case "closed-won" -> { result = opportunityRepository.countOfOpportuntiesByIndustryWhereClosedWon(); }
                    case "closed-lost" -> { result = opportunityRepository.countOfOpportuntiesByIndustryWhereClosedLost(); }
                    case "open" -> { result = opportunityRepository.countOfOpportuntiesByIndustryWhereOpen(); }
                }
            }
        }

        //TODO: Add the outputs
        if (result.size() > 50){
            String[] stringsRepository = new String[result.size() + 20];
            Arrays.fill(stringsRepository, "");
            Buffer.setStringsRepository(stringsRepository);
        }
        int startingStrIndex = 10;
        for (Object[] objects : result) {
            Buffer.insertStringIntoRepository((String) objects[0], startingStrIndex);
            Buffer.insertStringIntoRepository((String) objects[1], startingStrIndex);
//            System.out.println(objects[0] + " " + objects[1]);
        }
    }

    private static void showStats(String stat, String criterion) {
        double result = 0;
        switch (stat) {
            case "mean" -> {
                switch (criterion) {
                    case "employeecount" -> {
                        result = accountRepository.meanOfEmployeeCount();
                    }
                    case "quantity" -> {
                        result = opportunityRepository.meanOfQuantity();
                    }
                    case "opps" -> {
                        result = accountRepository.meanOfOpportunitiesOnAccounts();
                    }
                }
            }
            case "median" -> {
                switch (criterion) {
                    case "employeecount" -> {
                        result = accountRepository.medianOfEmployeeCount();
                    }
                    case "quantity" -> {
                        result = opportunityRepository.medianOfQuantity();
                    }
                    case "opps" -> {
                        result = accountRepository.medianOfOpportunitiesOnAccounts();
                    }
                }
            }
            case "max" -> {
                switch (criterion) {
                    case "employeecount" -> {
                        result = accountRepository.maxOfEmployeeCount();
                    }
                    case "quantity" -> {
                        result = opportunityRepository.maxOfQuantity();
                    }
                    case "opps" -> {
                        result = accountRepository.maxOfOpportunitiesOnAccounts();
                    }
                }
            }
            case "min" -> {
                switch (criterion) {
                    case "employeecount" -> {
                        result = accountRepository.minOfEmployeeCount();
                    }
                    case "quantity" -> {
                        result = opportunityRepository.minOfQuantity();
                    }
                    case "opps" -> {
                        result = accountRepository.minOfOpportunitiesOnAccounts();
                    }
                }
            }
        }

        //TODO: Add the outputs
        System.out.println(result);
    }

    //Method to create the command list for printing
    public static void setCommandList() {
        Buffer.insertStringIntoRepository("=====Command List=====", 40);
        Buffer.insertStringIntoRepository("", 41);
        Buffer.insertStringIntoRepository("NEW LEAD", 42);
        Buffer.insertStringIntoRepository("SHOW <ObjectInPlural>", 43);
        Buffer.insertStringIntoRepository("Show a list of objects", 44);
        Buffer.insertStringIntoRepository("CONVERT <Id>", 45);
        Buffer.insertStringIntoRepository("Convert Lead -> Opportunity", 46);
        Buffer.insertStringIntoRepository("LOOKUP <Object> <Id>", 47);
        Buffer.insertStringIntoRepository("Show an object", 48);
        Buffer.insertStringIntoRepository("CLOSE-WON <Id>", 49);
        Buffer.insertStringIntoRepository("Close Opportunity as won", 50);
        Buffer.insertStringIntoRepository("CLOSE-LOST <Id>", 51);
        Buffer.insertStringIntoRepository("Close Opportunity as lost", 52);
        Buffer.insertStringIntoRepository("HELP", 53);
        Buffer.insertStringIntoRepository("Shows more commands available", 54);
        Buffer.insertStringIntoRepository("EXIT", 55);
        Buffer.insertStringIntoRepository("Save and close the CRM", 56);
    }

    private static List<String> commandList;

    public static List<String> getCommandList() {
        return commandList;
    }

}
