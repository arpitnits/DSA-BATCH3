package Stack;

import java.util.Stack;

public class InfixToPostFix {

    public static int priority(char operator) {
        switch (operator) {
            case '+':
            case '-':
                return 1;

            case '*':
            case '/':
                return 2;

            case '^':
                return 3;

        }
        return -1;
    }

    public static boolean isOperand(char ch) {
        return (ch>='A' && ch<='Z') || (ch>='a' && ch<='z') || (ch>='0' && ch<='9');
    }

    /*
    If operand, then add it to the postFix expression
    If the operator then checks priority, if top is greater or equal, then pop all those and push after it.
    If ‘(’ → add to stack
    if ‘)’ → pop all the element till you got ‘(’

    */
    public static String infixToPostfix(String infix) {
        StringBuilder postFix = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        //operand -> Opening bracket -> closing -> operator
        for(char ch : infix.toCharArray()) {
            if(isOperand(ch)) {
                postFix.append(ch);
            } else if(ch=='(') {
                stack.push('(');
            } else if(ch==')') {
                while(!stack.isEmpty() && stack.peek()!='(') {
                    postFix.append(stack.pop());
                }
                stack.pop();
            } else {
                while(!stack.isEmpty() && priority(stack.peek())>=priority(ch)) {
                    postFix.append(stack.pop());
                }
                stack.push(ch);
            }
        }

        while (!stack.isEmpty()) {
            postFix.append(stack.pop());
        }

        return postFix.toString();
    }

    public static void main(String[] args) {
        String infix = "A+B*(C*D-E)*(F+G*H)-I";
        System.out.println(infixToPostfix(infix));
    }
}

