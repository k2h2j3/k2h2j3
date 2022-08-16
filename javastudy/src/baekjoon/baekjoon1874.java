package baekjoon;

import java.io.*;
import java.util.*;

public class baekjoon1874 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<Integer>();

        int T = sc.nextInt();
        int start = 0;


        for(int tc = 0; tc<T; tc++){

            int input = sc.nextInt();

            if(input > start) {

                for(int i = start+1; i <= input; i++) {
                    stack.push(i);
                    sb.append('+').append('\n');
                }
                start = input;
            } else if (stack.peek() != input) {
                System.out.print("NO");
                return;
            }

            stack.pop();
            sb.append('-').append('\n');
        }

        System.out.println(sb);

    }
}
