package com.ironhack.TheExceptionalistsCRMv20.model;

import com.ironhack.TheExceptionalistsCRMv20.enums.Product;
import com.ironhack.TheExceptionalistsCRMv20.enums.Status;

import javax.persistence.*;

@Entity
@Table(name = "opportunities")
public class Opportunity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Enumerated(value = EnumType.STRING)
    private Product product;
    private int quantity;
    @OneToOne
    private Contact decisionMaker;
    @Enumerated(value = EnumType.STRING)
    private Status status;
    @ManyToOne
    private SalesRep salesRep;
    @ManyToOne
    private Account account;

    public Opportunity() {
    }

    public Opportunity(Integer id, Product product, int quantity, Contact decisionMaker, Status status) {
        setId(id);
        setProduct(product);
        setQuantity(quantity);
        setDecisionMaker(decisionMaker);
        setStatus(status);
    }


    //Constructor for a new Opportunity
    public Opportunity(Product product, int quantity, Contact decisionMaker, Status status, Account account, SalesRep salesRep) {
        setProduct(product);
        setQuantity(quantity);
        setDecisionMaker(decisionMaker);
        setStatus(status);
        setAccount(account);
        setSalesRep(salesRep);
    }

    public Opportunity(Integer id, Product product, int quantity, Contact decisionMaker, Status status, Account account, SalesRep salesRep) {
        setId(id);
        setProduct(product);
        setQuantity(quantity);
        setDecisionMaker(decisionMaker);
        setStatus(status);
        setAccount(account);
        setSalesRep(salesRep);
    }

    //Constructor for a new Opportunity
    public Opportunity(Product product, int quantity, Contact decisionMaker, Status status) {
        setProduct(product);
        setQuantity(quantity);
        setDecisionMaker(decisionMaker);
        setStatus(status);
    }

    //Getters and setters
    public Integer getId() {
        return id;
    }

    public String getIdToPrint() {
        return "Id: " + id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public String getProductToPrint() {
        return "Product: " + product.toString();
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getQuantityToPrint() {
        return "Quantity: " + quantity;
    }

    public void setQuantity(int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("The number of trucks must be greater than zero.");
        }
        this.quantity = quantity;
    }

    public Contact getDecisionMaker() {
        return decisionMaker;
    }

    public void setDecisionMaker(Contact decisionMaker) {
        this.decisionMaker = decisionMaker;
    }

    public Status getStatus() {
        return status;
    }

    public String getStatusToPrint() {
        return "Status: " + status.toString();
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public SalesRep getSalesRep() {
        return salesRep;
    }

    public void setSalesRep(SalesRep salesRep) {
        this.salesRep = salesRep;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
