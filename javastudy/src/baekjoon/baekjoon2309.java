package baekjoon;

import java.util.Arrays;
import java.util.Scanner;
public class baekjoon2309 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[9];
        int sum = 0;

        for(int i= 0 ; i < 9; i++){
            int input = sc.nextInt();
            arr[i] = input;
            sum = sum + arr[i];
        }
        Arrays.sort(arr);
        int spyA = 0;
        int spyB = 0;

        for(int i = 0; i < arr.length - 1; i++) {
            for(int j = i + 1; j < arr.length; j++){
                if(sum - arr[i] - arr[j] == 100){
                    spyA = i;
                    spyB = j;
                    break;
                }
            }
        }
        for(int i =0; i < arr.length; i++){
            if(i == spyA || i == spyB){
                continue;
            }
            System.out.println(arr[i]);
        }

    }
}
