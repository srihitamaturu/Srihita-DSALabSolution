package com.srihita.balancedbrackets.driver;

import com.srihita.balancedbrackets.processor.input.BalancedBracketsInput;
import com.srihita.balancedbrackets.processor.output.BalancedBracketsOutput;

public class BalancedBracketsDriver {
    public static void main(String[] args) {
        BalancedBracketsInput bracketsInput = new BalancedBracketsInput();
        bracketsInput.processInput();
        BalancedBracketsOutput bracketsOutput = new BalancedBracketsOutput(bracketsInput);
        bracketsOutput.processBracketsInput();
    }
}
