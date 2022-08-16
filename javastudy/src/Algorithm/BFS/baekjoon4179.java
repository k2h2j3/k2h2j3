package Algorithm.BFS;

//불!
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class baekjoon4179 {

    static int[] moveR = {-1,0,1,0};
    static int[] moveC = {0,-1,0,1};

    static Character[][] box;
    static int[][] timeAttack;
    static int[][] timeAttack_J;
    static boolean[][] check;
    static boolean[][] check2;

    public static class Point{
        Point(int r, int c, int t){
            row = r;
            col = c;
            time = t;
        }
        int row, col, time;
    }
    static int R,C;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        //행
        R = Integer.parseInt(st.nextToken());
        //열
        C = Integer.parseInt(st.nextToken());

        box = new Character[R][C];

        int F_row = 0;
        int F_col = 0;

        int J_row = 0;
        int J_col = 0;

        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                if(line.charAt(j) == 'F'){
                    F_row = i;
                    F_col = j;
                }
                else if(line.charAt(j) == 'J'){
                    J_row = i;
                    J_col = j;
                }
                box[i][j] = line.charAt(j);
            }
        }

        Bfs_F(F_row, F_col);
        int result = Bfs_J(J_row, J_col);

        if(result == -1){
            System.out.println("IMPOSSIBLE");
        }
        else{
            System.out.println(result);
        }

        /*for(int i = 0; i < R; i++){
            for(int j = 0; j<C; j++){
                System.out.print(timeAttack[i][j]);
            }
            System.out.println();
        }

        System.out.println();

        for(int i = 0; i < R; i++){
            for(int j = 0; j<C; j++){
                System.out.print(timeAttack_J[i][j]);
            }
            System.out.println();
        }*/

    }

    public static void Bfs_F(int S_row, int S_col) {

        timeAttack = new int[R][C];
        for(int i = 0; i < R; i++){
            for(int j = 0; j<C; j++){
                timeAttack[i][j] = 2000;
            }
        }

        check = new boolean[R][C];
        Queue<Point> q = new ArrayDeque<>();

        for(int i = 0; i < R; i++){
            for(int j = 0; j<C; j++){
                if(box[i][j] == 'F'){
                    check[S_row][S_col] = true;
                    q.add(new Point(i,j,1));
                }
            }
        }

        Point now = null;

        while(!q.isEmpty()){
            now = q.remove();

            for(int i = 0; i < 4; i++){
                int nr = now.row + moveR[i];
                int nc = now.col + moveC[i];

                if(nr < 0 || nr > R-1 || nc < 0 || nc > C-1){
                    continue;
                }
                else if(check[nr][nc] == true){
                    continue;
                }
                else if(box[nr][nc] == '#'){
                    continue;
                }
                check[nr][nc] = true;
                timeAttack[nr][nc] = now.time;
                q.add(new Point(nr, nc, now.time+1));
            }
        }

    }

    public static int Bfs_J(int S_row, int S_col) {

        timeAttack_J = new int[R][C];
        check2 = new boolean[R][C];
        Queue<Point> q2 = new ArrayDeque<>();

        check2[S_row][S_col] = true;
        q2.add(new Point(S_row,S_col,1));

        Point now = null;

        while(!q2.isEmpty()){
            now = q2.remove();

            for(int i = 0; i < 4; i++){
                int nr = now.row + moveR[i];
                int nc = now.col + moveC[i];

                if(nr < 0 || nr > R-1 || nc < 0 || nc > C-1){
                    return now.time;
                }
                else if(check2[nr][nc] == true){
                    continue;
                }
                else if(timeAttack[nr][nc] <= now.time){
                    continue;
                }
                else if(box[nr][nc] == '#' || box[nr][nc] == 'F'){
                    continue;
                }

                check2[nr][nc] = true;
                timeAttack_J[nr][nc] = now.time;
                q2.add(new Point(nr, nc, now.time+1));
            }
        }
        return -1;

    }
}
