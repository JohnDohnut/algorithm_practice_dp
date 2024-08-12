import java.io.*;
import java.util.*;

public class Baek_2156 {
    public int[] dp;
    public int[] grid;
    public void solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        dp = new int[n+1];
        grid = new int[n+1];
        Arrays.fill(dp, 0);
        for(int i=1; i<n+1; i++){
            grid[i] = Integer.parseInt(br.readLine());
        }
        dp[1] = grid[1];
        if (n>=2) dp[2] = grid[1] + grid[2];
        if(n >= 3) dp[3] = triple_max(grid[1]+grid[2], grid[2]+grid[3], grid[1]+grid[3]);


        for(int i=4; i < n+1; i++){
            dp[i] = triple_max(grid[i]+grid[i-1]+dp[i-3], dp[i-2]+grid[i], dp[i-1]);
        }
        int max = 0;
        for(int el : dp){
            if(el > max) max = el;
        }
        System.out.println(max);

    }

    public int triple_max(int a, int b, int c){
        return Math.max(Math.max(a,b),c);
    }
}
