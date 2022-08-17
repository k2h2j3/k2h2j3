package Algorithm.BFS;
//빙산
import java.io.IOException;
import java.util.*;

public class baekjoon2206 {
    static int R,C;
    static int[] mr = {-1,0,1,0};
    static int[] mc = {0,-1,0,1};
    static boolean[][] check;
    static int[][] map;

    public static class Melt{
        Melt(int r2, int c2, int cnt){
            row2 = r2;
            col2 = c2;
            count = cnt;

        } int row2, col2, count;
    }
    public static class Point{
        Point(int r, int c){
            row = r;
            col = c;

        }int row,col;
    }
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);

        R = sc.nextInt();
        C = sc.nextInt();

        map = new int[R+2][C+2];

        for(int i = 1; i <= R; i++){
            for(int j = 1; j <= C; j++){
                map[i][j] = sc.nextInt();
            }
        }

        int year = 0;

        while(true){
            //빙하가 나눠지는 개수
            int cnt = 0;
            check = new boolean[R+2][C+2];

            for(int i = 1; i <= R; i++){
                for(int j = 1; j <= C; j++){
                    if(map[i][j] != 0 && !check[i][j]){
                        cnt++;
                        bfs(i,j);
                    }
                }
            }
            if(cnt >= 2){
                System.out.println(year);
                break;
            }
            if(cnt == 0){
                System.out.println(0);
                break;
            }
            Queue<Melt> q2 = new ArrayDeque<>();

            for(int i = 1; i <= R; i++){
                for(int j = 1; j <= C; j++){
                    int zero = 0;
                    if(map[i][j] != 0){
                        if(map[i-1][j] == 0) {
                            zero++;
                        }
                        if(map[i+1][j] == 0) {
                            zero++;
                        }
                        if(map[i][j-1] == 0) {
                            zero++;
                        }
                        if(map[i][j+1] == 0) {
                            zero++;
                        }
                        q2.add(new Melt(i,j,zero));
                    }
                }
            }

            while(!q2.isEmpty()){
                Melt melt = q2.remove();
                map[melt.row2][melt.col2] -= melt.count;
                if(map[melt.row2][melt.col2] < 0){
                    map[melt.row2][melt.col2] = 0;
                }
            }
            year++;
        }
    }
    public static void bfs(int i, int j){

        Queue<Point> q = new ArrayDeque<>();

        check[i][j] = true;
        q.add(new Point(i,j));

        while(!q.isEmpty()){
            Point now = q.remove();
            for(int t = 0; t < 4; t++){
                int nr = now.row + mr[t];
                int nc = now.col + mc[t];

                if(nr < 0 || nr > R+1 || nc < 0 || nc > C+1){
                    continue;
                }
                if(check[nr][nc]){
                    continue;
                }
                if(map[nr][nc] == 0){
                    continue;
                }
                check[nr][nc] = true;
                q.add(new Point(nr,nc));
            }
        }
    }
}
