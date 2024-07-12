import java.util.Scanner;

public class QuizApplication {
    private static Scanner scanner = new Scanner(System.in);
    private static int score = 0;
    private static int questionCount = 0;
    private static boolean quizOver = false;

    public static void main(String[] args) {
        System.out.println("Welcome to the Quiz!");
        System.out.println("You will have 10 seconds to answer each question.");

        while (!quizOver) {
            startQuestion();
            questionCount++;
        }

        System.out.println("Quiz over! Final score: " + score);
        scanner.close();
    }

    private static void startQuestion() {
        // Simulate a question with answer choices
        System.out.println("\nQuestion " + (questionCount + 1) + ": What is 10 + 5?");
        System.out.println("A. 15    B. 20    C. 25    D. 30");

        // Start timer
        Thread timerThread = new Thread(new TimerThread());
        timerThread.start();

        // Prompt for answer
        System.out.print("Your answer: ");
        String userAnswer = scanner.nextLine().toUpperCase();

        // Stop timer
        timerThread.interrupt();

        // Check answer
        if (userAnswer.equals("C")) {
            System.out.println("Correct!");
            score++;
        } else {
            System.out.println("Incorrect!");
        }

        // Check if more questions or end quiz
        if (questionCount < 5) { // Change the number to adjust the number of questions
            System.out.println("Moving to the next question...");
        } else {
            quizOver = true;
        }
    }

    static class TimerThread implements Runnable {
        @Override
        public void run() {
            try {
                Thread.sleep(10000); // 10 seconds timer
                System.out.println("\nTime's up!");
                quizOver = true;
            } catch (InterruptedException e) {
                // Timer was interrupted by user entering answer
            }
        }
    }
}
