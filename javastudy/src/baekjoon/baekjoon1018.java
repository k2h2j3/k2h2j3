package baekjoon;

import java.io.*;
import java.util.*;

public class baekjoon1018 {
    public static boolean[][] arr;
    public static int result = 64;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        int col = sc.nextInt();

        arr = new boolean[row][col];

        for (int i = 0; i < row; i++) {
            String X_Line = sc.next();
            for (int j = 0; j < col; j++) {
                if (X_Line.charAt(j) == 'W') {
                    arr[i][j] = true;
                } else {
                    arr[i][j] = false;
                }
            }
        }

        int new_row = row - 7;
        int new_col = col - 7;

        for (int i = 0; i < new_row; i++) {
            for (int j = 0; j < new_col; j++) {
                find(i, j);
            }
        }
        System.out.println(result);
    }

    public static void find(int row, int col){
        int end_row = row + 8;
        int end_col = col + 8;
        int cnt  = 0;

        boolean check_1st = arr[row][col];

        for(int i = row; i < end_row; i++){
            for(int j = col; j < end_col; j++){
                if(check_1st != arr[i][j]){
                    cnt++;
                }

                check_1st = (!check_1st);
            }

            check_1st = !check_1st;
        }

        cnt = Math.min(cnt, 64 - cnt);
        result = Math.min(result, cnt);


    }
}
