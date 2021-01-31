package com.ironhack.TheExceptionalistsCRMv20.repository;

import com.ironhack.TheExceptionalistsCRMv20.enums.Industry;
import com.ironhack.TheExceptionalistsCRMv20.enums.Product;
import com.ironhack.TheExceptionalistsCRMv20.enums.Status;
import com.ironhack.TheExceptionalistsCRMv20.model.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class LeadRepositoryTest {

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    ContactRepository contactRepository;

    @Autowired
    SalesRepRepository salesRepRepository;

    @Autowired
    OpportunityRepository opportunityRepository;

    @Autowired
    LeadRepository leadRepository;

    @BeforeEach
    void setUp() {


        Account account = accountRepository.save(new Account( "IKEA", Industry.ECOMMERCE,
                200, "Madrid", "Spain"));

        Contact contact1 = contactRepository.save(new Contact("Pedro Luis",
                "pedro.luis@gmail.com", "IKEA", "666 333 222 111", account));

        SalesRep salesRep = salesRepRepository.save(new SalesRep("sr005", "María Aguilar"));

        Opportunity opportunity1 = opportunityRepository.save(new Opportunity(Product.HYBRID, 10, contact1,
                Status.OPEN, account, salesRep));

        Lead lead1 = leadRepository.save(new Lead("Pedro Luis",
                "pedro.luis@gmail.com", "IKEA", "666 333 222 111", salesRep));

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
    void sometest(){

    }
//    @Test
//    void countBySalesRep_salesRepExistingId_count() {
//        assertEquals(4, leadRepository.countBySalesRepId("sr005"));
//    }
//
//    @Test
//    void countBySalesRepName_salesRepExistingName_count() {
//        assertEquals(4, opportunityRepository.countBySalesRepName("María Aguilar"));
//    }

//    @Test
//    void countOfLeadsBySalesReps_salesRepExistent_listOfNameAndCount() {
//        List<Object[]> result = leadRepository.countOfLeadsBySalesReps();
//        assertEquals(1, result.size());
//        assertEquals("María Aguilar", result.get(0)[0]);
//        assertEquals(4L, result.get(0)[1]);
//    }
//
//    @Test
//    void countOfOpportunitiesByProduct_containsOpportunities_listOfProductAndCount() {
//        List<Object[]> result = opportunityRepository.countOfOpportunitiesByProduct();
//        assertEquals(3L, result.size());
//        assertEquals(Product.HYBRID, result.get(0)[0]);
//        assertEquals(2L, result.get(0)[1]);
//        assertEquals(Product.BOX, result.get(1)[0]);
//        assertEquals(1L, result.get(1)[1]);
//        assertEquals(Product.FLATBED, result.get(2)[0]);
//        assertEquals(1L, result.get(2)[1]);
//    }
//
//    @Test
//    void countOfOpportuntiesByCountry_containsOpportunities_listOfProductAndCounty() {
//        List<Object[]> result = opportunityRepository.countOfOpportuntiesByCountry();
//        assertEquals(1, result.size());
//        assertEquals("Spain", result.get(0)[0]);
//        assertEquals(4L, result.get(0)[1]);
//    }
//
//    @Test
//    void countOfOpportuntiesByCity_containsOpportunities_listOfProductAndCount() {
//        List<Object[]> result = opportunityRepository.countOfOpportuntiesByCity();
//        assertEquals(1, result.size());
//        assertEquals("Madrid", result.get(0)[0]);
//        assertEquals(4L, result.get(0)[1]);
//    }
//
//    @Test
//    void countOfOpportuntiesByCityWhereOpen_containsOpportunities_listOfProductAndCount() {
//        List<Object[]> result = opportunityRepository.countOfOpportuntiesByCityWhereOpen();
//        assertEquals(1, result.size());
//        assertEquals("Madrid", result.get(0)[0]);
//        assertEquals(1L, result.get(0)[1]);
//    }
//
//    @Test
//    void countOfOpportuntiesByIndustry_containsOpportunities_listOfProductAndCount() {
//        List<Object[]> result = opportunityRepository.countOfOpportuntiesByIndustry();
//        assertEquals(1, result.size());
//        assertEquals(Industry.ECOMMERCE, result.get(0)[0]);
//        assertEquals(4L, result.get(0)[1]);
//    }
//


}