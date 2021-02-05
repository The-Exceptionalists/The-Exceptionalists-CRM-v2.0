package com.ironhack.TheExceptionalistsCRMv20.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "sales_rep")
public class SalesRep {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    @OneToMany(mappedBy = "salesRep")
    List<Lead> leads;
    @OneToMany(mappedBy = "salesRep")
    List<Opportunity> opportunities;

    public SalesRep() {
    }

    public SalesRep(String name) {
        this.name = name;
    }

    public SalesRep(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getIdToPrint() {
        return "SalesRep Id: " + id;
    }

    public String getNameToPrint() {
        return "Name: " + name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Lead> getLeads() {
        return leads;
    }

    public void setLeads(List<Lead> leads) {
        this.leads = leads;
    }

    public List<Opportunity> getOpportunities() {
        return opportunities;
    }

    public void setOpportunities(List<Opportunity> opportunities) {
        this.opportunities = opportunities;
    }
}
