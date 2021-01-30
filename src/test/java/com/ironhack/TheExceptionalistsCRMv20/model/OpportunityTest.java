package com.ironhack.TheExceptionalistsCRMv20.model;

import com.ironhack.TheExceptionalistsCRMv20.enums.Product;
import com.ironhack.TheExceptionalistsCRMv20.enums.Status;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OpportunityTest {
    static Contact contact;

    @BeforeAll
    public static void beforeAll() {
        contact = new Contact("Ivan", "ivan@gmail.com", "Company", "922 33 22 11");
    }

    @Test
    public void setQuantity_AboveZero_OpportunityCreated() {
        Opportunity opportunity = new Opportunity(Product.HYBRID, 5, contact, Status.OPEN);

        assertEquals(5, opportunity.getQuantity());
    }

    @Test
    public void setQuantity_ZeroOrNegative_IllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> new Opportunity(Product.HYBRID, -5, contact, Status.OPEN));
        assertThrows(IllegalArgumentException.class, () -> new Opportunity(Product.HYBRID, 0, contact, Status.OPEN));
    }
}
