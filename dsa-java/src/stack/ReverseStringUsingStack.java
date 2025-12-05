package stack;

import java.util.Stack;

public class ReverseStringUsingStack {
    public static void main(String[] args) {
        String s = "ABCD";
        Stack<Character> stack = new Stack<>();
        char[] cha =  s.toCharArray();
        for(char c: cha) {
            stack.push(c);
        }
        for(int i=0;i<cha.length;i++){
            cha[i] = stack.pop();
        }
        String news = new String(cha);
        System.out.println(news);
    }
}
