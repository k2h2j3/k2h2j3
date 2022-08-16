//SW Academy 1218 괄호 검사

package SW_JAVA.AcademySolveD4;

import java.util.Scanner;
import java.util.Stack;

public class Stack1 {public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    for (int tc = 1; tc <= 10; tc++) {

        //괄호검사할 문자길이 입력
        int length = sc.nextInt();
        //문자열로 입력받기
        String input = sc.next();
        boolean result = stackexam(input);

        if(result == true){
            System.out.println("#"+ tc + " " + 1);
        }
        else{
            System.out.println("#" + tc + " " + 0);
        }


    }

}
    //스택함수 구현
    public static boolean stackexam(String input){
        Stack<Character> stack = new Stack<Character>();
        stack.clear();
        boolean condition = false;
        for(int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if(c == '(' || c == '{' || c == '[' || c == '<'){
                stack.push(c);
            }
            else if(c == ')' && stack.peek() == '('){
                stack.pop();
            }
            else if(c == '}' && stack.peek() == '{'){
                stack.pop();
            }
            else if(c == ']' && stack.peek() == '['){
                stack.pop();
            }
            else if(c == '>' && stack.peek() == '<'){
                stack.pop();
            }
            else{
                break;
            }

        }
        if(stack.isEmpty()){
            condition = true;
        }
        return condition;

    }



}
