package calculator;

public class ErrorHandler {

    public boolean isUnknownCommand(String s) {
        return s.matches("^/.*");
    }

    public boolean isInvalidExpression(String s) {
        String s1 = s.replaceAll("\\s+", "");
        if (s1.matches("[\\+\\.\\,\\-]")) {
            //System.out.println("[\\+\\.\\,\\-]");
            return true;
        }

        if (s1.matches("\\D+=[\\D\\d]+")) {
            //System.out.println("\\D+=[\\D\\d]+");
            return false;
        }

        if (s1.matches(".*\\*{2,}.*")) {
            return true;
        }
        if (s1.matches(".*/{2,}.*")) {
            return true;
        }


        if (!s1.matches("[\\D0-9\\+\\-\\.\\,]+")) {
            //System.out.println("[\\D0-9\\+\\-\\.\\,]+");
            return true;
        }
        if (s1.matches(".*[\\-\\+\\.\\,]$")) {
            //System.out.println(".*[\\-\\+\\.\\,]$");
            return true;
        }
        if (!parenthesisEquality(s)) {
            //System.out.println("!parenthesisEquality(s)");
            return true;
        }
        return false;
    }

    public boolean isInvalidAssignment(String s) {
        String s1 = s.replaceAll("\\s+", "");
        if (s1.matches(".+=.+=.+")) {
            return true;
        }
        if (s1.matches(".*=.*\\d.*\\D.*")) {
            return true;
        }
        return false;
    }

    public boolean isInvalidIdentifier(String s) {
        String s1 = s.replaceAll("\\s+", "");
        if (s1.matches(".*[^a-zA-Z]+.*=.*")) {
            return true;
        }
        return false;
    }

    public boolean parenthesisEquality(String expression) {
        int left = 0;
        int right = 0;
        for (int i = 0; i < expression.length(); i++) {
            if (expression.charAt(i) == '(') {
                left++;
            }
            if (expression.charAt(i) ==')') {
                right++;
            }
        }
        return left == right;
    }
}
