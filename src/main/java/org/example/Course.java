package org.example;
import java.util.ArrayList;

public class Course {
    private String courseId;
    private String courseName;
    private double credits;
    private Department department;
    private ArrayList<Assignment> assignments;
    private ArrayList<Student> registeredStudents;
    private ArrayList<Double> finalScores;
    private static int nextId = 1;

    public Course(String courseName, ArrayList<Assignment> assignments, Department department, double credits) {
        this.courseName = courseName;
        this.department = department;
        this.credits = credits;
        this.assignments = (assignments != null) ? assignments : new ArrayList<>();
        this.registeredStudents = new ArrayList<>();
        this.finalScores = new ArrayList<>();
        String deptId = (department != null) ? department.getDepartmentId() : "D00";
        this.courseId = String.format("C-%s-%02d", deptId, nextId++);
    }
}