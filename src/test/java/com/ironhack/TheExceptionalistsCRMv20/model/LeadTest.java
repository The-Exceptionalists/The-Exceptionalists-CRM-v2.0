package com.ironhack.TheExceptionalistsCRMv20.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LeadTest {

    @Test
    void setName_noEmpty_true() {
        Lead lead = new Lead("Juan Alberto", "juan@juan.es", "Juan's Company", "669695702");
        assertTrue(lead.getName().length() > 0);
    }

    @Test
    void setName_noMoreThan30Char_true() {
        Lead lead = new Lead("Juan Alberto", "juan@juan.es", "Juan's Company", "669695702");
        assertTrue(lead.getName().length() < 31);
    }

    @Test
    void setName_work_name() {
        Lead lead = new Lead("Juan Alberto", "juan@juan.es", "Juan's Company", "669695702");
        lead.setName("Juan");
        assertEquals("Juan", lead.getName());
        lead.setName("juan");
        assertEquals("juan", lead.getName());
        lead.setName("Juan Alberto");
        assertEquals("Juan Alberto", lead.getName());
        lead.setName("Antonio Jesús");
        assertEquals("Antonio Jesús", lead.getName());
    }

    @Test
    void setName_throwEmptyError_IllegalArgumentException() {
        Lead lead = new Lead("Juan", "juan@juan.es", "Juan's Company", "669695702");
        assertThrows(IllegalArgumentException.class, () -> lead.setName(""));
    }

    @Test
    void setEmail_workCorrect_email() {
        Lead lead = new Lead("Antonio Jesús", "juan@juan.es", "Juan's Company", "669695702");
        assertEquals("juan@juan.es", lead.getEmail());
    }

    @Test
    void setEmail_checkStructureAndSendExceptionIfNotCorrect_IllegalArgumentException() {
        Lead lead = new Lead("Antonio Jesús", "juan@juan.es", "Juan's Company", "669695702");
        assertThrows(IllegalArgumentException.class, () -> lead.setEmail("juan"));
        assertThrows(IllegalArgumentException.class, () -> lead.setEmail("@juan"));
        assertThrows(IllegalArgumentException.class, () -> lead.setEmail("juan@juan"));
        assertThrows(IllegalArgumentException.class, () -> lead.setEmail("juan.com"));
        assertThrows(IllegalArgumentException.class, () -> lead.setEmail(""));
    }

    @Test
    void setCompanyName_noEmpty_true() {
        Lead lead = new Lead("Antonio Jesús", "juan@juan.es", "Juan's Company", "669695702");

        assertThrows(IllegalArgumentException.class, () -> lead.setCompanyName(""));
    }

    @Test
    void setCompanyName_noMoreThan30_true() {
        Lead lead = new Lead("Antonio Jesús", "juan@juan.es", "Juan's Company", "669695702");
        assertThrows(IllegalArgumentException.class, () -> lead.setCompanyName("juanjuanjuanjuanjuanjuanjuanjuanjuanjuanjuanjuanjuanjuanjuanjuanjuanjuanjuanjuanjuanjuanjuanjuan"));
    }


    @Test
    void setPhoneNumber_getCorrectNumber_correctNumber() {
        Lead lead = new Lead("Antonio Jesús", "juan@juan.es", "Juan's Company", "669695702");
        assertEquals("669695702", lead.getPhoneNumber());
    }

    @Test
    void setPhoneNumber_noEmpty_correctPhone() {
        Lead lead = new Lead("Antonio Jesús", "juan@juan.es", "Juan's Company", "669695702");
        assertTrue(lead.getPhoneNumber().length() > 0);
    }

    @Test
    void setPhoneNumber_phoneStructure_correctPhone() {
        Lead lead = new Lead("Antonio Jesús", "juan@juan.es", "Juan's Company", "669695702");
        assertThrows(IllegalArgumentException.class, () -> lead.setPhoneNumber("fahksdjhflah"));
    }
}
