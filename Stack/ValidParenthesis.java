package Stack;

import java.util.Stack;

public class ValidParenthesis {

    public boolean isPair(char opening, char closing) {
        return (opening=='(' && closing==')') ||
                (opening=='[' && closing==']') ||
                (opening=='{' && closing=='}');
    }


    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(char ch : s.toCharArray()) {
            if(!stack.isEmpty() && isPair(stack.peek(), ch)) {
                stack.pop();
            }
            else {
                stack.push(ch);
            }
        }
        return stack.isEmpty();
    }
}
