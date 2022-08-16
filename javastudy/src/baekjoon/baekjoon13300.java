package baekjoon;
import java.util.*;
public class baekjoon13300 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //수학여행가는 학생수
        int n = sc.nextInt();
        //방크기
        int roomsize = sc.nextInt();
        int[] woman = new int[6];
        int[] man = new int[6];
        boolean[] checkw = new boolean[6];
        boolean[] checkm = new boolean[6];
        for(int i = 0;  i<n;i++) {
            // 성별
            int sex = sc.nextInt();
            // 학년
            int level = sc.nextInt();
            //여학생
            if (sex == 0) {
                if (level == 1) {
                    woman[0] += 1;
                } else if (level == 2) {
                    woman[1] += 1;
                } else if (level == 3) {
                    woman[2] += 1;
                } else if (level == 4) {
                    woman[3] += 1;
                } else if (level == 5) {
                    woman[4] += 1;
                } else if (level == 6) {
                    woman[5] += 1;
                }
            }
            //남학생
            else {
                if (level == 1) {
                    man[0] += 1;
                } else if (level == 2) {
                    man[1] += 1;
                } else if (level == 3) {
                    man[2] += 1;
                } else if (level == 4) {
                    man[3] += 1;
                } else if (level == 5) {
                    man[4] += 1;
                } else if (level == 6) {
                    man[5] += 1;
                }
            }
        }
        int cnt = 0;
        for(int i = 0; i < 6; i++){
            if(woman[i] != 0 && woman[i] <= roomsize){
                cnt++;
            } else if(woman[i] > roomsize){
                if(woman[i] % roomsize == 0){
                    cnt = cnt + (woman[i]/roomsize);
                }
                else{
                    cnt = cnt + (woman[i]/roomsize +1);
                }
            }
            if(man[i] != 0 && man[i] <= roomsize){
                cnt++;
            } else if(man[i] > roomsize){
                if(man[i] % roomsize == 0){
                    cnt = cnt + (man[i]/roomsize);
                }
                else{
                    cnt = cnt + (man[i]/roomsize +1);
                }
            }
        }
        System.out.print(cnt);
    }
}
