package Algorithm.Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class baekjoon4949{


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String line;

        while(true){

            line = br.readLine();

            Stack<Character> stack = new Stack<>();

            if(line.equals(".")){
                break;
            }

            for(int i = 0; i < line.length(); i++){

                char c = line.charAt(i);
                if(c == '(' || c == '['){
                    stack.push(c);
                }
                else if(c == ')') {
                    if (stack.isEmpty() || stack.peek() != '(') {
                    } else {
                        stack.pop();
                    }
                }
                else if(line.charAt(i) == ']'){
                    if(stack.isEmpty() || stack.peek() != '[' ){
                    }
                    else{
                        stack.pop();
                    }
                }
            }
            if(!stack.isEmpty()){
                sb.append("no").append('\n');
            }
            else{
                sb.append("yes").append('\n');
            }
        }
        System.out.println(sb);
    }
}