//SW Academy 1215 : 회문1

package SW_JAVA.AcademySolveD3;

import java.util.Scanner;

public class Palindrome1 {
    //문자 테이블 생성
    public static char[][] puzzle = new char[8][8];

    //주어진 문자열이 회문이면 1씩 더함
    public static int result = 0;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        for(int tc = 1; tc <= 10; tc++) {
            //회문 길이 입력
            int palindrome = sc.nextInt();
            //새로운 퍼즐 테이블마다 결과값 초기화
            result = 0;


            //회문 길이를 1로 입력받았을 경우
            if(palindrome == 1){
                System.out.print("#" + tc + " " + 64);
            }

            //문자 테이블에 알파벳 채워넣기
            for(int i = 0; i < puzzle.length; i++){
                String input = sc.next();
                for(int j = 0; j < puzzle.length; j++){
                    puzzle[i][j] = input.charAt(j);
                }
            }

            for(int i = 0; i < 8; i++){
                for(int j = 0; j <= 8-palindrome; j++){
                    findP(i,j,palindrome,"col");
                    findP(i,j,palindrome,"row");
                }
            }


            System.out.println("#" + tc + " " + result);
        }
    }

    public static void findP(int row,int col,int p,String type){
        //문자열 생성칸
        String tmp = "";
        int count = 0;

        //가로탐색: 좌표를 이동시킬때마다 tmp(문자열생성칸)에 문자를 입력후 count 1증가
        if(type.equals("col")){
            while(count < p){
                tmp += puzzle[row][col+count];
                count++;
            }

        }

        //세로탐색: 이하 똑같이 실행
        else if(type.equals("row")){
            while(count < p){
                tmp += puzzle[col+count][row];
                count++;
            }

        }

        //문자열 뒤집어서 회문 검사(reverse() 함수를 사용하기위해 Stringbuffer 사용)
        StringBuffer mirrorStr = new StringBuffer(tmp);
        String reverse = mirrorStr.reverse().toString();

        if(tmp.equals(reverse)){
            result++;
        }

    }
}
