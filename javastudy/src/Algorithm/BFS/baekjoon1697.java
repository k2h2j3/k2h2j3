package Algorithm.BFS;

import java.io.IOException;
import java.util.*;

public class baekjoon1697{
    public static class Point{
        Point(int m,int t){
            me = m;
            time = t;
        }
        int me,time;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {

        Scanner sc = new Scanner(System.in);

        int me = sc.nextInt();
        int sister = sc.nextInt();

        int result = bfs(me,sister);
        System.out.println(result);

    }
    public static int bfs(int me,int sister){

        boolean[] check = new boolean[200000];
        Queue<Point> q = new ArrayDeque<>();

        check[me] = true;
        q.add(new Point(me,0));

        while(!q.isEmpty()){

            Point now = q.remove();

            if(now.me == sister){
                return now.time;
            }

            if(now.me + 1 <= 199999 && !check[now.me+1]){
                check[now.me+1] = true;
                q.add(new Point(now.me+1, now.time+1));
            }
            if(now.me * 2 <= 199999 && !check[now.me*2]){
                check[now.me*2] = true;
                q.add(new Point(now.me*2, now.time+1));
            }
            if(now.me - 1 >= 0 && !check[now.me-1]){
                check[now.me-1] = true;
                q.add(new Point(now.me-1, now.time+1));
            }
        }
        return -1;
    }
}
