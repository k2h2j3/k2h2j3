//SW Academy 1217 거듭제곱
package SW_JAVA.AcademySolveD3;

import java.util.Scanner;

public class Recursive1 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        for(int tc = 1; tc <= 10; tc++) {
            int T = sc.nextInt();
            int N = sc.nextInt();
            int M = sc.nextInt();

            int result = MathX(N,M);
            System.out.println("#" + tc + " " + result);
        }
    }

    static int MathX(int N, int M){
        if(M == 0) {
            return 1;
        }
        else{
            return N * MathX(N,M-1);
        }
    }
}
