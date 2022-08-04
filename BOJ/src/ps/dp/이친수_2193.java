package ps.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 이친수
 * https://www.acmicpc.net/problem/2193
 * @author Howoon
 *
 */
public class 이친수_2193 {

	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
	    int n=Integer.parseInt(br.readLine());
	    
	    int[][] dp = new int[n+1][n+1];
	    //이전 수가 1인 경우는 0
	    //이전 수가 0인 경우는 1 또는 0
	    
	    //dp[개수][마지막수]
	    dp[1][1]=1;
	    dp[1][0]=0;
	    
	    
	    for(int i=2;i<=n;i++) {
	    	dp[i][0]=dp[i-1][1]+dp[i-1][0];
	    	dp[i][1]=dp[i-1][0];
	    			
	    }
	    
	    System.out.println(dp[n][0]+dp[n][1]);
	    
	}

}
