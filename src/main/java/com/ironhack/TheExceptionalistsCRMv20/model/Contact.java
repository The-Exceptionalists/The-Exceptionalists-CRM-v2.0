package com.ironhack.TheExceptionalistsCRMv20.model;

import com.ironhack.TheExceptionalistsCRMv20.enums.ItemType;
import com.ironhack.TheExceptionalistsCRMv20.utilities.Storage;

import javax.persistence.*;

@Entity
@PrimaryKeyJoinColumn(name = "id")
@Table(name = "contacts")
public class Contact extends Item{
    @ManyToOne
    private Account account;

    @OneToOne(mappedBy = "decisionMaker")
    private Opportunity opportunity;

    public Contact() {
    }

    //Constructor for a new Contact
    public Contact(String id, String name, String email, String companyName, String phoneNumber) {
        super(id, name, email, companyName, phoneNumber);
    }

    //Constructor for a new Contact
    public Contact(String name, String email, String companyName, String phoneNumber, Account account) {
        super(Storage.getNewId(ItemType.CONTACT),name, email, companyName, phoneNumber);
        setAccount(account);
    }
    //Constructor para test

    public Contact(String id, String name, String email, String companyName, String phoneNumber, Account account) {
        super(id, name, email, companyName, phoneNumber);
        this.account = account;
    }

    //Constructor for a new Contact
    public Contact(String name, String email, String companyName, String phoneNumber) {
        super(Storage.getNewId(ItemType.CONTACT),name, email, companyName, phoneNumber);
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Opportunity getOpportunity() {
        return opportunity;
    }

    public void setOpportunity(Opportunity opportunity) {
        this.opportunity = opportunity;
    }
}
