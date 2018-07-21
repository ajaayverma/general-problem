import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;


public class Calc {

    public Double evaluate(String expr) {
        // TODO: Your code here
        if (expr.isEmpty()) {
            return 0.0;
        }

        final String[] tokens = expr.trim().split(" ");

        if (isValidExpression(tokens)) {
            return calculateValue(tokens);
        } else {
            return null; //Handled invalid expression condition
        }

    }

    private double calculateValue(String[] tokens) {
        Stack<Double> stack = new Stack<>();
        for (String token : tokens) {
            double secondOperand;
            double firstOperand;
            switch (token) {
                case "+":
                    firstOperand = stack.pop();
                    secondOperand = stack.pop();
                    stack.push(secondOperand + firstOperand);
                    break;

                case "-":
                    firstOperand = stack.pop();
                    secondOperand = stack.pop();
                    stack.push(secondOperand - firstOperand);
                    break;

                case "*":
                    firstOperand = stack.pop();
                    secondOperand = stack.pop();
                    stack.push(secondOperand * firstOperand);
                    break;

                case "/":
                    firstOperand = stack.pop();
                    secondOperand = stack.pop();
                    stack.push(secondOperand / firstOperand);
                    break;

                default:
                    if (!token.isEmpty()) {
                        stack.push(Double.parseDouble(token));
                        break;
                    }
            }
        }
        return stack.pop();
    }

    private boolean isValidExpression(String[] tokens) {
        final List<String> collect = Arrays.stream(tokens).filter(t -> t.length() > 1 && (t.contains("+") ||
                t.contains("-") ||
                t.contains("*") ||
                t.contains("/"))).collect(Collectors.toList());
        return collect.size() == 0;
    }

    public static void main(String[] args) {
        new Calc().evaluate("15 7 1 1 + - / 3 * 2 1 1 + + -");
    }

}