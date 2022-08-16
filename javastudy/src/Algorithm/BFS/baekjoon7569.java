package Algorithm.BFS;
//토마토(3차원배열)
import java.io.IOException;
import java.util.*;

public class baekjoon7569{
    static int[] mr = {0,0,-1,1,0,0};
    static int[] mc = {0,0,0,0,-1,1};
    static int[] mh = {-1,1,0,0,0,0};
    static int[][][] box;
    static boolean[][][] check;

    static int C,R,H;

    public static class Point{
        Point(int h, int r, int c, int t){
            row = r;
            col = c;
            height = h;
            time = t;
        }int row,col,height,time;
    }

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);

        C = sc.nextInt();
        R = sc.nextInt();
        H = sc.nextInt();

        box = new int[H][R][C];
        check = new boolean[H][R][C];

        for(int i = 0; i < H; i++){
            for(int j = 0; j < R; j++){
                for(int k = 0; k < C; k++){
                    box[i][j][k] = sc.nextInt();
                }
            }
        }

        int result = bfs();
        int fail = 0;

        for(int i = 0; i < box.length; i++){
            for(int j = 0; j < box[i].length; j++){
                for(int k = 0; k < box[i][j].length; k++){
                    if(box[i][j][k] == 0) {
                        fail++;
                    }
                }
            }
        }

        if(fail > 0){
            System.out.println(-1);
        }
        else{
            System.out.println(result);
        }
    }
    public static int bfs(){

        Queue<Point> q = new ArrayDeque<>();

        for(int i = 0; i < box.length; i++) {
            for (int j = 0; j < box[i].length; j++) {
                for (int k = 0; k < box[i][j].length; k++) {
                    if (box[i][j][k] == 1 && !check[i][j][k]) {
                        check[i][j][k] = true;
                        q.add(new Point(i,j,k,0));
                    }
                }
            }
        }

        Point now = new Point(0,0,0,0);

        while(!q.isEmpty()){
            now = q.remove();

            for(int i = 0; i < 6; i++){
                int nh = now.height + mh[i];
                int nr = now.row + mr[i];
                int nc = now.col + mc[i];

                if(nh < 0 || nh > H-1 || nr < 0 || nr > R-1 || nc < 0 || nc > C-1){
                    continue;
                }
                if(box[nh][nr][nc] == -1){
                    continue;
                }
                if(check[nh][nr][nc]){
                    continue;
                }

                check[nh][nr][nc] = true;
                box[nh][nr][nc] = 1;
                q.add(new Point(nh,nr,nc,now.time+1));
            }
        }
        return now.time;
    }
}
