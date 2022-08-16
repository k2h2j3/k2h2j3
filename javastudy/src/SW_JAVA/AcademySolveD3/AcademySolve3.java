package SW_JAVA.AcademySolveD3;

import java.util.Arrays;
import java.util.Scanner;

public class AcademySolve3 {

    public static void main(String[] args) {

        //D3 난이도

        //SW Academy 1206 : 조망권 확보된 세대찾기

            /*Scanner sc = new Scanner(System.in);
            int T = sc.nextInt();

            for(int tc = 1; tc <= T; tc++) {

                //배열 => 배열의 인덱스값 = 가로길이, 배열의 인덱스 안의 값 = 건물의 높이
                ArrayList<Integer> building = new ArrayList<Integer>();
                int[] gaparr = new int[4];

                int N = sc.nextInt(); //가로 길이
                int result = 0; //한 건물당 조망이 확보된 세대 수
                int sum = 0;


                //건물높이 입력 받기
                for(int i = 0; i < N; i++) {
                    int input = sc.nextInt();
                    building.add(input);
                }

                //처음과 끝을 2개씩 공백을 만들고 비교.
                for(int i = 2; i < building.size() -2; i++){

                    int gap1 = building.get(i) - building.get(i-2);
                    gaparr[0] = gap1;
                    int gap2 = building.get(i) - building.get(i-1);
                    gaparr[1] = gap2;
                    int gap3 = building.get(i) - building.get(i+1);
                    gaparr[2] = gap3;
                    int gap4 = building.get(i) - building.get(i+2);
                    gaparr[3] = gap4;

                    Arrays.sort(gaparr);
                    if(gaparr[0] <= 0){
                        result = 0;
                    }
                    else{
                        result = gaparr[0];
                    }
                    sum = sum + result;
                }
                System.out.println("#" + tc + " " + sum);



            }*/

        //SW Academy 1208 Flatten(평탄화)

        /*Scanner sc = new Scanner(System.in);
        //int T = sc.nextInt();

        for(int tc = 1; tc <= 10; tc++) {

            //입력 값: 덤프 수, 각 상자의 높이
            int dump = sc.nextInt();
            int[] boxarr = new int[100];
            //가장 높은 위치와 가장 낮은 위치의 차이 값
            int result;

            for(int i = 0; i < boxarr.length; i++){

                int boxH = sc.nextInt();
                boxarr[i] = boxH;
            }
            //오름차순으로 정렬
            Arrays.sort(boxarr);

            for(int i = 0; i < dump; i++){
                boxarr[0] = boxarr[0] + 1; //가장 낮은 높이의 상자에 상자 1개를 쌓고
                boxarr[99] = boxarr[99] -1; //가장 높은 높이의 상자에 상자 1개를 뺀다.
                Arrays.sort(boxarr);
            }
            result = boxarr[99] - boxarr[0];
            System.out.println("#" + tc + " " + result);

        }*/

        //SW Academy 1209 : 2차원 배열 sum

        /*Scanner sc = new Scanner(System.in);
        //int T = sc.nextInt();

        for(int tc = 1; tc <= 10; tc++) {

            int[][] arr = new int[100][100];
            int[] row = new int[100];
            int[] column = new int[100];
            int[] comp = new int[4];

            int sumL = 0;
            int sumR = 0;
            int N = sc.nextInt();


            //입력 받은 값 2차원 배열에 넣기
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[i].length; j++) {
                    int input = sc.nextInt();
                    arr[i][j] = input;
                }
            }

            //행 계산 값 넣기
            for (int i = 0; i < 100; i++) {
                int sum = 0;
                for (int j = 0; j < 100; j++) {
                    sum = sum + arr[i][j];
                }
                row[i] = sum;
            }
            Arrays.sort(row);
            //행중 가장 큰 값 comp배열에 추가
            comp[0] = row[99];

            //열 계산값 넣기
            for (int i = 0; i < 100; i++) {
                int sum = 0;
                for (int j = 0; j < 100; j++) {
                    sum = sum + arr[j][i];
                }
                column[i] = sum;
            }
            Arrays.sort(column);
            //열중 가장 큰 값 comp배열에 추가
            comp[1] = column[99];

            //왼쪽 대각선 합 계산
            for (int i = 0; i < 100; i++) {
                sumL = sumL + arr[i][i];
            }
            comp[2] = sumL;

            //오른쪽 대각선 합계산
            for (int i = 0; i < 100; i++) {
                sumR = sumR + arr[i][99 - i];
            }
            comp[3] = sumR;

            //comp배열에서 오름차순으로 정렬
            Arrays.sort(comp);

            //가장 큰 값 출력
            System.out.println("#" + tc + " " + comp[3]);
        }*/












    }

}
