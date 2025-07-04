package coding;

import java.util.*;

class Question {
    String question, optionA, optionB, optionC, optionD, correctOption;

    public Question(String question, String a, String b, String c, String d, String correct) {
        this.question = question;
        this.optionA = a;
        this.optionB = b;
        this.optionC = c;
        this.optionD = d;
        this.correctOption = correct.toUpperCase();
    }

    public boolean ask(Scanner sc) {
        System.out.println("\n🔹 " + question);
        System.out.println("A. " + optionA);
        System.out.println("B. " + optionB);
        System.out.println("C. " + optionC);
        System.out.println("D. " + optionD);
        System.out.print("👉 Your answer (A/B/C/D): ");

        String userAnswer = sc.nextLine().trim().toUpperCase();

        if (userAnswer.equals(correctOption)) {
            System.out.println("✅ Correct!");
            return true;
        } else {
            System.out.println("❌ Wrong! Correct answer is " + correctOption);
            return false;
        }
    }
}

public class quizgame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        printWelcome();

        List<Question> questions = new ArrayList<>();
        questions.add(new Question("Which language is used for Android app development?", "Java", "Python", "C#", "PHP", "A"));
        questions.add(new Question("What does HTML stand for?", "Hot Mail", "Hyper Trainer Marking Language", "HyperText Markup Language", "HyperText Markdown Language", "C"));
        questions.add(new Question("Who invented Java programming?", "Dennis Ritchie", "James Gosling", "Bjarne Stroustrup", "Guido van Rossum", "B"));
        questions.add(new Question("What is the default value of int in Java?", "0", "1", "null", "undefined", "A"));

        int score = 0;

        for (int i = 0; i < questions.size(); i++) {
            System.out.println("\n📍 Question " + (i + 1) + " of " + questions.size());
            boolean correct = questions.get(i).ask(sc);
            if (correct) score++;
        }

        System.out.println("\n🎉 Quiz Finished!");
        System.out.println("🔢 Your Score: " + score + "/" + questions.size());

        if (score == questions.size()) {
            System.out.println("🏆 Excellent! You're a quiz master!");
        } else if (score >= questions.size() / 2) {
            System.out.println("👍 Good job! Keep practicing.");
        } else {
            System.out.println("📚 Don’t worry! Try again and learn more.");
        }

        sc.close();
    }

    static void printWelcome() {
        System.out.println("===================================");
        System.out.println("       🎮 Welcome to Quiz Game      ");
        System.out.println("===================================");
        System.out.println("📝 Answer the following questions:");
    }
}
