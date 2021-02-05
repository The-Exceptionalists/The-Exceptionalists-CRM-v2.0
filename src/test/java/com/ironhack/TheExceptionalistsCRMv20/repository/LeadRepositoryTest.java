package com.ironhack.TheExceptionalistsCRMv20.repository;

import com.ironhack.TheExceptionalistsCRMv20.ConsoleApp;
import com.ironhack.TheExceptionalistsCRMv20.enums.Industry;
import com.ironhack.TheExceptionalistsCRMv20.enums.Product;
import com.ironhack.TheExceptionalistsCRMv20.enums.Status;
import com.ironhack.TheExceptionalistsCRMv20.model.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.math.BigInteger;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class LeadRepositoryTest {

    @MockBean
    private ConsoleApp consoleApp;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private ContactRepository contactRepository;

    @Autowired
    private SalesRepRepository salesRepRepository;

    @Autowired
    private OpportunityRepository opportunityRepository;

    @Autowired
    private LeadRepository leadRepository;

    @BeforeEach
    void setUp() {


        Account account = accountRepository.save(new Account(001, "IKEA", Industry.ECOMMERCE,
                200, "Madrid", "Spain"));
        Account account2 = accountRepository.save(new Account(002, "Muebles julian", Industry.PRODUCE,
                23, "Eisenach", "Germany"));

        Contact contact1 = contactRepository.save(new Contact(001, "Pedro Luis",
                "pedro.luis@gmail.com", "IKEA", "666 333 222 111", account));
        Contact contact2 = contactRepository.save(new Contact(002, "Jens Trittel",
                "pedro.luis@gmail.com", "IKEA", "666 333 222 111", account2));
        Contact contact3 = contactRepository.save(new Contact(003, "Pedro Francisco",
                "pedro.luis@gmail.com", "IKEA", "666 333 222 111", account));

        SalesRep salesRep = salesRepRepository.save(new SalesRep(005, "Maria Aguilar"));

        Opportunity opportunity1 = opportunityRepository.save(new Opportunity(001, Product.HYBRID, 10, contact1,
                Status.OPEN, account, salesRep));
        Opportunity opportunity2 = opportunityRepository.save(new Opportunity(002, Product.BOX, 10, contact2,
                Status.OPEN, account, salesRep));
        Opportunity opportunity3 = opportunityRepository.save(new Opportunity(003, Product.FLATBED, 10, contact3,
                Status.OPEN, account, salesRep));
//        Opportunity opportunity4 = opportunityRepository.save(new Opportunity("op004",Product.FLATBED, 10, contact1,
//                Status.OPEN,  salesRep, account));

        Lead lead1 = leadRepository.save(new Lead(001, "Pedro Luis",
                "pedro.luis@gmail.com", "IKEA", "666 333 222 111", salesRep));
        Lead lead2 = leadRepository.save(new Lead(002, "Pedro Juan",
                "pedro.luis@gmail.comm", "Muebles bonicos", "666 333 222 1112", salesRep));
        Lead lead3 = leadRepository.save(new Lead(003, "Pedro piedras",
                "pedro.luis@gmail.commm", "Mueblesfeos", "666 333 222 1113", salesRep));

    }

    @AfterEach
    void tearDown() {
        leadRepository.deleteAll();
        opportunityRepository.deleteAll();
        salesRepRepository.deleteAll();
        contactRepository.deleteAll();
        accountRepository.deleteAll();
    }


    @Test
    void countOfLeadsBySalesReps_salesRepExistent_listOfNameAndCount() {

        List<Object[]> result = leadRepository.countOfLeadsBySalesReps();
        assertEquals(1, result.size());
        assertEquals("Maria Aguilar", result.get(0)[0]);
        assertEquals(3L, result.get(0)[1]);
    }

    @Test
    void countOfLeadsByProduct_containsLeads_listOfProductAndCountOfLeads() {
        List<Object[]> result = leadRepository.countOfLeadsByProduct();
        assertEquals(3, result.size());
        assertEquals(Product.BOX.toString(), result.get(0)[0]);
        assertEquals(new BigInteger("3"), result.get(0)[1]);
        assertEquals(Product.FLATBED.toString(), result.get(1)[0]);
        assertEquals(new BigInteger("3"), result.get(1)[1]);
        assertEquals(Product.HYBRID.toString(), result.get(2)[0]);
        assertEquals(new BigInteger("3"), result.get(2)[1]);
    }

    @Test
    void countOfLeadsByCountry_containsLeads_listOfLeadAndCounty() {
        List<Object[]> result = leadRepository.countOfLeadsByCountry();
        assertEquals(1, result.size());
        assertEquals("Spain", result.get(0)[0]);
        assertEquals(new BigInteger("9"), result.get(0)[1]);
    }

    @Test
    void countOfLeadsByCity_containsLeads_listOfProductAndCount() {
        List<Object[]> result = leadRepository.countOfLeadsByCity();
        assertEquals(1, result.size());
        assertEquals("Madrid", result.get(0)[0]);
        assertEquals(new BigInteger("9"), result.get(0)[1]);
    }

    @Test
    void countOfLeadByIndustry_containsLeads_listOfProductAndCount() {
        List<Object[]> result = leadRepository.countOfLeadsByIndustry();
        assertEquals(1, result.size());
        assertEquals(Industry.ECOMMERCE.toString(), result.get(0)[0]);
        assertEquals(new BigInteger("9"), result.get(0)[1]);
    }


}
