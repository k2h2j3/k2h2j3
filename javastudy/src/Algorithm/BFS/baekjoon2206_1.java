package Algorithm.BFS;

//2206_1 내가 처음에 만든 문제풀이 (브루트 포스 + bfs)
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class baekjoon2206_1 {
    static int R,C;
    static int[] mr = {-1,0,1,0};
    static int[] mc = {0,-1,0,1};
    static boolean[][] check;
    static int[][] map;

    public static class Point{
        Point(int r, int c, int t){
            row = r;
            col = c;
            time = t;

        }int row,col,time;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new int[R][C];

        for(int i = 0; i < R; i++){
            String line = br.readLine();
            for(int j = 0; j < C; j++){
                map[i][j] = Character.getNumericValue(line.charAt(j));
            }
        }

        boolean[][] check_break = new boolean[R][C];
        int cnt = 0;
        int[] result = new int[R*C];

        for(int i = 0; i < R; i ++){
            for(int j = 0; j < C; j++){
                if(map[i][j] == 1 && !check_break[i][j]){
                    map[i][j] = 0;
                    check_break[i][j] = true;

                    result[cnt] = bfs();
                    cnt++;
                    map[i][j] = 1;
                }
            }
        }

        for(int i = 0; i < result.length; i++){
            if(result[i] <= 0){
                result[i] = 10000000;
            }  }

        Arrays.sort(result);

        if(result[0] == 10000000){
            System.out.println(-1);
        }
        else{
            System.out.println(result[0]);
        }
    }

    public static int bfs(){

        check = new boolean[R][C];
        Queue<Point> q = new ArrayDeque<>();

        check[0][0] = true;
        q.add(new Point(0,0,1));

        while(!q.isEmpty()){
            Point now = q.remove();
            if(now.row == R-1 && now.col == C-1){
                return now.time;
            }
            for(int i = 0; i < 4; i++){
                int nr = now.row + mr[i];
                int nc = now.col + mc[i];

                if(nr < 0 || nr > R-1 || nc < 0 || nc > C-1){
                    continue;
                }
                if(map[nr][nc] == 1){
                    continue;
                }
                if(check[nr][nc]){
                    continue;
                }
                check[nr][nc] = true;
                q.add(new Point(nr, nc, now.time+1));
            }
        }
        return -1;
    }
}
