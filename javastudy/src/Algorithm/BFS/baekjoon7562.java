package Algorithm.BFS;

import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class baekjoon7562 {
    //{상,하,좌,우}
    //왼쪽 위 이동
    static int[] mr = {2,1,-1,-2,-2,-1,1,2};
    static int[] mc = {1,2,2,1,-1,-2,-2,-1};

    static int N;
    static Character[][] chess;
    static boolean[][] check;

    public static class Point{
        Point(int r, int c, int t){
            row = r;
            col = c;
            time = t;
        }int row,col,time;
    }

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int T = sc.nextInt();

        for(int tc = 0; tc < T; tc++){

            N = sc.nextInt();

            int Start_c = sc.nextInt();
            int Start_r = sc.nextInt();

            int End_c = sc.nextInt();
            int End_r = sc.nextInt();

            int result = bfs(Start_c, Start_r, End_c, End_r);
            sb.append(result).append('\n');
        }
        System.out.println(sb);
    }

    public static int bfs(int S_c, int S_r, int E_c, int E_r){

        Queue<Point> q = new ArrayDeque<>();
        check = new boolean[N][N];

        check[S_r][S_c] = true;
        q.add(new Point(S_r,S_c,0));

        while(!q.isEmpty()){

            Point now = q.remove();
            if(now.row == E_r && now.col == E_c){
                return now.time;
            }
            for(int i = 0; i < 8; i++){
                int nr = now.row + mr[i];
                int nc = now.col + mc[i];

                if(nr < 0 || nr > N-1 || nc < 0 || nc > N-1){
                    continue;
                }
                if(check[nr][nc]){
                    continue;
                }
                check[nr][nc] = true;
                q.add(new Point(nr,nc,now.time+1));
            }
        }
        return -1;
    }
}
