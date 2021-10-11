package com.srihita.balancedbrackets.processor.output;

import com.srihita.balancedbrackets.processor.input.BalancedBracketsInput;

import java.util.HashMap;
import java.util.Stack;

public class BalancedBracketsOutput {
    private BalancedBracketsInput bracketsInput;
    private HashMap<Character, Character> bracketMatches;

    public BalancedBracketsOutput(BalancedBracketsInput bracketsInput) {
        this.bracketsInput = bracketsInput;
        bracketMatches = new HashMap<>();
        bracketMatches.put('}', '{');
        bracketMatches.put(']', '[');
        bracketMatches.put(')', '(');
    }

    public void processBracketsInput() {
        boolean balancedBrackets = true;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < bracketsInput.getBrackets().length; i++) {
            char c = bracketsInput.getBrackets()[i];
            if (bracketsInput.isTypeOfLeftBracket(c)) {
                stack.push(c);
            } else {
                char match = bracketMatches.get(c);
                if (stack.size() > 0) {
                    char temp = stack.pop();
                    if (temp != match) {
                        balancedBrackets = false;
                        break;
                    }
                } else {
                    balancedBrackets = false;
                    break;

                }
            }
        }
        if (stack.size() > 0) {
            balancedBrackets = false;
        }
        if (balancedBrackets)
            System.out.println("The entered String has Balanced Brackets");
        else
            System.out.println("The entered Strings do not contain Balanced Brackets");
    }
}




