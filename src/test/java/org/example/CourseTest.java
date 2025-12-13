package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;

public class CourseTest {

    @Test
    @DisplayName("isAssignmentWeightValid Exact 100% -> true")
    void testWeightValid() {
        Course c = new Course("Math", null, null, 3.0);
        c.addAssignment("A1", 50, 100);
        c.addAssignment("A2", 50, 100);

        boolean expected = true;
        boolean actual = c.isAssignmentWeightValid();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("isAssignmentWeightValid Under 100% -> false")
    void testWeightUnder() {
        Course c = new Course("Math", null, null, 3.0);
        c.addAssignment("A1", 90, 100);

        boolean expected = false;
        boolean actual = c.isAssignmentWeightValid();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("isAssignmentWeightValid Over 100% -> false")
    void testWeightOver() {
        Course c = new Course("Math", null, null, 3.0);
        c.addAssignment("A1", 60, 100);
        c.addAssignment("A2", 60, 100);

        boolean expected = false;
        boolean actual = c.isAssignmentWeightValid();
        Assertions.assertEquals(expected, actual);
    }


    @Test
    @DisplayName("registerStudent New Student -> Success")
    void testRegisterStudentSuccess() {
        Course c = new Course("Bio", null, null, 3.0);
        Student s = new Student("Bob", Student.Gender.MALE, null, null);

        boolean expected = true;
        boolean actual = c.registerStudent(s);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("registerStudent Duplicate Student -> Fail")
    void testRegisterStudentDuplicate() {
        Course c = new Course("Bio", null, null, 3.0);
        Student s = new Student("Bob", Student.Gender.MALE, null, null);
        c.registerStudent(s);

        boolean expected = false;
        boolean actual = c.registerStudent(s);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("addAssignment Normal -> Adds to list")
    void testAddAssignmentNormal() {
        Course c = new Course("Bio", null, null, 3.0);

        boolean expected = true;
        boolean actual = c.addAssignment("Quiz", 10, 100);
        Assertions.assertEquals(expected, actual);

        int expectedSize = 1;
        int actualSize = c.getAssignments().size();
        Assertions.assertEquals(expectedSize, actualSize);
    }

    @Test
    @DisplayName("addAssignment With Students -> Updates student scores list")
    void testAddAssignmentWithStudent() {
        Course c = new Course("Bio", null, null, 3.0);
        Student s = new Student("Bob", Student.Gender.MALE, null, null);
        c.registerStudent(s);

        c.addAssignment("Quiz", 10, 100);

        int expectedScoresSize = 1;
        int actualScoresSize = c.getAssignments().get(0).getScores().size();
        Assertions.assertEquals(expectedScoresSize, actualScoresSize);
    }
}