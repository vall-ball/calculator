package calculator;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ErrorHandler errorHandler = new ErrorHandler();
        StringParser parser = new StringParser();
        StringCalculator calculator = new StringCalculator();

        while (true) {
            String s = scanner.nextLine();

            if ("".equals(s)) {
                continue;
            }
            if ("/help".equals(s)) {
                System.out.println("The program calculates the result of the expression");
            } else if ("/exit".equals(s)) {
                System.out.println("Bye!");
                break;
            } else if (errorHandler.isUnknownCommand(s)) {
                System.out.println("Unknown command");
            } else if (errorHandler.isInvalidExpression(s)) {
                System.out.println("Invalid expression");
            } else if (errorHandler.isInvalidIdentifier(s)) {
                System.out.println("Invalid identifier");
            } else if (errorHandler.isInvalidAssignment(s)) {
                System.out.println("Invalid assignment");
            } else if (s.contains("=")) {
                try {
                    calculator.handleVariables(s);
                } catch (Exception e) {
                    System.out.println("Unknown variable");
                }
            } else {
                try {
                    System.out.println(calculator.calculate(calculator.toPostfixNotation(parser.parseToList(s))));
                } catch (Exception e) {
                    System.out.println("Unknown variable");
                }

            }
        }
    }

}



