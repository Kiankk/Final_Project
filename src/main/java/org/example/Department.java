package org.example;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode
public class Department {
    private String departmentId;
    private String departmentName;
    private static int nextId = 1;

    /**
     * Checks whether the department name is valid or not
     * @param departmentName that user inputs
     * @return whether the name is valid or not
     */
    public static boolean isDepartmentNameValid(String departmentName) {
        if (departmentName == null || departmentName.isEmpty()) {
            return false;
        }

        for (char c : departmentName.toCharArray()) {
            if (!Character.isLetter(c) && c != ' ') {
                return false;
            }
        }
        return true;
    }

    public Department(String departmentName) {
        if (isDepartmentNameValid(departmentName)) {
            this.departmentName = departmentName;
            this.departmentId = String.format("D%02d", nextId);
            nextId++;
        } else {
            this.departmentName = null;
            this.departmentId = null;
        }
    }

    public void setDepartmentName(String departmentName) {
        if (isDepartmentNameValid(departmentName)) {
            this.departmentName = Util.toTitleCase(departmentName);
        } else {
            System.out.println("Error: Invalid Department Name.");
        }
    }
}
