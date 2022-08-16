package Algorithm.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class baekjoon6593 {

    static int f,r,c;
    static char[][][] map;
    static StringBuilder sb = new StringBuilder();
    static int[] mc= {-1,1,0,0,0,0};
    static int[] mr = {0,0,-1,1,0,0};
    static int[] mf = {0,0,0,0,1,-1};

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while(true) {
            st = new StringTokenizer(br.readLine());
            f = Integer.parseInt(st.nextToken());
            r = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            if(f ==0 && r==0 && c==0) {
                System.out.println(sb.toString());
                return;
            }

            int sc=0,sr=0,sf=0;
            map =new char[f][r][c];

            for(int i=0; i<f; i++) {
                for(int j=0; j<r; j++) {
                    String line = br.readLine();
                    for(int k=0; k<c; k++) {
                        map[i][j][k] = line.charAt(k);
                        if(map[i][j][k] == 'S') {
                            sc =k; sr = j; sf =i;
                            map[i][j][k] = '.';
                        }
                    }
                }
                br.readLine();
            }
            bfs(sc, sr, sf);
        }
    }

    static void bfs(int col, int row, int fl) {
        Queue<int[]> q = new ArrayDeque<>();
        boolean[][][] check = new boolean[f][r][c];

        q.add(new int[] {col,row,fl,0});
        check[fl][row][col] = true;

        while(!q.isEmpty()) {
            int[] p = q.poll();
            int px=p[0], py=p[1], pz=p[2];
            int move = p[3];

            if(map[pz][py][px]=='E') {
                sb.append("Escaped in " + move+" minute(s).\n");
                return;
            }

            for(int d=0; d<6; d++) {
                int nx = px + mc[d], ny = py + mr[d], nz = pz + mf[d];
                if(nx <0 || ny <0 || nz<0 || nx>c-1 || ny>r-1 || nz >f-1) {
                    continue;
                }
                if(check[nz][ny][nx]) {
                    continue;
                }
                if(map[nz][ny][nx]=='.' || map[nz][ny][nx]=='E') {
                    check[nz][ny][nx] = true;
                    q.add(new int[] {nx, ny, nz, move+1});
                }
            }
        }
        sb.append("Trapped!\n");
    }
}

