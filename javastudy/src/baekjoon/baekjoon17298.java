package baekjoon;
//스택 문제
import java.io.IOException;
import java.util.*;

public class baekjoon17298 {

    public static void main(String[] args) throws IOException {
        Scanner sc  = new Scanner(System.in);
        int A = sc.nextInt();
        Stack<Integer> stack = new Stack<>();
        int[] arr = new int[A];

        for(int i = 0; i < A; i++){
            arr[i] = sc.nextInt();
        }

        int[] result = new int[A];

        for(int i = 0; i < A; i++){
            while(!stack.isEmpty() && arr[stack.peek()] < arr[i]){
                int idx = stack.pop();
                arr[idx] = arr[i];
            }
            stack.push(i);
        }

        while(!stack.isEmpty()){
            int idx = stack.pop();
            arr[idx] = -1;
        }
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < result.length; i++){
            sb.append(arr[i]).append(' ');
        }
        System.out.println(sb);

    }

}
