import java.util.Scanner;

public class Pirates {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int level = 1;
            int score = 0;

            System.out.println("🏴‍☠️ Your ship has sunk! You're stranded on an island of intelligent gorillas.");
            System.out.println("To rebuild your ship, you must prove your knowledge of Python.");
            System.out.println("Answer the questions correctly to escape before the full moon rises! You have 2 hours.\n");

            while (level <= 4) { // Increased level count
                System.out.println("🌕 Level " + level);
                
                // Display question based on the current level
                switch (level) {
                    case 1 -> {
                        System.out.println("Q1: How do you assign the value 50 to a variable named 'gold' in Python?");
                    }
                    case 2 -> {
                        System.out.println("Q2: Write a 'while' loop in Python that prints numbers from 1 to 3. Define variable 'i' first. Write the code in one line using one space in between.");
                    }
                    case 3 -> {
                        System.out.println("Q3: How do you create a variable named 'score' and set it to 0?");
                    }
                    case 4 -> {
                        System.out.println("Q4: Write an 'if' statement to check if a variable 'status' is equal to 'alive'. Print 'Still alive!' Write the code in one line, with one space in between.");
                    }
                    default -> System.out.println("All levels complete! Calculating your score...");
                }
                
                boolean isCorrect = checkAnswer(scanner, getExpectedAnswer(level));

                if (isCorrect) {
                    System.out.println("Correct! Moving on to the next level.\n");
                    score += 20; // Add score only if correct
                } else {
                    System.out.println("Incorrect. The gorillas refuse to help for this question.");
                }
                level++;
            }

            System.out.println("Your total score: " + score); //score evaluation

            if (score >= 60) {
                System.out.println("🏆 You escaped the island with the help of the gorillas!");
            } else {
                System.out.println("🌕 The full moon has risen... You're stuck on the island.");
            }
        }
    }

    private static String getExpectedAnswer(int level) {
        return switch (level) {
            case 1 -> "gold = 50";
            case 2 -> "i = 1 while i <= 3: print(i) i += 1";
            case 3 -> "score = 0";
            case 4 -> "if status == 'alive': print(\"Still alive!\")";
            default -> "";
        };
    }

    private static boolean checkAnswer(Scanner scanner, String correctAnswer) {
        System.out.println("Your answer:");
        String userAnswer = scanner.nextLine().trim();
        return userAnswer.equals(correctAnswer); // Check the user's answer
    }
}