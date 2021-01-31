package com.ironhack.TheExceptionalistsCRMv20.model;

import com.ironhack.TheExceptionalistsCRMv20.enums.Industry;
import com.ironhack.TheExceptionalistsCRMv20.enums.ItemType;
import com.ironhack.TheExceptionalistsCRMv20.utilities.Storage;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "accounts")
public class Account {

    @Id
    private String id;
    private String companyName;
    @Enumerated(value = EnumType.STRING)
    private Industry industry;
    private int employeeCount;
    private String city;
    private String country;
    @OneToMany(mappedBy = "account")
    private List<Contact> contactList = new ArrayList<>();
    @OneToMany(mappedBy = "account")
    private List<Opportunity> opportunityList = new ArrayList<>();

    public Account() {
    }

    public Account(String id, String companyName, Industry industry, int employeeCount, String city, String country) {
        setId(id);
        setCompanyName(companyName);
        setIndustry(industry);
        setEmployeeCount(employeeCount);
        setCity(city);
        setCountry(country);
    }

    public Account(String companyName, Industry industry, int employeeCount, String city, String country) {
        setId(Storage.getNewId(ItemType.ACCOUNT));
        setCompanyName(companyName);
        setIndustry(industry);
        setEmployeeCount(employeeCount);
        setCity(city);
        setCountry(country);
    }

    //Constructor for a new Account
    public Account(String companyName, Industry industry, int employeeCount, String city, String country, Contact contact, Opportunity opportunity) {
        setId(Storage.getNewId(ItemType.ACCOUNT));
        setCompanyName(companyName);
        setIndustry(industry);
        setEmployeeCount(employeeCount);
        setCity(city);
        setCountry(country);
        addContactToList(contact);
        addOpportunityToList(opportunity);
    }

    public Account(String id, String companyName, Industry industry, int employeeCount, String city, String country, Contact contact, Opportunity opportunity) {
        setId(id);
        setCompanyName(companyName);
        setIndustry(industry);
        setEmployeeCount(employeeCount);
        setCity(city);
        setCountry(country);
        addContactToList(contact);
        addOpportunityToList(opportunity);
    }

    //Methods
    private void addOpportunityToList(Opportunity opportunity) {
        opportunityList.add(opportunity);
    }

    private void addContactToList(Contact contact) {
        contactList.add(contact);
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

    public String getCompanyName() {
        return companyName;
    }

    public String getCompanyNameToPrint() {
        return "Company: " + companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Industry getIndustry() {
        return industry;
    }

    public String getIndustryToPrint() {
        return "Industry: " + industry.toString();
    }

    public void setIndustry(Industry industry) {
        this.industry = industry;
    }

    public int getEmployeeCount() {
        return employeeCount;
    }

    public String getEmployeeCountToPrint() {
        return "Employee Count: " + employeeCount;
    }

    public void setEmployeeCount(int employeeCount) {
        if (employeeCount <= 0) {
            throw new IllegalArgumentException("The employee count must be at least 1.");
        }
        this.employeeCount = employeeCount;
    }

    public String getCity() {
        return city;
    }

    public String getCityToPrint() {
        return "City: " + city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public String getCountryToPrint() {
        return "Country: " + country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<Contact> getContactList() {
        return contactList;
    }

    public void setContactList(List<Contact> contactList) {
        if (contactList.size() == 0) {
            throw new IllegalArgumentException("The contact list is empty!");
        }
        this.contactList = contactList;
    }

    public List<Opportunity> getOpportunityList() {
        return opportunityList;
    }

    public void setOpportunityList(List<Opportunity> opportunityList) {
        if (opportunityList.size() == 0) {
            throw new IllegalArgumentException("The opportunity list is empty!");
        }
        this.opportunityList = opportunityList;
    }

    public String toString() {

        return "Account{" +
                "id=" +
                ", companyName='" + companyName + '\'' +
                ", industry=" + industry +
                ", employeeCount=" + employeeCount +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", contactList=" + contactList +
                ", opportunityList=" + opportunityList +
                '}';
    }
}
