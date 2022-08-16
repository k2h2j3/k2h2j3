package baekjoon;
import java.util.*;
public class baekjoon3273 {
    //투포인터 방법
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i < n; i++){
            int a = sc.nextInt();
            arr[i] = a;
        }
        Arrays.sort(arr);
        int x = sc.nextInt();
        int start = 0;
        int end = n-1;
        int cnt = 0;

        while(start < end){
            int sum = arr[start] + arr[end];
            if(sum == x){
                start++;
                end--;
                cnt++;
            }
            else if(sum > x){
                end--;
            }
            else{
                start++;
            }
        }
        System.out.print(cnt);


    }
}
