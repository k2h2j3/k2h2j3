package SW_JAVA.AcademySolveD4;
import java.util.*;

//SW Academy 1210 : 사다리 타기 1
public class ladder1 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        for(int tc = 1; tc <= 10; tc++){
            int ladderNum = sc.nextInt();
            int[][] ladder = new int[100][100];

            //사다리 배열 생성
            for(int i = 0; i < ladder.length; i++){
                for(int j = 0; j < ladder[i].length; j++){
                    int input = sc.nextInt();
                    ladder[i][j] = input;
                }
            }

            int result = findX(ladder);
            System.out.println("#" + tc + " " + result);

        }

    }

    public static int findX(int[][] ladder){
        int Xindex = 0;
        for(int i = 0; i < 100; i++) {
            int row = 0;
            int col = i;
            int[][] passed = new int[100][100];
            passed[row][col] = 1;
            if (ladder[0][col] == 1) {
                while (row < 100) {
                    if (ladder[99][col] == 2) {
                        Xindex = i;
                        break;
                    }
                    if (col - 1 >= 0 && ladder[row][col - 1] == 1 && passed[row][col] == 0) {
                        col--;
                        passed[row][col] = 1;
                    } else if (col + 1 < 100 && ladder[row][col + 1] == 1 && passed[row][col] == 0) {
                        col++;
                        passed[row][col] = 1;
                    } else {
                        row++;
                        if (row < 100) {
                            passed[row][col] = 1;
                        }
                    }
                }

            }
        }
        return Xindex;
    }


}

