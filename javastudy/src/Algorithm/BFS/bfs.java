package Algorithm.BFS;

import java.io.IOException;
import java.util.*;

public class bfs {
    static final int Max_N = 10;
    static int[] mr = {-1,0,1,0}; // 상, 하 움직임
    static int[] mc = {0,-1,0,1}; // 좌 ,우 움직임
    static int[][] maze = new int[Max_N][Max_N];
    static int N;

    public static class Point{
        Point(int r, int c, int d){ // 포인트 생성자(열, 행, 거리)
            row = r;
            col = c;
            dist = d;
        }
        int row, col, dist;
    }

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);

        //미로 사이즈
        N = sc.nextInt();

        //미로 입력받아 만들기
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                maze[i][j] = sc.nextInt();
            }
        }

        //시작열, 시작행, 도착열, 도착행 입력받기
        int S_row = sc.nextInt();
        int S_col = sc.nextInt();
        int E_row = sc.nextInt();
        int E_col = sc.nextInt();

        int result = bfs(S_row, S_col, E_row, E_col);
        System.out.print(result);

    }

    public static int bfs(int S_row, int S_col, int E_row, int E_col){

        //탐색했던 경로 체크용 배열
        boolean[][] check = new boolean[Max_N][Max_N];
        //bfs에선 큐를 사용한다.
        Queue<Point> que = new ArrayDeque<>();

        //시작점 체크(큐에 넣기전에 반드시 시작점을 체크해야한다.)
        check[S_row][S_col] = true;
        Point start = new Point(S_row, S_col, 0);
        que.add(start);

        //큐가 비워질때까지 계속 탐색 후 이동
        while(!que.isEmpty()){
            Point now = que.remove();
            //목표점에 도달하면 거리값 반환
            if(now.row == E_row && now.col == E_col){
                return now.dist;
            }

            for(int i = 0; i < 4; i++){
                //열 이동
                int nr = now.row + mr[i];
                //행 이동
                int nc = now.col + mc[i];
                //미로를 벗어나게 될 경우 취소
                if(nr < 0 || nr > N-1 || nc < 0 || nc > N-1){
                    continue;
                }
                //이미 체크 되었던 곳을 갔을 경우 취소
                else if(check[nr][nc] == true){
                    continue;
                }
                //벽(1)으로 갔을 경우 취소
                else if(maze[nr][nc] == 1){
                    continue;
                }
                //이상 없을 경우 체크 배열에 true 변경(탐색전에는 false상태)
                check[nr][nc] = true;
                //큐에 넣을때마다 이동하므로 거리를 +1 추가
                Point next = new Point(nr, nc, now.dist + 1);
                que.add(next);
            }
        }
        return -1;
    }
}
