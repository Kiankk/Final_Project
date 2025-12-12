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

    public boolean isAssignmentWeightValid() {
        double sum = 0;
        for (Assignment a : assignments) {
            sum += a.getWeight();
        }
        return sum == 100.0;
    }

    public boolean registerStudent(Student student) {
        if (registeredStudents.contains(student)) {
            return false;
        }

        registeredStudents.add(student);
        finalScores.add(null);

        for (Assignment a : assignments) {
            a.getScores().add(null);
        }
        return true;
    }

    public int[] calcStudentsAverage() {
        int[] averages = new int[registeredStudents.size()];

        for (int i = 0; i < registeredStudents.size(); i++) {
            double weightedSum = 0;

            for (Assignment a : assignments) {
                Integer score = a.getScores().get(i);
                if (score != null) {
                    weightedSum += score * (a.getWeight() / 100.0);
                }
            }

            finalScores.set(i, weightedSum);
            averages[i] = (int) Math.round(weightedSum);
        }
        return averages;
    }
}