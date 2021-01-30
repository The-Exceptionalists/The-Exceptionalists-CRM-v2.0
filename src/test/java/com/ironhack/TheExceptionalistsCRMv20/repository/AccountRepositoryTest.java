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
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AccountRepositoryTest {

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    OpportunityRepository opportunityRepository;

    @Autowired
    ContactRepository contactRepository;

    @Autowired
    SalesRepRepository salesRepRepository;

    @BeforeEach
    public void setUp() {
        Contact contact = contactRepository.save(new Contact("co001", "Pedro Luis",
                "pedro.luis@gmail.com", "IKEA", "666 333 222 111"));
        SalesRep salesRep = salesRepRepository.save(new SalesRep("sr002", "María Aguilar"));
        Opportunity opportunity = opportunityRepository.save(new Opportunity("op003", Product.HYBRID, 10, contact,
                Status.OPEN));
        Account account = accountRepository.save(new Account("ac004", "IKEA", Industry.ECOMMERCE,
                200, "Madrid", "Spain", contact, opportunity));
        opportunity.setAccount(account);
        opportunity.setSalesRep(salesRep);
        opportunity = opportunityRepository.save(opportunity);
        contact.setAccount(account);
        contact = contactRepository.save(contact);
        account.setContactList(List.of(contact));
        account.setOpportunityList(List.of(opportunity));
        account = accountRepository.save(account);
    }

    @AfterEach
    public void tearDown() {
        contactRepository.deleteAll();
        opportunityRepository.deleteAll();
        salesRepRepository.deleteAll();
        accountRepository.deleteAll();
    }

    @Test
    public void save_ContactSalesRepOpportunityAccount_SavedCorrectly() {
        Optional<Opportunity> opportunity = opportunityRepository.findById("op003");
        Optional<Account> account = accountRepository.findById("ac004");

        assertEquals(10, opportunity.get().getQuantity());
        assertEquals("IKEA", account.get().getCompanyName());
        assertEquals("Pedro Luis", opportunity.get().getDecisionMaker().getName());
        assertEquals("pedro.luis@gmail.com", account.get().getContactList().get(0).getEmail());
    }
}