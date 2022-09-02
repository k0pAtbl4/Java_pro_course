package lesson15;

import java.util.HashMap;
import java.util.Stack;

public class InfixToPostfixTranslator {
    private final HashMap<String, Integer> operators;

    public InfixToPostfixTranslator() {
        this.operators = new HashMap<>();
        operators.put("/", 3);
        operators.put("*", 3);
        operators.put("-", 2);
        operators.put("+", 2);
        operators.put("(", 1);
    }

    public String InfixToPostfix(String infExpression) {
        Stack<String> stack = new Stack<>();
        String[] expressionPart = infExpression.split(" ");
        String postExpression = "";
        String digits = "0123456789";

        for(int i = 0; i < expressionPart.length; i++) {
            if (digits.contains(expressionPart[i])) {
                postExpression += expressionPart[i] + " ";
            } else if (expressionPart[i].equals("(")) {
                stack.push(expressionPart[i]);
            } else if (expressionPart[i].equals(")")) {
                String topToken = stack.pop();
                while (!topToken.equals("(")) {
                    postExpression += topToken + " ";
                    topToken = stack.pop();
                }
            } else {
                while (!stack.isEmpty() && (operators.get(stack.peek()) >= operators.get(expressionPart[i]))) {
                    postExpression += stack.pop() + " ";
                }
                stack.push(expressionPart[i]);
            }
        }
        while (!stack.isEmpty()) {
            postExpression += stack.pop() + " ";
        }

        return postExpression;
    }

    public double calculator(String postfix) {
        postfix = postfix.substring(0, postfix.length() - 1);
        String nums = "0123456789";
        String[] postfixPart = postfix.split(" ");
        Stack<Double> stack = new Stack<>();

        for (String part : postfixPart) {
            if (nums.contains(part)) {
                stack.push(Double.parseDouble(part));
            } else {
                Double left = stack.pop();
                Double right = stack.pop();
                Double result = 0.0;
                switch(part) {
                    case "*" -> result = left * right;
                    case "/" -> result = left / right;
                    case "+" -> result = left + right;
                    case "-" -> result = left - right;
                }
                stack.push(result);
            }
        }

        return stack.pop();
    }
}
