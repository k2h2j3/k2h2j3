package baekjoon;

import java.io.*;
import java.util.*;

public class baekjoon1978 {
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);

        int M = sc.nextInt();
        int N = sc.nextInt();
        int[] arr = new int[10000];
        int Min = 10000;
        int sum = 0;

        for(int i = M; i <= N; i++){
            int cnt = 0;
            for(int j = 1; j<= i; j++ ){
                if(i % j == 0){
                    cnt++;
                }

            }if(cnt == 2){
                arr[i] = i;
            }
        }
        Arrays.sort(arr);
        for(int i = 0; i < arr.length; i++){
            if(arr[i] != 0 && arr[i] < Min){
                Min = arr[i];
            }
            sum = sum + arr[i];
        }
        if(sum == 0) {
            System.out.print(-1);
        }
        else{
            System.out.println(sum);
            System.out.println(Min);
        }


    }


}
