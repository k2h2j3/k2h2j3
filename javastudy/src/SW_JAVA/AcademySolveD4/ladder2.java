package SW_JAVA.AcademySolveD4;

import java.util.Scanner;
import java.util.*;

//SW Academy 1211 : 사다리 타기 2(최단경로 구하기)
public class ladder2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);


        for (int tc = 1; tc <= 10; tc++) {
            int[][] ladder = new int[100][100];
            int N = sc.nextInt();


            //사다리 배열 만들기
            for (int i = 0; i < ladder.length; i++) {
                for (int j = 0; j < ladder[i].length; j++) {
                    int input = sc.nextInt();
                    ladder[i][j] = input;
                }
            }
            //사다리 이동거리 값을 저장하는 변수
            int[] data = countLength(ladder);

            int min = data[0];
            int result = 0;
            for (int i = 0; i < data.length; i++){
                if(data[i] != 0 && min >= data[i]){
                    min = data[i];
                    result = i;
                }
            }
            System.out.println("#" + tc + " " + result);
        }

    }

    public static int[] countLength(int[][] ladder) {
        int[] length = new int[100];

        for(int i = 0; i < 100; i++) {
            int row = 0;   int col = i;
            int cnt = 0;
            int[][] passed = new int[100][100];
            passed[row][col] = 1;
            if (ladder[row][col] == 0) {
                continue;
            }
            while (row < 100) {
                if (col - 1 >= 0 && ladder[row][col - 1] == 1 && passed[row][col-1] == 0) {
                    col--;
                    passed[row][col] = 1;
                } else if (col + 1 < 100 && ladder[row][col + 1] == 1 && passed[row][col+1] == 0) {
                    col++;
                    passed[row][col] = 1;
                } else {
                    row++;
                    if (row < 100) {
                        passed[row][col] = 1;
                    }
                }
                cnt++;
            }
            length[i] = cnt;

        }
        return length;
    }

}
