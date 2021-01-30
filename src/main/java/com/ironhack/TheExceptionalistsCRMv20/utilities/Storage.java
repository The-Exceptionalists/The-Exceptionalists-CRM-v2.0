package com.ironhack.TheExceptionalistsCRMv20.utilities;

import com.ironhack.TheExceptionalistsCRMv20.model.Account;
import com.ironhack.TheExceptionalistsCRMv20.model.Contact;
import com.ironhack.TheExceptionalistsCRMv20.model.Lead;
import com.ironhack.TheExceptionalistsCRMv20.model.Opportunity;
import com.ironhack.TheExceptionalistsCRMv20.enums.ItemType;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;


public class Storage {

    private static int id = 0;

    private static HashMap<String, Account> accountHashMap = new HashMap<>();
    private static HashMap<String, Contact> contactHashMap = new HashMap<>();
    private static HashMap<String, Lead> leadHashMap = new HashMap<>();
    private static HashMap<String, Opportunity> opportunityHashMap = new HashMap<>();

    /**
     * Add item to the correct hashmap
     *
     * @param item
     */
    public static void add(Account item) {
        ReadWriteLock reentrantLock = new ReentrantReadWriteLock();
        reentrantLock.writeLock();
        accountHashMap.put(item.getId(), item);
        reentrantLock.writeLock();
    }

    /**
     * Add item to the correct hashmap
     *
     * @param item
     */
    public static void add(Contact item) {
        ReadWriteLock reentrantLock = new ReentrantReadWriteLock();
        reentrantLock.writeLock();
        contactHashMap.put(item.getId(), item);
        reentrantLock.writeLock();
    }

    /**
     * Add item to the correct hashmap
     *
     * @param item
     */
    public static void add(Opportunity item) {
        ReadWriteLock reentrantLock = new ReentrantReadWriteLock();
        reentrantLock.writeLock();
        opportunityHashMap.put(item.getId(), item);
        reentrantLock.writeLock();
    }

    /**
     * Add item to the correct hashmap
     *
     * @param item
     */
    public static void add(Lead item) {
        ReadWriteLock reentrantLock = new ReentrantReadWriteLock();
        reentrantLock.writeLock();
        leadHashMap.put(item.getId(), item);
        reentrantLock.writeLock();
    }

    public static void setUpId() {
        ReadWriteLock reentrantLock = new ReentrantReadWriteLock();
        reentrantLock.writeLock();
        id++;
        reentrantLock.writeLock();
    }

    /**
     * Receive the updated version of an item and store it in the right place.
     *
     * @param item
     */
    public static void update(Account item) {
        if (accountHashMap.containsKey(item.getId()))
            accountHashMap.replace(item.getId(), item);
        else throw new IllegalArgumentException(item.getId() + " not found");
    }

    /**
     * Receive the updated version of an item and store it in the right place.
     *
     * @param item
     */
    public static void update(Contact item) {
        if (contactHashMap.containsKey(item.getId()))
            contactHashMap.replace(item.getId(), item);
        else throw new IllegalArgumentException(item.getId() + "not found");
    }

    /**
     * Receive the updated version of an item and store it in the right place.
     *
     * @param item
     */
    public static void update(Opportunity item) {
        if (opportunityHashMap.containsKey(item.getId()))
            opportunityHashMap.replace(item.getId(), item);
        else throw new IllegalArgumentException(item.getId() + "not found");
    }

    /**
     * Receive the updated version of an item and store it in the right place.
     *
     * @param item
     */
    public static void update(Lead item) {
        if (leadHashMap.containsKey(item.getId()))
            leadHashMap.replace(item.getId(), item);
        else throw new IllegalArgumentException(item.getId() + "not found");
    }


//    example on how it should be used work
//    if (idIsAccount(id)){ searchAccount(id)}

    /**
     * Search for an item and returns it
     *
     * @param id String id of item you are searching
     * @return
     */
    public static Account searchAccount(String id) {
        if (accountHashMap.containsKey(id))
            return accountHashMap.get(id);
        else throw new IllegalArgumentException(id + "not found");
    }

    /**
     * Search for an item and returns it
     *
     * @param id String id of item you are searching
     * @return
     */
    public static Contact searchContact(String id) {
        if (contactHashMap.containsKey(id))
            return contactHashMap.get(id);
        else throw new IllegalArgumentException(id + "not found");
    }

    /**
     * Search for an item and returns it
     *
     * @param id String id of item you are searching
     * @return
     */
    public static Opportunity searchOpportunity(String id) {
        if (opportunityHashMap.containsKey(id))
            return opportunityHashMap.get(id);
        else throw new IllegalArgumentException(id + "not found");

    }

    /**
     * Search for an item and returns it
     *
     * @param id String id of item you are searching
     * @return
     */
    public static Lead searchLead(String id) {
        if (leadHashMap.containsKey(id))
            return leadHashMap.get(id);
        else throw new IllegalArgumentException(id + "not found");

    }

    /**
     * Method to nullify a lead stored in the hashmap.
     *
     * @param id
     */
    public static void removeLead(String id) {
        if (leadHashMap.containsKey(id))
            leadHashMap.remove(id);
        else throw new IllegalArgumentException(id + "not found");
    }

    /**
     * All items of a type finder
     *
     * @return an ArrayList of all item of a type
     */
    public static List<Account> getAllAccounts() {
        Collection<Account> values = accountHashMap.values();
        return new ArrayList<>(values);
    }

    /**
     * All items of a type finder
     *
     * @return an ArrayList of all item of a type
     */
    public static List<Contact> getAllContacts() {
        Collection<Contact> values = contactHashMap.values();
        return new ArrayList<>(values);
    }

    /**
     * All items of a type finder
     *
     * @return an ArrayList of all item of a type
     */
    public static List<Opportunity> getAllOpportunities() {
        Collection<Opportunity> values = opportunityHashMap.values();
        return new ArrayList<>(values);
    }

    /**
     * All items of a type finder
     *
     * @return an ArrayList of all item of a type
     */
    public static List<Lead> getAllLeads() {
        Collection<Lead> values = leadHashMap.values();
        return new ArrayList<>(values);
    }


    /**
     * Return a unique id generated involving the item class
     *
     * @param itemType
     * @return
     */
    public static String getNewId(ItemType itemType) {
        String prefix = null;
        switch (itemType) {
            case LEAD -> prefix = "le";
            case ACCOUNT -> prefix = "ac";
            case CONTACT -> prefix = "co";
            case OPPORTUNITY -> prefix = "op";
        }
        Storage.id++;
        StringBuilder zeros = new StringBuilder();
        for (int i = 0; i < 10 - String.valueOf(id).length(); i++) {
            zeros.append("0");
        }
        return prefix + zeros + Storage.id;
    }

    public static boolean idIsAccount(String id) {
        return id.startsWith("ac") ? true : false;
    }

    public static boolean idIsContact(String id) {
        return id.startsWith("ct") ? true : false;
    }

    public static boolean idIsLead(String id) {
        return id.startsWith("le") ? true : false;
    }

    public static boolean idIsOpportunity(String id) {
        return id.startsWith("op") ? true : false;
    }

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        Storage.id = id;
    }

}
