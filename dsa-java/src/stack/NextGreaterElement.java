package stack;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElement {

    public static int[] nextGreaterElements(int[] nums) {
        int[] newArr = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        for(int i=nums.length-1;i>=0;i--) {
            if (!stack.isEmpty()) {
                while(!stack.isEmpty() && nums[i]>=stack.peek()) {
                    stack.pop();
                }

            }
            if(stack.isEmpty()) {
                newArr[i] = -1;
            } else {
                newArr[i] = stack.peek();
            }
            stack.push(nums[i]);
        }
        return newArr;

    }

    public static void main(String[] args) {
        Arrays.stream(nextGreaterElements(new int[]{4, 7, 3, 4, 8, 1})).forEach(System.out::print);
    }
}
