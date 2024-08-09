import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;

public class Baek_2839 {
    public int[] dp;
    public static final int IMPOSSIBLE = 5000;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        dp = new int[5001];
        for(int i=0; i<3; i++){
            dp[i] = -1;
        }
        dp[3] = 1;
        dp[4] = -1;
        dp[5] = 1;

        for(int i=6 ; i <= n ; i++){

            int dp_minus_5kg = dp[i-5] != -1 ? dp[i-5] : IMPOSSIBLE;
            int dp_minus_3kg = dp[i-3] != -1 ? dp[i-3] : IMPOSSIBLE;
            int dp_i = Math.min(dp_minus_3kg + 1, dp_minus_5kg + 1);
            dp[i] = dp_i < 5000 ? dp_i : -1;

        }

        System.out.println(dp[n]);
    }
}
