package com.Week7;

import java.util.Deque;
import java.util.LinkedList;

public class Application {

    private static final Deque<Integer> numbers = new LinkedList<>();
    private static final Deque<Character> operators = new LinkedList<>();
    private static final String CONST_OPERATORS = "+-*/";

    private static boolean isOperator(char ch) {

        for (int i = 0; i < CONST_OPERATORS.length(); i++) {
            if (ch == CONST_OPERATORS.charAt(i)) return true;
        }
        return false;
    }

    private static boolean isRight(String input) {
        for (int i = 0; i < input.length(); i++) {
            if (!Character.isDigit(input.charAt(i)) ||
                    !isOperator(input.charAt(i)) || input.charAt(i) != ' ') return false;
        }
    }

    private static String getFullNumber(String str, int indexStart) {

    }

    public static double parse(String rpnString) {

        if (isRight(rpnString)) {
            for (int i = 0; i < rpnString.length(); i++) {
                if (Character.isDigit(rpnString.charAt(i))) {
                    Integer number = Integer.parseInt(getFullNumber(rpnString, i));
                    numbers.add(number);
                }
            }

        } else {
            throw new RPNParserException();
        }



    }

}
