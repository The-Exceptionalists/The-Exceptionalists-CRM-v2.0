package com.ironhack.TheExceptionalistsCRMv20.classes;

import com.ironhack.TheExceptionalistsCRMv20.enums.ItemType;
import com.ironhack.TheExceptionalistsCRMv20.utilities.Storage;
import com.ironhack.TheExceptionalistsCRMv20.utils.Validator;

public class Contact {
    //Properties
    private String id;
    private String name;
    private String email;
    private String companyName;
    private String phoneNumber;

    //Constructor for the database
    public Contact(String id, String name, String email, String companyName, String phoneNumber) {
        setId(id);
        setName(name);
        setEmail(email);
        setCompanyName(companyName);
        setPhoneNumber(phoneNumber);
    }

    //Constructor for a new Contact
    public Contact(String name, String email, String companyName, String phoneNumber) {
        setId(Storage.getNewId(ItemType.CONTACT));
        setName(name);
        setEmail(email);
        setCompanyName(companyName);
        setPhoneNumber(phoneNumber);
    }

    //Getters and setters
    public String getId() {
        return id;
    }

    public String getIdToPrint() {
        //Shows only the part of the id string that the user needs to see
        char[] idArray = id.toCharArray();
        int charCount = 0;
        for (int i = 2; i < idArray.length; i++) {
            if (idArray[i] != '0') {
                charCount = i;
                break;
            }
        }
        return "Id: " + id.substring(charCount);
    }

    public void setId(String id) {
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

    public void setPhoneNumber(String phoneNumber) {
        if (!Validator.validatePhoneNumber(phoneNumber)) throw new IllegalArgumentException();

        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumberToPrint() {
        return "Phone: " + phoneNumber;
    }

    public String toString() {
        //Shows only the part of the id string that the user needs to see
        char[] idArray = id.toCharArray();
        int charCount = 0;
        for (int i = 2; i < idArray.length; i++) {
            if (idArray[i] != '0') {
                charCount = i;
                break;
            }
        }
        return "Contact{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", companyName='" + companyName + '\'' +
                ", phoneNum='" + phoneNumber + '\'' +
                '}';
    }
}
