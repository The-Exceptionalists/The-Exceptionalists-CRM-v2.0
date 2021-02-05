package com.ironhack.TheExceptionalistsCRMv20.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContactTest {

    Contact contact;

    @BeforeEach
    void setUp() {
        contact = new Contact("Perico Perez", "perico@perez.com", "Microsoft", "665566544");
    }

    @Test
    void setName_entersRegularName_OK() {
        contact.setName("Pepe");
        assertEquals("Pepe", contact.getName());
    }

    @Test
    void setName_emptyString_ThrowsIllegal() {
        assertThrows(IllegalArgumentException.class, () -> contact.setName(""));
    }

    @Test
    void setName_stringTooLong_ThrowsIllegal() {
        assertThrows(IllegalArgumentException.class, () -> contact.setName("12345678901234567890123456789012345"));
    }

    @Test
    void setName_blankSpace_ThrowsIllegal() {
        assertThrows(IllegalArgumentException.class, () -> contact.setName(" "));
    }

    @Test
    void setEmail_normalEmail_OK() {
        contact.setEmail("pepe@pepe.com");
        assertEquals("pepe@pepe.com", contact.getEmail());

    }

    @Test
    void setEmail_emptyString_ThrowsIllegal() {
        assertThrows(IllegalArgumentException.class, () -> contact.setEmail(""));
    }

    @Test
    void setEmail_blankSpace_ThrowsIllegal() {
        assertThrows(IllegalArgumentException.class, () -> contact.setEmail(" "));
    }

    @Test
    void setEmail_noAt_ThrowsIllegal() {
        assertThrows(IllegalArgumentException.class, () -> contact.setEmail("pepepepe.com"));
    }

    @Test
    void setEmail_noDotEmail_ThrowsIllegal() {
        assertThrows(IllegalArgumentException.class, () -> contact.setEmail("pepe@pepecom"));
    }

    @Test
    void setEmail_moreThanOneDot_OK() {
        contact.setEmail("pepe@pepe.co.uk");
        assertEquals("pepe@pepe.co.uk", contact.getEmail());
        contact.setEmail("pe.pe@pepe.co.uk");
        assertEquals("pe.pe@pepe.co.uk", contact.getEmail());

    }

    @Test
    void setEmail_specialCharacters_OK() {
        contact.setEmail("pe_pe@pepe.co.uk");
        assertEquals("pe_pe@pepe.co.uk", contact.getEmail());
        contact.setEmail("pe-pe@pepe.co.uk");
        assertEquals("pe-pe@pepe.co.uk", contact.getEmail());

    }

    @Test
    void setEmail_forbiddenCharacters_ThrowsIllegal() {
        assertThrows(IllegalArgumentException.class, () -> contact.setEmail("pe/pe@pepecom"));
        assertThrows(IllegalArgumentException.class, () -> contact.setEmail("pe*pe@pepecom"));
    }

    @Test
    void setEmail_spacesInBetween_ThrowsIllegal() {
        assertThrows(IllegalArgumentException.class, () -> contact.setEmail("pe pe@pepecom"));
    }


    @Test
    void setCompanyName_entersRegularName_OK() {
        contact.setCompanyName("Apple");
        assertEquals("Apple", contact.getCompanyName());
    }

    @Test
    void setCompanyName_emptyString_ThrowsIllegal() {
        assertThrows(IllegalArgumentException.class, () -> contact.setCompanyName(""));
    }

    @Test
    void setCompanyName_stringTooLong_ThrowsIllegal() {
        assertThrows(IllegalArgumentException.class, () -> contact.setCompanyName("12345678901234567890123456789012345"));
    }

    @Test
    void setPhoneNum_regularPhone_OK() {
        contact.setPhoneNumber("666666666");
        assertEquals("666666666", contact.getPhoneNumber());
    }

    @Test
    void setPhoneNum_withSpaces_OK() {
        contact.setPhoneNumber("666 666 666");
        assertEquals("666 666 666", contact.getPhoneNumber());
    }

    @Test
    void setPhoneNum_countryCode_OK() {
        contact.setPhoneNumber("+34 666 666 666");
        assertEquals("+34 666 666 666", contact.getPhoneNumber());
        contact.setPhoneNumber("+34666666666");
        assertEquals("+34666666666", contact.getPhoneNumber());
    }

    @Test
    void setPhoneNum_withBrackets_OK() {
        contact.setPhoneNumber("+34 (666) 666 666");
        assertEquals("+34 (666) 666 666", contact.getPhoneNumber());
        contact.setPhoneNumber("(346)66666666");
        assertEquals("(346)66666666", contact.getPhoneNumber());
    }

    @Test
    void setPhoneNum_withLetters_throwsException() {

        assertThrows(IllegalArgumentException.class, () -> contact.setPhoneNumber("66i553328"));
        assertThrows(IllegalArgumentException.class, () -> contact.setPhoneNumber("abc222111"));
        assertThrows(IllegalArgumentException.class, () -> contact.setPhoneNumber("96I4234"));
    }

    @Test
    void setPhoneNum_emptyOrBlankSpaces_throwsException() {

        assertThrows(IllegalArgumentException.class, () -> contact.setPhoneNumber(""));
        assertThrows(IllegalArgumentException.class, () -> contact.setPhoneNumber(" "));
        assertThrows(IllegalArgumentException.class, () -> contact.setPhoneNumber("  "));
    }

}
