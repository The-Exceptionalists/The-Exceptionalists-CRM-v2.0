package com.ironhack.TheExceptionalistsCRMv20.repository;

import com.ironhack.TheExceptionalistsCRMv20.ConsoleApp;
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
import org.springframework.boot.test.mock.mockito.MockBean;


import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class AccountRepositoryTest {

    @MockBean
    private ConsoleApp consoleApp;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private OpportunityRepository opportunityRepository;

    @Autowired
    private ContactRepository contactRepository;

    @Autowired
    private SalesRepRepository salesRepRepository;

    @BeforeEach
    public void setUp() {
        Contact contact1 = contactRepository.save(new Contact(1, "Pedro Luis",
                "pedro.luis@gmail.com", "IKEA", "666 333 222 111"));
        Contact contact2 = contactRepository.save(new Contact(2, "Raquel García",
                "raquel.garcia@gmail.com", "CocaCola", "666 999 888 777"));
        Contact contact3 = contactRepository.save(new Contact(10, "Alvaro Rodríguez",
                "alvaro.rodriguez@gmail.com", "IKEA", "666 000 555 444"));

        SalesRep salesRep1 = salesRepRepository.save(new SalesRep(3, "María Aguilar"));
        SalesRep salesRep2 = salesRepRepository.save(new SalesRep(4, "Juan Delgado"));

        Opportunity opportunity1 = opportunityRepository.save(new Opportunity(5, Product.HYBRID, 10, contact1,
                Status.OPEN));
        Opportunity opportunity2 = opportunityRepository.save(new Opportunity(6, Product.FLATBED, 5, contact2,
                Status.OPEN));
        Opportunity opportunity3 = opportunityRepository.save(new Opportunity(9, Product.BOX, 10, contact3,
                Status.OPEN));

        Account account1 = accountRepository.save(new Account(7, "IKEA", Industry.ECOMMERCE,
                200, "Madrid", "Spain", contact1, opportunity1));
        Account account2 = accountRepository.save(new Account(8, "CocaCola", Industry.PRODUCE,
                300, "Barcelona", "Spain", contact2, opportunity2));

        opportunity1.setAccount(account1);
        opportunity1.setSalesRep(salesRep1);
        opportunity2.setAccount(account2);
        opportunity2.setSalesRep(salesRep2);
        opportunity3.setAccount(account2);
        opportunity3.setSalesRep(salesRep2);
        opportunity1 = opportunityRepository.save(opportunity1);
        opportunity2 = opportunityRepository.save(opportunity2);
        opportunity3 = opportunityRepository.save(opportunity3);
        contact1.setAccount(account1);
        contact1 = contactRepository.save(contact1);
        contact2.setAccount(account2);
        contact2 = contactRepository.save(contact2);
        contact3.setAccount(account2);
        contact3 = contactRepository.save(contact3);
    }

    @AfterEach
    public void tearDown() {
        opportunityRepository.deleteAll();
        salesRepRepository.deleteAll();
        contactRepository.deleteAll();
        accountRepository.deleteAll();
    }

    @Test
    public void save_ContactSalesRepOpportunityAccount_SavedCorrectly() {
        Optional<Account> account = accountRepository.findByIdWithContact(7);

        assertEquals("IKEA", account.get().getCompanyName());
        assertEquals("pedro.luis@gmail.com", account.get().getContactList().get(0).getEmail());
    }

    @Test
    public void meanOfEmployeeCount_AccountsSaved_Mean() {
        double mean = accountRepository.meanOfEmployeeCount();

        assertEquals(250, mean);
    }

    @Test
    public void medianOfEmployeeCount_AccountsSaved_Median() {
        double median = accountRepository.medianOfEmployeeCount();

        assertEquals(250, median);
    }

    @Test
    public void maxOfEmployeeCount_AccountsSaved_Max() {
        Integer max = accountRepository.maxOfEmployeeCount();

        assertEquals(300, max);
    }

    @Test
    public void minOfEmployeeCount_AccountsSaved_Min() {
        Integer min = accountRepository.minOfEmployeeCount();

        assertEquals(200, min);
    }

    @Test
    public void meanOfOpportunitiesOnAccounts_AccountsSaved_Mean() {
        double mean = accountRepository.meanOfOpportunitiesOnAccounts();

        assertEquals(1.5, mean);
    }

    @Test
    public void medianOfOpportunitiesOnAccounts_AccountsSaved_Median() {
        double median = accountRepository.medianOfOpportunitiesOnAccounts();

        assertEquals(1.5, median);
    }

    @Test
    public void maxOfOpportunitiesOnAccounts_AccountsSaved_Max() {
        Integer max = accountRepository.maxOfOpportunitiesOnAccounts();

        assertEquals(2, max);
    }

    @Test
    public void minOfOpportunitiesOnAccounts_AccountsSaved_Min() {
        Integer min = accountRepository.minOfOpportunitiesOnAccounts();

        assertEquals(1, min);
    }
}
