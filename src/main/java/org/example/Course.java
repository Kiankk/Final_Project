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

    public boolean addAssignment(String assignmentName, double weight, int maxScore) {
        Assignment newAssignment = new Assignment(assignmentName, weight);
        for (int i = 0; i < registeredStudents.size(); i++) {
            newAssignment.getScores().add(null);
        }

        assignments.add(newAssignment);
        return true;
    }

    public void generateScores() {
        for (Assignment a : assignments) {
            a.generateRandomScore();
        }
        calcStudentsAverage();
    }

    /**
     * displays the scores of the assignment
     */
    public void displayScores() {
        System.out.printf("Course: %s (%s)%n", courseName, courseId);
        System.out.printf("%-20s", "");
        for (Assignment a : assignments) {
            System.out.printf("%-15s", a.getAssignmentName());
        }
        System.out.printf("%-15s%n", "Final Score");

        for (int i = 0; i < registeredStudents.size(); i++) {
            Student s = registeredStudents.get(i);
            System.out.printf("%-20s", s.getStudentName());

            for (Assignment a : assignments) {
                Integer score = a.getScores().get(i);
                System.out.printf("%-15s", (score != null ? score : "N/A"));
            }

            Double finalScore = finalScores.get(i);
            System.out.printf("%-15s%n", (finalScore != null ? Math.round(finalScore) : "N/A"));
        }

        System.out.printf("%-20s", "Average");
        for (Assignment a : assignments) {
            double sum = 0;
            int count = 0;
            for (Integer score : a.getScores()) {
                if (score != null) {
                    sum += score;
                    count++;
                }
            }
            int avg = (count > 0) ? (int)(sum / count) : 0;
            System.out.printf("%-15d", avg);
        }

        double finalSum = 0;
        int finalCount = 0;
        for (Double f : finalScores) {
            if (f != null) {
                finalSum += f;
                finalCount++;
            }
        }
        int totalAvg = (finalCount > 0) ? (int)(finalSum / finalCount) : 0;
        System.out.printf("%-15d%n", totalAvg);
    }

    public String toSimplifiedString() {
        String deptName = (department != null) ? department.getDepartmentName() : "Unknown";
        return String.format("CourseId: %s, Name: %s, Credits: %.1f, Dept: %s",
                courseId, courseName, credits, deptName);
    }

    @Override
    public String toString() {
        String deptName = (department != null) ? department.getDepartmentName() : "Unknown";

        StringBuilder studentsStr = new StringBuilder("[");
        for (int i = 0; i < registeredStudents.size(); i++) {
            Student s = registeredStudents.get(i);
            studentsStr.append(s.getStudentId())
                    .append("-")
                    .append(s.getStudentName())
                    .append("-")
                    .append(deptName);
            if (i < registeredStudents.size() - 1) studentsStr.append(", ");
        }
        studentsStr.append("]");

        return "Course{" +
                "courseId='" + courseId + '\'' +
                ", courseName='" + courseName + '\'' +
                ", credits=" + credits +
                ", department=" + deptName +
                ", assignments=" + assignments +
                ", registeredStudents=" + studentsStr +
                ", isAssignmentWeightValid=" + isAssignmentWeightValid() +
                '}';
    }
}