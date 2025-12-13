package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import java.util.ArrayList;
import java.util.Arrays;

public class AssignmentTest {
    @Test
    @DisplayName("calcAssignmentAvg Normal -> Runs safely")
    void testCalcAvgNormal() {
        Assignment a = new Assignment("A1", 20);
        a.setScores(new ArrayList<>(Arrays.asList(80, 90, 100)));

        Assertions.assertDoesNotThrow(() -> a.calcAssignmentAvg());
    }

    @Test
    @DisplayName("calcAssignmentAvg Empty List -> Runs safely (prints no scores)")
    void testCalcAvgEmpty() {
        Assignment a = new Assignment("A1", 20);
        Assertions.assertDoesNotThrow(() -> a.calcAssignmentAvg());
    }

    @Test
    @DisplayName("calcAssignmentAvg List with Nulls -> Runs safely (skips nulls)")
    void testCalcAvgNulls() {
        Assignment a = new Assignment("A1", 20);
        a.getScores().add(null);
        a.getScores().add(50);
        Assertions.assertDoesNotThrow(() -> a.calcAssignmentAvg());
    }

    @Test
    @DisplayName("generateRandomScore -> Populates null slots")
    void testGenerateRandomScorePopulate() {
        Assignment a = new Assignment("A1", 20);
        a.getScores().add(null);

        a.generateRandomScore();

        boolean expected = true;
        boolean actual = (a.getScores().get(0) != null);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("generateRandomScore -> Bounds Check (0-100)")
    void testGenerateRandomScoreBounds() {
        Assignment a = new Assignment("A1", 20);
        a.getScores().add(null);
        a.generateRandomScore();

        int score = a.getScores().get(0);
        boolean expected = true;
        boolean actual = (score >= 0 && score <= 100);
        Assertions.assertEquals(expected, actual);
    }
}