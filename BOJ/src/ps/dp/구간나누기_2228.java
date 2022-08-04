package ps.dp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

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

public class 구간나누기_2228 {
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st=new StringTokenizer(br.readLine());
	    int n=Integer.parseInt(st.nextToken());
	    int m=Integer.parseInt(st.nextToken());
	    
	    int[] arr=new int[n+1];
	    int[] sum = new int[n+1];

	    //dp: n을 구간 m으로 나눴을때 최대합 저장 배열
	    int[][] dp=new int[n+1][m+1];
	    
	    //내가 구간 m에 포함되거나 안되거나로 경우를 나눈다
	    
	    //내가 구간 m에 포함 안될 경우 : dp[n][m] = dp[n-1][m]
	    //내가 구간 m에 포함 될 경우  : dp[n][m] = dp[k][m-1] +(arr[k+2]+...+arr[n])
        

	    for(int i=1;i<=n;i++) {
	    	int tmp=Integer.parseInt(br.readLine());
	    	arr[i]=tmp;
	    	sum[i]=sum[i-1]+arr[i]; //arr[k+2]+..+arr[n]을 구하기 위해 구간합 배열 따로 저장
	    }
        
        //arr[k+2]+..+arr[n] => sum[n]-sum[k+1]
        
	    //dp배열에 최소값 으로 초기화
		for (int i = 0; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				dp[i][j] =  -32768*100;

			}
		}
		
        //dp 배열 첫번째 값
		dp[1][1] = arr[1];
        //dp 두번째 값부터 
	    for(int i=2;i<=n;i++) {
	    	for(int j=1;j<=m;j++) {
                //m이 n보다 클수는 없으므로 해당 경우는 continue
                if(j>i)
                    continue;
                
                //(1) 내가 구간에 포함되지 않을경우
	    		dp[i][j]=dp[i-1][j];
                
                //(2) 내가 구간에 포함될 경우
                //이전 그룹의 마지막 인덱스는 현재 i 인덱스와 인접하면 안되기 때문에 최대 i-2 인덱스부터 시작
	    		for (int k = i - 2; k >=0; k--) {
                    // (1)과 비교해서 최대값 삽입
					dp[i][j] = Math.max(dp[i][j], dp[k][j - 1] + sum[i] - sum[k + 1]);
				}
  
                if(j==1) //m==1일때 arr값들이 양수라면, 다 더한 값이 최대값이기 때문에 한번더 비교
                     dp[i][j] = Math.max(dp[i][j], sum[i]);
	    		
	    		
	    	}
	    }
	    
	    System.out.println(dp[n][m]);

	    
	}
}