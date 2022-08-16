package Algorithm.BFS;

import java.io.IOException;
import java.util.*;

//미로탐색

public class baekjoon1926 {

    static class Point {
        Point(int r, int c) {
            row = r;
            col = c;
        }
        int row, col, area;
    }
    static final int Max_N = 500;
    static int[] mr = {-1, 0, 1, 0};
    static int[] mc = {0, -1, 0, 1};
    static int[][] sketchbook = new int[Max_N][Max_N];
    static int N;
    static int M;

    static boolean[][] check = new boolean[Max_N][Max_N];


    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sketchbook[i][j] = sc.nextInt();
            }
        }

        //그림 개수
        int cnt = 0;
        int Max = 0;
        int ar = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (sketchbook[i][j] == 0 || check[i][j] == true) {
                    continue;
                }
                cnt++;
                ar = bfs(i, j);
                if(ar > Max){
                    Max = ar;
                }

            }
        }
        System.out.println(cnt);
        System.out.println(Max);

    }

    public static int bfs(int S_row, int S_col) {

        Queue<Point> que = new ArrayDeque<>();

        check[S_row][S_col] = true;
        Point start = new Point(S_row, S_col);
        que.add(start);
        int area = 0;

        while (!que.isEmpty()) {
            Point now = que.remove();
            area++;

            for (int i = 0; i < 4; i++) {
                int nr = now.row + mr[i];
                int nc = now.col + mc[i];
                if (nr < 0 || nr > N - 1 || nc < 0 || nc > M - 1) {
                    continue;
                } else if (check[nr][nc] == true) {
                    continue;
                } else if (sketchbook[nr][nc] == 0) {
                    continue;
                }
                check[nr][nc] = true;
                que.add(new Point(nr, nc));
            }
        }
        return area;
    }

}
