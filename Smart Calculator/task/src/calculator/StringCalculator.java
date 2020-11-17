package calculator;

import java.math.BigInteger;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class StringCalculator {

    Variables variables = new Variables();

    public List<String> toPostfixNotation(List<String> list) {
        List<String> answer = new ArrayList<>();
        Deque<String> stack = new ArrayDeque<>();
        int i = 0;
        while (i != list.size()) {
            if (list.get(i).matches("[\\-\\+]")) {
                if (stack.size() != 0 && stack.getLast().matches("[\\-\\+\\*/]")) {
                    answer.add(stack.pollLast());
                    stack.offerLast(list.get(i));
                } else {
                    stack.offerLast(list.get(i));
                }
            } else if (list.get(i).matches("[\\*/]")) {
                if (stack.size() != 0 && stack.getLast().matches("[\\*/]")) {
                    answer.add(stack.pollLast());
                    stack.offerLast(list.get(i));
                } else {
                    stack.offerLast(list.get(i));
                }
            } else if (list.get(i).equals("(")) {
                stack.offerLast(list.get(i));
            } else if (list.get(i).equals(")")) {
                while (!stack.getLast().equals("(")) {
                    answer.add(stack.pollLast());
                }
                stack.pollLast();
            } else if (list.get(i).matches("\\D+")) {
                answer.add(variables.getVariable(list.get(i)).toString());
            } else {
                answer.add(list.get(i));
            }
            i++;
        }
        while (stack.size() != 0) {
            answer.add(stack.pollLast());
        }
        return answer;
    }

    public BigInteger calculate(List<String> postfix) {
        Deque<String> stack = new ArrayDeque<>();
        int i = 0;
        while (i != postfix.size()) {
            if (!isOperator(postfix.get(i))) {
                stack.offerLast(postfix.get(i));
                i++;
            } else {
                BigInteger a = new BigInteger(stack.pollLast());
                BigInteger b = new BigInteger(stack.pollLast());
                if (postfix.get(i).equals("+")) {
                    stack.offerLast(b.add(a).toString());
                }
                if (postfix.get(i).equals("-")) {
                    stack.offerLast(b.subtract(a).toString());
                }
                if (postfix.get(i).equals("*")) {
                    stack.offerLast(b.multiply(a).toString());
                }
                if (postfix.get(i).equals("/")) {
                    stack.offerLast(b.divide(a).toString());
                }
                i++;
            }
        }
        return new BigInteger(stack.pollLast());
    }

    public boolean isOperator(String s) {
        return s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/");
    }

    public void handleVariables(String str) throws Exception {
        //System.out.println(str);
        String[] arr = str.split("=");
        ///System.out.println(arr[1].trim());
        if (arr[1].trim().matches("\\D+")) {
            //System.out.println("arr[1].trim().matches(\"\\\\D+\")");
            if (!variables.isVariable(arr[1].trim())) {
                throw new Exception("Unknown variable");
            }
            variables.add(arr[0].trim(), variables.getVariable(arr[1].trim()));
        } else {
            variables.add(arr[0].trim(), new BigInteger(arr[1].trim()));
        }
    }

}


