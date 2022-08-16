//로직 구현은 맞으나 시간초과 된 경우
package baekjoon;

import java.io.*;
import java.util.*;

public class baekjoon4948 {

    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);

        while(true){
            int N = sc.nextInt();
            if(N == 0){
                break;
            }
            int result = 0;
            for(int i = N; i <= 2*N; i++){
                int cnt = 0;
                for(int j = 1; j <= i; j++){
                    if(i % j == 0){
                        cnt++;
                    }
                }
                if(cnt == 2){
                    result++;
                }
            }
            System.out.println(result);


        }
    }



}
