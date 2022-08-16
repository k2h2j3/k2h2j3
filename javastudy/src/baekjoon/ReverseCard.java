package baekjoon;
import java.util.*;
public class ReverseCard {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] card = new int[20];
        for(int i = 1; i <= 20; i++){
            card[i-1] = i;
        }
        for(int i = 0; i < 10; i++){
            int input1 = sc.nextInt();
            int input2 = sc.nextInt();

            int a = input1 - 1;
            int b = input2 - 1;
            int reverse = (b - a + 1)/2;
            if(reverse < 0){
                reverse = 0;
            }
            int cnt = 0;

            for(int j = 0; j < reverse; j++){
                int temp = card[a+cnt];
                card[a+cnt] = card[b-cnt];
                card[b-cnt] = temp;
                cnt++;
            }

        }
        for(int i = 0; i < card.length; i++){
            System.out.print(card[i] + " ");
        }
    }
}