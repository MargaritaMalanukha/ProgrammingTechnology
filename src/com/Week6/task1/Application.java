package com.Week6.task1;

public class Application {

    public static void main(String[] args) {

        String input = args[0];

        if (!input.equals("")) {
            StringBuilder stringBuilder  = new StringBuilder();

            char current = input.charAt(0);
            char c;
            int countCurrentChar = 1;
            for (int i = 1; i <= input.length(); i++) {
                c = i < input.length() ? input.charAt(i) : 0;
                if (i == input.length() || countCurrentChar == 9 || current != c) {
                    stringBuilder.append(current);
                    if (countCurrentChar > 1) {
                        stringBuilder.append(countCurrentChar);
                    }
                    countCurrentChar = 1;
                    current = c;
                } else countCurrentChar++;
            }

            System.out.println(stringBuilder);
        } else {
            System.out.println();
        }
    }

}
