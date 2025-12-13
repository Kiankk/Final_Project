package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;

public class UtilTest {
    @Test
    @DisplayName("Normal Case: 'john doe' -> 'John Doe'")
    void testToTitleCaseNormal() {
        String input = "john doe";
        String expected = "John Doe";
        String actual = Util.toTitleCase(input);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Mixed Case: 'cOmPuTeR sCiEnCe' -> 'Computer Science'")
    void testToTitleCaseMixed() {
        String input = "cOmPuTeR sCiEnCe";
        String expected = "Computer Science";
        String actual = Util.toTitleCase(input);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Null Input -> null")
    void testToTitleCaseNull() {
        String input = null;
        String expected = null;
        String actual = Util.toTitleCase(input);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Empty String -> null (or empty based on implementation)")
    void testToTitleCaseEmpty() {
        String input = "";
        String expected = null; // Assuming logic returns null for empty/blank
        String actual = Util.toTitleCase(input);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Single Word: 'java' -> 'Java'")
    void testToTitleCaseSingleWord() {
        String input = "java";
        String expected = "Java";
        String actual = Util.toTitleCase(input);
        Assertions.assertEquals(expected, actual);
    }
}