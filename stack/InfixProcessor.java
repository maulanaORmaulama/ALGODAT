public class InfixProcessor {

    private static int precedence(char op) {
        switch (op) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
            default:
                return -1;
        }
    }

    private static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/' || c == '^';
    }

    // Convert Infix to Postfix
    public static String toPostfix(String infix) {
        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < infix.length(); i++) {
            char c = infix.charAt(i);

            if (Character.isWhitespace(c)) {
                continue;
            }

            if (Character.isLetterOrDigit(c)) {
                while (i < infix.length() && Character.isLetterOrDigit(infix.charAt(i))) {
                    result.append(infix.charAt(i));
                    i++;
                }
                result.append(' ');
                i--;
            } else if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    result.append(stack.pop()).append(' ');
                }
                if (!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();
                }
            } else if (isOperator(c)) {
                while (!stack.isEmpty() && stack.peek() != '(' &&
                        (precedence(c) < precedence(stack.peek()) ||
                         (precedence(c) == precedence(stack.peek()) && c != '^'))) {
                    result.append(stack.pop()).append(' ');
                }
                stack.push(c);
            }
        }

        while (!stack.isEmpty()) {
            result.append(stack.pop()).append(' ');
        }

        return result.toString().trim();
    }

    // Convert Infix to Prefix
    public static String toPrefix(String infix) {
        Stack<String> operands = new Stack<>();
        Stack<Character> operators = new Stack<>();

        for (int i = 0; i < infix.length(); i++) {
            char c = infix.charAt(i);

            if (Character.isWhitespace(c)) {
                continue;
            }

            if (Character.isLetterOrDigit(c)) {
                StringBuilder sb = new StringBuilder();
                while (i < infix.length() && Character.isLetterOrDigit(infix.charAt(i))) {
                    sb.append(infix.charAt(i));
                    i++;
                }
                operands.push(sb.toString());
                i--;
            } else if (c == '(') {
                operators.push(c);
            } else if (c == ')') {
                while (!operators.isEmpty() && operators.peek() != '(') {
                    String op2 = operands.pop();
                    String op1 = operands.pop();
                    char op = operators.pop();
                    operands.push(op + " " + op1 + " " + op2);
                }
                if (!operators.isEmpty() && operators.peek() == '(') {
                    operators.pop();
                }
            } else if (isOperator(c)) {
                while (!operators.isEmpty() && operators.peek() != '(' &&
                        (precedence(c) < precedence(operators.peek()) ||
                         (precedence(c) == precedence(operators.peek()) && c != '^'))) {
                    String op2 = operands.pop();
                    String op1 = operands.pop();
                    char op = operators.pop();
                    operands.push(op + " " + op1 + " " + op2);
                }
                operators.push(c);
            }
        }

        while (!operators.isEmpty()) {
            String op2 = operands.pop();
            String op1 = operands.pop();
            char op = operators.pop();
            operands.push(op + " " + op1 + " " + op2);
        }

        return operands.isEmpty() ? "" : operands.pop();
    }

    //Infix
    public static double evaluate(String infix) {
        String postfix = toPostfix(infix);
        Stack<Double> stack = new Stack<>();
        String[] tokens = postfix.split("\\s+");

        for (String token : tokens) {
            if (token.isEmpty()) continue;

            if (token.length() == 1 && isOperator(token.charAt(0))) {
                double b = stack.pop();
                double a = stack.pop();
                switch (token.charAt(0)) {
                    case '+': stack.push(a + b); break;
                    case '-': stack.push(a - b); break;
                    case '*': stack.push(a * b); break;
                    case '/': stack.push(a / b); break;
                    case '^': stack.push(Math.pow(a, b)); break;
                }
            } else {
                stack.push(Double.parseDouble(token));
            }
        }
        return stack.pop();
    }
}
