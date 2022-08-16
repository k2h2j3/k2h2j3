//monotonic stack 구현 함수 2
package Algorithm.Stack;

import java.util.*;

public class baekjoon6549 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Stack<Integer> stack = new Stack<>();

        int N = sc.nextInt();
        int[] arr = new int[N];

        for(int i = 0; i < N; i++ ){
            arr[i] = sc.nextInt();
        }

        long Max = 0;

        for(int i = 0; i < arr.length; i++){
            while(!stack.empty() && arr[stack.peek()] > arr[i]){
                int idx = stack.pop();
                int height = arr[idx];
                long width = i;
                if(!stack.empty()){
                    width -= stack.peek() + 1;
                }
                Max = Math.max(Max, height*width);
            }
            stack.push(i);
        }

        while(!stack.empty()){
            int idx = stack.pop();
            int height = arr[idx];
            long width = N;
            if(!stack.empty()){
                width -= stack.peek() + 1;
            }
            Max = Math.max(Max , height*width);
        }
        System.out.println(Max);

    }
}
