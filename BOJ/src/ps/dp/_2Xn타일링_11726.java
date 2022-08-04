package ps.dp;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
/**
 * 2*n 타일링
 * https://www.acmicpc.net/problem/11726
 * **/
public class _2Xn타일링_11726 {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    
	    int n=Integer.parseInt(br.readLine());
	    
	    //2*n 타일을 채우는 방법의 수
	    int[] dp=new int[n+1];
	    
	    //마지막 직사각형이 세로 1개: dp[n-1]
	    //마지막 직사각형이 가로 2개: dp[n-2]
	    
	    dp[1]=1;
	    dp[2]=2;
	    
	    for(int i=3;i<=n;i++) {
	    	dp[i]=dp[i-1]+dp[i-2];
	    }
	    System.out.println(dp[n]);
	    
	    
	}
}
