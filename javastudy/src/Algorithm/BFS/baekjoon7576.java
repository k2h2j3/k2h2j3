package Algorithm.BFS;

//토마토
import java.io.IOException;
import java.util.*;

public class baekjoon7576 {

    static int[] moveR = {-1,0,1,0};
    static int[] moveC = {0,-1,0,1};

    static int[][] box;
    static boolean[][] check;

    public static class Tomato{
        Tomato(int r, int c, int d){
            row = r;
            col = c;
            day = d;
        }
        int row, col, day;
    }
    static int N,M;

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);

        //행
        N = sc.nextInt();
        //열
        M = sc.nextInt();

        box = new int[M][N];

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                box[i][j] = sc.nextInt();
            }
        }

        dfs();
    }


    public static void dfs() {

        check = new boolean[M][N];
        Queue<Tomato> q = new ArrayDeque<>();

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (box[i][j] == 1) {
                    check[i][j] = true;
                    q.add(new Tomato(i, j, 0));
                }
            }
        }

        Tomato now = null;

        while(!q.isEmpty()){
            now = q.remove();

            for(int i = 0; i < 4; i++){
                int nr = now.row + moveR[i];
                int nc = now.col + moveC[i];

                if(nr < 0 || nr > M-1 || nc < 0 || nc > N-1){
                    continue;
                }
                else if(check[nr][nc] == true){
                    continue;
                }
                else if(box[nr][nc] == -1){
                    continue;
                }

                check[nr][nc] = true;
                box[nr][nc] = 1;
                q.add(new Tomato(nr, nc, now.day+1));
            }
        }

        int non = 0;
        for(int i = 0; i < M; i++){
            for(int j = 0; j < N; j++){
                if(box[i][j] == 0){
                    non++;
                }
            }
        }

        if(non > 0){
            System.out.println(-1);
        }
        else{
            System.out.println(now.day);
        }
    }
}
