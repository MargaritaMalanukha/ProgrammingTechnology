package com.Week7;

import java.util.Deque;
import java.util.LinkedList;

public class Application {

    private static final Deque<Double> intStack = new LinkedList<>();
    private static final String CONST_OPERATORS = "+-*/";

    public static double parse(String rpnString){
        double result;

        for (int i = 0; i < rpnString.length(); i++) {
            if (Character.isDigit(rpnString.charAt(i))) {
                i += addFullNumber(rpnString, i);
            } else if (isOperator(rpnString.charAt(i))) {
                if (intStack.size() >= 2) {
                    result = operate(rpnString.charAt(i), intStack.pollFirst(), intStack.pollFirst());
                    intStack.add(result);
                } else {
                    throw new RPNParserException();
                }
            } else if (rpnString.charAt(i) != ' ') {
                throw new RPNParserException();
            }
        }

        return intStack.poll();

    }

    private static double operate(char operator, double d1, double d2) {
        if (operator == '/' && d1 == 0 && d2 == 0) throw new ArithmeticException();
        return switch (operator) {
            case '+' -> d1 + d2;
            case '-' -> d1 - d2;
            case '*' -> d1 * d2;
            case '/' -> d1 / d2;
            default -> throw new RPNParserException();
        };
    }

    private static int addFullNumber(String rpnString, int startIndex) {

        int count = 0;
        StringBuilder result = new StringBuilder();
        char current = rpnString.charAt(startIndex);
        while (current != ' ') {
            if (!Character.isDigit(current)) throw new RPNParserException();
            else {
                result.append(current);
            }

            if (rpnString.length() != startIndex + count) {
                current = rpnString.charAt(++startIndex);
            } else break;

            count++;

        }
        intStack.add((double) Integer.parseInt(result.toString()));
        return count;


    }

    private static boolean isOperator(char ch) {

        for (int i = 0; i < CONST_OPERATORS.length(); i++) {
            if (ch == CONST_OPERATORS.charAt(i)) return true;
        }
        return false;
    }

    public static void main(String[] args) {

        String rpnString = "10 20 + 30 40 + *";
        double result = parse(rpnString);
        System.out.println(result);
    }

}
