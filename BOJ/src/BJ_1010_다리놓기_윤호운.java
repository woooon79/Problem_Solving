package ws;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_1010_다리놓기_윤호운 {
	static long ans=0;

	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		int TC= Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int t=1;t<=TC;t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int[][] dp = new int[31][31];
			int n=a;
			int r=b;
			if(a<b) {  //큰값을 n으로
				n=b;
				r=a;
			}
			
			for(int i=1;i<=30;i++) { //n개중에n개 고르고나 , 0개 고를떈 경우의수 1
				for(int j=1;j<=30;j++) {
					if(i==j) 
						dp[i][j]=1;
					dp[i][0]=1;
				}
			}
			
			for(int i=2;i<=n;i++) { //메모이제이션~
				for(int j=1;j<=i;j++) {		
					dp[i][j]=dp[i-1][j-1]+dp[i-1][j];
				}
			}
			
			ans=dp[n][r];
			
			
			sb.append(ans+"\n");
			ans=0;
		}
		System.out.println(sb);
	  
	}
}
