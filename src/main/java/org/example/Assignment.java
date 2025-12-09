package org.example;
import lombok.Getter;
import lombok.Setter;
import java.util.ArrayList;
import java.util.Random;

@Getter
@Setter
public class Assignment {
    private String assignmentId;
    private String assignmentName;
    private double weight;
    private ArrayList<Integer> scores;
    private static int nextId = 1;

    public Assignment(String assignmentName, double weight) {
        this.assignmentName = assignmentName;
        this.weight = weight;
        this.scores = new ArrayList<>();
        this.assignmentId = String.format("A%02d", nextId++);
    }

    /**
     * Calculates Assignments Average
     */
    public void calcAssignmentAvg() {
        if (scores == null || scores.isEmpty()) {
            System.out.println("No scores available for assignment: " + assignmentName);
            return;
        }

        double sum = 0;
        int count = 0;

        for (Integer score : scores) {
            if (score != null) {
                sum += score;
                count++;
            }
        }

        if (count > 0) {
            double avg = sum / count;
            System.out.println("Average for " + assignmentName + ": " + avg);
        } else {
            System.out.println("No valid scores to calculate average for " + assignmentName);
        }
    }

    /**
     * generated random score for the assignment
     */
    public void generateRandomScore() {
        Random random = new Random();
        for (int i = 0; i < scores.size(); i++) {
            int randGroup = random.nextInt(11);
            int score;

            switch (randGroup) {
                case 0 -> score = random.nextInt(60);
                case 1, 2 -> score = 60 + random.nextInt(10);
                case 3, 4 -> score = 70 + random.nextInt(10);
                case 5, 6, 7, 8 -> score = 80 + random.nextInt(10);
                case 9, 10 -> score = 90 + random.nextInt(11);
                default -> score = 0;
            }
            scores.set(i, score);
        }
    }

}
