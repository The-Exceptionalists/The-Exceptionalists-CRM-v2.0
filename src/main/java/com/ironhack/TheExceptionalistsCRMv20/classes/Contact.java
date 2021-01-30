package com.ironhack.TheExceptionalistsCRMv20.classes;

import com.ironhack.TheExceptionalistsCRMv20.enums.ItemType;
import com.ironhack.TheExceptionalistsCRMv20.utilities.Storage;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "id")
public class Contact extends Item{

    public Contact() {
    }

    //Constructor for a new Contact
    public Contact(String name, String email, String companyName, String phoneNumber) {
        super(Storage.getNewId(ItemType.CONTACT),name, email, companyName, phoneNumber);
    }

}
