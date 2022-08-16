package Algorithm.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;


public class baekjoon10026 {

    static int[] mr = {-1,0,1,0};
    static int[] mc = {0,-1,0,1};

    static int N;
    static Character[][] map;
    static boolean[][] check;

    public static class Point{
        Point(int r, int c){
            row = r;
            col = c;
        }int row,col;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new Character[N][N];

        for(int i = 0; i < N; i++){
            String line = br.readLine();
            for(int j = 0; j < N; j++){
                map[i][j] = line.charAt(j);
            }
        }

        int result_1 = bfs();
        int result_2 = bfs_2();

        System.out.println(result_1);
        System.out.println(result_2);
    }

    public static int bfs(){

        Queue<Point> q = new ArrayDeque<>();
        check = new boolean[N][N];
        int cnt = 0;

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(!check[i][j]){
                    check[i][j] = true;
                    q.add(new Point(i,j));
                    cnt++;

                    while(!q.isEmpty()){
                        Point now = q.remove();
                        for(int k = 0; k < 4; k++){
                            int nr = now.row + mr[k];
                            int nc = now.col + mc[k];

                            if(nr < 0 || nr > N-1 || nc < 0 || nc > N-1){
                                continue;
                            }
                            if(map[nr][nc] != map[i][j]){
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
        }
        return cnt;
    }

    public static int bfs_2(){

        Queue<Point> q2 = new ArrayDeque<>();
        check = new boolean[N][N];
        int cnt2 = 0;

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(!check[i][j]){
                    check[i][j] = true;
                    q2.add(new Point(i,j));
                    cnt2++;

                    while(!q2.isEmpty()){
                        Point now = q2.remove();
                        for(int k = 0; k < 4; k++){
                            int nr = now.row + mr[k];
                            int nc = now.col + mc[k];

                            if(nr < 0 || nr > N-1 || nc < 0 || nc > N-1){
                                continue;
                            }
                            if(map[i][j] == 'B' && map[i][j] != map[nr][nc]){
                                continue;
                            }
                            if(map[i][j] == 'R' || map[i][j] == 'G'){
                                if(map[nr][nc] == 'B'){
                                    continue;
                                }
                            }
                            if(check[nr][nc]){
                                continue;
                            }

                            check[nr][nc] = true;
                            q2.add(new Point(nr, nc));
                        }
                    }
                }
            }
        }
        return cnt2;
    }
}
