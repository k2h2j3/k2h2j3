package Algorithm.BFS;
//유기농 배추
import java.io.IOException;
import java.util.*;

public class baekjoon1012{
    static int[] mr = {-1,0,1,0};
    static int[] mc = {0,-1,0,1};

    static boolean[][] check;
    static int[][] map;

    public static class Point{

        Point(int r, int c){
            row = r;
            col = c;
        }int row, col;
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for(int tc = 0; tc < T; tc++){

            int C = sc.nextInt();
            int R = sc.nextInt();

            map = new int[R][C];
            check = new boolean[R][C];

            Queue<Point> q = new ArrayDeque<>();

            int num = sc.nextInt();
            for(int i = 0; i < num; i++){
                int col_num = sc.nextInt();
                int row_num = sc.nextInt();
                map[row_num][col_num] = 1;
            }

            int cnt = 0;
            for(int i = 0; i < R; i++){
                for(int j = 0; j < C; j++){
                    if(map[i][j] == 1 && !check[i][j]){
                        cnt++;
                        bfs(R,C,i,j);
                    }
                }
            }
            System.out.println(cnt);
        }
    }

    public static void bfs(int row, int col, int r, int c){

        Queue<Point> q = new ArrayDeque<>();

        check[r][c] = true;
        q.add(new Point(r,c));

        while(!q.isEmpty()){

            Point now = q.remove();

            for(int i = 0; i < 4; i++){
                int now_r = now.row + mr[i];
                int now_c = now.col + mc[i];

                if(now_r < 0 || now_r > row-1 || now_c < 0 || now_c > col -1){
                    continue;
                }
                if(check[now_r][now_c]){
                    continue;
                }
                if(map[now_r][now_c] == 0){
                    continue;
                }

                check[now_r][now_c] = true;
                q.add(new Point(now_r, now_c));
            }
        }
    }
}
