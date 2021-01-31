package com.ironhack.TheExceptionalistsCRMv20.repository;

import com.ironhack.TheExceptionalistsCRMv20.enums.Industry;
import com.ironhack.TheExceptionalistsCRMv20.enums.Product;
import com.ironhack.TheExceptionalistsCRMv20.enums.Status;
import com.ironhack.TheExceptionalistsCRMv20.model.Account;
import com.ironhack.TheExceptionalistsCRMv20.model.Contact;
import com.ironhack.TheExceptionalistsCRMv20.model.Opportunity;
import com.ironhack.TheExceptionalistsCRMv20.model.SalesRep;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class OpportunityRepositoryTest {

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    OpportunityRepository opportunityRepository;

    @Autowired
    ContactRepository contactRepository;

    @Autowired
    SalesRepRepository salesRepRepository;

    @BeforeEach
    void setUp() {
        Contact contact1 = contactRepository.save(new Contact("co001", "Pedro Luis",
                "pedro.luis@gmail.com", "IKEA", "666 333 222 111"));
        Contact contact2 = contactRepository.save(new Contact("co002", "Pedro Luis",
                "pedro.luis@gmail.com", "IKEA", "666 333 222 111"));
        Contact contact3 = contactRepository.save(new Contact("co003", "Pedro Luis",
                "pedro.luis@gmail.com", "IKEA", "666 333 222 111"));
        Contact contact4 = contactRepository.save(new Contact("co004", "Pedro Luis",
                "pedro.luis@gmail.com", "IKEA", "666 333 222 111"));
        SalesRep salesRep = salesRepRepository.save(new SalesRep("sr005", "María Aguilar"));
        Opportunity opportunity1 = opportunityRepository.save(new Opportunity("op006", Product.HYBRID, 10, contact1,
                Status.OPEN));
        Opportunity opportunity2 = opportunityRepository.save(new Opportunity("op007", Product.BOX, 20, contact2,
                Status.CLOSED_WON));
        Opportunity opportunity3 = opportunityRepository.save(new Opportunity("op008", Product.HYBRID, 25, contact3,
                Status.CLOSED_WON));
        Opportunity opportunity4 = opportunityRepository.save(new Opportunity("op009", Product.FLATBED, 30, contact4,
                Status.CLOSED_LOST));
        Account account = accountRepository.save(new Account("ac010", "IKEA", Industry.ECOMMERCE,
                200, "Madrid", "Spain", contact1, opportunity1));
        opportunity1.setAccount(account);
        opportunity1.setSalesRep(salesRep);
        opportunity1 = opportunityRepository.save(opportunity1);
        opportunity2.setAccount(account);
        opportunity2.setSalesRep(salesRep);
        opportunity2 = opportunityRepository.save(opportunity2);
        opportunity3.setAccount(account);
        opportunity3.setSalesRep(salesRep);
        opportunity3 = opportunityRepository.save(opportunity3);
        opportunity4.setAccount(account);
        opportunity4.setSalesRep(salesRep);
        opportunity4 = opportunityRepository.save(opportunity4);
        contact1.setAccount(account);
        contact1 = contactRepository.save(contact1);
        account.setContactList(List.of(contact1));
        account.setOpportunityList(List.of(opportunity1));
        contact2.setAccount(account);
        contact2 = contactRepository.save(contact2);
        account.setContactList(List.of(contact2));
        account.setOpportunityList(List.of(opportunity2));
        contact3.setAccount(account);
        contact3 = contactRepository.save(contact3);
        account.setContactList(List.of(contact3));
        account.setOpportunityList(List.of(opportunity3));
        contact4.setAccount(account);
        contact4 = contactRepository.save(contact4);
        account.setContactList(List.of(contact4));
        account.setOpportunityList(List.of(opportunity4));
        account = accountRepository.save(account);
    }

    @AfterEach
    void tearDown() {
        opportunityRepository.deleteAll();
        salesRepRepository.deleteAll();
        contactRepository.deleteAll();
        accountRepository.deleteAll();
    }

    @Test
    void countBySalesRep_salesRepExistingId_count() {
        assertEquals(4, opportunityRepository.countBySalesRepId("sr005"));
    }

    @Test
    void countBySalesRepName_salesRepExistingName_count() {
        assertEquals(4, opportunityRepository.countBySalesRepName("María Aguilar"));
    }

    @Test
    void countOfOpportunitiesBySalesReps_salesRepExistent_listOfNameAndCount() {
        List<Object[]> result = opportunityRepository.countOfOpportunitiesBySalesReps();
        assertEquals(1, result.size());
        assertEquals("María Aguilar", result.get(0)[0]);
        assertEquals(4L, result.get(0)[1]);
    }


    @Test
    void countOfOpportunitiesBySalesRepsWhereClosedWon_salesRepExistent_listOfNameAndCount() {
        List<Object[]> result = opportunityRepository.countOfOpportunitiesBySalesRepsWhereClosedWon();
        assertEquals(1, result.size());
        assertEquals("María Aguilar", result.get(0)[0]);
        assertEquals(2L, result.get(0)[1]);
    }

    @Test
    void countOfOpportunitiesBySalesRepsWhereClosedLost_salesRepExistent_listOfNameAndCount() {
        List<Object[]> result = opportunityRepository.countOfOpportunitiesBySalesRepsWhereClosedLost();
        assertEquals(1, result.size());
        assertEquals("María Aguilar", result.get(0)[0]);
        assertEquals(1L, result.get(0)[1]);
    }

    @Test
    void countOfOpportunitiesBySalesRepsWhereOpen_salesRepExistent_listOfNameAndCount() {
        List<Object[]> result = opportunityRepository.countOfOpportunitiesBySalesRepsWhereOpen();
        assertEquals(1, result.size());
        assertEquals("María Aguilar", result.get(0)[0]);
        assertEquals(1L, result.get(0)[1]);
    }

    @Test
    void countOfOpportunitiesByProduct_containsOpportunities_listOfProductAndCount() {
        List<Object[]> result = opportunityRepository.countOfOpportunitiesByProduct();
        assertEquals(3L, result.size());
        assertEquals(Product.HYBRID, result.get(0)[0]);
        assertEquals(2L, result.get(0)[1]);
        assertEquals(Product.BOX, result.get(1)[0]);
        assertEquals(1L, result.get(1)[1]);
        assertEquals(Product.FLATBED, result.get(2)[0]);
        assertEquals(1L, result.get(2)[1]);
    }

    @Test
    void countOfOpportunitiesByProductWhereClosedWon_containsOpportunities_listOfProductAndCount() {
        List<Object[]> result = opportunityRepository.countOfOpportunitiesByProductWhereClosedWon();
        assertEquals(2L, result.size());
        assertEquals(Product.BOX, result.get(0)[0]);
        assertEquals(1L, result.get(0)[1]);
        assertEquals(Product.HYBRID, result.get(1)[0]);
        assertEquals(1L, result.get(1)[1]);
    }

    @Test
    void countOfOpportunitiesByProductWhereClosedLost_containsOpportunities_listOfProductAndCount() {
        List<Object[]> result = opportunityRepository.countOfOpportunitiesByProductWhereClosedLost();
        assertEquals(1L, result.size());
        assertEquals(Product.FLATBED, result.get(0)[0]);
        assertEquals(1L, result.get(0)[1]);
    }

    @Test
    void countOfOpportunitiesByProductWhereOpen_containsOpportunities_listOfProductAndCount() {
        List<Object[]> result = opportunityRepository.countOfOpportunitiesByProductWhereOpen();
        assertEquals(1L, result.size());
        assertEquals(Product.HYBRID, result.get(0)[0]);
        assertEquals(1L, result.get(0)[1]);
    }

    @Test
    void countOfOpportuntiesByCountr_containsOpportunities_listOfProductAndCounty() {
        List<Object[]> result = opportunityRepository.countOfOpportuntiesByCountry();
        assertEquals(1, result.size());
        assertEquals("Spain", result.get(0)[0]);
        assertEquals(4L, result.get(0)[1]);
    }

    @Test
    void countOfOpportuntiesByCountryWhereClosedWon_containsOpportunities_listOfProductAndCount() {
        List<Object[]> result = opportunityRepository.countOfOpportuntiesByCountryWhereClosedWon();
        assertEquals(1, result.size());
        assertEquals("Spain", result.get(0)[0]);
        assertEquals(2L, result.get(0)[1]);
    }

    @Test
    void countOfOpportuntiesByCountryWhereClosedLost_containsOpportunities_listOfProductAndCount() {
        List<Object[]> result = opportunityRepository.countOfOpportuntiesByCountryWhereClosedLost();
        assertEquals(1, result.size());
        assertEquals("Spain", result.get(0)[0]);
        assertEquals(1L, result.get(0)[1]);

    }

    @Test
    void countOfOpportuntiesByCountryWhereOpen_containsOpportunities_listOfProductAndCount() {
        List<Object[]> result = opportunityRepository.countOfOpportuntiesByCountryWhereOpen();
        assertEquals(1, result.size());
        assertEquals("Spain", result.get(0)[0]);
        assertEquals(1L, result.get(0)[1]);
    }

    @Test
    void countOfOpportuntiesByCity_containsOpportunities_listOfProductAndCount() {
        List<Object[]> result = opportunityRepository.countOfOpportuntiesByCity();
        assertEquals(1, result.size());
        assertEquals("Madrid", result.get(0)[0]);
        assertEquals(4L, result.get(0)[1]);
    }

    @Test
    void countOfOpportuntiesByCityWhereClosedWon_containsOpportunities_listOfProductAndCount() {
        List<Object[]> result = opportunityRepository.countOfOpportuntiesByCityWhereClosedWon();
        assertEquals(1, result.size());
        assertEquals("Madrid", result.get(0)[0]);
        assertEquals(2L, result.get(0)[1]);
    }

    @Test
    void countOfOpportuntiesByCityWhereClosedLost_containsOpportunities_listOfProductAndCount() {
        List<Object[]> result = opportunityRepository.countOfOpportuntiesByCityWhereClosedLost();
        assertEquals(1, result.size());
        assertEquals("Madrid", result.get(0)[0]);
        assertEquals(1L, result.get(0)[1]);
    }

    @Test
    void countOfOpportuntiesByCityWhereOpen_containsOpportunities_listOfProductAndCount() {
        List<Object[]> result = opportunityRepository.countOfOpportuntiesByCityWhereOpen();
        assertEquals(1, result.size());
        assertEquals("Madrid", result.get(0)[0]);
        assertEquals(1L, result.get(0)[1]);
    }

    @Test
    void countOfOpportuntiesByIndustry_containsOpportunities_listOfProductAndCount() {
        List<Object[]> result = opportunityRepository.countOfOpportuntiesByIndustry();
        assertEquals(1, result.size());
        assertEquals(Industry.ECOMMERCE, result.get(0)[0]);
        assertEquals(4L, result.get(0)[1]);
    }

    @Test
    void countOfOpportuntiesByIndustryWhereClosedWon_containsOpportunities_listOfProductAndCount() {
        List<Object[]> result = opportunityRepository.countOfOpportuntiesByIndustryWhereClosedWon();
        assertEquals(1, result.size());
        assertEquals(Industry.ECOMMERCE, result.get(0)[0]);
        assertEquals(2L, result.get(0)[1]);
    }

    @Test
    void countOfOpportuntiesByIndustryWhereClosedLost_containsOpportunities_listOfProductAndCount() {
        List<Object[]> result = opportunityRepository.countOfOpportuntiesByIndustryWhereClosedLost();
        assertEquals(1, result.size());
        assertEquals(Industry.ECOMMERCE, result.get(0)[0]);
        assertEquals(1L, result.get(0)[1]);
    }

    @Test
    void countOfOpportuntiesByIndustryWhereOpen_containsOpportunities_listOfProductAndCount() {
        List<Object[]> result = opportunityRepository.countOfOpportuntiesByIndustryWhereOpen();
        assertEquals(1, result.size());
        assertEquals(Industry.ECOMMERCE, result.get(0)[0]);
        assertEquals(1L, result.get(0)[1]);
    }

    @Test
    public void meanOfQuantity_OpportunitiesSaved_Mean() {
        double mean = opportunityRepository.meanOfQuantity();

        assertEquals(21.25, mean);
    }

    @Test
    public void medianOfQuantity_OpportunitiesSaved_Median() {
        double median = opportunityRepository.medianOfQuantity();

        assertEquals(22.5, median);
    }

    @Test
    public void maxOfQuantity_OpportunitiesSaved_Max() {
        Integer max = opportunityRepository.maxOfQuantity();

        assertEquals(30, max);
    }

    @Test
    public void minOfQuantity_OpportunitiesSaved_Min() {
        Integer min = opportunityRepository.minOfQuantity();

        assertEquals(10, min);
    }
}
