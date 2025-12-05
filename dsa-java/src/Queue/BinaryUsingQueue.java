package Queue;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryUsingQueue {

    public static String[] binary(int n) {
        Queue<String> queue = new LinkedList<>();
        String[] result = new String[n];
        queue.offer("1");
        for (int i=0;i<n;i++){
            result[i] = queue.poll();
            String n1= result[i]+"0";
            String n2= result[i]+"1";
            queue.offer(n1);
            queue.offer(n2);


        }
        return result;

    }

    public static void main(String[] args) {
        String[] s= binary(10);
       Arrays.stream(s).forEach(System.out::println);
    }
}
