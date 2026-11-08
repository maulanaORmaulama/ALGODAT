public class Main {
    public static void main(String[] args) {
        String expr1 = "A + B * (C - D)";
        System.out.println("Infix   : " + expr1);
        System.out.println("Postfix : " + InfixProcessor.toPostfix(expr1));
        System.out.println("Prefix  : " + InfixProcessor.toPrefix(expr1));

        System.out.println("-----------------------------------------");

        String expr2 = "3 + 5 * (2 ^ 3 - 4) / 2";
        System.out.println("Infix   : " + expr2);
        System.out.println("Postfix : " + InfixProcessor.toPostfix(expr2));
        System.out.println("Prefix  : " + InfixProcessor.toPrefix(expr2));
        System.out.println("Result  : " + InfixProcessor.evaluate(expr2));
    }
}
