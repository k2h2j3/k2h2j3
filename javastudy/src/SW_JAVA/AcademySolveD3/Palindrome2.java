//SW Academy 1216 회문2

package SW_JAVA.AcademySolveD3;

import java.util.Scanner;

public class Palindrome2 {
    //문자 테이블 생성
    public static char[][] puzzle = new char[100][100];

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        for(int tc = 1; tc <= 10; tc++) {
            int N = sc.nextInt();
            //최종값
            int result = 0;

            //문자 테이블에 알파벳 채워넣기
            for(int i = 0; i < puzzle.length; i++){
                String input = sc.next();
                for(int j = 0; j < puzzle.length; j++){
                    puzzle[i][j] = input.charAt(j);
                }
            }

            for(int length = 100; length > 0; length--){
                if(findlength(length)){
                    System.out.println("#" + tc + " " + length);
                    break;
                }
            }
        }
        sc.close();
    }
    //탐색
    public static boolean findlength(int length){

        for(int row = 0; row < 100; row++){
            for(int col = 0; col <= 100 - length; col++){
                if(findX(row,col,length) || findY(col,row,length)){
                    return true;
                }
            }

        }
        return false;
    }
    //가로 탐색
    public static boolean findX(int row,int col,int length){
        for(int i = 0; i < length / 2; i++){
            if(puzzle[row][col + i] != puzzle[row][col + length -1 -i]){
                return false;
            }
        }
        return true;

    }
    //세로탐색
    public static boolean findY(int row,int col,int length){
        for(int i = 0; i < length / 2; i++){
            if(puzzle[row + i][col] != puzzle[row + length - 1 - i][col]){
                return false;
            }
        }
        return true;

    }

}
