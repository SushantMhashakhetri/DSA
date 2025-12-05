package stack;
import java.util.Stack;

public class BalancedBrackets {

    public  static boolean isBalanced(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c: s.toCharArray()) {
            if(c=='['|| c=='{' || c== '(') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                } else {
                 if (
                         c== ']' && stack.peek() == '[' ||
                         c== '}' && stack.peek() == '{' ||
                         c== ')' && stack.peek() == '('

                 ){
                        stack.pop();
                 } else {
                     return false;
                 }
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isBalanced("{([)]}"));
    }
}
