package com.ironhack.TheExceptionalistsCRMv20.model;

import com.ironhack.TheExceptionalistsCRMv20.enums.ItemType;
import com.ironhack.TheExceptionalistsCRMv20.utilities.Storage;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@PrimaryKeyJoinColumn(name = "id")
@Table(name = "leads")
public class Lead extends Item{
    @ManyToOne
    private SalesRep salesRep;

    public Lead() {
    }

    //Constructor for a new Lead
    public Lead(String id, String name, String email, String companyName, String phoneNumber) {
        super(id, name, email, companyName, phoneNumber);
    }

    //Constructor for a new Lead
    public Lead(String name, String email, String companyName, String phoneNumber) {
        super(Storage.getNewId(ItemType.LEAD), name, email, companyName, phoneNumber);
    }

    //Constructor for a new Lead
    public Lead(String name, String email, String companyName, String phoneNumber, SalesRep salesRep) {
        super(Storage.getNewId(ItemType.LEAD), name, email, companyName, phoneNumber);
        setSalesRep(salesRep);
    }

    public SalesRep getSalesRep() {
        return salesRep;
    }

    public void setSalesRep(SalesRep salesRep) {
        this.salesRep = salesRep;
    }
}
