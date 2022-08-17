package Algorithm.BFS;
//벽부수고 이동하기와 같은 유형의 문제
import java.io.IOException;
import java.util.*;

public class baekjoon14923 {
    static int R,C;
    static int s_row,s_col,e_row,e_col;
    static int[] mr = {-1,0,1,0};
    static int[] mc = {0,-1,0,1};
    static boolean[][][] check;
    static int[][] map;

    public static class Point{
        Point(int r, int c, int t,int b){
            row = r;
            col = c;
            time = t;
            broken = b;

        }int row,col,time,broken;
    }

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);

        R = sc.nextInt();
        C = sc.nextInt();

        s_row = sc.nextInt();
        s_col = sc.nextInt();

        e_row = sc.nextInt();
        e_col = sc.nextInt();

        map = new int[R][C];

        for(int i = 0; i < R; i++){
            for(int j = 0; j < C; j++){
                map[i][j] = sc.nextInt();
            }
        }

        int result = bfs();
        System.out.println(result);
    }

    public static int bfs(){

        check = new boolean[2][R][C];
        Queue<Point> q = new ArrayDeque<>();

        check[0][0][0] = true;
        check[1][0][0] = true;
        q.add(new Point(s_row-1,s_col-1,0,0));

        while(!q.isEmpty()){
            Point now = q.remove();
            if(now.row == e_row-1 && now.col == e_col-1){
                return now.time;
            }
            for(int i = 0; i < 4; i++){
                int nr = now.row + mr[i];
                int nc = now.col + mc[i];

                if(nr < 0 || nr > R-1 || nc < 0 || nc > C-1){
                    continue;
                }
                if(map[nr][nc] == 1 && !check[1][nr][nc] && now.broken == 0){
                    check[1][nr][nc] = true;
                    q.add(new Point(nr,nc,now.time+1, now.broken+1));
                }
                else if(map[nr][nc] == 0 && !check[now.broken][nr][nc]){
                    check[now.broken][nr][nc] = true;
                    q.add(new Point(nr,nc,now.time+1, now.broken));
                }
            }
        }
        return -1;
    }
}
