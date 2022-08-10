package ws;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 구간나누기
 * https://www.acmicpc.net/problem/2228
 * @author howoon
 *
 */

//각 구간은 한 개이상의 연속된 수
//서로다른 두 구간이 겹쳐있거나 인접 불가
//m개의 구간 
//=====>최대합 구하기

public class 구간나누기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
	    
	    StringTokenizer st=new StringTokenizer(br.readLine());
	    int n=Integer.parseInt(st.nextToken());
	    int m=Integer.parseInt(st.nextToken());
	    
	    int[] arr=new int[n+1];
	    int[] sum = new int[n+1];

	    //n을 구간 m으로 나눴을때 최대합 저장 배열
	    int[][] dp=new int[n+1][m+1];
	    
	    //내가 구간 m에 포함되거나 안되거나
	    
	    //내가 구간 m에 포함 안될 경우 : dp[n][m] = dp[n-1][m]
	    //내가 구간 m에 포함 될 경우  : dp[n][m] = dp[k][m-1] +(arr[k+2]+...+arr[n])

	    for(int i=1;i<=n;i++) {
	    	int tmp=Integer.parseInt(br.readLine());
	    	arr[i]=tmp;
	    	sum[i]=sum[i-1]+arr[i];
	    }
	    
		for (int i = 0; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				dp[i][j]= Integer.MIN_VALUE / 2;
				//dp[i][j] =  -32768*100;
//				if(m==1)
//					dp[i][j]=sum[i];
			}
		}
		
		dp[1][1] = arr[1];
	    
	    for(int i=2;i<=n;i++) {
	    	for(int j=1;j<=m;j++) {
	    		
	    		dp[i][j]=dp[i-1][j];
	    		
	    		int min = 0;
				if (j == 1)
					min = -1;
	    		
	    		for (int k = i - 2; k >=min; k--) {
	    			if(k<0)
	    				dp[i][j] = Math.max(dp[i][j], sum[i]);
	    				
	    			else
					dp[i][j] = Math.max(dp[i][j], dp[k][j - 1] + sum[i] - sum[k + 1]);
				}
	    		
	    		
	    	}
	    }
	    
	    System.out.println(dp[n][m]);
	    

	    
	    
	}
}