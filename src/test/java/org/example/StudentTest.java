package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;

public class StudentTest {
    @Test
    @DisplayName("registerCourse New -> true")
    void testRegisterCourseSuccess() {
        Department dept = new Department("Science");
        Student s = new Student("Alice", Student.Gender.FEMALE, null, null);
        Course c = new Course("CS", null, dept, 3.0);

        boolean expected = true;
        boolean actual = s.registerCourse(c);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("registerCourse Duplicate -> false")
    void testRegisterCourseDuplicate() {
        Department dept = new Department("Science");
        Student s = new Student("Alice", Student.Gender.FEMALE, null, null);
        Course c = new Course("CS", null, dept, 3.0);
        s.registerCourse(c);

        boolean expected = false;
        boolean actual = s.registerCourse(c);
        Assertions.assertEquals(expected, actual);
    }


    @Test
    @DisplayName("dropCourse Existing -> true")
    void testDropCourseSuccess() {
        Department dept = new Department("Science");
        Student s = new Student("Alice", Student.Gender.FEMALE, null, null);
        Course c = new Course("CS", null, dept, 3.0);
        s.registerCourse(c);

        boolean expected = true;
        boolean actual = s.dropCourse(c);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("dropCourse Not Registered -> false")
    void testDropCourseFail() {
        Department dept = new Department("Science");
        Student s = new Student("Alice", Student.Gender.FEMALE, null, null);
        Course c = new Course("CS", null, dept, 3.0);

        boolean expected = false;
        boolean actual = s.dropCourse(c);
        Assertions.assertEquals(expected, actual);
    }


    @Test
    @DisplayName("toSimplifiedString -> Valid Format")
    void testSimplifiedString() {
        Department dept = new Department("Science");
        Department d = new Department("Tech");
        Student s = new Student("Alice Doe", Student.Gender.FEMALE, null, d);

        String output = s.toSimplifiedString();

        boolean expectedName = true;
        boolean actualName = output.contains("Alice Doe");
        Assertions.assertEquals(expectedName, actualName);

        boolean expectedDept = true;
        boolean actualDept = output.contains("Tech");
        Assertions.assertEquals(expectedDept, actualDept);
    }
}
