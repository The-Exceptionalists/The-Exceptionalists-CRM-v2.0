package com.ironhack.TheExceptionalistsCRMv20.model;

import com.ironhack.TheExceptionalistsCRMv20.enums.Industry;
import com.ironhack.TheExceptionalistsCRMv20.enums.Product;
import com.ironhack.TheExceptionalistsCRMv20.enums.Status;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {

    Contact contact;
    Opportunity opportunity;

    @BeforeEach
    void setUp() {
        contact = new Contact("Ivan", "asd@hotmail.com", "Hehe", "922332211");
        opportunity = new Opportunity(Product.BOX, 20, contact, Status.OPEN);
    }

    @Test
    void setEmployeeCount_positiveInteger_set() {
        Account account1 = new Account("Apple", Industry.OTHER, 2, "New York", "USA", contact, opportunity);
        assertEquals(2, account1.getEmployeeCount());
        Account account2 = new Account("Apple", Industry.OTHER, 3000, "New York", "USA", contact, opportunity);
        assertEquals(3000, account2.getEmployeeCount());
    }

    @Test
    void setEmployeeCount_negativeOrZeroInteger_IllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> new Account("Apple", Industry.OTHER, -100, "New York", "USA", contact, opportunity));
        assertThrows(IllegalArgumentException.class, () -> new Account("Apple", Industry.OTHER, 0, "New York", "USA", contact, opportunity));
    }

    @Test
    void setContactList_notEmptyList_set() {
        Account account = new Account("Apple", Industry.OTHER, 2, "New York", "USA", contact, opportunity);
        assertEquals(1, account.getContactList().size());
    }

    @Test
    void setOpportunityList_notEmptyList_set() {
        Account account = new Account("Apple", Industry.OTHER, 2, "New York", "USA", contact, opportunity);
        assertEquals(1, account.getOpportunityList().size());
    }

}
