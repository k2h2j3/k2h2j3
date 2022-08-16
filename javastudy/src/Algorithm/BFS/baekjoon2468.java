package Algorithm.BFS;

import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;

public class baekjoon2468 {
    static int N;
    static int[] mr = {-1,0,1,0};
    static int[] mc = {0,-1,0,1};
    static boolean[][] check;
    static int[][] map;

    public static class Point{
        Point(int r, int c){
            row = r;
            col = c;

        }int row,col;
    }

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        map = new int[N][N];

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                map[i][j] = sc.nextInt();
            }
        }

        int[] result = new int[101];
        int cnt = 0;

        for(int r = 0; r < 101; r++){
            cnt = 0;
            check = new boolean[N][N];

            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    if(map[i][j] > r && !check[i][j]){
                        cnt++;
                        bfs(i,j,r);
                    }
                }
            }
            result[r] = cnt;
        }
        Arrays.sort(result);
        System.out.print(result[100]);
    }

    public static void bfs(int r,int c, int rain){

        Queue<Point> q = new ArrayDeque<>();

        check[r][c] = true;
        q.add(new Point(r,c));

        while(!q.isEmpty()){
            Point now = q.remove();
            for(int i = 0; i < 4; i++){
                int nr = now.row + mr[i];
                int nc = now.col + mc[i];

                if(nr < 0 || nr > N-1 || nc < 0 || nc > N-1){
                    continue;
                }
                if(map[nr][nc] <= rain){
                    continue;
                }
                if(check[nr][nc]){
                    continue;
                }

                check[nr][nc] = true;
                q.add(new Point(nr, nc));
            }
        }
    }
}
