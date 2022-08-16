package Algorithm.BFS;

import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class baekjoon5014 {

    static int F,S,G,U,D;

    static boolean check[];

    public static class Point{
        Point(int l, int c){
            locate = l;
            cnt = c;

        }int locate,cnt;
    }

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);

        F = sc.nextInt();
        S = sc.nextInt();
        G = sc.nextInt();
        U = sc.nextInt();
        D = sc.nextInt();

        int result = bfs(S);

        if(result == -1){
            System.out.println("use the stairs");
        }
        else{
            System.out.println(result);
        }

    }

    public static int bfs(int S){

        Queue<Point> q = new ArrayDeque<>();
        check = new boolean[F+1];

        check[S] = true;
        q.add(new Point(S,0));

        int[] moving  = {U,-D};

        while(!q.isEmpty()){

            Point now = q.remove();
            if(now.locate == G){
                return now.cnt;
            }
            for(int i = 0; i < 2; i++){
                int nl = now.locate + moving[i];

                if(nl < 1 || nl > F){
                    continue;
                }
                if(check[nl]){
                    continue;
                }

                check[nl] = true;
                q.add(new Point(nl,now.cnt +1));
            }
        }
        return -1;
    }
}
