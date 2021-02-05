package com.ironhack.TheExceptionalistsCRMv20.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidatorTest {

    @Test
    public void validateName_ValidName_True() {
        assertTrue(Validator.validateName("Diego"));
        assertTrue(Validator.validateName("Ángel"));
        assertTrue(Validator.validateName("Diego Pérez"));
        assertTrue(Validator.validateName("Diego pérez"));
        assertTrue(Validator.validateName("Diego Pérez Pérez"));
        assertTrue(Validator.validateName("Diego Juan Carlos Pérez Pérez"));
        assertTrue(Validator.validateName("Diego juan Carlos pérez Pérez"));
    }

    @Test
    public void validateName_NotValidName_False() {
        assertFalse(Validator.validateName("85122"));
        assertFalse(Validator.validateName("Diego5214"));
        assertFalse(Validator.validateName("Diego Pérez5468"));
        assertFalse(Validator.validateName("Diego 4563Pérez"));
        assertFalse(Validator.validateName("Diego 4563Pérez"));
        assertFalse(Validator.validateName("."));
        assertFalse(Validator.validateName(".Diego Pérez"));
        assertFalse(Validator.validateName("Diego. Pérez"));
        assertFalse(Validator.validateName("Diego -Pérez"));
        assertFalse(Validator.validateName("Diego Pérez-"));
    }

    @Test
    public void validateProduct_ValidProduct_True() {
        assertTrue(Validator.validateProduct("hybrid"));
        assertTrue(Validator.validateProduct("flatbed"));
        assertTrue(Validator.validateProduct("box"));
    }

    @Test
    public void validateProduct_NotValidProduct_False() {
        assertFalse(Validator.validateProduct("Hybrid"));
        assertFalse(Validator.validateProduct("HYBRID"));
        assertFalse(Validator.validateProduct("Flatbed"));
        assertFalse(Validator.validateProduct("FLATBED"));
        assertFalse(Validator.validateProduct("Box"));
        assertFalse(Validator.validateProduct("BOX"));
        assertFalse(Validator.validateProduct("43793"));
        assertFalse(Validator.validateProduct("truck"));
        assertFalse(Validator.validateProduct("truck45"));
    }

    @Test
    public void validateCompanyName_StringWithLengthBetween1And31_True() {
        assertTrue(Validator.validateCompanyName("CocaCola"));
        assertTrue(Validator.validateCompanyName("Coca Cola"));
        assertTrue(Validator.validateCompanyName("Coca-Cola"));
        assertTrue(Validator.validateCompanyName("coca cola"));
        assertTrue(Validator.validateCompanyName("a"));
        assertTrue(Validator.validateCompanyName("This is a large name company"));
        assertTrue(Validator.validateCompanyName("A name with characters.()=?"));
        assertTrue(Validator.validateCompanyName("541A name with numbers143545"));
    }

    @Test
    public void validateCompanyName_StringWithZeroLengthOrAbove31_False() {
        assertFalse(Validator.validateCompanyName(""));
        assertFalse(Validator.validateCompanyName("This is a very very large name company"));
    }

    @Test
    public void validateEmail_ValidEmail_True() {
        assertTrue(Validator.validateEmail("diegoperez@gmail.com"));
        assertTrue(Validator.validateEmail("diego.perez@gmail.com"));
        assertTrue(Validator.validateEmail("diego.perez-@gmail.com"));
        assertTrue(Validator.validateEmail("diego.852@gmail.com"));
        assertTrue(Validator.validateEmail("d.852iego@gmail.com"));
        assertTrue(Validator.validateEmail("diego.perez@mydomain.app"));
        assertTrue(Validator.validateEmail("diego.perez@averyverylargedomain.comesorgappuk"));
    }

    @Test
    public void validateEmail_NotValidEmail_False() {
        assertFalse(Validator.validateEmail("diego.perezgmail.com"));
        assertFalse(Validator.validateEmail("diego.perez@gmailcom"));
        assertFalse(Validator.validateEmail("diego.perezgmailcom"));
        assertFalse(Validator.validateEmail("852diego.@gmail.com"));
        assertFalse(Validator.validateEmail("diego.852()@gmail.com"));
        assertFalse(Validator.validateEmail("DIEGOPEREZ@gmail.com"));
        assertFalse(Validator.validateEmail("852DIEGO-PEREZ85@gmail.com"));
        assertFalse(Validator.validateEmail("diego.perez@GMAIL.com"));
        assertFalse(Validator.validateEmail("diego.perez@-gMAIL.com"));
        assertFalse(Validator.validateEmail("diego.perez@G52Mail().com"));
        assertFalse(Validator.validateEmail("diego.perez@gmail.COM"));
        assertFalse(Validator.validateEmail("diego.perez@gmail.ES52"));
        assertFalse(Validator.validateEmail("diego.perez@gmail.52ES-()"));
    }

    @Test
    public void validatePhoneNumber_ValidPhone_True() {
        assertTrue(Validator.validatePhoneNumber("922332211"));
        assertTrue(Validator.validatePhoneNumber("2055550125"));
        assertTrue(Validator.validatePhoneNumber("202 555 0125"));
        assertTrue(Validator.validatePhoneNumber("(202) 555-0125"));
        assertTrue(Validator.validatePhoneNumber("+111 (202) 555-0125"));
        assertTrue(Validator.validatePhoneNumber("636 856 789"));
        assertTrue(Validator.validatePhoneNumber("+111 636 856 789"));
        assertTrue(Validator.validatePhoneNumber("92233"));
        assertTrue(Validator.validatePhoneNumber("92233221100"));
        assertTrue(Validator.validatePhoneNumber("9223322110000"));
        assertTrue(Validator.validatePhoneNumber("000 000 0000"));
        assertTrue(Validator.validatePhoneNumber("636-856-789"));
        assertTrue(Validator.validatePhoneNumber("636.856.789"));
    }

    @Test
    public void validatePhoneNumber_NotValidPhone_False() {
        assertFalse(Validator.validatePhoneNumber("9"));
        assertFalse(Validator.validatePhoneNumber("922"));
        assertFalse(Validator.validatePhoneNumber("636 85 67 89"));
        assertFalse(Validator.validatePhoneNumber("+111 636 85 67 89"));
        assertFalse(Validator.validatePhoneNumber("phoneNumber"));
        assertFalse(Validator.validatePhoneNumber("(636 856 789)"));
        assertFalse(Validator.validatePhoneNumber("636 856 789N"));
        assertFalse(Validator.validatePhoneNumber("636*856*789"));
        assertFalse(Validator.validatePhoneNumber("P636 856 789"));
    }

    @Test
    public void validateCommand_ValidExitCommand_True() {
        assertTrue(Validator.validateCommand("exit"));
    }

    @Test
    public void validateCommand_ValidNewCommand_True() {
        assertTrue(Validator.validateCommand("new lead"));
    }

    @Test
    public void validateCommand_ValidShowCommand_True() {
        assertTrue(Validator.validateCommand("show leads"));
    }

    @Test
    public void introduceCommand_addCorrectInputNoCaseSensitive_True() {
        assertTrue(Validator.validateCommand("New Lead"));
        assertTrue(Validator.validateCommand("new lead"));
        assertTrue(Validator.validateCommand("NEw LeaD"));
        assertTrue(Validator.validateCommand("Show Leads"));
        assertTrue(Validator.validateCommand("show leads"));
    }

    @Test
    public void introduceCommand_checkEmptyInput_false() {
        assertFalse(Validator.validateCommand(""));
    }

    @Test
    public void validateCommand_ValidLookupCommand_True() {
        assertFalse(Validator.validateCommand("lookup opportunity"));
    }

    @Test
    public void validateCommand_ValidConvertCommand_True() {
        assertTrue(Validator.validateCommand("convert 120"));
    }

    @Test
    public void validateCommand_ValidCloseCommand_True() {
        assertTrue(Validator.validateCommand("close-won 120"));
        assertTrue(Validator.validateCommand("close-lost 120"));
    }

    @Test
    public void validateCommand_NotValidExitCommand_False() {
        assertFalse(Validator.validateCommand("exit lead"));
    }

    @Test
    public void validateCommand_NotValidNewCommand_False() {
        assertFalse(Validator.validateCommand("new"));
        assertFalse(Validator.validateCommand("new opportunity"));
        assertFalse(Validator.validateCommand("new 120"));
    }

    @Test
    public void validateCommand_NotValidShowCommand_False() {
        assertFalse(Validator.validateCommand("show"));
        assertFalse(Validator.validateCommand("show lead"));
        assertFalse(Validator.validateCommand("show 120"));
    }

    @Test
    public void validateCommand_NotValidLookupCommand_False() {
        assertFalse(Validator.validateCommand("lookup"));
        assertFalse(Validator.validateCommand("lookup lead"));
        assertFalse(Validator.validateCommand("lookup 120"));
    }

    @Test
    public void validateCommand_NotValidConvertCommand_False() {
        assertFalse(Validator.validateCommand("convert"));
        assertFalse(Validator.validateCommand("convert lead"));
    }

    @Test
    public void validateCommand_NotValidCloseCommand_False() {
        assertFalse(Validator.validateCommand("close-won"));
        assertFalse(Validator.validateCommand("close-won opportunity"));
        assertFalse(Validator.validateCommand("close-lost"));
        assertFalse(Validator.validateCommand("close-lost opportunity"));
    }

    @Test
    public void validateNumber_ZeroOrPositiveNumberAndBelowOneBillion_True() {
        assertTrue(Validator.validateNumber("1"));
        assertTrue(Validator.validateNumber("123456789"));
        assertTrue(Validator.validateNumber("999999999"));
    }

    @Test
    public void validateNumber_EmptyOrZeroOrNegativeNumberOrAboveOneMillion_False() {
        assertFalse(Validator.validateNumber(""));
        assertFalse(Validator.validateNumber("0"));
        assertFalse(Validator.validateNumber("-1"));
        assertFalse(Validator.validateNumber("-254125441254"));
        assertFalse(Validator.validateNumber("254125441254"));
    }

    @Test
    public void validateNumber_ANotNumberCharacter_False() {
        assertFalse(Validator.validateNumber("number"));
        assertFalse(Validator.validateNumber("55.hh"));
        assertFalse(Validator.validateNumber("55.55"));
        assertFalse(Validator.validateNumber("55-55"));
        assertFalse(Validator.validateNumber("55T55"));
    }

    @Test
    public void validateIndustry_ValidIndustry_True() {
        assertTrue(Validator.validateIndustry("produce"));
        assertTrue(Validator.validateIndustry("ecommerce"));
        assertTrue(Validator.validateIndustry("manufacturing"));
        assertTrue(Validator.validateIndustry("medical"));
        assertTrue(Validator.validateIndustry("other"));
    }

    @Test
    public void validateIndustry_NotValidIndustry_False() {
        assertFalse(Validator.validateIndustry("Produce"));
        assertFalse(Validator.validateIndustry("PRODUCE"));
        assertFalse(Validator.validateIndustry("Ecommerce"));
        assertFalse(Validator.validateIndustry("ECOMMERCE"));
        assertFalse(Validator.validateIndustry("Manufacturing"));
        assertFalse(Validator.validateIndustry("MANUFACTURING"));
        assertFalse(Validator.validateIndustry("Medical"));
        assertFalse(Validator.validateIndustry("MEDICAL"));
        assertFalse(Validator.validateIndustry("Other"));
        assertFalse(Validator.validateIndustry("OTHER"));
        assertFalse(Validator.validateIndustry("43793"));
        assertFalse(Validator.validateIndustry("truck"));
        assertFalse(Validator.validateIndustry("produce45"));
    }
}