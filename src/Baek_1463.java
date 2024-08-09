import java.io.*;
import java.util.*;

public class Baek_1463 {
    public static int[] dp = new int[1000001];
    public static final int IMPOSSIBLE = 9999999;
    public void solution() throws IOException{
        dp[1] = 0;
        dp[2] = 1;
        dp[3] = 1;
        int n = Integer.parseInt( new BufferedReader(new InputStreamReader (System.in)).readLine());
        for(int i = 4; i <= n ; i++){
            int back_div_3;
            int back_div_2;
            int back_minus_1;

            back_div_2 = i % 2 == 0 ? dp[i/2] : IMPOSSIBLE;
            back_div_3 = i % 3 == 0 ? dp[i/3] : IMPOSSIBLE;
            back_minus_1  = dp[i-1];

            dp[i] = tripleMin(back_div_2+1, back_div_3+1, back_minus_1 +1);

        }
        System.out.println(dp[n]);
    }

    public static int tripleMin(int a, int b, int c){
        int temp = Math.min(a,b);
        return Math.min(temp, c);
    }
}
