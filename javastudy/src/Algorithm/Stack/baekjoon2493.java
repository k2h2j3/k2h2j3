package Algorithm.Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class baekjoon2493 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] str = br.readLine().split(" ");

        Stack<Integer> height = new Stack<Integer>();
        Stack<Integer> index = new Stack<Integer>();
        for(int i = 0; i < N; i++){
            int topheight = Integer.parseInt(str[i]);
            while(!height.isEmpty()){
                if(height.peek() >= topheight){
                    System.out.print(index.peek() + " ");
                    break;
                } else{
                    height.pop();
                    index.pop();
                }
            }
            if(height.empty()){
                System.out.print(0 + " ");
            }
            height.push(topheight);
            index.push(i+1);
        }

    }

}
