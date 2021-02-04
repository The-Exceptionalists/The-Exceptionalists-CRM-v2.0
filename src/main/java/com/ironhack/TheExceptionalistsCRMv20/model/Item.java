package com.ironhack.TheExceptionalistsCRMv20.model;

import com.ironhack.TheExceptionalistsCRMv20.utils.Validator;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "items")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String email;
    private String companyName;
    private String phoneNumber;

    public Item() {
    }

    public Item(String name, String email, String companyName, String phoneNumber) {
        this.name = name;
        this.email = email;
        this.companyName = companyName;
        this.phoneNumber = phoneNumber;
    }

    public Item(Integer id, String name, String email, String companyName, String phoneNumber) {
        setId(id);
        setName(name);
        setEmail(email);
        setCompanyName(companyName);
        setPhoneNumber(phoneNumber);
    }


    public Integer getId() {
        return id;
    }

    public String getIdToPrint() {
        return "Id: " + id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getNameToPrint() {
        return "Name: " + name;
    }

    public void setName(String name) {
        if (!Validator.validateName(name))
            throw new IllegalArgumentException("Name must be between 1 and 31 characters");
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public String getEmailToPrint() {
        return "Email: " + email;
    }

    public void setEmail(String email) {
        if (!Validator.validateEmail(email)) throw new IllegalArgumentException();
        this.email = email;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getCompanyNameToPrint() {
        return "Company: " + companyName;
    }

    public void setCompanyName(String companyName) {
        if (!Validator.validateCompanyName(companyName))
            throw new IllegalArgumentException("Company name must be between 1 and 31 characters");
        this.companyName = companyName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getPhoneNumberToPrint() {
        return "Phone: " + phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        if (!Validator.validatePhoneNumber(phoneNumber)) throw new IllegalArgumentException();

        this.phoneNumber = phoneNumber;
    }
}
