package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;

public class DepartmentTest {
    @Test
    @DisplayName("Valid Name: 'Computer Science' -> true")
    void testIsDeptNameValidNormal() {
        String input = "Computer Science";
        boolean expected = true;
        boolean actual = Department.isDepartmentNameValid(input);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Null Name -> false")
    void testIsDeptNameValidNull() {
        String input = null;
        boolean expected = false;
        boolean actual = Department.isDepartmentNameValid(input);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Invalid Name (Contains Digits): 'Math 101' -> false")
    void testIsDeptNameValidDigits() {
        String input = "Math 101";
        boolean expected = false;
        boolean actual = Department.isDepartmentNameValid(input);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Constructor Valid -> ID Generated & Name Set")
    void testConstructorValid() {
        Department d = new Department("History");

        boolean expected = true;
        // ID should be D + 2 digits
        boolean actual = d.getDepartmentId().matches("D\\d{2}");
        Assertions.assertEquals(expected, actual);

        String expectedName = "History"; // Assuming TitleCase applied
        String actualName = d.getDepartmentName();
        Assertions.assertEquals(expectedName, actualName);
    }

    @Test
    @DisplayName("Constructor Invalid Name -> Object is Null state")
    void testConstructorInvalid() {
        Department d = new Department("Bad123");

        String expected = null;
        String actual = d.getDepartmentName();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("setDepartmentName Valid -> Updates and TitleCases")
    void testSetNameValid() {
        Department d = new Department("Math");
        d.setDepartmentName("pure math");

        String expected = "Pure Math";
        String actual = d.getDepartmentName();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("setDepartmentName Invalid -> Does NOT update")
    void testSetNameInvalid() {
        Department d = new Department("Math");
        d.setDepartmentName("Math 2");

        String expected = "Math";
        String actual = d.getDepartmentName();
        Assertions.assertEquals(expected, actual);
    }
}