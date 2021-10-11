package com.srihita.balancedbrackets.processor.input;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class BalancedBracketsInput {
    private char[] brackets;
    private ArrayList<Character> leftBrackets = new ArrayList<Character>(Arrays.asList('(', '[', '{'));
    private ArrayList<Character> rightBrackets = new ArrayList<Character>(Arrays.asList(')', ']', '}'));

    public char[] getBrackets() {
        return brackets;
    }

    public void processInput() {
        Scanner sc = new Scanner(System.in);
        boolean validInput = true;
        char[] temp;
        do {
            System.out.println("Please input the brackets string to be processed");
            String brackets = sc.nextLine();
            temp = brackets.toCharArray();
            for (int i = 0; i < temp.length; i++) {
                if (isTypeOfLeftBracket(temp[i]) || isTypeOfRightBracket(temp[i])) {
                    continue;
                } else {
                    validInput = false;
                    break;
                }
            }
            if (!validInput) {
                System.out.println("Invalid Input: " + brackets);
                System.out.println("Input should have only ( { [  ] } ) characters");
            }
        } while (!validInput);
        this.brackets = temp;

    }

    public boolean isTypeOfLeftBracket(Character input) {
        return leftBrackets.contains(input);
    }

    public boolean isTypeOfRightBracket(Character input) {
        return rightBrackets.contains(input);
    }
}

