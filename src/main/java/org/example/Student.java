package org.example;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Objects;

@Getter
@Setter
@EqualsAndHashCode
public class Student {
    private String studentId; // Auto-generated: S + 6 digits
    private String studentName;
    private Gender gender;
    private Address address;
    private Department department;
    private ArrayList<Course> registeredCourses;
    private static int nextId = 1;

    public Student(String studentName, Gender gender, Address address, Department department) {
        this.studentName = studentName;
        this.gender = gender;
        this.address = address;
        this.department = department;
        this.registeredCourses = new ArrayList<>();
        this.studentId = String.format("S%06d", nextId);
        nextId++;
    }

    /**
     * Registers a course for a student
     * @param course given by the user
     * @return if the course was already there or added
     */
    public boolean registerCourse(Course course) {
        if (registeredCourses.contains(course)) {
            return false;
        }

        registeredCourses.add(course);
        course.getRegisteredStudents().add(this);
        for (Assignment assignment : course.getAssignments()) {
            assignment.getScores().add(null);
        }
        return true;
    }

    /**
     * Removes a course for a student
     * @param course given by the user
     * @return if the course wasn't already there or removed
     */
    public boolean dropCourse(Course course) {
        if (!registeredCourses.contains(course)) {
            return false;
        }

        registeredCourses.remove(course);
        course.getRegisteredStudents().remove(this);

        return true;
    }

    public String toSimplifiedString() {
        return studentId + " " + studentName + " " + (department != null ? department.getDepartmentName() : "null");
    }

    @Override
    public String toString() {
        StringBuilder coursesStr = new StringBuilder("[");
        for (int i = 0; i < registeredCourses.size(); i++) {
            Course c = registeredCourses.get(i);
            coursesStr.append(c.getCourseId())
                    .append("-")
                    .append(c.getCourseName())
                    .append("-")
                    .append(c.getDepartment().getDepartmentName());

            if (i < registeredCourses.size() - 1) {
                coursesStr.append(", ");
            }
        }
        coursesStr.append("]");

        return "Student{" +
                "studentId='" + studentId + '\'' +
                ", studentName='" + studentName + '\'' +
                ", gender=" + gender +
                ", address=" + address +
                ", department=" + department +
                ", registeredCourses=" + coursesStr.toString() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(studentId, student.studentId) &&
                Objects.equals(studentName, student.studentName) &&
                gender == student.gender &&
                Objects.equals(address, student.address) &&
                Objects.equals(department, student.department);
    }

    enum Gender {
        MALE, FEMALE
    }
}
