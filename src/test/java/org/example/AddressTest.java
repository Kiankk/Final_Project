package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;

public class AddressTest {
    @Test
    @DisplayName("Valid Postal Code: 'H3A2K6' -> true")
    void testIsPostalCodeValidNormal() {
        String input = "H3A2K6";
        boolean expected = true;
        boolean actual = Address.isPostalCodeValid(input);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Null Postal Code -> false")
    void testIsPostalCodeValidNull() {
        String input = null;
        boolean expected = false;
        boolean actual = Address.isPostalCodeValid(input);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Invalid Length (Short): 'H3A' -> false")
    void testIsPostalCodeValidLength() {
        String input = "H3A";
        boolean expected = false;
        boolean actual = Address.isPostalCodeValid(input);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Invalid Format (Letter in Digit spot): 'AAAAAA' -> false")
    void testIsPostalCodeValidFormat() {
        String input = "AAAAAA";
        boolean expected = false;
        boolean actual = Address.isPostalCodeValid(input);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Constructor Valid -> All fields set correctly")
    void testConstructorValid() {
        Address addr = new Address(10, "Main St", "City", Address.Province.QC, "A1A1A1");

        String expected = "A1A1A1";
        String actual = addr.getPostalCode();
        Assertions.assertEquals(expected, actual);

        int expectedNo = 10;
        int actualNo = addr.getStreetNo();
        Assertions.assertEquals(expectedNo, actualNo);
    }

    @Test
    @DisplayName("Constructor Invalid Postal -> Fields set to null/0")
    void testConstructorInvalid() {
        Address addr = new Address(10, "Main St", "City", Address.Province.QC, "INVALID");

        String expected = null;
        String actual = addr.getPostalCode();
        Assertions.assertEquals(expected, actual);

        String expectedCity = null;
        String actualCity = addr.getCity();
        Assertions.assertEquals(expectedCity, actualCity);
    }

    @Test
    @DisplayName("setPostalCode Valid -> Updates field")
    void testSetPostalCodeValid() {
        Address addr = new Address(1, "S", "C", Address.Province.QC, "A1A1A1");
        addr.setPostalCode("B2B2B2");

        String expected = "B2B2B2";
        String actual = addr.getPostalCode();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("setPostalCode Invalid -> Does NOT update field")
    void testSetPostalCodeInvalid() {
        Address addr = new Address(1, "S", "C", Address.Province.QC, "A1A1A1");
        addr.setPostalCode("BadCode");

        String expected = "A1A1A1"; // Should remain original
        String actual = addr.getPostalCode();
        Assertions.assertEquals(expected, actual);
    }
}