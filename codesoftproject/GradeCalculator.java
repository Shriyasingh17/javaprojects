import java.util.Scanner;

public class GradeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Student Grade Calculator");
        System.out.print("Enter the number of subjects: ");
        int numSubjects = scanner.nextInt();

        if (numSubjects <= 0) {
            System.out.println("Invalid number of subjects. Exiting...");
            return;
        }

        int[] grades = new int[numSubjects];
        int sum = 0;

        for (int i = 0; i < numSubjects; i++) {
            System.out.print("Enter the grade for subject " + (i + 1) + ": ");
            grades[i] = scanner.nextInt();

            // Validate input grade (assuming grades are between 0 and 100)
            if (grades[i] < 0 || grades[i] > 100) {
                System.out.println("Invalid grade entered. Please enter a grade between 0 and 100.");
                i--; // Go back to the same subject for re-entry
            } else {
                sum += grades[i];
            }
        }

        // Calculate average grade
        double average = (double) sum / numSubjects;

        // Display results
        System.out.println("Grades entered:");
        for (int i = 0; i < numSubjects; i++) {
            System.out.println("Subject " + (i + 1) + ": " + grades[i]);
        }
        System.out.println("Average grade: " + average);

        scanner.close();
    }
}
