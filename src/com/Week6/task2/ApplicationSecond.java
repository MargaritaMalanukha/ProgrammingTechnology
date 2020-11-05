package com.Week6.task2;

import java.util.Arrays;

public class ApplicationSecond {

    private static String createSymbolString(char input, char s) {
        int size = Integer.parseInt(String.valueOf(s));
        char[] array = new char[size];
        Arrays.fill(array, input);
        return new String(array);
    }

    private static boolean isBetween(char input, char start, char end) {
        return input >= start && input <= end;
    }

    private static boolean isRight(String input) {
        int countNumbers = 0;
        if (Character.isDigit(input.charAt(0))) return false;
        char current = input.charAt(0);

        for (int i = 0; i < input.length(); i++) {
            if (current == input.charAt(i) && i != 0) return false;
            else current = input.charAt(i);

            if (Character.isDigit(input.charAt(i))) {
                int parsedDigit = Integer.parseInt(String.valueOf(input.charAt(i)));
                if (parsedDigit == 0 || parsedDigit == 1) return false;
            }

            if (isBetween(input.charAt(i), '2', '9')) countNumbers++;
            else countNumbers = 0;
            if (countNumbers == 2) return false;
        }
        return true;
    }

    public static void main(String[] args) {

    //    String input = args[0];
        String input = "Hhelo";

        if (!input.equals("") && isRight(input)) {
            StringBuilder stringBuilder = new StringBuilder();
            char current = input.charAt(0);
            boolean isAdded = false;
            for (int i = 1; i < input.length(); i++) {

                if (isBetween(input.charAt(i), '2', '9')) {
                    String str = createSymbolString(current, input.charAt(i));
                    stringBuilder.append(str);
                    isAdded = true;
                } else {
                    if (!isAdded) {
                        stringBuilder.append(current);
                    }
                    current = input.charAt(i);
                    isAdded = false;
                }
            }
            if (!isAdded) stringBuilder.append(current);
            System.out.println(stringBuilder);

        } else {
            System.out.println();
        }

    }

}
