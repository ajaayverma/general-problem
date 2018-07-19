package com.in28minutes.springboot.basics.springbootin10steps;

import java.util.Stack;

public class PolishNotation {
    public Double evaluate(String expression) {
        String[] tokens = expression.split(" ");
        Stack<String> opratorStack = new Stack<>();
        Stack<Double> operandStack = new Stack<>();
        Double operand1;
        Double operand;
        String operator;
        boolean pendingOperator = false;
        for (String token : tokens) {
            switch (token) {
                case "+":
                case "-":
                case "*":
                case "/":
                    opratorStack.push(token);
                    pendingOperator = false;
                    break;
                default:
                    if (!pendingOperator) {
                        operandStack.push(Double.parseDouble(token));
                        pendingOperator = true;
                    } else {
                        operand = Double.parseDouble(token);
                        while (!operandStack.empty()) {
                            operand1 = operandStack.pop();
                            operator = opratorStack.pop();
                            switch (operator) {
                                case "+":
                                    operand = operand1 + operand;
                                    break;
                                case "-":
                                    operand = operand1 - operand;
                                    break;
                                case "*":
                                    operand = operand1 * operand;
                                    break;
                                case "/":
                                    operand = operand1 / operand;
                                    break;
                                default:
                                    break;
                            }
                        }
                        operandStack.push(operand);
                        pendingOperator = true;
                    }
            }
        }
        return operandStack.pop();
    }

    public static void main(String[] args) {
       //System.out.println(new PolishNotation().evaluate("- * / 15 - 7 + 1 1 3 + 2 + 1 1"));

        Character c  = "+".charAt(0);
        System.out.println((int)c);
    }
}
