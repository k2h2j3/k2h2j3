package SW_JAVA;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class AcademySolve2 {

        public static void main(String[] args) {

        //D2 난이도

        //SW Academy 1926

        /*Scanner sc = new Scanner(System.in);
        int N;
        N = sc.nextInt();

        for(int i = 1; i <= N; i++ ) {
            int num = i;
            int cnt = 0; // "-" 카운트
            int clapnum;
            while (num > 0) {
                clapnum = num % 10;
                if (clapnum == 3 || clapnum == 6 || clapnum == 9)
                {
                    cnt++;
                }
                num = num / 10;

            }
            if(cnt == 0) {
                System.out.print(i);

            }
            else{
                while(cnt-- > 0){
                    System.out.print("-");
                }


            }
            System.out.print(" ");

        }
        sc.close();*/

        //SW Academy 1984

        /*Scanner sc = new Scanner(System.in);
        int T, input;
        T = sc.nextInt();



        for(int i = 1; i < T + 1; i++){
            ArrayList<Integer> list = new ArrayList<Integer>();
            double sum = 0;

            for(int j = 0; j < 10; j++) {

                input = sc.nextInt();
                list.add(input);
                list.sort(Comparator.naturalOrder());

            }
            for(int k = 1; k < 9; k++){
                sum = sum + list.get(k);

            }
            int result = (int) Math.round(sum / 8);

            System.out.print("#"+ i + " " + result);
            System.out.print("\n");
        }*/


        //SW Academy 1954(달팽이배열)

        /*Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();


        for(int i=1;i <= T; i++) {
            // N을 입력으로받기 (N * N 배열 생성)
            int N = sc.nextInt();
            // 배열안에 넣을 값(1부터 시작)
            int num = 1;

            //X좌표, Y좌표 초기화
            int Xstart = 0;
            int Ystart = 0;
            //X좌표, Y좌표 끝 위치
            int Xend = N - 1;
            int Yend = N - 1;

            // N X N 배열(달팽이배열 생성)
            int[][] arr = new int[N][N];
            //배열안에 넣을 값이 배열크기와 같을 때까지
            while(num <= N*N)
            {
                //(0,1)->(0,2)->(0,3)...(0,N-1)
                for(int move = Ystart; move <= Yend; move++){
                    arr[Xstart][move] = num;
                    num++;
                }
                //X좌표 1증가 (0,N-1) ->(1,N-1) : 기존위치에서 한칸내려서부터 값을 입력해야하기 때문
                Xstart++;

                //(1,N-1) -> (2,N-1) -> (3,N-1)...(N-1,N-1)
                for(int move = Xstart; move <= Xend; move++){
                    arr[move][Yend] = num;
                    num++;
                }
                //Y좌표 1 감소 (N-1,N-1) -> (N-1,N-2) : 기존위치에서 한칸 왼쪽부터 값을 입력해야하기 때문
                Yend--;

                //(N-1,N-2) -> (N-1,N-3) -> (N-1,N-4)...(N-1,0)
                for(int move = Yend; move >= Ystart; move--){
                    arr[Xend][move] = num;
                    num++;
                }
                //X좌표 1감소 (N-1,0) -> (N-2,0) :한칸 위에서부터 값을 입력해야하기 때문
                Xend--;

                //(N-2,0) -> (N-3,0) -> (N-4,0)... (1,0)
                for(int move = Xend; move >= Xstart; move--){
                    arr[move][Ystart] = num;
                    num++;
                }
                //Y좌표 1증가 (1,0) -> (1,1): 처음 값넣은 시점에서 좌표(1,1)씩 밀려난상태에서 다시 start
                Ystart++;

            }
            System.out.println("#"+i);
            for(int a=0;a<N;a++){
                for(int b=0;b<N;b++){
                    System.out.print(arr[a][b]+" ");
                }
                System.out.println();
            }


        }*/

        //SW Academy 1989 : 회문 찾기

           /* Scanner sc = new Scanner(System.in);
            int T;
            T = sc.nextInt();

            for(int i = 1; i <= T; i++) {
                String N;
                N = sc.next();
                char[] arr = N.toCharArray();
                int Max = arr.length;
                int result = 0;
                for(int j = 0; j < Max; j++){
                    if(arr[j] == arr[Max-j-1]){
                        result = 1;
                    }
                    else{
                        result = 0;
                    }
                }
                System.out.print("#" + i + " " + result);
                System.out.println();

            }*/

            //SW Academy 1976 : 시간 덧셈

            /*Scanner sc = new Scanner(System.in);
            int T;
            T = sc.nextInt();

            for(int i = 1; i <= T; i++) {

                int Hinput1, Hinput2;
                int Minput1, Minput2;
                int Hsum,Msum = 0;

                Hinput1 = sc.nextInt();
                Minput1 = sc.nextInt();

                Hinput2 = sc.nextInt();
                Minput2 = sc.nextInt();

                Hsum = Hinput1 + Hinput2;
                Msum = Minput1 + Minput2;

                if(Hsum > 12){
                    Hsum = Hsum % 12;
                }
                if(Msum > 60){
                    Msum = Msum - 60;
                    Hsum++;
                }
                System.out.print("#"+ i + " " + Hsum + " " + Msum);

            }*/

            //SW Academy 1970 : 거스름돈 변환기

            /*Scanner sc = new Scanner(System.in);
            int T;
            T = sc.nextInt();

            for(int i = 1; i <= T; i++) {

                int N;
                N = sc.nextInt();

                int cnt50000 = 0;
                int cnt10000 = 0;
                int cnt5000 = 0;
                int cnt1000 = 0;
                int cnt500 = 0;
                int cnt100 = 0;
                int cnt50 = 0;
                int cnt10 = 0;

                while(N >= 10){
                    if(N >= 50000){
                        cnt50000 = N / 50000;
                        N = N % 50000;
                    }
                    if(N >= 10000){
                        cnt10000 = N / 10000;
                        N = N % 10000;
                    }
                    if(N >= 5000){
                        cnt5000 = N / 5000;
                        N = N % 5000;
                    }
                    if(N >= 1000){
                        cnt1000 = N / 1000;
                        N = N % 1000;
                    }
                    if(N >= 500){
                        cnt500 = N / 500;
                        N = N % 500;
                    }
                    if(N >= 100){
                        cnt100 = N / 100;
                        N = N % 100;
                    }
                    if(N >= 50){
                        cnt50 = N / 50;
                        N = N % 50;
                    }
                    if(N >= 10){
                        cnt10 = N / 10;
                        N = N % 10;
                    }
                }
                System.out.println("#" + " " + i);
                System.out.println(cnt50000 + " " +cnt10000 + " " +cnt5000 + " " +
                        cnt1000 + " " + cnt500 + " " +cnt100 + " " +
                        cnt50 + " "+ cnt10);*/


            //SW Academy 1946 : 압축풀기

           /* Scanner sc = new Scanner(System.in);
            int T = sc.nextInt();

            for(int tc = 1; tc <= T; tc++) {

                int N = sc.nextInt();
                System.out.println("#" + tc);

                for(int i = 1; i <= N; i++){

                    String inputStr = sc.next();
                    int inputNum = sc.nextInt();
                    System.out.println();

                    for(int j = 0; j < inputNum; j++){

                        System.out.print(inputStr);
                    }

                }
            }*/

            //SW Academy 1284 : 합리적인 수도 금액 구하기

            /*Scanner sc = new Scanner(System.in);
            int T = sc.nextInt();

            for(int tc = 1; tc <= T; tc++) {

                int P = sc.nextInt();
                int Q = sc.nextInt();
                int R = sc.nextInt();
                int S = sc.nextInt();
                int W = sc.nextInt();

                //A회사 B회사에 지불할 수도금액
                int costA = 0;
                int costB = 0;
                //가장 합리적인 수도금액
                int bestcost = 0;

                //B사 수도 금액 계산
                if(W > R){
                    costB = Q + (W-R)*S;
                }
                else{
                    costB = Q;
                }

                //가장 합리적인 가격 도출
                if(costB >= W * P){
                    costA = W * P;
                    bestcost =  costA;
                }
                else if(costB < W * P){
                    bestcost = costB;
                }
                System.out.println("#"+ tc + " " + bestcost);

            }*/

            //SW Academy 1204: 최빈수 구하기

            /*Scanner sc = new Scanner(System.in);
            int T = sc.nextInt();

            for(int tc = 1; tc <= T; tc++) {

                //입력받은 점수 배열
                int[] dataarr = new int[1000];
                //카운팅 배열
                int[] countarr = new int[101];

                for(int i = 0; i < dataarr.length; i++) {

                    int input = sc.nextInt();
                    dataarr[i] = input;
                }
                //카운팅 배열 만드는 과정 1. array의 값을 index로 하는 counting 배열 값 1증가
                for(int i = 0; i < dataarr.length; i++){
                    countarr[dataarr[i]]++;
                }

                int Max = 0;
                int avg = 0;

                for(int i = 0; i < countarr.length; i++){
                    if(Max <= countarr[i]){
                        Max = countarr[i];
                        avg = i;
                    }
                }
                System.out.println("#" + tc + " " + avg);


            }*/









    }
}
