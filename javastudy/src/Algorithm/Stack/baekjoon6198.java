package Algorithm.Stack;
//monotonic stack 활용 문제
import java.io.IOException;
import java.util.*;

public class baekjoon6198 {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Stack<Integer> stack = new Stack<Integer>();
        long cnt = 0;

        for(int i = 0; i < N; i++){
            int height = sc.nextInt();
            while(!stack.isEmpty() && stack.peek() <= height) {
                stack.pop();
            }
            stack.push(height);
            cnt += stack.size()-1;
        }
        System.out.println(cnt);

    }

}
