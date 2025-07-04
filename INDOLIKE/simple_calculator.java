package coding;

import java.util.Scanner;

public class simple_calculator {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean keepRunning = true;

        printWelcome();

        while (keepRunning) {
            System.out.print("\n🔢 Enter first number: ");
            double num1 = getNumber(sc);

            System.out.print("🔢 Enter second number: ");
            double num2 = getNumber(sc);

            System.out.println("\n➕ Available Operations: +  -  *  /  %");
            System.out.print("✏️ Enter operator: ");
            String operator = sc.next();

            double result;
            boolean valid = true;

            switch (operator) {
                case "+":
                    result = num1 + num2;
                    break;
                case "-":
                    result = num1 - num2;
                    break;
                case "*":
                    result = num1 * num2;
                    break;
                case "/":
                    if (num2 == 0) {
                        System.out.println("❌ Cannot divide by zero!");
                        valid = false;
                        result = 0;
                    } else {
                        result = num1 / num2;
                    }
                    break;
                case "%":
                    if (num2 == 0) {
                        System.out.println("❌ Cannot perform modulus with zero!");
                        valid = false;
                        result = 0;
                    } else {
                        result = num1 % num2;
                    }
                    break;
                default:
                    System.out.println("❌ Invalid operator! Please use + - * / %");
                    valid = false;
                    result = 0;
            }

            if (valid) {
                System.out.println("✅ Result: " + num1 + " " + operator + " " + num2 + " = " + result);
            }

            System.out.print("\n🔁 Do you want to perform another calculation? (yes/no): ");
            String again = sc.next();
            if (!again.equalsIgnoreCase("yes")) {
                keepRunning = false;
            }
        }

        System.out.println("\n👋 Thank you for using the Simple Calculator. Goodbye!");
        sc.close();
    }

    public static double getNumber(Scanner sc) {
        while (true) {
            try {
                return sc.nextDouble();
            } catch (Exception e) {
                System.out.print("❗ Invalid number. Please enter again: ");
                sc.next(); // clear invalid input
            }
        }
    }

    public static void printWelcome() {
        System.out.println("========================================");
        System.out.println("        🧮 Welcome to Calculator         ");
        System.out.println("========================================");
        System.out.println("✨ You can perform: +  -  *  /  %");
    }
}

