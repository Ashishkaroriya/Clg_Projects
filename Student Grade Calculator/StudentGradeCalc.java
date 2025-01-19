import java.util.InputMismatchException;
import java.util.Scanner;

public class StudentGradeCalc {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        byte numberOfSubjects;
        short totalMarks = 0;
        byte marks;
        double averagePercentage;
        char grade;

        while (true) {
            try {
                System.out.println("Enter the number of subjects (1-10):");
                numberOfSubjects = scanner.nextByte();
                if (numberOfSubjects < 1 || numberOfSubjects > 10) {
                    System.out.println("Please enter a number between 1 and 10.");
                } else {
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next();
            }
        }

        for (byte i = 1; i <= numberOfSubjects; i++) {
            while (true) {
                try {
                    System.out.println("Enter marks obtained in subject " + i + " (out of 100):");
                    marks = scanner.nextByte();
                    if (marks < 0 || marks > 100) {
                        System.out.println("Please enter a number between 0 and 100.");
                    } else {
                        totalMarks += marks;
                        break;
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a number.");
                    scanner.next();
                }
            }
        }

        averagePercentage = (double) totalMarks / numberOfSubjects;

        if (averagePercentage >= 90) {
            grade = 'A';
        } else if (averagePercentage >= 80) {
            grade = 'B';
        } else if (averagePercentage >= 70) {
            grade = 'C';
        } else if (averagePercentage >= 60) {
            grade = 'D';
        } else {
            grade = 'F';
        }

        System.out.println("Total Marks: " + totalMarks);
        System.out.println("Average Percentage: " + String.format("%.2f", averagePercentage) + "%");
        System.out.println("Grade: " + grade);
    }
}
