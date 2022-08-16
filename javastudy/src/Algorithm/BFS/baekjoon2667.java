package Algorithm.BFS;
//단지 번호 붙이기
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class baekjoon2667{
    static int[] mr = {-1,0,1,0};
    static int[] mc = {0,-1,0,1};

    static int N;
    static Integer[][] map;
    static boolean[][] check;

    static int cnt = 0;

    public static class Point{
        Point(int r, int c){
            row = r;
            col = c;
        }int row,col;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        map = new Integer[N][N];

        for(int i = 0 ; i < N; i++){
            String line = br.readLine();
            for(int j = 0; j < N; j++){
                map[i][j] = Character.getNumericValue(line.charAt(j));
            }
        }

        check = new boolean[N][N];
        int cnt =0;
        int[] arr = new int[N*N];

        for(int i = 0 ; i < N; i++){
            for(int j = 0; j < N; j++){
                if(map[i][j] == 1 && !check[i][j]){
                    int result = bfs(i,j);
                    arr[cnt] = result;
                    cnt++;
                }
            }
        }
        Arrays.sort(arr);
        for(int i = 0; i < arr.length; i++){
            if(arr[i] > 0){
                sb.append(arr[i]).append('\n');
            }
        }

        System.out.println(cnt);
        System.out.println(sb);

    }
    public static int bfs(int r, int c){

        Queue<Point> q = new ArrayDeque<>();

        check[r][c] = true;
        q.add(new Point(r,c));
        int cnt = 0;

        while(!q.isEmpty()){
            Point now = q.remove();
            cnt++;

            for(int i = 0; i < 4; i++){
                int nr = now.row + mr[i];
                int nc = now.col + mc[i];

                if(nr < 0 || nr > N-1 || nc < 0 || nc > N-1){
                    continue;
                }
                if(map[nr][nc] == 0){
                    continue;
                }
                if(check[nr][nc]){
                    continue;
                }
                check[nr][nc] = true;
                q.add(new Point(nr,nc));
            }
        }
        return cnt;
    }
}
