package com.ironhack.TheExceptionalistsCRMv20.model;

import javax.persistence.*;

@Entity
@PrimaryKeyJoinColumn(name = "id")
@Table(name = "contacts")
public class Contact extends Item {
    @ManyToOne
    private Account account;

    @OneToOne(mappedBy = "decisionMaker")
    private Opportunity opportunity;

    public Contact() {
    }

    //Constructor for a new Contact
    public Contact(Integer id, String name, String email, String companyName, String phoneNumber) {
        super(id, name, email, companyName, phoneNumber);
    }

    //Constructor for a new Contact
    public Contact(String name, String email, String companyName, String phoneNumber) {
        super(name, email, companyName, phoneNumber);
    }

    //Constructor for a new Contact
    public Contact(String name, String email, String companyName, String phoneNumber, Account account) {
        super(name, email, companyName, phoneNumber);
        setAccount(account);
    }

    //Constructor for a new Contact
    public Contact(Integer id, String name, String email, String companyName, String phoneNumber, Account account) {
        super(id, name, email, companyName, phoneNumber);
        setAccount(account);
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
