package ws;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D2_1954_달팽이숫자_윤호운 {
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
	    StringBuffer sb = new StringBuffer();
	    
	    for(int t=1;t<=TC;t++) {
	    	StringTokenizer st = new StringTokenizer(br.readLine());
	    	int n = Integer.parseInt(st.nextToken());
	    	int m = Integer.parseInt(st.nextToken());
	    	
	    	//행마다 0~n 까지의 합을 넣을 배열 sum
		    int[][] sum = new int[n+1][n+1];
	    	
	    	int[][] arr = new int[n+1][n+1];
	    	for(int i=1;i<=n;i++) {
	    		st=new StringTokenizer(br.readLine());
	    		for(int j=1;j<=n;j++) {
	    			arr[i][j]=Integer.parseInt(st.nextToken());
	    			sum[i][j]=sum[i][j-1]+arr[i][j];
	    		}
	    	}
	    	
	    	
	    	for(int i=1;i<n-m+1;i++) {
	    		for(int j=1;j<n-m-1;j++) {
	    			
	    		}
	    	}
	    	
	    	
	    	
	    }
	    System.out.println(sb);
	}

}
