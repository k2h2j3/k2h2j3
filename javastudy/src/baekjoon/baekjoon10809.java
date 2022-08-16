package baekjoon;

import java.io.*;
import java.util.*;

public class baekjoon10809 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        char[] alphaarr = new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l',
                'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        int[] result = new int[26];
        boolean[] check = new boolean[26];
        String N = sc.next();
        char[] chararr = new char[N.length()];

        for(int i = 0; i < N.length(); i++){
            char c = N.charAt(i);
            chararr[i] = c;
        }
        for(int i = 0; i < chararr.length; i++){
            for(int j = 0; j < alphaarr.length; j++){
                if(chararr[i] == alphaarr[j] && check[j] == false){
                    result[j] = i;
                    check[j] = true;
                }

            }

        }
        for(int i = 0; i < alphaarr.length; i++){
            if(check[i] != true){
                result[i] = -1;
            }
        }
        for(int i = 0; i < alphaarr.length; i++){
            System.out.print(result[i]+" ");
        }


    }
}
