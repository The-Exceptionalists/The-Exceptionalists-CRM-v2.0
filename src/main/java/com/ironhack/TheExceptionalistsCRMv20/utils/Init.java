package com.ironhack.TheExceptionalistsCRMv20.utils;

import com.ironhack.TheExceptionalistsCRMv20.enums.*;
import com.ironhack.TheExceptionalistsCRMv20.model.*;
import com.ironhack.TheExceptionalistsCRMv20.repository.*;

public class Init {
    LeadRepository leadRepository;
    ContactRepository contactRepository;
    OpportunityRepository opportunityRepository;
    AccountRepository accountRepository;
    SalesRepRepository salesRepRepository;
    private static int id = 0;


    public void addLeads() {

        Account account = accountRepository.save(new Account(id++, "IKEA", Industry.ECOMMERCE,
                200, "Madrid", "Spain"));
        Account account2 = accountRepository.save(new Account(id++, "Muebles julian", Industry.PRODUCE,
                23, "Eisenach", "Germany"));

        Contact contact1 = contactRepository.save(new Contact(id++, "Pedro Luis",
                "pedro.luis@gmail.com", "IKEA", "666 333 222 111", account));
        Contact contact2 = contactRepository.save(new Contact(id++, "Jens Trittel",
                "pedro.luis@gmail.com", "IKEA", "666 333 222 111", account2));
        Contact contact3 = contactRepository.save(new Contact(id++, "Pedro Francisco",
                "pedro.luis@gmail.com", "IKEA", "666 333 222 111", account));

        SalesRep salesRep = salesRepRepository.save(new SalesRep(id++, "Maria Aguilar"));

        Opportunity opportunity1 = opportunityRepository.save(new Opportunity(id++, Product.HYBRID, 10, contact1,
                Status.OPEN, account, salesRep));
        Opportunity opportunity2 = opportunityRepository.save(new Opportunity(id++, Product.BOX, 10, contact2,
                Status.OPEN, account, salesRep));
        Opportunity opportunity3 = opportunityRepository.save(new Opportunity(id++, Product.FLATBED, 10, contact3,
                Status.OPEN, account, salesRep));
//        Opportunity opportunity4 = opportunityRepository.save(new Opportunity("op004",Product.FLATBED, 10, contact1,
//                Status.OPEN,  salesRep, account));

        Lead lead1 = leadRepository.save(new Lead(id++, "Pedro Luis",
                "pedro.luis@gmail.com", "IKEA", "666 333 222 111", salesRep));
        Lead lead2 = leadRepository.save(new Lead(id++, "Pedro Juan",
                "pedro.luis@gmail.comm", "Muebles bonicos", "666 333 222 1112", salesRep));
        Lead lead3 = leadRepository.save(new Lead(id++, "Pedro piedras",
                "pedro.luis@gmail.commm", "Mueblesfeos", "666 333 222 1113", salesRep));

    }

    public void addAccounts() {
        Contact contact1 = contactRepository.save(new Contact(id++, "Pedro Luis",
                "pedro.luis@gmail.com", "IKEA", "666 333 222 111"));
        Contact contact2 = contactRepository.save(new Contact(id++, "Pedro Luis",
                "pedro.luis@gmail.com", "IKEA", "666 333 222 111"));
        Contact contact3 = contactRepository.save(new Contact(id++, "Pedro Luis",
                "pedro.luis@gmail.com", "IKEA", "666 333 222 111"));
        Contact contact4 = contactRepository.save(new Contact(id++, "Pedro Luis",
                "pedro.luis@gmail.com", "IKEA", "666 333 222 111"));
        SalesRep salesRep = salesRepRepository.save(new SalesRep(id++, "María Aguilar"));
        Opportunity opportunity1 = opportunityRepository.save(new Opportunity(id++, Product.HYBRID, 10, contact1,
                Status.OPEN));
        Opportunity opportunity2 = opportunityRepository.save(new Opportunity(id++, Product.BOX, 20, contact2,
                Status.CLOSED_WON));
        Opportunity opportunity3 = opportunityRepository.save(new Opportunity(id++, Product.HYBRID, 25, contact3,
                Status.CLOSED_WON));
        Opportunity opportunity4 = opportunityRepository.save(new Opportunity(id++, Product.FLATBED, 30, contact4,
                Status.CLOSED_LOST));
        Account account = accountRepository.save(new Account(id++, "IKEA", Industry.ECOMMERCE,
                200, "Madrid", "Spain", contact1, opportunity1));
        opportunity1.setAccount(account);
        opportunity1.setSalesRep(salesRep);
        opportunityRepository.save(opportunity1);
        opportunity2.setAccount(account);
        opportunity2.setSalesRep(salesRep);
        opportunityRepository.save(opportunity2);
        opportunity3.setAccount(account);
        opportunity3.setSalesRep(salesRep);
        opportunityRepository.save(opportunity3);
        opportunity4.setAccount(account);
        opportunity4.setSalesRep(salesRep);
        opportunityRepository.save(opportunity4);
        contact1.setAccount(account);
        contactRepository.save(contact1);
        contact2.setAccount(account);
        contactRepository.save(contact2);
        contact3.setAccount(account);
        contactRepository.save(contact3);
        contact4.setAccount(account);
        contactRepository.save(contact4);
    }

    public Init(LeadRepository leadRepository, ContactRepository contactRepository, OpportunityRepository opportunityRepository, AccountRepository accountRepository, SalesRepRepository salesRepRepository) {
        this.leadRepository = leadRepository;
        this.contactRepository = contactRepository;
        this.opportunityRepository = opportunityRepository;
        this.accountRepository = accountRepository;
        this.salesRepRepository = salesRepRepository;
    }
}
