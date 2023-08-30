// Claire Lindstrom CMSC350: Contains the methods to convert prefix to postfix and postfix to prefix.

package conversion;

import java.util.Stack;

public class Converter {

    /**
     * This method takes e a prefix expression and turn it into its postfix .
     * 
     * @param prefixExpression - The prefix math expression we're starting with.
     * @return The converted postfix expression.
     */
    public static String convertPrefixToPostfix(String prefixExpression) {
        // This stack reverses the order of tokens
        Stack<String> tokenReversalStack = new Stack<>();

        // building our postfix expression using this stack
        Stack<String> intermediateResultsStack = new Stack<>();

        // breaks them into individual tokens
        String[] tokens = prefixExpression.split("");

        // Looping through tokens and pushing non-space ones onto our reversal stack
        for (String currentToken : tokens) {
            if (!currentToken.equals(" ")) {
                tokenReversalStack.push(currentToken);
            }
        }

        // while statement that takes off the reversal stack and builds the postfix
        // expression.
        while (!tokenReversalStack.isEmpty()) {
            String extractedToken = tokenReversalStack.pop();

            // If it's a number (or operand), just push it onto our results stack.
            if (isOperand(extractedToken)) {
                intermediateResultsStack.push(extractedToken);
            } else {
                // If it's an operator, we pop two operands, combine them with the operator, and
                // push back.
                String firstOperand = intermediateResultsStack.pop();
                String secondOperand = intermediateResultsStack.pop();
                String combinedExpression = firstOperand + secondOperand + extractedToken;
                intermediateResultsStack.push(combinedExpression);
            }
        }

        // Returns the postfix expression.
        return intermediateResultsStack.pop();
    }

    /**
     * This method takes a postfix expression and converts it to prefix.
     * 
     * @param postfixExpression - The postfix math expression we're starting with.
     * @return The converted prefix expression.
     */
    public static String convertPostfixToPrefix(String postfixExpression) {
        // This stack will help us build the prefix expression.
        Stack<String> intermediateResultsStack = new Stack<>();

        // Breaking the expression into individual tokens.
        String[] tokens = postfixExpression.split("");

        // Looping through tokens to build our prefix expression.
        for (String currentToken : tokens) {
            if (isOperand(currentToken)) {
                intermediateResultsStack.push(currentToken);
            } else {
                // For operators, we pop two operands, combine them with the operator at the
                // front, and push back.
                String secondOperand = intermediateResultsStack.pop();
                String firstOperand = intermediateResultsStack.pop();
                String combinedExpression = currentToken + firstOperand + secondOperand;
                intermediateResultsStack.push(combinedExpression);
            }
        }

        // prefix expression is ready.
        return intermediateResultsStack.pop();
    }

    /**
     * method to check if a token is an operand or an operator.
     * 
     * @param token - The token we're checking.
     * @return True if it's an operand, false otherwise.
     */
    public static boolean isOperand(String token) {
        // If it's not one of the basic operators, we assume it's an operand.
        return !("+".equals(token) || "-".equals(token) || "*".equals(token) || "/".equals(token));
    }
}
