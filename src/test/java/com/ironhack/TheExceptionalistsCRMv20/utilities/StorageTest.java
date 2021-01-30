package com.ironhack.TheExceptionalistsCRMv20.utilities;

import com.ironhack.TheExceptionalistsCRMv20.model.Account;
import com.ironhack.TheExceptionalistsCRMv20.model.Contact;
import com.ironhack.TheExceptionalistsCRMv20.model.Lead;
import com.ironhack.TheExceptionalistsCRMv20.model.Opportunity;
import com.ironhack.TheExceptionalistsCRMv20.enums.Industry;
import com.ironhack.TheExceptionalistsCRMv20.enums.Product;
import com.ironhack.TheExceptionalistsCRMv20.enums.Status;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StorageTest {
    private static Lead lead;
    private static Contact contact;
    private static Opportunity opportunity;
    private static Account account;


    @BeforeAll
    public static void setUp() {
        lead = new Lead("le0000000012", "Diego Pérez", "diego.perez@gmail.com", "CocaCola", "444 333 222 111");
        contact = new Contact("co0000000013", "Diego Pérez", "diego.perez@gmail.com", "CocaCola", "444 333 222 111");
        opportunity = new Opportunity("op0000000014", Product.HYBRID, 10, contact, Status.OPEN);
        account = new Account("ac0000000015", "CocaCola", Industry.ECOMMERCE, 100, "Madrid", "Spain");
        account.getContactList().add(contact);
        account.getOpportunityList().add(opportunity);
    }

    @Test
    public void add_Lead_LeadAddedToHashMap() {
        Storage.add(lead);

        assertEquals(Lead.class, Storage.searchLead("le0000000012").getClass());
        assertEquals("le0000000012", Storage.searchLead("le0000000012").getId());
        assertEquals("Diego Pérez", Storage.searchLead("le0000000012").getName());
    }

    @Test
    public void add_Contact_ContactAddedToHashMap() {
        Storage.add(contact);

        assertEquals(Contact.class, Storage.searchContact("co0000000013").getClass());
        assertEquals("co0000000013", Storage.searchContact("co0000000013").getId());
        assertEquals("Diego Pérez", Storage.searchContact("co0000000013").getName());
    }

    @Test
    public void add_Opportunity_OpportunityAddedToHashMap() {
        Storage.add(opportunity);

        assertEquals(Opportunity.class, Storage.searchOpportunity("op0000000014").getClass());
        assertEquals("op0000000014", Storage.searchOpportunity("op0000000014").getId());
        assertEquals(10, Storage.searchOpportunity("op0000000014").getQuantity());
    }

    @Test
    public void add_Account_AccountAddedToHashMap() {
        Storage.add(account);

        assertEquals(Account.class, Storage.searchAccount("ac0000000015").getClass());
        assertEquals("ac0000000015", Storage.searchAccount("ac0000000015").getId());
        assertEquals("Madrid", Storage.searchAccount("ac0000000015").getCity());
    }

    @Test
    public void setUpId_CallMethod_IncrementStaticId() {
        int id = Storage.getId();
        Storage.setUpId();

        assertEquals(id + 1, Storage.getId());
    }

    @Test
    public void update_Lead_LeadUpdatedToHashMap() {
        /*Storage.add(lead);
        lead = new Lead("le0000000012", "Diego Pérez", "diego-perez@gmail.com", "Coca-Cola", "444 333 222 111");
        Storage.update(lead);

        assertEquals("le0000000012", Storage.searchLead("ac0000000012").getId());
        assertEquals("diego-perez@gmail.com", Storage.searchLead("ac0000000012").getEmail());*/
    }

    @Test
    public void update_NotExistingLead_IllegalArgumentException() {
        /*lead = new Lead("le0000000014", "Diego Pérez", "diego-perez@gmail.com", "Coca-Cola", "444 333 222 111");

        assertThrows(IllegalArgumentException.class, ()->Storage.update(lead));*/
    }

    @Test
    public void testUpdate() {
    }

    @Test
    public void testUpdate1() {
    }

    @Test
    public void testUpdate2() {
    }
}
