package com.ironhack.TheExceptionalistsCRMv20.classes;

import com.ironhack.TheExceptionalistsCRMv20.enums.ItemType;
import com.ironhack.TheExceptionalistsCRMv20.utilities.Storage;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "id")
public class Lead extends Item{

    public Lead() {
    }

    //Constructor for a new Lead
    public Lead(String name, String email, String companyName, String phoneNumber) {
        super(Storage.getNewId(ItemType.LEAD), name, email, companyName, phoneNumber);
    }
}
