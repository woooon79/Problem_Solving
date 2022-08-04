package ps.dp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 1,2,3 더하기
 * https://www.acmicpc.net/problem/9095
 * @author Howoon
 *
 */
public class _123더하기_9095 {

	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
	    int tc=Integer.parseInt(br.readLine());
	    StringBuffer sb = new StringBuffer();
	    
	    for(int t=0;t<tc;t++) {
	    	int n=Integer.parseInt(br.readLine());
	    	//n을 1,2,3의 합으로 나타내는 방법을 담은 배열
	    	int[] dp= new int[n+1];
	    	
	    	dp[1]=1; // 1
	    	dp[2]=2; // 1+1 , 2
	    	dp[3]=4; // 1+1+1 , 2+1, 1+2, 3
	    	
	    	//마지막 n을 구할때는 이전 값을 활용 (연속한 수 -> 문제가 작아짐 -> 마지막 한 단계와 나머지 단계 => dp)
	    	for(int i=4;i<=n;i++) {
	    		dp[i]= dp[i-1]+dp[i-2]+dp[i-3];
	    	}
	    	
	    	sb.append(dp[n]+"\n");
	    	
	    }
	    System.out.println(sb);
	    
	}

}
